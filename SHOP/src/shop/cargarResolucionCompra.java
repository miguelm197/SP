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

public class cargarResolucionCompra extends ApiaAbstractClass {
	@Override
	protected void executeClass() throws BusClassException {

		Attribute tipos = this.getCurrentEntity().getAttribute("SH_COMPRA_FINAL_STR");

		PossibleValue pos1 = new PossibleValue("Si", "Si");
		PossibleValue pos2 = new PossibleValue("No", "No");
	

		tipos.addPossibleValues(pos1);
		tipos.addPossibleValues(pos2);
	 
	}
}