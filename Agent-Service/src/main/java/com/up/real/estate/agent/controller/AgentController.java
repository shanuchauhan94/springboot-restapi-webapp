package com.up.real.estate.agent.controller;

import com.up.real.estate.agent.model.Agent;
import com.up.real.estate.agent.model.response.ServiceResponse;
import com.up.real.estate.agent.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/app/estate/agent")
@CrossOrigin(origins = "http://localhost:63342")
public class AgentController {

    private final AgentService agentService;

    @Autowired
    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }

    @PostMapping("/register")
    public ResponseEntity<ServiceResponse> agentRegistration(@RequestBody Agent agent) {
        Optional<ServiceResponse> agentId = agentService.registration(agent);
        return agentId.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ServiceResponse()));
    }

    @GetMapping("/agents/{city}")
    public ResponseEntity<List<ServiceResponse>> getAllRegisteredAgents(@PathVariable("city") String city) {

        List<ServiceResponse> agents = agentService.getAllAgents(city);
        if (!CollectionUtils.isEmpty(agents)) {
            return ResponseEntity.ok(agents);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ArrayList<>());
    }
}
