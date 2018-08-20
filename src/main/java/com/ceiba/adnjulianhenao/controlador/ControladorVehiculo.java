package com.ceiba.adnjulianhenao.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ceiba.adnjulianhenao.modelo.ModeloVehiculo;
import com.ceiba.adnjulianhenao.servicio.ServicioVehiculo;


@RestController
@RequestMapping("/estacionamiento/vehiculos")
@CrossOrigin(origins = "http://localhost:4200")
public class ControladorVehiculo {

	@Autowired
	@Qualifier("servicioVehiculo")
	private ServicioVehiculo servicioVehiculo;

	/**
	 *  Por cada peticion nos trae un header y un body del tipo Json
	 *  Con RequestBody llamo y con el Valid lo convierto en entityVehiculo
	 */
	 	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<String> crear(@RequestBody ModeloVehiculo modeloVehiculo) {
		servicioVehiculo.crear(modeloVehiculo);
		return ResponseEntity.status(HttpStatus.CREATED).body("Vehiculo Ingresado exitosamente");
	}

	@RequestMapping(value="/all", method=RequestMethod.POST)
	public ResponseEntity<String> crear(@RequestBody List<ModeloVehiculo> modeloVehiculos) {
		servicioVehiculo.crear(modeloVehiculos);
		return ResponseEntity.status(HttpStatus.OK).body("Vehiculos Ingresados exitosamente");					
	}
	
	@RequestMapping(value="", method=RequestMethod.PUT)
	public ResponseEntity<String> actualizar(@RequestBody ModeloVehiculo vehiculo) {
		servicioVehiculo.actualizar(vehiculo);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Vehiculo Actualizado exitosamente");
	}

	
	/**
	 * La solicitud de Delete será utilizada para registrar la salida del vehiculo sin eliminarlo
	 * @param modeloVehiculo
	 * @return
	 */
	@RequestMapping(value="/{id}/{placa}", method=RequestMethod.DELETE)
	public ResponseEntity<String> borrar(@PathVariable("id") int idRegistro, @PathVariable("placa")String placa ) {
		servicioVehiculo.borrar(idRegistro, placa);
		return ResponseEntity.status(HttpStatus.CONTINUE).body("El vehiculo registro su salida exitosamente");
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public ResponseEntity<List<ModeloVehiculo>> obtenerVehiculos() {
		return ResponseEntity.status(HttpStatus.OK).body(servicioVehiculo.obtenerVehiculos());
	}
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public ResponseEntity<List<ModeloVehiculo>> obtenerVehiculosPorPaginacion(Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(servicioVehiculo.obtenerVehiculosPorPaginacion(pageable));
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<List<ModeloVehiculo>> obtenerVehiculosPorTipoVehiculo(@PathVariable("id") int idTipoVehiculo, Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(servicioVehiculo.obtenerPorTipoVehiculo(idTipoVehiculo, pageable));
	}
	
}