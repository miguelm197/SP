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

public class confirmarFinalizacion extends ApiaAbstractClass {
	@Override
	protected void executeClass() throws BusClassException {

		String puntaje = this.getCurrentEntity().getAttribute("SH_PUNTAJE_FINAL_STR").getValueAsString();
		String finaliza = this.getCurrentEntity().getAttribute("SH_COMPRA_FINAL_STR").getValueAsString();

		boolean bandera = true;
		int pun;

		if (finaliza.equals("Si")) {
			try {
				pun = Integer.parseInt(puntaje);
			} catch (Exception e) {
				bandera = false;
				throw new BusClassException("Ingreso de puntaje inv�lido");
			}

			if (pun < 0 || pun > 10) {
				throw new BusClassException("El puntaje debe de estar entre 0 y 10");
			}
		}
	}
}