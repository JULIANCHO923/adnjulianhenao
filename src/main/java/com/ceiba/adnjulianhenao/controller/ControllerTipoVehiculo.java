package com.ceiba.adnjulianhenao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.adnjulianhenao.entity.EntityTipoVehiculo;
import com.ceiba.adnjulianhenao.model.TipoVehiculo;
import com.ceiba.adnjulianhenao.service.ServiceTipoVehiculo;

@RestController
@RequestMapping("/v2")
public class ControllerTipoVehiculo {
	
	
	@Autowired
	@Qualifier("servicioTipoVehiculo")
	private ServiceTipoVehiculo serviceTipoVehiculo; 
	
	
	// Por cada peticion nos trae un header y un body del tipo Json
	// Con RequestBody llamo y con el Valid lo convierto en entityVehiculo
	
	@PutMapping("/tipovehiculo")
	public boolean agregarTipoVehiculo(@RequestBody EntityTipoVehiculo vehiculo){
		return serviceTipoVehiculo.crear(vehiculo);
	}
   
       
	@PostMapping("/tipovehiculo")
	public boolean actualizarTipoVehiculo(@RequestBody EntityTipoVehiculo vehiculo){
		return serviceTipoVehiculo.actualizar(vehiculo);
	}
	
	@DeleteMapping("/tipovehiculo/{id}")
	public boolean borrarTipoVehiculo(@PathVariable("id") int id){
		return serviceTipoVehiculo.borrar(id);
	}
	
	@GetMapping("/tipovehiculos")
	public List<TipoVehiculo> obtenerTipoVehiculos(){
		return serviceTipoVehiculo.obtenerTipoVehiculos();
	}
	
	
}