package com.ceiba.adnjulianhenao.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ceiba.adnjulianhenao.entity.EntityVehiculo;

/**
 * Se encarga de las peticiones en la base de datos
 * @author julian.henao
 *
 */
@Repository("repositorioVehiculo")
public interface IVehiculoRepository extends JpaRepository<EntityVehiculo, Serializable>{ 
	
	public abstract EntityVehiculo findById(int idVehiculo);	
	public abstract List<EntityVehiculo> findByPlaca(String placa);
	public abstract List<EntityVehiculo> findByTipoVehiculo(int tipoVehiculo);
	public abstract List<EntityVehiculo> findByCilindraje(int cilindraje);		

}
