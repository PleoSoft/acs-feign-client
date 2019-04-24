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

import java.util.Date;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

@Validated

public class Comment {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("title")
	private String title = null;

	@JsonProperty("content")
	private String content = null;

	@JsonProperty("createdBy")
	private Person createdBy = null;

	@JsonProperty("createdAt")
	private Date createdAt = null;

	@JsonProperty("edited")
	private Boolean edited = null;

	@JsonProperty("modifiedBy")
	private Person modifiedBy = null;

	@JsonProperty("modifiedAt")
	private Date modifiedAt = null;

	@JsonProperty("canEdit")
	private Boolean canEdit = null;

	@JsonProperty("canDelete")
	private Boolean canDelete = null;

	public Comment id(String id) {
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

	public Comment title(String title) {
		this.title = title;
		return this;
	}

	/**
	 * Get title
	 * 
	 * @return title
	 **/
	@NotNull

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Comment content(String content) {
		this.content = content;
		return this;
	}

	/**
	 * Get content
	 * 
	 * @return content
	 **/
	@NotNull

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Comment createdBy(Person createdBy) {
		this.createdBy = createdBy;
		return this;
	}

	/**
	 * Get createdBy
	 * 
	 * @return createdBy
	 **/
	@NotNull

	@Valid

	public Person getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Person createdBy) {
		this.createdBy = createdBy;
	}

	public Comment createdAt(Date createdAt) {
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

	public Comment edited(Boolean edited) {
		this.edited = edited;
		return this;
	}

	/**
	 * Get edited
	 * 
	 * @return edited
	 **/
	@NotNull

	public Boolean isEdited() {
		return edited;
	}

	public void setEdited(Boolean edited) {
		this.edited = edited;
	}

	public Comment modifiedBy(Person modifiedBy) {
		this.modifiedBy = modifiedBy;
		return this;
	}

	/**
	 * Get modifiedBy
	 * 
	 * @return modifiedBy
	 **/
	@NotNull

	@Valid

	public Person getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Person modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Comment modifiedAt(Date modifiedAt) {
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

	public Comment canEdit(Boolean canEdit) {
		this.canEdit = canEdit;
		return this;
	}

	/**
	 * Get canEdit
	 * 
	 * @return canEdit
	 **/
	@NotNull

	public Boolean isCanEdit() {
		return canEdit;
	}

	public void setCanEdit(Boolean canEdit) {
		this.canEdit = canEdit;
	}

	public Comment canDelete(Boolean canDelete) {
		this.canDelete = canDelete;
		return this;
	}

	/**
	 * Get canDelete
	 * 
	 * @return canDelete
	 **/
	@NotNull

	public Boolean isCanDelete() {
		return canDelete;
	}

	public void setCanDelete(Boolean canDelete) {
		this.canDelete = canDelete;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Comment comment = (Comment) o;
		return Objects.equals(this.id, comment.id) && Objects.equals(this.title, comment.title)
				&& Objects.equals(this.content, comment.content) && Objects.equals(this.createdBy, comment.createdBy)
				&& Objects.equals(this.createdAt, comment.createdAt) && Objects.equals(this.edited, comment.edited)
				&& Objects.equals(this.modifiedBy, comment.modifiedBy)
				&& Objects.equals(this.modifiedAt, comment.modifiedAt) && Objects.equals(this.canEdit, comment.canEdit)
				&& Objects.equals(this.canDelete, comment.canDelete);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, title, content, createdBy, createdAt, edited, modifiedBy, modifiedAt, canEdit,
				canDelete);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Comment {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    title: ").append(toIndentedString(title)).append("\n");
		sb.append("    content: ").append(toIndentedString(content)).append("\n");
		sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
		sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
		sb.append("    edited: ").append(toIndentedString(edited)).append("\n");
		sb.append("    modifiedBy: ").append(toIndentedString(modifiedBy)).append("\n");
		sb.append("    modifiedAt: ").append(toIndentedString(modifiedAt)).append("\n");
		sb.append("    canEdit: ").append(toIndentedString(canEdit)).append("\n");
		sb.append("    canDelete: ").append(toIndentedString(canDelete)).append("\n");
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
