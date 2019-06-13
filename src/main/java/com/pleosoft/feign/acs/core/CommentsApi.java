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

import com.pleosoft.feign.acs.core.model.CommentBody;
import com.pleosoft.feign.acs.core.model.CommentEntry;
import com.pleosoft.feign.acs.core.model.CommentPaging;

public interface CommentsApi {

	/**
	 * Create a comment
	 *
	 * <p>
	 * Creates a comment on node **nodeId**. You specify the comment in a JSON
	 * body like this: ```JSON { \"content\": \"This is a comment\" } ```
	 * **Note:** You can create more than one comment by specifying a list of
	 * comments in the JSON body like this: ```JSON [ { \"content\": \"This is a
	 * comment\" }, { \"content\": \"This is another comment\" } ] ``` If you
	 * specify a list as input, then a paginated list rather than an entry is
	 * returned in the response body. For example: ```JSON { \"list\": {
	 * \"pagination\": { \"count\": 2, \"hasMoreItems\": false, \"totalItems\":
	 * 2, \"skipCount\": 0, \"maxItems\": 100 }, \"entries\": [ { \"entry\": {
	 * ... } }, { \"entry\": { ... } } ] } } ```
	 * </p>
	 *
	 *
	 * @param nodeId
	 *            ("The identifier of a node.",required=true)
	 * @param commentBodyCreate
	 *            (value = "The comment text. Note that you can also provide a
	 *            list of comments." ,required=true )
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
	 *         CommentEntry.class),<br/>
	 *         code = 400, message = "Invalid parameter: **commentBodyCreate**
	 *         is invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "User does not have permission to create a
	 *         comment"),<br/>
	 *         code = 404, message = "**nodeId** does not exist "),<br/>
	 *         code = 405, message = "Cannot comment on a node of this
	 *         type"),<br/>
	 *         code = 409, message = "**nodeId** is locked and you are not the
	 *         lock owner "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/nodes/{nodeId}/comments", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	ResponseEntity<CommentEntry> createComment(@PathVariable("nodeId") String nodeId,
			@RequestBody CommentBody commentBodyCreate,
			@RequestParam(value = "fields", required = false) List<String> fields);

	/**
	 * Delete a comment
	 *
	 * <p>
	 * Deletes the comment **commentId** from node **nodeId**.
	 * </p>
	 *
	 *
	 * @param nodeId
	 *            ("The identifier of a node.",required=true)
	 * @param commentId
	 *            ("The identifier of a comment.",required=true)
	 * @return value = { <br/>
	 *         code = 204, message = "Successful response"),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "User does not have permission to delete a
	 *         comment"),<br/>
	 *         code = 404, message = "**nodeId** or **commentId** does not exist
	 *         "),<br/>
	 *         code = 409, message = "**nodeId** is locked and you are not the
	 *         lock owner "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/nodes/{nodeId}/comments/{commentId}", produces = "application/json",  method = RequestMethod.DELETE)
	ResponseEntity<Void> deleteComment(@PathVariable("nodeId") String nodeId,
			@PathVariable("commentId") String commentId);

	/**
	 * List comments
	 *
	 * <p>
	 * Gets a list of comments for the node **nodeId**, sorted chronologically
	 * with the newest comment first.
	 * </p>
	 *
	 *
	 * @param nodeId
	 *            ("The identifier of a node.",required=true)
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
	 *         CommentPaging.class),<br/>
	 *         code = 400, message = "Invalid parameter: **nodeId** exists but
	 *         does not identify a file or a folder, or the value of
	 *         **maxItems** is invalid, or the value of **skipCount** is invalid
	 *         "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "User does not have permission read
	 *         comments on the node"),<br/>
	 *         code = 404, message = "**nodeId** does not exist "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/nodes/{nodeId}/comments", produces = "application/json",  method = RequestMethod.GET)
	ResponseEntity<CommentPaging> listComments(@PathVariable("nodeId") String nodeId,
			@Min(0) @RequestParam(value = "skipCount", required = false, defaultValue = "0") Integer skipCount,
			@Min(1) @RequestParam(value = "maxItems", required = false, defaultValue = "100") Integer maxItems,
			@RequestParam(value = "fields", required = false) List<String> fields);

	/**
	 * Update a comment
	 *
	 * <p>
	 * Updates an existing comment **commentId** on node **nodeId**.
	 * </p>
	 *
	 *
	 * @param nodeId
	 *            ("The identifier of a node.",required=true)
	 * @param commentId
	 *            ("The identifier of a comment.",required=true)
	 * @param commentBodyUpdate
	 *            (value = "The JSON representing the comment to be updated."
	 *            ,required=true )
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
	 *         CommentEntry.class),<br/>
	 *         code = 400, message = "Invalid parameter: **commentBodyUpdate**
	 *         is invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "User does not have permission to update a
	 *         comment"),<br/>
	 *         code = 404, message = "**nodeId** or **commentId** does not exist
	 *         "),<br/>
	 *         code = 409, message = "**nodeId** is locked and you are not the
	 *         lock owner "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/nodes/{nodeId}/comments/{commentId}", produces = "application/json", consumes = "application/json", method = RequestMethod.PUT)
	ResponseEntity<CommentEntry> updateComment(@PathVariable("nodeId") String nodeId,
			@PathVariable("commentId") String commentId, @RequestBody CommentBody commentBodyUpdate,
			@RequestParam(value = "fields", required = false) List<String> fields);

}
