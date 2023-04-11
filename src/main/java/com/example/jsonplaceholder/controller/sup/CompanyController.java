package com.example.jsonplaceholder.controller.sup;

import com.example.jsonplaceholder.model.sup.Company;
import com.example.jsonplaceholder.services.sup.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyService service;

    @GetMapping
    public List<Company> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Company getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Company create(@RequestBody Company company) {
        return service.save(company);
    }

    @PutMapping("/{id}")
    public Company update(@PathVariable Long id, @RequestBody Company company) {
        company.setId(id);
        return service.save(company);
    }

    @DeleteMapping
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
