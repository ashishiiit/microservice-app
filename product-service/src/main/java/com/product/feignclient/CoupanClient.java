package com.product.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.product.dto.Coupan;
//when eureka is not there then we have to pass url @FeignClient.
@FeignClient("COUPAN-SERVICE")
public interface CoupanClient {
	@GetMapping("/api/v1/getCoupan/{code}")
	Coupan findByCode(@PathVariable("code") String code);
}
