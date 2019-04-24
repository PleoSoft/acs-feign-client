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

package com.pleosoft.feign.acs;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.util.Assert;

@ConfigurationProperties("acs.feign")
public class ACSConfigurationProperties implements InitializingBean {

	private String defaultAuthorization;
	private String authorizationHeaderName = "Authorization";
	private String url;

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(url, "url must not be null");

		Assert.isTrue(defaultAuthorization != null || authorizationHeaderName != null,
				"either defaultAuthorization or authorizationHeaderValue must not be used");
	}

	public String getDefaultAuthorization() {
		return defaultAuthorization;
	}

	public void setDefaultAuthorization(String defaultAuthorization) {
		this.defaultAuthorization = defaultAuthorization;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAuthorizationHeaderName() {
		return authorizationHeaderName;
	}

	public void setAuthorizationHeaderName(String authorizationHeaderName) {
		this.authorizationHeaderName = authorizationHeaderName;
	}
}
