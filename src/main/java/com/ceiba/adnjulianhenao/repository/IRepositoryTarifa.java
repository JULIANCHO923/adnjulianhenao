package com.ceiba.adnjulianhenao.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.adnjulianhenao.entity.EntityTarifa;

@Repository("repositorioTarifa")
public interface IRepositoryTarifa extends JpaRepository<EntityTarifa, Serializable>{
	
	public abstract EntityTarifa findById(int id);
	
	
		
	
}
