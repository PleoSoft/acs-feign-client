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

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class AuthorizationRequestInterceptor implements RequestInterceptor {

	private final String authorizationHeader;
	private final String defaultToken;

	public AuthorizationRequestInterceptor(String authorizationHeader, String defaultToken) {
		this.authorizationHeader = authorizationHeader;
		this.defaultToken = defaultToken;
	}

	@Override
	public void apply(final RequestTemplate template) {

		final ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		if (requestAttributes == null) {
			template.header("Authorization", defaultToken);
			return;
		}

		final HttpServletRequest request = requestAttributes.getRequest();
		if (request == null) {
			template.header("Authorization", defaultToken);
			return;
		}

		final String header = request.getHeader(this.authorizationHeader);
		if (!StringUtils.hasText(header)) {
			template.header("Authorization", defaultToken);
			return;
		}

		template.header("Authorization", header);
	}
}
