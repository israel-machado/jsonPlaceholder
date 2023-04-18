package com.example.jsonplaceholder.mappers.sup;

import com.example.jsonplaceholder.model.dto.request.sup.CompanyRequest;
import com.example.jsonplaceholder.model.dto.response.sup.CompanyResponse;
import com.example.jsonplaceholder.model.domain.user.CompanyDomain;

import java.util.List;
import java.util.stream.Collectors;

public class CompanyConverter {

    // Domain

    public static CompanyDomain convertToCompany(CompanyRequest companyRequest) {
        return CompanyDomain.builder()
                .id(companyRequest.getId())
                .name(companyRequest.getName())
                .catchPhrase(companyRequest.getCatchPhrase())
                .bs(companyRequest.getBs())
                .build();
    }

    // Response

    public static CompanyResponse convertToCompanyResponse(CompanyDomain company) {
        return CompanyResponse.builder()
                .id(company.getId())
                .name(company.getName())
                .catchPhrase(company.getCatchPhrase())
                .bs(company.getBs())
                .build();
    }

    public static List<CompanyResponse> generateCompanyResponseList(List<CompanyDomain> companyList) {
        return companyList.stream()
                .map(CompanyConverter::convertToCompanyResponse)
                .collect(Collectors.toList());
    }
}
