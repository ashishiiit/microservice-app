package com.coupan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coupan.model.Coupan;

public interface CoupanRepository extends JpaRepository<Coupan, Long> {

	Coupan findByCode(String code);

}
