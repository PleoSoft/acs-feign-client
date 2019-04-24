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

package com.pleosoft.feign.acs.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pleosoft.feign.acs.auth.model.TicketBody;
import com.pleosoft.feign.acs.auth.model.TicketEntry;
import com.pleosoft.feign.acs.auth.model.ValidTicketEntry;

public interface AuthenticationApi {

	/**
	 * Create ticket (login)
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2 and newer versions.
	 * Logs in and returns the new authentication ticket. The userId and
	 * password properties are mandatory in the request body. For example:
	 * ```JSON { \"userId\": \"jbloggs\", \"password\": \"password\" } ``` To
	 * use the ticket in future requests you should pass it in the request
	 * header. For example using Javascript: ```Javascript
	 * request.setRequestHeader (\"Authorization\", \"Basic \" + btoa(ticket));
	 * ```
	 * </p>
	 *
	 *
	 * @param ticketBodyCreate
	 *            (value = "The user credential." ,required=true )
	 * @return value = { <br/>
	 *         code = 201, message = "Successful response", response =
	 *         TicketEntry.class),<br/>
	 *         code = 400, message = "**userId** or **password** is not provided
	 *         "),<br/>
	 *         code = 403, message = "Login failed"),<br/>
	 *         code = 501, message = "SAML is enabled and enforced"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/tickets", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	ResponseEntity<TicketEntry> createTicket(@RequestBody TicketBody ticketBodyCreate);

	/**
	 * Delete ticket (logout)
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2 and newer versions.
	 * Deletes logged in ticket (logout).
	 * </p>
	 *
	 *
	 * @return value = { <br/>
	 *         code = 204, message = "Successful response"),<br/>
	 *         code = 400, message = "URL path does not include **-me-** or the
	 *         ticket is not provided by the Authorization header"),<br/>
	 *         code = 404, message = "Status of the user has changed (for
	 *         example, the user is locked or the account is disabled) or the
	 *         ticket has expired"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/tickets/-me-", produces = "application/json", consumes = "", method = RequestMethod.DELETE)
	ResponseEntity<Void> deleteTicket();

	/**
	 * Validate ticket
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2 and newer versions.
	 * Validates the specified ticket (derived from Authorization header) is
	 * still valid. For example, you can pass the Authorization request header
	 * using Javascript: ```Javascript request.setRequestHeader
	 * (\"Authorization\", \"Basic \" + btoa(ticket)); ```
	 * </p>
	 *
	 *
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response", response =
	 *         ValidTicketEntry.class),<br/>
	 *         code = 400, message = "URL path does not include **-me-** or the
	 *         ticket is not provided by the Authorization header"),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 404, message = "The request is authorized correctly but
	 *         the status of the user (of the supplied ticket) has changed (for
	 *         example, the user is locked or the account is disabled) or the
	 *         ticket has expired"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/tickets/-me-", produces = "application/json", consumes = "", method = RequestMethod.GET)
	ResponseEntity<ValidTicketEntry> validateTicket();

}
