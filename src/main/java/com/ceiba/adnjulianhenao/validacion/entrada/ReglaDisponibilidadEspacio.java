package com.ceiba.adnjulianhenao.validacion.entrada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.ceiba.adnjulianhenao.excepcion.ExcepcionConflicto;
import com.ceiba.adnjulianhenao.modelo.ModeloParqueaderoEspacioDisponible;
import com.ceiba.adnjulianhenao.modelo.ModeloVehiculo;
import com.ceiba.adnjulianhenao.servicio.ServicioParqueaderoEspacioDisponible;


@Component
public class ReglaDisponibilidadEspacio implements ValidacionesEntrada{

	
	@Autowired
	@Qualifier("servicioParqueaderoEspacioDisponible")
	private ServicioParqueaderoEspacioDisponible servicioParqueaderoEspacioDisponible;
	
	@Override
	public void validar(ModeloVehiculo modeloVehiculo) {
		
		ModeloParqueaderoEspacioDisponible modeloParqueaderoEspacioDisponible = servicioParqueaderoEspacioDisponible.obtenerEspacioDisponiblePorTipoVehiculo(modeloVehiculo.getTipoVehiculo().getId());
		
		if(modeloParqueaderoEspacioDisponible.getEspacioActual() == modeloParqueaderoEspacioDisponible.getLimiteEspacio()){
			throw new ExcepcionConflicto("No hay espacio disponible en el parqueadero para "+ modeloVehiculo.getTipoVehiculo().getDescripcion() + "\n Espacio Actual: " + modeloParqueaderoEspacioDisponible.getEspacioActual() + "\n Espacio Limite: " + modeloParqueaderoEspacioDisponible.getLimiteEspacio() );
		}
		
	}

}
