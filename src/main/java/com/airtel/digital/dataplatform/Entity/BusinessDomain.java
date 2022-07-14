package com.airtel.digital.dataplatform.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_business_domain")
public class BusinessDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long domainId;

    @Column(nullable = false,unique = true)
    private String domainName;
    private String description;

//    @OneToMany(mappedBy = "businessDomain",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    @JsonIgnore
//    private List<Dataset> dataset;
}
