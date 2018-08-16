package com.ceiba.adnjulianhenao.repositorio;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.adnjulianhenao.entidad.EntidadVehiculo;


/**
 * Se encarga de las peticiones en la base de datos
 * @author julian.henao
 *
 */
@Repository("repositorioVehiculo")
public interface IRepositorioVehiculo extends JpaRepository<EntidadVehiculo, Serializable>, PagingAndSortingRepository<EntidadVehiculo, Serializable>{ 
	
	public abstract EntidadVehiculo findById(int idVehiculo);	
	public abstract List<EntidadVehiculo> findByPlaca(String placa);
	
	public abstract List<EntidadVehiculo> findByCilindraje(int cilindraje);		
	public abstract Page<EntidadVehiculo> findAll(Pageable pageable);

	public abstract List<EntidadVehiculo> findByTipoVehiculoId(int id);
	
}
