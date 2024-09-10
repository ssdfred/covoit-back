package covoit.RESTcontroller;

import covoit.RESTcontroller.AuthController;
import covoit.dtos.LoginRequestDto;
import covoit.entities.UserAccount;
import covoit.exception.AnomalieException;
import covoit.services.JwtService;
import covoit.services.UserAccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AuthControllerTest {
//
//    @Mock
//    private UserAccountService userAccountService;
//
//    @Mock
//    private JwtService jwtService;
//
//    @Mock
//    private HttpServletRequest request;
//
//    @Mock
//    private HttpServletResponse response;
//
//    @Mock
//    private HttpSession session;
//
//    @InjectMocks
//    private AuthController authController;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    public void testLogin_Success() throws Exception {
//    }

//    @Test
//    public void testLogin_Failure_Unauthorized() throws Exception {
//        // Arrange
//        LoginRequestDto loginRequest = new LoginRequestDto("username", "password");
//        when(userAccountService.login(anyString(), anyString())).thenThrow(new AnomalieException("Login failed"));
//
//        // Act
//        ResponseEntity<?> responseEntity = authController.login(loginRequest, response);
//
//        // Assert
//        assertEquals(HttpStatus.UNAUTHORIZED, responseEntity.getStatusCode());
//        assertEquals("Login failed", responseEntity.getBody());
//    }

//    @Test
//    public void testLogout_Success() {
//        // Arrange
//        when(request.getSession(false)).thenReturn(session);
//
//        // Act
//        ResponseEntity<String> responseEntity = authController.logout(request, response);
//
//        // Assert
//        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//        assertEquals("Déconnecté avec succès", responseEntity.getBody());
//        verify(session, times(1)).invalidate();
//        verify(response, times(1)).addCookie(any(Cookie.class));  // Vérifie que le cookie est supprimé
//    }
//
//    @Test
//    public void testLogout_NoSession() {
//        // Arrange
//        when(request.getSession(false)).thenReturn(null);
//
//        // Act
//        ResponseEntity<String> responseEntity = authController.logout(request, response);
//
//        // Assert
//        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//        assertEquals("Déconnecté avec succès", responseEntity.getBody());
//        verify(response, times(1)).addCookie(any(Cookie.class));  // Vérifie que le cookie est supprimé
//    }
}
