package shop;

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

public class cargarCheque extends ApiaAbstractClass {
	
	@Override
	protected void executeClass() throws BusClassException {
		// currEnt.getAttribute("").clear();
		Attribute tipos = this.getCurrentEntity().getAttribute("SH_CHEQUE_SOLICITA_COMPRA_STR");

		PossibleValue pos1 = new PossibleValue("D�ferido", "D�ferido");
		PossibleValue pos2 = new PossibleValue("Al d�a", "Al d�a");

		tipos.addPossibleValues(pos1);
		tipos.addPossibleValues(pos2);
	
		
	}
}
