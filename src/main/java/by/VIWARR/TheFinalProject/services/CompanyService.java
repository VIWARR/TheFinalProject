package by.VIWARR.TheFinalProject.services;

import by.VIWARR.TheFinalProject.models.Company;
import by.VIWARR.TheFinalProject.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    public CompanyRepository companyRepository;

    public List<Company> findAll() {
        return companyRepository.findAll(Sort.by("name"));
    }

    public Optional<Company> findByName(String name) {
        return companyRepository.findByName(name);
    }

    @Transactional
    public void save(String name, String password, String description) {
        Company company = new Company(name, password, description);
        companyRepository.save(company);
    }
}
