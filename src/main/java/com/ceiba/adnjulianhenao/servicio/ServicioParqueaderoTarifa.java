package com.ceiba.adnjulianhenao.servicio;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Service;

import com.ceiba.adnjulianhenao.convertidor.ConvertidorParqueaderoTarifa;
import com.ceiba.adnjulianhenao.entidad.EntidadParqueaderoTarifa;
import com.ceiba.adnjulianhenao.modelo.ModeloParqueaderoTarifa;
import com.ceiba.adnjulianhenao.repositorio.IRepositorioParqueaderoTarifa;

@Service("servicioParqueaderoTarifa")
public class ServicioParqueaderoTarifa {

	@Autowired
	@Qualifier("repositorioParqueaderoTarifa") 
	private IRepositorioParqueaderoTarifa repositorioParquederoTarifa;

	@Autowired
	@Qualifier("convertidorParqueaderoTarifa") 
	private ConvertidorParqueaderoTarifa converterParquederoTarifa;

	private static final Logger log = LoggerFactory.getLogger(ServicioParqueaderoTarifa.class);

	public void crear(ModeloParqueaderoTarifa modeloParqueaderoTarifa) {
		log.info("Creando Tarifa");
		repositorioParquederoTarifa.save(converterParquederoTarifa.convertirModeloAEntidad(modeloParqueaderoTarifa));
		log.info("La tarifa se creó exitosamente");
	}

	public void actualizar(ModeloParqueaderoTarifa modeloParqueaderoTarifa) {
		if (repositorioParquederoTarifa.findById(modeloParqueaderoTarifa.getId()) != null) {
			repositorioParquederoTarifa
					.save(converterParquederoTarifa.convertirModeloAEntidad(modeloParqueaderoTarifa));
		}
	}

	public void borrar(int id) {
		EntidadParqueaderoTarifa entidadParqueaderoTarifa = repositorioParquederoTarifa.findById(id);
		repositorioParquederoTarifa.delete(entidadParqueaderoTarifa);
	}

	public List<ModeloParqueaderoTarifa> obtenerTarifas() {
		log.info("Listando Tarifas");
		return converterParquederoTarifa.convertirLista(repositorioParquederoTarifa.findAll());
	}

	public ModeloParqueaderoTarifa obtenerporId(int id) {
		return converterParquederoTarifa.convertirEntidadAModelo(repositorioParquederoTarifa.findById(id));
	}

	public ModeloParqueaderoTarifa obtenerTarifasPorTipoVehiculo(int idTipoVehiculo) {
		log.info("Listando Tarifas por tipo vehiculo");
		return converterParquederoTarifa
				.convertirEntidadAModelo(repositorioParquederoTarifa.findByTipoVehiculoId(idTipoVehiculo));
	}

}
