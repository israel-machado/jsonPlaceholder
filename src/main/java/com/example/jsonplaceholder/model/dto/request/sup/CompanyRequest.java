package com.example.jsonplaceholder.model.dto.request.sup;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyRequest {

    private Long id;
    private String name;
    private String catchPhrase;
    private String bs;
}
