package com.ceiba.adnjulianhenao.converter;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.ceiba.adnjulianhenao.entity.EntityTipoVehiculo;
import com.ceiba.adnjulianhenao.model.TipoVehiculo;

import java.util.List;

@Component("convertidorTipoVehiculo")
public class ConverterTipoVehiculo {

	
	public List<TipoVehiculo> convertirLista(List<EntityTipoVehiculo> entityTipoVehiculos){
		List<TipoVehiculo> tipoVehiculos = new ArrayList<>();
		for(EntityTipoVehiculo etv : entityTipoVehiculos ){
			tipoVehiculos.add(new TipoVehiculo(etv));
		}
		return tipoVehiculos;			
	}
	
	public TipoVehiculo convertirTipoVehiculo(EntityTipoVehiculo entityTipoVehiculo){
		return new TipoVehiculo(entityTipoVehiculo);						
	}
	
}
