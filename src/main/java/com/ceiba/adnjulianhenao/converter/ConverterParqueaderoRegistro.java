package com.ceiba.adnjulianhenao.converter;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.ceiba.adnjulianhenao.entity.EntityParqueaderoRegistro;
import com.ceiba.adnjulianhenao.model.ModelParqueaderoRegistro;

import java.util.List;

@Component("convertidorParqueaderoRegistro")
public class ConverterParqueaderoRegistro {
		
	public List<ModelParqueaderoRegistro> convertirLista(List<EntityParqueaderoRegistro> entityParqueaderoRegistros) {
		List<ModelParqueaderoRegistro> modelParqueaderoRegistros = new ArrayList<>();
		for (EntityParqueaderoRegistro entityParqueaderoRegistro : entityParqueaderoRegistros) {
			modelParqueaderoRegistros.add(convertirEntidadAModelo(entityParqueaderoRegistro));
		}
		return modelParqueaderoRegistros;
	}

	public ModelParqueaderoRegistro convertirEntidadAModelo(EntityParqueaderoRegistro entityParqueaderoRegistro) {
		ModelParqueaderoRegistro modelParqueaderoRegistro = new ModelParqueaderoRegistro();		
		ConverterVehiculo converterVehiculo = new ConverterVehiculo();
	    modelParqueaderoRegistro.setId(entityParqueaderoRegistro.getId());
	    modelParqueaderoRegistro.setVehiculo(converterVehiculo.convertirEntidadAModelo(entityParqueaderoRegistro.getVehiculo()));
	    modelParqueaderoRegistro.setFechaEntrada(entityParqueaderoRegistro.getFechaEntrada());
	    modelParqueaderoRegistro.setFechaSalida(entityParqueaderoRegistro.getFechaSalida());
	    modelParqueaderoRegistro.setDiasParqueadero(entityParqueaderoRegistro.getDiasParqueadero());
	    modelParqueaderoRegistro.setHorasParqueadero(entityParqueaderoRegistro.getHorasParqueadero());
	    modelParqueaderoRegistro.setCostoTotal(entityParqueaderoRegistro.getCostoTotal());	    
	    return modelParqueaderoRegistro;
	}

	public EntityParqueaderoRegistro convertirModeloAEntidad(ModelParqueaderoRegistro modelParqueaderoRegistro) {
		EntityParqueaderoRegistro entityParqueaderoRegistro = new EntityParqueaderoRegistro();
		ConverterVehiculo converterVehiculo = new ConverterVehiculo();
		entityParqueaderoRegistro.setId(modelParqueaderoRegistro.getId());		
		entityParqueaderoRegistro.setVehiculo(converterVehiculo.convertirModeloAEntidad(modelParqueaderoRegistro.getVehiculo()));
		entityParqueaderoRegistro.setFechaEntrada(modelParqueaderoRegistro.getFechaEntrada());
		entityParqueaderoRegistro.setFechaSalida(modelParqueaderoRegistro.getFechaSalida());
		entityParqueaderoRegistro.setDiasParqueadero(modelParqueaderoRegistro.getDiasParqueadero());
		entityParqueaderoRegistro.setHorasParqueadero(modelParqueaderoRegistro.getHorasParqueadero());
		entityParqueaderoRegistro.setCostoTotal(modelParqueaderoRegistro.getCostoTotal());
		return entityParqueaderoRegistro;
	}

}
