package com.airtel.digital.dataplatform.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "tbl_team_entity")
public class TeamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long teamId;

    private  String teamName;
    private  String teamDescription;

    @OneToMany(mappedBy = "teamEntity",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    private List<User> users;



}
