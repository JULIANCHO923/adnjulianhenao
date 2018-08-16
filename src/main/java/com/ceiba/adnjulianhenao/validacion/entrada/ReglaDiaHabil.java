package com.ceiba.adnjulianhenao.validacion.entrada;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.adnjulianhenao.excepcion.ExcepcionParametroInvalido;
import com.ceiba.adnjulianhenao.modelo.ModeloVehiculo;
import com.ceiba.adnjulianhenao.parqueadero.Calculadora;

@Component
public class ReglaDiaHabil implements ValidacionesEntrada{

	
	@Autowired
	Calculadora calculadora;
	
	@Override
	public void validar(ModeloVehiculo modelVehiculo) {
		
		int diaActual = calculadora.obtenerDiaActual();
		
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
