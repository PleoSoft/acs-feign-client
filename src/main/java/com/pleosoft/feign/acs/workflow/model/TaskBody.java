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
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

@Validated

public class TaskBody {
	@JsonProperty("name")
	private String name = null;

	@JsonProperty("description")
	private String description = null;

	@JsonProperty("dueAt")
	private Date dueAt = null;

	@JsonProperty("priority")
	private Integer priority = null;

	@JsonProperty("owner")
	private String owner = null;

	/**
	 * The state of this task
	 */
	public enum StateEnum {
		UNCLAIMED("unclaimed"),

		CLAIMED("claimed"),

		COMPLETED("completed"),

		RESOLVED("resolved");

		private String value;

		StateEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static StateEnum fromValue(String text) {
			for (StateEnum b : StateEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("state")
	private StateEnum state = null;

	@JsonProperty("variables")
	@Valid
	private List<Variable> variables = null;

	public TaskBody name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * The text name of this task
	 * 
	 * @return name
	 **/

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TaskBody description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * The description of this task
	 * 
	 * @return description
	 **/

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TaskBody dueAt(Date dueAt) {
		this.dueAt = dueAt;
		return this;
	}

	/**
	 * The date time this task is due
	 * 
	 * @return dueAt
	 **/

	@Valid

	public Date getDueAt() {
		return dueAt;
	}

	public void setDueAt(Date dueAt) {
		this.dueAt = dueAt;
	}

	public TaskBody priority(Integer priority) {
		this.priority = priority;
		return this;
	}

	/**
	 * The numeric priority of this task
	 * 
	 * @return priority
	 **/

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public TaskBody owner(String owner) {
		this.owner = owner;
		return this;
	}

	/**
	 * The id of the user who owns this task
	 * 
	 * @return owner
	 **/

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public TaskBody state(StateEnum state) {
		this.state = state;
		return this;
	}

	/**
	 * The state of this task
	 * 
	 * @return state
	 **/

	public StateEnum getState() {
		return state;
	}

	public void setState(StateEnum state) {
		this.state = state;
	}

	public TaskBody variables(List<Variable> variables) {
		this.variables = variables;
		return this;
	}

	public TaskBody addVariablesItem(Variable variablesItem) {
		if (this.variables == null) {
			this.variables = new ArrayList<Variable>();
		}
		this.variables.add(variablesItem);
		return this;
	}

	/**
	 * An array of variables for this task
	 * 
	 * @return variables
	 **/

	@Valid

	public List<Variable> getVariables() {
		return variables;
	}

	public void setVariables(List<Variable> variables) {
		this.variables = variables;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		TaskBody taskBody = (TaskBody) o;
		return Objects.equals(this.name, taskBody.name) && Objects.equals(this.description, taskBody.description)
				&& Objects.equals(this.dueAt, taskBody.dueAt) && Objects.equals(this.priority, taskBody.priority)
				&& Objects.equals(this.owner, taskBody.owner) && Objects.equals(this.state, taskBody.state)
				&& Objects.equals(this.variables, taskBody.variables);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, description, dueAt, priority, owner, state, variables);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class TaskBody {\n");

		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    dueAt: ").append(toIndentedString(dueAt)).append("\n");
		sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
		sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
		sb.append("    state: ").append(toIndentedString(state)).append("\n");
		sb.append("    variables: ").append(toIndentedString(variables)).append("\n");
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
