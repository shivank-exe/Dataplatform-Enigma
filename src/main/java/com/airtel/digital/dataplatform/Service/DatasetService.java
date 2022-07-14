package com.airtel.digital.dataplatform.Service;

import com.airtel.digital.dataplatform.Entity.BusinessDomain;
import com.airtel.digital.dataplatform.Entity.Dataset;
import com.airtel.digital.dataplatform.Entity.User;
import com.airtel.digital.dataplatform.Repository.BusinessDomainRepository;
import com.airtel.digital.dataplatform.Repository.DatasetRepository;
import com.airtel.digital.dataplatform.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatasetService {

    @Autowired
    private DatasetRepository datasetRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BusinessDomainRepository businessDomainRepository;

    public Dataset addDataset(Long userId, Long domainId, Dataset dataset) {
        User user= userRepository.findById(userId).get();
        BusinessDomain businessDomain= businessDomainRepository.findById(domainId).get();
        System.out.println("businessDomain = " + businessDomain);
        dataset.setUser(user);
        dataset.setBusinessDomain(businessDomain);
        datasetRepository.save(dataset);
        return dataset;
    }

    public List<Dataset> fetchAllDatasets() {
        return datasetRepository.findAll();

    }

    public Dataset fetchDatasetById(Long datasetId) {
        return datasetRepository.findById(datasetId).get();
    }

    public Dataset updateDataset(Long datasetId, Long userId, Long domainId,Dataset dataset) {
        Dataset present = datasetRepository.findById(datasetId).get();
        if(userId!=null){
            User user = userRepository.findById(userId).get();
            present.setUser(user);
        }
        if(domainId!=null){
            BusinessDomain businessDomain=businessDomainRepository.findById(domainId).get();
            present.setBusinessDomain(businessDomain);
        }
        if(dataset.getDatasetName()!=null){
            present.setDatasetName(dataset.getDatasetName());
        }
        if (dataset.getDatasetDescription()!=null){
            present.setDatasetDescription(dataset.getDatasetDescription());
        }
        if (dataset.getCreatedBy()!=null){
            present.setCreatedBy(dataset.getCreatedBy());
        }
        datasetRepository.save(present);
        return present;
    }

    public void deleteDataset(Long datasetId) {
        datasetRepository.deleteById(datasetId);
        return;
    }
}
