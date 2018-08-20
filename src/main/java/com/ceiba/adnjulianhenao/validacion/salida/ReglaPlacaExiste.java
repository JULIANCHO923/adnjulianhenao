package com.ceiba.adnjulianhenao.validacion.salida;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.ceiba.adnjulianhenao.excepcion.ExcepcionParametroInvalido;
import com.ceiba.adnjulianhenao.servicio.ServicioVehiculo;

@Component("reglaPlacaExiste")
public class ReglaPlacaExiste implements ValidacionSalida{
	
	@Autowired
	@Qualifier("servicioVehiculo")
	private ServicioVehiculo servicioVehiculo;
	
	@Override
	public void validar(int idRegistro, String placa) {
				
		if(servicioVehiculo.obtenerPorPlaca(placa) == null){
			throw new ExcepcionParametroInvalido("La placa ingresada para salir no se encuentra registrada");
		}
	}

}
