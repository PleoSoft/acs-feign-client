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

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

@Validated

public class SiteBodyUpdate {
	@JsonProperty("title")
	private String title = null;

	@JsonProperty("description")
	private String description = null;

	/**
	 * Gets or Sets visibility
	 */
	public enum VisibilityEnum {
		PRIVATE("PRIVATE"),

		MODERATED("MODERATED"),

		PUBLIC("PUBLIC");

		private String value;

		VisibilityEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static VisibilityEnum fromValue(String text) {
			for (VisibilityEnum b : VisibilityEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("visibility")
	private VisibilityEnum visibility = null;

	public SiteBodyUpdate title(String title) {
		this.title = title;
		return this;
	}

	/**
	 * Get title
	 * 
	 * @return title
	 **/

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public SiteBodyUpdate description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Get description
	 * 
	 * @return description
	 **/

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public SiteBodyUpdate visibility(VisibilityEnum visibility) {
		this.visibility = visibility;
		return this;
	}

	/**
	 * Get visibility
	 * 
	 * @return visibility
	 **/

	public VisibilityEnum getVisibility() {
		return visibility;
	}

	public void setVisibility(VisibilityEnum visibility) {
		this.visibility = visibility;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		SiteBodyUpdate siteBodyUpdate = (SiteBodyUpdate) o;
		return Objects.equals(this.title, siteBodyUpdate.title)
				&& Objects.equals(this.description, siteBodyUpdate.description)
				&& Objects.equals(this.visibility, siteBodyUpdate.visibility);
	}

	@Override
	public int hashCode() {
		return Objects.hash(title, description, visibility);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class SiteBodyUpdate {\n");

		sb.append("    title: ").append(toIndentedString(title)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    visibility: ").append(toIndentedString(visibility)).append("\n");
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
