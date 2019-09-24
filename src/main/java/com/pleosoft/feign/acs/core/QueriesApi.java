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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pleosoft.feign.acs.core.model.NodePaging;
import com.pleosoft.feign.acs.core.model.PersonPaging;
import com.pleosoft.feign.acs.core.model.SitePaging;

public interface QueriesApi {

	/**
	 * Find nodes
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2 and newer versions. Gets
	 * a list of nodes that match the given search criteria. The search term is used
	 * to look for nodes that match against name, title, description, full text
	 * content or tags. The search term: - must contain a minimum of 3 alphanumeric
	 * characters - allows \"quoted term\" - can optionally use '*' for wildcard
	 * matching By default, file and folder types will be searched unless a specific
	 * type is provided as a query parameter. By default, the search will be across
	 * the repository unless a specific root node id is provided to start the search
	 * from. You can sort the result list using the **orderBy** parameter. You can
	 * specify one or more of the following fields in the **orderBy** parameter: *
	 * name * modifiedAt * createdAt
	 * </p>
	 *
	 *
	 * @param term       ("The term to search for.", required = true)
	 * @param rootNodeId ("The id of the node to start the search from. Supports the
	 *                   aliases -my-, -root- and -shared-. ")
	 * @param skipCount  ("The number of entities that exist in the collection
	 *                   before those included in this list. If not supplied then
	 *                   the default value is 0. ", defaultValue = "0")
	 * @param maxItems   ("The maximum number of items to return in the list. If not
	 *                   supplied then the default value is 100. ", defaultValue =
	 *                   "100")
	 * @param nodeType   ("Restrict the returned results to only those of the given
	 *                   node type and its sub-types ")
	 * @param include    ("Returns additional information about the node. The
	 *                   following optional fields can be requested: *
	 *                   allowableOperations * aspectNames * isLink * isFavorite *
	 *                   isLocked * path * properties ")
	 * @param orderBy    ("A string to control the order of the entities returned in
	 *                   a list. You can use the **orderBy** parameter to sort the
	 *                   list by one or more fields. Each field has a default sort
	 *                   order, which is normally ascending order. Read the API
	 *                   method implementation notes above to check if any fields
	 *                   used in this method have a descending default search order.
	 *                   To sort the entities in a specific order, you can use the
	 *                   **ASC** and **DESC** keywords for any field. ")
	 * @param fields     ("A list of field names. You can use this parameter to
	 *                   restrict the fields returned within a response if, for
	 *                   example, you want to save on overall bandwidth. The list
	 *                   applies to a returned individual entity or entries within a
	 *                   collection. If the API method also supports the **include**
	 *                   parameter, then the fields specified in the **include**
	 *                   parameter are returned in addition to those specified in
	 *                   the **fields** parameter. ")
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response", response =
	 *         NodePaging.class),<br/>
	 *         code = 400, message = "Invalid parameter: value of **maxItems** or
	 *         **skipCount** is invalid, or search **term** too short, or
	 *         **nodeType** unknown, or **orderBy** invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 404, message = "**rootNodeId** does not exist "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/queries/nodes", produces = "application/json", method = RequestMethod.GET)
	ResponseEntity<NodePaging> findNodes(@NotNull @RequestParam(value = "term", required = true) String term,
			@RequestParam(value = "rootNodeId", required = false) String rootNodeId,
			@Min(0) @RequestParam(value = "skipCount", required = false, defaultValue = "0") Integer skipCount,
			@Min(1) @RequestParam(value = "maxItems", required = false, defaultValue = "100") Integer maxItems,
			@RequestParam(value = "nodeType", required = false) String nodeType,
			@RequestParam(value = "include", required = false) List<String> include,
			@RequestParam(value = "orderBy", required = false) List<String> orderBy,
			@RequestParam(value = "fields", required = false) List<String> fields);

	/**
	 * Find people
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2 and newer versions. Gets
	 * a list of people that match the given search criteria. The search term is
	 * used to look for matches against person id, firstname and lastname. The
	 * search term: - must contain a minimum of 2 alphanumeric characters - can
	 * optionally use '*' for wildcard matching within the term You can sort the
	 * result list using the **orderBy** parameter. You can specify one or more of
	 * the following fields in the **orderBy** parameter: * id * firstName *
	 * lastName
	 * </p>
	 *
	 *
	 * @param term      ("The term to search for. ", required = true)
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
	 * @param orderBy   ("A string to control the order of the entities returned in
	 *                  a list. You can use the **orderBy** parameter to sort the
	 *                  list by one or more fields. Each field has a default sort
	 *                  order, which is normally ascending order. Read the API
	 *                  method implementation notes above to check if any fields
	 *                  used in this method have a descending default search order.
	 *                  To sort the entities in a specific order, you can use the
	 *                  **ASC** and **DESC** keywords for any field. ")
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response", response =
	 *         PersonPaging.class),<br/>
	 *         code = 400, message = "Invalid parameter: value of **maxItems** or
	 *         **skipCount** is invalid, or search **term** too short, or
	 *         **orderBy** invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/queries/people", produces = "application/json", method = RequestMethod.GET)
	ResponseEntity<PersonPaging> findPeople(@NotNull @RequestParam(value = "term", required = true) String term,
			@Min(0) @RequestParam(value = "skipCount", required = false, defaultValue = "0") Integer skipCount,
			@Min(1) @RequestParam(value = "maxItems", required = false, defaultValue = "100") Integer maxItems,
			@RequestParam(value = "fields", required = false) List<String> fields,
			@RequestParam(value = "orderBy", required = false) List<String> orderBy);

	/**
	 * Find sites
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2 and newer versions. Gets
	 * a list of sites that match the given search criteria. The search term is used
	 * to look for sites that match against site id, title or description. The
	 * search term: - must contain a minimum of 2 alphanumeric characters - can
	 * optionally use '*' for wildcard matching within the term The default sort
	 * order for the returned list is for sites to be sorted by ascending id. You
	 * can override the default by using the **orderBy** parameter. You can specify
	 * one or more of the following fields in the **orderBy** parameter: * id *
	 * title * description
	 * </p>
	 *
	 *
	 * @param term      ("The term to search for.", required = true)
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
	 *         SitePaging.class),<br/>
	 *         code = 400, message = "Invalid parameter: value of **maxItems** or
	 *         **skipCount** is invalid, or search **term** too short, or
	 *         **orderBy** invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/queries/sites", produces = "application/json", method = RequestMethod.GET)
	ResponseEntity<SitePaging> findSites(@NotNull @RequestParam(value = "term", required = true) String term,
			@Min(0) @RequestParam(value = "skipCount", required = false, defaultValue = "0") Integer skipCount,
			@Min(1) @RequestParam(value = "maxItems", required = false, defaultValue = "100") Integer maxItems,
			@RequestParam(value = "orderBy", required = false) List<String> orderBy,
			@RequestParam(value = "fields", required = false) List<String> fields);

}
