package com.airtel.digital.dataplatform.Service;

import com.airtel.digital.dataplatform.Entity.Transformation;
import com.airtel.digital.dataplatform.Repository.TransformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TransformationService {

    @Autowired
    private TransformationRepository transformationRepository;

    public Transformation addTransformation(Transformation transformation) {
          transformationRepository.save(transformation);
          return  transformation;
    }

    public List<Transformation> fetchAllTransformation() {
        return transformationRepository.findAll();
    }

    public Transformation getTransformationById(Long transformationId) {
        return transformationRepository.findById(transformationId).get();
    }
    public  Transformation updateTransformation(Long transformationId,Transformation transformation){

      Transformation present = transformationRepository.findById(transformationId).get();

      if(transformation.getTransformationCode()!=null){
          present.setTransformationCode(transformation.getTransformationCode());
      }
      if(transformation.getTransformationType()!=null){
          present.setTransformationType(transformation.getTransformationType());
      }
      if(transformation.getTransformationConfigs()!=null){
          present.setTransformationConfigs(transformation.getTransformationConfigs());
      }
      if(transformation.getDescription()!=null){
          present.setDescription(transformation.getDescription());
      }
      if(transformation.getTransformationIsGeneric()!=null){
          present.setTransformationIsGeneric(transformation.getTransformationIsGeneric());
      }
      transformationRepository.save(present);
      return present;
    }

}
