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

public class RequestFacetFields {
	@JsonProperty("facets")
	@Valid
	private List<RequestFacetField> facets = null;

	public RequestFacetFields facets(List<RequestFacetField> facets) {
		this.facets = facets;
		return this;
	}

	public RequestFacetFields addFacetsItem(RequestFacetField facetsItem) {
		if (this.facets == null) {
			this.facets = new ArrayList<RequestFacetField>();
		}
		this.facets.add(facetsItem);
		return this;
	}

	/**
	 * Define specifc fields on which to facet (adds SOLR facet.field and
	 * f.<field>.facet.* options)
	 * 
	 * @return facets
	 **/

	@Valid

	public List<RequestFacetField> getFacets() {
		return facets;
	}

	public void setFacets(List<RequestFacetField> facets) {
		this.facets = facets;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		RequestFacetFields requestFacetFields = (RequestFacetFields) o;
		return Objects.equals(this.facets, requestFacetFields.facets);
	}

	@Override
	public int hashCode() {
		return Objects.hash(facets);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class RequestFacetFields {\n");

		sb.append("    facets: ").append(toIndentedString(facets)).append("\n");
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
