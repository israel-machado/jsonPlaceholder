package com.example.jsonplaceholder.model.sup;

import com.example.jsonplaceholder.model.User;
import com.example.jsonplaceholder.model.dto.request.sup.CompanyRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "company")
public class Company implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String catchPhrase;
    private String bs;

    @OneToOne(mappedBy = "company", cascade = CascadeType.ALL)
    private User user;

}
