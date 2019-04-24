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

import com.pleosoft.feign.acs.core.model.RenditionEntry;
import com.pleosoft.feign.acs.core.model.RenditionPaging;
import com.pleosoft.feign.acs.core.model.SharedLinkBodyCreate;
import com.pleosoft.feign.acs.core.model.SharedLinkBodyEmail;
import com.pleosoft.feign.acs.core.model.SharedLinkEntry;
import com.pleosoft.feign.acs.core.model.SharedLinkPaging;

public interface SharedLinksApi {

	/**
	 * Create a shared link to a file
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2 and newer versions.
	 * Create a shared link to the file **nodeId** in the request body. Also, an
	 * optional expiry date could be set, so the shared link would become
	 * invalid when the expiry date is reached. For example: ```JSON {
	 * \"nodeId\": \"1ff9da1a-ee2f-4b9c-8c34-3333333333\", \"expiresAt\":
	 * \"2017-03-23T23:00:00.000+0000\" } ``` **Note:** You can create shared
	 * links to more than one file specifying a list of **nodeId**s in the JSON
	 * body like this: ```JSON [ { \"nodeId\":
	 * \"1ff9da1a-ee2f-4b9c-8c34-4444444444\" }, { \"nodeId\":
	 * \"1ff9da1a-ee2f-4b9c-8c34-5555555555\" } ] ``` If you specify a list as
	 * input, then a paginated list rather than an entry is returned in the
	 * response body. For example: ```JSON { \"list\": { \"pagination\": {
	 * \"count\": 2, \"hasMoreItems\": false, \"totalItems\": 2, \"skipCount\":
	 * 0, \"maxItems\": 100 }, \"entries\": [ { \"entry\": { ... } }, {
	 * \"entry\": { ... } } ] } } ```
	 * </p>
	 *
	 *
	 * @param sharedLinkBodyCreate
	 *            (value = "The nodeId to create a shared link for."
	 *            ,required=true )
	 * @param include
	 *            ("Returns additional information about the shared link, the
	 *            following optional fields can be requested: *
	 *            allowableOperations * path ")
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
	 *         SharedLinkEntry.class),<br/>
	 *         code = 400, message = "Invalid parameter: **nodeId** is not a
	 *         valid format, or does not identify a file, or
	 *         **sharedLinkBodyCreate** invalid, or the specified expiry date is
	 *         invalid. E.g. the expiry date has already passed "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "Current user does not have permission to
	 *         create **sharedId** (for example, no read permission)"),<br/>
	 *         code = 404, message = "**nodeId** does not exist "),<br/>
	 *         code = 409, message = "Shared link already exists for
	 *         **nodeId**"),<br/>
	 *         code = 501, message = "Shared links are disabled for the
	 *         system"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/shared-links", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	ResponseEntity<SharedLinkEntry> createSharedLink(@RequestBody SharedLinkBodyCreate sharedLinkBodyCreate,
			@RequestParam(value = "include", required = false) List<String> include,
			@RequestParam(value = "fields", required = false) List<String> fields);

	/**
	 * Deletes a shared link
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2 and newer versions.
	 * Deletes the shared link with identifier **sharedId**.
	 * </p>
	 *
	 *
	 * @param sharedId
	 *            ("The identifier of a shared link to a file.",required=true)
	 * @return value = { <br/>
	 *         code = 204, message = "Successful response"),<br/>
	 *         code = 400, message = "Invalid parameter: **sharedId** is not a
	 *         valid format "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "Current user does not have permission to
	 *         delete **sharedId**"),<br/>
	 *         code = 404, message = "**sharedId** does not exist "),<br/>
	 *         code = 501, message = "Shared links are disabled for the
	 *         system"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/shared-links/{sharedId}", produces = "application/json", consumes = "", method = RequestMethod.DELETE)
	ResponseEntity<Void> deleteSharedLink(@PathVariable("sharedId") String sharedId);

	/**
	 * Email shared link
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2 and newer versions.
	 * Sends email with app-specific url including identifier **sharedId**. The
	 * client and recipientEmails properties are mandatory in the request body.
	 * For example, to email a shared link with minimum info: ```JSON {
	 * \"client\": \"myClient\", \"recipientEmails\": [\"john.doe@acme.com\",
	 * \"joe.bloggs@acme.com\"] } ``` A plain text message property can be
	 * optionally provided in the request body to customise the sent email.
	 * Also, a locale property can be optionally provided in the request body to
	 * send the emails in a particular language (if the locale is supported by
	 * Alfresco). For example, to email a shared link with a messages and a
	 * locale: ```JSON { \"client\": \"myClient\", \"recipientEmails\":
	 * [\"john.doe@acme.com\", \"joe.bloggs@acme.com\"], \"message\":
	 * \"myMessage\", \"locale\":\"en-GB\" } ``` **Note:** The client must be
	 * registered before you can send a shared link email. See [server
	 * documentation]. However, out-of-the-box share is registered as a default
	 * client, so you could pass **share** as the client name: ```JSON {
	 * \"client\": \"share\", \"recipientEmails\": [\"john.doe@acme.com\"] } ```
	 * </p>
	 *
	 *
	 * @param sharedId
	 *            ("The identifier of a shared link to a file.",required=true)
	 * @param sharedLinkBodyEmail
	 *            (value = "The shared link email to send." ,required=true )
	 * @return value = { <br/>
	 *         code = 202, message = "Successful response"),<br/>
	 *         code = 400, message = "Invalid parameter: **sharedId** is not a
	 *         valid format or **sharedLinkBodyEmail** invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 404, message = "**sharedId** does not exist or **client**
	 *         is not registered "),<br/>
	 *         code = 501, message = "Shared links are disabled for the
	 *         system"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/shared-links/{sharedId}/email", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	ResponseEntity<Void> emailSharedLink(@PathVariable("sharedId") String sharedId,
			@RequestBody SharedLinkBodyEmail sharedLinkBodyEmail);

	/**
	 * Get a shared link
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2 and newer versions.
	 * Gets minimal information for the file with shared link identifier
	 * **sharedId**. **Note:** No authentication is required to call this
	 * endpoint.
	 * </p>
	 *
	 *
	 * @param sharedId
	 *            ("The identifier of a shared link to a file.",required=true)
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
	 *         SharedLinkEntry.class),<br/>
	 *         code = 400, message = "Invalid parameter: **sharedId** is not a
	 *         valid format "),<br/>
	 *         code = 404, message = "**sharedId** does not exist "),<br/>
	 *         code = 501, message = "Shared links are disabled for the
	 *         system"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/shared-links/{sharedId}", produces = "application/json", consumes = "", method = RequestMethod.GET)
	ResponseEntity<SharedLinkEntry> getSharedLink(@PathVariable("sharedId") String sharedId,
			@RequestParam(value = "fields", required = false) List<String> fields);

	/**
	 * Get shared link content
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2 and newer versions.
	 * Gets the content of the file with shared link identifier **sharedId**.
	 * **Note:** No authentication is required to call this endpoint.
	 * </p>
	 *
	 *
	 * @param sharedId
	 *            ("The identifier of a shared link to a file.",required=true)
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
	 *         code = 400, message = "Invalid parameter: **sharedId** is not a
	 *         valid format "),<br/>
	 *         code = 404, message = "**sharedId** does not exist "),<br/>
	 *         code = 416, message = "Range Not Satisfiable"),<br/>
	 *         code = 501, message = "Shared links are disabled for the
	 *         system"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/shared-links/{sharedId}/content", produces = "application/json", consumes = "", method = RequestMethod.GET)
	ResponseEntity<Void> getSharedLinkContent(@PathVariable("sharedId") String sharedId,
			@RequestParam(value = "attachment", required = false, defaultValue = "true") Boolean attachment,
			@RequestHeader(value = "If-Modified-Since", required = false) Date ifModifiedSince,
			@RequestHeader(value = "Range", required = false) String range);

	/**
	 * Get shared link rendition information
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2 and newer versions.
	 * Gets rendition information for the file with shared link identifier
	 * **sharedId**. This API method returns rendition information where the
	 * rendition status is CREATED, which means the rendition is available to
	 * view/download. **Note:** No authentication is required to call this
	 * endpoint.
	 * </p>
	 *
	 *
	 * @param sharedId
	 *            ("The identifier of a shared link to a file.",required=true)
	 * @param renditionId
	 *            ("The name of a thumbnail rendition, for example *doclib*, or
	 *            *pdf*.",required=true)
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response", response =
	 *         RenditionEntry.class),<br/>
	 *         code = 400, message = "Invalid parameter: **sharedId** is not a
	 *         valid format, or **renditionId** is invalid "),<br/>
	 *         code = 404, message = "**sharedId** or **renditionId** does not
	 *         exist (ie. not CREATED) "),<br/>
	 *         code = 501, message = "Shared links are disabled for the
	 *         system"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/shared-links/{sharedId}/renditions/{renditionId}", produces = "application/json", consumes = "", method = RequestMethod.GET)
	ResponseEntity<RenditionEntry> getSharedLinkRendition(@PathVariable("sharedId") String sharedId,
			@PathVariable("renditionId") String renditionId);

	/**
	 * Get shared link rendition content
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2 and newer versions.
	 * Gets the rendition content for file with shared link identifier
	 * **sharedId**. **Note:** No authentication is required to call this
	 * endpoint.
	 * </p>
	 *
	 *
	 * @param sharedId
	 *            ("The identifier of a shared link to a file.",required=true)
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
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response"),<br/>
	 *         code = 206, message = "Partial Content"),<br/>
	 *         code = 304, message = "Content has not been modified since the
	 *         date provided in the If-Modified-Since header"),<br/>
	 *         code = 400, message = "Invalid parameter: **sharedId** is not a
	 *         valid format, or **renditionId** is invalid "),<br/>
	 *         code = 404, message = "**sharedId** does not exist "),<br/>
	 *         code = 416, message = "Range Not Satisfiable"),<br/>
	 *         code = 501, message = "Shared links are disabled for the
	 *         system"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/shared-links/{sharedId}/renditions/{renditionId}/content", produces = "application/json", consumes = "", method = RequestMethod.GET)
	ResponseEntity<Void> getSharedLinkRenditionContent(@PathVariable("sharedId") String sharedId,
			@PathVariable("renditionId") String renditionId,
			@RequestParam(value = "attachment", required = false, defaultValue = "true") Boolean attachment,
			@RequestHeader(value = "If-Modified-Since", required = false) Date ifModifiedSince,
			@RequestHeader(value = "Range", required = false) String range);

	/**
	 * List renditions for a shared link
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2 and newer versions.
	 * Gets a list of the rendition information for the file with shared link
	 * identifier **sharedId**. This API method returns rendition information,
	 * including the rendition id, for each rendition where the rendition status
	 * is CREATED, which means the rendition is available to view/download.
	 * **Note:** No authentication is required to call this endpoint.
	 * </p>
	 *
	 *
	 * @param sharedId
	 *            ("The identifier of a shared link to a file.",required=true)
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response", response =
	 *         RenditionPaging.class),<br/>
	 *         code = 400, message = "Invalid parameter: **sharedId** is not a
	 *         valid format "),<br/>
	 *         code = 404, message = "**sharedId** does not exist "),<br/>
	 *         code = 501, message = "Shared links are disabled for the
	 *         system"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/shared-links/{sharedId}/renditions", produces = "application/json", consumes = "", method = RequestMethod.GET)
	ResponseEntity<RenditionPaging> listSharedLinkRenditions(@PathVariable("sharedId") String sharedId);

	/**
	 * List shared links
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2 and newer versions.
	 * Get a list of links that the current user has read permission on source
	 * node. The list is ordered in descending modified order. **Note:** The
	 * list of links is eventually consistent so newly created shared links may
	 * not appear immediately.
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
	 *            ("Optionally filter the list by \"sharedByUser\" userid of
	 *            person who shared the link (can also use -me-) *
	 *            ```where=(sharedByUser='jbloggs')``` *
	 *            ```where=(sharedByUser='-me-')``` ")
	 * @param include
	 *            ("Returns additional information about the shared link, the
	 *            following optional fields can be requested: *
	 *            allowableOperations * path ")
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
	 *         SharedLinkPaging.class),<br/>
	 *         code = 400, message = "Invalid parameter: value of **maxItems**
	 *         or **skipCount** is invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 501, message = "Shared links are disabled for the
	 *         system"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/shared-links", produces = "application/json", consumes = "", method = RequestMethod.GET)
	ResponseEntity<SharedLinkPaging> listSharedLinks(
			@Min(0) @RequestParam(value = "skipCount", required = false, defaultValue = "0") Integer skipCount,
			@Min(1) @RequestParam(value = "maxItems", required = false, defaultValue = "100") Integer maxItems,
			@RequestParam(value = "where", required = false) String where,
			@RequestParam(value = "include", required = false) List<String> include,
			@RequestParam(value = "fields", required = false) List<String> fields);

}
