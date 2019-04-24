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

public class ResultSetContext {
	@JsonProperty("consistency")
	private ResponseConsistency consistency = null;

	@JsonProperty("request")
	private SearchRequest request = null;

	@JsonProperty("facetQueries")
	@Valid
	private List<ResultSetContextFacetQueries> facetQueries = null;

	@JsonProperty("facetsFields")
	@Valid
	private List<ResultBuckets> facetsFields = null;

	@JsonProperty("facets")
	@Valid
	private List<GenericFacetResponse> facets = null;

	@JsonProperty("spellcheck")
	@Valid
	private List<ResultSetContextSpellcheck> spellcheck = null;

	public ResultSetContext consistency(ResponseConsistency consistency) {
		this.consistency = consistency;
		return this;
	}

	/**
	 * Get consistency
	 * 
	 * @return consistency
	 **/

	@Valid

	public ResponseConsistency getConsistency() {
		return consistency;
	}

	public void setConsistency(ResponseConsistency consistency) {
		this.consistency = consistency;
	}

	public ResultSetContext request(SearchRequest request) {
		this.request = request;
		return this;
	}

	/**
	 * Get request
	 * 
	 * @return request
	 **/

	@Valid

	public SearchRequest getRequest() {
		return request;
	}

	public void setRequest(SearchRequest request) {
		this.request = request;
	}

	public ResultSetContext facetQueries(List<ResultSetContextFacetQueries> facetQueries) {
		this.facetQueries = facetQueries;
		return this;
	}

	public ResultSetContext addFacetQueriesItem(ResultSetContextFacetQueries facetQueriesItem) {
		if (this.facetQueries == null) {
			this.facetQueries = new ArrayList<ResultSetContextFacetQueries>();
		}
		this.facetQueries.add(facetQueriesItem);
		return this;
	}

	/**
	 * The counts from facet queries
	 * 
	 * @return facetQueries
	 **/

	@Valid

	public List<ResultSetContextFacetQueries> getFacetQueries() {
		return facetQueries;
	}

	public void setFacetQueries(List<ResultSetContextFacetQueries> facetQueries) {
		this.facetQueries = facetQueries;
	}

	public ResultSetContext facetsFields(List<ResultBuckets> facetsFields) {
		this.facetsFields = facetsFields;
		return this;
	}

	public ResultSetContext addFacetsFieldsItem(ResultBuckets facetsFieldsItem) {
		if (this.facetsFields == null) {
			this.facetsFields = new ArrayList<ResultBuckets>();
		}
		this.facetsFields.add(facetsFieldsItem);
		return this;
	}

	/**
	 * The counts from field facets
	 * 
	 * @return facetsFields
	 **/

	@Valid

	public List<ResultBuckets> getFacetsFields() {
		return facetsFields;
	}

	public void setFacetsFields(List<ResultBuckets> facetsFields) {
		this.facetsFields = facetsFields;
	}

	public ResultSetContext facets(List<GenericFacetResponse> facets) {
		this.facets = facets;
		return this;
	}

	public ResultSetContext addFacetsItem(GenericFacetResponse facetsItem) {
		if (this.facets == null) {
			this.facets = new ArrayList<GenericFacetResponse>();
		}
		this.facets.add(facetsItem);
		return this;
	}

	/**
	 * The faceted response
	 * 
	 * @return facets
	 **/

	@Valid

	public List<GenericFacetResponse> getFacets() {
		return facets;
	}

	public void setFacets(List<GenericFacetResponse> facets) {
		this.facets = facets;
	}

	public ResultSetContext spellcheck(List<ResultSetContextSpellcheck> spellcheck) {
		this.spellcheck = spellcheck;
		return this;
	}

	public ResultSetContext addSpellcheckItem(ResultSetContextSpellcheck spellcheckItem) {
		if (this.spellcheck == null) {
			this.spellcheck = new ArrayList<ResultSetContextSpellcheck>();
		}
		this.spellcheck.add(spellcheckItem);
		return this;
	}

	/**
	 * Suggested corrections If zero results were found for the original query
	 * then a single entry of type \"searchInsteadFor\" will be returned. If
	 * alternatives were found that return more results than the original query
	 * they are returned as \"didYouMean\" options. The highest quality
	 * suggestion is first.
	 * 
	 * @return spellcheck
	 **/

	@Valid

	public List<ResultSetContextSpellcheck> getSpellcheck() {
		return spellcheck;
	}

	public void setSpellcheck(List<ResultSetContextSpellcheck> spellcheck) {
		this.spellcheck = spellcheck;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ResultSetContext resultSetContext = (ResultSetContext) o;
		return Objects.equals(this.consistency, resultSetContext.consistency)
				&& Objects.equals(this.request, resultSetContext.request)
				&& Objects.equals(this.facetQueries, resultSetContext.facetQueries)
				&& Objects.equals(this.facetsFields, resultSetContext.facetsFields)
				&& Objects.equals(this.facets, resultSetContext.facets)
				&& Objects.equals(this.spellcheck, resultSetContext.spellcheck);
	}

	@Override
	public int hashCode() {
		return Objects.hash(consistency, request, facetQueries, facetsFields, facets, spellcheck);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ResultSetContext {\n");

		sb.append("    consistency: ").append(toIndentedString(consistency)).append("\n");
		sb.append("    request: ").append(toIndentedString(request)).append("\n");
		sb.append("    facetQueries: ").append(toIndentedString(facetQueries)).append("\n");
		sb.append("    facetsFields: ").append(toIndentedString(facetsFields)).append("\n");
		sb.append("    facets: ").append(toIndentedString(facets)).append("\n");
		sb.append("    spellcheck: ").append(toIndentedString(spellcheck)).append("\n");
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
