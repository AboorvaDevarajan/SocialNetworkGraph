package com.graph.social.repositories;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.neo4j.repository.RelationshipOperationsRepository;

import com.graph.social.domain.Organisation;
import com.graph.social.domain.User;

public interface IOrganisationRepository  extends GraphRepository<Organisation>, RelationshipOperationsRepository<User>   {

  @Query("match (O:Organisation) WHERE O.org_id={0} return O")
  Organisation getOrganisationById(String id);
  
}
