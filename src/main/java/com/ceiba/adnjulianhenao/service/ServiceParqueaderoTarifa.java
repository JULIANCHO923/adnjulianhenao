package com.ceiba.adnjulianhenao.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Service;

import com.ceiba.adnjulianhenao.converter.ConverterParqueaderoTarifa;

import com.ceiba.adnjulianhenao.entity.EntityParqueaderoTarifa;

import com.ceiba.adnjulianhenao.model.ModelParqueaderoTarifa;

import com.ceiba.adnjulianhenao.repository.IRepositoryParqueaderoTarifa;

@Service("servicioParqueaderoTarifa")
public class ServiceParqueaderoTarifa {

	@Autowired
	@Qualifier("repositorioParqueaderoTarifa") // Inyecta el bean
	private IRepositoryParqueaderoTarifa repositoryParquederoTarifa;

	@Autowired
	@Qualifier("convertidorParqueaderoTarifa") // Inyecta el bean
	private ConverterParqueaderoTarifa converterParquederoTarifa;

	private static final Logger log = LoggerFactory.getLogger(ServiceParqueaderoTarifa.class);

	public boolean crear(ModelParqueaderoTarifa modelParqueaderoTarifa) {
		log.info("Creando Tarifa");
		try {
			repositoryParquederoTarifa.save(converterParquederoTarifa.convertirModeloAEntidad(modelParqueaderoTarifa));
			log.info("La tarifa se creó exitosamente");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean actualizar(ModelParqueaderoTarifa modelParqueaderoTarifa) {
		try {
			if (repositoryParquederoTarifa.findById(modelParqueaderoTarifa.getId()) != null) {
				repositoryParquederoTarifa
						.save(converterParquederoTarifa.convertirModeloAEntidad(modelParqueaderoTarifa));
				return true;
			}
		} catch (Exception e) {
		}
		return false;
	}

	public boolean borrar(int id) {
		try {
			EntityParqueaderoTarifa entityParqueaderoTarifa = repositoryParquederoTarifa.findById(id);
			repositoryParquederoTarifa.delete(entityParqueaderoTarifa);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<ModelParqueaderoTarifa> obtenerTarifas() {
		log.info("Listando Tarifas");
		return converterParquederoTarifa.convertirLista(repositoryParquederoTarifa.findAll());
	}

	public ModelParqueaderoTarifa obtenerporId(int id) {
		return converterParquederoTarifa.convertirEntidadAModelo(repositoryParquederoTarifa.findById(id));
	}

	public List<ModelParqueaderoTarifa> obtenerTarifasPorTipoVehiculo(int idTipoVehiculo) {
		log.info("Listando Tarifas por tipo vehiculo");
		return converterParquederoTarifa.convertirLista(repositoryParquederoTarifa.findByTipoVehiculoId(idTipoVehiculo));
	}

}
