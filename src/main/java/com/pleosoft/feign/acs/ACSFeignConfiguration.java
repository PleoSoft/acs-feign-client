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

import java.util.ArrayList;
import java.util.Collections;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import feign.RequestInterceptor;
import feign.Retryer;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.codec.ErrorDecoder;
import feign.form.spring.converter.SpringManyMultipartFilesReader;

public class ACSFeignConfiguration {

	@Autowired
	private ACSConfigurationProperties properties;

	@Bean
	public Retryer retryer() {
		return new Retryer.Default();
	}

	@Bean
	public ErrorDecoder errorDecoder() {
		return new ErrorDecoder.Default();
	}

	@Bean
	public Decoder feignDecoder() {
		return new ResponseEntityDecoder(new SpringDecoder(new ObjectFactory<HttpMessageConverters>() {

			@Override
			public HttpMessageConverters getObject() throws BeansException {
				return httpMessageConverters();
			}
		}));
	}

	@Bean
	public Encoder feignEncoder() {
		return new SpringEncoder(new ObjectFactory<HttpMessageConverters>() {

			@Override
			public HttpMessageConverters getObject() throws BeansException {
				return httpMessageConverters();
			}
		});
	}

	@Bean
	public HttpMessageConverters httpMessageConverters() {
		final HttpMessageConverter<?> jacksonConverter = new MappingJackson2HttpMessageConverter(objectMapper());
		SpringManyMultipartFilesReader springManyMultipartFilesReader = new SpringManyMultipartFilesReader(4096);

		ArrayList<MediaType> arrayList2 = new ArrayList<>();
		arrayList2.add(MediaType.MULTIPART_FORM_DATA);

		arrayList2.add(new MediaType("application", "dita+xml", Collections.singletonMap("charset", "UTF-8")));
		springManyMultipartFilesReader.setSupportedMediaTypes(arrayList2);

		ArrayList<HttpMessageConverter<?>> arrayList = new ArrayList<>();
		arrayList.add(jacksonConverter);
		arrayList.add(springManyMultipartFilesReader);
		return new HttpMessageConverters(arrayList);
	}

	@Bean
	public ObjectMapper objectMapper() {
		final ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		final SimpleModule module = new SimpleModule();
		objectMapper.registerModule(module);
		return objectMapper;
	}

	@Bean
	public RequestInterceptor headerAuthRequestInterceptor() {
		return new AuthorizationRequestInterceptor(properties.getAuthorizationHeaderName(),
				properties.getDefaultAuthorization());
	}
}
