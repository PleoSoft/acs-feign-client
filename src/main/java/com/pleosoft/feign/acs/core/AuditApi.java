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

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pleosoft.feign.acs.core.model.AuditApp;
import com.pleosoft.feign.acs.core.model.AuditAppPaging;
import com.pleosoft.feign.acs.core.model.AuditBodyUpdate;
import com.pleosoft.feign.acs.core.model.AuditEntryEntry;
import com.pleosoft.feign.acs.core.model.AuditEntryPaging;

public interface AuditApi {

	/**
	 * Permanently delete audit entries for an audit application
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2.2 and newer versions.
	 * Permanently delete audit entries for an audit application
	 * **auditApplicationId**. The **where** clause must be specified, either with
	 * an inclusive time period or for an inclusive range of ids. The delete is
	 * within the context of the given audit application. For example: *
	 * ```where=(createdAt BETWEEN ('2017-06-02T12:13:51.593+01:00' ,
	 * '2017-06-04T10:05:16.536+01:00')``` * ```where=(id BETWEEN ('1234',
	 * '4321')``` You must have admin rights to delete audit information.
	 * </p>
	 *
	 *
	 * @param auditApplicationId ("The identifier of an audit
	 *                           application.",required=true)
	 * @param where              ("Audit entries to permanently delete for an audit
	 *                           application, given an inclusive time period or
	 *                           range of ids. For example: * ```where=(createdAt
	 *                           BETWEEN ('2017-06-02T12:13:51.593+01:00' ,
	 *                           '2017-06-04T10:05:16.536+01:00')``` * ```where=(id
	 *                           BETWEEN ('1234', '4321')``` ", required = true)
	 * @return value = { <br/>
	 *         code = 204, message = "Successful response"),<br/>
	 *         code = 400, message = "Invalid parameter: **auditApplicationId** is
	 *         not a valid format or invalid **where** "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "Current user does not have permission to
	 *         delete audit information"),<br/>
	 *         code = 404, message = "**auditApplicationId** does not exist "),<br/>
	 *         code = 501, message = "Audit is disabled for the system"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/audit-applications/{auditApplicationId}/audit-entries", produces = "application/json", method = RequestMethod.DELETE)
	ResponseEntity<Void> deleteAuditEntriesForAuditApp(@PathVariable("auditApplicationId") String auditApplicationId,
			@NotNull @RequestParam(value = "where", required = true) String where);

	/**
	 * Permanently delete an audit entry
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2.2 and newer versions.
	 * Permanently delete a single audit entry **auditEntryId**. You must have admin
	 * rights to delete audit information.
	 * </p>
	 *
	 *
	 * @param auditApplicationId ("The identifier of an audit
	 *                           application.",required=true)
	 * @param auditEntryId       ("The identifier of an audit entry.",required=true)
	 * @return value = { <br/>
	 *         code = 204, message = "Successful response"),<br/>
	 *         code = 400, message = "Invalid parameter: **auditApplicationId** or
	 *         **auditEntryId** is not a valid format "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "Current user does not have permission to
	 *         delete audit information"),<br/>
	 *         code = 404, message = "**auditApplicationId** or **auditEntryId**
	 *         does not exist "),<br/>
	 *         code = 501, message = "Audit is disabled for the system"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/audit-applications/{auditApplicationId}/audit-entries/{auditEntryId}", produces = "application/json", method = RequestMethod.DELETE)
	ResponseEntity<Void> deleteAuditEntry(@PathVariable("auditApplicationId") String auditApplicationId,
			@PathVariable("auditEntryId") String auditEntryId);

	/**
	 * Get audit application info
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2.2 and newer versions.
	 * Get status of an audit application **auditApplicationId**. You must have
	 * admin rights to retrieve audit information.
	 * </p>
	 *
	 *
	 * @param auditApplicationId ("The identifier of an audit
	 *                           application.",required=true)
	 * @param fields             ("A list of field names. You can use this parameter
	 *                           to restrict the fields returned within a response
	 *                           if, for example, you want to save on overall
	 *                           bandwidth. The list applies to a returned
	 *                           individual entity or entries within a collection.
	 *                           If the API method also supports the **include**
	 *                           parameter, then the fields specified in the
	 *                           **include** parameter are returned in addition to
	 *                           those specified in the **fields** parameter. ")
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response", response =
	 *         AuditApp.class),<br/>
	 *         code = 400, message = "Invalid parameter: invalid
	 *         **auditApplicationId** "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "User does not have permission to retrieve
	 *         audit information"),<br/>
	 *         code = 404, message = "**applicationId** does not exist "),<br/>
	 *         code = 501, message = "Audit is disabled for the system"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/audit-applications/{auditApplicationId}", produces = "application/json", method = RequestMethod.GET)
	ResponseEntity<AuditApp> getAuditApp(@PathVariable("auditApplicationId") String auditApplicationId,
			@RequestParam(value = "fields", required = false) List<String> fields);

	/**
	 * Get audit entry
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2.2 and newer versions.
	 * Gets audit entry **auditEntryId**. You must have admin rights to access audit
	 * information.
	 * </p>
	 *
	 *
	 * @param auditApplicationId ("The identifier of an audit
	 *                           application.",required=true)
	 * @param auditEntryId       ("The identifier of an audit entry.",required=true)
	 * @param fields             ("A list of field names. You can use this parameter
	 *                           to restrict the fields returned within a response
	 *                           if, for example, you want to save on overall
	 *                           bandwidth. The list applies to a returned
	 *                           individual entity or entries within a collection.
	 *                           If the API method also supports the **include**
	 *                           parameter, then the fields specified in the
	 *                           **include** parameter are returned in addition to
	 *                           those specified in the **fields** parameter. ")
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response", response =
	 *         AuditEntryEntry.class),<br/>
	 *         code = 400, message = "Invalid parameter: **auditApplicationId** or
	 *         **auditEntryId** is not a valid format "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "User does not have permission to retrieve
	 *         audit information"),<br/>
	 *         code = 404, message = "**auditApplicationId** or **auditEntryId**
	 *         does not exist "),<br/>
	 *         code = 501, message = "Audit is disabled for the system"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/audit-applications/{auditApplicationId}/audit-entries/{auditEntryId}", produces = "application/json", method = RequestMethod.GET)
	ResponseEntity<AuditEntryEntry> getAuditEntry(@PathVariable("auditApplicationId") String auditApplicationId,
			@PathVariable("auditEntryId") String auditEntryId,
			@RequestParam(value = "fields", required = false) List<String> fields);

	/**
	 * List audit applications
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2.2 and newer versions.
	 * Gets a list of audit applications in this repository. This list may include
	 * pre-configured audit applications, if enabled, such as: * alfresco-access *
	 * CMISChangeLog * Alfresco Tagging Service * Alfresco Sync Service (used by
	 * Enterprise Cloud Sync) You must have admin rights to retrieve audit
	 * information.
	 * </p>
	 *
	 *
	 * @param skipCount ("The number of entities that exist in the collection before
	 *                  those included in this list. If not supplied then the
	 *                  default value is 0. ", defaultValue = "0")
	 * @param maxItems  ("The maximum number of items to return in the list. If not
	 *                  supplied then the default value is 100. ", defaultValue =
	 *                  "100")
	 * @param fields    ("A list of field names. You can use this parameter to
	 *                  restrict the fields returned within a response if, for
	 *                  example, you want to save on overall bandwidth. The list
	 *                  applies to a returned individual entity or entries within a
	 *                  collection. If the API method also supports the **include**
	 *                  parameter, then the fields specified in the **include**
	 *                  parameter are returned in addition to those specified in the
	 *                  **fields** parameter. ")
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response", response =
	 *         AuditAppPaging.class),<br/>
	 *         code = 400, message = "Invalid parameter: value of **maxItems** or
	 *         **skipCount** is invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "User does not have permission to retrieve
	 *         audit information"),<br/>
	 *         code = 501, message = "Audit is disabled for the system"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/audit-applications", produces = "application/json", method = RequestMethod.GET)
	ResponseEntity<AuditAppPaging> listAuditApps(
			@Min(0) @RequestParam(value = "skipCount", required = false, defaultValue = "0") Integer skipCount,
			@Min(1) @RequestParam(value = "maxItems", required = false, defaultValue = "100") Integer maxItems,
			@RequestParam(value = "fields", required = false) List<String> fields);

	/**
	 * List audit entries for an audit application
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2.2 and newer versions.
	 * Gets a list of audit entries for audit application **auditApplicationId**.
	 * You can use the **include** parameter to return additional **values**
	 * information. The list can be filtered by one or more of: * **createdByUser**
	 * person id * **createdAt** inclusive time period * **id** inclusive range of
	 * ids * **valuesKey** audit entry values contains the exact matching key *
	 * **valuesValue** audit entry values contains the exact matching value The
	 * default sort order is **createdAt** ascending, but you can use an optional
	 * **ASC** or **DESC** modifier to specify an ascending or descending sort
	 * order. For example, specifying ```orderBy=createdAt DESC``` returns audit
	 * entries in descending **createdAt** order. You must have admin rights to
	 * retrieve audit information.
	 * </p>
	 *
	 *
	 * @param auditApplicationId ("The identifier of an audit
	 *                           application.",required=true)
	 * @param skipCount          ("The number of entities that exist in the
	 *                           collection before those included in this list. If
	 *                           not supplied then the default value is 0. ",
	 *                           defaultValue = "0")
	 * @param orderBy            ("A string to control the order of the entities
	 *                           returned in a list. You can use the **orderBy**
	 *                           parameter to sort the list by one or more fields.
	 *                           Each field has a default sort order, which is
	 *                           normally ascending order. Read the API method
	 *                           implementation notes above to check if any fields
	 *                           used in this method have a descending default
	 *                           search order. To sort the entities in a specific
	 *                           order, you can use the **ASC** and **DESC**
	 *                           keywords for any field. ")
	 * @param maxItems           ("The maximum number of items to return in the
	 *                           list. If not supplied then the default value is
	 *                           100. ", defaultValue = "100")
	 * @param where              ("Optionally filter the list. Here are some
	 *                           examples: * ```where=(createdByUser='jbloggs')``` *
	 *                           ```where=(id BETWEEN ('1234', '4321')``` *
	 *                           ```where=(createdAt BETWEEN
	 *                           ('2017-06-02T12:13:51.593+01:00' ,
	 *                           '2017-06-04T10:05:16.536+01:00')``` *
	 *                           ```where=(createdByUser='jbloggs' and createdAt
	 *                           BETWEEN ('2017-06-02T12:13:51.593+01:00' ,
	 *                           '2017-06-04T10:05:16.536+01:00')``` *
	 *                           ```where=(valuesKey='/alfresco-access/login/user')```
	 *                           *
	 *                           ```where=(valuesKey='/alfresco-access/transaction/action'
	 *                           and valuesValue='DELETE')``` ")
	 * @param include            ("Returns additional information about the audit
	 *                           entry. The following optional fields can be
	 *                           requested: * values ")
	 * @param fields             ("A list of field names. You can use this parameter
	 *                           to restrict the fields returned within a response
	 *                           if, for example, you want to save on overall
	 *                           bandwidth. The list applies to a returned
	 *                           individual entity or entries within a collection.
	 *                           If the API method also supports the **include**
	 *                           parameter, then the fields specified in the
	 *                           **include** parameter are returned in addition to
	 *                           those specified in the **fields** parameter. ")
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response", response =
	 *         AuditEntryPaging.class),<br/>
	 *         code = 400, message = "Invalid parameter: *auditApplicationId** is
	 *         not a valid format, value of **maxItems** or **skipCount** is invalid
	 *         "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "User does not have permission to retrieve
	 *         audit information"),<br/>
	 *         code = 404, message = "**applicationId** does not exist "),<br/>
	 *         code = 501, message = "Audit is disabled for the system"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/audit-applications/{auditApplicationId}/audit-entries", produces = "application/json", method = RequestMethod.GET)
	ResponseEntity<AuditEntryPaging> listAuditEntriesForAuditApp(
			@PathVariable("auditApplicationId") String auditApplicationId,
			@Min(0) @RequestParam(value = "skipCount", required = false, defaultValue = "0") Integer skipCount,
			@RequestParam(value = "orderBy", required = false) List<String> orderBy,
			@Min(1) @RequestParam(value = "maxItems", required = false, defaultValue = "100") Integer maxItems,
			@RequestParam(value = "where", required = false) String where,
			@RequestParam(value = "include", required = false) List<String> include,
			@RequestParam(value = "fields", required = false) List<String> fields);

	/**
	 * List audit entries for a node
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2.2 and newer versions.
	 * Gets a list of audit entries for node **nodeId**. The list can be filtered by
	 * **createdByUser** and for a given inclusive time period. The default sort
	 * order is **createdAt** ascending, but you can use an optional **ASC** or
	 * **DESC** modifier to specify an ascending or descending sort order. For
	 * example, specifying ```orderBy=createdAt DESC``` returns audit entries in
	 * descending **createdAt** order. This relies on the pre-configured
	 * 'alfresco-access' audit application.
	 * </p>
	 *
	 *
	 * @param nodeId    ("The identifier of a node.",required=true)
	 * @param skipCount ("The number of entities that exist in the collection before
	 *                  those included in this list. If not supplied then the
	 *                  default value is 0. ", defaultValue = "0")
	 * @param orderBy   ("A string to control the order of the entities returned in
	 *                  a list. You can use the **orderBy** parameter to sort the
	 *                  list by one or more fields. Each field has a default sort
	 *                  order, which is normally ascending order. Read the API
	 *                  method implementation notes above to check if any fields
	 *                  used in this method have a descending default search order.
	 *                  To sort the entities in a specific order, you can use the
	 *                  **ASC** and **DESC** keywords for any field. ")
	 * @param maxItems  ("The maximum number of items to return in the list. If not
	 *                  supplied then the default value is 100. ", defaultValue =
	 *                  "100")
	 * @param where     ("Optionally filter the list. Here are some examples: *
	 *                  ```where=(createdByUser='-me-')``` * ```where=(createdAt
	 *                  BETWEEN ('2017-06-02T12:13:51.593+01:00' ,
	 *                  '2017-06-04T10:05:16.536+01:00')``` *
	 *                  ```where=(createdByUser='jbloggs' and createdAt BETWEEN
	 *                  ('2017-06-02T12:13:51.593+01:00' ,
	 *                  '2017-06-04T10:05:16.536+01:00')``` ")
	 * @param include   ("Returns additional information about the audit entry. The
	 *                  following optional fields can be requested: * values ")
	 * @param fields    ("A list of field names. You can use this parameter to
	 *                  restrict the fields returned within a response if, for
	 *                  example, you want to save on overall bandwidth. The list
	 *                  applies to a returned individual entity or entries within a
	 *                  collection. If the API method also supports the **include**
	 *                  parameter, then the fields specified in the **include**
	 *                  parameter are returned in addition to those specified in the
	 *                  **fields** parameter. ")
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response", response =
	 *         AuditEntryPaging.class),<br/>
	 *         code = 400, message = "Invalid parameter: *nodeId** is not a valid
	 *         format, value of **maxItems** or **skipCount** is invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "User does not have permission to retrieve
	 *         audit information"),<br/>
	 *         code = 404, message = "**nodeId** does not exist "),<br/>
	 *         code = 501, message = "Audit is disabled for the system"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/nodes/{nodeId}/audit-entries", produces = "application/json", method = RequestMethod.GET)
	ResponseEntity<AuditEntryPaging> listAuditEntriesForNode(@PathVariable("nodeId") String nodeId,
			@Min(0) @RequestParam(value = "skipCount", required = false, defaultValue = "0") Integer skipCount,
			@RequestParam(value = "orderBy", required = false) List<String> orderBy,
			@Min(1) @RequestParam(value = "maxItems", required = false, defaultValue = "100") Integer maxItems,
			@RequestParam(value = "where", required = false) String where,
			@RequestParam(value = "include", required = false) List<String> include,
			@RequestParam(value = "fields", required = false) List<String> fields);

	/**
	 * Update audit application info
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2.2 and newer versions.
	 * Disable or re-enable the audit application **auditApplicationId**. New audit
	 * entries will not be created for a disabled audit application until it is
	 * re-enabled (and system-wide auditing is also enabled). Note, it is still
	 * possible to query &/or delete any existing audit entries even if auditing is
	 * disabled for the audit application. You must have admin rights to update
	 * audit application.
	 * </p>
	 *
	 *
	 * @param auditApplicationId ("The identifier of an audit
	 *                           application.",required=true)
	 * @param auditAppBodyUpdate (value = "The audit application to update."
	 *                           ,required=true )
	 * @param fields             ("A list of field names. You can use this parameter
	 *                           to restrict the fields returned within a response
	 *                           if, for example, you want to save on overall
	 *                           bandwidth. The list applies to a returned
	 *                           individual entity or entries within a collection.
	 *                           If the API method also supports the **include**
	 *                           parameter, then the fields specified in the
	 *                           **include** parameter are returned in addition to
	 *                           those specified in the **fields** parameter. ")
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response", response =
	 *         AuditApp.class),<br/>
	 *         code = 400, message = "Invalid parameter: **auditApplicationId** is
	 *         not a valid format or **auditAppBodyUpdate** is invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "Current user does not have permission to
	 *         update audit application"),<br/>
	 *         code = 404, message = "**auditApplicationId** does not exist "),<br/>
	 *         code = 501, message = "Audit is disabled for the system"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/audit-applications/{auditApplicationId}", produces = "application/json", consumes = "application/json", method = RequestMethod.PUT)
	ResponseEntity<AuditApp> updateAuditApp(@PathVariable("auditApplicationId") String auditApplicationId,
			@RequestBody AuditBodyUpdate auditAppBodyUpdate,
			@RequestParam(value = "fields", required = false) List<String> fields);

}
