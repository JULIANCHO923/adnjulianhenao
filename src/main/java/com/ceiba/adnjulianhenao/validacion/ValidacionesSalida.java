package com.ceiba.adnjulianhenao.validacion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class ValidacionesSalida {
			
	@Autowired
	private ReglaSobreCostoCilindraje reglaSobreCostoCilindraje;	
	
	public List<Validaciones> validacionesSalida() {
		List<Validaciones> validaciones = new ArrayList<>();				
		validaciones.add(reglaSobreCostoCilindraje);			
		return validaciones;
	}	
	
}
