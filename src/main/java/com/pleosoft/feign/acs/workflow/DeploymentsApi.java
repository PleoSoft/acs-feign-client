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

package com.pleosoft.feign.acs.workflow;

import java.util.List;

import javax.validation.constraints.Min;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pleosoft.feign.acs.workflow.model.DeploymentEntry;
import com.pleosoft.feign.acs.workflow.model.DeploymentPaging;

public interface DeploymentsApi {

	/**
	 * Delete a deployment
	 *
	 * <p>
	 * This request will delete the deployment including the tasks, process
	 * definitions contained in the deployment. The request will also delete
	 * processes and history information associated with the deployment.
	 * </p>
	 *
	 *
	 * @param deploymentId
	 *            ("The unique id must be a String. It is returned as an **id**
	 *            from the entity",required=true)
	 * @return value = { <br/>
	 *         code = 204, message = "Successful response"),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/deployments/{deploymentId}", produces = "application/json", consumes = "", method = RequestMethod.DELETE)
	ResponseEntity<Void> deleteDeployment(@PathVariable("deploymentId") String deploymentId);

	/**
	 * Get a deployment
	 *
	 * <p>
	 * Gets a specified deployment defined by **deploymentId**. The
	 * authenticated user must have role admin (non-network deployments) or
	 * network admin (networks enabled). If networks are enabled, the deployment
	 * is only returned if the deployment is in the given network.
	 * </p>
	 *
	 *
	 * @param deploymentId
	 *            ("The unique id must be a String. It is returned as an **id**
	 *            from the entity.",required=true)
	 * @param properties
	 *            ("A list of property names. You can use the properties
	 *            parameter to restrict the number of returned properties.")
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response", response =
	 *         DeploymentEntry.class),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 404, message = "**deploymentId** does not exist "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/deployments/{deploymentId}", produces = "application/json", consumes = "", method = RequestMethod.GET)
	ResponseEntity<DeploymentEntry> getDeployment(@PathVariable("deploymentId") String deploymentId,
			@RequestParam(value = "properties", required = false) List<String> properties);

	/**
	 * List deployments
	 *
	 * <p>
	 * Gets a list of deployments. The authenticated user must have role admin
	 * (non-network deployments) or network admin (networks enabled). If
	 * networks are enabled, the network admin can only see the deployments in
	 * the given network.
	 * </p>
	 *
	 *
	 * @param skipCount
	 *            ("The number of entities that exist in the collection before
	 *            those included in this list.")
	 * @param maxItems
	 *            ("The maximum number of items to return in the list.")
	 * @param properties
	 *            ("A list of property names. You can use the properties
	 *            parameter to restrict the number of returned properties.")
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response", response =
	 *         DeploymentPaging.class),<br/>
	 *         code = 400, message = "Invalid parameter: value of **maxItems**
	 *         or **skipCount** is invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/deployments", produces = "application/json", consumes = "", method = RequestMethod.GET)
	ResponseEntity<DeploymentPaging> listDeployments(
			@Min(0) @RequestParam(value = "skipCount", required = false) Integer skipCount,
			@Min(1) @RequestParam(value = "maxItems", required = false) Integer maxItems,
			@RequestParam(value = "properties", required = false) List<String> properties);

}
