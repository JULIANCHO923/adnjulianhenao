package com.ceiba.adnjulianhenao.converter;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.ceiba.adnjulianhenao.entity.EntityTipoVehiculo;
import com.ceiba.adnjulianhenao.model.ModelTipoVehiculo;

import java.util.List;

@Component("convertidorTipoVehiculo")
public class ConverterTipoVehiculo {

	
	public List<ModelTipoVehiculo> convertirLista(List<EntityTipoVehiculo> entityTipoVehiculos){
		List<ModelTipoVehiculo> tipoVehiculos = new ArrayList<>();
		for(EntityTipoVehiculo etv : entityTipoVehiculos ){
			tipoVehiculos.add(convertirEntidadAModelo(etv));
		}
		return tipoVehiculos;			
	}
	
	public ModelTipoVehiculo convertirEntidadAModelo(EntityTipoVehiculo entityTipoVehiculo) {
		ModelTipoVehiculo tv = new ModelTipoVehiculo();
		tv.setId(entityTipoVehiculo.getId());
		tv.setDescripcion(entityTipoVehiculo.getDescripcion());
		return tv;
	}

	public EntityTipoVehiculo convertirModeloAEntidad(ModelTipoVehiculo vehiculoModel) {
		EntityTipoVehiculo ev = new EntityTipoVehiculo();
		ev.setId(vehiculoModel.getId());
		ev.setDescripcion(vehiculoModel.getDescripcion());
		return ev;
	}
}
