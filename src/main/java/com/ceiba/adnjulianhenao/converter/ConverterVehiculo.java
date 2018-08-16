package com.ceiba.adnjulianhenao.converter;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.ceiba.adnjulianhenao.entity.EntityVehiculo;
import com.ceiba.adnjulianhenao.model.ModelVehiculo;

import java.util.List;

@Component("convertidorVehiculo")
public class ConverterVehiculo {
		
	public List<ModelVehiculo> convertirLista(List<EntityVehiculo> entityVehiculos) {
		List<ModelVehiculo> vehiculos = new ArrayList<>();
		for (EntityVehiculo entityVehiculo : entityVehiculos) {
			vehiculos.add(convertirEntidadAModelo(entityVehiculo));
		}
		return vehiculos;
	}

	public ModelVehiculo convertirEntidadAModelo(EntityVehiculo entityVehiculo) {
		ModelVehiculo modelVehiculo = new ModelVehiculo();
		ConverterTipoVehiculo converterTipoVehiculo = new ConverterTipoVehiculo();
		modelVehiculo.setCilindraje(entityVehiculo.getCilindraje());
		modelVehiculo.setId(entityVehiculo.getId());
		modelVehiculo.setPlaca(entityVehiculo.getPlaca());
		modelVehiculo.setTipoVehiculo(converterTipoVehiculo.convertirEntidadAModelo(entityVehiculo.getTipoVehiculo()));
		return modelVehiculo;
	}

	public EntityVehiculo convertirModeloAEntidad(ModelVehiculo vehiculoModel) {
		EntityVehiculo entityVehiculo = new EntityVehiculo();
		ConverterTipoVehiculo converterTipoVehiculo = new ConverterTipoVehiculo();
		entityVehiculo.setCilindraje(vehiculoModel.getCilindraje());
		entityVehiculo.setId(vehiculoModel.getId());
		entityVehiculo.setPlaca(vehiculoModel.getPlaca());
		entityVehiculo.setTipoVehiculo(converterTipoVehiculo.convertirModeloAEntidad(vehiculoModel.getTipoVehiculo()));
		return entityVehiculo;
	}

}
