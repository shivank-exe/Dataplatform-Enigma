package com.airtel.digital.dataplatform.Service;

import com.airtel.digital.dataplatform.Entity.BusinessDomain;
import com.airtel.digital.dataplatform.Repository.BusinessDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessDomainService {

    @Autowired
    BusinessDomainRepository businessDomainRepository;

    public BusinessDomain addBusinessDomain(BusinessDomain businessDomain) {
        businessDomainRepository.save(businessDomain);
        return businessDomain;
    }

    public List<BusinessDomain> fetchAllBusinessDomains() {
        return businessDomainRepository.findAll();
    }

    public BusinessDomain fetchBusinessDomainById(Long domainId) {
        return businessDomainRepository.findById(domainId).get();
    }

    public BusinessDomain updateBusinessDomainDetails(Long domainId, BusinessDomain businessDomain) {

        BusinessDomain present = businessDomainRepository.findById(domainId).get();
        if(businessDomain.getDomainName()!=null){
            present.setDomainName(businessDomain.getDomainName());
        }
        if(businessDomain.getDescription()!=null){
            present.setDescription(businessDomain.getDescription());
        }
        businessDomainRepository.save(present);
        return present;
    }

    public void deleteBusinessDomain(Long domainId) {
        businessDomainRepository.deleteById(domainId);
        return;
    }
}
