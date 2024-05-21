package com.pfe.HRS.Controller;


import com.pfe.HRS.Model.AgentRH;
import com.pfe.HRS.Service.AgentRHS;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@AllArgsConstructor
public class AgentRHC {
    @Autowired
    private final AgentRHS agentRHS;

    @PostMapping("/AgentRH/enregistrer")
    public AgentRH enregistrerAgentRH(@RequestBody AgentRH agentRHM)
    {
        return agentRHS.enregistrerAgentRH(agentRHM);
    }

    @GetMapping("/AgentRH/{id}")
    public AgentRH getAgentRHById(@PathVariable Long id)
    {
        return agentRHS.getAgentRHById(id);
    }

    @PutMapping("/AgentRH/{id}")
    public AgentRH updateAgentRH(@PathVariable Long id, @RequestBody AgentRH newAgentDetails)
    {
        return agentRHS.updateAgentRH(id, newAgentDetails);
    }

    @DeleteMapping("/AgentRH/{id}")
    public void deleteAgentRH(@PathVariable Long id)
    {
        agentRHS.deleteAgentRH(id);
    }

    @GetMapping("/AgentRH/all")
    public List<AgentRH> getAllFacturesAchat()
    {
        return agentRHS.getAllAgentRH();
    }
}
