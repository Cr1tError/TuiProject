package org.mk.tuiproject.controller;

import org.mk.tuiproject.model.Guide;
import org.mk.tuiproject.service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class GuideController {

    private final GuideService guideService;

    @Autowired
    public GuideController(GuideService guideService) {
        this.guideService = guideService;
    }

    @GetMapping("/guides")
    public String findAll(Model model){
        List<Guide> guides = guideService.findAll();
        model.addAttribute("guides", guides);
        return "guide-list";
    }
    @GetMapping("/guide-create")
    public String createGuideForm(Guide guide){
        return "guide-create";
    }

    @PostMapping("/guide-create")
    public String createGuide(Guide guide){
       guideService.saveGuide(guide);
        return "redirect:/guides";
    }

    @GetMapping("guide-delete/{id}")
    public String deleteGuide(@PathVariable("id") Long id){
        guideService.deleteById(id);
        return "redirect:/guides";
    }

    @GetMapping("/guide-update/{id}")
    public String updateGuideForm(@PathVariable("id") Long id, Model model){
        Guide guide = guideService.findById(id);
        model.addAttribute("guide", guide);
        return "guide-update";
    }

    @PostMapping("/guide-update")
    public String updateGuide(Guide guide){
        guideService.saveGuide(guide);
        return "redirect:/guides";
    }
}
