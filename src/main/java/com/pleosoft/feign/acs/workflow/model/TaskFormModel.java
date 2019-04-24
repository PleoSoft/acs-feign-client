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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

@Validated

public class TaskFormModel {
	@JsonProperty("dataType")
	private String dataType = null;

	@JsonProperty("title")
	private String title = null;

	@JsonProperty("qualifiedName")
	private String qualifiedName = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("required")
	private Boolean required = null;

	@JsonProperty("defaultValue")
	private String defaultValue = null;

	@JsonProperty("allowedValues")
	@Valid
	private List<String> allowedValues = null;

	public TaskFormModel dataType(String dataType) {
		this.dataType = dataType;
		return this;
	}

	/**
	 * Get dataType
	 * 
	 * @return dataType
	 **/

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public TaskFormModel title(String title) {
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

	public TaskFormModel qualifiedName(String qualifiedName) {
		this.qualifiedName = qualifiedName;
		return this;
	}

	/**
	 * Get qualifiedName
	 * 
	 * @return qualifiedName
	 **/

	public String getQualifiedName() {
		return qualifiedName;
	}

	public void setQualifiedName(String qualifiedName) {
		this.qualifiedName = qualifiedName;
	}

	public TaskFormModel name(String name) {
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

	public TaskFormModel required(Boolean required) {
		this.required = required;
		return this;
	}

	/**
	 * Get required
	 * 
	 * @return required
	 **/

	public Boolean isRequired() {
		return required;
	}

	public void setRequired(Boolean required) {
		this.required = required;
	}

	public TaskFormModel defaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
		return this;
	}

	/**
	 * Get defaultValue
	 * 
	 * @return defaultValue
	 **/

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public TaskFormModel allowedValues(List<String> allowedValues) {
		this.allowedValues = allowedValues;
		return this;
	}

	public TaskFormModel addAllowedValuesItem(String allowedValuesItem) {
		if (this.allowedValues == null) {
			this.allowedValues = new ArrayList<String>();
		}
		this.allowedValues.add(allowedValuesItem);
		return this;
	}

	/**
	 * An array of allowed values for this item
	 * 
	 * @return allowedValues
	 **/

	public List<String> getAllowedValues() {
		return allowedValues;
	}

	public void setAllowedValues(List<String> allowedValues) {
		this.allowedValues = allowedValues;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		TaskFormModel taskFormModel = (TaskFormModel) o;
		return Objects.equals(this.dataType, taskFormModel.dataType) && Objects.equals(this.title, taskFormModel.title)
				&& Objects.equals(this.qualifiedName, taskFormModel.qualifiedName)
				&& Objects.equals(this.name, taskFormModel.name)
				&& Objects.equals(this.required, taskFormModel.required)
				&& Objects.equals(this.defaultValue, taskFormModel.defaultValue)
				&& Objects.equals(this.allowedValues, taskFormModel.allowedValues);
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataType, title, qualifiedName, name, required, defaultValue, allowedValues);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class TaskFormModel {\n");

		sb.append("    dataType: ").append(toIndentedString(dataType)).append("\n");
		sb.append("    title: ").append(toIndentedString(title)).append("\n");
		sb.append("    qualifiedName: ").append(toIndentedString(qualifiedName)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    required: ").append(toIndentedString(required)).append("\n");
		sb.append("    defaultValue: ").append(toIndentedString(defaultValue)).append("\n");
		sb.append("    allowedValues: ").append(toIndentedString(allowedValues)).append("\n");
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
