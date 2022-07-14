package com.airtel.digital.dataplatform.Entity;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_user",uniqueConstraints = @UniqueConstraint(columnNames = "userEmail"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String userAccessDocs;

    @Column(nullable = false)
    private String userEmail;

    private Boolean visibleOnDatahub;
    private String userRole;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Dataset> dataset;

    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "team_id",referencedColumnName = "teamId",nullable = false)
    private TeamEntity teamEntity;

}
