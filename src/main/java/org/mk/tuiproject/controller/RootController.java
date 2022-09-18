package org.mk.tuiproject.controller;


import org.mk.tuiproject.model.Client;
import org.mk.tuiproject.model.Trip;
import org.mk.tuiproject.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class RootController {

    private ClientService clientService;

    @Autowired
    public RootController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/tui")
    public String root(Model model){
        List<Client> clients = clientService.findAll();
        model.addAttribute("clients", clients);
        return "root";
    }

}
