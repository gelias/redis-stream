package com.example.vendasproducer.controller;

import com.example.vendasproducer.controller.dto.ApiResult;
import com.example.vendasproducer.controller.dto.Synchronism;
import com.example.vendasproducer.domain.ProdutosRepository;
import com.example.vendasproducer.infraestrutura.ProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = { "/sync"})
public class ProdutoController {

	private Logger logger = LoggerFactory.getLogger(ProdutoController.class);
	
	@Autowired
	private ProducerService producer;

	@GetMapping(value = "/", produces = "application/json")
	public ApiResult sync() {
		return new ApiResult(OK.value(), "OK");
	}

	@PostMapping(value = "/", produces = "application/json")
	public ApiResult sync(@RequestBody Synchronism dto) {
		logger.info("Receiving synchronism dto");
		producer.publicarEventos(dto.refreshValues());
		return new ApiResult(OK.value(), "OK");
	}
}
