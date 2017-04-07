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

public class CargarSolicitate extends ApiaAbstractClass {
	@Override
	protected void executeClass() throws BusClassException {

		Attribute solicitante = this.getCurrentEntity().getAttribute("SH_SOLICITANTE_INGRESO_COMPRA_STR");

		PossibleValue pos1 = new PossibleValue("Karen", "Karen");
		PossibleValue pos2 = new PossibleValue("Carla", "Carla");
		PossibleValue pos3 = new PossibleValue("Marcos", "Marcos");
		PossibleValue pos4 = new PossibleValue("José", "José");
		PossibleValue pos5 = new PossibleValue("Jorge", "Jorge");


		solicitante.addPossibleValues(pos1);
		solicitante.addPossibleValues(pos2);
		solicitante.addPossibleValues(pos3);
		solicitante.addPossibleValues(pos4);
		solicitante.addPossibleValues(pos5);
		
		
		
	 
	}
}