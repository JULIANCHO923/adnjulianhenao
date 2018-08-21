package com.ceiba.adnjulianhenao.servicio;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Service;

import com.ceiba.adnjulianhenao.convertidor.ConvertidorTipoVehiculo;
import com.ceiba.adnjulianhenao.modelo.ModeloTipoVehiculo;
import com.ceiba.adnjulianhenao.repositorio.IRepositorioTipoVehiculo;

@Service("servicioTipoVehiculo")
public class ServicioTipoVehiculo {

	 
	@Autowired
	@Qualifier("repositorioTipoVehiculo")
	private IRepositorioTipoVehiculo iRepositorioTipoVehiculo;

	@Autowired
	@Qualifier("convertidorTipoVehiculo") 
	private ConvertidorTipoVehiculo convertidorTipoVehiculo;

	private static final Logger log = LoggerFactory.getLogger(ServicioTipoVehiculo.class);

	public void crear(ModeloTipoVehiculo modeloTipoVehiculo) {
		log.info("Creando Tipo Vehiculo");
		iRepositorioTipoVehiculo.save(convertidorTipoVehiculo.convertirModeloAEntidad(modeloTipoVehiculo));
		log.info("El Tipo vehiculo se creó exitosamente");
	}

	public List<ModeloTipoVehiculo> obtenerTipoVehiculos() {
		log.info("Listando Tipos de Vehiculos");
		return convertidorTipoVehiculo.convertirLista(iRepositorioTipoVehiculo.findAll());
	}

	public ModeloTipoVehiculo obtenerporId(int idTipoVehiculo) {
		return convertidorTipoVehiculo.convertirEntidadAModelo(iRepositorioTipoVehiculo.findById(idTipoVehiculo));
	}
}
