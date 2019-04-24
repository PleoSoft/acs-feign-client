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

import com.pleosoft.feign.acs.core.model.FavoriteBodyCreate;
import com.pleosoft.feign.acs.core.model.FavoriteEntry;
import com.pleosoft.feign.acs.core.model.FavoritePaging;
import com.pleosoft.feign.acs.core.model.FavoriteSiteBodyCreate;
import com.pleosoft.feign.acs.core.model.FavoriteSiteEntry;
import com.pleosoft.feign.acs.core.model.SiteEntry;
import com.pleosoft.feign.acs.core.model.SitePaging;

public interface FavoritesApi {

	/**
	 * Create a favorite
	 *
	 * <p>
	 * Favorite a **site**, **file**, or **folder** in the repository. You can
	 * use the `-me-` string in place of `<personId>` to specify the currently
	 * authenticated user. **Note:** You can favorite more than one entity by
	 * specifying a list of objects in the JSON body like this: ```JSON [ {
	 * \"target\": { \"file\": { \"guid\": \"abcde-01234-....\" } } }, {
	 * \"target\": { \"file\": { \"guid\": \"abcde-09863-....\" } } }, ] ``` If
	 * you specify a list as input, then a paginated list rather than an entry
	 * is returned in the response body. For example: ```JSON { \"list\": {
	 * \"pagination\": { \"count\": 2, \"hasMoreItems\": false, \"totalItems\":
	 * 2, \"skipCount\": 0, \"maxItems\": 100 }, \"entries\": [ { \"entry\": {
	 * ... } }, { \"entry\": { ... } } ] } } ```
	 * </p>
	 *
	 *
	 * @param personId
	 *            ("The identifier of a person.",required=true)
	 * @param favoriteBodyCreate
	 *            (value = "An object identifying the entity to be favorited.
	 *            The object consists of a single property which is an object
	 *            with the name `site`, `file`, or `folder`. The content of that
	 *            object is the `guid` of the target entity. For example, to
	 *            favorite a file the following body would be used: ```JSON {
	 *            \"target\": { \"file\": { \"guid\": \"abcde-01234-....\" } } }
	 *            ``` " ,required=true )
	 * @param include
	 *            ("Returns additional information about favorites, the
	 *            following optional fields can be requested: * path (note, this
	 *            only applies to files and folders) ")
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
	 *         FavoriteEntry.class),<br/>
	 *         code = 400, message = "Invalid parameter: **favoriteBodyCreate**
	 *         invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 404, message = "**personId** does not exist, or the target
	 *         entity does not exist, or a favorite already exists with the
	 *         specified id, or an entity exists with the id of the posted
	 *         object but is not of the same type of the posted object "),<br/>
	 *         code = 409, message = "The target **guid** has already been
	 *         favorited"),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/people/{personId}/favorites", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	ResponseEntity<FavoriteEntry> createFavorite(@PathVariable("personId") String personId,
			@RequestBody FavoriteBodyCreate favoriteBodyCreate,
			@RequestParam(value = "include", required = false) List<String> include,
			@RequestParam(value = "fields", required = false) List<String> fields);

	/**
	 * Create a site favorite
	 *
	 * <p>
	 * **Note:** this endpoint is deprecated as of Alfresco 4.2, and will be
	 * removed in the future. Use `/people/{personId}/favorites` instead. Create
	 * a site favorite for person **personId**. You can use the `-me-` string in
	 * place of `<personId>` to specify the currently authenticated user.
	 * **Note:** You can favorite more than one site by specifying a list of
	 * sites in the JSON body like this: ```JSON [ { \"id\": \"test-site-1\" },
	 * { \"id\": \"test-site-2\" } ] ``` If you specify a list as input, then a
	 * paginated list rather than an entry is returned in the response body. For
	 * example: ```JSON { \"list\": { \"pagination\": { \"count\": 2,
	 * \"hasMoreItems\": false, \"totalItems\": 2, \"skipCount\": 0,
	 * \"maxItems\": 100 }, \"entries\": [ { \"entry\": { ... } }, { \"entry\":
	 * { ... } } ] } } ```
	 * </p>
	 *
	 *
	 * @param personId
	 *            ("The identifier of a person.",required=true)
	 * @param favoriteSiteBodyCreate
	 *            (value = "The id of the site to favorite." ,required=true )
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
	 *         FavoriteSiteEntry.class),<br/>
	 *         code = 400, message = "Invalid parameter:
	 *         **favoriteSiteBodyCreate** is invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "Current user does not have access to the
	 *         favorite sites for **personId**"),<br/>
	 *         code = 404, message = "**personId** does not exist "),<br/>
	 *         code = 409, message = "**id** is already a site favorite "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/people/{personId}/favorite-sites", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	ResponseEntity<FavoriteSiteEntry> createSiteFavorite(@PathVariable("personId") String personId,
			@RequestBody FavoriteSiteBodyCreate favoriteSiteBodyCreate,
			@RequestParam(value = "fields", required = false) List<String> fields);

	/**
	 * Delete a favorite
	 *
	 * <p>
	 * Deletes **favoriteId** as a favorite of person **personId**. You can use
	 * the `-me-` string in place of `<personId>` to specify the currently
	 * authenticated user.
	 * </p>
	 *
	 *
	 * @param personId
	 *            ("The identifier of a person.",required=true)
	 * @param favoriteId
	 *            ("The identifier of a favorite.",required=true)
	 * @return value = { <br/>
	 *         code = 204, message = "Successful response"),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 404, message = "**personId** or **favoriteId** does not
	 *         exist "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/people/{personId}/favorites/{favoriteId}", produces = "application/json", consumes = "", method = RequestMethod.DELETE)
	ResponseEntity<Void> deleteFavorite(@PathVariable("personId") String personId,
			@PathVariable("favoriteId") String favoriteId);

	/**
	 * Delete a site favorite
	 *
	 * <p>
	 * **Note:** this endpoint is deprecated as of Alfresco 4.2, and will be
	 * removed in the future. Use `/people/{personId}/favorites/{favoriteId}`
	 * instead. Deletes site **siteId** from the favorite site list of person
	 * **personId**. You can use the `-me-` string in place of `<personId>` to
	 * specify the currently authenticated user.
	 * </p>
	 *
	 *
	 * @param personId
	 *            ("The identifier of a person.",required=true)
	 * @param siteId
	 *            ("The identifier of a site.",required=true)
	 * @return value = { <br/>
	 *         code = 204, message = "Successful response"),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "Current user does not have access to the
	 *         favorite sites for **personId**"),<br/>
	 *         code = 404, message = "**personId** or **siteId** does not exist
	 *         "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/people/{personId}/favorite-sites/{siteId}", produces = "application/json", consumes = "", method = RequestMethod.DELETE)
	ResponseEntity<Void> deleteSiteFavorite(@PathVariable("personId") String personId,
			@PathVariable("siteId") String siteId);

	/**
	 * Get a favorite
	 *
	 * <p>
	 * Gets favorite **favoriteId** for person **personId**. You can use the
	 * `-me-` string in place of `<personId>` to specify the currently
	 * authenticated user.
	 * </p>
	 *
	 *
	 * @param personId
	 *            ("The identifier of a person.",required=true)
	 * @param favoriteId
	 *            ("The identifier of a favorite.",required=true)
	 * @param include
	 *            ("Returns additional information about favorites, the
	 *            following optional fields can be requested: * path (note, this
	 *            only applies to files and folders) ")
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
	 *         FavoriteEntry.class),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 404, message = "**personId** or **favoriteId** does not
	 *         exist "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/people/{personId}/favorites/{favoriteId}", produces = "application/json", consumes = "", method = RequestMethod.GET)
	ResponseEntity<FavoriteEntry> getFavorite(@PathVariable("personId") String personId,
			@PathVariable("favoriteId") String favoriteId,
			@RequestParam(value = "include", required = false) List<String> include,
			@RequestParam(value = "fields", required = false) List<String> fields);

	/**
	 * Get a favorite site
	 *
	 * <p>
	 * **Note:** this endpoint is deprecated as of Alfresco 4.2, and will be
	 * removed in the future. Use `/people/{personId}/favorites/{favoriteId}`
	 * instead. Gets information on favorite site **siteId** of person
	 * **personId**. You can use the `-me-` string in place of `<personId>` to
	 * specify the currently authenticated user.
	 * </p>
	 *
	 *
	 * @param personId
	 *            ("The identifier of a person.",required=true)
	 * @param siteId
	 *            ("The identifier of a site.",required=true)
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
	 *         SiteEntry.class),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "Current user does not have access to the
	 *         favorite sites for **personId**"),<br/>
	 *         code = 404, message = "**personId** or **siteId** does not exist
	 *         "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/people/{personId}/favorite-sites/{siteId}", produces = "application/json", consumes = "", method = RequestMethod.GET)
	ResponseEntity<SiteEntry> getFavoriteSite(@PathVariable("personId") String personId,
			@PathVariable("siteId") String siteId,
			@RequestParam(value = "fields", required = false) List<String> fields);

	/**
	 * List favorite sites
	 *
	 * <p>
	 * **Note:** this endpoint is deprecated as of Alfresco 4.2, and will be
	 * removed in the future. Use `/people/{personId}/favorites` instead. Gets a
	 * list of a person's favorite sites. You can use the `-me-` string in place
	 * of `<personId>` to specify the currently authenticated user.
	 * </p>
	 *
	 *
	 * @param personId
	 *            ("The identifier of a person.",required=true)
	 * @param skipCount
	 *            ("The number of entities that exist in the collection before
	 *            those included in this list. If not supplied then the default
	 *            value is 0. ", defaultValue = "0")
	 * @param maxItems
	 *            ("The maximum number of items to return in the list. If not
	 *            supplied then the default value is 100. ", defaultValue =
	 *            "100")
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
	 *         SitePaging.class),<br/>
	 *         code = 400, message = "Invalid parameter: value of **maxItems**
	 *         or **skipCount** is invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 403, message = "Current user does not have access to the
	 *         favorite sites for **personId**"),<br/>
	 *         code = 404, message = "**personId** does not exist "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/people/{personId}/favorite-sites", produces = "application/json", consumes = "", method = RequestMethod.GET)
	ResponseEntity<SitePaging> listFavoriteSitesForPerson(@PathVariable("personId") String personId,
			@Min(0) @RequestParam(value = "skipCount", required = false, defaultValue = "0") Integer skipCount,
			@Min(1) @RequestParam(value = "maxItems", required = false, defaultValue = "100") Integer maxItems,
			@RequestParam(value = "fields", required = false) List<String> fields);

	/**
	 * List favorites
	 *
	 * <p>
	 * Gets a list of favorites for person **personId**. You can use the `-me-`
	 * string in place of `<personId>` to specify the currently authenticated
	 * user. You can use the **where** parameter to restrict the list in the
	 * response to entries of a specific kind. The **where** parameter takes a
	 * value. The value is a single predicate that can include one or more
	 * **EXISTS** conditions. The **EXISTS** condition uses a single operand to
	 * limit the list to include entries that include that one property. The
	 * property values are: * `target/file` * `target/folder` * `target/site`
	 * For example, the following **where** parameter restricts the returned
	 * list to the file favorites for a person: ```SQL (EXISTS(target/file)) ```
	 * You can specify more than one condition using **OR**. The predicate must
	 * be enclosed in parentheses. For example, the following **where**
	 * parameter restricts the returned list to the file and folder favorites
	 * for a person: ```SQL (EXISTS(target/file) OR EXISTS(target/folder)) ```
	 * </p>
	 *
	 *
	 * @param personId
	 *            ("The identifier of a person.",required=true)
	 * @param skipCount
	 *            ("The number of entities that exist in the collection before
	 *            those included in this list. If not supplied then the default
	 *            value is 0. ", defaultValue = "0")
	 * @param maxItems
	 *            ("The maximum number of items to return in the list. If not
	 *            supplied then the default value is 100. ", defaultValue =
	 *            "100")
	 * @param where
	 *            ("A string to restrict the returned objects by using a
	 *            predicate.")
	 * @param include
	 *            ("Returns additional information about favorites, the
	 *            following optional fields can be requested: * path (note, this
	 *            only applies to files and folders) ")
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
	 *         FavoritePaging.class),<br/>
	 *         code = 400, message = "Invalid parameter: value of **maxItems**,
	 *         **skipCount**, or **where** is invalid "),<br/>
	 *         code = 401, message = "Authentication failed"),<br/>
	 *         code = 404, message = "**personId** does not exist or the current
	 *         user does not have permission to access the favorites of
	 *         **personId** "),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/people/{personId}/favorites", produces = "application/json", consumes = "", method = RequestMethod.GET)
	ResponseEntity<FavoritePaging> listFavorites(@PathVariable("personId") String personId,
			@Min(0) @RequestParam(value = "skipCount", required = false, defaultValue = "0") Integer skipCount,
			@Min(1) @RequestParam(value = "maxItems", required = false, defaultValue = "100") Integer maxItems,
			@RequestParam(value = "where", required = false) String where,
			@RequestParam(value = "include", required = false) List<String> include,
			@RequestParam(value = "fields", required = false) List<String> fields);

}
