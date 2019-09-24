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

public class DeletedNode {
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

	@JsonProperty("archivedByUser")
	private UserInfo archivedByUser = null;

	@JsonProperty("archivedAt")
	private Date archivedAt = null;

	public DeletedNode id(String id) {
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

	public DeletedNode name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * The name must not contain spaces or the following special characters: * \" <
	 * > \\ / ? : and |. The character . must not be used at the end of the name.
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

	public DeletedNode nodeType(String nodeType) {
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

	public DeletedNode isFolder(Boolean isFolder) {
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

	public DeletedNode isFile(Boolean isFile) {
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

	public DeletedNode isLocked(Boolean isLocked) {
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

	public DeletedNode modifiedAt(Date modifiedAt) {
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

	public DeletedNode modifiedByUser(UserInfo modifiedByUser) {
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

	public DeletedNode createdAt(Date createdAt) {
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

	public DeletedNode createdByUser(UserInfo createdByUser) {
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

	public DeletedNode parentId(String parentId) {
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

	public DeletedNode isLink(Boolean isLink) {
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

	public DeletedNode isFavorite(Boolean isFavorite) {
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

	public DeletedNode content(ContentInfo content) {
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

	public DeletedNode aspectNames(List<String> aspectNames) {
		this.aspectNames = aspectNames;
		return this;
	}

	public DeletedNode addAspectNamesItem(String aspectNamesItem) {
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

	public DeletedNode properties(Map<String, Object> properties) {
		this.properties = properties;
		return this;
	}

	public DeletedNode putPropertiesItem(String key, Object propertiesItem) {
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

	public DeletedNode allowableOperations(List<String> allowableOperations) {
		this.allowableOperations = allowableOperations;
		return this;
	}

	public DeletedNode addAllowableOperationsItem(String allowableOperationsItem) {
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

	public DeletedNode path(PathInfo path) {
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

	public DeletedNode permissions(PermissionsInfo permissions) {
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

	public DeletedNode archivedByUser(UserInfo archivedByUser) {
		this.archivedByUser = archivedByUser;
		return this;
	}

	/**
	 * Get archivedByUser
	 * 
	 * @return archivedByUser
	 **/
	@NotNull

	@Valid

	public UserInfo getArchivedByUser() {
		return archivedByUser;
	}

	public void setArchivedByUser(UserInfo archivedByUser) {
		this.archivedByUser = archivedByUser;
	}

	public DeletedNode archivedAt(Date archivedAt) {
		this.archivedAt = archivedAt;
		return this;
	}

	/**
	 * Get archivedAt
	 * 
	 * @return archivedAt
	 **/
	@NotNull

	@Valid

	public Date getArchivedAt() {
		return archivedAt;
	}

	public void setArchivedAt(Date archivedAt) {
		this.archivedAt = archivedAt;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		DeletedNode deletedNode = (DeletedNode) o;
		return Objects.equals(this.id, deletedNode.id) && Objects.equals(this.name, deletedNode.name)
				&& Objects.equals(this.nodeType, deletedNode.nodeType)
				&& Objects.equals(this.isFolder, deletedNode.isFolder)
				&& Objects.equals(this.isFile, deletedNode.isFile)
				&& Objects.equals(this.isLocked, deletedNode.isLocked)
				&& Objects.equals(this.modifiedAt, deletedNode.modifiedAt)
				&& Objects.equals(this.modifiedByUser, deletedNode.modifiedByUser)
				&& Objects.equals(this.createdAt, deletedNode.createdAt)
				&& Objects.equals(this.createdByUser, deletedNode.createdByUser)
				&& Objects.equals(this.parentId, deletedNode.parentId)
				&& Objects.equals(this.isLink, deletedNode.isLink)
				&& Objects.equals(this.isFavorite, deletedNode.isFavorite)
				&& Objects.equals(this.content, deletedNode.content)
				&& Objects.equals(this.aspectNames, deletedNode.aspectNames)
				&& Objects.equals(this.properties, deletedNode.properties)
				&& Objects.equals(this.allowableOperations, deletedNode.allowableOperations)
				&& Objects.equals(this.path, deletedNode.path)
				&& Objects.equals(this.permissions, deletedNode.permissions)
				&& Objects.equals(this.archivedByUser, deletedNode.archivedByUser)
				&& Objects.equals(this.archivedAt, deletedNode.archivedAt);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, nodeType, isFolder, isFile, isLocked, modifiedAt, modifiedByUser, createdAt,
				createdByUser, parentId, isLink, isFavorite, content, aspectNames, properties, allowableOperations,
				path, permissions, archivedByUser, archivedAt);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class DeletedNode {\n");

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
		sb.append("    archivedByUser: ").append(toIndentedString(archivedByUser)).append("\n");
		sb.append("    archivedAt: ").append(toIndentedString(archivedAt)).append("\n");
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
