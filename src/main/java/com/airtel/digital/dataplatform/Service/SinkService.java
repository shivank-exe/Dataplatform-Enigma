package com.airtel.digital.dataplatform.Service;

import com.airtel.digital.dataplatform.Entity.Platform;
import com.airtel.digital.dataplatform.Entity.Sink;
import com.airtel.digital.dataplatform.Repository.PlatformRepository;
import com.airtel.digital.dataplatform.Repository.SinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SinkService {

    @Autowired
    private SinkRepository sinkRepository;

    @Autowired
    private PlatformRepository platformRepository;

    public Sink addSink(Long platformId, Sink sink) {
        Platform platform = platformRepository.findById(platformId).get();
        sink.setPlatform(platform);
        return sink;
    }

    public List<Sink> fetchAllSink() {
        return sinkRepository.findAll();
    }

    public Sink fetchById(Long sinkId) {
        return sinkRepository.findById(sinkId).get();
    }

    public Sink updateSinkDetails(Long sinkId, Optional<Long> platformId, Sink sink) {
        Sink present = sinkRepository.findById(sinkId).get();

        if(platformId.isPresent()){
            Platform platform = platformRepository.findById(platformId.get()).get();
            present.setPlatform(platform);
        }

        if(sink.getSinkName()!=null){
            present.setSinkName(sink.getSinkName());
        }

        if(sink.getSinkDescription()!=null){
            present.setSinkDescription(sink.getSinkDescription());
        }
        sinkRepository.save(present);
            return present;
    }


    public void deleteSink(Long sinkId) {
        sinkRepository.deleteById(sinkId);

    }
}
