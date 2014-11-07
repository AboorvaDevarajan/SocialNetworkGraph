package com.graph.social;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.graph.social.domain.Organisation;
import com.graph.social.domain.User;
import com.graph.social.repositories.IOrganisationRepository;
import com.graph.social.repositories.IUserRepository;

@Service
@Transactional
public class SocialService {

  @Autowired
  private IUserRepository userRepository;

  @Autowired
  private IOrganisationRepository orgRepository;

  public User findById(Long id) {
    return userRepository.getUser(id);
  }

  public Iterable<User> getFriends(String userId) {
    return userRepository.getUserFriend(userId);
  }

  public Iterable<User> addFriend(String userId, String fUserId) {
    return userRepository.addFriend(userId, fUserId);

  }

  public User createUser(String name, String userId) {
    return userRepository.save(new User(name, userId));
  }

  public Organisation createOrganisation(String orgId, String name) {
    return orgRepository.save(new Organisation(orgId, name));
  }
  

  public User addUserWorksAtOrganisation(String userId, String orgId) {
    return userRepository.addUserWorksAtOrganisation(userId, orgId);
  }
  
  public Iterable<User> getUserByOrganisation(String orgId) {
    return userRepository.getUserByOrganisation(orgId);
  }

  public Iterable<User> getFriendsInSameOrganization(String userId) {
    return userRepository.getFriendsInSameOrganization(userId);
  }
}
