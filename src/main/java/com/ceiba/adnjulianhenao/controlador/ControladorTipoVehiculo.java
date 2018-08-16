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

import com.ceiba.adnjulianhenao.modelo.ModeloTipoVehiculo;
import com.ceiba.adnjulianhenao.servicio.ServicioTipoVehiculo;

@RestController
@RequestMapping("/estacionamiento/tipo_vehiculo")
@CrossOrigin(origins = "http://localhost:4200")
public class ControladorTipoVehiculo {
	
	
	@Autowired
	@Qualifier("servicioTipoVehiculo")
	private ServicioTipoVehiculo servicioTipoVehiculo; 
	
	
	// Por cada peticion nos trae un header y un body del tipo Json
	// Con RequestBody llamo y con el Valid lo convierto en entityVehiculo	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<String> agregarTipoVehiculo(@RequestBody ModeloTipoVehiculo vehiculo){
		servicioTipoVehiculo.crear(vehiculo);
		return ResponseEntity.status(HttpStatus.CREATED).body("Tipo de vehiculo Ingresado exitosamente");
	}
          
	@RequestMapping(value="", method=RequestMethod.PUT)
	public ResponseEntity<String> actualizarTipoVehiculo(@RequestBody ModeloTipoVehiculo vehiculo){
		servicioTipoVehiculo.actualizar(vehiculo);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Tipo de vehiculo Actualizado exitosamente");
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.DELETE)
	public ResponseEntity<String> borrarTipoVehiculo(@PathVariable("id") int id){
		servicioTipoVehiculo.borrar(id);
		return ResponseEntity.status(HttpStatus.CONTINUE).body("Tipo de vehiculo Eliminado exitosamente");
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public ResponseEntity<List<ModeloTipoVehiculo>> obtenerTipoVehiculos(){
		return ResponseEntity.status(HttpStatus.OK).body(servicioTipoVehiculo.obtenerTipoVehiculos());
	}
	
	
}