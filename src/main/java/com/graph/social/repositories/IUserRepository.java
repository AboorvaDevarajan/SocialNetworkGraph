package com.graph.social.repositories;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.neo4j.repository.RelationshipOperationsRepository;

import com.graph.social.domain.User;

public interface IUserRepository  extends GraphRepository<User>, RelationshipOperationsRepository<User>   {

  @Query("match (U:User) WHERE id(U)={0} return U")
  User getUser(Long id);
  
  @Query("match (U:User)-[:`Friend`]-(U1:User) WHERE U.user_id={0} return U1")
  Iterable<User> getUserFriend(String userId);

  @Query("MATCH (U:User),(FU:User) WHERE U.user_id={0} AND FU.user_id={1} CREATE (U)-[F:`Friend`]->(FU) RETURN U,FU ")
  Iterable<User> addFriend(String userId,String fUserId);

  @Query("MATCH (U:User),(O:Organisation) WHERE U.user_id={0} AND O.org_id={1} CREATE (U)-[W:`Works_At`]->(O) RETURN U ")
  User addUserWorksAtOrganisation(String userId,String orgId);

  @Query("match (U:User)-[:`Works_At`]->(O:Organisation) WHERE O.org_id={0} return U")
  Iterable<User> getUserByOrganisation(String orgId);

  
  @Query("match (U:User)-[:`Friend`]-(U1:User), (U)-[:`Works_At`]->(O:Organisation), (U1)-[:`Works_At`]->(O) WHERE U.user_id={0} RETURN U1")
  Iterable<User> getFriendsInSameOrganization(String orgId);

}
