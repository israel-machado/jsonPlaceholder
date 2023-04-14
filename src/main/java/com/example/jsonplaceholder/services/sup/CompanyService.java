package com.example.jsonplaceholder.services.sup;

import com.example.jsonplaceholder.converters.sup.CompanyConverter;
import com.example.jsonplaceholder.model.sup.Company;
import com.example.jsonplaceholder.model.dto.request.sup.CompanyRequest;
import com.example.jsonplaceholder.model.dto.response.sup.CompanyResponse;
import com.example.jsonplaceholder.repository.sup.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.jsonplaceholder.converters.sup.CompanyConverter.*;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository repository;

    public List<CompanyResponse> findAll() {
        List<Company> CompanyList = repository.findAll();
        return generateCompanyResponseList(CompanyList);
    }

    public CompanyResponse findById(Long id) {
        Optional<Company> company = repository.findById(id);
        return company.map(CompanyConverter::convertToCompanyResponse).orElse(null);
    }

    public CompanyResponse insert(CompanyRequest companyRequest) {
        Company company = convertToCompany(companyRequest);
        company = repository.save(company);
        return convertToCompanyResponse(company);
    }

    public CompanyResponse update(Long id, CompanyRequest companyRequest) {
        Company company = convertToCompany(companyRequest);
        company.setId(id);
        Company updatedCompany = repository.save(company);
        return convertToCompanyResponse(updatedCompany);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
