package com.example.jsonplaceholder.services.sup;

import com.example.jsonplaceholder.model.sup.Company;
import com.example.jsonplaceholder.repository.sup.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository repository;

    public List<Company> getAll() {
        return repository.findAll();
    }

    public Company getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Company save(Company company) {
        return repository.save(company);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
