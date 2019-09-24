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

package com.pleosoft.feign.acs.core.model;

import java.util.Date;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

@Validated

public class Rating {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("aggregate")
	private RatingAggregate aggregate = null;

	@JsonProperty("ratedAt")
	private Date ratedAt = null;

	@JsonProperty("myRating")
	private String myRating = null;

	public Rating id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 * 
	 * @return id
	 **/
	@NotNull

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Rating aggregate(RatingAggregate aggregate) {
		this.aggregate = aggregate;
		return this;
	}

	/**
	 * Get aggregate
	 * 
	 * @return aggregate
	 **/
	@NotNull

	@Valid

	public RatingAggregate getAggregate() {
		return aggregate;
	}

	public void setAggregate(RatingAggregate aggregate) {
		this.aggregate = aggregate;
	}

	public Rating ratedAt(Date ratedAt) {
		this.ratedAt = ratedAt;
		return this;
	}

	/**
	 * Get ratedAt
	 * 
	 * @return ratedAt
	 **/

	@Valid

	public Date getRatedAt() {
		return ratedAt;
	}

	public void setRatedAt(Date ratedAt) {
		this.ratedAt = ratedAt;
	}

	public Rating myRating(String myRating) {
		this.myRating = myRating;
		return this;
	}

	/**
	 * The rating. The type is specific to the rating scheme, boolean for the likes
	 * and an integer for the fiveStar.
	 * 
	 * @return myRating
	 **/

	public String getMyRating() {
		return myRating;
	}

	public void setMyRating(String myRating) {
		this.myRating = myRating;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Rating rating = (Rating) o;
		return Objects.equals(this.id, rating.id) && Objects.equals(this.aggregate, rating.aggregate)
				&& Objects.equals(this.ratedAt, rating.ratedAt) && Objects.equals(this.myRating, rating.myRating);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, aggregate, ratedAt, myRating);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Rating {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    aggregate: ").append(toIndentedString(aggregate)).append("\n");
		sb.append("    ratedAt: ").append(toIndentedString(ratedAt)).append("\n");
		sb.append("    myRating: ").append(toIndentedString(myRating)).append("\n");
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
