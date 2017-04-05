package shopTesting;

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

public class cargarPuntaje extends ApiaAbstractClass {
	@Override
	protected void executeClass() throws BusClassException {

		Attribute puntaje = this.getCurrentEntity().getAttribute("SH_PUNTAJE_FINAL_STR");

		PossibleValue pos1 = new PossibleValue("1", "1");
		PossibleValue pos2 = new PossibleValue("2", "2");
		PossibleValue pos3 = new PossibleValue("3", "3");
		PossibleValue pos4 = new PossibleValue("4", "4");
		PossibleValue pos5 = new PossibleValue("5", "5");
		PossibleValue pos6 = new PossibleValue("6", "6");
		PossibleValue pos7 = new PossibleValue("7", "7");
		PossibleValue pos8 = new PossibleValue("8", "8");
		PossibleValue pos9 = new PossibleValue("9", "9");
		PossibleValue pos10 = new PossibleValue("10", "10");

		puntaje.addPossibleValues(pos1);
		puntaje.addPossibleValues(pos2);
		puntaje.addPossibleValues(pos3);
		puntaje.addPossibleValues(pos4);
		puntaje.addPossibleValues(pos5);
		puntaje.addPossibleValues(pos6);
		puntaje.addPossibleValues(pos7);
		puntaje.addPossibleValues(pos8);
		puntaje.addPossibleValues(pos9);
		puntaje.addPossibleValues(pos10);

		
	}
}