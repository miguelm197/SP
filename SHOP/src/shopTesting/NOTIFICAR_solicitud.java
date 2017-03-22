package shopTesting;

import com.dogma.busClass.ApiaAbstractClass;
import com.dogma.busClass.BusClassException;
import com.dogma.busClass.object.Attribute;
import com.dogma.busClass.object.Entity;
import com.dogma.busClass.object.PossibleValue;
import com.dogma.busClass.object.User;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;

public class NOTIFICAR_solicitud extends ApiaAbstractClass {
	@Override
	protected void executeClass() throws BusClassException {

		Entity currEnt = this.getCurrentEntity();

		String titulo = currEnt.getAttribute("SH_TITULO_INGRESO_COMPRA_STR").getValueAsString();
		String solicitante = currEnt.getAttribute("SH_SOLICITANTE_INGRESO_COMPRA_STR").getValueAsString();
	
		String[] gruposNotificar = { "ADMINISTRACION_TESTING", "DIRECCION_TESTING"};
		Collection<User> usuarios = null;

		for (int i = 0; i < gruposNotificar.length; i++) {
	
			usuarios = this.getGroup(gruposNotificar[i]).getUsers();
		}

		for (User u : usuarios) {
			String mail = u.getEmail();
			if (mail.compareTo("") != 0) {
				String[] mailEnviar = { mail };

				this.sendMail(mailEnviar, "ADMINISTRACION, DIRECCION_Se solicitó la compra "  + titulo ,
						"Hola Karen, <br> <br>" + "Confirmamos que la nueva compra solicitada por " + solicitante
								+ " ha sido solicitada correctamente. <br><br>" 
								
								+ "Saludos, Maite :)");
			}
		}
	}
}
