package com.ceiba.adnjulianhenao.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.adnjulianhenao.entity.EntityTipoVehiculo;

@Repository("repositorioTipoVehiculo")
public interface IRepositoryTipoVehiculo extends JpaRepository<EntityTipoVehiculo, Serializable>{
	
	public abstract EntityTipoVehiculo findById(int idTipoVehiculo);		
		
	
}
