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

public class cargarEstadoCompra extends ApiaAbstractClass {
	@Override
	protected void executeClass() throws BusClassException {

		Attribute tipos = this.getCurrentEntity().getAttribute("SH_ESTADO_APROBACION_COMPRA_STR");

		PossibleValue pos1 = new PossibleValue(" ", " ");
		PossibleValue pos2 = new PossibleValue("1", "Ejecutar Compra");
		PossibleValue pos3 = new PossibleValue("2", "Volver a Presupuestos");
		PossibleValue pos4 = new PossibleValue("3", "Posponer");
		PossibleValue pos5 = new PossibleValue("4", "Cancelar");

		tipos.addPossibleValues(pos1);
		tipos.addPossibleValues(pos2);
		tipos.addPossibleValues(pos3);
		tipos.addPossibleValues(pos4);
		tipos.addPossibleValues(pos5);

		
		// no entendi donde va este if en la clase confirmarAprobacion
		// if (tipos.equals(" ")) {
		//	throw new BusClassException("Debe elegir una de las opciones");
		// }

	}
}