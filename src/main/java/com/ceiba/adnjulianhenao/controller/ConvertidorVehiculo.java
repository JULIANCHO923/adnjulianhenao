package com.ceiba.adnjulianhenao.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.ceiba.adnjulianhenao.entity.EntityVehiculo;
import com.ceiba.adnjulianhenao.model.Vehiculo;

import java.util.List;

@Component("convertidorVehiculo")
public class ConvertidorVehiculo {

	
	public List<Vehiculo> convertirLista(List<EntityVehiculo> entityVehiculos){
		List<Vehiculo> vehiculos = new ArrayList<>();
		for(EntityVehiculo ev : entityVehiculos ){
			vehiculos.add(new Vehiculo(ev));
		}
		return vehiculos;			
	}
	
	public Vehiculo convertirVehiculo(EntityVehiculo entityVehiculo){
		return new Vehiculo(entityVehiculo);						
	}
	
}
