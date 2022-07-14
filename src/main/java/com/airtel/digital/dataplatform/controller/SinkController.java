package com.airtel.digital.dataplatform.controller;

import com.airtel.digital.dataplatform.Entity.Sink;
import com.airtel.digital.dataplatform.Service.SinkService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sink")
public class SinkController {

    @Autowired
    private SinkService sinkService;

    @PostMapping
    public Sink addSink(@RequestParam @NotNull Long platformId,@RequestBody Sink sink){
       return sinkService.addSink(platformId,sink);
    }

    @GetMapping
    public List<Sink> fetchAllSink(){
        return sinkService.fetchAllSink();
    }

    @GetMapping("/{id}")
    private Sink fetchById(@PathVariable("id") Long sinkId){
        return sinkService.fetchById(sinkId);
    }

    @PutMapping("/{id}")
    private Sink updateSinkDetails(@PathVariable("id") Long sinkId,
                                   @RequestParam("platformId") Long platformId,
                                   @RequestBody Sink sink){
        return sinkService.updateSinkDetails(sinkId,platformId,sink);
    }

    @DeleteMapping("/{id}")
    private void deleteSink(@PathVariable("id") Long sinkId){
       sinkService.deleteSink(sinkId);
       return;
    }
}
