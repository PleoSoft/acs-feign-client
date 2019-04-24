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

package com.pleosoft.feign.acs.workflow.model;

import java.util.Date;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

@Validated

public class Item {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("value")
	private Integer value = null;

	@JsonProperty("title")
	private String title = null;

	@JsonProperty("description")
	private String description = null;

	@JsonProperty("mimeType")
	private String mimeType = null;

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

	@JsonProperty("size")
	private Integer size = null;

	public Item id(String id) {
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

	public Item name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Get name
	 * 
	 * @return name
	 **/

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Item value(Integer value) {
		this.value = value;
		return this;
	}

	/**
	 * Get value
	 * 
	 * @return value
	 **/

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Item title(String title) {
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

	public Item description(String description) {
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

	public Item mimeType(String mimeType) {
		this.mimeType = mimeType;
		return this;
	}

	/**
	 * Get mimeType
	 * 
	 * @return mimeType
	 **/

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public Item createdBy(Person createdBy) {
		this.createdBy = createdBy;
		return this;
	}

	/**
	 * Get createdBy
	 * 
	 * @return createdBy
	 **/

	@Valid

	public Person getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Person createdBy) {
		this.createdBy = createdBy;
	}

	public Item createdAt(Date createdAt) {
		this.createdAt = createdAt;
		return this;
	}

	/**
	 * Get createdAt
	 * 
	 * @return createdAt
	 **/

	@Valid

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Item edited(Boolean edited) {
		this.edited = edited;
		return this;
	}

	/**
	 * Get edited
	 * 
	 * @return edited
	 **/

	public Boolean isEdited() {
		return edited;
	}

	public void setEdited(Boolean edited) {
		this.edited = edited;
	}

	public Item modifiedBy(Person modifiedBy) {
		this.modifiedBy = modifiedBy;
		return this;
	}

	/**
	 * Get modifiedBy
	 * 
	 * @return modifiedBy
	 **/

	@Valid

	public Person getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Person modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Item modifiedAt(Date modifiedAt) {
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

	public Item size(Integer size) {
		this.size = size;
		return this;
	}

	/**
	 * Get size
	 * 
	 * @return size
	 **/

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Item item = (Item) o;
		return Objects.equals(this.id, item.id) && Objects.equals(this.name, item.name)
				&& Objects.equals(this.value, item.value) && Objects.equals(this.title, item.title)
				&& Objects.equals(this.description, item.description) && Objects.equals(this.mimeType, item.mimeType)
				&& Objects.equals(this.createdBy, item.createdBy) && Objects.equals(this.createdAt, item.createdAt)
				&& Objects.equals(this.edited, item.edited) && Objects.equals(this.modifiedBy, item.modifiedBy)
				&& Objects.equals(this.modifiedAt, item.modifiedAt) && Objects.equals(this.size, item.size);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, value, title, description, mimeType, createdBy, createdAt, edited, modifiedBy,
				modifiedAt, size);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Item {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    value: ").append(toIndentedString(value)).append("\n");
		sb.append("    title: ").append(toIndentedString(title)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    mimeType: ").append(toIndentedString(mimeType)).append("\n");
		sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
		sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
		sb.append("    edited: ").append(toIndentedString(edited)).append("\n");
		sb.append("    modifiedBy: ").append(toIndentedString(modifiedBy)).append("\n");
		sb.append("    modifiedAt: ").append(toIndentedString(modifiedAt)).append("\n");
		sb.append("    size: ").append(toIndentedString(size)).append("\n");
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
