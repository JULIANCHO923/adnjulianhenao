package com.ceiba.adnjulianhenao.convertidor;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.ceiba.adnjulianhenao.entidad.EntidadVehiculo;
import com.ceiba.adnjulianhenao.modelo.ModeloVehiculo;

import java.util.List;

@Component("convertidorVehiculo")
public class ConvertidorVehiculo {
		
	public List<ModeloVehiculo> convertirLista(List<EntidadVehiculo> entidadVehiculos) {
		List<ModeloVehiculo> modeloVehiculos = new ArrayList<>();
		for (EntidadVehiculo entidadVehiculo : entidadVehiculos) {
			modeloVehiculos.add(convertirEntidadAModelo(entidadVehiculo));
		}
		return modeloVehiculos;
	}

	public List<EntidadVehiculo> convertirLista2(List<ModeloVehiculo> modeloVehiculos) {
		List<EntidadVehiculo> entidadVehiculos = new ArrayList<>();
		for (ModeloVehiculo modeloVehiculo : modeloVehiculos) {
			entidadVehiculos.add(convertirModeloAEntidad(modeloVehiculo));
		}
		return entidadVehiculos;
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

	public EntidadVehiculo convertirModeloAEntidad(ModeloVehiculo modeloVehiculo) {
		EntidadVehiculo entidadVehiculo = new EntidadVehiculo();
		ConvertidorTipoVehiculo convertidorTipoVehiculo = new ConvertidorTipoVehiculo();
		entidadVehiculo.setCilindraje(modeloVehiculo.getCilindraje());
		entidadVehiculo.setId(modeloVehiculo.getId());
		entidadVehiculo.setPlaca(modeloVehiculo.getPlaca());
		entidadVehiculo.setTipoVehiculo(convertidorTipoVehiculo.convertirModeloAEntidad(modeloVehiculo.getTipoVehiculo()));
		return entidadVehiculo;
	}

}
