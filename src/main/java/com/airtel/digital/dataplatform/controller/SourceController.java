package com.airtel.digital.dataplatform.controller;

import com.airtel.digital.dataplatform.Entity.Source;
import com.airtel.digital.dataplatform.Service.SourceService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/source")
public class SourceController {

    @Autowired
    private SourceService sourceService;

    @PostMapping
    public Source addSource(@RequestParam @NotNull Long platformId, @RequestBody Source source){
        return sourceService.addSource(platformId,source);
    }

    @GetMapping
    public List<Source> fetchAllSource(){
        return  sourceService.fetchAllSource();
    }
    @GetMapping("/{id}")
    public Source fetchSourceById(@PathVariable("id") Long sourceId){
        return sourceService.fetchSourceById(sourceId);
    }

    @PutMapping("/{id}")
    public Source updateSourceDetails(@PathVariable("id") Long sourceId,
                                      @RequestParam("platformId") Optional<Long> platformId,
                                      @RequestBody Source source){
        return  sourceService.updateSourceDetails(sourceId,platformId,source);
    }

    @DeleteMapping("/{id}")
    public void deleteSource(@PathVariable("id") Long sourceId){
        sourceService.deleteSource(sourceId);
        return;
    }
}
