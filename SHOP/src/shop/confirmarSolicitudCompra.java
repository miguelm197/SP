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

public class confirmarSolicitudCompra extends ApiaAbstractClass {
	@Override
	protected void executeClass() throws BusClassException {

		
		String fechaEstimada = this.getCurrentEntity().getAttribute("SH_FECHA_SOLICITA_COMPRA_FEC ").getValueAsString();

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

		
		if (fechaEst.after(fechaActual)){
			System.out.println("Sape");
		}
		else{
			throw new BusClassException("Fecha no puede ser anterior a la actual");
		}
	
	
		
	}
}