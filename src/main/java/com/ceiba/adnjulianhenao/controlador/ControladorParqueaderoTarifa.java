package com.ceiba.adnjulianhenao.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.adnjulianhenao.modelo.ModeloParqueaderoTarifa;
import com.ceiba.adnjulianhenao.servicio.ServicioParqueaderoTarifa;

@RestController
@RequestMapping("/estacionamiento/tarifa")
@CrossOrigin(origins = "http://localhost:4200")
public class ControladorParqueaderoTarifa {
	
	
	@Autowired
	@Qualifier("servicioParqueaderoTarifa")
	private ServicioParqueaderoTarifa servicioParqueaderoTarifa; 
	
	
	// Por cada peticion nos trae un header y un body del tipo Json
	// Con RequestBody llamo y con el Valid lo convierto en entityVehiculo
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<String> crear(@RequestBody ModeloParqueaderoTarifa modeloParqueaderoTarifa){
		servicioParqueaderoTarifa.crear(modeloParqueaderoTarifa);
		return ResponseEntity.status(HttpStatus.CREATED).body("Tarifa Ingresada exitosamente");
	}
   
	@RequestMapping(value="/all", method=RequestMethod.POST)
	public ResponseEntity<String> crear(@RequestBody List<ModeloParqueaderoTarifa> modeloParqueaderoTarifas){
		servicioParqueaderoTarifa.crear(modeloParqueaderoTarifas);
		return ResponseEntity.status(HttpStatus.CREATED).body("Tarifas Ingresadas exitosamente");
	}
   
       
	@RequestMapping(value="", method=RequestMethod.PUT)
	public ResponseEntity<String> actualizar(@RequestBody ModeloParqueaderoTarifa tarifa){
		servicioParqueaderoTarifa.actualizar(tarifa);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Tarifa Actualizada exitosamente");
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<String> borrar(@PathVariable("id") int id){
		servicioParqueaderoTarifa.borrar(id);
		return ResponseEntity.status(HttpStatus.CREATED).body("Tarifa Eliminada exitosamente");
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public ResponseEntity<List<ModeloParqueaderoTarifa>> obtenerTarifas(){
		return ResponseEntity.status(HttpStatus.OK).body(servicioParqueaderoTarifa.obtenerTarifas());
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<ModeloParqueaderoTarifa> obtenerTarifasPorTipoVehiculo(@PathVariable("id") int idTipoVehiculo){
		return ResponseEntity.status(HttpStatus.OK).body(servicioParqueaderoTarifa.obtenerTarifasPorTipoVehiculo(idTipoVehiculo));
	}
	
}