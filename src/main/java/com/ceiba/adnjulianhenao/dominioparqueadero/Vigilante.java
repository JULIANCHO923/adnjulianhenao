package com.ceiba.adnjulianhenao.dominioparqueadero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.ceiba.adnjulianhenao.excepcion.ExcepcionSobreCosto;
import com.ceiba.adnjulianhenao.modelo.ModeloParqueaderoEspacioDisponible;
import com.ceiba.adnjulianhenao.modelo.ModeloParqueaderoRegistro;
import com.ceiba.adnjulianhenao.modelo.ModeloVehiculo;
import com.ceiba.adnjulianhenao.servicio.ServicioParqueaderoEspacioDisponible;
import com.ceiba.adnjulianhenao.servicio.ServicioParqueaderoRegistro;
import com.ceiba.adnjulianhenao.servicio.ServicioVehiculo;
import com.ceiba.adnjulianhenao.validacion.entrada.ValidacionEntrada;
import com.ceiba.adnjulianhenao.validacion.entrada.ValidacionesEntrada;
import com.ceiba.adnjulianhenao.validacion.salida.ValidacionesSalida;
import com.ceiba.adnjulianhenao.validacion.salida.ValidacionSalida;

/**
 * Valida la entrada de vehiculo Registra la entrada Registra la salida
 */
@Component("vigilante")
public class Vigilante {

	@Autowired
	@Qualifier("validacionesEntrada")
	private ValidacionesEntrada validacionesEntrada;

	@Autowired
	@Qualifier("validacionesSalida")
	private ValidacionesSalida validacionesSalida;

	@Autowired
	@Qualifier("servicioVehiculo")
	private ServicioVehiculo servicioVehiculo;

	@Autowired
	@Qualifier("servicioParqueaderoEspacioDisponible")
	private ServicioParqueaderoEspacioDisponible servicioParqueaderoEspacioDisponible;

	@Autowired
	@Qualifier("servicioParqueaderoRegistro")
	private ServicioParqueaderoRegistro servicioParqueaderoRegistro;

	@Autowired
	@Qualifier("calendario")
	private Calendario calendario;

	@Autowired
	@Qualifier("calculadora")
	private Calculadora calculadora;

	/**
	 * Valida las reglas del negocio, crea el vehiculo (si no esta registrado) y
	 * registra mediante el idVehiculo el Registro del Parqueadero con la fecha
	 * actual
	 * 
	 * @param modeloVehiculo
	 *            vehiculo que envia el frontend
	 */
	public void registrarEntrada(ModeloVehiculo modeloVehiculo) {

		for (ValidacionEntrada validacion : validacionesEntrada.validacionesEntrada()) {
			validacion.validar(modeloVehiculo);
		}

		if (servicioVehiculo.obtenerPorPlaca(modeloVehiculo.getPlaca()) == null) {
			// No se encuentra registrado así que se debe de crear
			servicioVehiculo.insertar(modeloVehiculo);
		}

		crearRegistro(modeloVehiculo.getPlaca(), modeloVehiculo.getTipoVehiculo().getId());

	}

	/**
	 * Crea el registro de parqueo del vehiculo y aumenta el espacio ocupado
	 * 
	 * @param placa
	 *            del vehiculo
	 */
	public void crearRegistro(String placa, int idTipoVehiculo) {
		servicioParqueaderoRegistro.insertar(new ModeloParqueaderoRegistro(servicioVehiculo.obtenerPorPlaca(placa),
				calendario.obtenerFechaActual()));
		ModeloParqueaderoEspacioDisponible modeloParqueaderoEspacioDisponible = servicioParqueaderoEspacioDisponible
				.obtenerEspacioDisponiblePorTipoVehiculo(idTipoVehiculo);
		modeloParqueaderoEspacioDisponible.aumentarEspacio();
		servicioParqueaderoEspacioDisponible.actualizar(modeloParqueaderoEspacioDisponible);
	}

	public void registrarSalida(int idRegistro, String placa) {
		ModeloParqueaderoRegistro modeloParqueaderoRegistro = null;
		try {

			for (ValidacionSalida validacion : validacionesSalida.validacionesSalida()) {
				validacion.validar(idRegistro, placa);
			}
			
			
			modeloParqueaderoRegistro = (servicioParqueaderoRegistro.obtenerRegistroPorIdYPorPlacaSinSalir(idRegistro,
					placa));

			modeloParqueaderoRegistro.setFechaSalida(calendario.obtenerFechaActual());

			calculadora.calcularCostoParqueadero(modeloParqueaderoRegistro, calculadora.calcularHorasParqueadero(
					modeloParqueaderoRegistro.getFechaEntrada(), modeloParqueaderoRegistro.getFechaSalida()));

		} catch (ExcepcionSobreCosto esc) {
			
			modeloParqueaderoRegistro = (servicioParqueaderoRegistro.obtenerRegistroPorIdYPorPlacaSinSalir(idRegistro,
					placa));

			modeloParqueaderoRegistro.setFechaSalida(calendario.obtenerFechaActual());

			calculadora.calcularCostoParqueadero(modeloParqueaderoRegistro, calculadora.calcularHorasParqueadero(
					modeloParqueaderoRegistro.getFechaEntrada(), modeloParqueaderoRegistro.getFechaSalida()));

			modeloParqueaderoRegistro.setCostoTotal(modeloParqueaderoRegistro.getCostoTotal() + 2000);
		} finally {
			// Registrar Salida y descontar vehiculo solo si el registro y la placa coinciden
			if (modeloParqueaderoRegistro != null) {
				servicioParqueaderoRegistro.insertar(modeloParqueaderoRegistro);
				ModeloParqueaderoEspacioDisponible modeloParqueaderoEspacioDisponible = servicioParqueaderoEspacioDisponible
						.obtenerEspacioDisponiblePorTipoVehiculo(
								modeloParqueaderoRegistro.getVehiculo().getTipoVehiculo().getId());
				modeloParqueaderoEspacioDisponible.disminuirEspacio();
				servicioParqueaderoEspacioDisponible.actualizar(modeloParqueaderoEspacioDisponible);
			}
		}
	}

}
