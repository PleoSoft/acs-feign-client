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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pleosoft.feign.acs.core.model.PreferenceEntry;
import com.pleosoft.feign.acs.core.model.PreferencePaging;

public interface PreferencesApi {

	/**
	 * Get a preference
	 *
	 * <p>
	 * Gets a specific preference for person **personId**. You can use the `-me-`
	 * string in place of `<personId>` to specify the currently authenticated user.
	 * </p>
	 *
	 *
	 * @param personId       ("The identifier of a person.",required=true)
	 * @param preferenceName ("The name of the preference.",required=true)
	 * @param fields         ("A list of field names. You can use this parameter to
	 *                       restrict the fields returned within a response if, for
	 *                       example, you want to save on overall bandwidth. The
	 *                       list applies to a returned individual entity or entries
	 *                       within a collection. If the API method also supports
	 *                       the **include** parameter, then the fields specified in
	 *                       the **include** parameter are returned in addition to
	 *                       those specified in the **fields** parameter. ")
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response", response =
	 *         PreferenceEntry.class),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "Current user does not have access to the
	 *         preferences for **personId**"),<br/>
	 *         code = 404, message = "**personId** or **preferenceName** does not
	 *         exist "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/people/{personId}/preferences/{preferenceName}", produces = "application/json", method = RequestMethod.GET)
	ResponseEntity<PreferenceEntry> getPreference(@PathVariable("personId") String personId,
			@PathVariable("preferenceName") String preferenceName,
			@RequestParam(value = "fields", required = false) List<String> fields);

	/**
	 * List preferences
	 *
	 * <p>
	 * Gets a list of preferences for person **personId**. You can use the `-me-`
	 * string in place of `<personId>` to specify the currently authenticated user.
	 * Note that each preference consists of an **id** and a **value**. The
	 * **value** can be of any JSON type.
	 * </p>
	 *
	 *
	 * @param personId  ("The identifier of a person.",required=true)
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
	 *         PreferencePaging.class),<br/>
	 *         code = 400, message = "Invalid parameter: value of **maxItems** or
	 *         **skipCount** is invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "Current user does not have access to the
	 *         preferences for **personId**"),<br/>
	 *         code = 404, message = "**personId** does not exist "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/people/{personId}/preferences", produces = "application/json", method = RequestMethod.GET)
	ResponseEntity<PreferencePaging> listPreferences(@PathVariable("personId") String personId,
			@Min(0) @RequestParam(value = "skipCount", required = false, defaultValue = "0") Integer skipCount,
			@Min(1) @RequestParam(value = "maxItems", required = false, defaultValue = "100") Integer maxItems,
			@RequestParam(value = "fields", required = false) List<String> fields);

}
