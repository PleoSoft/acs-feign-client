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

public class SiteMembershipRequest {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("createdAt")
	private Date createdAt = null;

	@JsonProperty("site")
	private Site site = null;

	@JsonProperty("message")
	private String message = null;

	public SiteMembershipRequest id(String id) {
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

	public SiteMembershipRequest createdAt(Date createdAt) {
		this.createdAt = createdAt;
		return this;
	}

	/**
	 * Get createdAt
	 * 
	 * @return createdAt
	 **/
	@NotNull

	@Valid

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public SiteMembershipRequest site(Site site) {
		this.site = site;
		return this;
	}

	/**
	 * Get site
	 * 
	 * @return site
	 **/
	@NotNull

	@Valid

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public SiteMembershipRequest message(String message) {
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

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		SiteMembershipRequest siteMembershipRequest = (SiteMembershipRequest) o;
		return Objects.equals(this.id, siteMembershipRequest.id)
				&& Objects.equals(this.createdAt, siteMembershipRequest.createdAt)
				&& Objects.equals(this.site, siteMembershipRequest.site)
				&& Objects.equals(this.message, siteMembershipRequest.message);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, createdAt, site, message);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class SiteMembershipRequest {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
		sb.append("    site: ").append(toIndentedString(site)).append("\n");
		sb.append("    message: ").append(toIndentedString(message)).append("\n");
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
