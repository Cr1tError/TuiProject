package org.mk.tuiproject.service;

import org.mk.tuiproject.model.Client;
import org.mk.tuiproject.model.Guide;
import org.mk.tuiproject.repository.GuideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuideService {

    private final GuideRepository guideRepository;

    @Autowired
    public GuideService(GuideRepository guideRepository) {
        this.guideRepository = guideRepository;
    }

    public Guide findById(Long id){
        return guideRepository.getReferenceById(id);
    }

    public List<Guide> findAll(){
        return guideRepository.findAll();
    }

    public Guide saveGuide(Guide guide){
        return guideRepository.save(guide);
    }

    public void deleteById(Long id){
        guideRepository.deleteById(id);
    }
}
