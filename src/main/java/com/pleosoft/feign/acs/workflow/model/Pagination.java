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

package com.pleosoft.feign.acs.workflow.model;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

@Validated

public class Pagination {
	@JsonProperty("count")
	private Integer count = null;

	@JsonProperty("hasMoreItems")
	private Boolean hasMoreItems = null;

	@JsonProperty("totalItems")
	private Long totalItems = null;

	@JsonProperty("skipCount")
	private Long skipCount = null;

	@JsonProperty("maxItems")
	private Long maxItems = null;

	public Pagination count(Integer count) {
		this.count = count;
		return this;
	}

	/**
	 * The number of objects in the entries array.
	 * 
	 * @return count
	 **/

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Pagination hasMoreItems(Boolean hasMoreItems) {
		this.hasMoreItems = hasMoreItems;
		return this;
	}

	/**
	 * A boolean value which is **true** if there are more entities in the
	 * collection beyond those in this response. A true value means a request with a
	 * larger value for the **skipCount** or the **maxItems** parameter will return
	 * more entities.
	 * 
	 * @return hasMoreItems
	 **/

	public Boolean isHasMoreItems() {
		return hasMoreItems;
	}

	public void setHasMoreItems(Boolean hasMoreItems) {
		this.hasMoreItems = hasMoreItems;
	}

	public Pagination totalItems(Long totalItems) {
		this.totalItems = totalItems;
		return this;
	}

	/**
	 * An integer describing the total number of entities in the collection. The API
	 * might not be able to determine this value, in which case this property will
	 * not be present.
	 * 
	 * @return totalItems
	 **/

	public Long getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(Long totalItems) {
		this.totalItems = totalItems;
	}

	public Pagination skipCount(Long skipCount) {
		this.skipCount = skipCount;
		return this;
	}

	/**
	 * An integer describing how many entities exist in the collection before those
	 * included in this list.
	 * 
	 * @return skipCount
	 **/

	public Long getSkipCount() {
		return skipCount;
	}

	public void setSkipCount(Long skipCount) {
		this.skipCount = skipCount;
	}

	public Pagination maxItems(Long maxItems) {
		this.maxItems = maxItems;
		return this;
	}

	/**
	 * The value of the **maxItems** parameter used to generate this list, or if
	 * there was no **maxItems** parameter the default value, 10
	 * 
	 * @return maxItems
	 **/

	public Long getMaxItems() {
		return maxItems;
	}

	public void setMaxItems(Long maxItems) {
		this.maxItems = maxItems;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Pagination pagination = (Pagination) o;
		return Objects.equals(this.count, pagination.count)
				&& Objects.equals(this.hasMoreItems, pagination.hasMoreItems)
				&& Objects.equals(this.totalItems, pagination.totalItems)
				&& Objects.equals(this.skipCount, pagination.skipCount)
				&& Objects.equals(this.maxItems, pagination.maxItems);
	}

	@Override
	public int hashCode() {
		return Objects.hash(count, hasMoreItems, totalItems, skipCount, maxItems);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Pagination {\n");

		sb.append("    count: ").append(toIndentedString(count)).append("\n");
		sb.append("    hasMoreItems: ").append(toIndentedString(hasMoreItems)).append("\n");
		sb.append("    totalItems: ").append(toIndentedString(totalItems)).append("\n");
		sb.append("    skipCount: ").append(toIndentedString(skipCount)).append("\n");
		sb.append("    maxItems: ").append(toIndentedString(maxItems)).append("\n");
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
