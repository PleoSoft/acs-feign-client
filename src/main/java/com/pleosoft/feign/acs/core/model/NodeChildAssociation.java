/**
 * Copyright 2019 Pleo Soft d.o.o. (pleosoft.com)

 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.pleosoft.feign.acs.core.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

@Validated

public class NodeChildAssociation {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("nodeType")
	private String nodeType = null;

	@JsonProperty("isFolder")
	private Boolean isFolder = null;

	@JsonProperty("isFile")
	private Boolean isFile = null;

	@JsonProperty("isLocked")
	private Boolean isLocked = false;

	@JsonProperty("modifiedAt")
	private Date modifiedAt = null;

	@JsonProperty("modifiedByUser")
	private UserInfo modifiedByUser = null;

	@JsonProperty("createdAt")
	private Date createdAt = null;

	@JsonProperty("createdByUser")
	private UserInfo createdByUser = null;

	@JsonProperty("parentId")
	private String parentId = null;

	@JsonProperty("isLink")
	private Boolean isLink = null;

	@JsonProperty("isFavorite")
	private Boolean isFavorite = null;

	@JsonProperty("content")
	private ContentInfo content = null;

	@JsonProperty("aspectNames")
	@Valid
	private List<String> aspectNames = null;

	@JsonProperty("properties")
	@Valid
	private Map<String, Object> properties = null;

	@JsonProperty("allowableOperations")
	@Valid
	private List<String> allowableOperations = null;

	@JsonProperty("path")
	private PathInfo path = null;

	@JsonProperty("permissions")
	private PermissionsInfo permissions = null;

	@JsonProperty("association")
	private ChildAssociationInfo association = null;

	public NodeChildAssociation id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 * 
	 * @return id
	 **/
	@NotNull

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public NodeChildAssociation name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * The name must not contain spaces or the following special characters: *
	 * \" < > \\ / ? : and |. The character . must not be used at the end of the
	 * name.
	 * 
	 * @return name
	 **/
	@NotNull

	@Pattern(regexp = "^(?!(.*[\\\"\\*\\\\\\>\\<\\?/\\:\\|]+.*)|(.*[\\.]?.*[\\.]+$)|(.*[ ]+$))")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public NodeChildAssociation nodeType(String nodeType) {
		this.nodeType = nodeType;
		return this;
	}

	/**
	 * Get nodeType
	 * 
	 * @return nodeType
	 **/
	@NotNull

	public String getNodeType() {
		return nodeType;
	}

	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}

	public NodeChildAssociation isFolder(Boolean isFolder) {
		this.isFolder = isFolder;
		return this;
	}

	/**
	 * Get isFolder
	 * 
	 * @return isFolder
	 **/
	@NotNull

	public Boolean isIsFolder() {
		return isFolder;
	}

	public void setIsFolder(Boolean isFolder) {
		this.isFolder = isFolder;
	}

	public NodeChildAssociation isFile(Boolean isFile) {
		this.isFile = isFile;
		return this;
	}

	/**
	 * Get isFile
	 * 
	 * @return isFile
	 **/
	@NotNull

	public Boolean isIsFile() {
		return isFile;
	}

	public void setIsFile(Boolean isFile) {
		this.isFile = isFile;
	}

	public NodeChildAssociation isLocked(Boolean isLocked) {
		this.isLocked = isLocked;
		return this;
	}

	/**
	 * Get isLocked
	 * 
	 * @return isLocked
	 **/

	public Boolean isIsLocked() {
		return isLocked;
	}

	public void setIsLocked(Boolean isLocked) {
		this.isLocked = isLocked;
	}

	public NodeChildAssociation modifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
		return this;
	}

	/**
	 * Get modifiedAt
	 * 
	 * @return modifiedAt
	 **/
	@NotNull

	@Valid

	public Date getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public NodeChildAssociation modifiedByUser(UserInfo modifiedByUser) {
		this.modifiedByUser = modifiedByUser;
		return this;
	}

	/**
	 * Get modifiedByUser
	 * 
	 * @return modifiedByUser
	 **/
	@NotNull

	@Valid

	public UserInfo getModifiedByUser() {
		return modifiedByUser;
	}

	public void setModifiedByUser(UserInfo modifiedByUser) {
		this.modifiedByUser = modifiedByUser;
	}

	public NodeChildAssociation createdAt(Date createdAt) {
		this.createdAt = createdAt;
		return this;
	}

	/**
	 * Get createdAt
	 * 
	 * @return createdAt
	 **/
	@NotNull

	@Valid

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public NodeChildAssociation createdByUser(UserInfo createdByUser) {
		this.createdByUser = createdByUser;
		return this;
	}

	/**
	 * Get createdByUser
	 * 
	 * @return createdByUser
	 **/
	@NotNull

	@Valid

	public UserInfo getCreatedByUser() {
		return createdByUser;
	}

	public void setCreatedByUser(UserInfo createdByUser) {
		this.createdByUser = createdByUser;
	}

	public NodeChildAssociation parentId(String parentId) {
		this.parentId = parentId;
		return this;
	}

	/**
	 * Get parentId
	 * 
	 * @return parentId
	 **/

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public NodeChildAssociation isLink(Boolean isLink) {
		this.isLink = isLink;
		return this;
	}

	/**
	 * Get isLink
	 * 
	 * @return isLink
	 **/

	public Boolean isIsLink() {
		return isLink;
	}

	public void setIsLink(Boolean isLink) {
		this.isLink = isLink;
	}

	public NodeChildAssociation isFavorite(Boolean isFavorite) {
		this.isFavorite = isFavorite;
		return this;
	}

	/**
	 * Get isFavorite
	 * 
	 * @return isFavorite
	 **/

	public Boolean isIsFavorite() {
		return isFavorite;
	}

	public void setIsFavorite(Boolean isFavorite) {
		this.isFavorite = isFavorite;
	}

	public NodeChildAssociation content(ContentInfo content) {
		this.content = content;
		return this;
	}

	/**
	 * Get content
	 * 
	 * @return content
	 **/

	@Valid

	public ContentInfo getContent() {
		return content;
	}

	public void setContent(ContentInfo content) {
		this.content = content;
	}

	public NodeChildAssociation aspectNames(List<String> aspectNames) {
		this.aspectNames = aspectNames;
		return this;
	}

	public NodeChildAssociation addAspectNamesItem(String aspectNamesItem) {
		if (this.aspectNames == null) {
			this.aspectNames = new ArrayList<String>();
		}
		this.aspectNames.add(aspectNamesItem);
		return this;
	}

	/**
	 * Get aspectNames
	 * 
	 * @return aspectNames
	 **/

	public List<String> getAspectNames() {
		return aspectNames;
	}

	public void setAspectNames(List<String> aspectNames) {
		this.aspectNames = aspectNames;
	}

	public NodeChildAssociation properties(Map<String, Object> properties) {
		this.properties = properties;
		return this;
	}

	public NodeChildAssociation putPropertiesItem(String key, Object propertiesItem) {
		if (this.properties == null) {
			this.properties = new HashMap<String, Object>();
		}
		this.properties.put(key, propertiesItem);
		return this;
	}

	/**
	 * Get properties
	 * 
	 * @return properties
	 **/

	public Map<String, Object> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, Object> properties) {
		this.properties = properties;
	}

	public NodeChildAssociation allowableOperations(List<String> allowableOperations) {
		this.allowableOperations = allowableOperations;
		return this;
	}

	public NodeChildAssociation addAllowableOperationsItem(String allowableOperationsItem) {
		if (this.allowableOperations == null) {
			this.allowableOperations = new ArrayList<String>();
		}
		this.allowableOperations.add(allowableOperationsItem);
		return this;
	}

	/**
	 * Get allowableOperations
	 * 
	 * @return allowableOperations
	 **/

	public List<String> getAllowableOperations() {
		return allowableOperations;
	}

	public void setAllowableOperations(List<String> allowableOperations) {
		this.allowableOperations = allowableOperations;
	}

	public NodeChildAssociation path(PathInfo path) {
		this.path = path;
		return this;
	}

	/**
	 * Get path
	 * 
	 * @return path
	 **/

	@Valid

	public PathInfo getPath() {
		return path;
	}

	public void setPath(PathInfo path) {
		this.path = path;
	}

	public NodeChildAssociation permissions(PermissionsInfo permissions) {
		this.permissions = permissions;
		return this;
	}

	/**
	 * Get permissions
	 * 
	 * @return permissions
	 **/

	@Valid

	public PermissionsInfo getPermissions() {
		return permissions;
	}

	public void setPermissions(PermissionsInfo permissions) {
		this.permissions = permissions;
	}

	public NodeChildAssociation association(ChildAssociationInfo association) {
		this.association = association;
		return this;
	}

	/**
	 * Get association
	 * 
	 * @return association
	 **/

	@Valid

	public ChildAssociationInfo getAssociation() {
		return association;
	}

	public void setAssociation(ChildAssociationInfo association) {
		this.association = association;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		NodeChildAssociation nodeChildAssociation = (NodeChildAssociation) o;
		return Objects.equals(this.id, nodeChildAssociation.id) && Objects.equals(this.name, nodeChildAssociation.name)
				&& Objects.equals(this.nodeType, nodeChildAssociation.nodeType)
				&& Objects.equals(this.isFolder, nodeChildAssociation.isFolder)
				&& Objects.equals(this.isFile, nodeChildAssociation.isFile)
				&& Objects.equals(this.isLocked, nodeChildAssociation.isLocked)
				&& Objects.equals(this.modifiedAt, nodeChildAssociation.modifiedAt)
				&& Objects.equals(this.modifiedByUser, nodeChildAssociation.modifiedByUser)
				&& Objects.equals(this.createdAt, nodeChildAssociation.createdAt)
				&& Objects.equals(this.createdByUser, nodeChildAssociation.createdByUser)
				&& Objects.equals(this.parentId, nodeChildAssociation.parentId)
				&& Objects.equals(this.isLink, nodeChildAssociation.isLink)
				&& Objects.equals(this.isFavorite, nodeChildAssociation.isFavorite)
				&& Objects.equals(this.content, nodeChildAssociation.content)
				&& Objects.equals(this.aspectNames, nodeChildAssociation.aspectNames)
				&& Objects.equals(this.properties, nodeChildAssociation.properties)
				&& Objects.equals(this.allowableOperations, nodeChildAssociation.allowableOperations)
				&& Objects.equals(this.path, nodeChildAssociation.path)
				&& Objects.equals(this.permissions, nodeChildAssociation.permissions)
				&& Objects.equals(this.association, nodeChildAssociation.association);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, nodeType, isFolder, isFile, isLocked, modifiedAt, modifiedByUser, createdAt,
				createdByUser, parentId, isLink, isFavorite, content, aspectNames, properties, allowableOperations,
				path, permissions, association);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class NodeChildAssociation {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    nodeType: ").append(toIndentedString(nodeType)).append("\n");
		sb.append("    isFolder: ").append(toIndentedString(isFolder)).append("\n");
		sb.append("    isFile: ").append(toIndentedString(isFile)).append("\n");
		sb.append("    isLocked: ").append(toIndentedString(isLocked)).append("\n");
		sb.append("    modifiedAt: ").append(toIndentedString(modifiedAt)).append("\n");
		sb.append("    modifiedByUser: ").append(toIndentedString(modifiedByUser)).append("\n");
		sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
		sb.append("    createdByUser: ").append(toIndentedString(createdByUser)).append("\n");
		sb.append("    parentId: ").append(toIndentedString(parentId)).append("\n");
		sb.append("    isLink: ").append(toIndentedString(isLink)).append("\n");
		sb.append("    isFavorite: ").append(toIndentedString(isFavorite)).append("\n");
		sb.append("    content: ").append(toIndentedString(content)).append("\n");
		sb.append("    aspectNames: ").append(toIndentedString(aspectNames)).append("\n");
		sb.append("    properties: ").append(toIndentedString(properties)).append("\n");
		sb.append("    allowableOperations: ").append(toIndentedString(allowableOperations)).append("\n");
		sb.append("    path: ").append(toIndentedString(path)).append("\n");
		sb.append("    permissions: ").append(toIndentedString(permissions)).append("\n");
		sb.append("    association: ").append(toIndentedString(association)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
