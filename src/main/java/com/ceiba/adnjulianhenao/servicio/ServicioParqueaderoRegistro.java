package com.ceiba.adnjulianhenao.servicio;

import java.sql.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ceiba.adnjulianhenao.convertidor.ConvertidorParqueaderoRegistro;
import com.ceiba.adnjulianhenao.convertidor.ConvertidorVehiculo;
import com.ceiba.adnjulianhenao.entidad.EntidadParqueaderoRegistro;
import com.ceiba.adnjulianhenao.modelo.ModeloParqueaderoRegistro;
import com.ceiba.adnjulianhenao.repositorio.RepositorioParqueaderoRegistro;

@Service("servicioParqueaderoRegistro")
public class ServicioParqueaderoRegistro {

	@Autowired
	@Qualifier("repositorioParqueaderoRegistro") // Inyecta el bean
	private RepositorioParqueaderoRegistro repositorioParqueaderoRegistro;

	@Autowired
	@Qualifier("convertidorParqueaderoRegistro") // Inyecta el bean
	private ConvertidorParqueaderoRegistro convertidorParqueaderoRegistro;

	
	@Autowired
	@Qualifier("convertidorVehiculo") // Inyecta el bean
	private ConvertidorVehiculo convertidorVehiculo;

	
	private static final Logger log = LoggerFactory.getLogger(ServicioParqueaderoRegistro.class);

	public boolean crear(ModeloParqueaderoRegistro modeloParqueaderoRegistro) {
		log.info("Creando ParqueaderoRegistro");
		try {
			repositorioParqueaderoRegistro.save(convertidorParqueaderoRegistro.convertirModeloAEntidad(modeloParqueaderoRegistro));
			log.info("El ParqueaderoRegistro se creó exitosamente");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean actualizar(ModeloParqueaderoRegistro modeloParqueaderoRegistro) {
		try {
			if (repositorioParqueaderoRegistro.findById(modeloParqueaderoRegistro.getId()) != null) {
				repositorioParqueaderoRegistro.save(convertidorParqueaderoRegistro.convertirModeloAEntidad(modeloParqueaderoRegistro));
				return true;
			}
		} catch (Exception e) {
		}
		return false;
	}

	public boolean borrar(int idParqueaderoRegistro) {
		try {
			EntidadParqueaderoRegistro entidadParqueaderoRegistro = repositorioParqueaderoRegistro.findById(idParqueaderoRegistro);
			repositorioParqueaderoRegistro.delete(entidadParqueaderoRegistro);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<ModeloParqueaderoRegistro> obtenerRegistros() {
		log.info("Listando ParqueaderoRegistros");
		return convertidorParqueaderoRegistro.convertirLista(repositorioParqueaderoRegistro.findAll());
	}

	public ModeloParqueaderoRegistro obtenerPorId(int idParqueaderoRegistro) {
		return convertidorParqueaderoRegistro.convertirEntidadAModelo(repositorioParqueaderoRegistro.findById(idParqueaderoRegistro));
	}

	public List<ModeloParqueaderoRegistro> obtenerRegistrosPorVehiculo(int idVehiculo) {
		return convertidorParqueaderoRegistro.convertirLista(repositorioParqueaderoRegistro.findByVehiculoId(idVehiculo));
	}
	
	public List<ModeloParqueaderoRegistro> obtenerRegistrosPorVehiculosSinSalir(Date fechaEntrada){
		return convertidorParqueaderoRegistro.convertirLista(repositorioParqueaderoRegistro.findByFechaEntradaAndFechaSalidaIsNull(fechaEntrada));
	}		
	
	public List<ModeloParqueaderoRegistro> obtenerRegistrosPorPaginacion(Pageable pageable) {
		return convertidorParqueaderoRegistro.convertirLista(repositorioParqueaderoRegistro.findAll(pageable).getContent());
	}

	public List<ModeloParqueaderoRegistro> obtenerRegistrosPorVehiculosSinSalirPorPaginacion(Date fechaEntrada, Pageable pageable) {
		return convertidorParqueaderoRegistro.convertirLista(repositorioParqueaderoRegistro.findByFechaEntradaAndFechaSalidaIsNull(fechaEntrada, pageable).getContent());
	}
	
}
