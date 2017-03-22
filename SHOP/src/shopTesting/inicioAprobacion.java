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

public class inicioAprobacion extends ApiaAbstractClass {
	@Override
	protected void executeClass() throws BusClassException {

		String estado = this.getCurrentEntity().getAttribute("SH_ESTADO_APROBACION_COMPRA_STR").getValueAsString();
		String comentario = this.getCurrentEntity().getAttribute("SH_COMENTARIO_APROBACION_COMPRA_STR")
				.getValueAsString();

		if (estado.equals("2")) {
			this.getCurrentEntity().getAttribute("SH_COMENTARIO_VUELTAPRESUPUESTO_COMPRA_STR").setValue(comentario);
		}

		// String envDir =
		// currEnt.getAttribute("SH_FINPRESUPUESTO_PRESUPUESTO_COMPRA_STR").;

	}
}