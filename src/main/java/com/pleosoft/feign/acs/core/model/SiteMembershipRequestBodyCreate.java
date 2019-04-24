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

public class SiteMembershipRequestBodyCreate {
	@JsonProperty("message")
	private String message = null;

	@JsonProperty("id")
	private String id = null;

	@JsonProperty("title")
	private String title = null;

	public SiteMembershipRequestBodyCreate message(String message) {
		this.message = message;
		return this;
	}

	/**
	 * Get message
	 * 
	 * @return message
	 **/

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public SiteMembershipRequestBodyCreate id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
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

	public SiteMembershipRequestBodyCreate title(String title) {
		this.title = title;
		return this;
	}

	/**
	 * Get title
	 * 
	 * @return title
	 **/

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		SiteMembershipRequestBodyCreate siteMembershipRequestBodyCreate = (SiteMembershipRequestBodyCreate) o;
		return Objects.equals(this.message, siteMembershipRequestBodyCreate.message)
				&& Objects.equals(this.id, siteMembershipRequestBodyCreate.id)
				&& Objects.equals(this.title, siteMembershipRequestBodyCreate.title);
	}

	@Override
	public int hashCode() {
		return Objects.hash(message, id, title);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class SiteMembershipRequestBodyCreate {\n");

		sb.append("    message: ").append(toIndentedString(message)).append("\n");
		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    title: ").append(toIndentedString(title)).append("\n");
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
