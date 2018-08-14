package com.ceiba.adnjulianhenao.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.adnjulianhenao.entity.EntityVehiculo;
import com.ceiba.adnjulianhenao.service.VehiculoService;

@RestController
@RequestMapping("/v1")
public class VehiculoController {
	
	
	@Autowired
	@Qualifier("servicioVehiculo")
	private VehiculoService vehiculoService; 
	
	
	// Por cada peticion nos trae un header y un body del tipo Json
	// Con RequestBody llamo y con el Valid lo convierto en entityVehiculo
	
	@PutMapping("/vehiculo")
	public boolean agregarVehiculo(@RequestBody @Valid EntityVehiculo vehiculo){
		return vehiculoService.crear(vehiculo);
	}
   
       
	@PutMapping("/vehiculo")
	public boolean actualizarVehiculo(@RequestBody  @Valid EntityVehiculo vehiculo){
		return vehiculoService.actualizar(vehiculo);
	}
	
}