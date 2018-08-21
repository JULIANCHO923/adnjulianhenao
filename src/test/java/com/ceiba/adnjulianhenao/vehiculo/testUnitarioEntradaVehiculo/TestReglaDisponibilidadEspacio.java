package com.ceiba.adnjulianhenao.vehiculo.testUnitarioEntradaVehiculo;

import static org.mockito.Mockito.when;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.adnjulianhenao.builderstest.TipoVehiculoBuilder;
import com.ceiba.adnjulianhenao.builderstest.VehiculoBuilder;
import com.ceiba.adnjulianhenao.dominioparqueadero.Calendario;
import com.ceiba.adnjulianhenao.excepcion.ExcepcionParametroInvalido;
import com.ceiba.adnjulianhenao.modelo.ModeloTipoVehiculo;
import com.ceiba.adnjulianhenao.modelo.ModeloVehiculo;
import com.ceiba.adnjulianhenao.validacion.entrada.ReglaDiaHabil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestReglaDisponibilidadEspacio {

	
	@MockBean
	Calendario calendario;
	
	@Autowired
	ReglaDiaHabil reglaDiaHabil;
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Test
	public void ReglaEntradaVehiculoPlacaANoPuedeEntrarLunes() {
		int lunes = 1;
		String placa = "ABC123";
		
		ModeloTipoVehiculo tipoVehiculoMoto = new TipoVehiculoBuilder().conId(2).conDescripcion("Moto").build();		
		ModeloVehiculo vehiculo = new VehiculoBuilder().conPlaca(placa).conTipoVehiculo(tipoVehiculoMoto).conCilindraje(100).build();
		
		when(calendario.obtenerDiaActual()).thenReturn(lunes);			
		
		exceptionRule.expect(ExcepcionParametroInvalido.class);
		exceptionRule.expectMessage("La placa que inicia por 'A' NO puede ingresar los Lunes y los Domingos");
		reglaDiaHabil.validar(vehiculo);		
				
	}

	
	@Test(expected = ExcepcionParametroInvalido.class)
	public void ReglaEntradaVehiculoPlacaANoPuedeEntrarDomingo() {
		int domingo = 7;
		String placa = "ABC123";
		
		ModeloTipoVehiculo tipoVehiculoMoto = new TipoVehiculoBuilder().conId(2).conDescripcion("Moto").build();		
		ModeloVehiculo vehiculo = new VehiculoBuilder().conPlaca(placa).conTipoVehiculo(tipoVehiculoMoto).conCilindraje(100).build();
		
		when(calendario.obtenerDiaActual()).thenReturn(domingo);			
				
		reglaDiaHabil.validar(vehiculo);		
				
	}
	
}
