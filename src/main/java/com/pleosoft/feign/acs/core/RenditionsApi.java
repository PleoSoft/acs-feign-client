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

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pleosoft.feign.acs.core.model.RenditionBodyCreate;
import com.pleosoft.feign.acs.core.model.RenditionEntry;
import com.pleosoft.feign.acs.core.model.RenditionPaging;

public interface RenditionsApi {

	/**
	 * Create rendition
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2 and newer versions.
	 * An asynchronous request to create a rendition for file **nodeId**. The
	 * rendition is specified by name **id** in the request body: ```JSON {
	 * \"id\":\"doclib\" } ``` Multiple names may be specified as a comma
	 * separated list or using a list format: ```JSON [ { \"id\": \"doclib\" },
	 * { \"id\": \"avatar\" } ] ```
	 * </p>
	 *
	 *
	 * @param nodeId
	 *            ("The identifier of a node.",required=true)
	 * @param renditionBodyCreate
	 *            (value = "The rendition \"id\"." ,required=true )
	 * @return value = { <br/>
	 *         code = 202, message = "Request accepted"),<br/>
	 *         code = 400, message = "Invalid parameter: **nodeId** is not a
	 *         valid format or is not a file or **renditionBodyCreate** is
	 *         invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "Current user does not have permission for
	 *         **nodeId**"),<br/>
	 *         code = 404, message = "**nodeId** or **renditionId** does not
	 *         exist "),<br/>
	 *         code = 409, message = "All requested renditions already
	 *         exist"),<br/>
	 *         code = 501, message = "Renditions/thumbnails are disabled for the
	 *         system"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/nodes/{nodeId}/renditions", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	ResponseEntity<Void> createRendition(@PathVariable("nodeId") String nodeId,
			@RequestBody RenditionBodyCreate renditionBodyCreate);

	/**
	 * Get rendition information
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2 and newer versions.
	 * Gets the rendition information for **renditionId** of file **nodeId**.
	 * </p>
	 *
	 *
	 * @param nodeId
	 *            ("The identifier of a node.",required=true)
	 * @param renditionId
	 *            ("The name of a thumbnail rendition, for example *doclib*, or
	 *            *pdf*.",required=true)
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response", response =
	 *         RenditionEntry.class),<br/>
	 *         code = 400, message = "Invalid parameter: **nodeId** is not a
	 *         valid format, or is not a file, or **renditionId** is invalid
	 *         "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "Current user does not have permission for
	 *         **nodeId**"),<br/>
	 *         code = 404, message = "**nodeId** or **renditionId** does not
	 *         exist "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/nodes/{nodeId}/renditions/{renditionId}", produces = "application/json", consumes = "", method = RequestMethod.GET)
	ResponseEntity<RenditionEntry> getRendition(@PathVariable("nodeId") String nodeId,
			@PathVariable("renditionId") String renditionId);

	/**
	 * Get rendition content
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2 and newer versions.
	 * Gets the rendition content for **renditionId** of file **nodeId**.
	 * </p>
	 *
	 *
	 * @param nodeId
	 *            ("The identifier of a node.",required=true)
	 * @param renditionId
	 *            ("The name of a thumbnail rendition, for example *doclib*, or
	 *            *pdf*.",required=true)
	 * @param attachment
	 *            ("**true** enables a web browser to download the file as an
	 *            attachment. **false** means a web browser may preview the file
	 *            in a new tab or window, but not download the file. You can
	 *            only set this parameter to **false** if the content type of
	 *            the file is in the supported list; for example, certain image
	 *            files and PDF files. If the content type is not supported for
	 *            preview, then a value of **false** is ignored, and the
	 *            attachment will be returned in the response. ", defaultValue =
	 *            "true")
	 * @param ifModifiedSince
	 *            (value = "Only returns the content if it has been modified
	 *            since the date provided. Use the date format defined by HTTP.
	 *            For example, `Wed, 09 Mar 2016 16:56:34 GMT`. " )
	 * @param range
	 *            (value = "The Range header indicates the part of a document
	 *            that the server should return. Single part request supported,
	 *            for example: bytes=1-10. " )
	 * @param placeholder
	 *            ("If **true** and there is no rendition for this **nodeId**
	 *            and **renditionId**, then the placeholder image for the mime
	 *            type of this rendition is returned, rather than a 404
	 *            response. ", defaultValue = "false")
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response"),<br/>
	 *         code = 206, message = "Partial Content"),<br/>
	 *         code = 304, message = "Content has not been modified since the
	 *         date provided in the If-Modified-Since header"),<br/>
	 *         code = 400, message = "Invalid parameter: **nodeId** is not a
	 *         valid format, or is not a file, or **renditionId** is invalid
	 *         "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "Current user does not have permission for
	 *         **nodeId**"),<br/>
	 *         code = 404, message = "**nodeId** or **renditionId** does not
	 *         exist "),<br/>
	 *         code = 416, message = "Range Not Satisfiable"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/nodes/{nodeId}/renditions/{renditionId}/content", produces = "application/json", consumes = "", method = RequestMethod.GET)
	ResponseEntity<Void> getRenditionContent(@PathVariable("nodeId") String nodeId,
			@PathVariable("renditionId") String renditionId,
			@RequestParam(value = "attachment", required = false, defaultValue = "true") Boolean attachment,
			@RequestHeader(value = "If-Modified-Since", required = false) Date ifModifiedSince,
			@RequestHeader(value = "Range", required = false) String range,
			@RequestParam(value = "placeholder", required = false, defaultValue = "false") Boolean placeholder);

	/**
	 * List renditions
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2 and newer versions.
	 * Gets a list of the rendition information for each rendition of the the
	 * file **nodeId**, including the rendition id. Each rendition returned has
	 * a **status**: CREATED means it is available to view or download,
	 * NOT_CREATED means the rendition can be requested. You can use the
	 * **where** parameter to filter the returned renditions by **status**. For
	 * example, the following **where** clause will return just the CREATED
	 * renditions: ``` (status='CREATED') ```
	 * </p>
	 *
	 *
	 * @param nodeId
	 *            ("The identifier of a node.",required=true)
	 * @param where
	 *            ("A string to restrict the returned objects by using a
	 *            predicate.")
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response", response =
	 *         RenditionPaging.class),<br/>
	 *         code = 400, message = "Invalid parameter: **nodeId** is not a
	 *         valid format, is not a file, or **where** is invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "Current user does not have permission for
	 *         **nodeId**"),<br/>
	 *         code = 404, message = "**nodeId** does not exist "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/nodes/{nodeId}/renditions", produces = "application/json", consumes = "", method = RequestMethod.GET)
	ResponseEntity<RenditionPaging> listRenditions(@PathVariable("nodeId") String nodeId,
			@RequestParam(value = "where", required = false) String where);

}
