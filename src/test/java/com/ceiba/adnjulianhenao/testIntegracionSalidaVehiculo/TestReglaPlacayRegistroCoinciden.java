package com.ceiba.adnjulianhenao.testIntegracionSalidaVehiculo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.adnjulianhenao.excepcion.ExcepcionParametroInvalido;
import com.ceiba.adnjulianhenao.validacion.salida.ReglaPlacaYRegistroCoinciden;


/**
 * VEHICULO REGISTRADO : 'ABC123' IDREGISTRO EXISTENTE: 1 VEHICULO NO
 * REGISTRADO: 'FUT405' IDREGISTRO EXISTENTE: 1
 * 
 * @author julian.henao
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestReglaPlacayRegistroCoinciden {

	@Autowired
	ReglaPlacaYRegistroCoinciden registroCoinciden;

	String placaExistente;
	int idRegistroExistente;
	String placaNOExistente;

	@Before
	public void datosPrueba() {
		placaExistente = "ABC123";
		idRegistroExistente = 1;
		placaNOExistente = "FUT405";
	}

	@Test(expected = Test.None.class)
	@SqlGroup(@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:preparandoBD.sql"))
	public void ReglaRegistroExiste() {
		registroCoinciden.validar(idRegistroExistente, placaExistente);
	}

	@Test(expected = ExcepcionParametroInvalido.class)
	public void ReglaRegistroNOExiste() {
		registroCoinciden.validar(idRegistroExistente, placaNOExistente);
	}

	@After
	@SqlGroup(@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:eliminandoDatosBD.sql"))
	public void eliminadoDatosBD() {
	}

}
