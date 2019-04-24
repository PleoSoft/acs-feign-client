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

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

@Validated

public class ProcessBodyVariable {
	@JsonProperty("bpm_assignee")
	private String bpmAssignee = null;

	@JsonProperty("bpm_sendEMailNotifications")
	private Boolean bpmSendEMailNotifications = null;

	@JsonProperty("bpm_workflowPriority")
	private Integer bpmWorkflowPriority = null;

	public ProcessBodyVariable bpmAssignee(String bpmAssignee) {
		this.bpmAssignee = bpmAssignee;
		return this;
	}

	/**
	 * Get bpmAssignee
	 * 
	 * @return bpmAssignee
	 **/

	public String getBpmAssignee() {
		return bpmAssignee;
	}

	public void setBpmAssignee(String bpmAssignee) {
		this.bpmAssignee = bpmAssignee;
	}

	public ProcessBodyVariable bpmSendEMailNotifications(Boolean bpmSendEMailNotifications) {
		this.bpmSendEMailNotifications = bpmSendEMailNotifications;
		return this;
	}

	/**
	 * Get bpmSendEMailNotifications
	 * 
	 * @return bpmSendEMailNotifications
	 **/

	public Boolean isBpmSendEMailNotifications() {
		return bpmSendEMailNotifications;
	}

	public void setBpmSendEMailNotifications(Boolean bpmSendEMailNotifications) {
		this.bpmSendEMailNotifications = bpmSendEMailNotifications;
	}

	public ProcessBodyVariable bpmWorkflowPriority(Integer bpmWorkflowPriority) {
		this.bpmWorkflowPriority = bpmWorkflowPriority;
		return this;
	}

	/**
	 * Get bpmWorkflowPriority
	 * 
	 * @return bpmWorkflowPriority
	 **/

	public Integer getBpmWorkflowPriority() {
		return bpmWorkflowPriority;
	}

	public void setBpmWorkflowPriority(Integer bpmWorkflowPriority) {
		this.bpmWorkflowPriority = bpmWorkflowPriority;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ProcessBodyVariable processBodyVariable = (ProcessBodyVariable) o;
		return Objects.equals(this.bpmAssignee, processBodyVariable.bpmAssignee)
				&& Objects.equals(this.bpmSendEMailNotifications, processBodyVariable.bpmSendEMailNotifications)
				&& Objects.equals(this.bpmWorkflowPriority, processBodyVariable.bpmWorkflowPriority);
	}

	@Override
	public int hashCode() {
		return Objects.hash(bpmAssignee, bpmSendEMailNotifications, bpmWorkflowPriority);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ProcessBodyVariable {\n");

		sb.append("    bpmAssignee: ").append(toIndentedString(bpmAssignee)).append("\n");
		sb.append("    bpmSendEMailNotifications: ").append(toIndentedString(bpmSendEMailNotifications)).append("\n");
		sb.append("    bpmWorkflowPriority: ").append(toIndentedString(bpmWorkflowPriority)).append("\n");
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
