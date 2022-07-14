package com.airtel.digital.dataplatform.controller;

import com.airtel.digital.dataplatform.Entity.Dataset;
import com.airtel.digital.dataplatform.Service.DatasetService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dataset")
public class DatasetController {

    @Autowired
    private DatasetService datasetService;

    @PostMapping
    public Dataset addDataset(@RequestParam("userId") @NotNull Long userId,
                              @RequestParam("domainId") @NotNull Long domainId,
                              @RequestBody Dataset dataset){
        return datasetService.addDataset(userId,domainId,dataset);
    }

    @GetMapping
    public List<Dataset> fetchAllDatasets(){
        return datasetService.fetchAllDatasets();
    }

    @GetMapping("/{id}")
    public Dataset fetchDatasetById(@PathVariable("id") Long datasetId){
        return datasetService.fetchDatasetById(datasetId);
    }

    @PutMapping("/{id}")
    public Dataset  updateDataset(@PathVariable("id") Long datasetId,
                                  @RequestParam Long userId,
                                  @RequestParam  Long domainId,
                                  @RequestBody Dataset dataset){
        return datasetService.updateDataset(datasetId,userId,domainId,dataset);
    }

    @DeleteMapping("/{id}")
    public void deleteDataset(@PathVariable("id") Long datasetId){
        datasetService.deleteDataset(datasetId);
        return;
    }

}
