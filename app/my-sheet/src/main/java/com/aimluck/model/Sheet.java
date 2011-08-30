/*
 * This file is part of official Aipo App.
 * Copyright (C) 2011-2011 Aimluck,Inc.
 * http://www.aipo.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package com.aimluck.model;

import java.io.Serializable;
import java.util.Date;

import com.google.appengine.api.datastore.Key;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

@Model(kind = "Sh", schemaVersion = 1, schemaVersionName = "sV")
public class Sheet implements Serializable {

  private static final long serialVersionUID = 1L;

  @Attribute(primaryKey = true, name = "k")
  private Key key;
  @Attribute(version = true, name = "v")
  private Long version;
  @Attribute(name = "n")
  private String name;
  @Attribute(name = "kN")
  private String kindName;
  @Attribute(name = "cA")
  private Date createdAt;
  @Attribute(name = "uA")
  private Date updatedAt;

  /**
   * Returns the key.
   * 
   * @return the key
   */
  public Key getKey() {
    return key;
  }

  /**
   * Sets the key.
   * 
   * @param key
   *          the key
   */
  public void setKey(Key key) {
    this.key = key;
  }

  /**
   * Returns the version.
   * 
   * @return the version
   */
  public Long getVersion() {
    return version;
  }

  /**
   * Sets the version.
   * 
   * @param version
   *          the version
   */
  public void setVersion(Long version) {
    this.version = version;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((key == null) ? 0 : key.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Sheet other = (Sheet) obj;
    if (key == null) {
      if (other.key != null) {
        return false;
      }
    } else if (!key.equals(other.key)) {
      return false;
    }
    return true;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setKindName(String kindName) {
    this.kindName = kindName;
  }

  public String getKindName() {
    return kindName;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }
}
