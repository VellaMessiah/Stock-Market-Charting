package com.casestudy.stockexchange.Entity;

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

    @JsonManagedReference
    @OneToMany(mappedBy = "sector", cascade = CascadeType.ALL, targetEntity = Company.class)
    private List<Company> companyList;
}
