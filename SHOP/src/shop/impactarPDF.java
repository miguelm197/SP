package shop;

import com.dogma.busClass.ApiaAbstractClass;
import com.dogma.busClass.BusClassException;
import com.dogma.busClass.object.Attribute;
import com.dogma.busClass.object.Document;
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

public class impactarPDF extends ApiaAbstractClass {
	@Override
	protected void executeClass() throws BusClassException {
	
		Entity currEnt = this.getCurrentEntity();
		Document dtb = currEnt.getAttribute("SH_COMPROBANTE_PRESUPUESTO_COMPRA_STR").getDocumentValue();
			if (dtb != null) {
				currEnt.persist();
			}
		
	}
}



