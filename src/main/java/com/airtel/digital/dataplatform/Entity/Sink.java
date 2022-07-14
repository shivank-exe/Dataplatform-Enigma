package com.airtel.digital.dataplatform.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_sink")
public class Sink {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sinkId;

    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "platform_id",referencedColumnName = "platformId",nullable = false)
    private Platform platform;

    @Column(nullable = false,unique = true)
    private String sinkName;

    private String sinkDescription;

}

