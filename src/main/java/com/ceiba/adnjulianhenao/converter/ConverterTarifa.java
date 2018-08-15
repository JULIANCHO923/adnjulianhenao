package com.ceiba.adnjulianhenao.converter;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.ceiba.adnjulianhenao.entity.EntityTarifa;
import com.ceiba.adnjulianhenao.model.Tarifa;

import java.util.List;

@Component("convertidorTarifa")
public class ConverterTarifa {

	
	public List<Tarifa> convertirLista(List<EntityTarifa> entityTarifas){
		List<Tarifa> tarifas = new ArrayList<>();
		for(EntityTarifa ev : entityTarifas ){
			tarifas.add(new Tarifa(ev));
		}
		return tarifas;			
	}
	
	public Tarifa convertirTarifa(EntityTarifa entityTarifa){
		return new Tarifa(entityTarifa);						
	}
	
}
