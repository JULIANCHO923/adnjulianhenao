package com.ceiba.adnjulianhenao.servicio;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Service;

import com.ceiba.adnjulianhenao.convertidor.ConvertidorTipoVehiculo;
import com.ceiba.adnjulianhenao.entidad.EntidadTipoVehiculo;
import com.ceiba.adnjulianhenao.modelo.ModeloTipoVehiculo;
import com.ceiba.adnjulianhenao.repositorio.RepositorioTipoVehiculo;


@Service("servicioTipoVehiculo")
public class ServicioTipoVehiculo {
	

	@Autowired
	@Qualifier("repositorioTipoVehiculo") // Inyecta el bean
	private RepositorioTipoVehiculo repositorioTipoVehiculo;

	
	@Autowired
	@Qualifier("convertidorTipoVehiculo") // Inyecta el bean
	private ConvertidorTipoVehiculo convertidorTipoVehiculo;
	
	private static final Logger log = LoggerFactory.getLogger(ServicioTipoVehiculo.class);
	
	public void crear(ModeloTipoVehiculo modeloTipoVehiculo){
		log.info("Creando Tipo Vehiculo");
		try{
			repositorioTipoVehiculo.save(convertidorTipoVehiculo.convertirModeloAEntidad(modeloTipoVehiculo));
			log.info("El Tipo vehiculo se creó exitosamente");
			
		}catch(Exception e){
			
		}
	}
	
	public void actualizar(ModeloTipoVehiculo modeloTipoVehiculo){
		try{			
			if(repositorioTipoVehiculo.findById(modeloTipoVehiculo.getId()) != null){				
				repositorioTipoVehiculo.save(convertidorTipoVehiculo.convertirModeloAEntidad(modeloTipoVehiculo));
				
			}			
		}catch(Exception e){			
		}
		
	}
		
	public void borrar(int id){
		try{
			EntidadTipoVehiculo entidadTipoVehiculo = repositorioTipoVehiculo.findById(id);
			repositorioTipoVehiculo.delete(entidadTipoVehiculo);
			
		}catch(Exception e){
			
		}
	}
	
	
	public List<ModeloTipoVehiculo> obtenerTipoVehiculos(){
		log.info("Listando Tipos de Vehiculos");
		return convertidorTipoVehiculo.convertirLista(repositorioTipoVehiculo.findAll()); 		
	}
	
	public ModeloTipoVehiculo obtenerporId(int idTipoVehiculo){
		return convertidorTipoVehiculo.convertirEntidadAModelo(repositorioTipoVehiculo.findById(idTipoVehiculo)); 		
	}
	
}
