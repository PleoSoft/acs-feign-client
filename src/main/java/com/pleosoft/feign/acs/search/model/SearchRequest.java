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
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

@Validated

public class SearchRequest {
	@JsonProperty("query")
	private RequestQuery query = null;

	@JsonProperty("paging")
	private RequestPagination paging = null;

	@JsonProperty("include")
	private RequestInclude include = null;

	@JsonProperty("includeRequest")
	private Boolean includeRequest = false;

	@JsonProperty("fields")
	private RequestFields fields = null;

	@JsonProperty("sort")
	private RequestSortDefinition sort = null;

	@JsonProperty("templates")
	private RequestTemplates templates = null;

	@JsonProperty("defaults")
	private RequestDefaults defaults = null;

	@JsonProperty("localization")
	private RequestLocalization localization = null;

	@JsonProperty("filterQueries")
	private RequestFilterQueries filterQueries = null;

	@JsonProperty("facetQueries")
	private RequestFacetQueries facetQueries = null;

	@JsonProperty("facetFields")
	private RequestFacetFields facetFields = null;

	@JsonProperty("facetIntervals")
	private RequestFacetIntervals facetIntervals = null;

	@JsonProperty("pivots")
	@Valid
	private List<RequestPivot> pivots = null;

	@JsonProperty("stats")
	@Valid
	private List<RequestStats> stats = null;

	@JsonProperty("spellcheck")
	private RequestSpellcheck spellcheck = null;

	@JsonProperty("scope")
	private RequestScope scope = null;

	@JsonProperty("limits")
	private RequestLimits limits = null;

	@JsonProperty("highlight")
	private RequestHighlight highlight = null;

	@JsonProperty("ranges")
	@Valid
	private List<RequestRange> ranges = null;

	public SearchRequest query(RequestQuery query) {
		this.query = query;
		return this;
	}

	/**
	 * Get query
	 * 
	 * @return query
	 **/
	@NotNull

	@Valid

	public RequestQuery getQuery() {
		return query;
	}

	public void setQuery(RequestQuery query) {
		this.query = query;
	}

	public SearchRequest paging(RequestPagination paging) {
		this.paging = paging;
		return this;
	}

	/**
	 * Get paging
	 * 
	 * @return paging
	 **/

	@Valid

	public RequestPagination getPaging() {
		return paging;
	}

	public void setPaging(RequestPagination paging) {
		this.paging = paging;
	}

	public SearchRequest include(RequestInclude include) {
		this.include = include;
		return this;
	}

	/**
	 * Get include
	 * 
	 * @return include
	 **/

	@Valid

	public RequestInclude getInclude() {
		return include;
	}

	public void setInclude(RequestInclude include) {
		this.include = include;
	}

	public SearchRequest includeRequest(Boolean includeRequest) {
		this.includeRequest = includeRequest;
		return this;
	}

	/**
	 * When true, include the original request in the response
	 * 
	 * @return includeRequest
	 **/

	public Boolean isIncludeRequest() {
		return includeRequest;
	}

	public void setIncludeRequest(Boolean includeRequest) {
		this.includeRequest = includeRequest;
	}

	public SearchRequest fields(RequestFields fields) {
		this.fields = fields;
		return this;
	}

	/**
	 * Get fields
	 * 
	 * @return fields
	 **/

	@Valid

	public RequestFields getFields() {
		return fields;
	}

	public void setFields(RequestFields fields) {
		this.fields = fields;
	}

	public SearchRequest sort(RequestSortDefinition sort) {
		this.sort = sort;
		return this;
	}

	/**
	 * Get sort
	 * 
	 * @return sort
	 **/

	@Valid

	public RequestSortDefinition getSort() {
		return sort;
	}

	public void setSort(RequestSortDefinition sort) {
		this.sort = sort;
	}

	public SearchRequest templates(RequestTemplates templates) {
		this.templates = templates;
		return this;
	}

	/**
	 * Get templates
	 * 
	 * @return templates
	 **/

	@Valid

	public RequestTemplates getTemplates() {
		return templates;
	}

	public void setTemplates(RequestTemplates templates) {
		this.templates = templates;
	}

	public SearchRequest defaults(RequestDefaults defaults) {
		this.defaults = defaults;
		return this;
	}

	/**
	 * Get defaults
	 * 
	 * @return defaults
	 **/

	@Valid

	public RequestDefaults getDefaults() {
		return defaults;
	}

