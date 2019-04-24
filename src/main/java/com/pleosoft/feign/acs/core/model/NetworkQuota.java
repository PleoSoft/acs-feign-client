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

public class NetworkQuota {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("limit")
	private Long limit = null;

	@JsonProperty("usage")
	private Long usage = null;

	public NetworkQuota id(String id) {
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

	public NetworkQuota limit(Long limit) {
		this.limit = limit;
		return this;
	}

	/**
	 * Get limit
	 * 
	 * @return limit
	 **/
	@NotNull

	public Long getLimit() {
		return limit;
	}

	public void setLimit(Long limit) {
		this.limit = limit;
	}

	public NetworkQuota usage(Long usage) {
		this.usage = usage;
		return this;
	}

	/**
	 * Get usage
	 * 
	 * @return usage
	 **/
	@NotNull

	public Long getUsage() {
		return usage;
	}

	public void setUsage(Long usage) {
		this.usage = usage;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		NetworkQuota networkQuota = (NetworkQuota) o;
		return Objects.equals(this.id, networkQuota.id) && Objects.equals(this.limit, networkQuota.limit)
				&& Objects.equals(this.usage, networkQuota.usage);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, limit, usage);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class NetworkQuota {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
		sb.append("    usage: ").append(toIndentedString(usage)).append("\n");
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
