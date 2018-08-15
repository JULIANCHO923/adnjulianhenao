package com.ceiba.adnjulianhenao.converter;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.ceiba.adnjulianhenao.entity.EntityTipoVehiculo;
import com.ceiba.adnjulianhenao.entity.EntityVehiculo;
import com.ceiba.adnjulianhenao.model.TipoVehiculo;
import com.ceiba.adnjulianhenao.model.Vehiculo;

import java.util.List;

@Component("convertidorTipoVehiculo")
public class ConverterTipoVehiculo {

	
	public List<TipoVehiculo> convertirLista(List<EntityTipoVehiculo> entityTipoVehiculos){
		List<TipoVehiculo> tipoVehiculos = new ArrayList<>();
		for(EntityTipoVehiculo etv : entityTipoVehiculos ){
			tipoVehiculos.add(convertirEntidadAModelo(etv));
		}
		return tipoVehiculos;			
	}
	
	public TipoVehiculo convertirEntidadAModelo(EntityTipoVehiculo entityTipoVehiculo) {
		TipoVehiculo tv = new TipoVehiculo();
		tv.setId(entityTipoVehiculo.getId());
		tv.setDescripcion(entityTipoVehiculo.getDescripcion());
		return tv;
	}

	public EntityTipoVehiculo convertirModeloAEntidad(TipoVehiculo vehiculoModel) {
		EntityTipoVehiculo ev = new EntityTipoVehiculo();
		ev.setId(vehiculoModel.getId());
		ev.setDescripcion(vehiculoModel.getDescripcion());
		return ev;
	}
}
