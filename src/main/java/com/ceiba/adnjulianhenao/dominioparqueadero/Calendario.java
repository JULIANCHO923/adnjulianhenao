package com.ceiba.adnjulianhenao.dominioparqueadero;


import java.time.LocalDateTime;
import java.time.ZoneId;

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

	/**
	 * Lista de nombres de zonas horarias https://www.mkyong.com/java8/java-display-all-zoneid-and-its-utc-offset/
	 * "Pacific/Norfolk" "America/St_Johns"   "Etc/GMT+12"  "America/Bogota"
	 */	  	
	public static final String zonaHoraria = "America/Bogota" ;
	
	public int obtenerDiaActual() {		
		return obtenerFechaActual().getDayOfWeek().getValue();
	}

	public LocalDateTime obtenerFechaActual() {		 
		return LocalDateTime.now(ZoneId.of(zonaHoraria)); 
	}

}
