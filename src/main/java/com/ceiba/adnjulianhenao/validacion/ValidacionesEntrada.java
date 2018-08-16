package com.ceiba.adnjulianhenao.validacion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class ValidacionesEntrada {

	
	@Autowired
	private ReglaCilindrajeMoto reglaCilindrajeMoto;
	
	@Autowired	
	private ReglaDiaHabil reglaDiaHabil;
	
	@Autowired
	private ReglaDisponibilidadEspacio reglaDisponibilidadEspacio;
		
	@Autowired
	private ReglaTipoVehiculo reglaTipoVehiculo;
	
	@Autowired
	private ReglaVehiculoSinSalirVuelveAEntrar reglaVehiculoSinSalirVuelveAEntrar;
	
	
	public List<Validaciones> validacionesEntrada() {
		List<Validaciones> validaciones = new ArrayList<>();		
		validaciones.add(reglaTipoVehiculo);
		validaciones.add(reglaDiaHabil);
		validaciones.add(reglaVehiculoSinSalirVuelveAEntrar);
		validaciones.add(reglaDisponibilidadEspacio);
		validaciones.add(reglaCilindrajeMoto);		
		return validaciones;
	}	
	
}
