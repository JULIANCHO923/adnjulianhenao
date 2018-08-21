package com.ceiba.adnjulianhenao.convertidor;

import org.springframework.stereotype.Component;

import com.ceiba.adnjulianhenao.entidad.EntidadParqueaderoEspacioDisponible;
import com.ceiba.adnjulianhenao.modelo.ModeloParqueaderoEspacioDisponible;

@Component("convertidorParqueaderoEspacioDisponible")
public class ConvertidorParqueaderoEspacioDisponible {	

	public ModeloParqueaderoEspacioDisponible convertirEntidadAModelo(EntidadParqueaderoEspacioDisponible entidadParqueaderoEspacioDisponible) {
		ModeloParqueaderoEspacioDisponible modeloParqueaderoEspacioDisponible = new ModeloParqueaderoEspacioDisponible();
		ConvertidorTipoVehiculo convertidorTipoVehiculo = new ConvertidorTipoVehiculo();		
		modeloParqueaderoEspacioDisponible.setId(entidadParqueaderoEspacioDisponible.getId());		
		modeloParqueaderoEspacioDisponible.setTipoVehiculo(convertidorTipoVehiculo.convertirEntidadAModelo(entidadParqueaderoEspacioDisponible.getTipoVehiculo()));
		modeloParqueaderoEspacioDisponible.setLimiteEspacio(entidadParqueaderoEspacioDisponible.getLimiteEspacio());
		modeloParqueaderoEspacioDisponible.setEspacioActual(entidadParqueaderoEspacioDisponible.getEspacioActual());	
		return modeloParqueaderoEspacioDisponible;
	}

	public EntidadParqueaderoEspacioDisponible convertirModeloAEntidad(ModeloParqueaderoEspacioDisponible modeloParqueaderoEspacioDisponible) {
		EntidadParqueaderoEspacioDisponible entidadParqueaderoEspacioDisponible = new EntidadParqueaderoEspacioDisponible();
		ConvertidorTipoVehiculo convertidorTipoVehiculo = new ConvertidorTipoVehiculo();		
		entidadParqueaderoEspacioDisponible.setId(modeloParqueaderoEspacioDisponible.getId());		
		entidadParqueaderoEspacioDisponible.setTipoVehiculo(convertidorTipoVehiculo.convertirModeloAEntidad(modeloParqueaderoEspacioDisponible.getTipoVehiculo()));
		entidadParqueaderoEspacioDisponible.setLimiteEspacio(modeloParqueaderoEspacioDisponible.getLimiteEspacio());
		entidadParqueaderoEspacioDisponible.setEspacioActual(modeloParqueaderoEspacioDisponible.getEspacioActual());
		return entidadParqueaderoEspacioDisponible;
	}
	
}
