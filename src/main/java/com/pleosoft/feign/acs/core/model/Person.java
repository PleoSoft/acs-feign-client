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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

@Validated

public class Person {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("firstName")
	private String firstName = null;

	@JsonProperty("lastName")
	private String lastName = null;

	@JsonProperty("description")
	private String description = null;

	@JsonProperty("avatarId")
	private String avatarId = null;

	@JsonProperty("email")
	private String email = null;

	@JsonProperty("skypeId")
	private String skypeId = null;

	@JsonProperty("googleId")
	private String googleId = null;

	@JsonProperty("instantMessageId")
	private String instantMessageId = null;

	@JsonProperty("jobTitle")
	private String jobTitle = null;

	@JsonProperty("location")
	private String location = null;

	@JsonProperty("company")
	private Company company = null;

	@JsonProperty("mobile")
	private String mobile = null;

	@JsonProperty("telephone")
	private String telephone = null;

	@JsonProperty("statusUpdatedAt")
	private Date statusUpdatedAt = null;

	@JsonProperty("userStatus")
	private String userStatus = null;

	@JsonProperty("enabled")
	private Boolean enabled = true;

	@JsonProperty("emailNotificationsEnabled")
	private Boolean emailNotificationsEnabled = true;

	@JsonProperty("aspectNames")
	@Valid
	private List<String> aspectNames = null;

	@JsonProperty("properties")
	@Valid
	private Map<String, Object> properties = null;

	@JsonProperty("capabilities")
	@Valid
	private Map<String, Boolean> capabilities = null;

	public Person id(String id) {
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

	public Person firstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	/**
	 * Get firstName
	 * 
	 * @return firstName
	 **/
	@NotNull

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Person lastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	/**
	 * Get lastName
	 * 
	 * @return lastName
	 **/

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Person description(String description) {
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

	public Person avatarId(String avatarId) {
		this.avatarId = avatarId;
		return this;
	}

	/**
	 * Get avatarId
	 * 
	 * @return avatarId
	 **/

	public String getAvatarId() {
		return avatarId;
	}

	public void setAvatarId(String avatarId) {
		this.avatarId = avatarId;
	}

	public Person email(String email) {
		this.email = email;
		return this;
	}

	/**
	 * Get email
	 * 
	 * @return email
	 **/
	@NotNull

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Person skypeId(String skypeId) {
		this.skypeId = skypeId;
		return this;
	}

	/**
	 * Get skypeId
	 * 
	 * @return skypeId
	 **/

	public String getSkypeId() {
		return skypeId;
	}

	public void setSkypeId(String skypeId) {
		this.skypeId = skypeId;
	}

	public Person googleId(String googleId) {
		this.googleId = googleId;
		return this;
	}

	/**
	 * Get googleId
	 * 
	 * @return googleId
	 **/

	public String getGoogleId() {
		return googleId;
	}

	public void setGoogleId(String googleId) {
		this.googleId = googleId;
	}

	public Person instantMessageId(String instantMessageId) {
		this.instantMessageId = instantMessageId;
		return this;
	}

	/**
	 * Get instantMessageId
	 * 
	 * @return instantMessageId
	 **/

	public String getInstantMessageId() {
		return instantMessageId;
	}

	public void setInstantMessageId(String instantMessageId) {
		this.instantMessageId = instantMessageId;
	}

	public Person jobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
		return this;
	}

	/**
	 * Get jobTitle
	 * 
	 * @return jobTitle
	 **/

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Person location(String location) {
		this.location = location;
		return this;
	}

	/**
	 * Get location
	 * 
	 * @return location
	 **/

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Person company(Company company) {
		this.company = company;
		return this;
	}

	/**
	 * Get company
	 * 
	 * @return company
	 **/

	@Valid

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Person mobile(String mobile) {
		this.mobile = mobile;
		return this;
	}

	/**
	 * Get mobile
	 * 
	 * @return mobile
	 **/

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Person telephone(String telephone) {
		this.telephone = telephone;
		return this;
	}

	/**
	 * Get telephone
	 * 
	 * @return telephone
	 **/

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Person statusUpdatedAt(Date statusUpdatedAt) {
		this.statusUpdatedAt = statusUpdatedAt;
		return this;
	}

	/**
	 * Get statusUpdatedAt
	 * 
	 * @return statusUpdatedAt
	 **/

	@Valid

	public Date getStatusUpdatedAt() {
		return statusUpdatedAt;
	}

	public void setStatusUpdatedAt(Date statusUpdatedAt) {
		this.statusUpdatedAt = statusUpdatedAt;
	}

	public Person userStatus(String userStatus) {
		this.userStatus = userStatus;
		return this;
	}

	/**
	 * Get userStatus
	 * 
	 * @return userStatus
	 **/

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public Person enabled(Boolean enabled) {
		this.enabled = enabled;
		return this;
	}

	/**
	 * Get enabled
	 * 
	 * @return enabled
	 **/
	@NotNull

	public Boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Person emailNotificationsEnabled(Boolean emailNotificationsEnabled) {
		this.emailNotificationsEnabled = emailNotificationsEnabled;
		return this;
	}

	/**
	 * Get emailNotificationsEnabled
	 * 
	 * @return emailNotificationsEnabled
	 **/

	public Boolean isEmailNotificationsEnabled() {
		return emailNotificationsEnabled;
	}

	public void setEmailNotificationsEnabled(Boolean emailNotificationsEnabled) {
		this.emailNotificationsEnabled = emailNotificationsEnabled;
	}

	public Person aspectNames(List<String> aspectNames) {
		this.aspectNames = aspectNames;
		return this;
	}

	public Person addAspectNamesItem(String aspectNamesItem) {
		if (this.aspectNames == null) {
			this.aspectNames = new ArrayList<String>();
		}
		this.aspectNames.add(aspectNamesItem);
		return this;
	}

	/**
	 * Get aspectNames
	 * 
	 * @return aspectNames
	 **/

	public List<String> getAspectNames() {
		return aspectNames;
	}

	public void setAspectNames(List<String> aspectNames) {
		this.aspectNames = aspectNames;
	}

	public Person properties(Map<String, Object> properties) {
		this.properties = properties;
		return this;
	}

	public Person putPropertiesItem(String key, Object propertiesItem) {
		if (this.properties == null) {
			this.properties = new HashMap<String, Object>();
		}
		this.properties.put(key, propertiesItem);
		return this;
	}

	/**
	 * Get properties
	 * 
	 * @return properties
	 **/

	public Map<String, Object> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, Object> properties) {
		this.properties = properties;
	}

