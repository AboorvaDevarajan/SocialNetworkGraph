package com.graph.social.relation;

import org.neo4j.graphdb.RelationshipType;

public enum Rels implements RelationshipType {
  FRIEND, LIKES, POST, FOLLOW, COMMENTED, WORKS_AT
}
