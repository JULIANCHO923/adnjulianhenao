package com.ceiba.adnjulianhenao.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.adnjulianhenao.modelo.ModeloParqueaderoRegistro;
import com.ceiba.adnjulianhenao.servicio.ServicioParqueaderoRegistro;

@RestController
@RequestMapping("/estacionamiento/registros")
@CrossOrigin(origins = "http://localhost:4200")
public class ControladorParqueaderoRegistro {

	@Autowired
	@Qualifier("servicioParqueaderoRegistro")
	private ServicioParqueaderoRegistro servicioParqueaderoRegistro;

	// Por cada peticion nos trae un header y un body del tipo Json
	// Con RequestBody llamo y con el Valid lo convierto en entityParqueaderoRegistro

	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<String> crear(@RequestBody ModeloParqueaderoRegistro modeloParqueaderoRegistro) {
		servicioParqueaderoRegistro.insertar(modeloParqueaderoRegistro);
		return ResponseEntity.status(HttpStatus.CREATED).body("Registro Ingresado exitosamente");
	}

	@RequestMapping(value="/all", method=RequestMethod.PUT)
	public ResponseEntity<String> actualizar(@RequestBody ModeloParqueaderoRegistro modeloParqueaderoRegistro) {
		servicioParqueaderoRegistro.actualizar(modeloParqueaderoRegistro);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Registros Actualizados exitosamente");
	}

	@RequestMapping(value="{id}", method=RequestMethod.DELETE)
	public  ResponseEntity<String> borrar(@PathVariable("id") int idParqueaderoRegistro) {
		servicioParqueaderoRegistro.borrar(idParqueaderoRegistro);
		return ResponseEntity.status(HttpStatus.CONTINUE).body("Registro Eliminado exitosamente");
	}

	@RequestMapping(value="", method=RequestMethod.GET)
	public ResponseEntity<List<ModeloParqueaderoRegistro>> obtenerRegistros(Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(servicioParqueaderoRegistro.obtenerRegistros(pageable));
	}
	
	/*
	@RequestMapping(value="/{placa}", method=RequestMethod.GET)
	public ResponseEntity<ModeloParqueaderoRegistro> obtenerRegistroPorVehiculosSinSalirPorPaginacion(@PathVariable("placa") String placa) {
		return ResponseEntity.status(HttpStatus.OK).body(servicioParqueaderoRegistro.obtenerRegistrosPorVehiculosPorPlacaSinSalir(placa));
	}*/
		
}