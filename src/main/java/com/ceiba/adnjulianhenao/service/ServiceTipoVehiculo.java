package com.ceiba.adnjulianhenao.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Service;

import com.ceiba.adnjulianhenao.converter.ConverterTipoVehiculo;

import com.ceiba.adnjulianhenao.entity.EntityTipoVehiculo;

import com.ceiba.adnjulianhenao.model.ModelTipoVehiculo;

import com.ceiba.adnjulianhenao.repository.IRepositoryTipoVehiculo;


@Service("servicioTipoVehiculo")
public class ServiceTipoVehiculo {
	

	@Autowired
	@Qualifier("repositorioTipoVehiculo") // Inyecta el bean
	private IRepositoryTipoVehiculo repositoryTipoVehiculo;

	
	@Autowired
	@Qualifier("convertidorTipoVehiculo") // Inyecta el bean
	private ConverterTipoVehiculo converterTipoVehiculo;
	
	private static final Logger log = LoggerFactory.getLogger(ServiceTipoVehiculo.class);
	
	public boolean crear(ModelTipoVehiculo modelTipoVehiculo){
		log.info("Creando Tipo Vehiculo");
		try{
			repositoryTipoVehiculo.save(converterTipoVehiculo.convertirModeloAEntidad(modelTipoVehiculo));
			log.info("El Tipo vehiculo se creó exitosamente");
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	public boolean actualizar(ModelTipoVehiculo modelTipoVehiculo){
		try{			
			if(repositoryTipoVehiculo.findById(modelTipoVehiculo.getId()) != null){				
				repositoryTipoVehiculo.save(converterTipoVehiculo.convertirModeloAEntidad(modelTipoVehiculo));
				return true;
			}			
		}catch(Exception e){			
		}
		return false;
	}
		
	public boolean borrar(int id){
		try{
			EntityTipoVehiculo entityTipoVehiculo = repositoryTipoVehiculo.findById(id);
			repositoryTipoVehiculo.delete(entityTipoVehiculo);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	
	public List<ModelTipoVehiculo> obtenerTipoVehiculos(){
		log.info("Listando Tipos de Vehiculos");
		return converterTipoVehiculo.convertirLista(repositoryTipoVehiculo.findAll()); 		
	}
	
	public ModelTipoVehiculo obtenerporId(int idTipoVehiculo){
		return converterTipoVehiculo.convertirEntidadAModelo(repositoryTipoVehiculo.findById(idTipoVehiculo)); 		
	}
	
}
