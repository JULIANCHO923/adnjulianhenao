package com.ceiba.adnjulianhenao.servicio;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Service;

import com.ceiba.adnjulianhenao.convertidor.ConvertidorParqueaderoEspacioDisponible;
import com.ceiba.adnjulianhenao.entidad.EntidadParqueaderoEspacioDisponible;
import com.ceiba.adnjulianhenao.modelo.ModeloParqueaderoEspacioDisponible;
import com.ceiba.adnjulianhenao.repositorio.RepositorioParqueaderoEspacioDisponible;

@Service("servicioParqueaderoEspacioDisponible")
public class ServicioParqueaderoEspacioDisponible {

	@Autowired
	@Qualifier("repositorioParqueaderoEspacioDisponible") // Inyecta el bean
	private RepositorioParqueaderoEspacioDisponible repositorioParquederoEspacioDisponible;

	@Autowired
	@Qualifier("convertidorParqueaderoEspacioDisponible") // Inyecta el bean
	private ConvertidorParqueaderoEspacioDisponible converterParquederoEspacioDisponible;

	private static final Logger log = LoggerFactory.getLogger(ServicioParqueaderoEspacioDisponible.class);

	public void crear(ModeloParqueaderoEspacioDisponible modeloParqueaderoEspacioDisponible) {
		log.info("Creando Espacio");
		try {
			repositorioParquederoEspacioDisponible.save(converterParquederoEspacioDisponible.convertirModeloAEntidad(modeloParqueaderoEspacioDisponible));
			log.info("El espacio se creó exitosamente");			
		} catch (Exception e) {			
		}
	}

	public void actualizar(ModeloParqueaderoEspacioDisponible modeloParqueaderoEspacioDisponible) {
		try {
			if (repositorioParquederoEspacioDisponible.findById(modeloParqueaderoEspacioDisponible.getId()) != null) {
				repositorioParquederoEspacioDisponible.save(converterParquederoEspacioDisponible.convertirModeloAEntidad(modeloParqueaderoEspacioDisponible));
			
			}
		} catch (Exception e) {
		}
		
	}

	public void borrar(int id) {
		try {
			EntidadParqueaderoEspacioDisponible tarifa = repositorioParquederoEspacioDisponible.findById(id);
			repositorioParquederoEspacioDisponible.delete(tarifa);
			
		} catch (Exception e) {
			
		}
	}

	public List<ModeloParqueaderoEspacioDisponible> obtenerTarifas() {
		log.info("Listando Espacios");
		return converterParquederoEspacioDisponible.convertirLista(repositorioParquederoEspacioDisponible.findAll());
	}

	public ModeloParqueaderoEspacioDisponible obtenerporId(int id) {
		return converterParquederoEspacioDisponible.convertirEntidadAModelo(repositorioParquederoEspacioDisponible.findById(id));
	}

	public ModeloParqueaderoEspacioDisponible obtenerEspacioDisponiblePorTipoVehiculo(int idTipoVehiculo) {
		log.info("Listando Tarifas por tipo vehiculo");
		return converterParquederoEspacioDisponible.convertirEntidadAModelo(repositorioParquederoEspacioDisponible.findByTipoVehiculoId(idTipoVehiculo));
	}

}