	public void setDefaults(RequestDefaults defaults) {
		this.defaults = defaults;
	}

	public SearchRequest localization(RequestLocalization localization) {
		this.localization = localization;
		return this;
	}

	/**
	 * Get localization
	 * 
	 * @return localization
	 **/

	@Valid

	public RequestLocalization getLocalization() {
		return localization;
	}

	public void setLocalization(RequestLocalization localization) {
		this.localization = localization;
	}

	public SearchRequest filterQueries(RequestFilterQueries filterQueries) {
		this.filterQueries = filterQueries;
		return this;
	}

	/**
	 * Get filterQueries
	 * 
	 * @return filterQueries
	 **/

	@Valid

	public RequestFilterQueries getFilterQueries() {
		return filterQueries;
	}

	public void setFilterQueries(RequestFilterQueries filterQueries) {
		this.filterQueries = filterQueries;
	}

	public SearchRequest facetQueries(RequestFacetQueries facetQueries) {
		this.facetQueries = facetQueries;
		return this;
	}

	/**
	 * Get facetQueries
	 * 
	 * @return facetQueries
	 **/

	@Valid

	public RequestFacetQueries getFacetQueries() {
		return facetQueries;
	}

	public void setFacetQueries(RequestFacetQueries facetQueries) {
		this.facetQueries = facetQueries;
	}

	public SearchRequest facetFields(RequestFacetFields facetFields) {
		this.facetFields = facetFields;
		return this;
	}

	/**
	 * Get facetFields
	 * 
	 * @return facetFields
	 **/

	@Valid

	public RequestFacetFields getFacetFields() {
		return facetFields;
	}

	public void setFacetFields(RequestFacetFields facetFields) {
		this.facetFields = facetFields;
	}

	public SearchRequest facetIntervals(RequestFacetIntervals facetIntervals) {
		this.facetIntervals = facetIntervals;
		return this;
	}

	/**
	 * Get facetIntervals
	 * 
	 * @return facetIntervals
	 **/

	@Valid

	public RequestFacetIntervals getFacetIntervals() {
		return facetIntervals;
	}

	public void setFacetIntervals(RequestFacetIntervals facetIntervals) {
		this.facetIntervals = facetIntervals;
	}

	public SearchRequest pivots(List<RequestPivot> pivots) {
		this.pivots = pivots;
		return this;
	}

	public SearchRequest addPivotsItem(RequestPivot pivotsItem) {
		if (this.pivots == null) {
			this.pivots = new ArrayList<RequestPivot>();
		}
		this.pivots.add(pivotsItem);
		return this;
	}

	/**
	 * Get pivots
	 * 
	 * @return pivots
	 **/

	@Valid

	public List<RequestPivot> getPivots() {
		return pivots;
	}

	public void setPivots(List<RequestPivot> pivots) {
		this.pivots = pivots;
	}

	public SearchRequest stats(List<RequestStats> stats) {
		this.stats = stats;
		return this;
	}

	public SearchRequest addStatsItem(RequestStats statsItem) {
		if (this.stats == null) {
			this.stats = new ArrayList<RequestStats>();
		}
		this.stats.add(statsItem);
		return this;
	}

	/**
	 * Get stats
	 * 
	 * @return stats
	 **/

	@Valid

	public List<RequestStats> getStats() {
		return stats;
	}

	public void setStats(List<RequestStats> stats) {
		this.stats = stats;
	}

	public SearchRequest spellcheck(RequestSpellcheck spellcheck) {
		this.spellcheck = spellcheck;
		return this;
	}

	/**
	 * Get spellcheck
	 * 
	 * @return spellcheck
	 **/

	@Valid

	public RequestSpellcheck getSpellcheck() {
		return spellcheck;
	}

	public void setSpellcheck(RequestSpellcheck spellcheck) {
		this.spellcheck = spellcheck;
	}

	public SearchRequest scope(RequestScope scope) {
		this.scope = scope;
		return this;
	}

	/**
	 * Get scope
	 * 
	 * @return scope
	 **/

	@Valid

	public RequestScope getScope() {
		return scope;
	}

	public void setScope(RequestScope scope) {
		this.scope = scope;
	}

	public SearchRequest limits(RequestLimits limits) {
		this.limits = limits;
		return this;
	}

	/**
	 * Get limits
	 * 
	 * @return limits
	 **/

	@Valid

	public RequestLimits getLimits() {
		return limits;
	}

