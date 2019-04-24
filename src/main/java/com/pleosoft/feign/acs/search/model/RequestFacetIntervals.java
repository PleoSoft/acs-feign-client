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

public class RequestFacetIntervals {
	@JsonProperty("sets")
	@Valid
	private List<RequestFacetSet> sets = null;

	@JsonProperty("intervals")
	@Valid
	private List<RequestFacetIntervalsIntervals> intervals = null;

	public RequestFacetIntervals sets(List<RequestFacetSet> sets) {
		this.sets = sets;
		return this;
	}

	public RequestFacetIntervals addSetsItem(RequestFacetSet setsItem) {
		if (this.sets == null) {
			this.sets = new ArrayList<RequestFacetSet>();
		}
		this.sets.add(setsItem);
		return this;
	}

	/**
	 * Sets the intervals for all fields.
	 * 
	 * @return sets
	 **/

	@Valid

	public List<RequestFacetSet> getSets() {
		return sets;
	}

	public void setSets(List<RequestFacetSet> sets) {
		this.sets = sets;
	}

	public RequestFacetIntervals intervals(List<RequestFacetIntervalsIntervals> intervals) {
		this.intervals = intervals;
		return this;
	}

	public RequestFacetIntervals addIntervalsItem(RequestFacetIntervalsIntervals intervalsItem) {
		if (this.intervals == null) {
			this.intervals = new ArrayList<RequestFacetIntervalsIntervals>();
		}
		this.intervals.add(intervalsItem);
		return this;
	}

	/**
	 * Specifies the fields to facet by interval.
	 * 
	 * @return intervals
	 **/

	@Valid

	public List<RequestFacetIntervalsIntervals> getIntervals() {
		return intervals;
	}

	public void setIntervals(List<RequestFacetIntervalsIntervals> intervals) {
		this.intervals = intervals;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		RequestFacetIntervals requestFacetIntervals = (RequestFacetIntervals) o;
		return Objects.equals(this.sets, requestFacetIntervals.sets)
				&& Objects.equals(this.intervals, requestFacetIntervals.intervals);
	}

	@Override
	public int hashCode() {
		return Objects.hash(sets, intervals);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class RequestFacetIntervals {\n");

		sb.append("    sets: ").append(toIndentedString(sets)).append("\n");
		sb.append("    intervals: ").append(toIndentedString(intervals)).append("\n");
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
