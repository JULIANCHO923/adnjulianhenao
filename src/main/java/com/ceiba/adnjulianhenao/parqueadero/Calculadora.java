package com.ceiba.adnjulianhenao.parqueadero;

import java.util.Calendar;

/**
 * Esta clase tiene como funciones:
 * 1. Obtener fecha actual
 * 2. Obtener dia de la semana
 * 3. Calcular dias y horas entre las fechas de ingreso y salida del vehiculo
 * 4. Calcular costoTotal del parqueo  
 * @author julian.henao
 *
 */
public class Calculadora {

	
	
		
	public float calcularHorasTranscurridas(Calendar fechaDeIngreso, Calendar fechaDeSalida) {
		
		long fechaDeIngresoEnMillis = fechaDeIngreso.getTimeInMillis();
		long fechaActualEnMillis = fechaDeSalida.getTimeInMillis();
		
		long tiempoTranscurridoEnMilis = fechaActualEnMillis - fechaDeIngresoEnMillis;
		return convertirMiliEnHoras(tiempoTranscurridoEnMilis);
	}
	
	public int obtenerDiaActual() {
		return obtenerFechaActual().get(Calendar.DAY_OF_WEEK);
	}

	public Calendar obtenerFechaActual() {		
		return Calendar.getInstance();		
	}
	
	private float convertirMiliEnHoras(long milisegundos) {				
		float equivalencia = ((float) 1000) * 60 * 60;  
		return milisegundos/equivalencia;		
	}
	
	
}
