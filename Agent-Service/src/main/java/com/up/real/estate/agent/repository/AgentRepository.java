package com.up.real.estate.agent.repository;

import com.up.real.estate.agent.model.Address;
import com.up.real.estate.agent.model.Agent;
import com.up.real.estate.agent.model.response.ServiceResponse;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class AgentRepository {

    public Optional<ServiceResponse> registerAgent(Agent agent) {
        if (Objects.nonNull(agent)) {
            return Optional.of(new ServiceResponse(UUID.randomUUID().toString(), agent.getName(), agent.getEmail(),
                    agent.getMobNumber(), 0, null));
        }
        return Optional.empty();
    }

    public List<ServiceResponse> getAgents(String city) {
        return Arrays.asList(
                new ServiceResponse(UUID.randomUUID().toString(), "Agent1", "agent1@gmail.com",
                        98665433222L, 30, new Address("Basti", "village1", 110928)),
                new ServiceResponse(UUID.randomUUID().toString(), "Agent2", "agent2@gmail.com",
                        86284294924L, 32, new Address("Harriya", "village2", 653432)),
                new ServiceResponse(UUID.randomUUID().toString(), "Agent3", "agent3@gmail.com",
                        9987654433L, 24, new Address("Basti", "village3", 342617)),
                new ServiceResponse(UUID.randomUUID().toString(), "Agent4", "agent4@gmail.com",
                        99865433467L, 29, new Address("Harriya", "village4", 874274))
        );
    }
}
