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

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

@Validated

public class Association {
	@JsonProperty("targetId")
	private String targetId = null;

	@JsonProperty("assocType")
	private String assocType = null;

	public Association targetId(String targetId) {
		this.targetId = targetId;
		return this;
	}

	/**
	 * Get targetId
	 * 
	 * @return targetId
	 **/
	@NotNull

	public String getTargetId() {
		return targetId;
	}

	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}

	public Association assocType(String assocType) {
		this.assocType = assocType;
		return this;
	}

	/**
	 * Get assocType
	 * 
	 * @return assocType
	 **/
	@NotNull

	public String getAssocType() {
		return assocType;
	}

	public void setAssocType(String assocType) {
		this.assocType = assocType;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Association association = (Association) o;
		return Objects.equals(this.targetId, association.targetId)
				&& Objects.equals(this.assocType, association.assocType);
	}

	@Override
	public int hashCode() {
		return Objects.hash(targetId, assocType);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Association {\n");

		sb.append("    targetId: ").append(toIndentedString(targetId)).append("\n");
		sb.append("    assocType: ").append(toIndentedString(assocType)).append("\n");
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
