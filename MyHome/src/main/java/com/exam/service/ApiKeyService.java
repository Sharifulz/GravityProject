package com.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dao.ApiKeyDao;
import com.exam.model.ApiKeyModel;

@Service
public class ApiKeyService implements IApiKeyService {

	@Autowired
	ApiKeyDao  apiKeyDao;
	
	@Override
	public boolean getByEndpointAndApiKey(String endpoint, String apiKey) {

		List<ApiKeyModel> apiKeyRecords = apiKeyDao.findByEndpointAndApiKey(endpoint, apiKey);
		
		if (apiKeyRecords.size()>0) {
			apiKeyRecords.get(0).getExpireDate();
			return true;
		}else {
			return false;
		}
		
	}

}
