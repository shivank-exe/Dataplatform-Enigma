package com.airtel.digital.dataplatform.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_source")
public class Source {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sourceId;

    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "platform_id",referencedColumnName = "platformId",nullable = false)
    private Platform platform;

    @Column(nullable = false,unique = true)
    private String sourceName;

    private String sourceDescription;

}
