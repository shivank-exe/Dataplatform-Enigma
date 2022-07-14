package com.airtel.digital.dataplatform.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_dataset")
public class Dataset {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long datasetId;

    @Column(nullable = false,unique = true)
    private String datasetName;

    private String datasetDescription;
    private String createdBy;

    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name="user_id",referencedColumnName = "userId",nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "domain_id",referencedColumnName = "domainId",nullable = false)
    private BusinessDomain businessDomain;

}
