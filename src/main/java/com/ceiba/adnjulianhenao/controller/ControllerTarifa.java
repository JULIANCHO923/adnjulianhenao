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

import com.ceiba.adnjulianhenao.entity.EntityTarifa;
import com.ceiba.adnjulianhenao.model.Tarifa;
import com.ceiba.adnjulianhenao.service.ServiceTarifa;

@RestController
@RequestMapping("/v3")
public class ControllerTarifa {
	
	
	@Autowired
	@Qualifier("servicioTarifa")
	private ServiceTarifa serviceTarifa; 
	
	
	// Por cada peticion nos trae un header y un body del tipo Json
	// Con RequestBody llamo y con el Valid lo convierto en entityVehiculo
	
	@PutMapping("/tarifa")
	public boolean agregarTarifa(@RequestBody EntityTarifa tarifa){
		return serviceTarifa.crear(tarifa);
	}
   
       
	@PostMapping("/tarifa")
	public boolean actualizarTarifa(@RequestBody EntityTarifa tarifa){
		return serviceTarifa.actualizar(tarifa);
	}
	
	@DeleteMapping("/tarifa/{id}")
	public boolean borrarTarifa(@PathVariable("id") int id){
		return serviceTarifa.borrar(id);
	}
	
	@GetMapping("/tarifas")
	public List<Tarifa> obtenerTarifas(){
		return serviceTarifa.obtenerTarifas();
	}
	
	
}