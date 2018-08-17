package com.ceiba.adnjulianhenao.dominioparqueadero;

import java.util.Calendar;

import org.springframework.stereotype.Component;


/**
 * Esta clase tiene como funciones: 
 * 1. Obtener fecha actual 
 * 2. Obtener dia de la semana 
 * 
 * @author julian.henao
 *
 */
@Component("calendario")
public class Calendario {

	public int obtenerDiaActual() {
		return obtenerFechaActual().get(Calendar.DAY_OF_WEEK);
	}

	public Calendar obtenerFechaActual() {
		return Calendar.getInstance();
	}

}
