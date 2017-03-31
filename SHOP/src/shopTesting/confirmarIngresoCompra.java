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

public class confirmarIngresoCompra extends ApiaAbstractClass {
	@Override
	protected void executeClass() throws BusClassException {

		String cantidad = this.getCurrentEntity().getAttribute("SH_CANTIDAD_INGRESO_COMPRA_STR").getValueAsString();
		String fechaEstimada = this.getCurrentEntity().getAttribute("SH_FECHAFIN_INGRESO_COMPRA_FEC")
				.getValueAsString();

		int diaEstimada = Integer.parseInt(fechaEstimada.substring(0, 2));
		int mesEstimada = Integer.parseInt(fechaEstimada.substring(3, 5));
		int aniEstimada = Integer.parseInt(fechaEstimada.substring(6, 10));

		DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		Date fechaEst = null;
		Date fechaAct = null;

		Date fechaActual = new Date();
		fechaActual.setHours(0);
		fechaActual.setMinutes(0);
		fechaActual.setSeconds(0);

		try {
			fechaEst = formatoFecha.parse(fechaEstimada);
			fechaAct = formatoFecha.parse(fechaActual.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if (fechaEst.after(fechaActual)) {

			System.out.println("Sape");

			String fechaIngreso = fechaActual + "";
			this.getCurrentEntity().getAttribute("SH_FECHA_INGRESO_STR").setValue(fechaIngreso);

		} else {
			throw new BusClassException("Fecha no puede ser anterior a la actual");
		}

		int cant;

		try {
			cant = Integer.parseInt(cantidad);
		} catch (Exception e) {
			throw new BusClassException("Ingreso de cantidad inválida");
		}

		if (cant <= 0) {
			throw new BusClassException("La cantidad no puede ser menor a 1");
		}

	}
}