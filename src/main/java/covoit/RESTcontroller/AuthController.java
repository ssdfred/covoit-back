package covoit.RESTcontroller;

import covoit.dtos.LoginRequestDto;
import covoit.entities.UserAccount;
import covoit.exception.AnomalieException;
import covoit.services.UserAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserAccountService userAccountService;

    public AuthController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto loginRequest, HttpServletRequest request) {
        try {
            UserAccount user = userAccountService.login(loginRequest.getUsername(), loginRequest.getPassword());
            HttpSession session = request.getSession();
            session.setAttribute("user", user); // Stocker l'utilisateur dans la session
            return ResponseEntity.ok(user);
        } catch (AnomalieException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }


    @GetMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); // Invalider la session
        }
        return ResponseEntity.ok("Déconnecté");
    }

   
}
