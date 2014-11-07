package com.graph.social.domain;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity
public class User {

  @GraphId
  private Long id;

  @Indexed(unique = true)
  private String user_id;

  private String username;

  private String password;
  
  public User() {
  }

  public User(String name, String userId) {
    this.username=name;
    this.user_id = userId;
  }

  public Long getId() {
    return id;
  }

  @Override
  public int hashCode() {
    return (id == null) ? 0 : id.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    User other = (User) obj;
    if (id == null)
      return other.id == null;
    return id.equals(other.id);
  }

  @Override
  public String toString() {
    return String.format("User{name='%s', user_id=%s}", username, user_id);
  }

  public final String getUser_id() {
    return user_id;
  }

  public final void setUser_id(String user_id) {
    this.user_id = user_id;
  }

  public final String getUsername() {
    return username;
  }

  public final void setUsername(String username) {
    this.username = username;
  }

  public final String getPassword() {
    return password;
  }

  public final void setPassword(String password) {
    this.password = password;
  }

  public final void setId(Long id) {
    this.id = id;
  }
}
