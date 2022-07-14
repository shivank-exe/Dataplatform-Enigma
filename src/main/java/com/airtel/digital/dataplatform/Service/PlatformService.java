package com.airtel.digital.dataplatform.Service;

import com.airtel.digital.dataplatform.Entity.Platform;
import com.airtel.digital.dataplatform.Repository.PlatformRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatformService {

    @Autowired
    private PlatformRepository platformRepository;

    public Platform addPlatform(Platform platform) {
        platformRepository.save(platform);
        return platform;
    }

    public List<Platform> fetchAllPlatforms() {
        return platformRepository.findAll();
    }

    public Platform fetchPlatformById(Long platformId) {
        return platformRepository.findById(platformId).get();
    }

    public Platform updatePlatformDetails(Long platformId,Platform platform) {
        Platform present = platformRepository.findById(platformId).get();

        if(platform.getPlatformConfigs()!=null){
            present.setPlatformConfigs(platform.getPlatformConfigs());
        }
        if(platform.getPlatformType()!=null){
            present.setPlatformType(platform.getPlatformType());
        }
        if(platform.getPlatformCred()!=null){
            present.setPlatformCred(platform.getPlatformCred());
        }
        if (platform.getSecretName()!=null){
            present.setSecretName(platform.getSecretName());
        }
        platformRepository.save(present);
        return present;
    }

    public void deletePlatform(Long platformId) {
        platformRepository.deleteById(platformId);
        return;
    }
}
