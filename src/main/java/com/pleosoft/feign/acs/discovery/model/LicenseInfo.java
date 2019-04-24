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

package com.pleosoft.feign.acs.discovery.model;

import java.util.Date;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

@Validated

public class LicenseInfo {
	@JsonProperty("issuedAt")
	private Date issuedAt = null;

	@JsonProperty("expiresAt")
	private Date expiresAt = null;

	@JsonProperty("remainingDays")
	private Integer remainingDays = null;

	@JsonProperty("holder")
	private String holder = null;

	@JsonProperty("mode")
	private String mode = null;

	@JsonProperty("entitlements")
	private EntitlementsInfo entitlements = null;

	public LicenseInfo issuedAt(Date issuedAt) {
		this.issuedAt = issuedAt;
		return this;
	}

	/**
	 * Get issuedAt
	 * 
	 * @return issuedAt
	 **/
	@NotNull

	@Valid

	public Date getIssuedAt() {
		return issuedAt;
	}

	public void setIssuedAt(Date issuedAt) {
		this.issuedAt = issuedAt;
	}

	public LicenseInfo expiresAt(Date expiresAt) {
		this.expiresAt = expiresAt;
		return this;
	}

	/**
	 * Get expiresAt
	 * 
	 * @return expiresAt
	 **/
	@NotNull

	@Valid

	public Date getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(Date expiresAt) {
		this.expiresAt = expiresAt;
	}

	public LicenseInfo remainingDays(Integer remainingDays) {
		this.remainingDays = remainingDays;
		return this;
	}

	/**
	 * Get remainingDays
	 * 
	 * @return remainingDays
	 **/
	@NotNull

	public Integer getRemainingDays() {
		return remainingDays;
	}

	public void setRemainingDays(Integer remainingDays) {
		this.remainingDays = remainingDays;
	}

	public LicenseInfo holder(String holder) {
		this.holder = holder;
		return this;
	}

	/**
	 * Get holder
	 * 
	 * @return holder
	 **/
	@NotNull

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public LicenseInfo mode(String mode) {
		this.mode = mode;
		return this;
	}

	/**
	 * Get mode
	 * 
	 * @return mode
	 **/
	@NotNull

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public LicenseInfo entitlements(EntitlementsInfo entitlements) {
		this.entitlements = entitlements;
		return this;
	}

	/**
	 * Get entitlements
	 * 
	 * @return entitlements
	 **/

	@Valid

	public EntitlementsInfo getEntitlements() {
		return entitlements;
	}

	public void setEntitlements(EntitlementsInfo entitlements) {
		this.entitlements = entitlements;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		LicenseInfo licenseInfo = (LicenseInfo) o;
		return Objects.equals(this.issuedAt, licenseInfo.issuedAt)
				&& Objects.equals(this.expiresAt, licenseInfo.expiresAt)
				&& Objects.equals(this.remainingDays, licenseInfo.remainingDays)
				&& Objects.equals(this.holder, licenseInfo.holder) && Objects.equals(this.mode, licenseInfo.mode)
				&& Objects.equals(this.entitlements, licenseInfo.entitlements);
	}

	@Override
	public int hashCode() {
		return Objects.hash(issuedAt, expiresAt, remainingDays, holder, mode, entitlements);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class LicenseInfo {\n");

		sb.append("    issuedAt: ").append(toIndentedString(issuedAt)).append("\n");
		sb.append("    expiresAt: ").append(toIndentedString(expiresAt)).append("\n");
		sb.append("    remainingDays: ").append(toIndentedString(remainingDays)).append("\n");
		sb.append("    holder: ").append(toIndentedString(holder)).append("\n");
		sb.append("    mode: ").append(toIndentedString(mode)).append("\n");
		sb.append("    entitlements: ").append(toIndentedString(entitlements)).append("\n");
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
