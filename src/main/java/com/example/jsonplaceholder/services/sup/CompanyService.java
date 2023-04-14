package com.example.jsonplaceholder.services.sup;

import com.example.jsonplaceholder.converters.CompanyConverter;
import com.example.jsonplaceholder.model.Company;
import com.example.jsonplaceholder.model.dto.request.CompanyRequest;
import com.example.jsonplaceholder.model.dto.response.CompanyResponse;
import com.example.jsonplaceholder.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.jsonplaceholder.converters.CompanyConverter.*;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository repository;

    public List<CompanyResponse> findAll() {
        List<Company> CompanyList = repository.findAll();
        return generateCompanyResponseList(CompanyList);
    }

    public CompanyResponse findById(Long id) {
        Optional<Company> Company = repository.findById(id);
        return Company.map(CompanyConverter::convertToCompanyResponse).orElse(null);
    }

    public CompanyResponse insert(CompanyRequest CompanyRequest) {
        Company Company = convertToCompany(CompanyRequest);
        Company = repository.save(Company);
        return convertToCompanyResponse(Company);
    }

    public CompanyResponse update(Long id, CompanyRequest CompanyRequest) {
        Company Company = convertToCompany(CompanyRequest);
        Company.setId(id);
        Company updatedCompany = repository.save(Company);
        return convertToCompanyResponse(Company);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
