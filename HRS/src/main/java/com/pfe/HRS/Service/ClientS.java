package com.pfe.HRS.Service;

import com.pfe.HRS.Model.Client;
import com.pfe.HRS.Repository.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientS {

    private final ClientRepo clientRepo;

    @Autowired
    public ClientS(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    public Client enregistrerClient(Client client) {
        return clientRepo.save(client);
    }

    public Client getClientById(Long id) {
        return clientRepo.findById(id).orElse(null);
    }

    public Client updateClient(Long id, Client newClientDetails) {
        Client existingClient = clientRepo.findById(id).orElse(null);
        if (existingClient != null) {
            // Mettez à jour les attributs selon vos besoins
            existingClient.setIdClient(newClientDetails.getIdClient());

            return clientRepo.save(existingClient);
        } else {
            return null;
        }
    }

    public void deleteClient(Long id) {
        clientRepo.deleteById(id);
    }

    public List<Client> getAllClients() {
        return clientRepo.findAll();
    }
}
