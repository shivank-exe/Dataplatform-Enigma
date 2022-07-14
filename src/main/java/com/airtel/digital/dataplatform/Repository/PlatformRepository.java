package com.airtel.digital.dataplatform.Repository;

import com.airtel.digital.dataplatform.Entity.Platform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatformRepository extends JpaRepository<Platform,Long> {
}
