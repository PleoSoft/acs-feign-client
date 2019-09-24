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

package com.pleosoft.feign.acs.searchsql;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pleosoft.feign.acs.searchsql.model.SQLResultSetPaging;
import com.pleosoft.feign.acs.searchsql.model.SQLSearchRequest;

public interface SqlApi {

	/**
	 * Alfresco Insight Engine SQL Passthrough
	 *
	 * <p>
	 * **Note**: this endpoint is available in Alfresco 6.0 and newer versions. This
	 * will require Insight Engine and will not work with Alfresco Search Services.
	 * **You specify all the parameters in this API in a JSON body**, A basic query
	 * looks like this: ```JSON { \"stmt\": \"select * from alfresco\", \"locales\":
	 * [\"en_UK\"] \"timezone\": \"Europe/London\" \"includeMetadata\":true } ```
	 * **Note:** the minimum possible query parameter required. ```JSON { \"stmt\":
	 * } ``` The expected reponse will appear in the Alfresco format as seen below.
	 * ```JSON { \"list\": { \"pagination\": { \"count\": 1, \"hasMoreItems\":
	 * false, \"totalItems\": 1, \"skipCount\": 0, \"maxItems\": 100 }, \"entries\":
	 * [{ \"entry\": [ { \"label\": \"aliases\", \"value\":
	 * \"{\\\"SITE\\\":\\\"site\\\"}\" }, { \"label\": \"isMetadata\", \"value\":
	 * \"true\" }, { \"label\": \"fields\", \"value\": \"[\\\"SITE\\\"]\" } ] }]}}
	 * ``` To override the default format set the format to solr. ```JSON {
	 * \"stmt\": \"select * from alfresco\", \"format\": \"solr\" } ``` This will
	 * return Solr's output response. ```JSON { \"result-set\": { \"docs\": [ {
	 * \"aliases\": { \"SITE\": \"site\" }, \"isMetadata\": true, \"fields\": [
	 * \"SITE\"] }, { \"RESPONSE_TIME\": 23, \"EOF\": true } ]} } ``` You can use
	 * the **locales parameter** to filter results based on locale. ```JSON
	 * \"locales\": [\"en_UK\", \"en_US\"] ``` To include timezone in the query add
	 * the **timezone parameter**. ```JSON \"timezone\": \"Japan\" ``` You can use
	 * the **includeMetadata parameter** to include addtional information, this is
	 * by default set to false. ```JSON \"includeMetadata\": \"false\" ``` Please
	 * note that if its set to true the first entry will represent the metdata
	 * requested ```JSON { \"stmt\": \"select site from alfresco limit 2\",
	 * \"includeMetadata\":true } ``` The expected response: ```JSON \"entries\": [
	 * { #First entry holds the Metadata infromation as set by
	 * {includeMetadata:true} \"entry\": [ { \"label\": \"aliases\", \"value\":
	 * \"{\\\"SITE\\\":\\\"site\\\"}\" }, { \"label\": \"isMetadata\", \"value\":
	 * \"true\" }, { \"label\": \"fields\", \"value\": \"[\\\"SITE\\\"]\" } ] #end
	 * of Metadata }, { #Query result entry value. \"entry\": [ { \"label\":
	 * \"site\", \"value\": \"[\\\"test\\\"]\" } ] }, { \"entry\": [ { \"label\":
	 * \"site\", \"value\": \"[\\\"test\\\"]\" } ] } ] ```
	 * </p>
	 *
	 *
	 * @param queryBody (value = "Generic query API " ,required=true )
	 * @return value = { <br/>
	 *         code = 200, message = "Successful response", response =
	 *         SQLResultSetPaging.class),<br/>
	 *         code = 200, message = "Unexpected error", response =
	 *         Error.class)<br/>
	 *         }
	 *
	 */
	@RequestMapping(value = "/sql", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	ResponseEntity<SQLResultSetPaging> search(@RequestBody SQLSearchRequest queryBody);

}
