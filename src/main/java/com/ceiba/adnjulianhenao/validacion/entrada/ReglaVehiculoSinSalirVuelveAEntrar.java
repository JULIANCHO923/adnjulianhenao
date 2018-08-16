package com.ceiba.adnjulianhenao.validacion.entrada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ceiba.adnjulianhenao.modelo.ModeloVehiculo;
import com.ceiba.adnjulianhenao.servicio.ServicioParqueaderoRegistro;

public class ReglaVehiculoSinSalirVuelveAEntrar implements ValidacionesEntrada{

	
	@Autowired
	@Qualifier("servicioParqueaderoRegistro")
	private ServicioParqueaderoRegistro servicioParqueaderoRegistro;
	
	@Override
	public void validar(ModeloVehiculo vehiculo) {
		
		
	}

}
