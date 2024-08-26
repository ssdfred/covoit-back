package covoit.RESTcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import covoit.dtos.UserAccountDto;
import covoit.entities.UserAccount;
import covoit.exception.AnomalieException;
import covoit.services.UserAccountService;

@RestController
@RequestMapping(value = "/user", produces = "application/json")
public class UserAccountController {

    @Autowired
    private UserAccountService userAccountService;
 
    @CrossOrigin("http://localhost:4200")
    @GetMapping("/")
    public List< UserAccountDto> findAll(){
    	return userAccountService.findAll();
    }
    @CrossOrigin("http://localhost:4200")
    @GetMapping("/{id}")
    public UserAccountDto findById(@PathVariable int id) {
        return userAccountService.findById(id);
    }
    @CrossOrigin("http://localhost:4200")
    @PostMapping("/register")
    public ResponseEntity<String> create(@RequestBody UserAccountDto userAccountDto) {
        // Convertir UserAccountDto en UserAccount	
        UserAccount userAccount = userAccountDto.toBean(userAccountDto);
        // Appeler la méthode create avec l'entité UserAccount
        userAccountService.create(userAccount);
        return ResponseEntity.ok("User created successfully");
    }
    @CrossOrigin("http://localhost:4200")
    @PostMapping("/update")
    public void update(@PathVariable int id, @RequestBody UserAccountDto userDto) {
        userAccountService.update(id, userDto);
    }
    
    @CrossOrigin("http://localhost:4200")
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        userAccountService.delete(id);
    }

    @CrossOrigin("http://localhost:4200")
    @DeleteMapping("/{userId}/cancel-carpool")
    public void cancelCarpool(@PathVariable int userId, @RequestParam int carpoolId) {
     //  userAccountService.deleteBookingCarpool(carpoolId, userId);
    }
}