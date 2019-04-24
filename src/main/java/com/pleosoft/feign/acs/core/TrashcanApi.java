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

import com.pleosoft.feign.acs.core.model.DeletedNodeBodyRestore;
import com.pleosoft.feign.acs.core.model.DeletedNodeEntry;
import com.pleosoft.feign.acs.core.model.DeletedNodesPaging;
import com.pleosoft.feign.acs.core.model.NodeEntry;
import com.pleosoft.feign.acs.core.model.RenditionEntry;
import com.pleosoft.feign.acs.core.model.RenditionPaging;

public interface TrashcanApi {

	/**
	 * Permanently delete a deleted node
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2 and newer versions.
	 * Permanently deletes the deleted node **nodeId**.
	 * </p>
	 *
	 *
	 * @param nodeId
	 *            ("The identifier of a node.",required=true)
	 * @return value = { <br/>
	 *         code = 204, message = "Successful response"),<br/>
	 *         code = 400, message = "Invalid parameter: **nodeId** is not a
	 *         valid format "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "User does not have permission to
	 *         permanently delete the deleted node"),<br/>
	 *         code = 404, message = "**nodeId** does not exist "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/deleted-nodes/{nodeId}", produces = "application/json", consumes = "", method = RequestMethod.DELETE)
	ResponseEntity<Void> deleteDeletedNode(@PathVariable("nodeId") String nodeId);

	/**
	 * Get rendition information for a deleted node
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
	@RequestMapping(value = "/deleted-nodes/{nodeId}/renditions/{renditionId}", produces = "application/json", consumes = "", method = RequestMethod.GET)
	ResponseEntity<RenditionEntry> getArchivedNodeRendition(@PathVariable("nodeId") String nodeId,
			@PathVariable("renditionId") String renditionId);

	/**
	 * Get rendition content of a deleted node
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
	@RequestMapping(value = "/deleted-nodes/{nodeId}/renditions/{renditionId}/content", produces = "application/json", consumes = "", method = RequestMethod.GET)
	ResponseEntity<Void> getArchivedNodeRenditionContent(@PathVariable("nodeId") String nodeId,
			@PathVariable("renditionId") String renditionId,
			@RequestParam(value = "attachment", required = false, defaultValue = "true") Boolean attachment,
			@RequestHeader(value = "If-Modified-Since", required = false) Date ifModifiedSince,
			@RequestHeader(value = "Range", required = false) String range,
			@RequestParam(value = "placeholder", required = false, defaultValue = "false") Boolean placeholder);

	/**
	 * Get a deleted node
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2 and newer versions.
	 * Gets the specific deleted node **nodeId**.
	 * </p>
	 *
	 *
	 * @param nodeId
	 *            ("The identifier of a node.",required=true)
	 * @param include
	 *            ("Returns additional information about the node. The following
	 *            optional fields can be requested: * allowableOperations *
	 *            association * isLink * isFavorite * isLocked * path *
	 *            permissions ")
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response", response =
	 *         DeletedNodeEntry.class),<br/>
	 *         code = 400, message = "Invalid parameter: **nodeId** is not a
	 *         valid format "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "User does not have permission to view the
	 *         deleted node"),<br/>
	 *         code = 404, message = "**nodeId** does not exist "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/deleted-nodes/{nodeId}", produces = "application/json", consumes = "", method = RequestMethod.GET)
	ResponseEntity<DeletedNodeEntry> getDeletedNode(@PathVariable("nodeId") String nodeId,
			@RequestParam(value = "include", required = false) List<String> include);

	/**
	 * Get deleted node content
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2 and newer versions.
	 * Gets the content of the deleted node with identifier **nodeId**.
	 * </p>
	 *
	 *
	 * @param nodeId
	 *            ("The identifier of a node.",required=true)
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
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response"),<br/>
	 *         code = 206, message = "Partial Content"),<br/>
	 *         code = 304, message = "Content has not been modified since the
	 *         date provided in the If-Modified-Since header"),<br/>
	 *         code = 400, message = "Invalid parameter: **nodeId** is not a
	 *         valid format, or is not a file "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "Current user does not have permission to
	 *         retrieve content of **nodeId**"),<br/>
	 *         code = 404, message = "**nodeId** does not exist "),<br/>
	 *         code = 416, message = "Range Not Satisfiable"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/deleted-nodes/{nodeId}/content", produces = "application/json", consumes = "", method = RequestMethod.GET)
	ResponseEntity<Void> getDeletedNodeContent(@PathVariable("nodeId") String nodeId,
			@RequestParam(value = "attachment", required = false, defaultValue = "true") Boolean attachment,
			@RequestHeader(value = "If-Modified-Since", required = false) Date ifModifiedSince,
			@RequestHeader(value = "Range", required = false) String range);

	/**
	 * List renditions for a deleted node
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2 and newer versions.
	 * Gets a list of the rendition information for each rendition of the file
	 * **nodeId**, including the rendition id. Each rendition returned has a
	 * **status**: CREATED means it is available to view or download,
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
	@RequestMapping(value = "/deleted-nodes/{nodeId}/renditions", produces = "application/json", consumes = "", method = RequestMethod.GET)
	ResponseEntity<RenditionPaging> listDeletedNodeRenditions(@PathVariable("nodeId") String nodeId,
			@RequestParam(value = "where", required = false) String where);

	/**
	 * List deleted nodes
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2 and newer versions.
	 * Gets a list of deleted nodes for the current user. If the current user is
	 * an administrator deleted nodes for all users will be returned. The list
	 * of deleted nodes will be ordered with the most recently deleted node at
	 * the top of the list.
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
	 * @param include
	 *            ("Returns additional information about the node. The following
	 *            optional fields can be requested: * allowableOperations *
	 *            aspectNames * association * isLink * isFavorite * isLocked *
	 *            path * properties * permissions ")
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response", response =
	 *         DeletedNodesPaging.class),<br/>
	 *         code = 400, message = "Invalid parameter: value of **maxItems**
	 *         or **skipCount** is invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/deleted-nodes", produces = "application/json", consumes = "", method = RequestMethod.GET)
	ResponseEntity<DeletedNodesPaging> listDeletedNodes(
			@Min(0) @RequestParam(value = "skipCount", required = false, defaultValue = "0") Integer skipCount,
			@Min(1) @RequestParam(value = "maxItems", required = false, defaultValue = "100") Integer maxItems,
			@RequestParam(value = "include", required = false) List<String> include);

	/**
	 * Restore a deleted node
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2 and newer versions.
	 * Attempts to restore the deleted node **nodeId** to its original location
	 * or to a new location. If the node is successfully restored to its former
	 * primary parent, then only the primary child association will be restored,
	 * including recursively for any primary children. It should be noted that
	 * no other secondary child associations or peer associations will be
	 * restored, for any of the nodes within the primary parent-child hierarchy
	 * of restored nodes, irrespective of whether these associations were to
	 * nodes within or outside of the restored hierarchy. Also, any previously
	 * shared link will not be restored since it is deleted at the time of
	 * delete of each node.
	 * </p>
	 *
	 *
	 * @param nodeId
	 *            ("The identifier of a node.",required=true)
	 * @param fields
	 *            ("A list of field names. You can use this parameter to
	 *            restrict the fields returned within a response if, for
	 *            example, you want to save on overall bandwidth. The list
	 *            applies to a returned individual entity or entries within a
	 *            collection. If the API method also supports the **include**
	 *            parameter, then the fields specified in the **include**
	 *            parameter are returned in addition to those specified in the
	 *            **fields** parameter. ")
	 * @param deletedNodeBodyRestore
	 *            (value = "The targetParentId if the node is restored to a new
	 *            location." )
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response", response =
	 *         NodeEntry.class),<br/>
	 *         code = 400, message = "Invalid parameter: **nodeId** or
	 *         **targetNodeId** is not a valid format "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "User does not have permission to restore
	 *         the deleted node or user does not have permission to the target
	 *         node"),<br/>
	 *         code = 404, message = "**nodeId** does not exist or the restore
	 *         destination parent node does not exists "),<br/>
	 *         code = 409, message = "Node name already exists in the restore
	 *         destination"),<br/>
	 *         code = 422, message = "Model integrity exception trying to
	 *         restore the node"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/deleted-nodes/{nodeId}/restore", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	ResponseEntity<NodeEntry> restoreDeletedNode(@PathVariable("nodeId") String nodeId,
			@RequestParam(value = "fields", required = false) List<String> fields,
			@RequestBody DeletedNodeBodyRestore deletedNodeBodyRestore);

}
