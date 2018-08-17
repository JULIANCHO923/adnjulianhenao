package com.ceiba.adnjulianhenao.dominioparqueadero;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.ceiba.adnjulianhenao.modelo.ModeloParqueaderoRegistro;
import com.ceiba.adnjulianhenao.modelo.ModeloParqueaderoTarifa;
import com.ceiba.adnjulianhenao.servicio.ServicioParqueaderoTarifa;

/**
 * Esta clase tiene como funciones: 1. Calcular dias y horas entre las fechas de
 * ingreso y salida del vehiculo 2. Calcular costoTotal del parqueo
 * 
 * @author julian.henao
 *
 */
@Component("calculadora")
public class Calculadora {

	@Autowired
	@Qualifier("servicioParqueaderoTarifa")
	private ServicioParqueaderoTarifa servicioParqueaderoTarifa;

	public void calcularCostoParqueadero(ModeloParqueaderoRegistro modeloParqueaderoRegistro, int horasACalcular) {

		ModeloParqueaderoTarifa modeloParqueaderoTarifa = servicioParqueaderoTarifa
				.obtenerTarifasPorTipoVehiculo(modeloParqueaderoRegistro.getVehiculo().getTipoVehiculo().getId());

		long costohora = modeloParqueaderoTarifa.getCostoHora();
		long costodia = modeloParqueaderoTarifa.getCostoDia();
		int inicioCobroDia = modeloParqueaderoTarifa.getHorasCobroDia();
		long costoTotal;

		int a = (horasACalcular / 24);
		int horas = (horasACalcular % 24);

		int b = 0;
		int c = 0;

		if (horas >= inicioCobroDia && horas <= 24) {
			b = horas;
			costoTotal = costodia * (a + 1);
		} else {
			b = (horas / inicioCobroDia);
			c = (horas % inicioCobroDia);

			costoTotal = (a + b) * costodia + c * costohora;
		}

		modeloParqueaderoRegistro.setHorasParqueo((a) * 24 + b + c);
		modeloParqueaderoRegistro.setDiasParqueadero((a + b));
		modeloParqueaderoRegistro.setHorasParqueadero(c);
		modeloParqueaderoRegistro.setCostoTotal(costoTotal);

	}

	public int calcularHorasParqueadero(Calendar fechaEntrada, Calendar fechaSalida) {
		long fechaEntradaEnMillis = fechaEntrada.getTimeInMillis();
		long fechaSalidaEnMillis = fechaSalida.getTimeInMillis();
		long tiempoTranscurridoEnMilis = (fechaSalidaEnMillis - fechaEntradaEnMillis);
		long hh = tiempoTranscurridoEnMilis / (1000 * 60 * 60);

		return (int) hh;
	}
}