	public void setLimits(RequestLimits limits) {
		this.limits = limits;
	}

	public SearchRequest highlight(RequestHighlight highlight) {
		this.highlight = highlight;
		return this;
	}

	/**
	 * Get highlight
	 * 
	 * @return highlight
	 **/

	@Valid

	public RequestHighlight getHighlight() {
		return highlight;
	}

	public void setHighlight(RequestHighlight highlight) {
		this.highlight = highlight;
	}

	public SearchRequest ranges(List<RequestRange> ranges) {
		this.ranges = ranges;
		return this;
	}

	public SearchRequest addRangesItem(RequestRange rangesItem) {
		if (this.ranges == null) {
			this.ranges = new ArrayList<RequestRange>();
		}
		this.ranges.add(rangesItem);
		return this;
	}

	/**
	 * Get ranges
	 * 
	 * @return ranges
	 **/

	@Valid

	public List<RequestRange> getRanges() {
		return ranges;
	}

	public void setRanges(List<RequestRange> ranges) {
		this.ranges = ranges;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		SearchRequest searchRequest = (SearchRequest) o;
		return Objects.equals(this.query, searchRequest.query) && Objects.equals(this.paging, searchRequest.paging)
				&& Objects.equals(this.include, searchRequest.include)
				&& Objects.equals(this.includeRequest, searchRequest.includeRequest)
				&& Objects.equals(this.fields, searchRequest.fields) && Objects.equals(this.sort, searchRequest.sort)
				&& Objects.equals(this.templates, searchRequest.templates)
				&& Objects.equals(this.defaults, searchRequest.defaults)
				&& Objects.equals(this.localization, searchRequest.localization)
				&& Objects.equals(this.filterQueries, searchRequest.filterQueries)
				&& Objects.equals(this.facetQueries, searchRequest.facetQueries)
				&& Objects.equals(this.facetFields, searchRequest.facetFields)
				&& Objects.equals(this.facetIntervals, searchRequest.facetIntervals)
				&& Objects.equals(this.pivots, searchRequest.pivots) && Objects.equals(this.stats, searchRequest.stats)
				&& Objects.equals(this.spellcheck, searchRequest.spellcheck)
				&& Objects.equals(this.scope, searchRequest.scope) && Objects.equals(this.limits, searchRequest.limits)
				&& Objects.equals(this.highlight, searchRequest.highlight)
				&& Objects.equals(this.ranges, searchRequest.ranges);
	}

	@Override
	public int hashCode() {
		return Objects.hash(query, paging, include, includeRequest, fields, sort, templates, defaults, localization,
				filterQueries, facetQueries, facetFields, facetIntervals, pivots, stats, spellcheck, scope, limits,
				highlight, ranges);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class SearchRequest {\n");

		sb.append("    query: ").append(toIndentedString(query)).append("\n");
		sb.append("    paging: ").append(toIndentedString(paging)).append("\n");
		sb.append("    include: ").append(toIndentedString(include)).append("\n");
		sb.append("    includeRequest: ").append(toIndentedString(includeRequest)).append("\n");
		sb.append("    fields: ").append(toIndentedString(fields)).append("\n");
		sb.append("    sort: ").append(toIndentedString(sort)).append("\n");
		sb.append("    templates: ").append(toIndentedString(templates)).append("\n");
		sb.append("    defaults: ").append(toIndentedString(defaults)).append("\n");
		sb.append("    localization: ").append(toIndentedString(localization)).append("\n");
		sb.append("    filterQueries: ").append(toIndentedString(filterQueries)).append("\n");
		sb.append("    facetQueries: ").append(toIndentedString(facetQueries)).append("\n");
		sb.append("    facetFields: ").append(toIndentedString(facetFields)).append("\n");
		sb.append("    facetIntervals: ").append(toIndentedString(facetIntervals)).append("\n");
		sb.append("    pivots: ").append(toIndentedString(pivots)).append("\n");
		sb.append("    stats: ").append(toIndentedString(stats)).append("\n");
		sb.append("    spellcheck: ").append(toIndentedString(spellcheck)).append("\n");
		sb.append("    scope: ").append(toIndentedString(scope)).append("\n");
		sb.append("    limits: ").append(toIndentedString(limits)).append("\n");
		sb.append("    highlight: ").append(toIndentedString(highlight)).append("\n");
		sb.append("    ranges: ").append(toIndentedString(ranges)).append("\n");
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
