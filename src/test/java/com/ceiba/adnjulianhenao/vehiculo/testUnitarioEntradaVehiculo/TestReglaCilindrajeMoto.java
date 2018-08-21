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
import com.ceiba.adnjulianhenao.validacion.entrada.ReglaCilindrajeMoto;



@RunWith(SpringRunner.class)
@SpringBootTest
public class TestReglaCilindrajeMoto {


	@Autowired
	ReglaCilindrajeMoto reglaCilindrajeMoto;
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Test
	public void ReglaEntradaMotoCilindrajeCero() {				
		ModeloTipoVehiculo tipoVehiculoMoto = new TipoVehiculoBuilder().conId(2).conDescripcion("Moto").build();
		long cilindrajeCero = 0;
		ModeloVehiculo vehiculo1 = new VehiculoBuilder().conPlaca("ABC123").conTipoVehiculo(tipoVehiculoMoto).conCilindraje(cilindrajeCero).build();		
		exceptionRule.expect(ExcepcionParametroInvalido.class);
		exceptionRule.expectMessage("Valor de cilindraje invalido para la Moto");		
		reglaCilindrajeMoto.validar(vehiculo1);			
	}
	
	
	@Test(expected = Test.None.class)
	public void ReglaEntradaMotoCilindrajeMayoraCero() {				
		ModeloTipoVehiculo tipoVehiculoMoto = new TipoVehiculoBuilder().conId(2).conDescripcion("Moto").build();
		long cilindrajeMayoraCero = 1;
		ModeloVehiculo vehiculo1 = new VehiculoBuilder().conPlaca("ABC123").conTipoVehiculo(tipoVehiculoMoto).conCilindraje(cilindrajeMayoraCero).build();						
		reglaCilindrajeMoto.validar(vehiculo1);			
	}

	/**
	 * Se espera que no importe el valor del cilindraje del Auto
	 * Si no falla, la prueba es exitosa 
	 */
	@Test
	public void ReglaEntradaAutoCilindrajeCero() {		
		ModeloTipoVehiculo tipoVehiculoAuto = new TipoVehiculoBuilder().conId(1).conDescripcion("Automovil").build();	
		long cilindrajeCero = 0;
		ModeloVehiculo vehiculo = new VehiculoBuilder().conPlaca("ABC123").conTipoVehiculo(tipoVehiculoAuto).conCilindraje(cilindrajeCero).build();
		try{
		reglaCilindrajeMoto.validar(vehiculo);
		}catch(ExcepcionParametroInvalido e){
			fail();
		}
	}
	
}
