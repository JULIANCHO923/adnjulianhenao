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
import com.ceiba.adnjulianhenao.repositorio.IRepositorioParqueaderoEspacioDisponible;

@Service("servicioParqueaderoEspacioDisponible")
public class ServicioParqueaderoEspacioDisponible {
	
	@Autowired
	@Qualifier("repositorioParqueaderoEspacioDisponible")
	private IRepositorioParqueaderoEspacioDisponible irepositorioParquederoEspacioDisponible;

	@Autowired
	@Qualifier("convertidorParqueaderoEspacioDisponible") 
	private ConvertidorParqueaderoEspacioDisponible convertidorParquederoEspacioDisponible;

	private static final Logger log = LoggerFactory.getLogger(ServicioParqueaderoEspacioDisponible.class);

	public void crear(ModeloParqueaderoEspacioDisponible modeloParqueaderoEspacioDisponible) {
		log.info("Creando Espacio");
		irepositorioParquederoEspacioDisponible
				.save(convertidorParquederoEspacioDisponible.convertirModeloAEntidad(modeloParqueaderoEspacioDisponible));
		log.info("El espacio se creó exitosamente");
	}

	public void crear(List<ModeloParqueaderoEspacioDisponible> modeloParqueaderoEspacioDisponibles) {
		log.info("Creando Espacios");
		irepositorioParquederoEspacioDisponible
				.saveAll(convertidorParquederoEspacioDisponible.convertirLista2(modeloParqueaderoEspacioDisponibles));
		log.info("Los espacios se crearon exitosamente");
	}
	
	public void actualizar(ModeloParqueaderoEspacioDisponible modeloParqueaderoEspacioDisponible) {
		if (irepositorioParquederoEspacioDisponible.findById(modeloParqueaderoEspacioDisponible.getId()) != null) {
			irepositorioParquederoEspacioDisponible.save(
					convertidorParquederoEspacioDisponible.convertirModeloAEntidad(modeloParqueaderoEspacioDisponible));
		}
	}

	public void borrar(int id) {
		EntidadParqueaderoEspacioDisponible tarifa = irepositorioParquederoEspacioDisponible.findById(id);
		irepositorioParquederoEspacioDisponible.delete(tarifa);
	}

	public List<ModeloParqueaderoEspacioDisponible> obtenerTarifas() {
		log.info("Listando Espacios");
		return convertidorParquederoEspacioDisponible.convertirLista(irepositorioParquederoEspacioDisponible.findAll());
	}

	public ModeloParqueaderoEspacioDisponible obtenerporId(int id) {
		return convertidorParquederoEspacioDisponible
				.convertirEntidadAModelo(irepositorioParquederoEspacioDisponible.findById(id));
	}

	public ModeloParqueaderoEspacioDisponible obtenerEspacioDisponiblePorTipoVehiculo(int idTipoVehiculo) {
		log.info("Listando Tarifas por tipo vehiculo");
		return convertidorParquederoEspacioDisponible
				.convertirEntidadAModelo(irepositorioParquederoEspacioDisponible.findByTipoVehiculoId(idTipoVehiculo));
	}

}
