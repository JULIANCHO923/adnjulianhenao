package com.ceiba.adnjulianhenao.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.adnjulianhenao.entity.EntityParqueaderoTarifa;

@Repository("repositorioParqueaderoTarifa")
public interface IRepositoryParqueaderoTarifa extends JpaRepository<EntityParqueaderoTarifa, Serializable> {

	public abstract EntityParqueaderoTarifa findById(int id);
	public abstract List<EntityParqueaderoTarifa> findByTipoVehiculoId(int id);

}
