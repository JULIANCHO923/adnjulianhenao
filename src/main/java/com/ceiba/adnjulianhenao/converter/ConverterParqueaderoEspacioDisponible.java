package com.ceiba.adnjulianhenao.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.adnjulianhenao.entity.EntityParqueaderoEspacioDisponible;
import com.ceiba.adnjulianhenao.model.ModelParqueaderoEspacioDisponible;

@Component("convertidorParqueaderoEspacioDisponible")
public class ConverterParqueaderoEspacioDisponible {
	
	public List<ModelParqueaderoEspacioDisponible> convertirLista(List<EntityParqueaderoEspacioDisponible> entityParqueaderoEspaciosDisponible) {
		List<ModelParqueaderoEspacioDisponible> parqueaderoEspacioDisponible = new ArrayList<>();
		for (EntityParqueaderoEspacioDisponible ParqueaderoEspacioDisponible : entityParqueaderoEspaciosDisponible) {
			parqueaderoEspacioDisponible.add(convertirEntidadAModelo(ParqueaderoEspacioDisponible));
		}
		return parqueaderoEspacioDisponible;		
	}

	public ModelParqueaderoEspacioDisponible convertirEntidadAModelo(EntityParqueaderoEspacioDisponible entityParqueaderoEspacioDisponible) {
		ModelParqueaderoEspacioDisponible modelParqueaderoEspacioDisponible = new ModelParqueaderoEspacioDisponible();
		ConverterTipoVehiculo converterTipoVehiculo = new ConverterTipoVehiculo();		
		modelParqueaderoEspacioDisponible.setId(entityParqueaderoEspacioDisponible.getId());		
		modelParqueaderoEspacioDisponible.setTipoVehiculo(converterTipoVehiculo.convertirEntidadAModelo(entityParqueaderoEspacioDisponible.getTipoVehiculo()));
		modelParqueaderoEspacioDisponible.setCantidadEspacio(entityParqueaderoEspacioDisponible.getCantidadEspacio());	
		return modelParqueaderoEspacioDisponible;
	}

	public EntityParqueaderoEspacioDisponible convertirModeloAEntidad(ModelParqueaderoEspacioDisponible modelParqueaderoEspacioDisponible) {
		EntityParqueaderoEspacioDisponible entityParqueaderoEspacioDisponible = new EntityParqueaderoEspacioDisponible();
		ConverterTipoVehiculo converterTipoVehiculo = new ConverterTipoVehiculo();		
		entityParqueaderoEspacioDisponible.setId(modelParqueaderoEspacioDisponible.getId());		
		entityParqueaderoEspacioDisponible.setTipoVehiculo(converterTipoVehiculo.convertirModeloAEntidad(modelParqueaderoEspacioDisponible.getTipoVehiculo()));
		entityParqueaderoEspacioDisponible.setCantidadEspacio(modelParqueaderoEspacioDisponible.getCantidadEspacio());
		return entityParqueaderoEspacioDisponible;
	}
	
}
