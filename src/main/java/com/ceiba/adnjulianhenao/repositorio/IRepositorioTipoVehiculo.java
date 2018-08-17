package com.ceiba.adnjulianhenao.repositorio;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.adnjulianhenao.entidad.EntidadTipoVehiculo;


@Repository("repositorioTipoVehiculo")
public interface IRepositorioTipoVehiculo extends JpaRepository<EntidadTipoVehiculo, Serializable>{
	
	public abstract EntidadTipoVehiculo findById(int id);
	public abstract EntidadTipoVehiculo findByDescripcion(String descripcion);
	
}
