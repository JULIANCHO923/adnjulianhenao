package com.ceiba.adnjulianhenao.validacion.salida;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.ceiba.adnjulianhenao.excepcion.ExcepcionParametroInvalido;
import com.ceiba.adnjulianhenao.servicio.ServicioParqueaderoRegistro;

@Component("reglaPlacaYRegistroCoinciden")
public class ReglaPlacaYRegistroCoinciden implements ValidacionSalida{
	
	@Autowired
	@Qualifier("servicioParqueaderoRegistro")
	private ServicioParqueaderoRegistro servicioParqueaderoRegistro;
	
	@Override
	public void validar(int idRegistro, String placa) {
			
		if(servicioParqueaderoRegistro.obtenerRegistroPorIdYPorPlacaSinSalir(idRegistro, placa) == null){
			throw new ExcepcionParametroInvalido("El id del registro del parqueadero y la placa no coinciden");
		}
	}

}
