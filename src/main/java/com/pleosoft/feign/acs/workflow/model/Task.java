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
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

@Validated

public class Task {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("processId")
	private String processId = null;

	@JsonProperty("processDefinitionId")
	private String processDefinitionId = null;

	@JsonProperty("activityDefinitionId")
	private String activityDefinitionId = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("description")
	private String description = null;

	@JsonProperty("dueAt")
	private Date dueAt = null;

	@JsonProperty("startedAt")
	private Date startedAt = null;

	@JsonProperty("endedAt")
	private Date endedAt = null;

	@JsonProperty("durationInMs")
	private Integer durationInMs = null;

	@JsonProperty("priority")
	private Integer priority = null;

	@JsonProperty("owner")
	private String owner = null;

	@JsonProperty("assignee")
	private String assignee = null;

	@JsonProperty("formResourceKey")
	private String formResourceKey = null;

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

	public Task id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * The unique id of this task
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

	public Task processId(String processId) {
		this.processId = processId;
		return this;
	}

	/**
	 * The containing process's unique id
	 * 
	 * @return processId
	 **/

	public String getProcessId() {
		return processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}

	public Task processDefinitionId(String processDefinitionId) {
		this.processDefinitionId = processDefinitionId;
		return this;
	}

	/**
	 * The unique identity of the owning process definition
	 * 
	 * @return processDefinitionId
	 **/

	public String getProcessDefinitionId() {
		return processDefinitionId;
	}

	public void setProcessDefinitionId(String processDefinitionId) {
		this.processDefinitionId = processDefinitionId;
	}

	public Task activityDefinitionId(String activityDefinitionId) {
		this.activityDefinitionId = activityDefinitionId;
		return this;
	}

	/**
	 * The activity id of this task
	 * 
	 * @return activityDefinitionId
	 **/

	public String getActivityDefinitionId() {
		return activityDefinitionId;
	}

	public void setActivityDefinitionId(String activityDefinitionId) {
		this.activityDefinitionId = activityDefinitionId;
	}

	public Task name(String name) {
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

	public Task description(String description) {
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

	public Task dueAt(Date dueAt) {
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

	public Task startedAt(Date startedAt) {
		this.startedAt = startedAt;
		return this;
	}

	/**
	 * The date time this task started
	 * 
	 * @return startedAt
	 **/

	@Valid

	public Date getStartedAt() {
		return startedAt;
	}

	public void setStartedAt(Date startedAt) {
		this.startedAt = startedAt;
	}

	public Task endedAt(Date endedAt) {
		this.endedAt = endedAt;
		return this;
	}

	/**
	 * The date time this task started
	 * 
	 * @return endedAt
	 **/

	@Valid

	public Date getEndedAt() {
		return endedAt;
	}

	public void setEndedAt(Date endedAt) {
		this.endedAt = endedAt;
	}

	public Task durationInMs(Integer durationInMs) {
		this.durationInMs = durationInMs;
		return this;
	}

	/**
	 * The duration of this task
	 * 
	 * @return durationInMs
	 **/

	public Integer getDurationInMs() {
		return durationInMs;
	}

	public void setDurationInMs(Integer durationInMs) {
		this.durationInMs = durationInMs;
	}

	public Task priority(Integer priority) {
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

	public Task owner(String owner) {
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

	public Task assignee(String assignee) {
		this.assignee = assignee;
		return this;
	}

	/**
	 * The id of the user who is currently assigned this task
	 * 
	 * @return assignee
	 **/

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public Task formResourceKey(String formResourceKey) {
		this.formResourceKey = formResourceKey;
		return this;
	}

	/**
	 * The key of the form for this task
	 * 
	 * @return formResourceKey
	 **/

	public String getFormResourceKey() {
		return formResourceKey;
	}

	public void setFormResourceKey(String formResourceKey) {
		this.formResourceKey = formResourceKey;
	}

	public Task state(StateEnum state) {
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

	public Task variables(List<Variable> variables) {
		this.variables = variables;
		return this;
	}

	public Task addVariablesItem(Variable variablesItem) {
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
		Task task = (Task) o;
		return Objects.equals(this.id, task.id) && Objects.equals(this.processId, task.processId)
				&& Objects.equals(this.processDefinitionId, task.processDefinitionId)
				&& Objects.equals(this.activityDefinitionId, task.activityDefinitionId)
				&& Objects.equals(this.name, task.name) && Objects.equals(this.description, task.description)
				&& Objects.equals(this.dueAt, task.dueAt) && Objects.equals(this.startedAt, task.startedAt)
				&& Objects.equals(this.endedAt, task.endedAt) && Objects.equals(this.durationInMs, task.durationInMs)
				&& Objects.equals(this.priority, task.priority) && Objects.equals(this.owner, task.owner)
				&& Objects.equals(this.assignee, task.assignee)
				&& Objects.equals(this.formResourceKey, task.formResourceKey) && Objects.equals(this.state, task.state)
				&& Objects.equals(this.variables, task.variables);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, processId, processDefinitionId, activityDefinitionId, name, description, dueAt,
				startedAt, endedAt, durationInMs, priority, owner, assignee, formResourceKey, state, variables);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Task {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    processId: ").append(toIndentedString(processId)).append("\n");
		sb.append("    processDefinitionId: ").append(toIndentedString(processDefinitionId)).append("\n");
		sb.append("    activityDefinitionId: ").append(toIndentedString(activityDefinitionId)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    dueAt: ").append(toIndentedString(dueAt)).append("\n");
		sb.append("    startedAt: ").append(toIndentedString(startedAt)).append("\n");
		sb.append("    endedAt: ").append(toIndentedString(endedAt)).append("\n");
		sb.append("    durationInMs: ").append(toIndentedString(durationInMs)).append("\n");
		sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
		sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
		sb.append("    assignee: ").append(toIndentedString(assignee)).append("\n");
		sb.append("    formResourceKey: ").append(toIndentedString(formResourceKey)).append("\n");
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
