package com.ceiba.adnjulianhenao.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ceiba.adnjulianhenao.converter.ConverterVehiculo;
//import com.ceiba.adnjulianhenao.entity.EntityTipoVehiculo;
import com.ceiba.adnjulianhenao.entity.EntityVehiculo;
import com.ceiba.adnjulianhenao.model.Vehiculo;
import com.ceiba.adnjulianhenao.repository.IRepositoryVehiculo;

@Service("servicioVehiculo")
public class ServiceVehiculo {

	@Autowired
	@Qualifier("repositorioVehiculo") // Inyecta el bean
	private IRepositoryVehiculo repositoryVehiculo;

	@Autowired
	@Qualifier("convertidorVehiculo") // Inyecta el bean
	private ConverterVehiculo converterVehiculo;

	private static final Logger log = LoggerFactory.getLogger(ServiceTipoVehiculo.class);

	public boolean crear(Vehiculo vehiculo) {
		log.info("Creando Vehiculo");
		try {
			repositoryVehiculo.save(converterVehiculo.convertirModeloAEntidad(vehiculo));
			log.info("El vehiculo se creó exitosamente");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean actualizar(EntityVehiculo vehiculo) {
		try {
			if (repositoryVehiculo.findById(vehiculo.getId()) != null) {
				repositoryVehiculo.save(vehiculo);
				return true;
			}
		} catch (Exception e) {
		}
		return false;
	}

	public boolean borrar(int idVehiculo) {
		try {
			EntityVehiculo vehiculo = repositoryVehiculo.findById(idVehiculo);
			repositoryVehiculo.delete(vehiculo);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<Vehiculo> obtenerVehiculos() {
		log.info("Listando Vehiculos");
		return converterVehiculo.convertirLista(repositoryVehiculo.findAll());
	}

	public Vehiculo obtenerporId(int idVehiculo) {
		return converterVehiculo.convertirEntidadAModelo(repositoryVehiculo.findById(idVehiculo));
	}

	public List<Vehiculo> obtenerPorPlaca(String placa) {
		return converterVehiculo.convertirLista(repositoryVehiculo.findByPlaca(placa));
	}

	/*
	 * public List<Vehiculo> obtenerPorIdTipoVehiculo(EntityTipoVehiculo
	 * tipoVehiculo){ return
	 * converterVehiculo.convertirLista(repositoryVehiculo.findByTipoVehiculo(
	 * tipoVehiculo)); }
	 */

	public List<Vehiculo> obtenerPorCilindraje(int cilindraje) {
		return converterVehiculo.convertirLista(repositoryVehiculo.findByCilindraje(cilindraje));
	}

	public List<Vehiculo> obtenerVehiculosPorPaginacion(Pageable pageable) {
		return converterVehiculo.convertirLista(repositoryVehiculo.findAll(pageable).getContent());
	}

}
