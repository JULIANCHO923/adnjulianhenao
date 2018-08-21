package com.ceiba.adnjulianhenao.servicio;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ceiba.adnjulianhenao.convertidor.ConvertidorTipoVehiculo;
import com.ceiba.adnjulianhenao.convertidor.ConvertidorVehiculo;
import com.ceiba.adnjulianhenao.dominioparqueadero.Vigilante;
import com.ceiba.adnjulianhenao.entidad.EntidadVehiculo;
import com.ceiba.adnjulianhenao.modelo.ModeloVehiculo;
import com.ceiba.adnjulianhenao.repositorio.IRepositorioVehiculo;

@Service("servicioVehiculo")
public class ServicioVehiculo {

	@Autowired
	@Qualifier("repositorioVehiculo")
	private IRepositorioVehiculo iRepositorioVehiculo;

	@Autowired
	@Qualifier("convertidorVehiculo") 
	private ConvertidorVehiculo convertidorVehiculo;

	@Autowired
	@Qualifier("convertidorTipoVehiculo")
	private ConvertidorTipoVehiculo convertidorTipoVehiculo;

	@Autowired
	@Qualifier("vigilante")
	private Vigilante vigilante;

	private static final Logger log = LoggerFactory.getLogger(ServicioVehiculo.class);

	public void crear(ModeloVehiculo modeloVehiculo) {
		log.info("_Entrando a la validación por el vigilante ");
		vigilante.registrarEntrada(modeloVehiculo);
	}

	public void crear(List<ModeloVehiculo> modeloVehiculos) {
		log.info("Ingresando varios Vehiculos sin realizar validaciones");
		iRepositorioVehiculo.saveAll(convertidorVehiculo.convertirLista2(modeloVehiculos));
	}

	public void insertar(ModeloVehiculo modeloVehiculo) {
		log.info("Creando Vehiculo");
		iRepositorioVehiculo.save(convertidorVehiculo.convertirModeloAEntidad(modeloVehiculo));
		log.info("El vehiculo se creó exitosamente");
	}

	public void actualizar(ModeloVehiculo modeloVehiculo) {
		log.info("Actualizando vehiculo");
		// Faltaria validar que si el vehiculo no se encuentra en los registros
		if (iRepositorioVehiculo.findByPlaca(modeloVehiculo.getPlaca()) != null) {
			iRepositorioVehiculo.save(convertidorVehiculo.convertirModeloAEntidad(modeloVehiculo));
		}

	}

	public void generarSalidaVehiculo(int idRegistro, String placa) {
		log.info(".... Enlaza la salida");
		vigilante.registrarSalida(idRegistro, placa);
		log.info("Salida realizada exitosamente");
	}

	public List<ModeloVehiculo> obtenerVehiculos() {
		log.info("Listando Vehiculos");
		return convertidorVehiculo.convertirLista(iRepositorioVehiculo.findAll());
	}

	public ModeloVehiculo obtenerporId(int idVehiculo) {
		EntidadVehiculo entidadVehiculo = iRepositorioVehiculo.findById(idVehiculo);
		if (entidadVehiculo == null) {
			return null;
		} else {
			return convertidorVehiculo.convertirEntidadAModelo(entidadVehiculo);
		}
	}

	public ModeloVehiculo obtenerPorPlaca(String placa) {
		EntidadVehiculo entidadVehiculo = iRepositorioVehiculo.findByPlaca(placa);
		if (entidadVehiculo == null) {
			return null;
		} else {
			return convertidorVehiculo.convertirEntidadAModelo(entidadVehiculo);
		}
	}

	public List<ModeloVehiculo> obtenerPorTipoVehiculo(int idTipoVehiculo, Pageable pageable) {
		return convertidorVehiculo
				.convertirLista(iRepositorioVehiculo.findByTipoVehiculoId(idTipoVehiculo, pageable).getContent());
	}

	public List<ModeloVehiculo> obtenerPorCilindraje(int cilindraje) {
		return convertidorVehiculo.convertirLista(iRepositorioVehiculo.findByCilindraje(cilindraje));
	}

	public List<ModeloVehiculo> obtenerVehiculosPorPaginacion(Pageable pageable) {
		return convertidorVehiculo.convertirLista(iRepositorioVehiculo.findAll(pageable).getContent());
	}

}
