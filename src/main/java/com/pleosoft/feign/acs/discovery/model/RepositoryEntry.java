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

public class RepositoryEntry {
	@JsonProperty("repository")
	private RepositoryInfo repository = null;

	public RepositoryEntry repository(RepositoryInfo repository) {
		this.repository = repository;
		return this;
	}

	/**
	 * Get repository
	 * 
	 * @return repository
	 **/
	@NotNull

	@Valid

	public RepositoryInfo getRepository() {
		return repository;
	}

	public void setRepository(RepositoryInfo repository) {
		this.repository = repository;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		RepositoryEntry repositoryEntry = (RepositoryEntry) o;
		return Objects.equals(this.repository, repositoryEntry.repository);
	}

	@Override
	public int hashCode() {
		return Objects.hash(repository);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class RepositoryEntry {\n");

		sb.append("    repository: ").append(toIndentedString(repository)).append("\n");
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
