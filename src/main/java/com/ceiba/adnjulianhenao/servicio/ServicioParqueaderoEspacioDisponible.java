package com.ceiba.adnjulianhenao.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Service;

import com.ceiba.adnjulianhenao.convertidor.ConvertidorParqueaderoEspacioDisponible;
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

	public void crear(ModeloParqueaderoEspacioDisponible modeloParqueaderoEspacioDisponible) {
		irepositorioParquederoEspacioDisponible
				.save(convertidorParquederoEspacioDisponible.convertirModeloAEntidad(modeloParqueaderoEspacioDisponible));
	}

	
	public void actualizar(ModeloParqueaderoEspacioDisponible modeloParqueaderoEspacioDisponible) {
		if (irepositorioParquederoEspacioDisponible.findById(modeloParqueaderoEspacioDisponible.getId()) != null) {
			irepositorioParquederoEspacioDisponible.save(
					convertidorParquederoEspacioDisponible.convertirModeloAEntidad(modeloParqueaderoEspacioDisponible));
		}
	}


	public ModeloParqueaderoEspacioDisponible obtenerEspacioDisponiblePorTipoVehiculo(int idTipoVehiculo) {
		return convertidorParquederoEspacioDisponible
				.convertirEntidadAModelo(irepositorioParquederoEspacioDisponible.findByTipoVehiculoId(idTipoVehiculo));
	}

}
