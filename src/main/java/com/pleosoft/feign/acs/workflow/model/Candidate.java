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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

@Validated

public class Candidate {
	/**
	 * Gets or Sets candidateType
	 */
	public enum CandidateTypeEnum {
		USER("user"),

		GROUP("group");

		private String value;

		CandidateTypeEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static CandidateTypeEnum fromValue(String text) {
			for (CandidateTypeEnum b : CandidateTypeEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("candidateType")
	private CandidateTypeEnum candidateType = null;

	@JsonProperty("candidateId")
	private String candidateId = null;

	public Candidate candidateType(CandidateTypeEnum candidateType) {
		this.candidateType = candidateType;
		return this;
	}

	/**
	 * Get candidateType
	 * 
	 * @return candidateType
	 **/

	public CandidateTypeEnum getCandidateType() {
		return candidateType;
	}

	public void setCandidateType(CandidateTypeEnum candidateType) {
		this.candidateType = candidateType;
	}

	public Candidate candidateId(String candidateId) {
		this.candidateId = candidateId;
		return this;
	}

	/**
	 * Get candidateId
	 * 
	 * @return candidateId
	 **/

	public String getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Candidate candidate = (Candidate) o;
		return Objects.equals(this.candidateType, candidate.candidateType)
				&& Objects.equals(this.candidateId, candidate.candidateId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(candidateType, candidateId);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Candidate {\n");

		sb.append("    candidateType: ").append(toIndentedString(candidateType)).append("\n");
		sb.append("    candidateId: ").append(toIndentedString(candidateId)).append("\n");
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
