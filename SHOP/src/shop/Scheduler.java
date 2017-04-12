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

public class Scheduler extends ApiaAbstractClass {
	@Override
	protected void executeClass() throws BusClassException {

		String entType = "SHOP";
		String preFix = null;
		int number = 1;
		String postFix = null;

		Entity ent = this.getEntity(entType, preFix, number, postFix);
		Collection presupuestos = ent.getAttribute("SH_MONTO_PRESUPUESTO_INFO_STR").getValues();
		ArrayList presu = new ArrayList();
		presu.addAll(presupuestos);
		
		presu.set(2, "$U 10919");
		
		ent.getAttribute("SH_MONTO_PRESUPUESTO_INFO_STR").setValues(presu);
		
		
		/*
		 * 9882 Diser 8950 + Iva 10919                 
		 */
	}
}
