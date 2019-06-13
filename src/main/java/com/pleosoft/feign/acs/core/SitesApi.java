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

import com.pleosoft.feign.acs.core.model.SiteBodyCreate;
import com.pleosoft.feign.acs.core.model.SiteBodyUpdate;
import com.pleosoft.feign.acs.core.model.SiteContainerEntry;
import com.pleosoft.feign.acs.core.model.SiteContainerPaging;
import com.pleosoft.feign.acs.core.model.SiteEntry;
import com.pleosoft.feign.acs.core.model.SiteMemberEntry;
import com.pleosoft.feign.acs.core.model.SiteMemberPaging;
import com.pleosoft.feign.acs.core.model.SiteMembershipApprovalBody;
import com.pleosoft.feign.acs.core.model.SiteMembershipBodyCreate;
import com.pleosoft.feign.acs.core.model.SiteMembershipBodyUpdate;
import com.pleosoft.feign.acs.core.model.SiteMembershipRejectionBody;
import com.pleosoft.feign.acs.core.model.SiteMembershipRequestBodyCreate;
import com.pleosoft.feign.acs.core.model.SiteMembershipRequestBodyUpdate;
import com.pleosoft.feign.acs.core.model.SiteMembershipRequestEntry;
import com.pleosoft.feign.acs.core.model.SiteMembershipRequestPaging;
import com.pleosoft.feign.acs.core.model.SiteMembershipRequestWithPersonPaging;
import com.pleosoft.feign.acs.core.model.SitePaging;
import com.pleosoft.feign.acs.core.model.SiteRoleEntry;
import com.pleosoft.feign.acs.core.model.SiteRolePaging;

public interface SitesApi {

