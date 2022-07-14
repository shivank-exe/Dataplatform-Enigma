package com.airtel.digital.dataplatform.Service;

import com.airtel.digital.dataplatform.Entity.Platform;
import com.airtel.digital.dataplatform.Entity.Source;
import com.airtel.digital.dataplatform.Repository.PlatformRepository;
import com.airtel.digital.dataplatform.Repository.SourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SourceService {

    @Autowired
    private SourceRepository sourceRepository;

    @Autowired
    private PlatformRepository platformRepository;

    public Source addSource(Long platformId, Source source) {

        Platform platform= platformRepository.findById(platformId).get();
        source.setPlatform(platform);
        sourceRepository.save(source);
        return source;
    }

    public List<Source> fetchAllSource() {
        return  sourceRepository.findAll();
    }

    public Source fetchSourceById(Long sourceId) {
        return sourceRepository.findById(sourceId).get();
    }

    public Source updateSourceDetails(Long sourceId, Long platformId, Source source) {
        Source present = sourceRepository.findById(sourceId).get();

        if(platformId!=null){
            Platform platform = platformRepository.findById(platformId).get();
            present.setPlatform(platform);
        }
        if(source.getSourceName()!=null){
            present.setSourceName(source.getSourceName());
        }
        if(source.getSourceDescription()!=null){
            present.setSourceDescription(source.getSourceDescription());
        }
        sourceRepository.save(present);
        return present;
    }

    public void deleteSource(Long sourceId) {
        sourceRepository.deleteById(sourceId);
    }
}
