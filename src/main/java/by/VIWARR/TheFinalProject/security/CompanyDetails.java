package by.VIWARR.TheFinalProject.security;

import by.VIWARR.TheFinalProject.models.Company;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Optional;

public class CompanyDetails implements UserDetails {

    private final Company company;

    public CompanyDetails(Optional<Company> company) {
        this.company = company;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.company.getPassword();
    }

    @Override
    public String getUsername() {
        return this.company.getName();
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

    public Company getCompany() {
        return this.company;
    }
}
