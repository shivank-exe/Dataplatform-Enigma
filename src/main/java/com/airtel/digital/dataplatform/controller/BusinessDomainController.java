package com.airtel.digital.dataplatform.controller;

import com.airtel.digital.dataplatform.Entity.BusinessDomain;
import com.airtel.digital.dataplatform.Service.BusinessDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/business")
public class BusinessDomainController {

    @Autowired
    private BusinessDomainService businessDomainService;

    @PostMapping
    public BusinessDomain addBusinessDomain(@RequestBody BusinessDomain businessDomain){
        return businessDomainService.addBusinessDomain(businessDomain);

    }

    @GetMapping
    public List<BusinessDomain> fetchAllBusinessDomains(){
        return businessDomainService.fetchAllBusinessDomains();
    }

    @GetMapping("/{id}")
    public BusinessDomain fetchBusinessDomainById(@PathVariable("id") Long domainId){
     return businessDomainService.fetchBusinessDomainById(domainId);
    }

    @PutMapping("/{id}")
    public BusinessDomain updateBusinessDomainDetails(@PathVariable("id") Long domainId,
                                                      @RequestBody BusinessDomain businessDomain){
        return  businessDomainService.updateBusinessDomainDetails(domainId,businessDomain);
    }

    @DeleteMapping("/{id}")
    public void deleteBusinessDomain(@PathVariable("id") Long domainId){
        businessDomainService.deleteBusinessDomain(domainId);
        return;
    }
}
