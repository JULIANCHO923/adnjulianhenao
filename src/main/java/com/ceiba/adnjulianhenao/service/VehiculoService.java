package com.ceiba.adnjulianhenao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.ceiba.adnjulianhenao.controller.ConvertidorVehiculo;
import com.ceiba.adnjulianhenao.entity.EntityVehiculo;
import com.ceiba.adnjulianhenao.model.Vehiculo;
import com.ceiba.adnjulianhenao.repository.IVehiculoRepository;

@Service("servicioVehiculo")
public class VehiculoService {
	
	@Autowired
	@Qualifier("repositorioVehiculo") // Inyecta el bean
	private IVehiculoRepository vehiculoRepository;

	
	@Autowired
	@Qualifier("convertidorVehiculo") // Inyecta el bean
	private ConvertidorVehiculo vehiculoConvertidor;
	
	
	
	public boolean crear(EntityVehiculo vehiculo){
		try{
			vehiculoRepository.save(vehiculo);			
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	public boolean actualizar(EntityVehiculo vehiculo){
		try{
			if(vehiculoRepository.findById(vehiculo.getId()) != null){
				vehiculoRepository.save(vehiculo);
				return true;
			}			
		}catch(Exception e){			
		}
		return false;
	}
	
	public boolean borrar(int idVehiculo){
		try{
			EntityVehiculo vehiculo = vehiculoRepository.findById(idVehiculo);
			vehiculoRepository.delete(vehiculo);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	public List<Vehiculo> obtenerVehiculos(){
		return vehiculoConvertidor.convertirLista(vehiculoRepository.findAll()); 		
	}
	
	public Vehiculo obtenerporId(int idVehiculo){
		return vehiculoConvertidor.convertirVehiculo(vehiculoRepository.findById(idVehiculo)); 		
	}
	
	public List<Vehiculo> obtenerPorPlaca(String placa){
		return vehiculoConvertidor.convertirLista(vehiculoRepository.findByPlaca(placa)); 		
	}
	
	public List<Vehiculo> obtenerPorIdTipoVehiculo(int tipoVehiculo){
		return vehiculoConvertidor.convertirLista(vehiculoRepository.findByTipoVehiculo(tipoVehiculo)); 		
	}
	
	public List<Vehiculo> obtenerPorCilindraje(int cilindraje){
		return vehiculoConvertidor.convertirLista(vehiculoRepository.findByCilindraje(cilindraje)); 		
	}
	
}
