package com.graph.social;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.graph.social.domain.Organisation;
import com.graph.social.domain.User;

@ContextConfiguration(locations = "classpath:/spring/socialNetworkContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class SocialServiceTest {

  @Autowired
  private SocialService userService;

  @Autowired
  private Neo4jTemplate template;

  @Test
  public void socialServiceTest() {
    // userService.createUser("name1", "mail");

    userService.getFriends("1").iterator().hasNext();

    userService.createUser("sample", "1");
    userService.createUser("sample1", "2");

    userService.addFriend("1", "2");

    userService.createUser("sample2", "3");

    Organisation o = userService.createOrganisation("1", "sampleOrg");

    userService.addUserWorksAtOrganisation("1", "1");

    userService.addUserWorksAtOrganisation("2", "1");

    userService.addUserWorksAtOrganisation("3", "1");

    System.out.println("\nFriends of User 1 in same organization");
    for (User u : userService.getFriendsInSameOrganization("1")) {
      System.out.println(u.getUser_id());
    }

    System.out.println("\nUsers Working at Organization 1");
    for (User u : userService.getUserByOrganisation("1")) {
      System.out.println(u.getUser_id());
    }
  }
}
