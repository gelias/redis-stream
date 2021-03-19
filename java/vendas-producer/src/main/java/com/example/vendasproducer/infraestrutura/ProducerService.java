package com.example.vendasproducer.infraestrutura;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

import com.example.vendasproducer.controller.dto.Synchronism;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.stream.ObjectRecord;
import org.springframework.data.redis.connection.stream.StreamRecords;
import org.springframework.data.redis.connection.stream.StringRecord;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.example.vendasproducer.controller.dto.ProdutoDTO;
import com.example.vendasproducer.domain.Produto;

import reactor.core.Disposable;

@Component
public class ProducerService {

	private Logger logger = LoggerFactory.getLogger(ProducerService.class);
	
    private final AtomicInteger atomicInteger = new AtomicInteger(0);
    
    @Value("${stream.key}")
    private String streamKey;
    
    @Autowired
    private ReactiveRedisTemplate<String, String> redisTemplate;
	
	@Autowired
	private GsonAdapter gsonAdapter;

	@Async
	public void publicarEventos(Synchronism dto) {

			try {
                long timeMillis = System.currentTimeMillis();
                String produto = gsonAdapter.toJson(dto);
				
				Map<String, String> fields = new HashMap<String, String>();
	            fields.put("sync_at_"+timeMillis, produto);
	            
				 StringRecord stringRecord = StreamRecords
						.newRecord()
						.ofStrings(fields)
						.withStreamKey(streamKey);
				 
				this.redisTemplate
						.opsForStream()
						.add(stringRecord)
						.subscribe(System.out::println);
				
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("Something get wrong adding into stream");
			}

	}
}
