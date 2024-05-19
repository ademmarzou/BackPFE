package com.pfe.HRS.Controller;


import com.pfe.HRS.Model.Client;
import com.pfe.HRS.Service.ClientS;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ClientC {
    @Autowired
    private final ClientS clientS;

    @PostMapping("/Client/enregistrer")
    public Client enregistrerClient(@RequestBody Client client) {

        return clientS.enregistrerClient(client);
    }

    @GetMapping("/Client/{id}")
    public Client getClientById(@PathVariable Long id) {
        return clientS.getClientById(id);
    }

    @PutMapping("/Client/{id}")
    public Client updateClient(@PathVariable Long id, @RequestBody Client newClientDetails) {
        return clientS.updateClient(id, newClientDetails);
    }

    @DeleteMapping("/Client/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientS.deleteClient(id);
    }

    @GetMapping("/Client/all")
    public List<Client> getAllClients() {
        return clientS.getAllClients();
    }
}
