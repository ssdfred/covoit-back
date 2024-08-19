package covoit.services;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import covoit.entities.UserAccount;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {

    private final UserAccount userAccount;

    public CustomUserDetails(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Convert user roles into GrantedAuthority
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")); // Adjust based on actual roles
    }

    @Override
    public String getPassword() {
        return userAccount.getPassword();
    }

    @Override
    public String getUsername() {
        return userAccount.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Implement logic based on your requirements
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Implement logic based on your requirements
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Implement logic based on your requirements
    }

    @Override
    public boolean isEnabled() {
        return true; // Implement logic based on your requirements
    }
}
