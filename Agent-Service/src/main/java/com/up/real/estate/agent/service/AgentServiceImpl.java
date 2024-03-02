package com.up.real.estate.agent.service;

import com.up.real.estate.agent.model.Agent;
import com.up.real.estate.agent.model.enums.CityEnum;
import com.up.real.estate.agent.model.response.ServiceResponse;
import com.up.real.estate.agent.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
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
        return repository.registerAgent(agent);
    }

    @Override
    public List<ServiceResponse> getAllAgents(String city) {
        try {
            if (CityEnum.valueOf(city.toUpperCase(Locale.ROOT)).name().equals(city.toUpperCase(Locale.ROOT))) {
                return repository.getAgents(city).stream().filter(f -> f.getAddress().getCity().equalsIgnoreCase(city))
                        .collect(Collectors.toList());
            }
        } catch (Exception e) {
            return new ArrayList<>();
        }
        return new ArrayList<>();
    }
}
