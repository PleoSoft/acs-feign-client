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
import java.util.List;

import javax.validation.constraints.Min;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pleosoft.feign.acs.core.model.RevertBody;
import com.pleosoft.feign.acs.core.model.VersionEntry;
import com.pleosoft.feign.acs.core.model.VersionPaging;

public interface VersionsApi {

	/**
	 * Delete a version
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2 and newer versions.
	 * Delete the version identified by **versionId** and **nodeId*. If the version
	 * is successfully deleted then the content and metadata for that versioned node
	 * will be deleted and will no longer appear in the version history. This
	 * operation cannot be undone. If the most recent version is deleted the live
	 * node will revert to the next most recent version. We currently do not allow
	 * the last version to be deleted. If you wish to clear the history then you can
	 * remove the \"cm:versionable\" aspect (via update node) which will also
	 * disable versioning. In this case, you can re-enable versioning by adding back
	 * the \"cm:versionable\" aspect or using the version params (majorVersion and
	 * comment) on a subsequent file content update.
	 * </p>
	 *
	 *
	 * @param nodeId    ("The identifier of a node.",required=true)
	 * @param versionId ("The identifier of a version, ie. version label, within the
	 *                  version history of a node.",required=true)
	 * @return value = { <br/>
	 *         code = 204, message = "Successful response"),<br/>
	 *         code = 400, message = "Invalid parameter: **nodeId** is not a valid
	 *         format, or exists but does not identify a file, or **versionId** is
	 *         invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "Current user does not have permission to
	 *         delete the versioned node"),<br/>
	 *         code = 404, message = "**nodeId** or **versionId** does not exist
	 *         "),<br/>
	 *         code = 422, message = "Cannot delete the last remaining
	 *         version"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/nodes/{nodeId}/versions/{versionId}", produces = "application/json", method = RequestMethod.DELETE)
	ResponseEntity<Void> deleteVersion(@PathVariable("nodeId") String nodeId,
			@PathVariable("versionId") String versionId);

	/**
	 * Get version information
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2 and newer versions. Gets
	 * the version information for **versionId** of file node **nodeId**.
	 * </p>
	 *
	 *
	 * @param nodeId    ("The identifier of a node.",required=true)
	 * @param versionId ("The identifier of a version, ie. version label, within the
	 *                  version history of a node.",required=true)
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response", response =
	 *         VersionEntry.class),<br/>
	 *         code = 400, message = "Invalid parameter: **nodeId** is not a valid
	 *         format, or it exists but does not identify a file, or **versionId**
	 *         is invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "Current user does not have permission for
	 *         **nodeId**"),<br/>
	 *         code = 404, message = "**nodeId** or **versionId** does not exist
	 *         "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/nodes/{nodeId}/versions/{versionId}", produces = "application/json", method = RequestMethod.GET)
	ResponseEntity<VersionEntry> getVersion(@PathVariable("nodeId") String nodeId,
			@PathVariable("versionId") String versionId);

	/**
	 * Get version content
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2 and newer versions. Gets
	 * the version content for **versionId** of file node **nodeId**.
	 * </p>
	 *
	 *
	 * @param nodeId          ("The identifier of a node.",required=true)
	 * @param versionId       ("The identifier of a version, ie. version label,
	 *                        within the version history of a node.",required=true)
	 * @param attachment      ("**true** enables a web browser to download the file
	 *                        as an attachment. **false** means a web browser may
	 *                        preview the file in a new tab or window, but not
	 *                        download the file. You can only set this parameter to
	 *                        **false** if the content type of the file is in the
	 *                        supported list; for example, certain image files and
	 *                        PDF files. If the content type is not supported for
	 *                        preview, then a value of **false** is ignored, and the
	 *                        attachment will be returned in the response. ",
	 *                        defaultValue = "true")
	 * @param ifModifiedSince (value = "Only returns the content if it has been
	 *                        modified since the date provided. Use the date format
	 *                        defined by HTTP. For example, `Wed, 09 Mar 2016
	 *                        16:56:34 GMT`. " )
	 * @param range           (value = "The Range header indicates the part of a
	 *                        document that the server should return. Single part
	 *                        request supported, for example: bytes=1-10. " )
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response"),<br/>
	 *         code = 206, message = "Partial Content"),<br/>
	 *         code = 304, message = "Content has not been modified since the date
	 *         provided in the If-Modified-Since header"),<br/>
	 *         code = 400, message = "Invalid parameter: **nodeId** is not a valid
	 *         format, or is not a file, or **versionId** is invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "Current user does not have permission for
	 *         **nodeId**"),<br/>
	 *         code = 404, message = "**nodeId** or **versionId** does not exist
	 *         "),<br/>
	 *         code = 416, message = "Range Not Satisfiable"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/nodes/{nodeId}/versions/{versionId}/content", produces = "application/json", method = RequestMethod.GET)
	ResponseEntity<Void> getVersionContent(@PathVariable("nodeId") String nodeId,
			@PathVariable("versionId") String versionId,
			@RequestParam(value = "attachment", required = false, defaultValue = "true") Boolean attachment,
			@RequestHeader(value = "If-Modified-Since", required = false) Date ifModifiedSince,
			@RequestHeader(value = "Range", required = false) String range);

	/**
	 * List version history
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2 and newer versions. Gets
	 * the version history as an ordered list of versions for the specified
	 * **nodeId**. The list is ordered in descending modified order. So the most
	 * recent version is first and the original version is last in the list.
	 * </p>
	 *
	 *
	 * @param nodeId    ("The identifier of a node.",required=true)
	 * @param include   ("Returns additional information about the version node. The
	 *                  following optional fields can be requested: * properties *
	 *                  aspectNames ")
	 * @param fields    ("A list of field names. You can use this parameter to
	 *                  restrict the fields returned within a response if, for
	 *                  example, you want to save on overall bandwidth. The list
	 *                  applies to a returned individual entity or entries within a
	 *                  collection. If the API method also supports the **include**
	 *                  parameter, then the fields specified in the **include**
	 *                  parameter are returned in addition to those specified in the
	 *                  **fields** parameter. ")
	 * @param skipCount ("The number of entities that exist in the collection before
	 *                  those included in this list. If not supplied then the
	 *                  default value is 0. ", defaultValue = "0")
	 * @param maxItems  ("The maximum number of items to return in the list. If not
	 *                  supplied then the default value is 100. ", defaultValue =
	 *                  "100")
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response", response =
	 *         VersionPaging.class),<br/>
	 *         code = 400, message = "Invalid parameter: **nodeId** is not a valid
	 *         format "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "Current user does not have permission for
	 *         **nodeId**"),<br/>
	 *         code = 404, message = "Target **nodeId** does not exist"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/nodes/{nodeId}/versions", produces = "application/json", method = RequestMethod.GET)
	ResponseEntity<VersionPaging> listVersionHistory(@PathVariable("nodeId") String nodeId,
			@RequestParam(value = "include", required = false) List<String> include,
			@RequestParam(value = "fields", required = false) List<String> fields,
			@Min(0) @RequestParam(value = "skipCount", required = false, defaultValue = "0") Integer skipCount,
			@Min(1) @RequestParam(value = "maxItems", required = false, defaultValue = "100") Integer maxItems);

	/**
	 * Revert a version
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2 and newer versions.
	 * Attempts to revert the version identified by **versionId** and **nodeId** to
	 * the live node. If the node is successfully reverted then the content and
	 * metadata for that versioned node will be promoted to the live node and a new
	 * version will appear in the version history.
	 * </p>
	 *
	 *
	 * @param nodeId     ("The identifier of a node.",required=true)
	 * @param versionId  ("The identifier of a version, ie. version label, within
	 *                   the version history of a node.",required=true)
	 * @param revertBody (value = "Optionally, specify a version comment and whether
	 *                   this should be a major version, or not." ,required=true )
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
	 *         VersionEntry.class),<br/>
	 *         code = 400, message = "Invalid parameter: **nodeId** is not a valid
	 *         format, or it exists but does not identify a file, or **versionId**
	 *         is invalid, or **revertBody** invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "Current user does not have permission to
	 *         revert the versioned node"),<br/>
	 *         code = 404, message = "**nodeId** or **versionId** does not exist
	 *         "),<br/>
	 *         code = 422, message = "Model integrity exception trying to revert the
	 *         node"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/nodes/{nodeId}/versions/{versionId}/revert", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	ResponseEntity<VersionEntry> revertVersion(@PathVariable("nodeId") String nodeId,
			@PathVariable("versionId") String versionId, @RequestBody RevertBody revertBody,
			@RequestParam(value = "fields", required = false) List<String> fields);

}
