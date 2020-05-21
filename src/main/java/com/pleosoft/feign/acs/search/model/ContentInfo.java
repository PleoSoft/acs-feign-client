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

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

@Validated

public class ContentInfo {
	@JsonProperty("mimeType")
	private String mimeType = null;

	@JsonProperty("mimeTypeName")
	private String mimeTypeName = null;

	@JsonProperty("sizeInBytes")
	private Long sizeInBytes = null;

	@JsonProperty("encoding")
	private String encoding = null;

	@JsonProperty("mimeTypeGroup")
	private String mimeTypeGroup = null;

	public ContentInfo mimeType(String mimeType) {
		this.mimeType = mimeType;
		return this;
	}

	/**
	 * Get mimeType
	 * 
	 * @return mimeType
	 **/
	@NotNull

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public ContentInfo mimeTypeName(String mimeTypeName) {
		this.mimeTypeName = mimeTypeName;
		return this;
	}

	/**
	 * Get mimeTypeName
	 * 
	 * @return mimeTypeName
	 **/
	@NotNull

	public String getMimeTypeName() {
		return mimeTypeName;
	}

	public void setMimeTypeName(String mimeTypeName) {
		this.mimeTypeName = mimeTypeName;
	}

	public ContentInfo sizeInBytes(Long sizeInBytes) {
		this.sizeInBytes = sizeInBytes;
		return this;
	}

	/**
	 * Get sizeInBytes
	 * 
	 * @return sizeInBytes
	 **/
	@NotNull

	public Long getSizeInBytes() {
		return sizeInBytes;
	}

	public void setSizeInBytes(Long sizeInBytes) {
		this.sizeInBytes = sizeInBytes;
	}

	public ContentInfo encoding(String encoding) {
		this.encoding = encoding;
		return this;
	}

	/**
	 * Get encoding
	 * 
	 * @return encoding
	 **/

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public ContentInfo mimeTypeGroup(String mimeTypeGroup) {
		this.mimeTypeGroup = mimeTypeGroup;
		return this;
	}

	/**
	 * Get mimeTypeGroup
	 * 
	 * @return mimeTypeGroup
	 **/

	public String getMimeTypeGroup() {
		return mimeTypeGroup;
	}

	public void setMimeTypeGroup(String mimeTypeGroup) {
		this.mimeTypeGroup = mimeTypeGroup;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ContentInfo contentInfo = (ContentInfo) o;
		return Objects.equals(this.mimeType, contentInfo.mimeType)
				&& Objects.equals(this.mimeTypeName, contentInfo.mimeTypeName)
				&& Objects.equals(this.sizeInBytes, contentInfo.sizeInBytes)
				&& Objects.equals(this.encoding, contentInfo.encoding)
				&& Objects.equals(this.mimeTypeGroup, contentInfo.mimeTypeGroup);
	}

	@Override
	public int hashCode() {
		return Objects.hash(mimeType, mimeTypeName, sizeInBytes, encoding, mimeTypeGroup);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ContentInfo {\n");

		sb.append("    mimeType: ").append(toIndentedString(mimeType)).append("\n");
		sb.append("    mimeTypeName: ").append(toIndentedString(mimeTypeName)).append("\n");
		sb.append("    sizeInBytes: ").append(toIndentedString(sizeInBytes)).append("\n");
		sb.append("    encoding: ").append(toIndentedString(encoding)).append("\n");
		sb.append("    mimeTypeGroup: ").append(toIndentedString(mimeTypeGroup)).append("\n");
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
