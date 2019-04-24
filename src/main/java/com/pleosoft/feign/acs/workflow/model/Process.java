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
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

@Validated

public class Process {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("processDefinitionId")
	private String processDefinitionId = null;

	@JsonProperty("businessKey")
	private String businessKey = null;

	@JsonProperty("startedAt")
	private Date startedAt = null;

	@JsonProperty("endedAt")
	private Date endedAt = null;

	@JsonProperty("durationInMs")
	private Integer durationInMs = null;

	@JsonProperty("startActivityDefinitionId")
	private String startActivityDefinitionId = null;

	@JsonProperty("endActivityDefinitionId")
	private String endActivityDefinitionId = null;

	@JsonProperty("startUserId")
	private String startUserId = null;

	@JsonProperty("deleteReason")
	private String deleteReason = null;

	public Process id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * The unique id of this process
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

	public Process processDefinitionId(String processDefinitionId) {
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

	public Process businessKey(String businessKey) {
		this.businessKey = businessKey;
		return this;
	}

	/**
	 * The business key
	 * 
	 * @return businessKey
	 **/

	public String getBusinessKey() {
		return businessKey;
	}

	public void setBusinessKey(String businessKey) {
		this.businessKey = businessKey;
	}

	public Process startedAt(Date startedAt) {
		this.startedAt = startedAt;
		return this;
	}

	/**
	 * The date time this process started
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

	public Process endedAt(Date endedAt) {
		this.endedAt = endedAt;
		return this;
	}

	/**
	 * The date time this process started
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

	public Process durationInMs(Integer durationInMs) {
		this.durationInMs = durationInMs;
		return this;
	}

	/**
	 * The duration of this process
	 * 
	 * @return durationInMs
	 **/

	public Integer getDurationInMs() {
		return durationInMs;
	}

	public void setDurationInMs(Integer durationInMs) {
		this.durationInMs = durationInMs;
	}

	public Process startActivityDefinitionId(String startActivityDefinitionId) {
		this.startActivityDefinitionId = startActivityDefinitionId;
		return this;
	}

	/**
	 * The id of the first activity in the process
	 * 
	 * @return startActivityDefinitionId
	 **/

	public String getStartActivityDefinitionId() {
		return startActivityDefinitionId;
	}

	public void setStartActivityDefinitionId(String startActivityDefinitionId) {
		this.startActivityDefinitionId = startActivityDefinitionId;
	}

	public Process endActivityDefinitionId(String endActivityDefinitionId) {
		this.endActivityDefinitionId = endActivityDefinitionId;
		return this;
	}

	/**
	 * The id of the last activity in the process
	 * 
	 * @return endActivityDefinitionId
	 **/

	public String getEndActivityDefinitionId() {
		return endActivityDefinitionId;
	}

	public void setEndActivityDefinitionId(String endActivityDefinitionId) {
		this.endActivityDefinitionId = endActivityDefinitionId;
	}

	public Process startUserId(String startUserId) {
		this.startUserId = startUserId;
		return this;
	}

	/**
	 * The id of the user who started the process
	 * 
	 * @return startUserId
	 **/

	public String getStartUserId() {
		return startUserId;
	}

	public void setStartUserId(String startUserId) {
		this.startUserId = startUserId;
	}

	public Process deleteReason(String deleteReason) {
		this.deleteReason = deleteReason;
		return this;
	}

	/**
	 * The reason this process was canceled
	 * 
	 * @return deleteReason
	 **/

	public String getDeleteReason() {
		return deleteReason;
	}

	public void setDeleteReason(String deleteReason) {
		this.deleteReason = deleteReason;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Process process = (Process) o;
		return Objects.equals(this.id, process.id)
				&& Objects.equals(this.processDefinitionId, process.processDefinitionId)
				&& Objects.equals(this.businessKey, process.businessKey)
				&& Objects.equals(this.startedAt, process.startedAt) && Objects.equals(this.endedAt, process.endedAt)
				&& Objects.equals(this.durationInMs, process.durationInMs)
				&& Objects.equals(this.startActivityDefinitionId, process.startActivityDefinitionId)
				&& Objects.equals(this.endActivityDefinitionId, process.endActivityDefinitionId)
				&& Objects.equals(this.startUserId, process.startUserId)
				&& Objects.equals(this.deleteReason, process.deleteReason);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, processDefinitionId, businessKey, startedAt, endedAt, durationInMs,
				startActivityDefinitionId, endActivityDefinitionId, startUserId, deleteReason);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Process {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    processDefinitionId: ").append(toIndentedString(processDefinitionId)).append("\n");
		sb.append("    businessKey: ").append(toIndentedString(businessKey)).append("\n");
		sb.append("    startedAt: ").append(toIndentedString(startedAt)).append("\n");
		sb.append("    endedAt: ").append(toIndentedString(endedAt)).append("\n");
		sb.append("    durationInMs: ").append(toIndentedString(durationInMs)).append("\n");
		sb.append("    startActivityDefinitionId: ").append(toIndentedString(startActivityDefinitionId)).append("\n");
		sb.append("    endActivityDefinitionId: ").append(toIndentedString(endActivityDefinitionId)).append("\n");
		sb.append("    startUserId: ").append(toIndentedString(startUserId)).append("\n");
		sb.append("    deleteReason: ").append(toIndentedString(deleteReason)).append("\n");
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
