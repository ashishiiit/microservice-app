package com.coupan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coupan.model.Coupan;
import com.coupan.repository.CoupanRepository;

@RestController
@RequestMapping("/api/v1/coupan")
public class CoupanController {

	@Autowired
	private CoupanRepository coupanRepository;
	
	@PostMapping(value="/save")
	public ResponseEntity<Coupan> createCoupan(@RequestBody Coupan coupan) {
		return ResponseEntity.ok(coupanRepository.save(coupan)) ;
	}
	
	@GetMapping(value="/fetch/{code}")
	public ResponseEntity<Coupan> getCoupan(@PathVariable("code") String code) {
		System.out.println("server - 1");
		return ResponseEntity.ok(coupanRepository.findByCode(code));
	}
}
