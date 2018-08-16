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
import com.ceiba.adnjulianhenao.repositorio.IRepositorioParqueaderoRegistro;

@Service("servicioParqueaderoRegistro")
public class ServicioParqueaderoRegistro {

	@Autowired
	@Qualifier("repositorioParqueaderoRegistro") // Inyecta el bean
	private IRepositorioParqueaderoRegistro iRepositorioParqueaderoRegistro;

	@Autowired
	@Qualifier("convertidorParqueaderoRegistro") // Inyecta el bean
	private ConvertidorParqueaderoRegistro convertidorParqueaderoRegistro;
	
	@Autowired
	@Qualifier("convertidorVehiculo") // Inyecta el bean
	private ConvertidorVehiculo convertidorVehiculo;
	
	private static final Logger log = LoggerFactory.getLogger(ServicioParqueaderoRegistro.class);

	public void crear(ModeloParqueaderoRegistro modeloParqueaderoRegistro) {
		log.info("Creando ParqueaderoRegistro");		
		iRepositorioParqueaderoRegistro.save(convertidorParqueaderoRegistro.convertirModeloAEntidad(modeloParqueaderoRegistro));
		log.info("El ParqueaderoRegistro se creó exitosamente");					
	}

	public void actualizar(ModeloParqueaderoRegistro modeloParqueaderoRegistro) {		
		if (iRepositorioParqueaderoRegistro.findById(modeloParqueaderoRegistro.getId()) != null) {
			iRepositorioParqueaderoRegistro.save(convertidorParqueaderoRegistro.convertirModeloAEntidad(modeloParqueaderoRegistro));		
		}		
	}

	public void borrar(int idParqueaderoRegistro) {		
		EntidadParqueaderoRegistro entidadParqueaderoRegistro = iRepositorioParqueaderoRegistro.findById(idParqueaderoRegistro);
		iRepositorioParqueaderoRegistro.delete(entidadParqueaderoRegistro);		
	}

	public List<ModeloParqueaderoRegistro> obtenerRegistros() {
		log.info("Listando ParqueaderoRegistros");
		return convertidorParqueaderoRegistro.convertirLista(iRepositorioParqueaderoRegistro.findAll());
	}

	public ModeloParqueaderoRegistro obtenerPorId(int idParqueaderoRegistro) {
		return convertidorParqueaderoRegistro.convertirEntidadAModelo(iRepositorioParqueaderoRegistro.findById(idParqueaderoRegistro));
	}

	public List<ModeloParqueaderoRegistro> obtenerRegistrosPorVehiculo(int idVehiculo) {
		return convertidorParqueaderoRegistro.convertirLista(iRepositorioParqueaderoRegistro.findByVehiculoId(idVehiculo));
	}
	
	public List<ModeloParqueaderoRegistro> obtenerRegistrosPorVehiculosSinSalir(Date fechaEntrada){
		return convertidorParqueaderoRegistro.convertirLista(iRepositorioParqueaderoRegistro.findByFechaEntradaAndFechaSalidaIsNull(fechaEntrada));
	}		
	
	public List<ModeloParqueaderoRegistro> obtenerRegistrosPorPaginacion(Pageable pageable) {
		return convertidorParqueaderoRegistro.convertirLista(iRepositorioParqueaderoRegistro.findAll(pageable).getContent());
	}

	public ModeloParqueaderoRegistro obtenerRegistrosPorVehiculosPorPlacaSinSalir(String placa) {
		return convertidorParqueaderoRegistro.convertirEntidadAModelo(iRepositorioParqueaderoRegistro.findByPlacaAndFechaSalidaIsNull(placa));
	}	
}
