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

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pleosoft.feign.acs.workflow.model.ProcessDefinitionEntry;
import com.pleosoft.feign.acs.workflow.model.ProcessDefinitionPaging;
import com.pleosoft.feign.acs.workflow.model.TaskFormModelPaging;

public interface ProcessDefinitionsApi {

	/**
	 * Get a process definition
	 *
	 * <p>
	 * Gets a process definition identified by **processDefinitionId**. In
	 * non-network deployments, any authenticated user will see all the process
	 * definitions. If networks are enabled, the network admin can only see the
	 * deployments in the given network.
	 * </p>
	 *
	 *
	 * @param processDefinitionId
	 *            ("The identifier of a process definition.",required=true)
	 * @param properties
	 *            ("A list of property names. You can use the properties
	 *            parameter to restrict the number of returned properties.")
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response", response =
	 *         ProcessDefinitionEntry.class),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 404, message = "**processDefinitionId** does not exist
	 *         "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/process-definitions/{processDefinitionId}", produces = "application/json",  method = RequestMethod.GET)
	ResponseEntity<ProcessDefinitionEntry> getProcessDefinition(
			@PathVariable("processDefinitionId") String processDefinitionId,
			@RequestParam(value = "properties", required = false) List<String> properties);

	/**
	 * Get a process definition image
	 *
	 * <p>
	 * Gets an image that represents a single process definition identified by
	 * **processDefinitionId**. In non-network deployments, any authenticated
	 * user will see all the process definitions. If networks are enabled, the
	 * network admin can only see the deployments in the given network.
	 * </p>
	 *
	 *
	 * @param processDefinitionId
	 *            ("The identifier of a process definition.",required=true)
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response", response =
	 *         Resource.class),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 404, message = "**processDefinitionId** does not exist
	 *         "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/process-definitions/{processDefinitionId}/image", produces = "application/json",  method = RequestMethod.GET)
	ResponseEntity<Resource> getProcessDefinitionImage(@PathVariable("processDefinitionId") String processDefinitionId);

	/**
	 * Get a start form model
	 *
	 * <p>
	 * Gets a model of the start form type definition. An authenticated user
	 * will have access to all start form models. In a network, only start form
	 * models that are inside the given network are returned.
	 * </p>
	 *
	 *
	 * @param processDefinitionId
	 *            ("The identifier of a process definition.",required=true)
	 * @param properties
	 *            ("A list of property names. You can use the properties
	 *            parameter to restrict the number of returned properties.")
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response", response =
	 *         TaskFormModelPaging.class),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 404, message = "**processDefinitionId** does not exist
	 *         "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/process-definitions/{processDefinitionId}/start-form-model", produces = "application/json",  method = RequestMethod.GET)
	ResponseEntity<TaskFormModelPaging> getProcessDefinitionStartFormModel(
			@PathVariable("processDefinitionId") String processDefinitionId,
			@RequestParam(value = "properties", required = false) List<String> properties);

	/**
	 * List process definitions
	 *
	 * <p>
	 * Gets a list of process definitions. In non-network deployments, any
	 * authenticated user will see all the process definitions. If networks are
	 * enabled, the network admin can only see the deployments in the given
	 * network.
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
	 * @param orderBy
	 *            ("A string to control the order of the entities returned in a
	 *            list. You can use the **orderby** parameter to sort the list
	 *            by one or more fields. Each field has a default sort order,
	 *            which is normally ascending order. Read the API method
	 *            implementation notes above to check if any fields used in this
	 *            method have a descending default search order. To sort the
	 *            entities in a specific order, you can use the **ASC** and
	 *            **DESC** keywords for any field. ")
	 * @param where
	 *            ("A string to restrict the returned objects by using a
	 *            predicate.")
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response", response =
	 *         ProcessDefinitionPaging.class),<br/>
	 *         code = 400, message = "Invalid parameter: value of **maxItems**,
	 *         **skipCount**, **orderBy**, or **where** is invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/process-definitions", produces = "application/json",  method = RequestMethod.GET)
	ResponseEntity<ProcessDefinitionPaging> listProcessDefinitions(
			@Min(0) @RequestParam(value = "skipCount", required = false) Integer skipCount,
			@Min(1) @RequestParam(value = "maxItems", required = false) Integer maxItems,
			@RequestParam(value = "properties", required = false) List<String> properties,
			@RequestParam(value = "orderBy", required = false) List<String> orderBy,
			@RequestParam(value = "where", required = false) String where);

}
