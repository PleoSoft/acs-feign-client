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
import javax.validation.constraints.Pattern;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pleosoft.feign.acs.core.model.AssociationBody;
import com.pleosoft.feign.acs.core.model.AssociationEntry;
import com.pleosoft.feign.acs.core.model.ChildAssociationBody;
import com.pleosoft.feign.acs.core.model.ChildAssociationEntry;
import com.pleosoft.feign.acs.core.model.NodeAssociationPaging;
import com.pleosoft.feign.acs.core.model.NodeBodyCopy;
import com.pleosoft.feign.acs.core.model.NodeBodyCreate;
import com.pleosoft.feign.acs.core.model.NodeBodyLock;
import com.pleosoft.feign.acs.core.model.NodeBodyMove;
import com.pleosoft.feign.acs.core.model.NodeBodyUpdate;
import com.pleosoft.feign.acs.core.model.NodeChildAssociationPaging;
import com.pleosoft.feign.acs.core.model.NodeEntry;

public interface NodesApi {

	/**
	 * Copy a node
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2 and newer versions.
	 * Copies the node **nodeId** to the parent folder node **targetParentId**.
	 * You specify the **targetParentId** in the request body. The new node has
	 * the same name as the source node unless you specify a new **name** in the
	 * request body. If the source **nodeId** is a folder, then all of its
	 * children are also copied. If the source **nodeId** is a file, it's
	 * properties, aspects and tags are copied, it's ratings, comments and locks
	 * are not.
	 * </p>
	 *
	 *
	 * @param nodeId
	 *            ("The identifier of a node.",required=true)
	 * @param nodeBodyCopy
	 *            (value = "The targetParentId and, optionally, a new name which
	 *            should include the file extension." ,required=true )
	 * @param include
	 *            ("Returns additional information about the node. The following
	 *            optional fields can be requested: * allowableOperations *
	 *            association * isLink * isFavorite * isLocked * path *
	 *            permissions ")
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
	 *         NodeEntry.class),<br/>
	 *         code = 400, message = "Invalid parameter: **nodeId** is not a
	 *         valid format or **nodeBodyCopy** is invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "Current user does not have permission to
	 *         copy **nodeId**"),<br/>
	 *         code = 404, message = "**nodeId** does not exist "),<br/>
	 *         code = 409, message = "New name clashes with an existing node in
	 *         the destination parent folder"),<br/>
	 *         code = 422, message = "Model integrity exception including a file
	 *         name containing invalid characters"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/nodes/{nodeId}/copy", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	ResponseEntity<NodeEntry> copyNode(@PathVariable("nodeId") String nodeId, @RequestBody NodeBodyCopy nodeBodyCopy,
			@RequestParam(value = "include", required = false) List<String> include,
			@RequestParam(value = "fields", required = false) List<String> fields);

	/**
	 * Create node association
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2 and newer versions.
	 * Create an association, with the given association type, between the
	 * source **nodeId** and a target node. **Note:** You can create more than
	 * one association by specifying a list of associations in the JSON body
	 * like this: ```JSON [ { \"targetId\": \"string\", \"assocType\":
	 * \"string\" }, { \"targetId\": \"string\", \"assocType\": \"string\" } ]
	 * ``` If you specify a list as input, then a paginated list rather than an
	 * entry is returned in the response body. For example: ```JSON { \"list\":
	 * { \"pagination\": { \"count\": 2, \"hasMoreItems\": false,
	 * \"totalItems\": 2, \"skipCount\": 0, \"maxItems\": 100 }, \"entries\": [
	 * { \"entry\": { ... } }, { \"entry\": { ... } } ] } } ```
	 * </p>
	 *
	 *
	 * @param nodeId
	 *            ("The identifier of a source node.",required=true)
	 * @param associationBodyCreate
	 *            (value = "The target node id and assoc type." ,required=true )
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
	 *         AssociationEntry.class),<br/>
	 *         code = 400, message = "Invalid parameter: **assocType** is
	 *         unknown, or the **nodeId** is not a valid format, or
	 *         **associationBodyCreate** invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "Current user does not have permission for
	 *         **nodeId**"),<br/>
	 *         code = 404, message = "Source **nodeId** or **targetId** does not
	 *         exist"),<br/>
	 *         code = 409, message = "An association of this assoc type already
	 *         exists between these two nodes"),<br/>
	 *         code = 422, message = "Model integrity exception"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/nodes/{nodeId}/targets", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	ResponseEntity<AssociationEntry> createAssociation(@PathVariable("nodeId") String nodeId,
			@RequestBody AssociationBody associationBodyCreate,
			@RequestParam(value = "fields", required = false) List<String> fields);

	/**
	 * Create a node
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2 and newer versions.
	 * Create a node and add it as a primary child of node **nodeId**. This
	 * endpoint supports both JSON and multipart/form-data (file upload).
	 * **Using multipart/form-data** Use the **filedata** field to represent the
	 * content to upload, for example, the following curl command will create a
	 * node with the contents of test.txt in the test user's home folder.
	 * ```curl -utest:test -X POST
	 * host:port/alfresco/api/-default-/public/alfresco/versions/1/nodes/-my-/children
	 * -F filedata=@test.txt``` You can use the **name** field to give an
	 * alternative name for the new file. You can use the **nodeType** field to
	 * create a specific type. The default is cm:content. You can use the
	 * **renditions** field to create renditions (e.g. doclib) asynchronously
	 * upon upload. Also, as requesting rendition is a background process, any
	 * rendition failure (e.g. No transformer is currently available) will not
	 * fail the whole upload and has the potential to silently fail. Use
	 * **overwrite** to overwrite an existing file, matched by name. If the file
	 * is versionable, the existing content is replaced. When you overwrite
	 * existing content, you can set the **majorVersion** boolean field to
	 * **true** to indicate a major version should be created. The default for
	 * **majorVersion** is **false**. Setting **majorVersion** enables
	 * versioning of the node, if it is not already versioned. When you
	 * overwrite existing content, you can use the **comment** field to add a
	 * version comment that appears in the version history. This also enables
	 * versioning of this node, if it is not already versioned. You can set the
	 * **autoRename** boolean field to automatically resolve name clashes. If
	 * there is a name clash, then the API method tries to create a unique name
	 * using an integer suffix. You can use the **relativePath** field to
	 * specify the folder structure to create relative to the node **nodeId**.
	 * Folders in the **relativePath** that do not exist are created before the
	 * node is created. Any other field provided will be treated as a property
	 * to set on the newly created node. **Note:** setting properties of type
	 * d:content and d:category are not supported. **Using JSON** You must
	 * specify at least a **name** and **nodeType**. For example, to create a
	 * folder: ```JSON { \"name\":\"My Folder\", \"nodeType\":\"cm:folder\" }
	 * ``` You can create an empty file like this: ```JSON { \"name\":\"My text
	 * file.txt\", \"nodeType\":\"cm:content\" } ``` You can update binary
	 * content using the ```PUT /nodes/{nodeId}``` API method. You can create a
	 * folder, or other node, inside a folder hierarchy: ```JSON { \"name\":\"My
	 * Special Folder\", \"nodeType\":\"cm:folder\", \"relativePath\":\"X/Y/Z\"
	 * } ``` The **relativePath** specifies the folder structure to create
	 * relative to the node **nodeId**. Folders in the **relativePath** that do
	 * not exist are created before the node is created. You can set properties
	 * when you create a new node: ```JSON { \"name\":\"My Other Folder\",
	 * \"nodeType\":\"cm:folder\", \"properties\": { \"cm:title\":\"Folder
	 * title\", \"cm:description\":\"This is an important folder\" } } ``` Any
	 * missing aspects are applied automatically. For example, **cm:titled** in
	 * the JSON shown above. You can set aspects explicitly, if needed, using an
	 * **aspectNames** field. **Note:** setting properties of type d:content and
	 * d:category are not supported. Typically, for files and folders, the
	 * primary children are created within the parent folder using the default
	 * \"cm:contains\" assocType. If the content model allows then it is also
	 * possible to create primary children with a different assoc type. For
	 * example: ```JSON { \"name\":\"My Node\",
	 * \"nodeType\":\"my:specialNodeType\", \"association\": {
	 * \"assocType\":\"my:specialAssocType\" } } ``` Additional associations can
	 * be added after creating a node. You can also add associations at the time
	 * the node is created. This is required, for example, if the content model
	 * specifies that a node has mandatory associations to one or more existing
	 * nodes. You can optionally specify an array of **secondaryChildren** to
	 * create one or more secondary child associations, such that the newly
	 * created node acts as a parent node. You can optionally specify an array
	 * of **targets** to create one or more peer associations such that the
	 * newly created node acts as a source node. For example, to associate one
	 * or more secondary children at time of creation: ```JSON { \"name\":\"My
	 * Folder\", \"nodeType\":\"cm:folder\", \"secondaryChildren\": [
	 * {\"childId\":\"abcde-01234-...\",
	 * \"assocType\":\"my:specialChildAssocType\"} ] } ``` For example, to
	 * associate one or more targets at time of creation: ```JSON {
	 * \"name\":\"My Folder\", \"nodeType\":\"cm:folder\", \"targets\": [
	 * {\"targetId\":\"abcde-01234-...\",
	 * \"assocType\":\"my:specialPeerAssocType\"} ] } ``` **Note:** You can
	 * create more than one child by specifying a list of nodes in the JSON
	 * body. For example, the following JSON body creates two folders inside the
	 * specified **nodeId**, if the **nodeId** identifies a folder: ```JSON [ {
	 * \"name\":\"My Folder 1\", \"nodeType\":\"cm:folder\" }, { \"name\":\"My
	 * Folder 2\", \"nodeType\":\"cm:folder\" } ] ``` If you specify a list as
	 * input, then a paginated list rather than an entry is returned in the
	 * response body. For example: ```JSON { \"list\": { \"pagination\": {
	 * \"count\": 2, \"hasMoreItems\": false, \"totalItems\": 2, \"skipCount\":
	 * 0, \"maxItems\": 100 }, \"entries\": [ { \"entry\": { ... } }, {
	 * \"entry\": { ... } } ] } } ```
	 * </p>
	 *
	 *
	 * @param nodeId
	 *            ("The identifier of a node. You can also use one of these
	 *            well-known aliases: * -my- * -shared- * -root-
	 *            ",required=true)
	 * @param nodeBodyCreate
	 *            (value = "The node information to create." ,required=true )
	 * @param autoRename
	 *            ("If true, then a name clash will cause an attempt to auto
	 *            rename by finding a unique name using an integer suffix.")
	 * @param include
	 *            ("Returns additional information about the node. The following
	 *            optional fields can be requested: * allowableOperations *
	 *            association * isLink * isFavorite * isLocked * path *
	 *            permissions ")
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
	 *         NodeEntry.class),<br/>
	 *         code = 400, message = "Invalid parameter: **nodeId** is not a
	 *         valid format or **nodeBodyCreate** is invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "Current user does not have permission to
	 *         create children of **nodeId**"),<br/>
	 *         code = 404, message = "**nodeId** or **renditionId** does not
	 *         exist "),<br/>
	 *         code = 409, message = "New name clashes with an existing node in
	 *         the current parent folder"),<br/>
	 *         code = 413, message = "Content exceeds individual file size limit
	 *         configured for the network or system"),<br/>
	 *         code = 422, message = "Model integrity exception including a file
	 *         name containing invalid characters"),<br/>
	 *         code = 507, message = "Content exceeds overall storage quota
	 *         limit configured for the network or system"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/nodes/{nodeId}/children", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	ResponseEntity<NodeEntry> createNode(@PathVariable("nodeId") String nodeId,
			@RequestBody NodeBodyCreate nodeBodyCreate,
			@RequestParam(value = "autoRename", required = false) Boolean autoRename,
			@RequestParam(value = "include", required = false) List<String> include,
			@RequestParam(value = "fields", required = false) List<String> fields);

	/**
	 * Create secondary child
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2 and newer versions.
	 * Create a secondary child association, with the given association type,
	 * between the parent **nodeId** and a child node. **Note:** You can create
	 * more than one secondary child association by specifying a list of
	 * associations in the JSON body like this: ```JSON [ { \"childId\":
	 * \"string\", \"assocType\": \"string\" }, { \"childId\": \"string\",
	 * \"assocType\": \"string\" } ] ``` If you specify a list as input, then a
	 * paginated list rather than an entry is returned in the response body. For
	 * example: ```JSON { \"list\": { \"pagination\": { \"count\": 2,
	 * \"hasMoreItems\": false, \"totalItems\": 2, \"skipCount\": 0,
	 * \"maxItems\": 100 }, \"entries\": [ { \"entry\": { ... } }, { \"entry\":
	 * { ... } } ] } } ```
	 * </p>
	 *
	 *
	 * @param nodeId
	 *            ("The identifier of a parent node.",required=true)
	 * @param secondaryChildAssociationBodyCreate
	 *            (value = "The child node id and assoc type." ,required=true )
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
	 *         ChildAssociationEntry.class),<br/>
	 *         code = 400, message = "Invalid parameter: **assocType** is
	 *         unknown, or the **nodeId** is not a valid format, or
	 *         **secondaryChildAssociationBodyCreate** invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "Current user does not have permission to
	 *         create secondary children of **nodeId**"),<br/>
	 *         code = 404, message = "Parent **nodeId** or **childId** does not
	 *         exist"),<br/>
	 *         code = 409, message = "An association of this assoc type already
	 *         exists between these two nodes"),<br/>
	 *         code = 422, message = "Model integrity exception"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/nodes/{nodeId}/secondary-children", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	ResponseEntity<ChildAssociationEntry> createSecondaryChildAssociation(@PathVariable("nodeId") String nodeId,
			@RequestBody ChildAssociationBody secondaryChildAssociationBodyCreate,
			@RequestParam(value = "fields", required = false) List<String> fields);

	/**
	 * Delete node association(s)
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2 and newer versions.
	 * Delete an association, or associations, from the source **nodeId* to a
	 * target node for the given association type. If the association type is
	 * **not** specified, then all peer associations, of any type, in the
	 * direction from source to target, are deleted. **Note:** After removal of
	 * the peer association, or associations, from source to target, the two
	 * nodes may still have peer associations in the other direction.
	 * </p>
	 *
	 *
	 * @param nodeId
	 *            ("The identifier of a source node.",required=true)
	 * @param targetId
	 *            ("The identifier of a target node.",required=true)
	 * @param assocType
	 *            ("Only delete associations of this type.")
	 * @return value = { <br/>
	 *         code = 204, message = "Successful response"),<br/>
	 *         code = 400, message = "Invalid parameter: **assocType** is
	 *         unknown, or the **nodeId** is not a valid format, or **targetId**
	 *         is invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "Current user does not have permission for
	 *         **nodeId**"),<br/>
	 *         code = 404, message = "Source **nodeId** or **targetId** does not
	 *         exist (with given assocType, if specified)"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/nodes/{nodeId}/targets/{targetId}", produces = "application/json",  method = RequestMethod.DELETE)
	ResponseEntity<Void> deleteAssociation(@PathVariable("nodeId") String nodeId,
			@PathVariable("targetId") String targetId,
			@RequestParam(value = "assocType", required = false) String assocType);

	/**
	 * Delete a node
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2 and newer versions.
	 * Deletes the node **nodeId**. If **nodeId** is a folder, then its children
	 * are also deleted. Deleted nodes move to the trashcan unless the
	 * **permanent** query parameter is **true** and the current user is the
	 * owner of the node or an admin. Deleting a node deletes it from its
	 * primary parent and also from any secondary parents. Peer associations are
	 * also deleted, where the deleted node is either a source or target of an
	 * association. This applies recursively to any hierarchy of primary
	 * children of the deleted node. **Note:** If the node is not permanently
	 * deleted, and is later successfully restored to its former primary parent,
	 * then the primary child association is restored. This applies recursively
	 * for any primary children. No other secondary child associations or peer
	 * associations are restored for any of the nodes in the primary
	 * parent-child hierarchy of restored nodes, regardless of whether the
	 * original associations were to nodes inside or outside the restored
	 * hierarchy.
	 * </p>
	 *
	 *
	 * @param nodeId
	 *            ("The identifier of a node.",required=true)
	 * @param permanent
	 *            ("If **true** then the node is deleted permanently, without
	 *            moving to the trashcan. Only the owner of the node or an admin
	 *            can permanently delete the node. ", defaultValue = "false")
	 * @return value = { <br/>
	 *         code = 204, message = "Successful response"),<br/>
	 *         code = 400, message = "Invalid parameter: **nodeId** is not a
	 *         valid format "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "Current user does not have permission to
	 *         delete **nodeId**"),<br/>
	 *         code = 404, message = "**nodeId** does not exist "),<br/>
	 *         code = 409, message = "**nodeId** is locked and cannot be deleted
	 *         "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/nodes/{nodeId}", produces = "application/json",  method = RequestMethod.DELETE)
	ResponseEntity<Void> deleteNode(@PathVariable("nodeId") String nodeId,
			@RequestParam(value = "permanent", required = false, defaultValue = "false") Boolean permanent);

	/**
	 * Delete secondary child or children
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2 and newer versions.
	 * Delete secondary child associations between the parent **nodeId** and
	 * child nodes for the given association type. If the association type is
	 * **not** specified, then all secondary child associations, of any type in
	 * the direction from parent to secondary child, will be deleted. The child
	 * will still have a primary parent and may still be associated as a
	 * secondary child with other secondary parents.
	 * </p>
	 *
	 *
	 * @param nodeId
	 *            ("The identifier of a parent node.",required=true)
	 * @param childId
	 *            ("The identifier of a child node.",required=true)
	 * @param assocType
	 *            ("Only delete associations of this type.")
	 * @return value = { <br/>
	 *         code = 204, message = "Successful response"),<br/>
	 *         code = 400, message = "Invalid parameter: **assocType** is
	 *         unknown or you are trying to delete a primary **assocType**. Use
	 *         delete node instead "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "Current user does not have permission for
	 *         **nodeId**"),<br/>
	 *         code = 404, message = "Parent **nodeId** or **childId** does not
	 *         exist (with given assocType, if specified)"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/nodes/{nodeId}/secondary-children/{childId}", produces = "application/json",  method = RequestMethod.DELETE)
	ResponseEntity<Void> deleteSecondaryChildAssociation(@PathVariable("nodeId") String nodeId,
			@PathVariable("childId") String childId,
			@RequestParam(value = "assocType", required = false) String assocType);

	/**
	 * Get a node
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2 and newer versions.
	 * Get information for node **nodeId**. You can use the **include**
	 * parameter to return additional information.
	 * </p>
	 *
	 *
	 * @param nodeId
	 *            ("The identifier of a node. You can also use one of these
	 *            well-known aliases: * -my- * -shared- * -root-
	 *            ",required=true)
	 * @param include
	 *            ("Returns additional information about the node. The following
	 *            optional fields can be requested: * allowableOperations *
	 *            association * isLink * isFavorite * isLocked * path *
	 *            permissions ")
	 * @param relativePath
	 *            ("A path relative to the **nodeId**. If you set this,
	 *            information is returned on the node resolved by this path. ")
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
	 *         NodeEntry.class),<br/>
	 *         code = 400, message = "Invalid parameter: **nodeId** is not a
	 *         valid format "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "Current user does not have permission to
	 *         retrieve **nodeId**"),<br/>
	 *         code = 404, message = "**nodeId** does not exist "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/nodes/{nodeId}", produces = "application/json",  method = RequestMethod.GET)
	ResponseEntity<NodeEntry> getNode(@PathVariable("nodeId") String nodeId,
			@RequestParam(value = "include", required = false) List<String> include,
			@RequestParam(value = "relativePath", required = false) String relativePath,
			@RequestParam(value = "fields", required = false) List<String> fields);

	/**
	 * Get node content
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2 and newer versions.
	 * Gets the content of the node with identifier **nodeId**.
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
	 *         code = 416, message = "Range Not Satisfiable "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/nodes/{nodeId}/content", produces = "application/json",  method = RequestMethod.GET)
	ResponseEntity<Void> getNodeContent(@PathVariable("nodeId") String nodeId,
			@RequestParam(value = "attachment", required = false, defaultValue = "true") Boolean attachment,
			@RequestHeader(value = "If-Modified-Since", required = false) Date ifModifiedSince,
			@RequestHeader(value = "Range", required = false) String range);

	/**
	 * List node children
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2 and newer versions.
	 * Gets a list of children of the parent node **nodeId**. Minimal
	 * information for each child is returned by default. You can use the
	 * **include** parameter to return additional information. The list of child
	 * nodes includes primary children and secondary children, if there are any.
	 * You can use the **include** parameter (include=association) to return
	 * child association details for each child, including the **assocTyp**e and
	 * the **isPrimary** flag. The default sort order for the returned list is
	 * for folders to be sorted before files, and by ascending name. You can
	 * override the default using **orderBy** to specify one or more fields to
	 * sort by. The default order is always ascending, but you can use an
	 * optional **ASC** or **DESC** modifier to specify an ascending or
	 * descending sort order. For example, specifying ```orderBy=name DESC```
	 * returns a mixed folder/file list in descending **name** order. You can
	 * use any of the following fields to order the results: * isFolder * name *
	 * mimeType * nodeType * sizeInBytes * modifiedAt * createdAt *
	 * modifiedByUser * createdByUser
	 * </p>
	 *
	 *
	 * @param nodeId
	 *            ("The identifier of a node. You can also use one of these
	 *            well-known aliases: * -my- * -shared- * -root-
	 *            ",required=true)
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
	 * @param where
	 *            ("Optionally filter the list. Here are some examples: *
	 *            ```where=(isFolder=true)``` * ```where=(isFile=true)``` *
	 *            ```where=(nodeType='my:specialNodeType')``` *
	 *            ```where=(nodeType='my:specialNodeType INCLUDESUBTYPES')``` *
	 *            ```where=(isPrimary=true)``` *
	 *            ```where=(assocType='my:specialAssocType')``` *
	 *            ```where=(isPrimary=false and
	 *            assocType='my:specialAssocType')``` ")
	 * @param include
	 *            ("Returns additional information about the node. The following
	 *            optional fields can be requested: * allowableOperations *
	 *            aspectNames * association * isLink * isFavorite * isLocked *
	 *            path * properties * permissions ")
	 * @param relativePath
	 *            ("Return information on children in the folder resolved by
	 *            this path. The path is relative to **nodeId**.")
	 * @param includeSource
	 *            ("Also include **source** in addition to **entries** with
	 *            folder information on the parent node – either the specified
	 *            parent **nodeId**, or as resolved by **relativePath**.")
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
	 *         NodeChildAssociationPaging.class),<br/>
	 *         code = 400, message = "Invalid parameter: **nodeId** is not a
	 *         valid format, **nodeId** is not a folder or **orderBy** is
	 *         invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "Current user does not have permission to
	 *         retrieve children of **nodeId**"),<br/>
	 *         code = 404, message = "**nodeId** does not exist "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/nodes/{nodeId}/children", produces = "application/json",  method = RequestMethod.GET)
	ResponseEntity<NodeChildAssociationPaging> listNodeChildren(@PathVariable("nodeId") String nodeId,
			@Min(0) @RequestParam(value = "skipCount", required = false, defaultValue = "0") Integer skipCount,
			@Min(1) @RequestParam(value = "maxItems", required = false, defaultValue = "100") Integer maxItems,
			@RequestParam(value = "orderBy", required = false) List<String> orderBy,
			@RequestParam(value = "where", required = false) String where,
			@RequestParam(value = "include", required = false) List<String> include,
			@RequestParam(value = "relativePath", required = false) String relativePath,
			@RequestParam(value = "includeSource", required = false) Boolean includeSource,
			@RequestParam(value = "fields", required = false) List<String> fields);

	/**
	 * List parents
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2 and newer versions.
	 * Gets a list of parent nodes that are associated with the current child
	 * **nodeId**. The list includes both the primary parent and any secondary
	 * parents.
	 * </p>
	 *
	 *
	 * @param nodeId
	 *            ("The identifier of a child node. You can also use one of
	 *            these well-known aliases: * -my- * -shared- * -root-
	 *            ",required=true)
	 * @param where
	 *            ("Optionally filter the list by **assocType** and/or
	 *            **isPrimary**. Here are some example filters: *
	 *            ```where=(assocType='my:specialAssocType')``` *
	 *            ```where=(isPrimary=true)``` * ```where=(isPrimary=false and
	 *            assocType='my:specialAssocType')``` ")
	 * @param include
	 *            ("Returns additional information about the node. The following
	 *            optional fields can be requested: * allowableOperations *
	 *            aspectNames * isLink * isFavorite * isLocked * path *
	 *            properties ")
	 * @param skipCount
	 *            ("The number of entities that exist in the collection before
	 *            those included in this list. If not supplied then the default
	 *            value is 0. ", defaultValue = "0")
	 * @param maxItems
	 *            ("The maximum number of items to return in the list. If not
	 *            supplied then the default value is 100. ", defaultValue =
	 *            "100")
	 * @param includeSource
	 *            ("Also include **source** (in addition to **entries**) with
	 *            folder information on **nodeId**")
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
	 *         NodeAssociationPaging.class),<br/>
	 *         code = 400, message = "Invalid parameter: **assocType** is
	 *         unknown or the **nodeId** is not a valid format "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "Current user does not have permission for
	 *         **nodeId**"),<br/>
	 *         code = 404, message = "Child **nodeId** does not exist"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/nodes/{nodeId}/parents", produces = "application/json",  method = RequestMethod.GET)
	ResponseEntity<NodeAssociationPaging> listParents(@PathVariable("nodeId") String nodeId,
			@RequestParam(value = "where", required = false) String where,
			@RequestParam(value = "include", required = false) List<String> include,
			@Min(0) @RequestParam(value = "skipCount", required = false, defaultValue = "0") Integer skipCount,
			@Min(1) @RequestParam(value = "maxItems", required = false, defaultValue = "100") Integer maxItems,
			@RequestParam(value = "includeSource", required = false) Boolean includeSource,
			@RequestParam(value = "fields", required = false) List<String> fields);

	/**
	 * List secondary children
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2 and newer versions.
	 * Gets a list of secondary child nodes that are associated with the current
	 * parent **nodeId**, via a secondary child association.
	 * </p>
	 *
	 *
	 * @param nodeId
	 *            ("The identifier of a parent node. You can also use one of
	 *            these well-known aliases: * -my- * -shared- * -root-
	 *            ",required=true)
	 * @param where
	 *            ("Optionally filter the list by assocType. Here's an example:
	 *            * ```where=(assocType='my:specialAssocType')``` ")
	 * @param include
	 *            ("Returns additional information about the node. The following
	 *            optional fields can be requested: * allowableOperations *
	 *            aspectNames * isLink * isFavorite * isLocked * path *
	 *            properties ")
	 * @param skipCount
	 *            ("The number of entities that exist in the collection before
	 *            those included in this list. If not supplied then the default
	 *            value is 0. ", defaultValue = "0")
	 * @param maxItems
	 *            ("The maximum number of items to return in the list. If not
	 *            supplied then the default value is 100. ", defaultValue =
	 *            "100")
	 * @param includeSource
	 *            ("Also include **source** (in addition to **entries**) with
	 *            folder information on **nodeId**")
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
	 *         NodeChildAssociationPaging.class),<br/>
	 *         code = 400, message = "Invalid parameter: **assocType** is
	 *         unknown or the **nodeId** is not a valid format "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "Current user does not have permission for
	 *         **nodeId**"),<br/>
	 *         code = 404, message = "Parent **nodeId** does not exist"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/nodes/{nodeId}/secondary-children", produces = "application/json",  method = RequestMethod.GET)
	ResponseEntity<NodeChildAssociationPaging> listSecondaryChildren(@PathVariable("nodeId") String nodeId,
			@RequestParam(value = "where", required = false) String where,
			@RequestParam(value = "include", required = false) List<String> include,
			@Min(0) @RequestParam(value = "skipCount", required = false, defaultValue = "0") Integer skipCount,
			@Min(1) @RequestParam(value = "maxItems", required = false, defaultValue = "100") Integer maxItems,
			@RequestParam(value = "includeSource", required = false) Boolean includeSource,
			@RequestParam(value = "fields", required = false) List<String> fields);

	/**
	 * List source associations
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2 and newer versions.
	 * Gets a list of source nodes that are associated with the current target
	 * **nodeId**.
	 * </p>
	 *
	 *
	 * @param nodeId
	 *            ("The identifier of a target node.",required=true)
	 * @param where
	 *            ("Optionally filter the list by **assocType**. Here's an
	 *            example: * ```where=(assocType='my:specialAssocType')``` ")
	 * @param include
	 *            ("Returns additional information about the node. The following
	 *            optional fields can be requested: * allowableOperations *
	 *            aspectNames * isLink * isFavorite * isLocked * path *
	 *            properties ")
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
	 *         NodeAssociationPaging.class),<br/>
	 *         code = 400, message = "Invalid parameter: **nodeId** is not a
	 *         valid format or **assocType** is unknown "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "Current user does not have permission for
	 *         **nodeId**"),<br/>
	 *         code = 404, message = "Target **nodeId** does not exist"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/nodes/{nodeId}/sources", produces = "application/json",  method = RequestMethod.GET)
	ResponseEntity<NodeAssociationPaging> listSourceAssociations(@PathVariable("nodeId") String nodeId,
			@RequestParam(value = "where", required = false) String where,
			@RequestParam(value = "include", required = false) List<String> include,
			@RequestParam(value = "fields", required = false) List<String> fields);

	/**
	 * List target associations
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2 and newer versions.
	 * Gets a list of target nodes that are associated with the current source
	 * **nodeId**.
	 * </p>
	 *
	 *
	 * @param nodeId
	 *            ("The identifier of a source node.",required=true)
	 * @param where
	 *            ("Optionally filter the list by **assocType**. Here's an
	 *            example: * ```where=(assocType='my:specialAssocType')``` ")
	 * @param include
	 *            ("Returns additional information about the node. The following
	 *            optional fields can be requested: * allowableOperations *
	 *            aspectNames * isLink * isFavorite * isLocked * path *
	 *            properties ")
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
	 *         NodeAssociationPaging.class),<br/>
	 *         code = 400, message = "Invalid parameter: **assocType** is
	 *         unknown or the **nodeId** is not a valid format "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "Current user does not have permission for
	 *         **nodeId**"),<br/>
	 *         code = 404, message = "Source **nodeId** does not exist"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/nodes/{nodeId}/targets", produces = "application/json",  method = RequestMethod.GET)
	ResponseEntity<NodeAssociationPaging> listTargetAssociations(@PathVariable("nodeId") String nodeId,
			@RequestParam(value = "where", required = false) String where,
			@RequestParam(value = "include", required = false) List<String> include,
			@RequestParam(value = "fields", required = false) List<String> fields);

	/**
	 * Lock a node
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2 and newer versions.
	 * Places a lock on node **nodeId**. **Note:** you can only lock files. More
	 * specifically, a node can only be locked if it is of type `cm:content` or
	 * a subtype of `cm:content`. The lock is owned by the current user, and
	 * prevents other users or processes from making updates to the node until
	 * the lock is released. If the **timeToExpire** is not set or is zero, then
	 * the lock never expires. Otherwise, the **timeToExpire** is the number of
	 * seconds before the lock expires. When a lock expires, the lock is
	 * released. If the node is already locked, and the user is the lock owner,
	 * then the lock is renewed with the new **timeToExpire**. By default, a
	 * lock is applied that allows the owner to update or delete the node. You
	 * can use **type** to change the lock type to one of the following: *
	 * **ALLOW_OWNER_CHANGES** (default) changes to the node can be made only by
	 * the lock owner. This enum is the same value as the deprecated WRITE_LOCK
	 * described in `org.alfresco.service.cmr.lock.LockType` in the Alfresco
	 * Public Java API. This is the default value. * **FULL** no changes by any
	 * user are allowed. This enum is the same value as the deprecated
	 * READ_ONLY_LOCK described in `org.alfresco.service.cmr.lock.LockType` in
	 * the Alfresco Public Java API. By default, a lock is persisted in the
	 * database. You can create a volatile in-memory lock by setting the
	 * **lifetime** property to EPHEMERAL. You might choose use EPHEMERAL locks,
	 * for example, if you are taking frequent short-term locks that you don't
	 * need to be kept over a restart of the repository. In this case you don't
	 * need the overhead of writing the locks to the database. If a lock on the
	 * node cannot be taken, then an error is returned.
	 * </p>
	 *
	 *
	 * @param nodeId
	 *            ("The identifier of a node.",required=true)
	 * @param nodeBodyLock
	 *            (value = "Lock details." ,required=true )
	 * @param include
	 *            ("Returns additional information about the node. The following
	 *            optional fields can be requested: * allowableOperations *
	 *            association * isLink * isFavorite * isLocked * path *
	 *            permissions ")
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
	 *         NodeEntry.class),<br/>
	 *         code = 400, message = "Invalid parameter: **nodeId** is not a
	 *         valid format, or **nodeBodyLock** is invalid, or a lock was
	 *         attempted on a node that is not a file "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "Current user does not have permission to
	 *         lock **nodeId** "),<br/>
	 *         code = 404, message = "**nodeId** does not exist "),<br/>
	 *         code = 422, message = "**nodeId** could not be locked "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/nodes/{nodeId}/lock", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	ResponseEntity<NodeEntry> lockNode(@PathVariable("nodeId") String nodeId, @RequestBody NodeBodyLock nodeBodyLock,
			@RequestParam(value = "include", required = false) List<String> include,
			@RequestParam(value = "fields", required = false) List<String> fields);

	/**
	 * Move a node
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2 and newer versions.
	 * Move the node **nodeId** to the parent folder node **targetParentId**.
	 * The **targetParentId** is specified in the in request body. The moved
	 * node retains its name unless you specify a new **name** in the request
	 * body. If the source **nodeId** is a folder, then its children are also
	 * moved. The move will effectively change the primary parent.
	 * </p>
	 *
	 *
	 * @param nodeId
	 *            ("The identifier of a node.",required=true)
	 * @param nodeBodyMove
	 *            (value = "The targetParentId and, optionally, a new name which
	 *            should include the file extension." ,required=true )
	 * @param include
	 *            ("Returns additional information about the node. The following
	 *            optional fields can be requested: * allowableOperations *
	 *            association * isLink * isFavorite * isLocked * path *
	 *            permissions ")
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
	 *         NodeEntry.class),<br/>
	 *         code = 400, message = "Invalid parameter: **nodeId** is not a
	 *         valid format, or **targetParentId** is not a folder, or
	 *         **nodeBodyMove** is invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "Current user does not have permission to
	 *         move **nodeId**"),<br/>
	 *         code = 404, message = "**nodeId** does not exist "),<br/>
	 *         code = 409, message = "New name clashes with an existing node in
	 *         the destination parent folder"),<br/>
	 *         code = 422, message = "Model integrity exception including a file
	 *         name containing invalid characters"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/nodes/{nodeId}/move", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	ResponseEntity<NodeEntry> moveNode(@PathVariable("nodeId") String nodeId, @RequestBody NodeBodyMove nodeBodyMove,
			@RequestParam(value = "include", required = false) List<String> include,
			@RequestParam(value = "fields", required = false) List<String> fields);

	/**
	 * Unlock a node
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2 and newer versions.
	 * Deletes a lock on node **nodeId**. The current user must be the owner of
	 * the locks or have admin rights, otherwise an error is returned. If a lock
	 * on the node cannot be released, then an error is returned.
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
	 *         NodeEntry.class),<br/>
	 *         code = 400, message = "Invalid parameter: **nodeId** is not a
	 *         valid format "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "Current user does not have permission to
	 *         unlock **nodeId** "),<br/>
	 *         code = 404, message = "**nodeId** does not exist "),<br/>
	 *         code = 422, message = "**nodeId** could not be unlocked "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/nodes/{nodeId}/unlock", produces = "application/json",  method = RequestMethod.POST)
	ResponseEntity<NodeEntry> unlockNode(@PathVariable("nodeId") String nodeId,
			@RequestParam(value = "include", required = false) List<String> include,
			@RequestParam(value = "fields", required = false) List<String> fields);

	/**
	 * Update a node
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2 and newer versions.
	 * Updates the node **nodeId**. For example, you can rename a file or
	 * folder: ```JSON { \"name\":\"My new name\" } ``` You can also set or
	 * update one or more properties: ```JSON { \"properties\": {
	 * \"cm:title\":\"Folder title\" } } ``` **Note:** setting properties of
	 * type d:content and d:category are not supported. **Note:** if you want to
	 * add or remove aspects, then you must use **GET /nodes/{nodeId}** first to
	 * get the complete set of *aspectNames*. You can add (or remove)
	 * *locallySet* permissions, if any, in addition to any inherited
	 * permissions. You can also optionally disable (or re-enable) inherited
	 * permissions via *isInheritanceEnabled* flag: ```JSON { \"permissions\": {
	 * \"isInheritanceEnabled\": false, \"locallySet\": [ {\"authorityId\":
	 * \"GROUP_special\", \"name\": \"Read\", \"accessStatus\":\"DENIED\"},
	 * {\"authorityId\": \"testuser\", \"name\": \"Contributor\",
	 * \"accessStatus\":\"ALLOWED\"} ] } } ``` **Note:** if you want to add or
	 * remove locally set permissions then you must use **GET /nodes/{nodeId}**
	 * first to get the complete set of *locallySet* permissions. **Note:**
	 * Currently there is no optimistic locking for updates, so they are applied
	 * in \"last one wins\" order.
	 * </p>
	 *
	 *
	 * @param nodeId
	 *            ("The identifier of a node.",required=true)
	 * @param nodeBodyUpdate
	 *            (value = "The node information to update." ,required=true )
	 * @param include
	 *            ("Returns additional information about the node. The following
	 *            optional fields can be requested: * allowableOperations *
	 *            association * isLink * isFavorite * isLocked * path *
	 *            permissions ")
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
	 *         NodeEntry.class),<br/>
	 *         code = 400, message = "Invalid parameter: the update request is
	 *         invalid or **nodeId** is not a valid format or **nodeBodyUpdate**
	 *         is invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "Current user does not have permission to
	 *         update **nodeId**"),<br/>
	 *         code = 404, message = "**nodeId** does not exist "),<br/>
	 *         code = 409, message = "Updated name clashes with an existing node
	 *         in the current parent folder"),<br/>
	 *         code = 422, message = "Model integrity exception including a file
	 *         name containing invalid characters"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/nodes/{nodeId}", produces = "application/json", consumes = "application/json", method = RequestMethod.PUT)
	ResponseEntity<NodeEntry> updateNode(@PathVariable("nodeId") String nodeId,
			@RequestBody NodeBodyUpdate nodeBodyUpdate,
			@RequestParam(value = "include", required = false) List<String> include,
			@RequestParam(value = "fields", required = false) List<String> fields);

	/**
	 * Update node content
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2 and newer versions.
	 * Updates the content of the node with identifier **nodeId**. The request
	 * body for this endpoint can be any text or binary stream. The
	 * **majorVersion** and **comment** parameters can be used to control
	 * versioning behaviour. If the content is versionable, a new minor version
	 * is created by default. Optionally a new **name** parameter can also be
	 * specified that must be unique within the parent folder. If specified and
	 * valid then this will rename the node. If invalid then an error is
	 * returned and the content is not updated. **Note:** This API method
	 * accepts any content type, but for testing with this tool text based
	 * content can be provided. This is because the OpenAPI Specification does
	 * not allow a wildcard to be provided or the ability for tooling to accept
	 * an arbitrary file.
	 * </p>
	 *
	 *
	 * @param nodeId
	 *            ("The identifier of a node.",required=true)
	 * @param contentBodyUpdate
	 *            (value = "The binary content" ,required=true )
	 * @param majorVersion
	 *            ("If **true**, create a major version. Setting this parameter
	 *            also enables versioning of this node, if it is not already
	 *            versioned. ", defaultValue = "false")
	 * @param comment
	 *            ("Add a version comment which will appear in version history.
	 *            Setting this parameter also enables versioning of this node,
	 *            if it is not already versioned. ")
	 * @param name
	 *            ("Optional new name. This should include the file extension.
	 *            The name must not contain spaces or the following special
	 *            characters: * \" < > \\ / ? : and |. The character `.` must
	 *            not be used at the end of the name. ")
	 * @param include
	 *            ("Returns additional information about the node. The following
	 *            optional fields can be requested: * allowableOperations *
	 *            association * isLink * isFavorite * isLocked * path *
	 *            permissions ")
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
	 *         NodeEntry.class),<br/>
	 *         code = 400, message = "Invalid parameter: **nodeId** is not a
	 *         valid format, or is not a file "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "Current user does not have permission to
	 *         update **nodeId**"),<br/>
	 *         code = 404, message = "**nodeId** does not exist "),<br/>
	 *         code = 409, message = "Optional new name clashes with an existing
	 *         node in the current parent folder"),<br/>
	 *         code = 413, message = "Content exceeds individual file size limit
	 *         (configured for network/system)"),<br/>
	 *         code = 422, message = "Model integrity exception including a file
	 *         name containing invalid characters"),<br/>
	 *         code = 507, message = "Content exceeds overall storage quota
	 *         limit configured for the network/system"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/nodes/{nodeId}/content", produces = "application/json", consumes = "application/octet-stream", method = RequestMethod.PUT)
	ResponseEntity<NodeEntry> updateNodeContent(@PathVariable("nodeId") String nodeId,
			@RequestBody byte[] contentBodyUpdate,
			@RequestParam(value = "majorVersion", required = false, defaultValue = "false") Boolean majorVersion,
			@RequestParam(value = "comment", required = false) String comment,
			@Pattern(regexp = "^(?!(.*[\\\"\\*\\\\\\>\\<\\?/\\:\\|]+.*)|(.*[\\.]?.*[\\.]+$)|(.*[ ]+$))") @RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "include", required = false) List<String> include,
			@RequestParam(value = "fields", required = false) List<String> fields);

}
