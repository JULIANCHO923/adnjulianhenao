package com.ceiba.adnjulianhenao.validacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ceiba.adnjulianhenao.excepcion.ExcepcionConflicto;
import com.ceiba.adnjulianhenao.modelo.ModeloVehiculo;
import com.ceiba.adnjulianhenao.servicio.ServicioParqueaderoRegistro;

public class ReglaVehiculoSinSalirVuelveAEntrar implements Validaciones{

	
	@Autowired
	@Qualifier("servicioParqueaderoRegistro")
	private ServicioParqueaderoRegistro servicioParqueaderoRegistro;
	
	@Override
	public void validar(ModeloVehiculo modeloVehiculo) {		
		if(servicioParqueaderoRegistro.obtenerRegistrosPorVehiculosPorPlacaSinSalir(modeloVehiculo.getPlaca()) != null){
			throw new ExcepcionConflicto("La Placa registrada ya se encuentra en el parqueadero");
		}
	}

}
