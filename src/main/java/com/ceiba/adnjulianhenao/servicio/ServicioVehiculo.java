package com.ceiba.adnjulianhenao.servicio;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ceiba.adnjulianhenao.convertidor.ConvertidorTipoVehiculo;
import com.ceiba.adnjulianhenao.convertidor.ConvertidorVehiculo;
import com.ceiba.adnjulianhenao.entidad.EntidadVehiculo;
import com.ceiba.adnjulianhenao.modelo.ModeloVehiculo;
import com.ceiba.adnjulianhenao.parqueadero.Vigilante;
import com.ceiba.adnjulianhenao.repositorio.RepositorioVehiculo;

@Service("servicioVehiculo")
public class ServicioVehiculo {

	@Autowired
	@Qualifier("repositorioVehiculo") // Inyecta el bean
	private RepositorioVehiculo repositorioVehiculo;

	@Autowired
	@Qualifier("convertidorVehiculo") // Inyecta el bean
	private ConvertidorVehiculo convertidorVehiculo;

	
	@Autowired
	@Qualifier("convertidorTipoVehiculo") // Inyecta el bean
	private ConvertidorTipoVehiculo convertidorTipoVehiculo;

	
	@Autowired
	private Vigilante vigilante;
	
	private static final Logger log = LoggerFactory.getLogger(ServicioVehiculo.class);

	public void crear(ModeloVehiculo modeloVehiculo) {
		log.info("Creando Vehiculo");
		try {
			
			repositorioVehiculo.save(convertidorVehiculo.convertirModeloAEntidad(modeloVehiculo));
			log.info("El vehiculo se creó exitosamente");
			
		} catch (Exception e) {
			
		}
	}

	public void actualizar(ModeloVehiculo modeloVehiculo) {
		try {
			if (repositorioVehiculo.findById(modeloVehiculo.getId()) != null) {
				repositorioVehiculo.save(convertidorVehiculo.convertirModeloAEntidad(modeloVehiculo));
				
			}
		} catch (Exception e) {
		}
		
	}

	public void borrar(int idVehiculo) {
		try {
			EntidadVehiculo entidadVehiculo = repositorioVehiculo.findById(idVehiculo);
			repositorioVehiculo.delete(entidadVehiculo);
			
		} catch (Exception e) {
			
		}
	}

	public List<ModeloVehiculo> obtenerVehiculos() {
		log.info("Listando Vehiculos");
		return convertidorVehiculo.convertirLista(repositorioVehiculo.findAll());
	}

	public ModeloVehiculo obtenerporId(int idVehiculo) {
		return convertidorVehiculo.convertirEntidadAModelo(repositorioVehiculo.findById(idVehiculo));
	}

	public List<ModeloVehiculo> obtenerPorPlaca(String placa) {
		return convertidorVehiculo.convertirLista(repositorioVehiculo.findByPlaca(placa));
	}
	
	public List<ModeloVehiculo> obtenerPorTipoVehiculo(int idTipoVehiculo){
		return convertidorVehiculo.convertirLista(repositorioVehiculo.findByTipoVehiculoId(idTipoVehiculo));
	}
	

	/*
	 * public List<Vehiculo> obtenerPorIdTipoVehiculo(EntityTipoVehiculo
	 * tipoVehiculo){ return
	 * converterVehiculo.convertirLista(repositoryVehiculo.findByTipoVehiculo(
	 * tipoVehiculo)); }
	 */

	public List<ModeloVehiculo> obtenerPorCilindraje(int cilindraje) {
		return convertidorVehiculo.convertirLista(repositorioVehiculo.findByCilindraje(cilindraje));
	}

	public List<ModeloVehiculo> obtenerVehiculosPorPaginacion(Pageable pageable) {
		return convertidorVehiculo.convertirLista(repositorioVehiculo.findAll(pageable).getContent());
	}

}
