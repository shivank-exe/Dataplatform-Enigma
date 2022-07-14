package com.airtel.digital.dataplatform.Repository;

import com.airtel.digital.dataplatform.Entity.BusinessDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface BusinessDomainRepository extends JpaRepository<BusinessDomain,Long> {

}
