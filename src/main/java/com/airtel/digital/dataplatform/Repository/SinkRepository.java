package com.airtel.digital.dataplatform.Repository;

import com.airtel.digital.dataplatform.Entity.Sink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SinkRepository extends JpaRepository<Sink,Long> {
}
