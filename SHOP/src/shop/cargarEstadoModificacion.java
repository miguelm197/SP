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

public class cargarEstadoModificacion extends ApiaAbstractClass {
	
	@Override
	protected void executeClass() throws BusClassException {
		// currEnt.getAttribute("").clear();
		Attribute tipos = this.getCurrentEntity().getAttribute("SH_ESTADO_MODIFICACION");

		PossibleValue pos1 = new PossibleValue("1", "Información general");
		PossibleValue pos2 = new PossibleValue("2", "Solicitud de Compra");
		PossibleValue pos3 = new PossibleValue("3", "Finalización de Compra");

		tipos.addPossibleValues(pos1);
		tipos.addPossibleValues(pos2);
		tipos.addPossibleValues(pos3);
	
		
	}
}
