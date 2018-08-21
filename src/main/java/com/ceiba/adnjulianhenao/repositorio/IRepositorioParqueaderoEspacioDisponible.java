package com.ceiba.adnjulianhenao.repositorio;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.adnjulianhenao.entidad.EntidadParqueaderoEspacioDisponible;



@Repository("repositorioParqueaderoEspacioDisponible")
public interface IRepositorioParqueaderoEspacioDisponible extends JpaRepository<EntidadParqueaderoEspacioDisponible, Serializable>{
	
	public abstract EntidadParqueaderoEspacioDisponible findById(int id);
	public abstract EntidadParqueaderoEspacioDisponible findByTipoVehiculoId(int id);
				
}
