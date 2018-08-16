package com.ceiba.adnjulianhenao.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ceiba.adnjulianhenao.converter.ConverterTipoVehiculo;
import com.ceiba.adnjulianhenao.converter.ConverterVehiculo;

import com.ceiba.adnjulianhenao.entity.EntityVehiculo;
import com.ceiba.adnjulianhenao.model.ModelVehiculo;
import com.ceiba.adnjulianhenao.repository.IRepositoryVehiculo;

@Service("servicioVehiculo")
public class ServiceVehiculo {

	@Autowired
	@Qualifier("repositorioVehiculo") // Inyecta el bean
	private IRepositoryVehiculo repositoryVehiculo;

	@Autowired
	@Qualifier("convertidorVehiculo") // Inyecta el bean
	private ConverterVehiculo converterVehiculo;

	
	@Autowired
	@Qualifier("convertidorTipoVehiculo") // Inyecta el bean
	private ConverterTipoVehiculo converterTipoVehiculo;

	
	private static final Logger log = LoggerFactory.getLogger(ServiceVehiculo.class);

	public boolean crear(ModelVehiculo modelVehiculo) {
		log.info("Creando Vehiculo");
		try {
			repositoryVehiculo.save(converterVehiculo.convertirModeloAEntidad(modelVehiculo));
			log.info("El vehiculo se creó exitosamente");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean actualizar(ModelVehiculo modelVehiculo) {
		try {
			if (repositoryVehiculo.findById(modelVehiculo.getId()) != null) {
				repositoryVehiculo.save(converterVehiculo.convertirModeloAEntidad(modelVehiculo));
				return true;
			}
		} catch (Exception e) {
		}
		return false;
	}

	public boolean borrar(int idVehiculo) {
		try {
			EntityVehiculo entityVehiculo = repositoryVehiculo.findById(idVehiculo);
			repositoryVehiculo.delete(entityVehiculo);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<ModelVehiculo> obtenerVehiculos() {
		log.info("Listando Vehiculos");
		return converterVehiculo.convertirLista(repositoryVehiculo.findAll());
	}

	public ModelVehiculo obtenerporId(int idVehiculo) {
		return converterVehiculo.convertirEntidadAModelo(repositoryVehiculo.findById(idVehiculo));
	}

	public List<ModelVehiculo> obtenerPorPlaca(String placa) {
		return converterVehiculo.convertirLista(repositoryVehiculo.findByPlaca(placa));
	}
	
	public List<ModelVehiculo> obtenerPorTipoVehiculo(int idTipoVehiculo){
		return converterVehiculo.convertirLista(repositoryVehiculo.findByTipoVehiculoId(idTipoVehiculo));
	}
	

	/*
	 * public List<Vehiculo> obtenerPorIdTipoVehiculo(EntityTipoVehiculo
	 * tipoVehiculo){ return
	 * converterVehiculo.convertirLista(repositoryVehiculo.findByTipoVehiculo(
	 * tipoVehiculo)); }
	 */

	public List<ModelVehiculo> obtenerPorCilindraje(int cilindraje) {
		return converterVehiculo.convertirLista(repositoryVehiculo.findByCilindraje(cilindraje));
	}

	public List<ModelVehiculo> obtenerVehiculosPorPaginacion(Pageable pageable) {
		return converterVehiculo.convertirLista(repositoryVehiculo.findAll(pageable).getContent());
	}

}
