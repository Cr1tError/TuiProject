package org.mk.tuiproject.controller;

import org.mk.tuiproject.model.Client;
import org.mk.tuiproject.model.Guide;
import org.mk.tuiproject.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClientController {
    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/client-create")
    public String createClientForm(Client client){
        return "client-create";
    }

    @PostMapping("/client-create")
    public String createClient(Client client){
        clientService.saveClient(client);
        return "redirect:/tui";
    }

    @GetMapping("client-delete/{id}")
    public String deleteClient(@PathVariable("id") Long id){
        clientService.deleteById(id);
        return "redirect:/tui";
    }

    @GetMapping("/client-update/{id}")
    public String updateClientForm(@PathVariable("id") Long id, Model model){
        Client client = clientService.findById(id);
        model.addAttribute("client", client);
        return "client-update";
    }

    @PostMapping("/client-update")
    public String updateClient(Client client){
        clientService.saveClient(client);
        return "redirect:/tui";
    }
}
