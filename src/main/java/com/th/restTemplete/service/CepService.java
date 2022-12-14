package com.th.restTemplete.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.th.restTemplete.model.Cep;

@Service
public class CepService {
	@Autowired
	private RestTemplate restTemplateCep;

	public Optional<Cep> findByCep(Integer cepNumber){
		var response = restTemplateCep.exchange("/"+cepNumber+"/json"
				       ,HttpMethod.GET, null, new ParameterizedTypeReference<Optional<Cep>>(){});
		return response.getBody();
	}

	public List<Cep> findByAdress(String uf, String state, String place) {
		var response = restTemplateCep.exchange("/"+uf+"/"+state+"/"+place+"/json"
					   ,HttpMethod.GET, null, new ParameterizedTypeReference<List<Cep>>(){});
		return response.getBody();
	}
}
