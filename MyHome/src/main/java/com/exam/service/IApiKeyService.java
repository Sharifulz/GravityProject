package com.exam.service;

import java.util.Map;

public interface IApiKeyService {

	public Map<String, Object> getByEndpointAndApiKey(String endpoint, String apiKey);
	
}
