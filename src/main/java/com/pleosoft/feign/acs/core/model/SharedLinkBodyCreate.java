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

import java.util.Date;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

@Validated

public class SharedLinkBodyCreate {
	@JsonProperty("nodeId")
	private String nodeId = null;

	@JsonProperty("expiresAt")
	private Date expiresAt = null;

	public SharedLinkBodyCreate nodeId(String nodeId) {
		this.nodeId = nodeId;
		return this;
	}

	/**
	 * Get nodeId
	 * 
	 * @return nodeId
	 **/
	@NotNull

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public SharedLinkBodyCreate expiresAt(Date expiresAt) {
		this.expiresAt = expiresAt;
		return this;
	}

	/**
	 * Get expiresAt
	 * 
	 * @return expiresAt
	 **/

	@Valid

	public Date getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(Date expiresAt) {
		this.expiresAt = expiresAt;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		SharedLinkBodyCreate sharedLinkBodyCreate = (SharedLinkBodyCreate) o;
		return Objects.equals(this.nodeId, sharedLinkBodyCreate.nodeId)
				&& Objects.equals(this.expiresAt, sharedLinkBodyCreate.expiresAt);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nodeId, expiresAt);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class SharedLinkBodyCreate {\n");

		sb.append("    nodeId: ").append(toIndentedString(nodeId)).append("\n");
		sb.append("    expiresAt: ").append(toIndentedString(expiresAt)).append("\n");
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
