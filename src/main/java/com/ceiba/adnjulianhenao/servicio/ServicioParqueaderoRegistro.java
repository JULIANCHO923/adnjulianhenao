package com.ceiba.adnjulianhenao.servicio;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ceiba.adnjulianhenao.convertidor.ConvertidorParqueaderoRegistro;
import com.ceiba.adnjulianhenao.entidad.EntidadParqueaderoRegistro;
import com.ceiba.adnjulianhenao.modelo.ModeloParqueaderoRegistro;
import com.ceiba.adnjulianhenao.repositorio.IRepositorioParqueaderoRegistro;

@Service("servicioParqueaderoRegistro")
public class ServicioParqueaderoRegistro {
	 
	@Autowired
	@Qualifier("repositorioParqueaderoRegistro")
	private IRepositorioParqueaderoRegistro iRepositorioParqueaderoRegistro;

	@Autowired
	private ConvertidorParqueaderoRegistro convertidorParqueaderoRegistro;
	
	private static final Logger log = LoggerFactory.getLogger(ServicioParqueaderoRegistro.class);

	public void insertar(ModeloParqueaderoRegistro modeloParqueaderoRegistro) {
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

	public List<ModeloParqueaderoRegistro> obtenerRegistros(Pageable pageable) {
		return convertidorParqueaderoRegistro.convertirLista(iRepositorioParqueaderoRegistro.findAll(pageable).getContent());
	}

	public ModeloParqueaderoRegistro obtenerRegistroPoId(int id) {
		log.info("Listando Parqueadero Registros por ID");
		return convertidorParqueaderoRegistro.convertirEntidadAModelo(iRepositorioParqueaderoRegistro.findById(id));
	}
	
	public List<ModeloParqueaderoRegistro> obtenerRegistros() {
		log.info("Listando todos los registros del Parqueadero");
		return convertidorParqueaderoRegistro.convertirLista(iRepositorioParqueaderoRegistro.findAll());
	}
	
	public List<ModeloParqueaderoRegistro> obtenerRegistrosAnteriores() {
		log.info("Listando los Registros del parqueadero que ya salieron");
		return convertidorParqueaderoRegistro.convertirLista(iRepositorioParqueaderoRegistro.findByFechaSalidaIsNotNull());
	}
	
	public List<ModeloParqueaderoRegistro> obtenerRegistrosPorTipoVehiculoSinSalir(int idTipoVehiculo) {
		log.info("Listando los Registros del parqueadero según el tipo de dato");
		return convertidorParqueaderoRegistro.convertirLista(iRepositorioParqueaderoRegistro.findByVehiculoTipoVehiculoIdAndFechaSalidaIsNull(idTipoVehiculo));
	}
	
	public ModeloParqueaderoRegistro obtenerPorId(int idParqueaderoRegistro) {
		return convertidorParqueaderoRegistro.convertirEntidadAModelo(iRepositorioParqueaderoRegistro.findById(idParqueaderoRegistro));
	}

	public List<ModeloParqueaderoRegistro> obtenerRegistrosPorVehiculo(int idVehiculo) {
		return convertidorParqueaderoRegistro.convertirLista(iRepositorioParqueaderoRegistro.findByVehiculoId(idVehiculo));
	}		
	
	public List<ModeloParqueaderoRegistro> obtenerRegistrosPorPaginacion(Pageable pageable) {
		return convertidorParqueaderoRegistro.convertirLista(iRepositorioParqueaderoRegistro.findAll(pageable).getContent());
	}

	public ModeloParqueaderoRegistro obtenerRegistrosPorVehiculosPorIdSinSalir(int id) {
		EntidadParqueaderoRegistro entidadParqueaderoRegistro = iRepositorioParqueaderoRegistro.findByVehiculoIdAndFechaSalidaIsNull(id);
		if(entidadParqueaderoRegistro == null){
			return null;
		}else{
			return convertidorParqueaderoRegistro.convertirEntidadAModelo(entidadParqueaderoRegistro);
		}
	}
	
	public ModeloParqueaderoRegistro obtenerRegistroPorIdYPorPlacaSinSalir(int id, String placa) {	
		EntidadParqueaderoRegistro entidadParqueaderoRegistro = iRepositorioParqueaderoRegistro.findByIdAndVehiculoPlacaAndFechaSalidaIsNull(id, placa);
		if(entidadParqueaderoRegistro == null){
			return null;
		}else{
			return convertidorParqueaderoRegistro.convertirEntidadAModelo(entidadParqueaderoRegistro);
		}
	}
		
}
