package com.example.demo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LoggerRepository extends CrudRepository<Logger,String>{
	List<Logger> findByDate(LocalDate date);
}
