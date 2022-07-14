package com.airtel.digital.dataplatform.controller;

import com.airtel.digital.dataplatform.Entity.Platform;
import com.airtel.digital.dataplatform.Service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/platform")
public class PlatformController {

    @Autowired
    private PlatformService platformService;

    @PostMapping
    public Platform addPlatform(@RequestBody  Platform platform){
        return platformService.addPlatform(platform);
    }
    @GetMapping
    public List<Platform> fetchAllPlatforms(){
        return platformService.fetchAllPlatforms();
    }

    @GetMapping("/{id}")
    public Platform fetchPlatformById(@PathVariable("id") Long platformId){
        return platformService.fetchPlatformById(platformId);
    }

    @PutMapping("/{id}")
    public Platform updatePlatformDetails(@PathVariable("id") Long platformId,@RequestBody Platform platform){
        return platformService.updatePlatformDetails(platformId,platform);
    }

    @DeleteMapping("/{id}")
    public void deletePlatform(@RequestParam("id") Long platformId){
        platformService.deletePlatform(platformId);
        return;
    }
}
