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
import com.ceiba.adnjulianhenao.repositorio.RepositorioParqueaderoTarifa;

@Service("servicioParqueaderoTarifa")
public class ServicioParqueaderoTarifa {

	@Autowired
	@Qualifier("repositorioParqueaderoTarifa") // Inyecta el bean
	private RepositorioParqueaderoTarifa repositorioParquederoTarifa;

	@Autowired
	@Qualifier("convertidorParqueaderoTarifa") // Inyecta el bean
	private ConvertidorParqueaderoTarifa converterParquederoTarifa;

	private static final Logger log = LoggerFactory.getLogger(ServicioParqueaderoTarifa.class);

	public void crear(ModeloParqueaderoTarifa modeloParqueaderoTarifa) {
		log.info("Creando Tarifa");
		try {
			repositorioParquederoTarifa.save(converterParquederoTarifa.convertirModeloAEntidad(modeloParqueaderoTarifa));
			log.info("La tarifa se creó exitosamente");			
		} catch (Exception e) {			
		}
	}

	public void actualizar(ModeloParqueaderoTarifa modeloParqueaderoTarifa) {
		try {
			if (repositorioParquederoTarifa.findById(modeloParqueaderoTarifa.getId()) != null) {
				repositorioParquederoTarifa
						.save(converterParquederoTarifa.convertirModeloAEntidad(modeloParqueaderoTarifa));				
			}
		} catch (Exception e) {
		}		
	}

	public void borrar(int id) {
		try {
			EntidadParqueaderoTarifa entidadParqueaderoTarifa = repositorioParquederoTarifa.findById(id);
			repositorioParquederoTarifa.delete(entidadParqueaderoTarifa);			
		} catch (Exception e) {			
		}
	}

	public List<ModeloParqueaderoTarifa> obtenerTarifas() {
		log.info("Listando Tarifas");
		return converterParquederoTarifa.convertirLista(repositorioParquederoTarifa.findAll());
	}

	public ModeloParqueaderoTarifa obtenerporId(int id) {
		return converterParquederoTarifa.convertirEntidadAModelo(repositorioParquederoTarifa.findById(id));
	}

	public List<ModeloParqueaderoTarifa> obtenerTarifasPorTipoVehiculo(int idTipoVehiculo) {
		log.info("Listando Tarifas por tipo vehiculo");
		return converterParquederoTarifa.convertirLista(repositorioParquederoTarifa.findByTipoVehiculoId(idTipoVehiculo));
	}

}
