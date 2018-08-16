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

import com.ceiba.adnjulianhenao.model.ModelParqueaderoEspacioDisponible;
import com.ceiba.adnjulianhenao.service.ServiceParqueaderoEspacioDisponible;

@RestController
@RequestMapping("/v4")
public class ControllerParqueaderoEspacioDisponible {
	
	
	@Autowired
	@Qualifier("servicioParqueaderoEspacioDisponible")
	private ServiceParqueaderoEspacioDisponible serviceParqueaderoEspacioDisponible; 
	
	
	// Por cada peticion nos trae un header y un body del tipo Json
	// Con RequestBody llamo y con el Valid lo convierto en entityVehiculo
	
	@PutMapping("/espacio")
	public boolean agregar(@RequestBody ModelParqueaderoEspacioDisponible modelParqueaderoEspacioDisponible){
		return serviceParqueaderoEspacioDisponible.crear(modelParqueaderoEspacioDisponible);
	}
          
	@PostMapping("/espacio")
	public boolean actualizar(@RequestBody ModelParqueaderoEspacioDisponible modelParqueaderoEspacioDisponible){
		return serviceParqueaderoEspacioDisponible.actualizar(modelParqueaderoEspacioDisponible);
	}
	
	@DeleteMapping("/espacio/{id}")
	public boolean borrar(@PathVariable("id") int id){
		return serviceParqueaderoEspacioDisponible.borrar(id);
	}
	
	@GetMapping("/espacios")
	public List<ModelParqueaderoEspacioDisponible> obtenerTarifas(){
		return serviceParqueaderoEspacioDisponible.obtenerTarifas();
	}
	
	@GetMapping("/espacio/{id}")
	public List<ModelParqueaderoEspacioDisponible> obtenerEspacioDisponiblePorTipoVehiculo(@PathVariable("id") int idTipoVehiculo){
		return serviceParqueaderoEspacioDisponible.obtenerEspacioDisponiblePorTipoVehiculo(idTipoVehiculo);
	}
}