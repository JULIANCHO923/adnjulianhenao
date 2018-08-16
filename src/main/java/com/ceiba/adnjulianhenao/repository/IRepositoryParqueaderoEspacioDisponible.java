package com.ceiba.adnjulianhenao.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ceiba.adnjulianhenao.entity.EntityParqueaderoEspacioDisponible;

@Repository("repositorioParqueaderoEspacioDisponible")
public interface IRepositoryParqueaderoEspacioDisponible extends JpaRepository<EntityParqueaderoEspacioDisponible, Serializable>{
	
	public abstract EntityParqueaderoEspacioDisponible findById(int id);
	public abstract List<EntityParqueaderoEspacioDisponible> findByTipoVehiculoId(int id);
				
}
