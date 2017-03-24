package shopTesting;

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

public class init_confirmarCompra extends ApiaAbstractClass {
	@Override
	protected void executeClass() throws BusClassException {
	
		Entity currEnt = this.getCurrentEntity();
		
		currEnt.getAttribute("SH_COMENTARIO_APROBACION_COMPRA_STR").clear();
		
		
	}
}



