package com.ceiba.adnjulianhenao.validacion.entrada;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.ceiba.adnjulianhenao.dominioparqueadero.Calendario;
import com.ceiba.adnjulianhenao.excepcion.ExcepcionParametroInvalido;
import com.ceiba.adnjulianhenao.modelo.ModeloVehiculo;

@Component
public class ReglaDiaHabil implements ValidacionEntrada{

	
	@Autowired
	@Qualifier("calendario")
	Calendario calendario;
	
	@Override
	public void validar(ModeloVehiculo modelVehiculo) {
		
		int diaActual = calendario.obtenerDiaActual();
		
		if(modelVehiculo.getPlaca().charAt(0) == 'A' && (diaNoHabilDomingoPlacaA(diaActual) || diaNoHabilLunesPlacaA(diaActual))){
			throw new ExcepcionParametroInvalido("La placa que inicia por 'A' NO puede ingresar los Lunes y los Domingos");
		}
		
	}
		
	private boolean diaNoHabilLunesPlacaA(int diaActual){
		return diaActual == Calendar.MONDAY;		
	}
	
	private boolean diaNoHabilDomingoPlacaA(int diaActual){
		return diaActual == Calendar.SUNDAY;
	}

}
