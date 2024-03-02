package com.up.real.estate.agent.service;

import com.up.real.estate.agent.model.Agent;
import com.up.real.estate.agent.model.response.ServiceResponse;

import java.util.List;
import java.util.Optional;

public interface AgentService {

    Optional<ServiceResponse> registration(Agent agent);

    List<ServiceResponse> getAllAgents(String city);
}
