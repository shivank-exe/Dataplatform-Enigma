package com.airtel.digital.dataplatform.Repository;

import com.airtel.digital.dataplatform.Entity.Source;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SourceRepository extends JpaRepository<Source,Long> {

}
