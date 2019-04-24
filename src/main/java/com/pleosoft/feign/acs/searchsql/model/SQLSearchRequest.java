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

package com.pleosoft.feign.acs.searchsql.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

@Validated

public class SQLSearchRequest {
	@JsonProperty("stmt")
	private String stmt = null;

	@JsonProperty("format")
	private String format = null;

	@JsonProperty("locales")
	@Valid
	private List<String> locales = null;

	@JsonProperty("timezone")
	private String timezone = null;

	@JsonProperty("includeMetadata")
	private Boolean includeMetadata = null;

	public SQLSearchRequest stmt(String stmt) {
		this.stmt = stmt;
		return this;
	}

	/**
	 * Get stmt
	 * 
	 * @return stmt
	 **/

	public String getStmt() {
		return stmt;
	}

	public void setStmt(String stmt) {
		this.stmt = stmt;
	}

	public SQLSearchRequest format(String format) {
		this.format = format;
		return this;
	}

	/**
	 * Get format
	 * 
	 * @return format
	 **/

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public SQLSearchRequest locales(List<String> locales) {
		this.locales = locales;
		return this;
	}

	public SQLSearchRequest addLocalesItem(String localesItem) {
		if (this.locales == null) {
			this.locales = new ArrayList<String>();
		}
		this.locales.add(localesItem);
		return this;
	}

	/**
	 * Get locales
	 * 
	 * @return locales
	 **/

	public List<String> getLocales() {
		return locales;
	}

	public void setLocales(List<String> locales) {
		this.locales = locales;
	}

	public SQLSearchRequest timezone(String timezone) {
		this.timezone = timezone;
		return this;
	}

	/**
	 * Get timezone
	 * 
	 * @return timezone
	 **/

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public SQLSearchRequest includeMetadata(Boolean includeMetadata) {
		this.includeMetadata = includeMetadata;
		return this;
	}

	/**
	 * Get includeMetadata
	 * 
	 * @return includeMetadata
	 **/

	public Boolean isIncludeMetadata() {
		return includeMetadata;
	}

	public void setIncludeMetadata(Boolean includeMetadata) {
		this.includeMetadata = includeMetadata;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		SQLSearchRequest sqLSearchRequest = (SQLSearchRequest) o;
		return Objects.equals(this.stmt, sqLSearchRequest.stmt) && Objects.equals(this.format, sqLSearchRequest.format)
				&& Objects.equals(this.locales, sqLSearchRequest.locales)
				&& Objects.equals(this.timezone, sqLSearchRequest.timezone)
				&& Objects.equals(this.includeMetadata, sqLSearchRequest.includeMetadata);
	}

	@Override
	public int hashCode() {
		return Objects.hash(stmt, format, locales, timezone, includeMetadata);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class SQLSearchRequest {\n");

		sb.append("    stmt: ").append(toIndentedString(stmt)).append("\n");
		sb.append("    format: ").append(toIndentedString(format)).append("\n");
		sb.append("    locales: ").append(toIndentedString(locales)).append("\n");
		sb.append("    timezone: ").append(toIndentedString(timezone)).append("\n");
		sb.append("    includeMetadata: ").append(toIndentedString(includeMetadata)).append("\n");
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
