package com.airtel.digital.dataplatform.Repository;

import com.airtel.digital.dataplatform.Entity.Dataset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatasetRepository extends JpaRepository<Dataset,Long> {
}
