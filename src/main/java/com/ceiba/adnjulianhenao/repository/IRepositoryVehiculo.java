package com.ceiba.adnjulianhenao.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ceiba.adnjulianhenao.entity.EntityVehiculo;

/**
 * Se encarga de las peticiones en la base de datos
 * @author julian.henao
 *
 */
@Repository("repositorioVehiculo")
public interface IRepositoryVehiculo extends JpaRepository<EntityVehiculo, Serializable>, PagingAndSortingRepository<EntityVehiculo, Serializable>{ 
	
	public abstract EntityVehiculo findById(int idVehiculo);	
	public abstract List<EntityVehiculo> findByPlaca(String placa);
	public abstract List<EntityVehiculo> findByTipoVehiculo(int tipoVehiculo);
	public abstract List<EntityVehiculo> findByCilindraje(int cilindraje);		
	
	public abstract Page<EntityVehiculo> findAll(Pageable pageable);

}
