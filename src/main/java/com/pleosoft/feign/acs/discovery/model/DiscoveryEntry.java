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

package com.pleosoft.feign.acs.discovery.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

@Validated

public class DiscoveryEntry {
	@JsonProperty("entry")
	private RepositoryEntry entry = null;

	public DiscoveryEntry entry(RepositoryEntry entry) {
		this.entry = entry;
		return this;
	}

	/**
	 * Get entry
	 * 
	 * @return entry
	 **/
	@NotNull

	@Valid

	public RepositoryEntry getEntry() {
		return entry;
	}

	public void setEntry(RepositoryEntry entry) {
		this.entry = entry;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		DiscoveryEntry discoveryEntry = (DiscoveryEntry) o;
		return Objects.equals(this.entry, discoveryEntry.entry);
	}

	@Override
	public int hashCode() {
		return Objects.hash(entry);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class DiscoveryEntry {\n");

		sb.append("    entry: ").append(toIndentedString(entry)).append("\n");
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
