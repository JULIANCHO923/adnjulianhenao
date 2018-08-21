package com.ceiba.adnjulianhenao.testIntegracionEntrada;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.adnjulianhenao.servicio.ServicioVehiculo;


@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestInsertarVehiculo {

	@Autowired
	ServicioVehiculo servicioVehiculo;
	
	@Test
	@SqlGroup(@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:preparandoBD.sql"))
	public void test() {
		
		
		
	}

}
