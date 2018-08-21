package com.ceiba.adnjulianhenao.vehiculo.testUnitarioEntradaVehiculo;

import static org.junit.Assert.fail;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.adnjulianhenao.builderstest.TipoVehiculoBuilder;
import com.ceiba.adnjulianhenao.builderstest.VehiculoBuilder;
import com.ceiba.adnjulianhenao.excepcion.ExcepcionParametroInvalido;
import com.ceiba.adnjulianhenao.modelo.ModeloTipoVehiculo;
import com.ceiba.adnjulianhenao.modelo.ModeloVehiculo;
import com.ceiba.adnjulianhenao.validacion.entrada.ReglaIngresaPlaca;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestReglaIngresaPlaca {

	@Autowired
	ReglaIngresaPlaca reglaIngresaPlaca;

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@Test
	public void ReglaEntradaPlacaObligatoriaAuto() {
		ModeloTipoVehiculo tipoVehiculoAuto = new TipoVehiculoBuilder().conId(1).conDescripcion("Automovil").build();

		String placaNula = null;

		ModeloVehiculo vehiculo = new VehiculoBuilder().conPlaca(placaNula).conTipoVehiculo(tipoVehiculoAuto)
				.conCilindraje(100).build();

		exceptionRule.expect(ExcepcionParametroInvalido.class);
		exceptionRule.expectMessage("La Placa es obligatoria");
		reglaIngresaPlaca.validar(vehiculo);
	}

	@Test
	public void ReglaEntradaPlacaObligatoriaMoto() {
		ModeloTipoVehiculo tipoVehiculoMoto = new TipoVehiculoBuilder().conId(2).conDescripcion("Moto").build();
		ModeloVehiculo vehiculo = new VehiculoBuilder().conPlaca("ABC123").conTipoVehiculo(tipoVehiculoMoto)
				.conCilindraje(100).build();
		try {
			reglaIngresaPlaca.validar(vehiculo);
		} catch (ExcepcionParametroInvalido e) {
			fail();
		}
	}

	/*
	 * Cuando la excepcion es lanzada se aprueba
	 * 
	 * @Test(expected = NullPointerException.class) public void
	 * whenExceptionThrown_thenExpectationSatisfied() { String test = null;
	 * test.length(); }
	 */

	/*
	 * Cuando deseo evaluar otras propiedades (Integración ???)
	 * 
	 * @Rule public ExpectedException exceptionRule = ExpectedException.none();
	 * 
	 * @Test public void whenExceptionThrown_thenRuleIsApplied() {
	 * exceptionRule.expect(NumberFormatException.class);
	 * exceptionRule.expectMessage("For input string"); Integer.parseInt("1a");
	 * }
	 */

}
