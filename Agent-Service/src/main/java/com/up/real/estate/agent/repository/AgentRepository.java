package com.up.real.estate.agent.repository;

import com.up.real.estate.agent.model.Address;
import com.up.real.estate.agent.model.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgentRepository extends JpaRepository<Agent, Long> {

    List<Agent> findAgentsByEmail(String email);
}
