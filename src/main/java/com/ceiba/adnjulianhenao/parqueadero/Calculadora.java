package com.ceiba.adnjulianhenao.parqueadero;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ceiba.adnjulianhenao.modelo.ModeloParqueaderoRegistro;
import com.ceiba.adnjulianhenao.modelo.ModeloParqueaderoTarifa;
import com.ceiba.adnjulianhenao.servicio.ServicioParqueaderoTarifa;

/**
 * Esta clase tiene como funciones: 
 * 1. Calcular dias y horas entre las fechas de ingreso y salida del vehiculo 
 * 2. Calcular costoTotal del parqueo
 * 
 * @author julian.henao
 *
 */
public class Calculadora {
	@Autowired
	@Qualifier("servicioParqueaderoTarifa")
	private ServicioParqueaderoTarifa servicioParqueaderoTarifa;

	private static final Logger log = LoggerFactory.getLogger(Calendario.class);

	public long calcularCostoParqueadero(ModeloParqueaderoRegistro modeloParqueaderoRegistro, int horasACalcular) {

		ModeloParqueaderoTarifa modeloParqueaderoTarifa = servicioParqueaderoTarifa
				.obtenerTarifasPorTipoVehiculo(modeloParqueaderoRegistro.getVehiculo().getTipoVehiculo().getId());

		long costohora = modeloParqueaderoTarifa.getCostoHora();
		long costodia = modeloParqueaderoTarifa.getCostoDia();
		int inicioCobroDia = modeloParqueaderoTarifa.getHorasCobroDia();
		long total;

		log.info("---Horas a Calcular: " + horasACalcular + " -----");
		int a = (horasACalcular / 24);
		int horas = (horasACalcular % 24);

		log.info("dias: " + a + " horas: " + horas);
		int b = 0, c = 0;
		
		if (horas >= inicioCobroDia && horas <= 24) {
			log.info("Dias cobrados " + (a + 1) + " horas: " + c);
			b = horas;
			total = costodia * (a + 1);
		} else {
			b = (horas / inicioCobroDia);
			c = (horas % inicioCobroDia);
			log.info("Dias cobrados: " + (a + b) + " horas: " + c);
			total = (a + b) * costodia + c * costohora;
		}
		log.info("Costo total:" + total);

		int comprobando = (a) * 24 + b + c;
		log.info("Horas ingresadas:" + horasACalcular + "horas Comprobadas: " + comprobando);

		return total;
	}

	public int calcularHorasParqueadero(ModeloParqueaderoRegistro modeloParqueaderoRegistro) {
		
		Calendar fechaEntrada = modeloParqueaderoRegistro.getFechaEntrada();
		Calendar fechaSalida = modeloParqueaderoRegistro.getFechaSalida();
		
		long fechaEntradaEnMillis = fechaEntrada.getTimeInMillis();
		long fechaSalidaEnMillis = fechaSalida.getTimeInMillis();
		long tiempoTranscurridoEnMilis = (fechaSalidaEnMillis - fechaEntradaEnMillis);
		long hh = tiempoTranscurridoEnMilis / (1000 * 60 * 60);
		
		return (int) hh;
	}
}
