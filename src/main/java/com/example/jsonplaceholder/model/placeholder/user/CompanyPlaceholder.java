package com.example.jsonplaceholder.model.placeholder.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CompanyPlaceholder {

    private String name;
    private String catchPhrase;
    private String bs;
}
