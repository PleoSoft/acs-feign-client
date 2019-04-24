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
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

@Validated

public class SharedLink {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("expiresAt")
	private Date expiresAt = null;

	@JsonProperty("nodeId")
	private String nodeId = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("title")
	private String title = null;

	@JsonProperty("description")
	private String description = null;

	@JsonProperty("modifiedAt")
	private Date modifiedAt = null;

	@JsonProperty("modifiedByUser")
	private UserInfo modifiedByUser = null;

	@JsonProperty("sharedByUser")
	private UserInfo sharedByUser = null;

	@JsonProperty("content")
	private ContentInfo content = null;

	@JsonProperty("allowableOperations")
	@Valid
	private List<String> allowableOperations = null;

	@JsonProperty("allowableOperationsOnTarget")
	@Valid
	private List<String> allowableOperationsOnTarget = null;

	public SharedLink id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 * 
	 * @return id
	 **/

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public SharedLink expiresAt(Date expiresAt) {
		this.expiresAt = expiresAt;
		return this;
	}

	/**
	 * Get expiresAt
	 * 
	 * @return expiresAt
	 **/

	@Valid

	public Date getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(Date expiresAt) {
		this.expiresAt = expiresAt;
	}

	public SharedLink nodeId(String nodeId) {
		this.nodeId = nodeId;
		return this;
	}

	/**
	 * Get nodeId
	 * 
	 * @return nodeId
	 **/

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public SharedLink name(String name) {
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

	@Pattern(regexp = "^(?!(.*[\\\"\\*\\\\\\>\\<\\?/\\:\\|]+.*)|(.*[\\.]?.*[\\.]+$)|(.*[ ]+$))")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SharedLink title(String title) {
		this.title = title;
		return this;
	}

	/**
	 * Get title
	 * 
	 * @return title
	 **/

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public SharedLink description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Get description
	 * 
	 * @return description
	 **/

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public SharedLink modifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
		return this;
	}

	/**
	 * Get modifiedAt
	 * 
	 * @return modifiedAt
	 **/

	@Valid

	public Date getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public SharedLink modifiedByUser(UserInfo modifiedByUser) {
		this.modifiedByUser = modifiedByUser;
		return this;
	}

	/**
	 * Get modifiedByUser
	 * 
	 * @return modifiedByUser
	 **/

	@Valid

	public UserInfo getModifiedByUser() {
		return modifiedByUser;
	}

	public void setModifiedByUser(UserInfo modifiedByUser) {
		this.modifiedByUser = modifiedByUser;
	}

	public SharedLink sharedByUser(UserInfo sharedByUser) {
		this.sharedByUser = sharedByUser;
		return this;
	}

	/**
	 * Get sharedByUser
	 * 
	 * @return sharedByUser
	 **/

	@Valid

	public UserInfo getSharedByUser() {
		return sharedByUser;
	}

	public void setSharedByUser(UserInfo sharedByUser) {
		this.sharedByUser = sharedByUser;
	}

	public SharedLink content(ContentInfo content) {
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

	public SharedLink allowableOperations(List<String> allowableOperations) {
		this.allowableOperations = allowableOperations;
		return this;
	}

	public SharedLink addAllowableOperationsItem(String allowableOperationsItem) {
		if (this.allowableOperations == null) {
			this.allowableOperations = new ArrayList<String>();
		}
		this.allowableOperations.add(allowableOperationsItem);
		return this;
	}

	/**
	 * The allowable operations for the Quickshare link itself. See
	 * allowableOperationsOnTarget for the allowable operations pertaining to
	 * the linked content node.
	 * 
	 * @return allowableOperations
	 **/

	public List<String> getAllowableOperations() {
		return allowableOperations;
	}

	public void setAllowableOperations(List<String> allowableOperations) {
		this.allowableOperations = allowableOperations;
	}

	public SharedLink allowableOperationsOnTarget(List<String> allowableOperationsOnTarget) {
		this.allowableOperationsOnTarget = allowableOperationsOnTarget;
		return this;
	}

	public SharedLink addAllowableOperationsOnTargetItem(String allowableOperationsOnTargetItem) {
		if (this.allowableOperationsOnTarget == null) {
			this.allowableOperationsOnTarget = new ArrayList<String>();
		}
		this.allowableOperationsOnTarget.add(allowableOperationsOnTargetItem);
		return this;
	}

	/**
	 * The allowable operations for the content node being shared.
	 * 
	 * @return allowableOperationsOnTarget
	 **/

	public List<String> getAllowableOperationsOnTarget() {
		return allowableOperationsOnTarget;
	}

	public void setAllowableOperationsOnTarget(List<String> allowableOperationsOnTarget) {
		this.allowableOperationsOnTarget = allowableOperationsOnTarget;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		SharedLink sharedLink = (SharedLink) o;
		return Objects.equals(this.id, sharedLink.id) && Objects.equals(this.expiresAt, sharedLink.expiresAt)
				&& Objects.equals(this.nodeId, sharedLink.nodeId) && Objects.equals(this.name, sharedLink.name)
				&& Objects.equals(this.title, sharedLink.title)
				&& Objects.equals(this.description, sharedLink.description)
				&& Objects.equals(this.modifiedAt, sharedLink.modifiedAt)
				&& Objects.equals(this.modifiedByUser, sharedLink.modifiedByUser)
				&& Objects.equals(this.sharedByUser, sharedLink.sharedByUser)
				&& Objects.equals(this.content, sharedLink.content)
				&& Objects.equals(this.allowableOperations, sharedLink.allowableOperations)
				&& Objects.equals(this.allowableOperationsOnTarget, sharedLink.allowableOperationsOnTarget);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, expiresAt, nodeId, name, title, description, modifiedAt, modifiedByUser, sharedByUser,
				content, allowableOperations, allowableOperationsOnTarget);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class SharedLink {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    expiresAt: ").append(toIndentedString(expiresAt)).append("\n");
		sb.append("    nodeId: ").append(toIndentedString(nodeId)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    title: ").append(toIndentedString(title)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    modifiedAt: ").append(toIndentedString(modifiedAt)).append("\n");
		sb.append("    modifiedByUser: ").append(toIndentedString(modifiedByUser)).append("\n");
		sb.append("    sharedByUser: ").append(toIndentedString(sharedByUser)).append("\n");
		sb.append("    content: ").append(toIndentedString(content)).append("\n");
		sb.append("    allowableOperations: ").append(toIndentedString(allowableOperations)).append("\n");
		sb.append("    allowableOperationsOnTarget: ").append(toIndentedString(allowableOperationsOnTarget))
				.append("\n");
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
