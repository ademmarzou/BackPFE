package com.pfe.HRS.Service;

import com.pfe.HRS.Model.AgentRH;
import com.pfe.HRS.Repository.AgentRHRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentRHS {

    private final AgentRHRepo agentRHRepo;

    @Autowired
    public AgentRHS(AgentRHRepo agentRHRepo)
    {
        this.agentRHRepo = agentRHRepo;
    }

    public AgentRH enregistrerAgentRH(AgentRH agentRH)
    {
        return agentRHRepo.save(agentRH);
    }

    public AgentRH getAgentRHById(Long id)
    {
        return agentRHRepo.findById(id).orElse(null);
    }

    public AgentRH updateAgentRH(Long IdAgentRH, AgentRH newAgentRHDetails) {
        AgentRH existingAgentRH = agentRHRepo.findById(IdAgentRH).orElse(null); // Utilisez l'instance agentRHRepo
        if (existingAgentRH != null) {
            existingAgentRH.setIdAgentRH(newAgentRHDetails.getIdAgentRH());

            return agentRHRepo.save(existingAgentRH);
        } else {
            return null;
        }
    }

    public void deleteAgentRH(Long id)
    {
        agentRHRepo.deleteById(id);
    }

    // Récupérer toutes les factures d'achat
    public List<AgentRH> getAllAgentRH()
    {
        return agentRHRepo.findAll();
    }
}