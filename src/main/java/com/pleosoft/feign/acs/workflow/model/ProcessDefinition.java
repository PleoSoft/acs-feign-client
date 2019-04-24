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

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

@Validated

public class ProcessDefinition {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("key")
	private String key = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("category")
	private String category = null;

	@JsonProperty("deploymentId")
	private String deploymentId = null;

	@JsonProperty("title")
	private String title = null;

	@JsonProperty("description")
	private String description = null;

	@JsonProperty("startFormResourceKey")
	private String startFormResourceKey = null;

	@JsonProperty("graphicNotationDefined")
	private Boolean graphicNotationDefined = null;

	public ProcessDefinition id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * The unique id of this process definition
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

	public ProcessDefinition key(String key) {
		this.key = key;
		return this;
	}

	/**
	 * The key of this process definition
	 * 
	 * @return key
	 **/

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public ProcessDefinition name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * The name of this process definition
	 * 
	 * @return name
	 **/

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProcessDefinition category(String category) {
		this.category = category;
		return this;
	}

	/**
	 * The category to which this process definition belongs
	 * 
	 * @return category
	 **/

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public ProcessDefinition deploymentId(String deploymentId) {
		this.deploymentId = deploymentId;
		return this;
	}

	/**
	 * The deployment of which this process definition is a part
	 * 
	 * @return deploymentId
	 **/

	public String getDeploymentId() {
		return deploymentId;
	}

	public void setDeploymentId(String deploymentId) {
		this.deploymentId = deploymentId;
	}

	public ProcessDefinition title(String title) {
		this.title = title;
		return this;
	}

	/**
	 * The title of this process definition
	 * 
	 * @return title
	 **/

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ProcessDefinition description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * The description of this process definition
	 * 
	 * @return description
	 **/

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ProcessDefinition startFormResourceKey(String startFormResourceKey) {
		this.startFormResourceKey = startFormResourceKey;
		return this;
	}

	/**
	 * The start form key
	 * 
	 * @return startFormResourceKey
	 **/

	public String getStartFormResourceKey() {
		return startFormResourceKey;
	}

	public void setStartFormResourceKey(String startFormResourceKey) {
		this.startFormResourceKey = startFormResourceKey;
	}

	public ProcessDefinition graphicNotationDefined(Boolean graphicNotationDefined) {
		this.graphicNotationDefined = graphicNotationDefined;
		return this;
	}

	/**
	 * Get graphicNotationDefined
	 * 
	 * @return graphicNotationDefined
	 **/

	public Boolean isGraphicNotationDefined() {
		return graphicNotationDefined;
	}

	public void setGraphicNotationDefined(Boolean graphicNotationDefined) {
		this.graphicNotationDefined = graphicNotationDefined;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ProcessDefinition processDefinition = (ProcessDefinition) o;
		return Objects.equals(this.id, processDefinition.id) && Objects.equals(this.key, processDefinition.key)
				&& Objects.equals(this.name, processDefinition.name)
				&& Objects.equals(this.category, processDefinition.category)
				&& Objects.equals(this.deploymentId, processDefinition.deploymentId)
				&& Objects.equals(this.title, processDefinition.title)
				&& Objects.equals(this.description, processDefinition.description)
				&& Objects.equals(this.startFormResourceKey, processDefinition.startFormResourceKey)
				&& Objects.equals(this.graphicNotationDefined, processDefinition.graphicNotationDefined);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, key, name, category, deploymentId, title, description, startFormResourceKey,
				graphicNotationDefined);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ProcessDefinition {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    key: ").append(toIndentedString(key)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    category: ").append(toIndentedString(category)).append("\n");
		sb.append("    deploymentId: ").append(toIndentedString(deploymentId)).append("\n");
		sb.append("    title: ").append(toIndentedString(title)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    startFormResourceKey: ").append(toIndentedString(startFormResourceKey)).append("\n");
		sb.append("    graphicNotationDefined: ").append(toIndentedString(graphicNotationDefined)).append("\n");
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
