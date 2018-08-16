package com.ceiba.adnjulianhenao.excepcion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExcepcionParametroInvalido extends RuntimeException{

	public ExcepcionParametroInvalido(){}
	
	public ExcepcionParametroInvalido(String mensaje){
		super(mensaje);		
	}
	
}
