package com.example.jsonplaceholder.converters.sup;

import com.example.jsonplaceholder.model.dto.request.sup.CompanyRequest;
import com.example.jsonplaceholder.model.dto.response.sup.CompanyResponse;
import com.example.jsonplaceholder.model.sup.Company;

import java.util.List;
import java.util.stream.Collectors;

public class CompanyConverter {

    public static Company convertToCompany(CompanyRequest companyRequest) {
        return Company.builder()
                .id(companyRequest.getId())
                .name(companyRequest.getName())
                .catchPhrase(companyRequest.getCatchPhrase())
                .bs(companyRequest.getBs())
                .build();
    }

    public static CompanyResponse convertToCompanyResponse(Company company) {
        return CompanyResponse.builder()
                .id(company.getId())
                .name(company.getName())
                .catchPhrase(company.getCatchPhrase())
                .bs(company.getBs())
                .build();
    }

    public static List<CompanyResponse> generateCompanyResponseList(List<Company> companyList) {
        return companyList.stream()
                .map(CompanyConverter::convertToCompanyResponse)
                .collect(Collectors.toList());
    }
}
