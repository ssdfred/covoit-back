package covoit.RESTcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import covoit.dtos.UserAccountDto;
import covoit.entities.UserAccount;
import covoit.services.UserAccountService;
@RestController
@RequestMapping("/users")
public class UserAccountRestController {

    @Autowired
    private UserAccountService userAccountService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public List<UserAccountDto> getAllUsers() {
        return userAccountService.findAll().stream()
                .map(UserAccountDto::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/create")
    public ResponseEntity<UserAccountDto> createUser(@RequestBody UserAccountDto userAccountDto) {
        userAccountDto.setPassword(passwordEncoder.encode(userAccountDto.getPassword()));
        UserAccount userAccount = UserAccountDto.toBean(userAccountDto);
        UserAccount createdUser = userAccountService.save(userAccount);
        return ResponseEntity.ok(UserAccountDto.toDto(createdUser));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserAccountDto> updateUser(@PathVariable Long id, @RequestBody UserAccountDto userAccountDto) {
        UserAccount userAccount = UserAccountDto.toBean(userAccountDto);
        UserAccount updatedUser = userAccountService.update(id, userAccount);
        return ResponseEntity.ok(UserAccountDto.toDto(updatedUser));
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable Long id) {
        userAccountService.delete(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
