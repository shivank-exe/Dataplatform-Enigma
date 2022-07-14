package com.airtel.digital.dataplatform.Entity;

import com.airtel.digital.dataplatform.Enums.PlatformType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_platform")
public class Platform {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long platformId;
    private  PlatformType platformType;
    private String platformConfigs;
    private String platformCred;
    private String secretName;

    @OneToMany(mappedBy = "platform",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Source> sources;

    @OneToMany(mappedBy = "platform",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Sink> sinks;
}
