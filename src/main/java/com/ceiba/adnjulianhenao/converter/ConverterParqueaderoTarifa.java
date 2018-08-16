package com.ceiba.adnjulianhenao.converter;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.ceiba.adnjulianhenao.entity.EntityParqueaderoTarifa;
import com.ceiba.adnjulianhenao.model.ModelParqueaderoTarifa;

import java.util.List;

@Component("convertidorParqueaderoTarifa")
public class ConverterParqueaderoTarifa {

	
	public List<ModelParqueaderoTarifa> convertirLista(List<EntityParqueaderoTarifa> entityParquederoTarifas) {
		List<ModelParqueaderoTarifa> parquederoTarifas = new ArrayList<>();
		for (EntityParqueaderoTarifa entityParqueaderoTarifa : entityParquederoTarifas) {
			parquederoTarifas.add(convertirEntidadAModelo( entityParqueaderoTarifa));
		}
		return parquederoTarifas;
	}

	public ModelParqueaderoTarifa convertirEntidadAModelo(EntityParqueaderoTarifa entityParqueaderoTarifa) {
		ModelParqueaderoTarifa modelParqueaderoTarifa = new ModelParqueaderoTarifa();
		ConverterTipoVehiculo converterTipoVehiculo = new ConverterTipoVehiculo();		
		modelParqueaderoTarifa.setId(entityParqueaderoTarifa.getId());		
		modelParqueaderoTarifa.setTipoVehiculo(converterTipoVehiculo.convertirEntidadAModelo(entityParqueaderoTarifa.getTipoVehiculo()));
		modelParqueaderoTarifa.setCostoHora(entityParqueaderoTarifa.getCostoHora());
		modelParqueaderoTarifa.setCostoDia(entityParqueaderoTarifa.getCostoDia());
		modelParqueaderoTarifa.setHorasCobroDia(entityParqueaderoTarifa.getHorasCobroDia());
		return modelParqueaderoTarifa;
	}

	public EntityParqueaderoTarifa convertirModeloAEntidad(ModelParqueaderoTarifa modelParqueaderoTarifa) {
		EntityParqueaderoTarifa entityParqueaderoTarifa = new EntityParqueaderoTarifa();
		ConverterTipoVehiculo converterTipoVehiculo = new ConverterTipoVehiculo();		
		entityParqueaderoTarifa.setId(modelParqueaderoTarifa.getId());		
		entityParqueaderoTarifa.setTipoVehiculo(converterTipoVehiculo.convertirModeloAEntidad(modelParqueaderoTarifa.getTipoVehiculo()));
		entityParqueaderoTarifa.setCostoHora(modelParqueaderoTarifa.getCostoHora());
		entityParqueaderoTarifa.setCostoDia(modelParqueaderoTarifa.getCostoDia());
		entityParqueaderoTarifa.setHorasCobroDia(modelParqueaderoTarifa.getHorasCobroDia());
		return entityParqueaderoTarifa;
	}
	
}