	/**
	 * Approve a site membership request
	 *
	 * <p>
	 * Approve a site membership request.
	 * </p>
	 *
	 *
	 * @param siteId
	 *            ("The identifier of a site.",required=true)
	 * @param inviteeId
	 *            ("The invitee user name.",required=true)
	 * @param siteMembershipApprovalBody
	 *            (value = "Accepting a request to join, optionally, allows
	 *            assignment of a role to the user. " )
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response"),<br/>
	 *         code = 400, message = "Invalid parameter: value of **siteId** or
	 *         **inviteeId** is invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "Current user does not have permission to
	 *         approve membership request"),<br/>
	 *         code = 404, message = "**siteId** or **inviteeId** does not exist
	 *         "),<br/>
	 *         code = 422, message = "Integrity exception or not allowed to
	 *         approve membership request. "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/sites/{siteId}/site-membership-requests/{inviteeId}/approve", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	ResponseEntity<Void> approveSiteMembershipRequest(@PathVariable("siteId") String siteId,
			@PathVariable("inviteeId") String inviteeId,
			@RequestBody SiteMembershipApprovalBody siteMembershipApprovalBody);

	/**
	 * Create a site
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2 and newer versions.
	 * Creates a default site with the given details. Unless explicitly
	 * specified, the site id will be generated from the site title. The site id
	 * must be unique and only contain alphanumeric and/or dash characters.
	 * Note: the id of a site cannot be updated once the site has been created.
	 * For example, to create a public site called \"Marketing\" the following
	 * body could be used: ```JSON { \"title\": \"Marketing\", \"visibility\":
	 * \"PUBLIC\" } ``` The creation of the (surf) configuration files required
	 * by Share can be skipped via the **skipConfiguration** query parameter.
	 * **Note:** if skipped then such a site will **not** work within Share. The
	 * addition of the site to the user's site favorites can be skipped via the
	 * **skipAddToFavorites** query parameter. The creator will be added as a
	 * member with Site Manager role. When you create a site, a container called
	 * **documentLibrary** is created for you in the new site. This container is
	 * the root folder for content stored in the site.
	 * </p>
	 *
	 *
	 * @param siteBodyCreate
	 *            (value = "The site details" ,required=true )
	 * @param skipConfiguration
	 *            ("Flag to indicate whether the Share-specific (surf)
	 *            configuration files for the site should not be created.",
	 *            defaultValue = "false")
	 * @param skipAddToFavorites
	 *            ("Flag to indicate whether the site should not be added to the
	 *            user's site favorites.", defaultValue = "false")
	 * @param fields
	 *            ("A list of field names. You can use this parameter to
	 *            restrict the fields returned within a response if, for
	 *            example, you want to save on overall bandwidth. The list
	 *            applies to a returned individual entity or entries within a
	 *            collection. If the API method also supports the **include**
	 *            parameter, then the fields specified in the **include**
	 *            parameter are returned in addition to those specified in the
	 *            **fields** parameter. ")
	 * @return value = { <br/>
	 *         code = 201, message = "Successful response", response =
	 *         SiteEntry.class),<br/>
	 *         code = 400, message = "Invalid parameter: **id**, **title**, or
	 *         **description** exceed the maximum length; or **id** contains
	 *         invalid characters; or **siteBodyCreate** invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 409, message = "Site with the given identifier already
	 *         exists"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/sites", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	ResponseEntity<SiteEntry> createSite(@RequestBody SiteBodyCreate siteBodyCreate,
			@RequestParam(value = "skipConfiguration", required = false, defaultValue = "false") Boolean skipConfiguration,
			@RequestParam(value = "skipAddToFavorites", required = false, defaultValue = "false") Boolean skipAddToFavorites,
			@RequestParam(value = "fields", required = false) List<String> fields);

	/**
	 * Create a site membership
	 *
	 * <p>
	 * Creates a site membership for person **personId** on site **siteId**. You
	 * can set the **role** to one of four types: * SiteConsumer *
	 * SiteCollaborator * SiteContributor * SiteManager **Note:** You can create
	 * more than one site membership by specifying a list of people in the JSON
	 * body like this: ```JSON [ { \"role\": \"SiteConsumer\", \"id\": \"joe\"
	 * }, { \"role\": \"SiteConsumer\", \"id\": \"fred\" } ] ``` If you specify
	 * a list as input, then a paginated list rather than an entry is returned
	 * in the response body. For example: ```JSON { \"list\": { \"pagination\":
	 * { \"count\": 2, \"hasMoreItems\": false, \"totalItems\": 2,
	 * \"skipCount\": 0, \"maxItems\": 100 }, \"entries\": [ { \"entry\": { ...
	 * } }, { \"entry\": { ... } } ] } } ```
	 * </p>
	 *
	 *
	 * @param siteId
	 *            ("The identifier of a site.",required=true)
	 * @param siteMembershipBodyCreate
	 *            (value = "The person to add and their role" ,required=true )
	 * @param fields
	 *            ("A list of field names. You can use this parameter to
	 *            restrict the fields returned within a response if, for
	 *            example, you want to save on overall bandwidth. The list
	 *            applies to a returned individual entity or entries within a
	 *            collection. If the API method also supports the **include**
	 *            parameter, then the fields specified in the **include**
	 *            parameter are returned in addition to those specified in the
	 *            **fields** parameter. ")
	 * @return value = { <br/>
	 *         code = 201, message = "Successful response", response =
	 *         SiteMemberEntry.class),<br/>
	 *         code = 400, message = "Invalid parameter: value of **role** or
	 *         **id** is invalid or **siteMembershipBodyCreate** invalid
	 *         "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "User does not have permission to invite a
	 *         person"),<br/>
	 *         code = 404, message = "**siteId** or **personId** does not exist
	 *         "),<br/>
	 *         code = 409, message = "Person with this **id** is already a
	 *         member"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/sites/{siteId}/members", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	ResponseEntity<SiteMemberEntry> createSiteMembership(@PathVariable("siteId") String siteId,
			@RequestBody SiteMembershipBodyCreate siteMembershipBodyCreate,
			@RequestParam(value = "fields", required = false) List<String> fields);

	/**
	 * Create a site membership request
	 *
	 * <p>
	 * Create a site membership request for yourself on the site with the
	 * identifier of **id**, specified in the JSON body. The result of the
	 * request differs depending on the type of site. * For a **public** site,
	 * you join the site immediately as a SiteConsumer. * For a **moderated**
	 * site, your request is added to the site membership request list. The
	 * request waits for approval from the Site Manager. * You cannot request
	 * membership of a **private** site. Members are invited by the site
	 * administrator. You can use the `-me-` string in place of `<personId>` to
	 * specify the currently authenticated user. **Note:** You can create site
	 * membership requests for more than one site by specifying a list of sites
	 * in the JSON body like this: ```JSON [ { \"message\": \"Please can you add
	 * me\", \"id\": \"test-site-1\", \"title\": \"Request for test site 1\", },
	 * { \"message\": \"Please can you add me\", \"id\": \"test-site-2\",
	 * \"title\": \"Request for test site 2\", } ] ``` If you specify a list as
	 * input, then a paginated list rather than an entry is returned in the
	 * response body. For example: ```JSON { \"list\": { \"pagination\": {
	 * \"count\": 2, \"hasMoreItems\": false, \"totalItems\": 2, \"skipCount\":
	 * 0, \"maxItems\": 100 }, \"entries\": [ { \"entry\": { ... } }, {
	 * \"entry\": { ... } } ] } } ```
	 * </p>
	 *
	 *
	 * @param personId
	 *            ("The identifier of a person.",required=true)
	 * @param siteMembershipRequestBodyCreate
	 *            (value = "Site membership request details" ,required=true )
	 * @param fields
	 *            ("A list of field names. You can use this parameter to
	 *            restrict the fields returned within a response if, for
	 *            example, you want to save on overall bandwidth. The list
	 *            applies to a returned individual entity or entries within a
	 *            collection. If the API method also supports the **include**
	 *            parameter, then the fields specified in the **include**
	 *            parameter are returned in addition to those specified in the
	 *            **fields** parameter. ")
	 * @return value = { <br/>
	 *         code = 201, message = "Successful response", response =
	 *         SiteMembershipRequestEntry.class),<br/>
	 *         code = 400, message = "Invalid parameter: **id** is invalid, or
	 *         the user is already invited, or
	 *         **siteMembershipRequestBodyCreate** invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 404, message = "**personId** or **id** does not exist
	 *         "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/people/{personId}/site-membership-requests", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	ResponseEntity<SiteMembershipRequestEntry> createSiteMembershipRequestForPerson(
			@PathVariable("personId") String personId,
			@RequestBody SiteMembershipRequestBodyCreate siteMembershipRequestBodyCreate,
			@RequestParam(value = "fields", required = false) List<String> fields);

	/**
	 * Delete a site
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2 and newer versions.
	 * Deletes the site with **siteId**.
	 * </p>
	 *
	 *
	 * @param siteId
	 *            ("The identifier of a site.",required=true)
	 * @param permanent
	 *            ("Flag to indicate whether the site should be permanently
	 *            deleted i.e. bypass the trashcan.", defaultValue = "false")
	 * @return value = { <br/>
	 *         code = 204, message = "Successful response"),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "Current user does not have permission to
	 *         delete the site that is visible to them."),<br/>
	 *         code = 404, message = "**siteId** does not exist "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/sites/{siteId}", produces = "application/json",  method = RequestMethod.DELETE)
	ResponseEntity<Void> deleteSite(@PathVariable("siteId") String siteId,
			@RequestParam(value = "permanent", required = false, defaultValue = "false") Boolean permanent);

	/**
	 * Delete a site membership
	 *
	 * <p>
	 * Deletes person **personId** as a member of site **siteId**. You can use
	 * the `-me-` string in place of `<personId>` to specify the currently
	 * authenticated user.
	 * </p>
	 *
	 *
	 * @param siteId
	 *            ("The identifier of a site.",required=true)
	 * @param personId
	 *            ("The identifier of a person.",required=true)
	 * @return value = { <br/>
	 *         code = 204, message = "Successful response"),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 404, message = "**siteId** or **personId** does not exist
	 *         "),<br/>
	 *         code = 422, message = "Integrity exception (eg. last site member
	 *         must be a site manager) or not allowed to delete member"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/sites/{siteId}/members/{personId}", produces = "application/json",  method = RequestMethod.DELETE)
	ResponseEntity<Void> deleteSiteMembership(@PathVariable("siteId") String siteId,
			@PathVariable("personId") String personId);

	/**
	 * Delete a site membership
	 *
	 * <p>
	 * Deletes person **personId** as a member of site **siteId**. You can use
	 * the `-me-` string in place of `<personId>` to specify the currently
	 * authenticated user.
	 * </p>
	 *
	 *
	 * @param personId
	 *            ("The identifier of a person.",required=true)
	 * @param siteId
	 *            ("The identifier of a site.",required=true)
	 * @return value = { <br/>
	 *         code = 204, message = "Successful response"),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 404, message = "**personId** or **siteId** does not exist
	 *         "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/people/{personId}/sites/{siteId}", produces = "application/json",  method = RequestMethod.DELETE)
	ResponseEntity<Void> deleteSiteMembershipForPerson(@PathVariable("personId") String personId,
			@PathVariable("siteId") String siteId);

	/**
	 * Delete a site membership request
	 *
	 * <p>
	 * Deletes the site membership request to site **siteId** for person
	 * **personId**. You can use the `-me-` string in place of `<personId>` to
	 * specify the currently authenticated user.
	 * </p>
	 *
	 *
	 * @param personId
	 *            ("The identifier of a person.",required=true)
	 * @param siteId
	 *            ("The identifier of a site.",required=true)
	 * @return value = { <br/>
	 *         code = 204, message = "Successful response"),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 404, message = "**personId** or **siteId** does not exist
	 *         "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/people/{personId}/site-membership-requests/{siteId}", produces = "application/json",  method = RequestMethod.DELETE)
	ResponseEntity<Void> deleteSiteMembershipRequestForPerson(@PathVariable("personId") String personId,
			@PathVariable("siteId") String siteId);

	/**
	 * Get a site
	 *
	 * <p>
	 * Gets information for site **siteId**. You can use the **relations**
	 * parameter to include one or more related entities in a single response
	 * and so reduce network traffic. The entity types in Alfresco are organized
	 * in a tree structure. The **sites** entity has two children,
	 * **containers** and **members**. The following relations parameter returns
	 * all the container and member objects related to the site **siteId**: ```
	 * containers,members ```
	 * </p>
	 *
	 *
	 * @param siteId
	 *            ("The identifier of a site.",required=true)
	 * @param relations
	 *            ("Use the relations parameter to include one or more related
	 *            entities in a single response.")
	 * @param fields
	 *            ("A list of field names. You can use this parameter to
	 *            restrict the fields returned within a response if, for
	 *            example, you want to save on overall bandwidth. The list
	 *            applies to a returned individual entity or entries within a
	 *            collection. If the API method also supports the **include**
	 *            parameter, then the fields specified in the **include**
	 *            parameter are returned in addition to those specified in the
	 *            **fields** parameter. ")
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response", response =
	 *         SiteEntry.class),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 404, message = "**siteId** does not exist "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/sites/{siteId}", produces = "application/json",  method = RequestMethod.GET)
	ResponseEntity<SiteEntry> getSite(@PathVariable("siteId") String siteId,
			@RequestParam(value = "relations", required = false) List<String> relations,
			@RequestParam(value = "fields", required = false) List<String> fields);

	/**
	 * Get a site container
	 *
	 * <p>
	 * Gets information on the container **containerId** in site **siteId**.
	 * </p>
	 *
	 *
	 * @param siteId
	 *            ("The identifier of a site.",required=true)
	 * @param containerId
	 *            ("The unique identifier of a site container.",required=true)
	 * @param fields
	 *            ("A list of field names. You can use this parameter to
	 *            restrict the fields returned within a response if, for
	 *            example, you want to save on overall bandwidth. The list
	 *            applies to a returned individual entity or entries within a
	 *            collection. If the API method also supports the **include**
	 *            parameter, then the fields specified in the **include**
	 *            parameter are returned in addition to those specified in the
	 *            **fields** parameter. ")
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response", response =
	 *         SiteContainerEntry.class),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 404, message = "**siteId** or **containerId** does not
	 *         exist "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/sites/{siteId}/containers/{containerId}", produces = "application/json",  method = RequestMethod.GET)
	ResponseEntity<SiteContainerEntry> getSiteContainer(@PathVariable("siteId") String siteId,
			@PathVariable("containerId") String containerId,
			@RequestParam(value = "fields", required = false) List<String> fields);

	/**
	 * Get a site membership
	 *
	 * <p>
	 * Gets site membership information for person **personId** on site
	 * **siteId**. You can use the `-me-` string in place of `<personId>` to
	 * specify the currently authenticated user.
	 * </p>
	 *
	 *
	 * @param siteId
	 *            ("The identifier of a site.",required=true)
	 * @param personId
	 *            ("The identifier of a person.",required=true)
	 * @param fields
	 *            ("A list of field names. You can use this parameter to
	 *            restrict the fields returned within a response if, for
	 *            example, you want to save on overall bandwidth. The list
	 *            applies to a returned individual entity or entries within a
	 *            collection. If the API method also supports the **include**
	 *            parameter, then the fields specified in the **include**
	 *            parameter are returned in addition to those specified in the
	 *            **fields** parameter. ")
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response", response =
	 *         SiteMemberEntry.class),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 404, message = "**siteId** or **personId** does not exist
	 *         "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/sites/{siteId}/members/{personId}", produces = "application/json",  method = RequestMethod.GET)
	ResponseEntity<SiteMemberEntry> getSiteMembership(@PathVariable("siteId") String siteId,
			@PathVariable("personId") String personId,
			@RequestParam(value = "fields", required = false) List<String> fields);

	/**
	 * Get a site membership
	 *
	 * <p>
	 * Gets site membership information for person **personId** on site
	 * **siteId**. You can use the `-me-` string in place of `<personId>` to
	 * specify the currently authenticated user.
	 * </p>
	 *
	 *
	 * @param personId
	 *            ("The identifier of a person.",required=true)
	 * @param siteId
	 *            ("The identifier of a site.",required=true)
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response", response =
	 *         SiteRoleEntry.class),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 404, message = "**personId** or **siteId** does not exist
	 *         "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/people/{personId}/sites/{siteId}", produces = "application/json",  method = RequestMethod.GET)
	ResponseEntity<SiteRoleEntry> getSiteMembershipForPerson(@PathVariable("personId") String personId,
			@PathVariable("siteId") String siteId);

	/**
	 * Get a site membership request
	 *
	 * <p>
	 * Gets the site membership request for site **siteId** for person
	 * **personId**, if one exists. You can use the `-me-` string in place of
	 * `<personId>` to specify the currently authenticated user.
	 * </p>
	 *
	 *
	 * @param personId
	 *            ("The identifier of a person.",required=true)
	 * @param siteId
	 *            ("The identifier of a site.",required=true)
	 * @param fields
	 *            ("A list of field names. You can use this parameter to
	 *            restrict the fields returned within a response if, for
	 *            example, you want to save on overall bandwidth. The list
	 *            applies to a returned individual entity or entries within a
	 *            collection. If the API method also supports the **include**
	 *            parameter, then the fields specified in the **include**
	 *            parameter are returned in addition to those specified in the
	 *            **fields** parameter. ")
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response", response =
	 *         SiteMembershipRequestEntry.class),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 404, message = "**personId** or **siteId** does not exist
	 *         "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/people/{personId}/site-membership-requests/{siteId}", produces = "application/json",  method = RequestMethod.GET)
	ResponseEntity<SiteMembershipRequestEntry> getSiteMembershipRequestForPerson(
			@PathVariable("personId") String personId, @PathVariable("siteId") String siteId,
			@RequestParam(value = "fields", required = false) List<String> fields);

	/**
	 * Get site membership requests
	 *
	 * <p>
	 * Get the list of site membership requests the user can action. You can use
	 * the **where** parameter to filter the returned site membership requests
	 * by **siteId**. For example: ``` (siteId=mySite) ``` The **where**
	 * parameter can also be used to filter by ***personId***. For example: ```
	 * where=(personId=person) ``` This may be combined with the siteId filter,
	 * as shown below: ``` where=(siteId=mySite AND personId=person)) ```
	 * </p>
	 *
	 *
	 * @param skipCount
	 *            ("The number of entities that exist in the collection before
	 *            those included in this list. If not supplied then the default
	 *            value is 0. ", defaultValue = "0")
	 * @param maxItems
	 *            ("The maximum number of items to return in the list. If not
	 *            supplied then the default value is 100. ", defaultValue =
	 *            "100")
	 * @param where
	 *            ("A string to restrict the returned objects by using a
	 *            predicate.")
	 * @param fields
	 *            ("A list of field names. You can use this parameter to
	 *            restrict the fields returned within a response if, for
	 *            example, you want to save on overall bandwidth. The list
	 *            applies to a returned individual entity or entries within a
	 *            collection. If the API method also supports the **include**
	 *            parameter, then the fields specified in the **include**
	 *            parameter are returned in addition to those specified in the
	 *            **fields** parameter. ")
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response", response =
	 *         SiteMembershipRequestWithPersonPaging.class),<br/>
	 *         code = 400, message = "Invalid parameter: value of **maxItems**
	 *         or **skipCount** is invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/site-membership-requests", produces = "application/json",  method = RequestMethod.GET)
	ResponseEntity<SiteMembershipRequestWithPersonPaging> getSiteMembershipRequests(
			@Min(0) @RequestParam(value = "skipCount", required = false, defaultValue = "0") Integer skipCount,
			@Min(1) @RequestParam(value = "maxItems", required = false, defaultValue = "100") Integer maxItems,
			@RequestParam(value = "where", required = false) String where,
			@RequestParam(value = "fields", required = false) List<String> fields);

	/**
	 * List site containers
	 *
	 * <p>
	 * Gets a list of containers for the site **siteId**.
	 * </p>
	 *
	 *
	 * @param siteId
	 *            ("The identifier of a site.",required=true)
	 * @param skipCount
	 *            ("The number of entities that exist in the collection before
	 *            those included in this list. If not supplied then the default
	 *            value is 0. ", defaultValue = "0")
	 * @param maxItems
	 *            ("The maximum number of items to return in the list. If not
	 *            supplied then the default value is 100. ", defaultValue =
	 *            "100")
	 * @param fields
	 *            ("A list of field names. You can use this parameter to
	 *            restrict the fields returned within a response if, for
	 *            example, you want to save on overall bandwidth. The list
	 *            applies to a returned individual entity or entries within a
	 *            collection. If the API method also supports the **include**
	 *            parameter, then the fields specified in the **include**
	 *            parameter are returned in addition to those specified in the
	 *            **fields** parameter. ")
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response", response =
	 *         SiteContainerPaging.class),<br/>
	 *         code = 400, message = "Invalid parameter: value of **maxItems**
	 *         or **skipCount** is invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 404, message = "**siteId** does not exist "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/sites/{siteId}/containers", produces = "application/json",  method = RequestMethod.GET)
	ResponseEntity<SiteContainerPaging> listSiteContainers(@PathVariable("siteId") String siteId,
			@Min(0) @RequestParam(value = "skipCount", required = false, defaultValue = "0") Integer skipCount,
			@Min(1) @RequestParam(value = "maxItems", required = false, defaultValue = "100") Integer maxItems,
			@RequestParam(value = "fields", required = false) List<String> fields);

	/**
	 * List site membership requests
	 *
	 * <p>
	 * Gets a list of the current site membership requests for person
	 * **personId**. You can use the `-me-` string in place of `<personId>` to
	 * specify the currently authenticated user.
	 * </p>
	 *
	 *
	 * @param personId
	 *            ("The identifier of a person.",required=true)
	 * @param skipCount
	 *            ("The number of entities that exist in the collection before
	 *            those included in this list. If not supplied then the default
	 *            value is 0. ", defaultValue = "0")
	 * @param maxItems
	 *            ("The maximum number of items to return in the list. If not
	 *            supplied then the default value is 100. ", defaultValue =
	 *            "100")
	 * @param fields
	 *            ("A list of field names. You can use this parameter to
	 *            restrict the fields returned within a response if, for
	 *            example, you want to save on overall bandwidth. The list
	 *            applies to a returned individual entity or entries within a
	 *            collection. If the API method also supports the **include**
	 *            parameter, then the fields specified in the **include**
	 *            parameter are returned in addition to those specified in the
	 *            **fields** parameter. ")
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response", response =
	 *         SiteMembershipRequestPaging.class),<br/>
	 *         code = 400, message = "Invalid parameter: value of **maxItems**
	 *         or **skipCount** is invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 404, message = "**personId** does not exist "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/people/{personId}/site-membership-requests", produces = "application/json",  method = RequestMethod.GET)
	ResponseEntity<SiteMembershipRequestPaging> listSiteMembershipRequestsForPerson(
			@PathVariable("personId") String personId,
			@Min(0) @RequestParam(value = "skipCount", required = false, defaultValue = "0") Integer skipCount,
			@Min(1) @RequestParam(value = "maxItems", required = false, defaultValue = "100") Integer maxItems,
			@RequestParam(value = "fields", required = false) List<String> fields);

	/**
	 * List site memberships
	 *
	 * <p>
	 * Gets a list of site memberships for site **siteId**.
	 * </p>
	 *
	 *
	 * @param siteId
	 *            ("The identifier of a site.",required=true)
	 * @param skipCount
	 *            ("The number of entities that exist in the collection before
	 *            those included in this list. If not supplied then the default
	 *            value is 0. ", defaultValue = "0")
	 * @param maxItems
	 *            ("The maximum number of items to return in the list. If not
	 *            supplied then the default value is 100. ", defaultValue =
	 *            "100")
	 * @param fields
	 *            ("A list of field names. You can use this parameter to
	 *            restrict the fields returned within a response if, for
	 *            example, you want to save on overall bandwidth. The list
	 *            applies to a returned individual entity or entries within a
	 *            collection. If the API method also supports the **include**
	 *            parameter, then the fields specified in the **include**
	 *            parameter are returned in addition to those specified in the
	 *            **fields** parameter. ")
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response", response =
	 *         SiteMemberPaging.class),<br/>
	 *         code = 400, message = "Invalid parameter: value of **maxItems**
	 *         or **skipCount** is invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 404, message = "**siteId** does not exist "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/sites/{siteId}/members", produces = "application/json",  method = RequestMethod.GET)
	ResponseEntity<SiteMemberPaging> listSiteMemberships(@PathVariable("siteId") String siteId,
			@Min(0) @RequestParam(value = "skipCount", required = false, defaultValue = "0") Integer skipCount,
			@Min(1) @RequestParam(value = "maxItems", required = false, defaultValue = "100") Integer maxItems,
			@RequestParam(value = "fields", required = false) List<String> fields);

	/**
	 * List site memberships
	 *
	 * <p>
	 * Gets a list of site membership information for person **personId**. You
	 * can use the `-me-` string in place of `<personId>` to specify the
	 * currently authenticated user. You can use the **where** parameter to
	 * filter the returned sites by **visibility** or site **preset**. Example
	 * to filter by **visibility**, use any one of: ``` (visibility='PRIVATE')
	 * (visibility='PUBLIC') (visibility='MODERATED') ``` Example to filter by
	 * site **preset**: ``` (preset='site-dashboard') ``` The default sort order
	 * for the returned list is for sites to be sorted by ascending title. You
	 * can override the default by using the **orderBy** parameter. You can
	 * specify one or more of the following fields in the **orderBy** parameter:
	 * * id * title * role
	 * </p>
	 *
	 *
	 * @param personId
	 *            ("The identifier of a person.",required=true)
	 * @param skipCount
	 *            ("The number of entities that exist in the collection before
	 *            those included in this list. If not supplied then the default
	 *            value is 0. ", defaultValue = "0")
	 * @param maxItems
	 *            ("The maximum number of items to return in the list. If not
	 *            supplied then the default value is 100. ", defaultValue =
	 *            "100")
	 * @param orderBy
	 *            ("A string to control the order of the entities returned in a
	 *            list. You can use the **orderBy** parameter to sort the list
	 *            by one or more fields. Each field has a default sort order,
	 *            which is normally ascending order. Read the API method
	 *            implementation notes above to check if any fields used in this
	 *            method have a descending default search order. To sort the
	 *            entities in a specific order, you can use the **ASC** and
	 *            **DESC** keywords for any field. ")
	 * @param relations
	 *            ("Use the relations parameter to include one or more related
	 *            entities in a single response.")
	 * @param fields
	 *            ("A list of field names. You can use this parameter to
	 *            restrict the fields returned within a response if, for
	 *            example, you want to save on overall bandwidth. The list
	 *            applies to a returned individual entity or entries within a
	 *            collection. If the API method also supports the **include**
	 *            parameter, then the fields specified in the **include**
	 *            parameter are returned in addition to those specified in the
	 *            **fields** parameter. ")
	 * @param where
	 *            ("A string to restrict the returned objects by using a
	 *            predicate.")
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response", response =
	 *         SiteRolePaging.class),<br/>
	 *         code = 400, message = "Invalid parameter: value of **maxItems**,
	 *         **skipCount**, **orderBy**, or **where** is invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 404, message = "**personId** does not exist "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/people/{personId}/sites", produces = "application/json",  method = RequestMethod.GET)
	ResponseEntity<SiteRolePaging> listSiteMembershipsForPerson(@PathVariable("personId") String personId,
			@Min(0) @RequestParam(value = "skipCount", required = false, defaultValue = "0") Integer skipCount,
			@Min(1) @RequestParam(value = "maxItems", required = false, defaultValue = "100") Integer maxItems,
			@RequestParam(value = "orderBy", required = false) List<String> orderBy,
			@RequestParam(value = "relations", required = false) List<String> relations,
			@RequestParam(value = "fields", required = false) List<String> fields,
			@RequestParam(value = "where", required = false) String where);

	/**
	 * List sites
	 *
	 * <p>
	 * Gets a list of sites in this repository. You can use the **where**
	 * parameter to filter the returned sites by **visibility** or site
	 * **preset**. Example to filter by **visibility**, use any one of: ```
	 * (visibility='PRIVATE') (visibility='PUBLIC') (visibility='MODERATED') ```
	 * Example to filter by site **preset**: ``` (preset='site-dashboard') ```
	 * The default sort order for the returned list is for sites to be sorted by
	 * ascending title. You can override the default by using the **orderBy**
	 * parameter. You can specify one or more of the following fields in the
	 * **orderBy** parameter: * id * title * description You can use the
	 * **relations** parameter to include one or more related entities in a
	 * single response and so reduce network traffic. The entity types in
	 * Alfresco are organized in a tree structure. The **sites** entity has two
	 * children, **containers** and **members**. The following relations
	 * parameter returns all the container and member objects related to each
	 * site: ``` containers,members ```
	 * </p>
	 *
	 *
	 * @param skipCount
	 *            ("The number of entities that exist in the collection before
	 *            those included in this list. If not supplied then the default
	 *            value is 0. ", defaultValue = "0")
	 * @param maxItems
	 *            ("The maximum number of items to return in the list. If not
	 *            supplied then the default value is 100. ", defaultValue =
	 *            "100")
	 * @param orderBy
	 *            ("A string to control the order of the entities returned in a
	 *            list. You can use the **orderBy** parameter to sort the list
	 *            by one or more fields. Each field has a default sort order,
	 *            which is normally ascending order. Read the API method
	 *            implementation notes above to check if any fields used in this
	 *            method have a descending default search order. To sort the
	 *            entities in a specific order, you can use the **ASC** and
	 *            **DESC** keywords for any field. ")
	 * @param relations
	 *            ("Use the relations parameter to include one or more related
	 *            entities in a single response.")
	 * @param fields
	 *            ("A list of field names. You can use this parameter to
	 *            restrict the fields returned within a response if, for
	 *            example, you want to save on overall bandwidth. The list
	 *            applies to a returned individual entity or entries within a
	 *            collection. If the API method also supports the **include**
	 *            parameter, then the fields specified in the **include**
	 *            parameter are returned in addition to those specified in the
	 *            **fields** parameter. ")
	 * @param where
	 *            ("A string to restrict the returned objects by using a
	 *            predicate.")
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response", response =
	 *         SitePaging.class),<br/>
	 *         code = 400, message = "Invalid parameter: value of **maxItems**,
	 *         **skipCount**, **orderBy**, or **where** is invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/sites", produces = "application/json",  method = RequestMethod.GET)
	ResponseEntity<SitePaging> listSites(
			@Min(0) @RequestParam(value = "skipCount", required = false, defaultValue = "0") Integer skipCount,
			@Min(1) @RequestParam(value = "maxItems", required = false, defaultValue = "100") Integer maxItems,
			@RequestParam(value = "orderBy", required = false) List<String> orderBy,
			@RequestParam(value = "relations", required = false) List<String> relations,
			@RequestParam(value = "fields", required = false) List<String> fields,
			@RequestParam(value = "where", required = false) String where);

	/**
	 * Reject a site membership request
	 *
	 * <p>
	 * Reject a site membership request.
	 * </p>
	 *
	 *
	 * @param siteId
	 *            ("The identifier of a site.",required=true)
	 * @param inviteeId
	 *            ("The invitee user name.",required=true)
	 * @param siteMembershipRejectionBody
	 *            (value = "Rejecting a request to join, optionally, allows the
	 *            inclusion of comment. " )
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response"),<br/>
	 *         code = 400, message = "Invalid parameter: value of **siteId** or
	 *         **inviteeId** is invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "Current user does not have permission to
	 *         reject membership request"),<br/>
	 *         code = 404, message = "**siteId** or **inviteeId** does not exist
	 *         "),<br/>
	 *         code = 422, message = "Integrity exception or not allowed to
	 *         reject membership request. "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/sites/{siteId}/site-membership-requests/{inviteeId}/reject", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	ResponseEntity<Void> rejectSiteMembershipRequest(@PathVariable("siteId") String siteId,
			@PathVariable("inviteeId") String inviteeId,
			@RequestBody SiteMembershipRejectionBody siteMembershipRejectionBody);

	/**
	 * Update a site
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2 and newer versions.
	 * Update the details for the given site **siteId**. Site Manager or
	 * otherwise a (site) admin can update title, description or visibility.
	 * Note: the id of a site cannot be updated once the site has been created.
	 * </p>
	 *
	 *
	 * @param siteId
	 *            ("The identifier of a site.",required=true)
	 * @param siteBodyUpdate
	 *            (value = "The site information to update." ,required=true )
	 * @param fields
	 *            ("A list of field names. You can use this parameter to
	 *            restrict the fields returned within a response if, for
	 *            example, you want to save on overall bandwidth. The list
	 *            applies to a returned individual entity or entries within a
	 *            collection. If the API method also supports the **include**
	 *            parameter, then the fields specified in the **include**
	 *            parameter are returned in addition to those specified in the
	 *            **fields** parameter. ")
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response", response =
	 *         SiteEntry.class),<br/>
	 *         code = 400, message = "Invalid parameter: **siteBodyUpdate**
	 *         invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "Current user does not have permission to
	 *         update the site that is visible to them."),<br/>
	 *         code = 404, message = "**siteId** does not exist "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/sites/{siteId}", produces = "application/json", consumes = "application/json", method = RequestMethod.PUT)
	ResponseEntity<SiteEntry> updateSite(@PathVariable("siteId") String siteId,
			@RequestBody SiteBodyUpdate siteBodyUpdate,
			@RequestParam(value = "fields", required = false) List<String> fields);

	/**
	 * Update a site membership
	 *
	 * <p>
	 * Update the membership of person **personId** in site **siteId**. You can
	 * use the `-me-` string in place of `<personId>` to specify the currently
	 * authenticated user. You can set the **role** to one of four types: *
	 * SiteConsumer * SiteCollaborator * SiteContributor * SiteManager
	 * </p>
	 *
	 *
	 * @param siteId
	 *            ("The identifier of a site.",required=true)
	 * @param personId
	 *            ("The identifier of a person.",required=true)
	 * @param siteMembershipBodyUpdate
	 *            (value = "The persons new role" ,required=true )
	 * @param fields
	 *            ("A list of field names. You can use this parameter to
	 *            restrict the fields returned within a response if, for
	 *            example, you want to save on overall bandwidth. The list
	 *            applies to a returned individual entity or entries within a
	 *            collection. If the API method also supports the **include**
	 *            parameter, then the fields specified in the **include**
	 *            parameter are returned in addition to those specified in the
	 *            **fields** parameter. ")
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response", response =
	 *         SiteMemberEntry.class),<br/>
	 *         code = 400, message = "Invalid parameter: **role** does not exist
	 *         or **siteMembershipBodyUpdate** invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 404, message = "**siteId** or **personId** does not exist
	 *         "),<br/>
	 *         code = 422, message = "Integrity exception (eg. last site member
	 *         must be a site manager) or not allowed to update member"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/sites/{siteId}/members/{personId}", produces = "application/json", consumes = "application/json", method = RequestMethod.PUT)
	ResponseEntity<SiteMemberEntry> updateSiteMembership(@PathVariable("siteId") String siteId,
			@PathVariable("personId") String personId, @RequestBody SiteMembershipBodyUpdate siteMembershipBodyUpdate,
			@RequestParam(value = "fields", required = false) List<String> fields);

	/**
	 * Update a site membership request
	 *
	 * <p>
	 * Updates the message for the site membership request to site **siteId**
	 * for person **personId**. You can use the `-me-` string in place of
	 * `<personId>` to specify the currently authenticated user.
	 * </p>
	 *
	 *
	 * @param personId
	 *            ("The identifier of a person.",required=true)
	 * @param siteId
	 *            ("The identifier of a site.",required=true)
	 * @param siteMembershipRequestBodyUpdate
	 *            (value = "The new message to display" ,required=true )
	 * @param fields
	 *            ("A list of field names. You can use this parameter to
	 *            restrict the fields returned within a response if, for
	 *            example, you want to save on overall bandwidth. The list
	 *            applies to a returned individual entity or entries within a
	 *            collection. If the API method also supports the **include**
	 *            parameter, then the fields specified in the **include**
	 *            parameter are returned in addition to those specified in the
	 *            **fields** parameter. ")
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response", response =
	 *         SiteMembershipRequestEntry.class),<br/>
	 *         code = 400, message = "Invalid parameter: **id** is invalid or
	 *         **siteMembershipRequestBodyUpdate** invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 404, message = "**personId** or **siteId** does not exist
	 *         "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/people/{personId}/site-membership-requests/{siteId}", produces = "application/json", consumes = "application/json", method = RequestMethod.PUT)
	ResponseEntity<SiteMembershipRequestEntry> updateSiteMembershipRequestForPerson(
			@PathVariable("personId") String personId, @PathVariable("siteId") String siteId,
			@RequestBody SiteMembershipRequestBodyUpdate siteMembershipRequestBodyUpdate,
			@RequestParam(value = "fields", required = false) List<String> fields);

}
