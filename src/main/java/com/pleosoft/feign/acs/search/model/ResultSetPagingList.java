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

package com.pleosoft.feign.acs.search.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

@Validated

public class ResultSetPagingList {
	@JsonProperty("pagination")
	private Pagination pagination = null;

	@JsonProperty("context")
	private ResultSetContext context = null;

	@JsonProperty("entries")
	@Valid
	private List<ResultSetRowEntry> entries = null;

	public ResultSetPagingList pagination(Pagination pagination) {
		this.pagination = pagination;
		return this;
	}

	/**
	 * Get pagination
	 * 
	 * @return pagination
	 **/

	@Valid

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public ResultSetPagingList context(ResultSetContext context) {
		this.context = context;
		return this;
	}

	/**
	 * Get context
	 * 
	 * @return context
	 **/

	@Valid

	public ResultSetContext getContext() {
		return context;
	}

	public void setContext(ResultSetContext context) {
		this.context = context;
	}

	public ResultSetPagingList entries(List<ResultSetRowEntry> entries) {
		this.entries = entries;
		return this;
	}

	public ResultSetPagingList addEntriesItem(ResultSetRowEntry entriesItem) {
		if (this.entries == null) {
			this.entries = new ArrayList<ResultSetRowEntry>();
		}
		this.entries.add(entriesItem);
		return this;
	}

	/**
	 * Get entries
	 * 
	 * @return entries
	 **/

	@Valid

	public List<ResultSetRowEntry> getEntries() {
		return entries;
	}

	public void setEntries(List<ResultSetRowEntry> entries) {
		this.entries = entries;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ResultSetPagingList resultSetPagingList = (ResultSetPagingList) o;
		return Objects.equals(this.pagination, resultSetPagingList.pagination)
				&& Objects.equals(this.context, resultSetPagingList.context)
				&& Objects.equals(this.entries, resultSetPagingList.entries);
	}

	@Override
	public int hashCode() {
		return Objects.hash(pagination, context, entries);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ResultSetPagingList {\n");

		sb.append("    pagination: ").append(toIndentedString(pagination)).append("\n");
		sb.append("    context: ").append(toIndentedString(context)).append("\n");
		sb.append("    entries: ").append(toIndentedString(entries)).append("\n");
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
