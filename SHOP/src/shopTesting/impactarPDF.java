package shopTesting;

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
import java.util.Iterator;

public class impactarPDF extends ApiaAbstractClass {
	@Override
	protected void executeClass() throws BusClassException {

		Entity currEnt = this.getCurrentEntity();
		String listo = currEnt.getAttribute("SH_LISTO_PRESUPUESTOS_STR").getValuesAsString();

		if (listo.equals("false")) {
			Document pdf = currEnt.getAttribute("SH_COMPROBANTE_PRESUPUESTO_COMPRA_STR").getDocumentValue();

			String path = pdf.download();

	
			this.getCurrentEntity().getAttribute("SH_COMPROBANTE_PRESUPUESTO_INFO_STR").addDocument(path, pdf.getName(),
					pdf.getDescription(), false);

		}
	}
}
