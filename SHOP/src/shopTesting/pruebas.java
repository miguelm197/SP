package shopTesting;

import com.dogma.busClass.ApiaAbstractClass;
import com.dogma.busClass.BusClassException;
import com.dogma.busClass.object.Attribute;
import com.dogma.busClass.object.Entity;
import com.dogma.busClass.object.PossibleValue;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class pruebas extends ApiaAbstractClass {
	@Override
	protected void executeClass() throws BusClassException {
		//currEnt.getAttribute("").clear();
		
		
		Entity currEnt = this.getCurrentEntity();

		String finP = currEnt.getAttribute("SH_FINPRESUPUESTO_PRESUPUESTO_COMPRA_STR").getValueAsString();
			this.addMessage(finP);
		

	}
}