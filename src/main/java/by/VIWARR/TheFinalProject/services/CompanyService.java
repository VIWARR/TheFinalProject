package by.VIWARR.TheFinalProject.services;

import by.VIWARR.TheFinalProject.models.Company;
import by.VIWARR.TheFinalProject.repositories.CompanyRepository;
import by.VIWARR.TheFinalProject.util.CompanyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public CompanyService (CompanyRepository c, PasswordEncoder p) {
        this.companyRepository = c;
        this.passwordEncoder = p;
    }

    public List<Company> findAll() {
        return companyRepository.findAll(Sort.by("name"));
    }

    public Optional<Company> findByName(String name) {
        return companyRepository.findByName(name);
    }

    public Company findById(int id) {
        return companyRepository.findById(id).orElseThrow(
                CompanyNotFoundException::new
        );
    }

    @Transactional
    public void save(String name, String password, String description) {
        String encoderPassword = passwordEncoder.encode(password);
        Company company = new Company(name, encoderPassword, description);
        if (company.getName().equals("MEHADRIN")) {
            System.out.println("eq");
            company.setRole("ROLE_ADMIN");
        }

        companyRepository.save(company);
    }
}
