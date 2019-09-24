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

package com.pleosoft.feign.acs.core;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pleosoft.feign.acs.core.model.ProbeEntry;

public interface ProbesApi {

	/**
	 * Check readiness and liveness of the repository
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 6.0 and newer versions.
	 * Returns a status of 200 to indicate success and 503 for failure. The
	 * readiness probe is normally only used to check repository startup. The
	 * liveness probe should then be used to check the repository is still
	 * responding to requests. **Note:** No authentication is required to call this
	 * endpoint.
	 * </p>
	 *
	 *
	 * @param probeId ("The name of the probe: * -ready- * -live- ",required=true)
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response", response =
	 *         ProbeEntry.class),<br/>
	 *         code = 404, message = "**probeId** does not exist "),<br/>
	 *         code = 503, message = "Service Unavailable - Probe failure
	 *         status."),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/probes/{probeId}", produces = "application/json", method = RequestMethod.GET)
	ResponseEntity<ProbeEntry> getProbe(@PathVariable("probeId") String probeId);

}
