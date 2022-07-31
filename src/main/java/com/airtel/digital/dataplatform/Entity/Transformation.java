package com.airtel.digital.dataplatform.Entity;

import com.airtel.digital.dataplatform.Enums.Drivers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tbl_transformation")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class  Transformation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transformationId;

    private Drivers transformationType;

    private Boolean transformationIsGeneric;

    private String transformationCode;

    private String description;

    private String transformationConfigs;

}
