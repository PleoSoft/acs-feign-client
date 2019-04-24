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

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

@Validated

public class ProcessBody {
	@JsonProperty("processDefinitionKey")
	private String processDefinitionKey = null;

	@JsonProperty("variables")
	private ProcessBodyVariable variables = null;

	public ProcessBody processDefinitionKey(String processDefinitionKey) {
		this.processDefinitionKey = processDefinitionKey;
		return this;
	}

	/**
	 * Get processDefinitionKey
	 * 
	 * @return processDefinitionKey
	 **/

	public String getProcessDefinitionKey() {
		return processDefinitionKey;
	}

	public void setProcessDefinitionKey(String processDefinitionKey) {
		this.processDefinitionKey = processDefinitionKey;
	}

	public ProcessBody variables(ProcessBodyVariable variables) {
		this.variables = variables;
		return this;
	}

	/**
	 * Get variables
	 * 
	 * @return variables
	 **/

	@Valid

	public ProcessBodyVariable getVariables() {
		return variables;
	}

	public void setVariables(ProcessBodyVariable variables) {
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
		ProcessBody processBody = (ProcessBody) o;
		return Objects.equals(this.processDefinitionKey, processBody.processDefinitionKey)
				&& Objects.equals(this.variables, processBody.variables);
	}

	@Override
	public int hashCode() {
		return Objects.hash(processDefinitionKey, variables);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ProcessBody {\n");

		sb.append("    processDefinitionKey: ").append(toIndentedString(processDefinitionKey)).append("\n");
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
