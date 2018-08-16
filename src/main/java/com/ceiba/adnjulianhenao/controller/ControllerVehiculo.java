package com.ceiba.adnjulianhenao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.adnjulianhenao.model.ModelVehiculo;
import com.ceiba.adnjulianhenao.service.ServiceVehiculo;

@RestController
@RequestMapping("/v1")
public class ControllerVehiculo {

	@Autowired
	@Qualifier("servicioVehiculo")
	private ServiceVehiculo serviceVehiculo;

	// Por cada peticion nos trae un header y un body del tipo Json
	// Con RequestBody llamo y con el Valid lo convierto en entityVehiculo

	@PutMapping("/vehiculo")
	public boolean agregarVehiculo(@RequestBody ModelVehiculo vehiculo) {
		return serviceVehiculo.crear(vehiculo);
	}

	@PostMapping("/vehiculo")
	public boolean actualizarVehiculo(@RequestBody ModelVehiculo vehiculo) {
		return serviceVehiculo.actualizar(vehiculo);
	}

	@DeleteMapping("/vehiculo/{id}")
	public boolean borrarVehiculo(@PathVariable("id") int idVehiculo) {
		return serviceVehiculo.borrar(idVehiculo);
	}

	@GetMapping("/vehiculo")
	public List<ModelVehiculo> obtenerVehiculos() {
		return serviceVehiculo.obtenerVehiculos();
	}

	@GetMapping("/vehiculos")
	public List<ModelVehiculo> obtenerVehiculosPorPaginacion(Pageable pageable) {
		return serviceVehiculo.obtenerVehiculosPorPaginacion(pageable);
	}
	
	@GetMapping("/vehiculos/{id}")
	public List<ModelVehiculo> obtenerVehiculosPorTipoVehiculo(@PathVariable("id") int idTipoVehiculo) {
		return serviceVehiculo.obtenerPorTipoVehiculo(idTipoVehiculo);
	}
}