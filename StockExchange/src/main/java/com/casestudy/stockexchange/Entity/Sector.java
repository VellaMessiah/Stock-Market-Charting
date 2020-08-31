package com.casestudy.stockexchange.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Sector {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "sector_name", nullable = false)
    private String sectorName;

    private String brief;

    @JsonIgnoreProperties("sector")
    @OneToMany( cascade = CascadeType.ALL, targetEntity = Company.class, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Company> companyList;
}
