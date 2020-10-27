package ru.itis.resumeservice.security.details;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.itis.resumeservice.models.Applicant;

import java.util.Collection;
import java.util.Collections;

@Getter
@Setter
public class UserDetailsImpl implements UserDetails {

    private Applicant applicant;

    public UserDetailsImpl(Applicant applicant) {
        this.applicant = applicant;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("USER");
        return Collections.singleton(simpleGrantedAuthority);
    }

    @Override
    public String getPassword() {
        return applicant.getPassword();
    }

    @Override
    public String getUsername() {
        return applicant.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
