package com.ceiba.adnjulianhenao.convertidor;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.ceiba.adnjulianhenao.entidad.EntidadVehiculo;
import com.ceiba.adnjulianhenao.modelo.ModeloVehiculo;

import java.util.List;

@Component("convertidorVehiculo")
public class ConvertidorVehiculo {
		
	public List<ModeloVehiculo> convertirLista(List<EntidadVehiculo> entidadVehiculos) {
		List<ModeloVehiculo> vehiculos = new ArrayList<>();
		for (EntidadVehiculo entidadVehiculo : entidadVehiculos) {
			vehiculos.add(convertirEntidadAModelo(entidadVehiculo));
		}
		return vehiculos;
	}

	public ModeloVehiculo convertirEntidadAModelo(EntidadVehiculo entidadVehiculo) {
		ModeloVehiculo modeloVehiculo = new ModeloVehiculo();
		ConvertidorTipoVehiculo convertidorTipoVehiculo = new ConvertidorTipoVehiculo();
		modeloVehiculo.setCilindraje(entidadVehiculo.getCilindraje());
		modeloVehiculo.setId(entidadVehiculo.getId());
		modeloVehiculo.setPlaca(entidadVehiculo.getPlaca());
		modeloVehiculo.setTipoVehiculo(convertidorTipoVehiculo.convertirEntidadAModelo(entidadVehiculo.getTipoVehiculo()));
		return modeloVehiculo;
	}

	public EntidadVehiculo convertirModeloAEntidad(ModeloVehiculo vehiculoModel) {
		EntidadVehiculo entidadVehiculo = new EntidadVehiculo();
		ConvertidorTipoVehiculo convertidorTipoVehiculo = new ConvertidorTipoVehiculo();
		entidadVehiculo.setCilindraje(vehiculoModel.getCilindraje());
		entidadVehiculo.setId(vehiculoModel.getId());
		entidadVehiculo.setPlaca(vehiculoModel.getPlaca());
		entidadVehiculo.setTipoVehiculo(convertidorTipoVehiculo.convertirModeloAEntidad(vehiculoModel.getTipoVehiculo()));
		return entidadVehiculo;
	}

}
