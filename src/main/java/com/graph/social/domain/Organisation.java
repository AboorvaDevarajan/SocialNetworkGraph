package com.graph.social.domain;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity
public class Organisation {

  @GraphId
  private Long id;

  @Indexed(unique = true)
  private String org_id;

  public final String getOrg_id() {
    return org_id;
  }

  public final void setOrg_id(String org_id) {
    this.org_id = org_id;
  }

  public final String getName() {
    return name;
  }

  public final void setName(String name) {
    this.name = name;
  }

  public final String getDescription() {
    return description;
  }

  public final void setDescription(String description) {
    this.description = description;
  }

  private String name;

  private String description;

  public Organisation() {
  }

  public Organisation(String org_id, String name) {
    this.org_id = org_id;
    this.name = name;
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
    Organisation other = (Organisation) obj;
    if (id == null)
      return other.id == null;
    return id.equals(other.id);
  }

  @Override
  public String toString() {
    return String.format("Organisation{name='%s', user_id=%s}", name, org_id);
  }

  public final void setId(Long id) {
    this.id = id;
  }
}
