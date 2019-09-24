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

import com.pleosoft.feign.acs.core.model.TagBody;
import com.pleosoft.feign.acs.core.model.TagEntry;
import com.pleosoft.feign.acs.core.model.TagPaging;

public interface TagsApi {

	/**
	 * Create a tag for a node
	 *
	 * <p>
	 * Creates a tag on the node **nodeId**. You specify the tag in a JSON body like
	 * this: ```JSON { \"tag\":\"test-tag-1\" } ``` **Note:** You can create more
	 * than one tag by specifying a list of tags in the JSON body like this: ```JSON
	 * [ { \"tag\":\"test-tag-1\" }, { \"tag\":\"test-tag-2\" } ] ``` If you specify
	 * a list as input, then a paginated list rather than an entry is returned in
	 * the response body. For example: ```JSON { \"list\": { \"pagination\": {
	 * \"count\": 2, \"hasMoreItems\": false, \"totalItems\": 2, \"skipCount\": 0,
	 * \"maxItems\": 100 }, \"entries\": [ { \"entry\": { ... } }, { \"entry\": {
	 * ... } } ] } } ```
	 * </p>
	 *
	 *
	 * @param nodeId        ("The identifier of a node.",required=true)
	 * @param tagBodyCreate (value = "The new tag" ,required=true )
	 * @param fields        ("A list of field names. You can use this parameter to
	 *                      restrict the fields returned within a response if, for
	 *                      example, you want to save on overall bandwidth. The list
	 *                      applies to a returned individual entity or entries
	 *                      within a collection. If the API method also supports the
	 *                      **include** parameter, then the fields specified in the
	 *                      **include** parameter are returned in addition to those
	 *                      specified in the **fields** parameter. ")
	 * @return value = { <br/>
	 *         code = 201, message = "Successful response", response =
	 *         TagEntry.class),<br/>
	 *         code = 400, message = "Invalid parameter: **tagBodyCreate** is
	 *         invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "User does not have permission to create tags
	 *         on the node"),<br/>
	 *         code = 404, message = "**nodeId** does not exist "),<br/>
	 *         code = 405, message = "Cannot tag a node of this type"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/nodes/{nodeId}/tags", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	ResponseEntity<TagEntry> createTagForNode(@PathVariable("nodeId") String nodeId, @RequestBody TagBody tagBodyCreate,
			@RequestParam(value = "fields", required = false) List<String> fields);

	/**
	 * Delete a tag from a node
	 *
	 * <p>
	 * Deletes tag **tagId** from node **nodeId**.
	 * </p>
	 *
	 *
	 * @param nodeId ("The identifier of a node.",required=true)
	 * @param tagId  ("The identifier of a tag.",required=true)
	 * @return value = { <br/>
	 *         code = 204, message = "Successful response"),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "User does not have permission to delete the
	 *         tag"),<br/>
	 *         code = 404, message = "**nodeId** or **tagId** does not exist
	 *         "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/nodes/{nodeId}/tags/{tagId}", produces = "application/json", method = RequestMethod.DELETE)
	ResponseEntity<Void> deleteTagFromNode(@PathVariable("nodeId") String nodeId, @PathVariable("tagId") String tagId);

	/**
	 * Get a tag
	 *
	 * <p>
	 * Get a specific tag with **tagId**.
	 * </p>
	 *
	 *
	 * @param tagId  ("The identifier of a tag.",required=true)
	 * @param fields ("A list of field names. You can use this parameter to restrict
	 *               the fields returned within a response if, for example, you want
	 *               to save on overall bandwidth. The list applies to a returned
	 *               individual entity or entries within a collection. If the API
	 *               method also supports the **include** parameter, then the fields
	 *               specified in the **include** parameter are returned in addition
	 *               to those specified in the **fields** parameter. ")
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response", response =
	 *         TagEntry.class),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 404, message = "**tagId** does not exist "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/tags/{tagId}", produces = "application/json", method = RequestMethod.GET)
	ResponseEntity<TagEntry> getTag(@PathVariable("tagId") String tagId,
			@RequestParam(value = "fields", required = false) List<String> fields);

	/**
	 * List tags
	 *
	 * <p>
	 * Gets a list of tags in this repository. You can use the **include** parameter
	 * to return additional **values** information.
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
	 * @param include   ("Returns additional information about the tag. The
	 *                  following optional fields can be requested: * count ")
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response", response =
	 *         TagPaging.class),<br/>
	 *         code = 400, message = "Invalid parameter: value of **maxItems** or
	 *         **skipCount** is invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/tags", produces = "application/json", method = RequestMethod.GET)
	ResponseEntity<TagPaging> listTags(
			@Min(0) @RequestParam(value = "skipCount", required = false, defaultValue = "0") Integer skipCount,
			@Min(1) @RequestParam(value = "maxItems", required = false, defaultValue = "100") Integer maxItems,
			@RequestParam(value = "fields", required = false) List<String> fields,
			@RequestParam(value = "include", required = false) List<String> include);

	/**
	 * List tags for a node
	 *
	 * <p>
	 * Gets a list of tags for node **nodeId**.
	 * </p>
	 *
	 *
	 * @param nodeId    ("The identifier of a node.",required=true)
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
	 *         TagPaging.class),<br/>
	 *         code = 400, message = "Invalid parameter: value of **maxItems** or
	 *         **skipCount** is invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "User does not have permission to read tags on
	 *         the node"),<br/>
	 *         code = 404, message = "**nodeId** does not exist "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/nodes/{nodeId}/tags", produces = "application/json", method = RequestMethod.GET)
	ResponseEntity<TagPaging> listTagsForNode(@PathVariable("nodeId") String nodeId,
			@Min(0) @RequestParam(value = "skipCount", required = false, defaultValue = "0") Integer skipCount,
			@Min(1) @RequestParam(value = "maxItems", required = false, defaultValue = "100") Integer maxItems,
			@RequestParam(value = "fields", required = false) List<String> fields);

	/**
	 * Update a tag
	 *
	 * <p>
	 * Updates the tag **tagId**.
	 * </p>
	 *
	 *
	 * @param tagId         ("The identifier of a tag.",required=true)
	 * @param tagBodyUpdate (value = "The updated tag" ,required=true )
	 * @param fields        ("A list of field names. You can use this parameter to
	 *                      restrict the fields returned within a response if, for
	 *                      example, you want to save on overall bandwidth. The list
	 *                      applies to a returned individual entity or entries
	 *                      within a collection. If the API method also supports the
	 *                      **include** parameter, then the fields specified in the
	 *                      **include** parameter are returned in addition to those
	 *                      specified in the **fields** parameter. ")
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response", response =
	 *         TagEntry.class),<br/>
	 *         code = 400, message = "Invalid parameter: **tagBodyUpdate** is
	 *         invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 404, message = "**tagId** does not exist "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/tags/{tagId}", produces = "application/json", consumes = "application/json", method = RequestMethod.PUT)
	ResponseEntity<TagEntry> updateTag(@PathVariable("tagId") String tagId, @RequestBody TagBody tagBodyUpdate,
			@RequestParam(value = "fields", required = false) List<String> fields);

}
