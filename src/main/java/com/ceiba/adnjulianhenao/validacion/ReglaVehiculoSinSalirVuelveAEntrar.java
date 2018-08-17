package com.ceiba.adnjulianhenao.validacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.ceiba.adnjulianhenao.excepcion.ExcepcionConflicto;
import com.ceiba.adnjulianhenao.modelo.ModeloVehiculo;
import com.ceiba.adnjulianhenao.servicio.ServicioVehiculo;

@Component("")
public class ReglaVehiculoSinSalirVuelveAEntrar implements Validaciones{

	
	@Autowired
	@Qualifier("servicioVehiculo")
	private ServicioVehiculo servicioVehiculo;
	
	@Override
	public void validar(ModeloVehiculo modeloVehiculo) {		
		if(servicioVehiculo.obtenerPorPlaca(modeloVehiculo.getPlaca()) != null){
			throw new ExcepcionConflicto("La Placa registrada ya se encuentra en el parqueadero");
		}
	}

}
