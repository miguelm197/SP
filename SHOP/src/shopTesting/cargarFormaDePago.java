package shopTesting;

import com.dogma.busClass.ApiaAbstractClass;
import com.dogma.busClass.BusClassException;
import com.dogma.busClass.object.Attribute;
import com.dogma.busClass.object.Entity;
import com.dogma.busClass.object.PossibleValue;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;

public class cargarFormaDePago extends ApiaAbstractClass {
	@Override
	protected void executeClass() throws BusClassException {
		// currEnt.getAttribute("").clear();
		Attribute tipos = this.getCurrentEntity().getAttribute("SH_FORMADEPAGO_SOLICITA_COMPRA_STR");

		PossibleValue pos1 = new PossibleValue("Efectivo", "Efectivo");
		PossibleValue pos2 = new PossibleValue("Tarjeta", "Tarjeta");
		PossibleValue pos3 = new PossibleValue("Cheque", "Cheque");
		PossibleValue pos4 = new PossibleValue("Depósito", "Depósito Bancario");

		tipos.addPossibleValues(pos1);
		tipos.addPossibleValues(pos2);
		tipos.addPossibleValues(pos3);
		tipos.addPossibleValues(pos4);

	}
}
