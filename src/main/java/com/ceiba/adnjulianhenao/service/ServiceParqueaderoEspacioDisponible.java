package com.ceiba.adnjulianhenao.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Service;

import com.ceiba.adnjulianhenao.converter.ConverterParqueaderoEspacioDisponible;

import com.ceiba.adnjulianhenao.entity.EntityParqueaderoEspacioDisponible;

import com.ceiba.adnjulianhenao.model.ModelParqueaderoEspacioDisponible;

import com.ceiba.adnjulianhenao.repository.IRepositoryParqueaderoEspacioDisponible;

@Service("servicioParqueaderoEspacioDisponible")
public class ServiceParqueaderoEspacioDisponible {

	@Autowired
	@Qualifier("repositorioParqueaderoEspacioDisponible") // Inyecta el bean
	private IRepositoryParqueaderoEspacioDisponible repositoryParquederoEspacioDisponible;

	@Autowired
	@Qualifier("convertidorParqueaderoEspacioDisponible") // Inyecta el bean
	private ConverterParqueaderoEspacioDisponible converterParquederoEspacioDisponible;

	private static final Logger log = LoggerFactory.getLogger(ServiceParqueaderoEspacioDisponible.class);

	public boolean crear(ModelParqueaderoEspacioDisponible modelParqueaderoEspacioDisponible) {
		log.info("Creando Espacio");
		try {
			repositoryParquederoEspacioDisponible.save(converterParquederoEspacioDisponible.convertirModeloAEntidad(modelParqueaderoEspacioDisponible));
			log.info("El espacio se creó exitosamente");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean actualizar(ModelParqueaderoEspacioDisponible modelParqueaderoEspacioDisponible) {
		try {
			if (repositoryParquederoEspacioDisponible.findById(modelParqueaderoEspacioDisponible.getId()) != null) {
				repositoryParquederoEspacioDisponible.save(converterParquederoEspacioDisponible.convertirModeloAEntidad(modelParqueaderoEspacioDisponible));
				return true;
			}
		} catch (Exception e) {
		}
		return false;
	}

	public boolean borrar(int id) {
		try {
			EntityParqueaderoEspacioDisponible tarifa = repositoryParquederoEspacioDisponible.findById(id);
			repositoryParquederoEspacioDisponible.delete(tarifa);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<ModelParqueaderoEspacioDisponible> obtenerTarifas() {
		log.info("Listando Espacios");
		return converterParquederoEspacioDisponible.convertirLista(repositoryParquederoEspacioDisponible.findAll());
	}

	public ModelParqueaderoEspacioDisponible obtenerporId(int id) {
		return converterParquederoEspacioDisponible.convertirEntidadAModelo(repositoryParquederoEspacioDisponible.findById(id));
	}

	public List<ModelParqueaderoEspacioDisponible> obtenerEspacioDisponiblePorTipoVehiculo(int idTipoVehiculo) {
		log.info("Listando Tarifas por tipo vehiculo");
		return converterParquederoEspacioDisponible.convertirLista(repositoryParquederoEspacioDisponible.findByTipoVehiculoId(idTipoVehiculo));
	}

}
