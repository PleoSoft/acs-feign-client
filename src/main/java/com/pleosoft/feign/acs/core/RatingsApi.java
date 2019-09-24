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

import com.pleosoft.feign.acs.core.model.RatingBody;
import com.pleosoft.feign.acs.core.model.RatingEntry;
import com.pleosoft.feign.acs.core.model.RatingPaging;

public interface RatingsApi {

	/**
	 * Create a rating
	 *
	 * <p>
	 * Create a rating for the node with identifier **nodeId**
	 * </p>
	 *
	 *
	 * @param nodeId           ("The identifier of a node.",required=true)
	 * @param ratingBodyCreate (value = "For \"myRating\" the type is specific to
	 *                         the rating scheme, boolean for the likes and an
	 *                         integer for the fiveStar. For example, to \"like\" a
	 *                         file the following body would be used: ```JSON {
	 *                         \"id\": \"likes\", \"myRating\": true } ``` "
	 *                         ,required=true )
	 * @param fields           ("A list of field names. You can use this parameter
	 *                         to restrict the fields returned within a response if,
	 *                         for example, you want to save on overall bandwidth.
	 *                         The list applies to a returned individual entity or
	 *                         entries within a collection. If the API method also
	 *                         supports the **include** parameter, then the fields
	 *                         specified in the **include** parameter are returned
	 *                         in addition to those specified in the **fields**
	 *                         parameter. ")
	 * @return value = { <br/>
	 *         code = 201, message = "Successful response", response =
	 *         RatingEntry.class),<br/>
	 *         code = 400, message = "Invalid parameter: **ratingBodyCreate** is
	 *         invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 404, message = "**nodeId** does not exist "),<br/>
	 *         code = 405, message = "Cannot rate a node of this type"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/nodes/{nodeId}/ratings", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	ResponseEntity<RatingEntry> createRating(@PathVariable("nodeId") String nodeId,
			@RequestBody RatingBody ratingBodyCreate,
			@RequestParam(value = "fields", required = false) List<String> fields);

	/**
	 * Delete a rating
	 *
	 * <p>
	 * Deletes rating **ratingId** from node **nodeId**.
	 * </p>
	 *
	 *
	 * @param nodeId   ("The identifier of a node.",required=true)
	 * @param ratingId ("The identifier of a rating.",required=true)
	 * @return value = { <br/>
	 *         code = 204, message = "Successful response"),<br/>
	 *         code = 400, message = "Invalid parameter: unknown rating scheme
	 *         specified "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 404, message = "**nodeId** does not exist "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/nodes/{nodeId}/ratings/{ratingId}", produces = "application/json", method = RequestMethod.DELETE)
	ResponseEntity<Void> deleteRating(@PathVariable("nodeId") String nodeId, @PathVariable("ratingId") String ratingId);

	/**
	 * Get a rating
	 *
	 * <p>
	 * Get the specific rating **ratingId** on node **nodeId**.
	 * </p>
	 *
	 *
	 * @param nodeId   ("The identifier of a node.",required=true)
	 * @param ratingId ("The identifier of a rating.",required=true)
	 * @param fields   ("A list of field names. You can use this parameter to
	 *                 restrict the fields returned within a response if, for
	 *                 example, you want to save on overall bandwidth. The list
	 *                 applies to a returned individual entity or entries within a
	 *                 collection. If the API method also supports the **include**
	 *                 parameter, then the fields specified in the **include**
	 *                 parameter are returned in addition to those specified in the
	 *                 **fields** parameter. ")
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response", response =
	 *         RatingEntry.class),<br/>
	 *         code = 400, message = "Invalid parameter: unknown rating scheme
	 *         specified "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 404, message = "**nodeId** does not exist "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/nodes/{nodeId}/ratings/{ratingId}", produces = "application/json", method = RequestMethod.GET)
	ResponseEntity<RatingEntry> getRating(@PathVariable("nodeId") String nodeId,
			@PathVariable("ratingId") String ratingId,
			@RequestParam(value = "fields", required = false) List<String> fields);

	/**
	 * List ratings
	 *
	 * <p>
	 * Gets a list of ratings for node **nodeId**.
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
	 *         RatingPaging.class),<br/>
	 *         code = 400, message = "Invalid parameter: value of **maxItems** or
	 *         **skipCount** is invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 404, message = "**nodeId** does not exist "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/nodes/{nodeId}/ratings", produces = "application/json", method = RequestMethod.GET)
	ResponseEntity<RatingPaging> listRatings(@PathVariable("nodeId") String nodeId,
			@Min(0) @RequestParam(value = "skipCount", required = false, defaultValue = "0") Integer skipCount,
			@Min(1) @RequestParam(value = "maxItems", required = false, defaultValue = "100") Integer maxItems,
			@RequestParam(value = "fields", required = false) List<String> fields);

}
