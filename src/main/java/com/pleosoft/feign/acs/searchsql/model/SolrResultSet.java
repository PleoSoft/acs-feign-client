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

package com.pleosoft.feign.acs.searchsql.model;

import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

@Validated

public class SolrResultSet {
	@JsonProperty("result-set")
	private Docs resultSet = null;

	public SolrResultSet resultSet(Docs resultSet) {
		this.resultSet = resultSet;
		return this;
	}

	/**
	 * Get resultSet
	 * 
	 * @return resultSet
	 **/

	@Valid

	public Docs getResultSet() {
		return resultSet;
	}

	public void setResultSet(Docs resultSet) {
		this.resultSet = resultSet;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		SolrResultSet solrResultSet = (SolrResultSet) o;
		return Objects.equals(this.resultSet, solrResultSet.resultSet);
	}

	@Override
	public int hashCode() {
		return Objects.hash(resultSet);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class SolrResultSet {\n");

		sb.append("    resultSet: ").append(toIndentedString(resultSet)).append("\n");
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