	public Person capabilities(Map<String, Boolean> capabilities) {
		this.capabilities = capabilities;
		return this;
	}

	public Person putCapabilitiesItem(String key, Boolean capabilitiesItem) {
		if (this.capabilities == null) {
			this.capabilities = new HashMap<String, Boolean>();
		}
		this.capabilities.put(key, capabilitiesItem);
		return this;
	}

	/**
	 * Get capabilities
	 * 
	 * @return capabilities
	 **/

	public Map<String, Boolean> getCapabilities() {
		return capabilities;
	}

	public void setCapabilities(Map<String, Boolean> capabilities) {
		this.capabilities = capabilities;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Person person = (Person) o;
		return Objects.equals(this.id, person.id) && Objects.equals(this.firstName, person.firstName)
				&& Objects.equals(this.lastName, person.lastName)
				&& Objects.equals(this.description, person.description)
				&& Objects.equals(this.avatarId, person.avatarId) && Objects.equals(this.email, person.email)
				&& Objects.equals(this.skypeId, person.skypeId) && Objects.equals(this.googleId, person.googleId)
				&& Objects.equals(this.instantMessageId, person.instantMessageId)
				&& Objects.equals(this.jobTitle, person.jobTitle) && Objects.equals(this.location, person.location)
				&& Objects.equals(this.company, person.company) && Objects.equals(this.mobile, person.mobile)
				&& Objects.equals(this.telephone, person.telephone)
				&& Objects.equals(this.statusUpdatedAt, person.statusUpdatedAt)
				&& Objects.equals(this.userStatus, person.userStatus) && Objects.equals(this.enabled, person.enabled)
				&& Objects.equals(this.emailNotificationsEnabled, person.emailNotificationsEnabled)
				&& Objects.equals(this.aspectNames, person.aspectNames)
				&& Objects.equals(this.properties, person.properties)
				&& Objects.equals(this.capabilities, person.capabilities);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, firstName, lastName, description, avatarId, email, skypeId, googleId, instantMessageId,
				jobTitle, location, company, mobile, telephone, statusUpdatedAt, userStatus, enabled,
				emailNotificationsEnabled, aspectNames, properties, capabilities);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Person {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
		sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    avatarId: ").append(toIndentedString(avatarId)).append("\n");
		sb.append("    email: ").append(toIndentedString(email)).append("\n");
		sb.append("    skypeId: ").append(toIndentedString(skypeId)).append("\n");
		sb.append("    googleId: ").append(toIndentedString(googleId)).append("\n");
		sb.append("    instantMessageId: ").append(toIndentedString(instantMessageId)).append("\n");
		sb.append("    jobTitle: ").append(toIndentedString(jobTitle)).append("\n");
		sb.append("    location: ").append(toIndentedString(location)).append("\n");
		sb.append("    company: ").append(toIndentedString(company)).append("\n");
		sb.append("    mobile: ").append(toIndentedString(mobile)).append("\n");
		sb.append("    telephone: ").append(toIndentedString(telephone)).append("\n");
		sb.append("    statusUpdatedAt: ").append(toIndentedString(statusUpdatedAt)).append("\n");
		sb.append("    userStatus: ").append(toIndentedString(userStatus)).append("\n");
		sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
		sb.append("    emailNotificationsEnabled: ").append(toIndentedString(emailNotificationsEnabled)).append("\n");
		sb.append("    aspectNames: ").append(toIndentedString(aspectNames)).append("\n");
		sb.append("    properties: ").append(toIndentedString(properties)).append("\n");
		sb.append("    capabilities: ").append(toIndentedString(capabilities)).append("\n");
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
