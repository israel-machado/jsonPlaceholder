package com.example.jsonplaceholder.model.domain.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "company")
public class CompanyDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String catchPhrase;
    private String bs;

    @OneToOne(mappedBy = "company", cascade = CascadeType.ALL)
    private UserDomain user;

}
