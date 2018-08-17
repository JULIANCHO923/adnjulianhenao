package com.ceiba.adnjulianhenao.validacion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;



@Component("validacionesSalida")
public class ValidacionesSalida {
			
	@Autowired
	@Qualifier("reglaSobreCostoCilindraje")
	private ReglaSobreCostoCilindraje reglaSobreCostoCilindraje;	
	
	public List<Validaciones> validacionesSalida() {
		List<Validaciones> validaciones = new ArrayList<>();				
		validaciones.add(reglaSobreCostoCilindraje);			
		return validaciones;
	}	
	
}
