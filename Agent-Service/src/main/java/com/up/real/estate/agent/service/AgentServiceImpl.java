package com.up.real.estate.agent.service;

import com.up.real.estate.agent.model.Agent;
import com.up.real.estate.agent.model.response.ServiceResponse;
import com.up.real.estate.agent.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AgentServiceImpl implements AgentService {

    private final AgentRepository repository;

    @Autowired
    public AgentServiceImpl(AgentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<ServiceResponse> registration(Agent agent) {
        agent.getAddress().setId(UUID.randomUUID().toString());
        Agent response = repository.save(agent);
        return Optional.of(new ServiceResponse(response.getId(), response.getName(), response.getEmail(),
                response.getMobNumber(), response.getDob(), response.getAddress()));
    }

    @Override
    public List<ServiceResponse> getAllAgents(String emailId) {
        try {
            if (!"all".equalsIgnoreCase(emailId)) {
                return repository.findAgentsByEmail(emailId)
                        .stream()
                        .filter(f -> f.getEmail().equalsIgnoreCase(emailId))
                        .map(agent -> new ServiceResponse(agent.getId(), agent.getName(), agent.getEmail(),
                                agent.getMobNumber(), agent.getDob(), agent.getAddress()))
                        .collect(Collectors.toList());
            } else {
                return repository.findAll().stream()
                        .map(agent -> new ServiceResponse(agent.getId(), agent.getName(), agent.getEmail(),
                                agent.getMobNumber(), agent.getDob(), agent.getAddress()))
                        .collect(Collectors.toList());
            }
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
