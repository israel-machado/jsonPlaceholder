package com.example.jsonplaceholder.converters.sup;

import com.example.jsonplaceholder.model.dto.request.CompanyRequest;
import com.example.jsonplaceholder.model.dto.response.sup.CompanyResponse;
import com.example.jsonplaceholder.model.sup.Company;

import java.util.List;
import java.util.stream.Collectors;

public class CompanyConverter {

    public static Company convertToCompany(CompanyRequest CompanyRequest) {

  
                
    }

    public static CompanyResponse convertToCompanyResponse(Company Company) {
        

    }

    public static List<CompanyResponse> generateCompanyResponseList(List<Company> CompanyList) {
        List<CompanyResponse> CompanyResponseList = CompanyList.stream()
                .map(CompanyConverter::convertToCompanyResponse)
                .collect(Collectors.toList());
        return CompanyResponseList;
    }
}
