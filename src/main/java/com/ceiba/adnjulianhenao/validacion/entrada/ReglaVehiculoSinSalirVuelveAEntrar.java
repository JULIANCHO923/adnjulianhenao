package com.ceiba.adnjulianhenao.validacion.entrada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.ceiba.adnjulianhenao.excepcion.ExcepcionConflicto;
import com.ceiba.adnjulianhenao.modelo.ModeloVehiculo;
import com.ceiba.adnjulianhenao.servicio.ServicioParqueaderoRegistro;
import com.ceiba.adnjulianhenao.servicio.ServicioVehiculo;

@Component("reglaVehiculoSinSalirVuelveAEntrar")
public class ReglaVehiculoSinSalirVuelveAEntrar implements ValidacionEntrada {

	@Autowired
	@Qualifier("servicioVehiculo")
	private ServicioVehiculo servicioVehiculo;

	@Autowired
	@Qualifier("servicioParqueaderoRegistro")
	private ServicioParqueaderoRegistro servicioParqueaderoRegistro;

	@Override
	public void validar(ModeloVehiculo modeloVehiculo) {
		ModeloVehiculo modeloVehiculoAux = servicioVehiculo.obtenerPorPlaca(modeloVehiculo.getPlaca());
		if (modeloVehiculoAux != null && servicioParqueaderoRegistro
				.obtenerRegistrosPorVehiculosPorIdSinSalir(modeloVehiculoAux.getId()) != null) {
			throw new ExcepcionConflicto("El vehiculo con la PLACA ingresada se encuentra en el parqueadero y NO ha salido");
		}
	}

}
