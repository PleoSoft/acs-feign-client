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

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pleosoft.feign.acs.core.model.GroupBodyCreate;
import com.pleosoft.feign.acs.core.model.GroupBodyUpdate;
import com.pleosoft.feign.acs.core.model.GroupEntry;
import com.pleosoft.feign.acs.core.model.GroupMemberEntry;
import com.pleosoft.feign.acs.core.model.GroupMemberPaging;
import com.pleosoft.feign.acs.core.model.GroupMembershipBodyCreate;
import com.pleosoft.feign.acs.core.model.GroupPaging;

public interface GroupsApi {

	/**
	 * Create a group
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2.1 and newer versions.
	 * Create a group. The group id must start with \"GROUP\\_\". If this is omitted
	 * it will be added automatically. This format is also returned when listing
	 * groups or group memberships. It should be noted that the other group-related
	 * operations also expect the id to start with \"GROUP\\_\". If one or more
	 * parentIds are specified then the group will be created and become a member of
	 * each of the specified parent groups. If no parentIds are specified then the
	 * group will be created as a root group. The group will be created in the
	 * **APP.DEFAULT** and **AUTH.ALF** zones. You must have admin rights to create
	 * a group.
	 * </p>
	 *
	 *
	 * @param groupBodyCreate (value = "The group to create." ,required=true )
	 * @param include         ("Returns additional information about the group. The
	 *                        following optional fields can be requested: *
	 *                        parentIds * zones ")
	 * @param fields          ("A list of field names. You can use this parameter to
	 *                        restrict the fields returned within a response if, for
	 *                        example, you want to save on overall bandwidth. The
	 *                        list applies to a returned individual entity or
	 *                        entries within a collection. If the API method also
	 *                        supports the **include** parameter, then the fields
	 *                        specified in the **include** parameter are returned in
	 *                        addition to those specified in the **fields**
	 *                        parameter. ")
	 * @return value = { <br/>
	 *         code = 201, message = "Successful response", response =
	 *         GroupEntry.class),<br/>
	 *         code = 400, message = "Invalid parameter: invalid **groupBodyCreate**
	 *         "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "User does not have permission to create a
	 *         group"),<br/>
	 *         code = 404, message = "**parentIds** does not exist "),<br/>
	 *         code = 409, message = "**id** clashes with an existing group "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/groups", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	ResponseEntity<GroupEntry> createGroup(@RequestBody GroupBodyCreate groupBodyCreate,
			@RequestParam(value = "include", required = false) List<String> include,
			@RequestParam(value = "fields", required = false) List<String> fields);

	/**
	 * Create a group membership
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2.1 and newer versions.
	 * Create a group membership (for an existing person or group) within a group
	 * **groupId**. If the added group was previously a root group then it becomes a
	 * non-root group since it now has a parent. It is an error to specify an **id**
	 * that does not exist. You must have admin rights to create a group membership.
	 * </p>
	 *
	 *
	 * @param groupId                   ("The identifier of a group.",required=true)
	 * @param groupMembershipBodyCreate (value = "The group membership to add
	 *                                  (person or sub-group)." ,required=true )
	 * @param fields                    ("A list of field names. You can use this
	 *                                  parameter to restrict the fields returned
	 *                                  within a response if, for example, you want
	 *                                  to save on overall bandwidth. The list
	 *                                  applies to a returned individual entity or
	 *                                  entries within a collection. If the API
	 *                                  method also supports the **include**
	 *                                  parameter, then the fields specified in the
	 *                                  **include** parameter are returned in
	 *                                  addition to those specified in the
	 *                                  **fields** parameter. ")
	 * @return value = { <br/>
	 *         code = 201, message = "Successful response", response =
	 *         GroupMemberEntry.class),<br/>
	 *         code = 400, message = "Invalid parameter: **groupId** or
	 *         **groupMembershipBodyCreate** is invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "User does not have permission to create a
	 *         group membership"),<br/>
	 *         code = 404, message = "**groupId** or *id* (of group or person) does
	 *         not exist "),<br/>
	 *         code = 409, message = "Trying to modify a pre-defined system group,
	 *         such as GROUP_EVERYONE. "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/groups/{groupId}/members", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	ResponseEntity<GroupMemberEntry> createGroupMembership(@PathVariable("groupId") String groupId,
			@RequestBody GroupMembershipBodyCreate groupMembershipBodyCreate,
			@RequestParam(value = "fields", required = false) List<String> fields);

	/**
	 * Delete a group
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2.1 and newer versions.
	 * Delete group **groupId**. The option to cascade delete applies this
	 * recursively to any hierarchy of group members. In this case, removing a group
	 * member does not delete the person or sub-group itself. If a removed sub-group
	 * no longer has any parent groups then it becomes a root group. You must have
	 * admin rights to delete a group.
	 * </p>
	 *
	 *
	 * @param groupId ("The identifier of a group.",required=true)
	 * @param cascade ("If **true** then the delete will be applied in cascade to
	 *                sub-groups. ", defaultValue = "false")
	 * @return value = { <br/>
	 *         code = 204, message = "Successful response"),<br/>
	 *         code = 400, message = "Invalid parameter: **groupId** is invalid
	 *         "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "User does not have permission to delete a
	 *         group member"),<br/>
	 *         code = 404, message = "**groupId** does not exist "),<br/>
	 *         code = 409, message = "Trying to delete a pre-defined system group,
	 *         such as GROUP_EVERYONE. "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/groups/{groupId}", produces = "application/json", method = RequestMethod.DELETE)
	ResponseEntity<Void> deleteGroup(@PathVariable("groupId") String groupId,
			@RequestParam(value = "cascade", required = false, defaultValue = "false") Boolean cascade);

	/**
	 * Delete a group membership
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2.1 and newer versions.
	 * Delete group member **groupMemberId** (person or sub-group) from group
	 * **groupId**. Removing a group member does not delete the person or sub-group
	 * itself. If a removed sub-group no longer has any parent groups then it
	 * becomes a root group. You must have admin rights to delete a group
	 * membership.
	 * </p>
	 *
	 *
	 * @param groupId       ("The identifier of a group.",required=true)
	 * @param groupMemberId ("The identifier of a person or group.",required=true)
	 * @return value = { <br/>
	 *         code = 204, message = "Successful response"),<br/>
	 *         code = 400, message = "Invalid parameter: value of **groupId**, or
	 *         **groupMemberId** is invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "User does not have permission to delete a
	 *         group membership"),<br/>
	 *         code = 404, message = "**groupId** or **groupMemberId** does not
	 *         exist "),<br/>
	 *         code = 409, message = "Trying to delete a member of a pre-defined
	 *         system group, such as GROUP_EVERYONE "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/groups/{groupId}/members/{groupMemberId}", produces = "application/json", method = RequestMethod.DELETE)
	ResponseEntity<Void> deleteGroupMembership(@PathVariable("groupId") String groupId,
			@PathVariable("groupMemberId") String groupMemberId);

	/**
	 * Get group details
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2.1 and newer versions.
	 * Get details for group **groupId**. You can use the **include** parameter to
	 * return additional information.
	 * </p>
	 *
	 *
	 * @param groupId ("The identifier of a group.",required=true)
	 * @param include ("Returns additional information about the group. The
	 *                following optional fields can be requested: * parentIds *
	 *                zones ")
	 * @param fields  ("A list of field names. You can use this parameter to
	 *                restrict the fields returned within a response if, for
	 *                example, you want to save on overall bandwidth. The list
	 *                applies to a returned individual entity or entries within a
	 *                collection. If the API method also supports the **include**
	 *                parameter, then the fields specified in the **include**
	 *                parameter are returned in addition to those specified in the
	 *                **fields** parameter. ")
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response", response =
	 *         GroupEntry.class),<br/>
	 *         code = 400, message = "Invalid parameter: invalid **groupId**
	 *         "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 404, message = "**groupId** does not exist "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/groups/{groupId}", produces = "application/json", method = RequestMethod.GET)
	ResponseEntity<GroupEntry> getGroup(@PathVariable("groupId") String groupId,
			@RequestParam(value = "include", required = false) List<String> include,
			@RequestParam(value = "fields", required = false) List<String> fields);

	/**
	 * List memberships of a group
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2.1 and newer versions.
	 * Gets a list of the group memberships for the group **groupId**. You can use
	 * the **where** parameter to filter the returned groups by **memberType**.
	 * Example to filter by **memberType**, use any one of: ``` (memberType='GROUP')
	 * (memberType='PERSON') ``` The default sort order for the returned list is for
	 * group members to be sorted by ascending displayName. You can override the
	 * default by using the **orderBy** parameter. You can specify one of the
	 * following fields in the **orderBy** parameter: * id * displayName
	 * </p>
	 *
	 *
	 * @param groupId   ("The identifier of a group.",required=true)
	 * @param skipCount ("The number of entities that exist in the collection before
	 *                  those included in this list. If not supplied then the
	 *                  default value is 0. ", defaultValue = "0")
	 * @param maxItems  ("The maximum number of items to return in the list. If not
	 *                  supplied then the default value is 100. ", defaultValue =
	 *                  "100")
	 * @param orderBy   ("A string to control the order of the entities returned in
	 *                  a list. You can use the **orderBy** parameter to sort the
	 *                  list by one or more fields. Each field has a default sort
	 *                  order, which is normally ascending order. Read the API
	 *                  method implementation notes above to check if any fields
	 *                  used in this method have a descending default search order.
	 *                  To sort the entities in a specific order, you can use the
	 *                  **ASC** and **DESC** keywords for any field. ")
	 * @param where     ("A string to restrict the returned objects by using a
	 *                  predicate.")
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
	 *         GroupMemberPaging.class),<br/>
	 *         code = 400, message = "Invalid parameter: value of **maxItems**,
	 *         **skipCount**, **orderBy**, or **where** is invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 404, message = "**groupId** does not exist "),<br/>
	 *         code = 405, message = "Trying to list all members of a pre-defined
	 *         system group, such as GROUP_EVERYONE "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/groups/{groupId}/members", produces = "application/json", method = RequestMethod.GET)
	ResponseEntity<GroupMemberPaging> listGroupMemberships(@PathVariable("groupId") String groupId,
			@Min(0) @RequestParam(value = "skipCount", required = false, defaultValue = "0") Integer skipCount,
			@Min(1) @RequestParam(value = "maxItems", required = false, defaultValue = "100") Integer maxItems,
			@RequestParam(value = "orderBy", required = false) List<String> orderBy,
			@RequestParam(value = "where", required = false) String where,
			@RequestParam(value = "fields", required = false) List<String> fields);

	/**
	 * List group memberships
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2.1 and newer versions.
	 * Gets a list of group membership information for person **personId**. You can
	 * use the `-me-` string in place of `<personId>` to specify the currently
	 * authenticated user. You can use the **include** parameter to return
	 * additional information. You can use the **where** parameter to filter the
	 * returned groups by **isRoot**. For example, the following **where** clause
	 * will return just the root groups: ``` (isRoot=true) ``` The **where**
	 * parameter can also be used to filter by ***zone***. This may be combined with
	 * isRoot to narrow a result set even further. For example, the following where
	 * clause will only return groups belonging to the `MY.ZONE` zone. ```
	 * where=(zones in ('MY.ZONE')) ``` This may be combined with the isRoot filter,
	 * as shown below: ``` where=(isRoot=false AND zones in ('MY.ZONE')) ```
	 * ***Note:*** restrictions include * `AND` is the only supported operator when
	 * combining `isRoot` and `zones` filters * Only one zone is supported by the
	 * filter * The quoted zone name must be placed in parenthesis — a 400 error
	 * will result if these are omitted. The default sort order for the returned
	 * list is for groups to be sorted by ascending displayName. You can override
	 * the default by using the **orderBy** parameter. You can specify one or more
	 * of the following fields in the **orderBy** parameter: * id * displayName
	 * </p>
	 *
	 *
	 * @param personId  ("The identifier of a person.",required=true)
	 * @param skipCount ("The number of entities that exist in the collection before
	 *                  those included in this list. If not supplied then the
	 *                  default value is 0. ", defaultValue = "0")
	 * @param maxItems  ("The maximum number of items to return in the list. If not
	 *                  supplied then the default value is 100. ", defaultValue =
	 *                  "100")
	 * @param orderBy   ("A string to control the order of the entities returned in
	 *                  a list. You can use the **orderBy** parameter to sort the
	 *                  list by one or more fields. Each field has a default sort
	 *                  order, which is normally ascending order. Read the API
	 *                  method implementation notes above to check if any fields
	 *                  used in this method have a descending default search order.
	 *                  To sort the entities in a specific order, you can use the
	 *                  **ASC** and **DESC** keywords for any field. ")
	 * @param include   ("Returns additional information about the group. The
	 *                  following optional fields can be requested: * parentIds *
	 *                  zones ")
	 * @param where     ("A string to restrict the returned objects by using a
	 *                  predicate.")
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
	 *         GroupPaging.class),<br/>
	 *         code = 400, message = "Invalid parameter: value of **maxItems**,
	 *         **skipCount**, **orderBy** or **personId** is invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 404, message = "**personId** does not exist "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/people/{personId}/groups", produces = "application/json", method = RequestMethod.GET)
	ResponseEntity<GroupPaging> listGroupMembershipsForPerson(@PathVariable("personId") String personId,
			@Min(0) @RequestParam(value = "skipCount", required = false, defaultValue = "0") Integer skipCount,
			@Min(1) @RequestParam(value = "maxItems", required = false, defaultValue = "100") Integer maxItems,
			@RequestParam(value = "orderBy", required = false) List<String> orderBy,
			@RequestParam(value = "include", required = false) List<String> include,
			@RequestParam(value = "where", required = false) String where,
			@RequestParam(value = "fields", required = false) List<String> fields);

	/**
	 * List groups
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2.1 and newer versions.
	 * Gets a list of groups. You can use the **include** parameter to return
	 * additional information. You can use the **where** parameter to filter the
	 * returned groups by **isRoot**. For example, the following **where** clause
	 * will return just the root groups: ``` (isRoot=true) ``` The **where**
	 * parameter can also be used to filter by ***zone***. This may be combined with
	 * isRoot to narrow a result set even further. For example, the following where
	 * clause will only return groups belonging to the `MY.ZONE` zone. ```
	 * where=(zones in ('MY.ZONE')) ``` This may be combined with the isRoot filter,
	 * as shown below: ``` where=(isRoot=false AND zones in ('MY.ZONE')) ```
	 * ***Note:*** restrictions include * `AND` is the only supported operator when
	 * combining `isRoot` and `zones` filters * Only one zone is supported by the
	 * filter * The quoted zone name must be placed in parenthesis — a 400 error
	 * will result if these are omitted. The default sort order for the returned
	 * list is for groups to be sorted by ascending displayName. You can override
	 * the default by using the **orderBy** parameter. You can specify one of the
	 * following fields in the **orderBy** parameter: * id * displayName
	 * </p>
	 *
	 *
	 * @param skipCount ("The number of entities that exist in the collection before
	 *                  those included in this list. If not supplied then the
	 *                  default value is 0. ", defaultValue = "0")
	 * @param maxItems  ("The maximum number of items to return in the list. If not
	 *                  supplied then the default value is 100. ", defaultValue =
	 *                  "100")
	 * @param orderBy   ("A string to control the order of the entities returned in
	 *                  a list. You can use the **orderBy** parameter to sort the
	 *                  list by one or more fields. Each field has a default sort
	 *                  order, which is normally ascending order. Read the API
	 *                  method implementation notes above to check if any fields
	 *                  used in this method have a descending default search order.
	 *                  To sort the entities in a specific order, you can use the
	 *                  **ASC** and **DESC** keywords for any field. ")
	 * @param include   ("Returns additional information about the group. The
	 *                  following optional fields can be requested: * parentIds *
	 *                  zones ")
	 * @param where     ("A string to restrict the returned objects by using a
	 *                  predicate.")
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
	 *         GroupPaging.class),<br/>
	 *         code = 400, message = "Invalid parameter: value of **maxItems** or
	 *         **skipCount**, or **orderBy**, or **where** is invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/groups", produces = "application/json", method = RequestMethod.GET)
	ResponseEntity<GroupPaging> listGroups(
			@Min(0) @RequestParam(value = "skipCount", required = false, defaultValue = "0") Integer skipCount,
			@Min(1) @RequestParam(value = "maxItems", required = false, defaultValue = "100") Integer maxItems,
			@RequestParam(value = "orderBy", required = false) List<String> orderBy,
			@RequestParam(value = "include", required = false) List<String> include,
			@RequestParam(value = "where", required = false) String where,
			@RequestParam(value = "fields", required = false) List<String> fields);

	/**
	 * Update group details
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2.1 and newer versions.
	 * Update details (displayName) for group **groupId**. You must have admin
	 * rights to update a group.
	 * </p>
	 *
	 *
	 * @param groupId         ("The identifier of a group.",required=true)
	 * @param groupBodyUpdate (value = "The group information to update."
	 *                        ,required=true )
	 * @param include         ("Returns additional information about the group. The
	 *                        following optional fields can be requested: *
	 *                        parentIds * zones ")
	 * @param fields          ("A list of field names. You can use this parameter to
	 *                        restrict the fields returned within a response if, for
	 *                        example, you want to save on overall bandwidth. The
	 *                        list applies to a returned individual entity or
	 *                        entries within a collection. If the API method also
	 *                        supports the **include** parameter, then the fields
	 *                        specified in the **include** parameter are returned in
	 *                        addition to those specified in the **fields**
	 *                        parameter. ")
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response", response =
	 *         GroupEntry.class),<br/>
	 *         code = 400, message = "Invalid parameter: **groupId** or
	 *         **groupBodyCreate** is invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "User does not have permission to update a
	 *         group"),<br/>
	 *         code = 404, message = "**groupId** does not exist "),<br/>
	 *         code = 409, message = "Trying to modify a pre-defined system group,
	 *         such as GROUP_EVERYONE "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/groups/{groupId}", produces = "application/json", consumes = "application/json", method = RequestMethod.PUT)
	ResponseEntity<GroupEntry> updateGroup(@PathVariable("groupId") String groupId,
			@RequestBody GroupBodyUpdate groupBodyUpdate,
			@RequestParam(value = "include", required = false) List<String> include,
			@RequestParam(value = "fields", required = false) List<String> fields);

}
