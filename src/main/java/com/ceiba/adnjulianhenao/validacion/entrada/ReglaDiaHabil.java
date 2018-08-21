package com.ceiba.adnjulianhenao.validacion.entrada;


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
		
	/**
	 * En el formato LocalDateTime manejado en el calendario Lunes = 1, Martes = 2...
	 * @param diaActual
	 * @return
	 */
	private boolean diaNoHabilLunesPlacaA(int diaActual){
		return diaActual == 1;		
	}
	
	/**
	 * En el formato LocalDateTime manejado en el calendario Sabado = 6, Domingo = 7, Lunes = 1, Martes = 2...
	 * @param diaActual
	 * @return
	 */
	private boolean diaNoHabilDomingoPlacaA(int diaActual){
		return diaActual == 7;
	}

}
