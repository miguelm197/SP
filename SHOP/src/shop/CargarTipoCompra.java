package shop;

import com.dogma.busClass.ApiaAbstractClass;
import com.dogma.busClass.BusClassException;
import com.dogma.busClass.object.Attribute;
import com.dogma.busClass.object.PossibleValue;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CargarTipoCompra extends ApiaAbstractClass {
	@Override
	protected void executeClass() throws BusClassException {

		Attribute tipos = this.getCurrentEntity().getAttribute("SH_TIPO_INGRESO_COMPRA_STR");

		PossibleValue pos1 = new PossibleValue("Consumo Interno", "Consumo Interno");
		PossibleValue pos2 = new PossibleValue("Instalaciones", "Instalaciones");
		PossibleValue pos3 = new PossibleValue("Provisiones de Cliente", "Provisiones de Cliente");
		PossibleValue pos4 = new PossibleValue("Merchandising", "Merchandising");
		PossibleValue pos5 = new PossibleValue("Otros", "Otros");


		tipos.addPossibleValues(pos1);
		tipos.addPossibleValues(pos2);
		tipos.addPossibleValues(pos3);
		tipos.addPossibleValues(pos4);
		tipos.addPossibleValues(pos5);
	 
		
	}
}