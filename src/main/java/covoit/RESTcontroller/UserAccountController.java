package covoit.RESTcontroller;

import org.springframework.beans.factory.annotation.Autowired;
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
import covoit.services.UserAccountService;

@RestController
@RequestMapping("/user")
public class UserAccountController {
    @Autowired
    private UserAccountService userAccountService;
    
    @PostMapping("/register")
    public void registerUser(@RequestBody UserAccountDto userDto) {
        //userAccountService.registerUser(userDTO);
    }
    @PutMapping("/update")
    public void updateUser(@PathVariable int id, @RequestBody UserAccountDto userDto) {
        userAccountService.update(id, userDto);
    }
    @GetMapping("/{id}")
    public UserAccountDto findById(@PathVariable int id) {
        return userAccountService.findById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userAccountService.delete(id);
    }


    @PostMapping("/login")
    public void login(@RequestParam String email, @RequestParam String password) {
    }

    @DeleteMapping("/{userId}/cancel-carpool")
    public void cancelCarpool(@PathVariable int userId, @RequestParam int carpoolId) {
      //S  userAccountService.deleteBookingCarpool(carpoolId, userId);
    }
}