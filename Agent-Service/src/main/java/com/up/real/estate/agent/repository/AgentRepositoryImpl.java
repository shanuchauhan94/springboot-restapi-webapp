package com.up.real.estate.agent.repository;

import com.up.real.estate.agent.model.Address;
import com.up.real.estate.agent.model.Agent;
import com.up.real.estate.agent.model.response.ServiceResponse;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class AgentRepositoryImpl {

    public Optional<ServiceResponse> registerAgent(Agent agent) {
        if (Objects.nonNull(agent)) {
            return Optional.of(new ServiceResponse(1L, agent.getName(), agent.getEmail(),
                    agent.getMobNumber(), null, null));
        }
        return Optional.empty();
    }

    public List<ServiceResponse> getAgents(String city) {
        return Arrays.asList(
                new ServiceResponse(2L, "Agent1", "agent1@gmail.com",
                        98665433222L, null, new Address("","Basti", "village1", 110928)),
                new ServiceResponse(3L, "Agent2", "agent2@gmail.com",
                        86284294924L, null, new Address("","Harriya", "village2", 653432)),
                new ServiceResponse(4L, "Agent3", "agent3@gmail.com",
                        9987654433L, null, new Address("","Basti", "village3", 342617)),
                new ServiceResponse(5L, "Agent4", "agent4@gmail.com",
                        99865433467L, null, new Address("","Harriya", "village4", 874274))
        );
    }
}
