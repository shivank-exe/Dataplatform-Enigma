package com.airtel.digital.dataplatform.controller;

import com.airtel.digital.dataplatform.Entity.Transformation;
import com.airtel.digital.dataplatform.Service.TransformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transformer")
public class TransformationController {

    @Autowired
    private TransformationService transformationService;

    @PostMapping
    public Transformation addTransformation(@RequestBody Transformation transformation){
        return  transformationService.addTransformation(transformation);
    }

    @GetMapping
    public List<Transformation> fetchAllTransformation(){
        return  transformationService.fetchAllTransformation();
    }
    @GetMapping("/{id}")
    public Transformation getTransformationById(@PathVariable("id") Long transformationId){
        return  transformationService.getTransformationById(transformationId);
    }
    @PutMapping("/{id}")
    public Transformation updateTransformation(@PathVariable("id") Long transformationId,
                                               @RequestBody Transformation transformation){
        return transformationService.updateTransformation(transformationId,transformation);
    }

}
