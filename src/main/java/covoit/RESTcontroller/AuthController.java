package covoit.RESTcontroller;

import covoit.dtos.LoginRequestDto;
import covoit.entities.UserAccount;
import covoit.exception.AnomalieException;
import covoit.services.JwtService;
import covoit.services.UserAccountService;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserAccountService userAccountService;
    private JwtService jwtService;
    public AuthController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto loginRequest, HttpServletRequest request) {
        try {
            UserAccount user = userAccountService.login(loginRequest.getUsername(), loginRequest.getPassword());
            HttpSession session = request.getSession();
            session.setAttribute("user", user); // Stocker l'utilisateur dans la session
            return ResponseEntity.ok().body(user); // Assurez-vous de renvoyer une réponse appropriée
        } catch (AnomalieException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        } catch (Exception e) {
            // Attraper d'autres exceptions et renvoyer une réponse appropriée
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
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
