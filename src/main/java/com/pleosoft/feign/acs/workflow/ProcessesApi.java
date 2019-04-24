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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pleosoft.feign.acs.workflow.model.ItemBody;
import com.pleosoft.feign.acs.workflow.model.ItemPaging;
import com.pleosoft.feign.acs.workflow.model.ProcessBody;
import com.pleosoft.feign.acs.workflow.model.ProcessEntry;
import com.pleosoft.feign.acs.workflow.model.ProcessPaging;
import com.pleosoft.feign.acs.workflow.model.VariableBody;
import com.pleosoft.feign.acs.workflow.model.VariableEntry;
import com.pleosoft.feign.acs.workflow.model.VariablePaging;

public interface ProcessesApi {

	/**
	 * Create a process
	 *
	 * <p>
	 * Creates a new process. In non-network deployments, any authenticated user
	 * can start a new process for any process definition. If networks are
	 * enabled, the authenticated user can start a new process for a process
	 * definition in the user's network. **Note:** You can start more than one
	 * process by specifying a list of process entries in the JSON body like
	 * this: ```JSON [ { \"processDefinitionKey\": \"activitiAdhoc\",
	 * \"variables\": { \"bpm_assignee\": \"fred\" } }, {
	 * \"processDefinitionKey\": \"activitiAdhoc\", \"variables\": {
	 * \"bpm_assignee\": \"joe\" } ] ``` If you specify a list as input, then a
	 * paginated list rather than an entry is returned in the response body. For
	 * example: ```JSON { \"list\": { \"pagination\": { \"count\": 2,
	 * \"hasMoreItems\": false, \"totalItems\": 2, \"skipCount\": 0,
	 * \"maxItems\": 100 }, \"entries\": [ { \"entry\": { ... } }, { \"entry\":
	 * { ... } } ] } } ```
	 * </p>
	 *
	 *
	 * @param processBody
	 *            (value = "process properties" ,required=true )
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response", response =
	 *         ProcessEntry.class),<br/>
	 *         code = 400, message = "Invalid parameter: **processBody** is
	 *         invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/processes", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	ResponseEntity<ProcessEntry> createProcess(@RequestBody ProcessBody processBody);

	/**
	 * Create an item
	 *
	 * <p>
	 * Creates an item for process **processId**\". If the item already is part
	 * of that process the request will have no effect. **Note:** You can create
	 * more than one item by specifying a list of items in the JSON body like
	 * this: ```JSON [ { \"id\": \"1ff9da1a-ee2f-4b9c-8c34-44665e844444\" }, {
	 * \"id\": \"1ff9da1a-ee2f-4b9c-8c34-44665e855555\" } ] ``` If you specify a
	 * list as input, then a paginated list rather than an entry is returned in
	 * the response body. For example: ```JSON { \"list\": { \"pagination\": {
	 * \"count\": 2, \"hasMoreItems\": false, \"totalItems\": 2, \"skipCount\":
	 * 0, \"maxItems\": 100 }, \"entries\": [ { \"entry\": { ... } }, {
	 * \"entry\": { ... } } ] } } ```
	 * </p>
	 *
	 *
	 * @param processId
	 *            ("The identifier of a process.",required=true)
	 * @param itemBody
	 *            (value = "The **nodeId** of the item" ,required=true )
	 * @return value = { <br/>
	 *         code = 201, message = "Successful response", response =
	 *         ItemPaging.class),<br/>
	 *         code = 400, message = "Invalid parameter: **itemBody** is invalid
	 *         "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 404, message = "**processId** does not exist "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/processes/{processId}/items", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	ResponseEntity<ItemPaging> createProcessItem(@PathVariable("processId") String processId,
			@RequestBody ItemBody itemBody);

	/**
	 * Create or update a variable
	 *
	 * <p>
	 * Creates or updates a specific variable **variableName** for process
	 * **processId**.
	 * </p>
	 *
	 *
	 * @param processId
	 *            ("The identifier of a process.",required=true)
	 * @param variableName
	 *            ("The name of a variable.",required=true)
	 * @param variableBody
	 *            (value = "A variable" ,required=true )
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response", response =
	 *         VariableEntry.class),<br/>
	 *         code = 400, message = "Invalid parameter: **variableBody** is
	 *         invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 404, message = "**processId** does not exist "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/processes/{processId}/variables/{variableName}", produces = "application/json", consumes = "application/json", method = RequestMethod.PUT)
	ResponseEntity<VariableEntry> createProcessVariable(@PathVariable("processId") String processId,
			@PathVariable("variableName") String variableName, @RequestBody VariableBody variableBody);

	/**
	 * Create or update variables
	 *
	 * <p>
	 * Create or update a variable for a given process. If the variable does not
	 * exist yet, it will be created. **Note:** You can create or update more
	 * than one variable by specifying a list of variables in the JSON body like
	 * this: ```JSON [ { \"name\": \"string\", \"value\": \"string\", \"type\":
	 * \"string\" }, { \"name\": \"string\", \"value\": \"string\", \"type\":
	 * \"string\" } ] ``` If you specify a list as input, then a paginated list
	 * rather than an entry is returned in the response body. For example:
	 * ```JSON { \"list\": { \"pagination\": { \"count\": 2, \"hasMoreItems\":
	 * false, \"totalItems\": 2, \"skipCount\": 0, \"maxItems\": 100 },
	 * \"entries\": [ { \"entry\": { ... } }, { \"entry\": { ... } } ] } } ```
	 * </p>
	 *
	 *
	 * @param processId
	 *            ("The identifier of a process.",required=true)
	 * @param variableBody
	 *            (value = "A variable" ,required=true )
	 * @return value = { <br/>
	 *         code = 201, message = "Successful response", response =
	 *         VariableEntry.class),<br/>
	 *         code = 400, message = "Invalid parameter: **variableBody** is
	 *         invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 404, message = "**processId** does not exist "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/processes/{processId}/variables", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	ResponseEntity<VariableEntry> createProcessVariables(@PathVariable("processId") String processId,
			@RequestBody VariableBody variableBody);

	/**
	 * Delete a process
	 *
	 * <p>
	 * Deletes the process with the specified **processId**.
	 * </p>
	 *
	 *
	 * @param processId
	 *            ("The identifier of a process.",required=true)
	 * @return value = { <br/>
	 *         code = 204, message = "Successful response"),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 404, message = "The processId does not exist"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/processes/{processId}", produces = "application/json", consumes = "", method = RequestMethod.DELETE)
	ResponseEntity<Void> deleteProcess(@PathVariable("processId") String processId);

	/**
	 * Delete an item
	 *
	 * <p>
	 * Deletes the item with the specified **itemId** from the process with the
	 * specified **processId**.
	 * </p>
	 *
	 *
	 * @param processId
	 *            ("The identifier of a process.",required=true)
	 * @param itemId
	 *            ("The identifier of an item.",required=true)
	 * @return value = { <br/>
	 *         code = 204, message = "Successful response"),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 404, message = "The **processId** does not exist or the
	 *         **itemId** does not exist"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/processes/{processId}/items/{itemId}", produces = "application/json", consumes = "", method = RequestMethod.DELETE)
	ResponseEntity<Void> deleteProcessItem(@PathVariable("processId") String processId,
			@PathVariable("itemId") String itemId);

	/**
	 * Delete a variable
	 *
	 * <p>
	 * Deletes the variable **variableName** from the process with the specified
	 * **processId**.
	 * </p>
	 *
	 *
	 * @param processId
	 *            ("The identifier of a process.",required=true)
	 * @param variableName
	 *            ("The name of a variable.",required=true)
	 * @return value = { <br/>
	 *         code = 204, message = "Successful response"),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 404, message = "The **processId** does not exist or the
	 *         **variableName** does not exist"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/processes/{processId}/variables/{variableName}", produces = "application/json", consumes = "", method = RequestMethod.DELETE)
	ResponseEntity<Void> deleteProcessVariable(@PathVariable("processId") String processId,
			@PathVariable("variableName") String variableName);

	/**
	 * Get a process
	 *
	 * <p>
	 * Gets the process identified by **processId**. An authenticated user will
	 * have access to a process if the user has started the process or if the
	 * user is involved in any of the process’s tasks. In a network, only
	 * processes that are inside the given network are returned. In non-network
	 * deployments, administrators can see all processes and perform all
	 * operations on tasks. In network deployments, network administrators can
	 * see all processes in their network and perform all operations on tasks in
	 * their network.
	 * </p>
	 *
	 *
	 * @param processId
	 *            ("The identifier of a process.",required=true)
	 * @param properties
	 *            ("A list of property names. You can use the properties
	 *            parameter to restrict the number of returned properties.")
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response", response =
	 *         ProcessEntry.class),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 404, message = "**processId** does not exist "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/processes/{processId}", produces = "application/json", consumes = "", method = RequestMethod.GET)
	ResponseEntity<ProcessEntry> getProcess(@PathVariable("processId") String processId,
			@RequestParam(value = "properties", required = false) List<String> properties);

	/**
	 * List items
	 *
	 * <p>
	 * Gets a list of items for the specified process **processId**. An
	 * authenticated user will have access to a processes items if the user has
	 * started the process or if the user is involved in any of the process’s
	 * tasks. In a network, only items for a process that is inside the given
	 * network are returned. In non-network deployments, administrators can see
	 * all items and perform all operations on those items. In network
	 * deployments, network administrators can see all items in their network
	 * and perform all operations on items in their network.
	 * </p>
	 *
	 *
	 * @param processId
	 *            ("The identifier of a process.",required=true)
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
	 *         ItemPaging.class),<br/>
	 *         code = 400, message = "Invalid parameter: value of **maxItems**
	 *         or **skipCount** is invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 404, message = "**processId** does not exist "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/processes/{processId}/items", produces = "application/json", consumes = "", method = RequestMethod.GET)
	ResponseEntity<ItemPaging> listProcessItems(@PathVariable("processId") String processId,
			@Min(0) @RequestParam(value = "skipCount", required = false) Integer skipCount,
			@Min(1) @RequestParam(value = "maxItems", required = false) Integer maxItems,
			@RequestParam(value = "properties", required = false) List<String> properties);

	/**
	 * List variables
	 *
	 * <p>
	 * Gets a list of variables for the process **processId**. An authenticated
	 * user will have access to a processes variables if the user has started
	 * the process or if the user is involved in any of the process’s tasks. In
	 * a network, only variables for a process that is inside the given network
	 * are returned. In non-network deployments, administrators can see all
	 * variables and perform all operations on those variable. In network
	 * deployments, network administrators can see all variables in their
	 * network and perform all operations on variables in their network.
	 * </p>
	 *
	 *
	 * @param processId
	 *            ("The identifier of a process.",required=true)
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
	 *         VariablePaging.class),<br/>
	 *         code = 400, message = "Invalid parameter: value of **maxItems**
	 *         or **skipCount** is invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 404, message = "**processId** does not exist "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/processes/{processId}/variables", produces = "application/json", consumes = "", method = RequestMethod.GET)
	ResponseEntity<VariablePaging> listProcessVariables(@PathVariable("processId") String processId,
			@Min(0) @RequestParam(value = "skipCount", required = false) Integer skipCount,
			@Min(1) @RequestParam(value = "maxItems", required = false) Integer maxItems,
			@RequestParam(value = "properties", required = false) List<String> properties);

	/**
	 * List processes
	 *
	 * <p>
	 * Gets a list of processes. An authenticated user will have access to a
	 * processes if the user has started the process or if the user is involved
	 * in any of the process’s tasks. In a network, only processes that are
	 * inside the given network are returned. In non-network deployments, any
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
	 *         ProcessPaging.class),<br/>
	 *         code = 400, message = "Invalid parameter: value of **maxItems**,
	 *         **skipCount**, **orderBy**, or **where** is invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/processes", produces = "application/json", consumes = "", method = RequestMethod.GET)
	ResponseEntity<ProcessPaging> listProcesses(
			@Min(0) @RequestParam(value = "skipCount", required = false) Integer skipCount,
			@Min(1) @RequestParam(value = "maxItems", required = false) Integer maxItems,
			@RequestParam(value = "properties", required = false) List<String> properties,
			@RequestParam(value = "orderBy", required = false) List<String> orderBy,
			@RequestParam(value = "where", required = false) String where);

}
