package com.example.vendasproducer.infraestrutura;

import com.example.vendasproducer.controller.dto.Synchronism;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class GsonAdapter {

	
	private Gson gson;

	public GsonAdapter() {
		this.gson = new Gson();
	}
	
	public String toJson(Synchronism src) {
		return this.gson.toJson(src);
	}
	
}
