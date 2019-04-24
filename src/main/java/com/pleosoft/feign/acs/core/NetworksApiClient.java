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

import org.springframework.cloud.openfeign.FeignClient;

import com.pleosoft.feign.acs.ACSFeignConfiguration;;

@FeignClient(name = "NetworksApiClient", url = "${acs.feign.url}", path = "api/-default-/public/alfresco/versions/1", configuration = ACSFeignConfiguration.class)
public interface NetworksApiClient extends NetworksApi {
}