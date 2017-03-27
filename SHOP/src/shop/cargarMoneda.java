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

public class cargarMoneda extends ApiaAbstractClass {
	@Override
	protected void executeClass() throws BusClassException {

		Attribute moneda = this.getCurrentEntity().getAttribute("SH_MONEDA_PRESUPUESTO_COMPRA_STR");

		PossibleValue pos1 = new PossibleValue("Pesos", "$U");
		PossibleValue pos2 = new PossibleValue("Dólares", "U$D");
		
		moneda.addPossibleValues(pos1);
		moneda.addPossibleValues(pos2);
	

	}
}