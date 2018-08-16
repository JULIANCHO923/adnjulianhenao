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

import com.ceiba.adnjulianhenao.model.ModelParqueaderoTarifa;
import com.ceiba.adnjulianhenao.service.ServiceParqueaderoTarifa;

@RestController
@RequestMapping("/v3")
public class ControllerParqueaderoTarifa {
	
	
	@Autowired
	@Qualifier("servicioParqueaderoTarifa")
	private ServiceParqueaderoTarifa serviceParqueaderoTarifa; 
	
	
	// Por cada peticion nos trae un header y un body del tipo Json
	// Con RequestBody llamo y con el Valid lo convierto en entityVehiculo
	
	@PutMapping("/tarifa")
	public boolean agregarTarifa(@RequestBody ModelParqueaderoTarifa modelParqueaderoTarifa){
		return serviceParqueaderoTarifa.crear(modelParqueaderoTarifa);
	}
   
       
	@PostMapping("/tarifa")
	public boolean actualizarTarifa(@RequestBody ModelParqueaderoTarifa tarifa){
		return serviceParqueaderoTarifa.actualizar(tarifa);
	}
	
	@DeleteMapping("/tarifa/{id}")
	public boolean borrarTarifa(@PathVariable("id") int id){
		return serviceParqueaderoTarifa.borrar(id);
	}
	
	@GetMapping("/tarifas")
	public List<ModelParqueaderoTarifa> obtenerTarifas(){
		return serviceParqueaderoTarifa.obtenerTarifas();
	}
	
	@GetMapping("/tarifa/{id}")
	public List<ModelParqueaderoTarifa> obtenerTarifasPorTipoVehiculo(@PathVariable("id") int idTipoVehiculo){
		return serviceParqueaderoTarifa.obtenerTarifasPorTipoVehiculo(idTipoVehiculo);
	}
	
}