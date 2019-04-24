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

import com.pleosoft.feign.acs.core.model.ClientBody;
import com.pleosoft.feign.acs.core.model.PasswordResetBody;
import com.pleosoft.feign.acs.core.model.PersonBodyCreate;
import com.pleosoft.feign.acs.core.model.PersonBodyUpdate;
import com.pleosoft.feign.acs.core.model.PersonEntry;
import com.pleosoft.feign.acs.core.model.PersonPaging;

public interface PeopleApi {

	/**
	 * Create person
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2 and newer versions.
	 * Create a person. If applicable, the given person's login access can also
	 * be optionally disabled. You must have admin rights to create a person.
	 * You can set custom properties when you create a person: ```JSON { \"id\":
	 * \"abeecher\", \"firstName\": \"Alice\", \"lastName\": \"Beecher\",
	 * \"email\": \"abeecher@example.com\", \"password\": \"secret\",
	 * \"properties\": { \"my:property\": \"The value\" } } ``` **Note:**
	 * setting properties of type d:content and d:category are not supported.
	 * </p>
	 *
	 *
	 * @param personBodyCreate
	 *            (value = "The person details." ,required=true )
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
	 *         PersonEntry.class),<br/>
	 *         code = 400, message = "Invalid parameter: **personBodyCreate** is
	 *         invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "Current user does not have permission to
	 *         create a person"),<br/>
	 *         code = 409, message = "Person within given *id* already
	 *         exists"),<br/>
	 *         code = 422, message = "Model integrity exception"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/people", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	ResponseEntity<PersonEntry> createPerson(@RequestBody PersonBodyCreate personBodyCreate,
			@RequestParam(value = "fields", required = false) List<String> fields);

	/**
	 * Delete avatar image
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2.2 and newer
	 * versions. Deletes the avatar image related to person **personId**. You
	 * must be the person or have admin rights to update a person's avatar. You
	 * can use the `-me-` string in place of `<personId>` to specify the
	 * currently authenticated user.
	 * </p>
	 *
	 *
	 * @param personId
	 *            ("The identifier of a person.",required=true)
	 * @return value = { <br/>
	 *         code = 204, message = "Successful response"),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "Current user does not have permission to
	 *         delete the avatar image for **personId**"),<br/>
	 *         code = 404, message = "**personId** does not exist "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/people/{personId}/avatar", produces = "application/json", consumes = "", method = RequestMethod.DELETE)
	ResponseEntity<Void> deleteAvatarImage(@PathVariable("personId") String personId);

	/**
	 * Get avatar image
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2.2 and newer
	 * versions. Gets the avatar image related to the person **personId**. If
	 * the person has no related avatar then the **placeholder** query parameter
	 * can be optionally used to request a placeholder image to be returned. You
	 * can use the `-me-` string in place of `<personId>` to specify the
	 * currently authenticated user.
	 * </p>
	 *
	 *
	 * @param personId
	 *            ("The identifier of a person.",required=true)
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
	 * @param placeholder
	 *            ("If **true** and there is no avatar for this **personId**
	 *            then the placeholder image is returned, rather than a 404
	 *            response. ", defaultValue = "true")
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response"),<br/>
	 *         code = 304, message = "Content has not been modified since the
	 *         date provided in the If-Modified-Since header"),<br/>
	 *         code = 400, message = "Invalid parameter: **personId** is not a
	 *         valid format "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 404, message = "**personId** does not exist or avatar does
	 *         not exist (and no placeholder requested) "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/people/{personId}/avatar", produces = "application/json", consumes = "", method = RequestMethod.GET)
	ResponseEntity<Void> getAvatarImage(@PathVariable("personId") String personId,
			@RequestParam(value = "attachment", required = false, defaultValue = "true") Boolean attachment,
			@RequestHeader(value = "If-Modified-Since", required = false) Date ifModifiedSince,
			@RequestParam(value = "placeholder", required = false, defaultValue = "true") Boolean placeholder);

	/**
	 * Get a person
	 *
	 * <p>
	 * Gets information for the person **personId**. You can use the `-me-`
	 * string in place of `<personId>` to specify the currently authenticated
	 * user.
	 * </p>
	 *
	 *
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
	 *         PersonEntry.class),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 404, message = "**personId** does not exist "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/people/{personId}", produces = "application/json", consumes = "", method = RequestMethod.GET)
	ResponseEntity<PersonEntry> getPerson(@PathVariable("personId") String personId,
			@RequestParam(value = "fields", required = false) List<String> fields);

	/**
	 * List people
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2 and newer versions.
	 * List people. You can use the **include** parameter to return any
	 * additional information. The default sort order for the returned list is
	 * for people to be sorted by ascending id. You can override the default by
	 * using the **orderBy** parameter. You can use any of the following fields
	 * to order the results: * id * firstName * lastName
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
	 * @param include
	 *            ("Returns additional information about the person. The
	 *            following optional fields can be requested: * properties *
	 *            aspectNames * capabilities ")
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
	 *         PersonPaging.class),<br/>
	 *         code = 400, message = "Invalid parameter: value of **maxItems**,
	 *         **skipCount** or **orderBy** is invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/people", produces = "application/json", consumes = "", method = RequestMethod.GET)
	ResponseEntity<PersonPaging> listPeople(
			@Min(0) @RequestParam(value = "skipCount", required = false, defaultValue = "0") Integer skipCount,
			@Min(1) @RequestParam(value = "maxItems", required = false, defaultValue = "100") Integer maxItems,
			@RequestParam(value = "orderBy", required = false) List<String> orderBy,
			@RequestParam(value = "include", required = false) List<String> include,
			@RequestParam(value = "fields", required = false) List<String> fields);

	/**
	 * Request password reset
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2.1 and newer
	 * versions. Initiates the reset password workflow to send an email with
	 * reset password instruction to the user's registered email. The client is
	 * mandatory in the request body. For example: ```JSON { \"client\":
	 * \"myClient\" } ``` **Note:** The client must be registered before this
	 * API can send an email. See [server documentation]. However,
	 * out-of-the-box share is registered as a default client, so you could pass
	 * **share** as the client name: ```JSON { \"client\": \"share\" } ```
	 * **Note:** No authentication is required to call this endpoint.
	 * </p>
	 *
	 *
	 * @param personId
	 *            ("The identifier of a person.",required=true)
	 * @param clientBody
	 *            (value = "The client name to send email with app-specific
	 *            url." ,required=true )
	 * @return value = { <br/>
	 *         code = 202, message = "Successful response or even when the
	 *         **personId** does not exist or the user is disabled by an
	 *         Administrator "),<br/>
	 *         code = 404, message = "**client** is not registered ")<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/people/{personId}/request-password-reset", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	ResponseEntity<Void> requestPasswordReset(@PathVariable("personId") String personId,
			@RequestBody ClientBody clientBody);

	/**
	 * Reset password
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2.1 and newer
	 * versions. Resets user's password The password, id and key properties are
	 * mandatory in the request body. For example: ```JSON {
	 * \"password\":\"newPassword\", \"id\":\"activiti$10\",
	 * \"key\":\"4dad6d00-0daf-413a-b200-f64af4e12345\" } ``` **Note:** No
	 * authentication is required to call this endpoint.
	 * </p>
	 *
	 *
	 * @param personId
	 *            ("The identifier of a person.",required=true)
	 * @param passwordResetBody
	 *            (value = "The reset password details" ,required=true )
	 * @return value = { <br/>
	 *         code = 202, message = "Successful response or even when no
	 *         workflow instance is found with the given **id** or the workflow
	 *         instance is invalid (already been used or expired) or the given
	 *         **personId** does not match the person's id requesting the
	 *         password reset or the given workflow **key** does not match the
	 *         recovered key. "),<br/>
	 *         code = 400, message = "Invalid parameter: Value of **password**,
	 *         **id** or **key** is invalid ")<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/people/{personId}/reset-password", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	ResponseEntity<Void> resetPassword(@PathVariable("personId") String personId,
			@RequestBody PasswordResetBody passwordResetBody);

	/**
	 * Update avatar image
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2.2 and newer
	 * versions. Updates the avatar image related to the person **personId**.
	 * The request body should be the binary stream for the avatar image. The
	 * content type of the file should be an image file. This will be used to
	 * generate an \"avatar\" thumbnail rendition. You must be the person or
	 * have admin rights to update a person's avatar. You can use the `-me-`
	 * string in place of `<personId>` to specify the currently authenticated
	 * user.
	 * </p>
	 *
	 *
	 * @param personId
	 *            ("The identifier of a person.",required=true)
	 * @param contentBodyUpdate
	 *            (value = "The binary content" ,required=true )
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response"),<br/>
	 *         code = 400, message = "Invalid parameter: **personId** is not a
	 *         valid format or the avatar cannot be uploaded "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "Current user does not have permission to
	 *         update the avatar image for **personId**"),<br/>
	 *         code = 404, message = "**personId** does not exist "),<br/>
	 *         code = 413, message = "Content exceeds individual file size limit
	 *         (configured for network/system)"),<br/>
	 *         code = 501, message = "Renditions/thumbnails are disabled for the
	 *         system"),<br/>
	 *         code = 507, message = "Content exceeds overall storage quota
	 *         limit configured for the network/system"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/people/{personId}/avatar", produces = "application/json", consumes = "application/octet-stream", method = RequestMethod.PUT)
	ResponseEntity<Void> updateAvatarImage(@PathVariable("personId") String personId,
			@RequestBody byte[] contentBodyUpdate);

	/**
	 * Update person
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2 and newer versions.
	 * Update the given person's details. You can use the `-me-` string in place
	 * of `<personId>` to specify the currently authenticated user. If
	 * applicable, the given person's login access can also be optionally
	 * disabled or re-enabled. You must have admin rights to update a person —
	 * unless updating your own details. If you are changing your password, as a
	 * non-admin user, then the existing password must also be supplied (using
	 * the oldPassword field in addition to the new password value). Admin users
	 * cannot be disabled by setting enabled to false. Non-admin users may not
	 * disable themselves. You can set custom properties when you update a
	 * person: ```JSON { \"firstName\": \"Alice\", \"properties\": {
	 * \"my:property\": \"The value\" } } ``` **Note:** setting properties of
	 * type d:content and d:category are not supported.
	 * </p>
	 *
	 *
	 * @param personId
	 *            ("The identifier of a person.",required=true)
	 * @param personBodyUpdate
	 *            (value = "The person details." ,required=true )
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
	 *         PersonEntry.class),<br/>
	 *         code = 400, message = "Invalid parameter: the update request is
	 *         invalid or **personId** is not a valid format or
	 *         **personBodyUpdate** is invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "Current user does not have permission to
	 *         update a person"),<br/>
	 *         code = 404, message = "**personId** does not exist "),<br/>
	 *         code = 422, message = "Model integrity exception"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/people/{personId}", produces = "application/json", consumes = "application/json", method = RequestMethod.PUT)
	ResponseEntity<PersonEntry> updatePerson(@PathVariable("personId") String personId,
			@RequestBody PersonBodyUpdate personBodyUpdate,
			@RequestParam(value = "fields", required = false) List<String> fields);

}