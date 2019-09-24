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

package com.pleosoft.feign.acs.discovery;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pleosoft.feign.acs.discovery.model.DiscoveryEntry;

public interface DiscoveryApi {

	/**
	 * Get repository information
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2 and newer versions.
	 * Retrieves the capabilities and detailed version information from the
	 * repository.
	 * </p>
	 *
	 *
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response", response =
	 *         DiscoveryEntry.class),<br/>
	 *         code = 501, message = "Discovery is disabled for the system"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/discovery", produces = "application/json", method = RequestMethod.GET)
	ResponseEntity<DiscoveryEntry> getRepositoryInformation();

}
