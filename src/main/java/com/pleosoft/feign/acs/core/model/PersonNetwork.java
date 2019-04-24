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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

@Validated

public class PersonNetwork {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("homeNetwork")
	private Boolean homeNetwork = null;

	@JsonProperty("isEnabled")
	private Boolean isEnabled = null;

	@JsonProperty("createdAt")
	private Date createdAt = null;

	@JsonProperty("paidNetwork")
	private Boolean paidNetwork = null;

	/**
	 * Gets or Sets subscriptionLevel
	 */
	public enum SubscriptionLevelEnum {
		FREE("Free"),

		STANDARD("Standard"),

		ENTERPRISE("Enterprise");

		private String value;

		SubscriptionLevelEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static SubscriptionLevelEnum fromValue(String text) {
			for (SubscriptionLevelEnum b : SubscriptionLevelEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("subscriptionLevel")
	private SubscriptionLevelEnum subscriptionLevel = null;

	@JsonProperty("quotas")
	@Valid
	private List<NetworkQuota> quotas = null;

	public PersonNetwork id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * This network's unique id
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

	public PersonNetwork homeNetwork(Boolean homeNetwork) {
		this.homeNetwork = homeNetwork;
		return this;
	}

	/**
	 * Is this the home network?
	 * 
	 * @return homeNetwork
	 **/

	public Boolean isHomeNetwork() {
		return homeNetwork;
	}

	public void setHomeNetwork(Boolean homeNetwork) {
		this.homeNetwork = homeNetwork;
	}

	public PersonNetwork isEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
		return this;
	}

	/**
	 * Get isEnabled
	 * 
	 * @return isEnabled
	 **/
	@NotNull

	public Boolean isIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public PersonNetwork createdAt(Date createdAt) {
		this.createdAt = createdAt;
		return this;
	}

	/**
	 * Get createdAt
	 * 
	 * @return createdAt
	 **/

	@Valid

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public PersonNetwork paidNetwork(Boolean paidNetwork) {
		this.paidNetwork = paidNetwork;
		return this;
	}

	/**
	 * Get paidNetwork
	 * 
	 * @return paidNetwork
	 **/

	public Boolean isPaidNetwork() {
		return paidNetwork;
	}

	public void setPaidNetwork(Boolean paidNetwork) {
		this.paidNetwork = paidNetwork;
	}

	public PersonNetwork subscriptionLevel(SubscriptionLevelEnum subscriptionLevel) {
		this.subscriptionLevel = subscriptionLevel;
		return this;
	}

	/**
	 * Get subscriptionLevel
	 * 
	 * @return subscriptionLevel
	 **/

	public SubscriptionLevelEnum getSubscriptionLevel() {
		return subscriptionLevel;
	}

	public void setSubscriptionLevel(SubscriptionLevelEnum subscriptionLevel) {
		this.subscriptionLevel = subscriptionLevel;
	}

	public PersonNetwork quotas(List<NetworkQuota> quotas) {
		this.quotas = quotas;
		return this;
	}

	public PersonNetwork addQuotasItem(NetworkQuota quotasItem) {
		if (this.quotas == null) {
			this.quotas = new ArrayList<NetworkQuota>();
		}
		this.quotas.add(quotasItem);
		return this;
	}

	/**
	 * Get quotas
	 * 
	 * @return quotas
	 **/

	@Valid

	public List<NetworkQuota> getQuotas() {
		return quotas;
	}

	public void setQuotas(List<NetworkQuota> quotas) {
		this.quotas = quotas;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PersonNetwork personNetwork = (PersonNetwork) o;
		return Objects.equals(this.id, personNetwork.id) && Objects.equals(this.homeNetwork, personNetwork.homeNetwork)
				&& Objects.equals(this.isEnabled, personNetwork.isEnabled)
				&& Objects.equals(this.createdAt, personNetwork.createdAt)
				&& Objects.equals(this.paidNetwork, personNetwork.paidNetwork)
				&& Objects.equals(this.subscriptionLevel, personNetwork.subscriptionLevel)
				&& Objects.equals(this.quotas, personNetwork.quotas);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, homeNetwork, isEnabled, createdAt, paidNetwork, subscriptionLevel, quotas);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PersonNetwork {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    homeNetwork: ").append(toIndentedString(homeNetwork)).append("\n");
		sb.append("    isEnabled: ").append(toIndentedString(isEnabled)).append("\n");
		sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
		sb.append("    paidNetwork: ").append(toIndentedString(paidNetwork)).append("\n");
		sb.append("    subscriptionLevel: ").append(toIndentedString(subscriptionLevel)).append("\n");
		sb.append("    quotas: ").append(toIndentedString(quotas)).append("\n");
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
