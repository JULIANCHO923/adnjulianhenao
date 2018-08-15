package com.ceiba.adnjulianhenao.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Service;

import com.ceiba.adnjulianhenao.converter.ConverterTarifa;

import com.ceiba.adnjulianhenao.entity.EntityTarifa;

import com.ceiba.adnjulianhenao.model.Tarifa;

import com.ceiba.adnjulianhenao.repository.IRepositoryTarifa;


@Service("servicioTarifa")
public class ServiceTarifa {
	

	@Autowired
	@Qualifier("repositorioTarifa") // Inyecta el bean
	private IRepositoryTarifa repositoryTarifa;

	
	@Autowired
	@Qualifier("convertidorTarifa") // Inyecta el bean
	private ConverterTarifa converterTarifa;
	
	private static final Logger log = LoggerFactory.getLogger(ServiceVehiculo.class);
	
	public boolean crear(EntityTarifa tarifa){
		log.info("Creando Tipo Vehiculo");
		try{
			repositoryTarifa.save(tarifa);
			log.info("El Tipo vehiculo se creó exitosamente");
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	public boolean actualizar(EntityTarifa tarifa){
		try{			
			if(repositoryTarifa.findById(tarifa.getId()) != null){				
				repositoryTarifa.save(tarifa);
				return true;
			}			
		}catch(Exception e){			
		}
		return false;
	}
		
	public boolean borrar(int id){
		try{
			EntityTarifa tarifa = repositoryTarifa.findById(id);
			repositoryTarifa.delete(tarifa);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	
	public List<Tarifa> obtenerTarifas(){
		log.info("Listando Tarifas");
		return converterTarifa.convertirLista(repositoryTarifa.findAll()); 		
	}
	
	public Tarifa obtenerporId(int id){
		return converterTarifa.convertirTarifa(repositoryTarifa.findById(id)); 		
	}
	
}
