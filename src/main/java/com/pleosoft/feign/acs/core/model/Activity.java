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
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

@Validated

public class Activity {
	@JsonProperty("postPersonId")
	private String postPersonId = null;

	@JsonProperty("id")
	private Long id = null;

	@JsonProperty("siteId")
	private String siteId = null;

	@JsonProperty("postedAt")
	private Date postedAt = null;

	@JsonProperty("feedPersonId")
	private String feedPersonId = null;

	@JsonProperty("activitySummary")
	@Valid
	private Map<String, Object> activitySummary = null;

	@JsonProperty("activityType")
	private String activityType = null;

	public Activity postPersonId(String postPersonId) {
		this.postPersonId = postPersonId;
		return this;
	}

	/**
	 * The id of the person who performed the activity
	 * 
	 * @return postPersonId
	 **/
	@NotNull

	public String getPostPersonId() {
		return postPersonId;
	}

	public void setPostPersonId(String postPersonId) {
		this.postPersonId = postPersonId;
	}

	public Activity id(Long id) {
		this.id = id;
		return this;
	}

	/**
	 * The unique id of the activity
	 * 
	 * @return id
	 **/
	@NotNull

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Activity siteId(String siteId) {
		this.siteId = siteId;
		return this;
	}

	/**
	 * The unique id of the site on which the activity was performed
	 * 
	 * @return siteId
	 **/

	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public Activity postedAt(Date postedAt) {
		this.postedAt = postedAt;
		return this;
	}

	/**
	 * The date time at which the activity was performed
	 * 
	 * @return postedAt
	 **/

	@Valid

	public Date getPostedAt() {
		return postedAt;
	}

	public void setPostedAt(Date postedAt) {
		this.postedAt = postedAt;
	}

	public Activity feedPersonId(String feedPersonId) {
		this.feedPersonId = feedPersonId;
		return this;
	}

	/**
	 * The feed on which this activity was posted
	 * 
	 * @return feedPersonId
	 **/
	@NotNull

	public String getFeedPersonId() {
		return feedPersonId;
	}

	public void setFeedPersonId(String feedPersonId) {
		this.feedPersonId = feedPersonId;
	}

	public Activity activitySummary(Map<String, Object> activitySummary) {
		this.activitySummary = activitySummary;
		return this;
	}

	public Activity putActivitySummaryItem(String key, Object activitySummaryItem) {
		if (this.activitySummary == null) {
			this.activitySummary = new HashMap<String, Object>();
		}
		this.activitySummary.put(key, activitySummaryItem);
		return this;
	}

	/**
	 * An object summarizing the activity
	 * 
	 * @return activitySummary
	 **/

	public Map<String, Object> getActivitySummary() {
		return activitySummary;
	}

	public void setActivitySummary(Map<String, Object> activitySummary) {
		this.activitySummary = activitySummary;
	}

	public Activity activityType(String activityType) {
		this.activityType = activityType;
		return this;
	}

	/**
	 * The type of the activity posted
	 * 
	 * @return activityType
	 **/
	@NotNull

	public String getActivityType() {
		return activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Activity activity = (Activity) o;
		return Objects.equals(this.postPersonId, activity.postPersonId) && Objects.equals(this.id, activity.id)
				&& Objects.equals(this.siteId, activity.siteId) && Objects.equals(this.postedAt, activity.postedAt)
				&& Objects.equals(this.feedPersonId, activity.feedPersonId)
				&& Objects.equals(this.activitySummary, activity.activitySummary)
				&& Objects.equals(this.activityType, activity.activityType);
	}

	@Override
	public int hashCode() {
		return Objects.hash(postPersonId, id, siteId, postedAt, feedPersonId, activitySummary, activityType);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Activity {\n");

		sb.append("    postPersonId: ").append(toIndentedString(postPersonId)).append("\n");
		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    siteId: ").append(toIndentedString(siteId)).append("\n");
		sb.append("    postedAt: ").append(toIndentedString(postedAt)).append("\n");
		sb.append("    feedPersonId: ").append(toIndentedString(feedPersonId)).append("\n");
		sb.append("    activitySummary: ").append(toIndentedString(activitySummary)).append("\n");
		sb.append("    activityType: ").append(toIndentedString(activityType)).append("\n");
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
