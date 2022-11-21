package com.th.restTemplete.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.th.restTemplete.model.Cep;
import com.th.restTemplete.service.CepService;

@RestController
@RequestMapping("/cep")
public class CepController {
	
	@Autowired
	private CepService cepService;
	
	@GetMapping("/{cepNumber}")
	public ResponseEntity<Cep> findCep(@PathVariable Integer cepNumber){
		return cepService.findCep(cepNumber)
				.map(cep -> new ResponseEntity<Cep>(cep, HttpStatus.OK))
				.orElse(ResponseEntity.notFound().build());
	}
	
}
