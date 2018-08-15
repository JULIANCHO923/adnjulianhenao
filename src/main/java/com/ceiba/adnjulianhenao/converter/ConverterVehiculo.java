package com.ceiba.adnjulianhenao.converter;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.ceiba.adnjulianhenao.entity.EntityVehiculo;
import com.ceiba.adnjulianhenao.model.Vehiculo;

import java.util.List;

@Component("convertidorVehiculo")
public class ConverterVehiculo {

	private ConverterTipoVehiculo ctv = new ConverterTipoVehiculo();
	
	public List<Vehiculo> convertirLista(List<EntityVehiculo> entityVehiculos) {
		List<Vehiculo> vehiculos = new ArrayList<>();
		for (EntityVehiculo ev : entityVehiculos) {
			vehiculos.add(convertirEntidadAModelo(ev));
		}
		return vehiculos;
	}

	public Vehiculo convertirEntidadAModelo(EntityVehiculo entityVehiculo) {
		Vehiculo v = new Vehiculo();
		v.setCilindraje(entityVehiculo.getCilindraje());
		v.setId(entityVehiculo.getId());
		v.setPlaca(entityVehiculo.getPlaca());
		v.setTipoVehiculo(ctv.convertirEntidadAModelo(entityVehiculo.getTipoVehiculo()));
		return v;
	}

	public EntityVehiculo convertirModeloAEntidad(Vehiculo vehiculoModel) {
		EntityVehiculo ev = new EntityVehiculo();
		ev.setCilindraje(vehiculoModel.getCilindraje());
		ev.setId(vehiculoModel.getId());
		ev.setPlaca(vehiculoModel.getPlaca());
		ev.setTipoVehiculo(ctv.convertirModeloAEntidad(vehiculoModel.getTipoVehiculo()));
		return ev;
	}

}
