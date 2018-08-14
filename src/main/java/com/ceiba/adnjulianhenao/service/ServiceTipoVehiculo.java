package com.ceiba.adnjulianhenao.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Service;

import com.ceiba.adnjulianhenao.converter.ConverterTipoVehiculo;

import com.ceiba.adnjulianhenao.entity.EntityTipoVehiculo;

import com.ceiba.adnjulianhenao.model.TipoVehiculo;

import com.ceiba.adnjulianhenao.repository.IRepositoryTipoVehiculo;


@Service("servicioTipoVehiculo")
public class ServiceTipoVehiculo {
	

	@Autowired
	@Qualifier("repositorioTipoVehiculo") // Inyecta el bean
	private IRepositoryTipoVehiculo repositoryTipoVehiculo;

	
	@Autowired
	@Qualifier("convertidorTipoVehiculo") // Inyecta el bean
	private ConverterTipoVehiculo converterTipoVehiculo;
	
	private static final Logger log = LoggerFactory.getLogger(ServiceVehiculo.class);
	
	public boolean crear(EntityTipoVehiculo tipoVehiculo){
		log.info("Creando Tipo Vehiculo");
		try{
			repositoryTipoVehiculo.save(tipoVehiculo);
			log.info("El Tipo vehiculo se creó exitosamente");
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	public boolean actualizar(EntityTipoVehiculo tipoVehiculo){
		try{			
			if(repositoryTipoVehiculo.findById(tipoVehiculo.getId()) != null){				
				repositoryTipoVehiculo.save(tipoVehiculo);
				return true;
			}			
		}catch(Exception e){			
		}
		return false;
	}
		
	public boolean borrar(int idTipoVehiculo){
		try{
			EntityTipoVehiculo vehiculo = repositoryTipoVehiculo.findById(idTipoVehiculo);
			repositoryTipoVehiculo.delete(vehiculo);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	
	public List<TipoVehiculo> obtenerTipoVehiculos(){
		log.info("Listando Tipos de Vehiculos");
		return converterTipoVehiculo.convertirLista(repositoryTipoVehiculo.findAll()); 		
	}
	
	public TipoVehiculo obtenerporId(int idTipoVehiculo){
		return converterTipoVehiculo.convertirTipoVehiculo(repositoryTipoVehiculo.findById(idTipoVehiculo)); 		
	}
	
}
