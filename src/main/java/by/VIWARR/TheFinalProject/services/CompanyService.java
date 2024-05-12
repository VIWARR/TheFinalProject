package by.VIWARR.TheFinalProject.services;

import by.VIWARR.TheFinalProject.models.Company;
import by.VIWARR.TheFinalProject.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

    @Transactional
    public void save(String name, String password, String description) {
        System.out.println(password);
        String encoderPassword = passwordEncoder.encode(password);
        System.out.println(encoderPassword);
        Company company = new Company(name, encoderPassword, description);
        companyRepository.save(company);
    }
}
