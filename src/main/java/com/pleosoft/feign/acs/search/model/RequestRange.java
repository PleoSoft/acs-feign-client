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

public class RequestRange {
	@JsonProperty("field")
	private String field = null;

	@JsonProperty("start")
	private String start = null;

	@JsonProperty("end")
	private String end = null;

	@JsonProperty("gap")
	private String gap = null;

	@JsonProperty("hardend")
	private Boolean hardend = null;

	@JsonProperty("other")
	@Valid
	private List<String> other = null;

	@JsonProperty("include")
	@Valid
	private List<String> include = null;

	@JsonProperty("label")
	private String label = null;

	@JsonProperty("excludeFilters")
	@Valid
	private List<String> excludeFilters = null;

	public RequestRange field(String field) {
		this.field = field;
		return this;
	}

	/**
	 * The name of the field to perform range
	 * 
	 * @return field
	 **/

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public RequestRange start(String start) {
		this.start = start;
		return this;
	}

	/**
	 * The start of the range
	 * 
	 * @return start
	 **/

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public RequestRange end(String end) {
		this.end = end;
		return this;
	}

	/**
	 * The end of the range
	 * 
	 * @return end
	 **/

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public RequestRange gap(String gap) {
		this.gap = gap;
		return this;
	}

	/**
	 * Bucket size
	 * 
	 * @return gap
	 **/

	public String getGap() {
		return gap;
	}

	public void setGap(String gap) {
		this.gap = gap;
	}

	public RequestRange hardend(Boolean hardend) {
		this.hardend = hardend;
		return this;
	}

	/**
	 * If true means that the last bucket will end at “end” even if it is less than
	 * “gap” wide.
	 * 
	 * @return hardend
	 **/

	public Boolean isHardend() {
		return hardend;
	}

	public void setHardend(Boolean hardend) {
		this.hardend = hardend;
	}

	public RequestRange other(List<String> other) {
		this.other = other;
		return this;
	}

	public RequestRange addOtherItem(String otherItem) {
		if (this.other == null) {
			this.other = new ArrayList<String>();
		}
		this.other.add(otherItem);
		return this;
	}

	/**
	 * before, after, between, non, all
	 * 
	 * @return other
	 **/

	public List<String> getOther() {
		return other;
	}

	public void setOther(List<String> other) {
		this.other = other;
	}

	public RequestRange include(List<String> include) {
		this.include = include;
		return this;
	}

	public RequestRange addIncludeItem(String includeItem) {
		if (this.include == null) {
			this.include = new ArrayList<String>();
		}
		this.include.add(includeItem);
		return this;
	}

	/**
	 * lower, upper, edge, outer, all
	 * 
	 * @return include
	 **/

	public List<String> getInclude() {
		return include;
	}

	public void setInclude(List<String> include) {
		this.include = include;
	}

	public RequestRange label(String label) {
		this.label = label;
		return this;
	}

	/**
	 * A label to include as a pivot reference
	 * 
	 * @return label
	 **/

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public RequestRange excludeFilters(List<String> excludeFilters) {
		this.excludeFilters = excludeFilters;
		return this;
	}

	public RequestRange addExcludeFiltersItem(String excludeFiltersItem) {
		if (this.excludeFilters == null) {
			this.excludeFilters = new ArrayList<String>();
		}
		this.excludeFilters.add(excludeFiltersItem);
		return this;
	}

	/**
	 * Filter queries to exclude when calculating statistics
	 * 
	 * @return excludeFilters
	 **/

	public List<String> getExcludeFilters() {
		return excludeFilters;
	}

	public void setExcludeFilters(List<String> excludeFilters) {
		this.excludeFilters = excludeFilters;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		RequestRange requestRange = (RequestRange) o;
		return Objects.equals(this.field, requestRange.field) && Objects.equals(this.start, requestRange.start)
				&& Objects.equals(this.end, requestRange.end) && Objects.equals(this.gap, requestRange.gap)
				&& Objects.equals(this.hardend, requestRange.hardend) && Objects.equals(this.other, requestRange.other)
				&& Objects.equals(this.include, requestRange.include) && Objects.equals(this.label, requestRange.label)
				&& Objects.equals(this.excludeFilters, requestRange.excludeFilters);
	}

	@Override
	public int hashCode() {
		return Objects.hash(field, start, end, gap, hardend, other, include, label, excludeFilters);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class RequestRange {\n");

		sb.append("    field: ").append(toIndentedString(field)).append("\n");
		sb.append("    start: ").append(toIndentedString(start)).append("\n");
		sb.append("    end: ").append(toIndentedString(end)).append("\n");
		sb.append("    gap: ").append(toIndentedString(gap)).append("\n");
		sb.append("    hardend: ").append(toIndentedString(hardend)).append("\n");
		sb.append("    other: ").append(toIndentedString(other)).append("\n");
		sb.append("    include: ").append(toIndentedString(include)).append("\n");
		sb.append("    label: ").append(toIndentedString(label)).append("\n");
		sb.append("    excludeFilters: ").append(toIndentedString(excludeFilters)).append("\n");
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
