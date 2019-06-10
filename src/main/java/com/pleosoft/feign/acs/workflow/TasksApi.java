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

import com.pleosoft.feign.acs.workflow.model.CandidatePaging;
import com.pleosoft.feign.acs.workflow.model.ItemBody;
import com.pleosoft.feign.acs.workflow.model.ItemPaging;
import com.pleosoft.feign.acs.workflow.model.TaskBody;
import com.pleosoft.feign.acs.workflow.model.TaskEntry;
import com.pleosoft.feign.acs.workflow.model.TaskFormModelPaging;
import com.pleosoft.feign.acs.workflow.model.TaskPaging;
import com.pleosoft.feign.acs.workflow.model.Variable;
import com.pleosoft.feign.acs.workflow.model.VariableEntry;
import com.pleosoft.feign.acs.workflow.model.VariablePaging;

public interface TasksApi {

	/**
	 * Create an item
	 *
	 * <p>
	 * Creates an item for a given task **taskId**. If the item already is part
	 * of that task the request will have no effect. **Note:** You can create
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
	 * @param taskId
	 *            ("The identifier of a task.",required=true)
	 * @param itemBody
	 *            (value = "The nodeId of the item" ,required=true )
	 * @return value = { <br/>
	 *         code = 201, message = "Successful response", response =
	 *         ItemPaging.class),<br/>
	 *         code = 400, message = "Invalid parameter: **itemBody** is invalid
	 *         "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 404, message = "**taskId** does not exist "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/tasks/{taskId}/items", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	ResponseEntity<ItemPaging> createTaskItem(@PathVariable("taskId") String taskId, @RequestBody ItemBody itemBody);

	/**
	 * Create or update variables
	 *
	 * <p>
	 * Create or update a variable for the task **taskId**. If the variable does
	 * not exist yet, it will be created. **Note:** You can create or update
	 * more than one variable by specifying a list of variables in the JSON body
	 * like this: ```JSON [ { \"name\": \"string\", \"value\": \"string\",
	 * \"type\": \"string\" }, { \"name\": \"string\", \"value\": \"string\",
	 * \"type\": \"string\" } ] ``` If you specify a list as input, then a
	 * paginated list rather than an entry is returned in the response body. For
	 * example: ```JSON { \"list\": { \"pagination\": { \"count\": 2,
	 * \"hasMoreItems\": false, \"totalItems\": 2, \"skipCount\": 0,
	 * \"maxItems\": 100 }, \"entries\": [ { \"entry\": { ... } }, { \"entry\":
	 * { ... } } ] } } ```
	 * </p>
	 *
	 *
	 * @param taskId
	 *            ("The identifier of a task.",required=true)
	 * @param variable
	 *            (value = "A variable" ,required=true )
	 * @return value = { <br/>
	 *         code = 201, message = "Successful response", response =
	 *         VariableEntry.class),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 404, message = "**taskId** does not exist "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/tasks/{taskId}/variables", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	ResponseEntity<VariableEntry> createTaskVariables(@PathVariable("taskId") String taskId,
			@RequestBody Variable variable);

	/**
	 * Delete an item
	 *
	 * <p>
	 * Deletes the item with the specified **itemId** from the task with the
	 * specified **taskId**.
	 * </p>
	 *
	 *
	 * @param taskId
	 *            ("The identifier of a task.",required=true)
	 * @param itemId
	 *            ("The identifier of an item.",required=true)
	 * @return value = { <br/>
	 *         code = 204, message = "Successful response"),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 404, message = "The **taskId** does not exist or the
	 *         **itemId** does not exist"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/tasks/{taskId}/items/{itemId}", produces = "application/json",  method = RequestMethod.DELETE)
	ResponseEntity<Void> deleteTaskItem(@PathVariable("taskId") String taskId, @PathVariable("itemId") String itemId);

	/**
	 * Delete a variable
	 *
	 * <p>
	 * Deletes the variable with the specified **variableName** from the task
	 * with the specified **taskId**.
	 * </p>
	 *
	 *
	 * @param taskId
	 *            ("The identifier of a task.",required=true)
	 * @param variableName
	 *            ("The name of a variable.",required=true)
	 * @return value = { <br/>
	 *         code = 204, message = "Successful response"),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 404, message = "The **taskId** does not exist or the
	 *         **variableName** does not exist"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/tasks/{taskId}/variables/{variableName}", produces = "application/json",  method = RequestMethod.DELETE)
	ResponseEntity<Void> deleteTaskVariable(@PathVariable("taskId") String taskId,
			@PathVariable("variableName") String variableName);

	/**
	 * Get a task
	 *
	 * <p>
	 * Gets the task identified by **taskId**. An authenticated user will have
	 * access to a task if the user has started the process or if the user is
	 * involved in any of the process’s tasks. In a network, only tasks that are
	 * inside the given network are returned. In non-network deployments,
	 * administrators can see all processes and perform all operations on tasks.
	 * In network deployments, network administrators can see all processes in
	 * their network and perform all operations on tasks in their network.
	 * </p>
	 *
	 *
	 * @param taskId
	 *            ("The identifier of a task.",required=true)
	 * @param properties
	 *            ("A list of property names. You can use the properties
	 *            parameter to restrict the number of returned properties.")
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response", response =
	 *         TaskEntry.class),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 404, message = "**taskId** does not exist "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/tasks/{taskId}", produces = "application/json",  method = RequestMethod.GET)
	ResponseEntity<TaskEntry> getTask(@PathVariable("taskId") String taskId,
			@RequestParam(value = "properties", required = false) List<String> properties);

	/**
	 * Get a task form model
	 *
	 * <p>
	 * Gets the model of the task form type definition. An authenticated user
	 * will have access to access to all task form models. In a network, only
	 * task form models that are inside the given network are returned.
	 * </p>
	 *
	 *
	 * @param taskId
	 *            ("The identifier of a task.",required=true)
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
	 *         TaskFormModelPaging.class),<br/>
	 *         code = 400, message = "Invalid parameter: value of **maxItems**
	 *         or **skipCount** is invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 404, message = "**taskId** does not exist "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/tasks/{taskId}/task-form-model", produces = "application/json",  method = RequestMethod.GET)
	ResponseEntity<TaskFormModelPaging> getTaskFormModel(@PathVariable("taskId") String taskId,
			@Min(0) @RequestParam(value = "skipCount", required = false) Integer skipCount,
			@Min(1) @RequestParam(value = "maxItems", required = false) Integer maxItems,
			@RequestParam(value = "properties", required = false) List<String> properties);

	/**
	 * List task candidates
	 *
	 * <p>
	 * Gets a list of candidate users and groups for the specified task
	 * **taskId**.
	 * </p>
	 *
	 *
	 * @param taskId
	 *            ("The identifier of a task.",required=true)
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
	 *         CandidatePaging.class),<br/>
	 *         code = 400, message = "Invalid parameter: value of **maxItems**
	 *         or **skipCount** is invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 404, message = "**taskId** does not exist "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/tasks/{taskId}/candidates", produces = "application/json",  method = RequestMethod.GET)
	ResponseEntity<CandidatePaging> listTaskCandidates(@PathVariable("taskId") String taskId,
			@Min(0) @RequestParam(value = "skipCount", required = false) Integer skipCount,
			@Min(1) @RequestParam(value = "maxItems", required = false) Integer maxItems,
			@RequestParam(value = "properties", required = false) List<String> properties);

	/**
	 * List items
	 *
	 * <p>
	 * Gets a list of items for the specified task **taskId**. An authenticated
	 * user will have access to a task's items if the user has started the
	 * process or if the user is involved in any of the process’s tasks. In a
	 * network, only items for a process that is inside the given network are
	 * returned. In non-network deployments, administrators can see all items
	 * and perform all operations on those items. In network deployments,
	 * network administrators can see all items in their network and perform all
	 * operations on items in their network.
	 * </p>
	 *
	 *
	 * @param taskId
	 *            ("The identifier of a task.",required=true)
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
	 *         code = 404, message = "**taskId** does not exist "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/tasks/{taskId}/items", produces = "application/json",  method = RequestMethod.GET)
	ResponseEntity<ItemPaging> listTaskItems(@PathVariable("taskId") String taskId,
			@Min(0) @RequestParam(value = "skipCount", required = false) Integer skipCount,
			@Min(1) @RequestParam(value = "maxItems", required = false) Integer maxItems,
			@RequestParam(value = "properties", required = false) List<String> properties);

	/**
	 * List variables
	 *
	 * <p>
	 * Gets a list of variables for the specified task **taskId**. An
	 * authenticated user will have access to a tasks variables if the user has
	 * started the process or if the user is involved in any of the process’s
	 * tasks. In a network, only variables for a process that is inside the
	 * given network are returned. In non-network deployments, administrators
	 * can see all variables and perform all operations on those variable. In
	 * network deployments, network administrators can see all variables in
	 * their network and perform all operations on variables in their network.
	 * </p>
	 *
	 *
	 * @param taskId
	 *            ("The identifier of a task.",required=true)
	 * @param skipCount
	 *            ("The number of entities that exist in the collection before
	 *            those included in this list.")
	 * @param maxItems
	 *            ("The maximum number of items to return in the list.")
	 * @param properties
	 *            ("A list of property names. You can use the properties
	 *            parameter to restrict the number of returned properties.")
	 * @param where
	 *            ("A string to restrict the returned objects by using a
	 *            predicate.")
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response", response =
	 *         VariablePaging.class),<br/>
	 *         code = 400, message = "Invalid parameter: value of **maxItems**,
	 *         **skipCount**, or **where** is invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 404, message = "**taskId** does not exist "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/tasks/{taskId}/variables", produces = "application/json",  method = RequestMethod.GET)
	ResponseEntity<VariablePaging> listTaskVariables(@PathVariable("taskId") String taskId,
			@Min(0) @RequestParam(value = "skipCount", required = false) Integer skipCount,
			@Min(1) @RequestParam(value = "maxItems", required = false) Integer maxItems,
			@RequestParam(value = "properties", required = false) List<String> properties,
			@RequestParam(value = "where", required = false) String where);

	/**
	 * List tasks
	 *
	 * <p>
	 * Gets a list of tasks visible to the authenticated user. Tasks are
	 * returned for which the authenticated user is the assignee or a candidate.
	 * If networks are enabled, the only tasks that are inside the given network
	 * are returned. In non-network deployments, administrators can see all
	 * processes and perform all operations on tasks. In network deployments,
	 * network administrators can see all processes in their network and perform
	 * all operations on tasks in their network.
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
	 *         TaskPaging.class),<br/>
	 *         code = 400, message = "Invalid parameter: value of **maxItems**,
	 *         **skipCount**, **orderBy**, or **where** is invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/tasks", produces = "application/json",  method = RequestMethod.GET)
	ResponseEntity<TaskPaging> listTasks(@Min(0) @RequestParam(value = "skipCount", required = false) Integer skipCount,
			@Min(1) @RequestParam(value = "maxItems", required = false) Integer maxItems,
			@RequestParam(value = "properties", required = false) List<String> properties,
			@RequestParam(value = "orderBy", required = false) List<String> orderBy,
			@RequestParam(value = "where", required = false) String where);

	/**
	 * List tasks for a process
	 *
	 * <p>
	 * Gets a list of tasks for the specified process **processId**. An
	 * authenticated user will have access to a processes tasks if the user has
	 * started the process or if the user is involved in any of the process’s
	 * tasks. In a network, only tasks for a process that is inside the given
	 * network are returned. In non-network deployments, administrators can see
	 * all tasks and perform all operations on those tasks. In network
	 * deployments, network administrators can see all tasks in their network
	 * and perform all operations on tasks in their network.
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
	 * @param orderBy
	 *            ("A string to control the order of the entities returned in a
	 *            list. You can use the **orderby** parameter to sort the list
	 *            by one or more fields. Each field has a default sort order,
	 *            which is normally ascending order. Read the API method
	 *            implementation notes above to check if any fields used in this
	 *            method have a descending default search order. To sort the
	 *            entities in a specific order, you can use the **ASC** and
	 *            **DESC** keywords for any field. ")
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response", response =
	 *         TaskPaging.class),<br/>
	 *         code = 400, message = "Invalid parameter: value of **maxItems**,
	 *         **skipCount**, or **orderBy** is invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 404, message = "**processId** does not exist "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/processes/{processId}/tasks", produces = "application/json",  method = RequestMethod.GET)
	ResponseEntity<TaskPaging> listTasksForProcess(@PathVariable("processId") String processId,
			@Min(0) @RequestParam(value = "skipCount", required = false) Integer skipCount,
			@Min(1) @RequestParam(value = "maxItems", required = false) Integer maxItems,
			@RequestParam(value = "properties", required = false) List<String> properties,
			@RequestParam(value = "orderBy", required = false) List<String> orderBy);

	/**
	 * Update a task
	 *
	 * <p>
	 * Updates the state of the task **taskId**. To perform a task action the
	 * authenticated user must be the assignee or a candidate. If networks is
	 * enabled, the task action is only performed if the task is inside the
	 * given network. In non-network deployments, administrators can perform all
	 * operations on tasks. In network deployments, network administrators can
	 * see all tasks in their network and perform all operations on tasks in
	 * their network. You use the **select** parameter in the URL to specify a
	 * comma-separated list of properties in the task that you want to update.
	 * Use the JSON body to specify the new values for those properties. So for
	 * example to change the state of task **123** to **completed**, use this
	 * URL
	 * http://localhost:8080/alfresco/api/-default-/public/workflow/versions/1/tasks/123?select=state,
	 * and provide this request body: ```JSON { \"state\": \"completed\" } ```
	 * State Transitions ================= Clients can invoke actions by
	 * assigning an allowed value to the state property of a task. The select
	 * parameter can be used to allow for a partial update of the resource.
	 * Alfresco will check for illegal state transitions and return an HTTP Bad
	 * Request (Response 400) if an illegal state transition is attempted. There
	 * are five state transitions, completing, claiming, unclaiming, delegating,
	 * resolving. Completing a task ----------------- If variables are included
	 * in the JSON body, they will be set in the task and then the process will
	 * continue. To complete a task, the authenticated user must be the assignee
	 * of the task, the owner of the task, or have started the process. In
	 * non-network deployments, administrators can perform this task operation
	 * on all tasks. In network deployments, network administrators can perform
	 * this action on all tasks in their network. Here's an example PUT request
	 * ``` /tasks/123?select=state,variables ``` Here's is a corresponding PUT
	 * request body: ```JSON { “state : “completed”, “variables” : [ { \"name\"
	 * : \"bpm_priority\", \"type\" : \"d_int\", \"value\" : 1, \"scope\" :
	 * \"global\" } ] } ``` Claiming a task ----------------- To claim a task,
	 * the authenticated user must be the assignee of the task, the owner of the
	 * task, or have started the process. Here's an example PUT request ```
	 * /tasks/123?select=state ``` Here's a corresponding PUT request body:
	 * ```JSON { “state : “claimed” } ``` Unclaiming a task -----------------
	 * This removes the current assignee of the task. To unclaim a task, the
	 * authenticated user must be the assignee of the task, the owner of the
	 * task, or have started the process. Here's an example PUT request ```
	 * /tasks/123?select=state ``` Here's a corresponding PUT request body:
	 * ```JSON { “state : “unclaimed” } ``` Delegating a task -----------------
	 * This delegates the task from the owner to an assignee. The result is the
	 * same as if the assignee had claimed the task, but the task can then be
	 * resolved and the owner will become the assignee again. To delegate a
	 * task, the authenticated user must be the assignee of the task and the
	 * assignee must be different from the owner. Here's an example PUT request
	 * ``` /tasks/123?select=state,assignee ``` Here's a corresponding PUT
	 * request body: ```JSON { “state : “delegated”, “assignee : “Kermit” } ```
	 * Resolving a task ----------------- This returns a delegated task back to
	 * the owner. In order to delegate a task, the authenticated user must be
	 * the assignee of the task and the assignee must be different from the
	 * owner. To resolve a task, the authenticated user must be the assignee of
	 * the task, the owner of the task, or have started the process. Here's an
	 * example PUT request ``` /tasks/123?select=state ``` Here's a
	 * corresponding PUT request body: ```JSON { “state : “resolved” } ```
	 * </p>
	 *
	 *
	 * @param taskId
	 *            ("The identifier of a task.",required=true)
	 * @param taskBody
	 *            (value = "An object containing the properties to be updated"
	 *            ,required=true )
	 * @param select
	 *            ("A string specifying a required subset of properties to be
	 *            returned for an entity or list of entities. Properties are
	 *            separated by commas.")
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response", response =
	 *         TaskEntry.class),<br/>
	 *         code = 400, message = "Invalid parameter: **taskBody** is invalid
	 *         "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/tasks/{taskId}", produces = "application/json", consumes = "application/json", method = RequestMethod.PUT)
	ResponseEntity<TaskEntry> updateTask(@PathVariable("taskId") String taskId, @RequestBody TaskBody taskBody,
			@RequestParam(value = "select", required = false) Integer select);

	/**
	 * Create or update a variable
	 *
	 * <p>
	 * Creates or updates a specific variable **variableName** for a given task
	 * **taskId**.
	 * </p>
	 *
	 *
	 * @param taskId
	 *            ("The identifier of a task.",required=true)
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
	 *         code = 404, message = "**taskId** does not exist "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/tasks/{taskId}/variables/{variableName}", produces = "application/json", consumes = "application/json", method = RequestMethod.PUT)
	ResponseEntity<VariableEntry> updateTaskVariable(@PathVariable("taskId") String taskId,
			@PathVariable("variableName") String variableName, @RequestBody Variable variableBody);

}
