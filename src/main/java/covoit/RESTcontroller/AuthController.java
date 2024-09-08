package covoit.RESTcontroller;

import covoit.dtos.LoginRequestDto;
import covoit.entities.UserAccount;
import covoit.exception.AnomalieException;
import covoit.services.JwtService;
import covoit.services.UserAccountService;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserAccountService userAccountService;
    private final JwtService jwtService;

    // Injection via le constructeur
    public AuthController(UserAccountService userAccountService, JwtService jwtService) {
        this.userAccountService = userAccountService;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto loginRequest, HttpServletRequest request, HttpServletResponse response) {
        try {
            // Authentifie l'utilisateur
            UserAccount user = userAccountService.login(loginRequest.getUsername(), loginRequest.getPassword());

            // Création de la session utilisateur
            HttpSession session = request.getSession(true);
            session.setAttribute("user", user);

            // Optionnel : Générer un JWT si tu utilises des tokens pour l'authentification
            String jwtToken = jwtService.generate("username");

            // Ajouter le JWT dans un cookie
            Cookie cookie = new Cookie("authToken", jwtToken);
            cookie.setHttpOnly(true);  // Pour des raisons de sécurité, on marque le cookie comme HttpOnly
            cookie.setSecure(true);    // Assurez-vous que ce cookie est envoyé uniquement via HTTPS
            cookie.setPath("/");
            cookie.setMaxAge(24 * 60 * 60); // Expire après 24 heures
            response.addCookie(cookie);  // Ajoute le cookie à la réponse

            // Construction de la réponse incluant les données de l'utilisateur
            return ResponseEntity.ok().body(user);  // Renvoie les données de l'utilisateur

        } catch (AnomalieException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());  // 401 Unauthorized si login échoue
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur interne du serveur");  // 500 Internal Server Error
        }
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();  // Invalide la session
        }

        // Supprimer le cookie JWT
        Cookie cookie = new Cookie("authToken", null);
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        cookie.setPath("/");
        cookie.setMaxAge(0); // Expiration immédiate pour supprimer le cookie
        response.addCookie(cookie);

        return ResponseEntity.ok("Déconnecté avec succès");  // Réponse 200 OK avec un message de confirmation
    }
}
