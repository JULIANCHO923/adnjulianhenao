package com.ceiba.adnjulianhenao.service;

import java.sql.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ceiba.adnjulianhenao.converter.ConverterParqueaderoRegistro;
import com.ceiba.adnjulianhenao.converter.ConverterVehiculo;
import com.ceiba.adnjulianhenao.entity.EntityParqueaderoRegistro;
import com.ceiba.adnjulianhenao.model.ModelParqueaderoRegistro;
import com.ceiba.adnjulianhenao.repository.IRepositoryParqueaderoRegistro;

@Service("servicioParqueaderoRegistro")
public class ServiceParqueaderoRegistro {

	@Autowired
	@Qualifier("repositorioParqueaderoRegistro") // Inyecta el bean
	private IRepositoryParqueaderoRegistro repositoryParqueaderoRegistro;

	@Autowired
	@Qualifier("convertidorParqueaderoRegistro") // Inyecta el bean
	private ConverterParqueaderoRegistro converterParqueaderoRegistro;

	
	@Autowired
	@Qualifier("convertidorVehiculo") // Inyecta el bean
	private ConverterVehiculo converterVehiculo;

	
	private static final Logger log = LoggerFactory.getLogger(ServiceParqueaderoRegistro.class);

	public boolean crear(ModelParqueaderoRegistro modelParqueaderoRegistro) {
		log.info("Creando ParqueaderoRegistro");
		try {
			repositoryParqueaderoRegistro.save(converterParqueaderoRegistro.convertirModeloAEntidad(modelParqueaderoRegistro));
			log.info("El ParqueaderoRegistro se creó exitosamente");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean actualizar(ModelParqueaderoRegistro modelParqueaderoRegistro) {
		try {
			if (repositoryParqueaderoRegistro.findById(modelParqueaderoRegistro.getId()) != null) {
				repositoryParqueaderoRegistro.save(converterParqueaderoRegistro.convertirModeloAEntidad(modelParqueaderoRegistro));
				return true;
			}
		} catch (Exception e) {
		}
		return false;
	}

	public boolean borrar(int idParqueaderoRegistro) {
		try {
			EntityParqueaderoRegistro entityParqueaderoRegistro = repositoryParqueaderoRegistro.findById(idParqueaderoRegistro);
			repositoryParqueaderoRegistro.delete(entityParqueaderoRegistro);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<ModelParqueaderoRegistro> obtenerParqueaderoRegistros() {
		log.info("Listando ParqueaderoRegistros");
		return converterParqueaderoRegistro.convertirLista(repositoryParqueaderoRegistro.findAll());
	}

	public ModelParqueaderoRegistro obtenerporId(int idParqueaderoRegistro) {
		return converterParqueaderoRegistro.convertirEntidadAModelo(repositoryParqueaderoRegistro.findById(idParqueaderoRegistro));
	}

	public List<ModelParqueaderoRegistro> obtenerRegistrosPorVehiculo(int idVehiculo) {
		return converterParqueaderoRegistro.convertirLista(repositoryParqueaderoRegistro.findByVehiculoId(idVehiculo));
	}
	
	public List<ModelParqueaderoRegistro> obtenerRegistrosPorVehiculosSinSalir(Date fechaEntrada){
		return converterParqueaderoRegistro.convertirLista(repositoryParqueaderoRegistro.findByFechaEntradaAndFechaSalidaIsNull(fechaEntrada));
	}		
	
	public List<ModelParqueaderoRegistro> obtenerRegistrosPorPaginacion(Pageable pageable) {
		return converterParqueaderoRegistro.convertirLista(repositoryParqueaderoRegistro.findAll(pageable).getContent());
	}

	public List<ModelParqueaderoRegistro> obtenerRegistrosPorVehiculosSinSalirPorPaginacion(Date fechaEntrada, Pageable pageable) {
		return converterParqueaderoRegistro.convertirLista(repositoryParqueaderoRegistro.findByFechaEntradaAndFechaSalidaIsNull(fechaEntrada, pageable).getContent());
	}
	
}
