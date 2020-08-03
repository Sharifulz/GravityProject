package com.exam.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dao.ApiKeyDao;
import com.exam.model.ApiKeyModel;

@Service
public class ApiKeyService implements IApiKeyService {

	@Autowired
	ApiKeyDao  apiKeyDao;
	
	@Override
	public Map<String, Object> getByEndpointAndApiKey(String endpoint, String apiKey) {

		Map<String, Object> map = new HashMap<>();
		List<String> message = new ArrayList<>();
		
		List<ApiKeyModel> apiKeyRecords = apiKeyDao.findByEndpointAndApiKey(endpoint, apiKey);
		
		if (apiKeyRecords.size()>0) {
			Date expDate = apiKeyRecords.get(0).getExpireDate();
			
			Date currentDate = new Date(System.currentTimeMillis());
			//---------- task : if exp date is today allow api request
			if (expDate.after(currentDate)) {
				map.put("result", true);
				message.add("Api key is not expired");
				map.put("message", message);
			}else {
				map.put("result", false);
				message.add("Api key is expired");
				map.put("message", message);
			}
			
		}else {
			map.put("result", false);
			message.add("Api key is not valid");
			map.put("message", message);
		}
		return map;
		
	}

}
