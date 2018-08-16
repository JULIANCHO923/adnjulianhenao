package com.ceiba.adnjulianhenao.excepcion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CHECKPOINT)
public class ExcepcionSobreCosto extends RuntimeException {

	public ExcepcionSobreCosto() {
	}

	public ExcepcionSobreCosto(String mensaje) {
		super(mensaje);
	}

}
