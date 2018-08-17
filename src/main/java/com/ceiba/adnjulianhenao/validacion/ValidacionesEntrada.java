package com.ceiba.adnjulianhenao.validacion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;



@Component("validacionesEntrada")
public class ValidacionesEntrada {

	
	@Autowired
	@Qualifier("reglaCilindrajeMoto")
	private ReglaCilindrajeMoto reglaCilindrajeMoto;
	
	@Autowired	
	@Qualifier("reglaDiaHabil")
	private ReglaDiaHabil reglaDiaHabil;
	
	@Autowired
	@Qualifier("reglaDisponibilidadEspacio")
	private ReglaDisponibilidadEspacio reglaDisponibilidadEspacio;
		
	@Autowired
	@Qualifier("reglaTipoVehiculo")
	private ReglaTipoVehiculo reglaTipoVehiculo;
	
	@Autowired
	@Qualifier("reglaVehiculoSinSalirVuelveAEntrar")
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
