package com.exam.service;

public interface IApiKeyService {

	public boolean getByEndpointAndApiKey(String endpoint, String apiKey);
	
}
