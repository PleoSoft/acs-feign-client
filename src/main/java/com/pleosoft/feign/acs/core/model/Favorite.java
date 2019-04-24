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

public class Favorite {
	@JsonProperty("targetGuid")
	private String targetGuid = null;

	@JsonProperty("createdAt")
	private Date createdAt = null;

	@JsonProperty("target")
	private Object target = null;

	public Favorite targetGuid(String targetGuid) {
		this.targetGuid = targetGuid;
		return this;
	}

	/**
	 * The guid of the object that is a favorite.
	 * 
	 * @return targetGuid
	 **/
	@NotNull

	public String getTargetGuid() {
		return targetGuid;
	}

	public void setTargetGuid(String targetGuid) {
		this.targetGuid = targetGuid;
	}

	public Favorite createdAt(Date createdAt) {
		this.createdAt = createdAt;
		return this;
	}

	/**
	 * The time the object was made a favorite.
	 * 
	 * @return createdAt
	 **/

	@Valid

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Favorite target(Object target) {
		this.target = target;
		return this;
	}

	/**
	 * Get target
	 * 
	 * @return target
	 **/
	@NotNull

	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Favorite favorite = (Favorite) o;
		return Objects.equals(this.targetGuid, favorite.targetGuid)
				&& Objects.equals(this.createdAt, favorite.createdAt) && Objects.equals(this.target, favorite.target);
	}

	@Override
	public int hashCode() {
		return Objects.hash(targetGuid, createdAt, target);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Favorite {\n");

		sb.append("    targetGuid: ").append(toIndentedString(targetGuid)).append("\n");
		sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
		sb.append("    target: ").append(toIndentedString(target)).append("\n");
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
