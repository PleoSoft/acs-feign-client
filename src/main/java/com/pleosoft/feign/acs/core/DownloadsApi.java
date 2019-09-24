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

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pleosoft.feign.acs.core.model.DownloadBodyCreate;
import com.pleosoft.feign.acs.core.model.DownloadEntry;

public interface DownloadsApi {

	/**
	 * Cancel a download
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2.1 and newer versions.
	 * Cancels the creation of a download request. **Note:** The download node can
	 * be deleted using the **DELETE /nodes/{downloadId}** endpoint By default, if
	 * the download node is not deleted it will be picked up by a cleaner job which
	 * removes download nodes older than a configurable amount of time (default is 1
	 * hour) Information about the existing progress at the time of cancelling can
	 * be retrieved by calling the **GET /downloads/{downloadId}** endpoint The
	 * cancel operation is done asynchronously.
	 * </p>
	 *
	 *
	 * @param downloadId ("The identifier of a download node.",required=true)
	 * @return value = { <br/>
	 *         code = 202, message = "The request to cancel a download was
	 *         accepted"),<br/>
	 *         code = 400, message = "Invalid parameter: **downloadId** is invalid,
	 *         or **downloadId** does not point to a node of download type "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "Current user does not have permission cancel
	 *         the **downloadId** node"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/downloads/{downloadId}", produces = "application/json", method = RequestMethod.DELETE)
	ResponseEntity<Void> cancelDownload(@PathVariable("downloadId") String downloadId);

	/**
	 * Create a new download
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2.1 and newer versions.
	 * Creates a new download node asynchronously, the content of which will be the
	 * zipped content of the **nodeIds** specified in the JSON body like this:
	 * ```JSON { \"nodeIds\": [ \"c8bb482a-ff3c-4704-a3a3-de1c83ccd84c\",
	 * \"cffa62db-aa01-493d-9594-058bc058eeb1\" ] } ``` **Note:** The content of the
	 * download node can be obtained using the **GET /nodes/{downloadId}/content**
	 * endpoint
	 * </p>
	 *
	 *
	 * @param downloadBodyCreate (value = "The nodeIds the content of which will be
	 *                           zipped, which zip will be set as the content of our
	 *                           download node." ,required=true )
	 * @param fields             ("A list of field names. You can use this parameter
	 *                           to restrict the fields returned within a response
	 *                           if, for example, you want to save on overall
	 *                           bandwidth. The list applies to a returned
	 *                           individual entity or entries within a collection.
	 *                           If the API method also supports the **include**
	 *                           parameter, then the fields specified in the
	 *                           **include** parameter are returned in addition to
	 *                           those specified in the **fields** parameter. ")
	 * @return value = { <br/>
	 *         code = 202, message = "The request to create a download node was
	 *         accepted", response = DownloadEntry.class),<br/>
	 *         code = 400, message = "Invalid parameter: **DownloadBodyCreate** is
	 *         invalid due to incorrect syntax, or **nodeIds** is empty, or
	 *         **nodeIds** contains a duplicate **nodeId** "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "Current user does not have permission to add a
	 *         certain **nodeId** to the zip"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/downloads", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	ResponseEntity<DownloadEntry> createDownload(@RequestBody DownloadBodyCreate downloadBodyCreate,
			@RequestParam(value = "fields", required = false) List<String> fields);

	/**
	 * Get a download
	 *
	 * <p>
	 * **Note:** this endpoint is available in Alfresco 5.2.1 and newer versions.
	 * Retrieve status information for download node **downloadId**
	 * </p>
	 *
	 *
	 * @param downloadId ("The identifier of a download node.",required=true)
	 * @param fields     ("A list of field names. You can use this parameter to
	 *                   restrict the fields returned within a response if, for
	 *                   example, you want to save on overall bandwidth. The list
	 *                   applies to a returned individual entity or entries within a
	 *                   collection. If the API method also supports the **include**
	 *                   parameter, then the fields specified in the **include**
	 *                   parameter are returned in addition to those specified in
	 *                   the **fields** parameter. ")
	 * @return value = { <br/>
	 *         code = 200, message = "Download node information", response =
	 *         DownloadEntry.class),<br/>
	 *         code = 400, message = "Invalid parameter: **downloadId** is invalid,
	 *         or **downloadId** does not point to a node of download type "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "Current user does not have permission to get
	 *         information about **downloadId** node"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/downloads/{downloadId}", produces = "application/json", method = RequestMethod.GET)
	ResponseEntity<DownloadEntry> getDownload(@PathVariable("downloadId") String downloadId,
			@RequestParam(value = "fields", required = false) List<String> fields);

}
