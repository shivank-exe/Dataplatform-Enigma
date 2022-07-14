package com.airtel.digital.dataplatform.Repository;

import com.airtel.digital.dataplatform.Entity.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamEntityRepository extends JpaRepository<TeamEntity,Long> {

}
