package com.exam.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.model.ApiKeyModel;

@Repository
public interface ApiKeyDao extends JpaRepository<ApiKeyModel, UUID> {
	List<ApiKeyModel> findByEndpointAndApiKey(String endpoint, String apiKey);
}
