package by.VIWARR.TheFinalProject.services;

import by.VIWARR.TheFinalProject.models.Company;
import by.VIWARR.TheFinalProject.repositories.CompanyRepository;
import by.VIWARR.TheFinalProject.security.CompanyDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyDetailsService implements UserDetailsService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<Company> company = companyRepository.findByName(name);

        return Optional.ofNullable(CompanyDetails(company)).orElseThrow(
                () -> new UsernameNotFoundException(name + " is not found")
        );

    }
}
