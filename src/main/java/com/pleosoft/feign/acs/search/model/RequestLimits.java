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

package com.pleosoft.feign.acs.search.model;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

@Validated

public class RequestLimits {
	@JsonProperty("permissionEvaluationTime")
	private Integer permissionEvaluationTime = null;

	@JsonProperty("permissionEvaluationCount")
	private Integer permissionEvaluationCount = null;

	public RequestLimits permissionEvaluationTime(Integer permissionEvaluationTime) {
		this.permissionEvaluationTime = permissionEvaluationTime;
		return this;
	}

	/**
	 * Maximum time for post query permission evaluation
	 * 
	 * @return permissionEvaluationTime
	 **/

	public Integer getPermissionEvaluationTime() {
		return permissionEvaluationTime;
	}

	public void setPermissionEvaluationTime(Integer permissionEvaluationTime) {
		this.permissionEvaluationTime = permissionEvaluationTime;
	}

	public RequestLimits permissionEvaluationCount(Integer permissionEvaluationCount) {
		this.permissionEvaluationCount = permissionEvaluationCount;
		return this;
	}

	/**
	 * Maximum count of post query permission evaluations
	 * 
	 * @return permissionEvaluationCount
	 **/

	public Integer getPermissionEvaluationCount() {
		return permissionEvaluationCount;
	}

	public void setPermissionEvaluationCount(Integer permissionEvaluationCount) {
		this.permissionEvaluationCount = permissionEvaluationCount;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		RequestLimits requestLimits = (RequestLimits) o;
		return Objects.equals(this.permissionEvaluationTime, requestLimits.permissionEvaluationTime)
				&& Objects.equals(this.permissionEvaluationCount, requestLimits.permissionEvaluationCount);
	}

	@Override
	public int hashCode() {
		return Objects.hash(permissionEvaluationTime, permissionEvaluationCount);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class RequestLimits {\n");

		sb.append("    permissionEvaluationTime: ").append(toIndentedString(permissionEvaluationTime)).append("\n");
		sb.append("    permissionEvaluationCount: ").append(toIndentedString(permissionEvaluationCount)).append("\n");
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
