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
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

@Validated

public class PermissionsBodyUpdate {
	@JsonProperty("isInheritanceEnabled")
	private Boolean isInheritanceEnabled = null;

	@JsonProperty("locallySet")
	@Valid
	private List<PermissionElement> locallySet = null;

	public PermissionsBodyUpdate isInheritanceEnabled(Boolean isInheritanceEnabled) {
		this.isInheritanceEnabled = isInheritanceEnabled;
		return this;
	}

	/**
	 * Get isInheritanceEnabled
	 * 
	 * @return isInheritanceEnabled
	 **/

	public Boolean isIsInheritanceEnabled() {
		return isInheritanceEnabled;
	}

	public void setIsInheritanceEnabled(Boolean isInheritanceEnabled) {
		this.isInheritanceEnabled = isInheritanceEnabled;
	}

	public PermissionsBodyUpdate locallySet(List<PermissionElement> locallySet) {
		this.locallySet = locallySet;
		return this;
	}

	public PermissionsBodyUpdate addLocallySetItem(PermissionElement locallySetItem) {
		if (this.locallySet == null) {
			this.locallySet = new ArrayList<PermissionElement>();
		}
		this.locallySet.add(locallySetItem);
		return this;
	}

	/**
	 * Get locallySet
	 * 
	 * @return locallySet
	 **/

	@Valid

	public List<PermissionElement> getLocallySet() {
		return locallySet;
	}

	public void setLocallySet(List<PermissionElement> locallySet) {
		this.locallySet = locallySet;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PermissionsBodyUpdate permissionsBodyUpdate = (PermissionsBodyUpdate) o;
		return Objects.equals(this.isInheritanceEnabled, permissionsBodyUpdate.isInheritanceEnabled)
				&& Objects.equals(this.locallySet, permissionsBodyUpdate.locallySet);
	}

	@Override
	public int hashCode() {
		return Objects.hash(isInheritanceEnabled, locallySet);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PermissionsBodyUpdate {\n");

		sb.append("    isInheritanceEnabled: ").append(toIndentedString(isInheritanceEnabled)).append("\n");
		sb.append("    locallySet: ").append(toIndentedString(locallySet)).append("\n");
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
