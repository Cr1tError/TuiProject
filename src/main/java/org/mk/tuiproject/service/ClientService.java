package org.mk.tuiproject.service;

import org.mk.tuiproject.model.Client;
import org.mk.tuiproject.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    
    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client findById(Long id){
        return clientRepository.getReferenceById(id);
    }

    public List<Client> findAll(){
        return clientRepository.findAll();
    }

    public Client saveClient(Client client){
        return clientRepository.save(client);
    }

    public void deleteById(Long id){
        clientRepository.deleteById(id);
    }
}
