package shop;

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

public class Scheduler2 extends ApiaAbstractClass {
	@Override
	protected void executeClass() throws BusClassException {

		String envDir="true";
		boolean enviDireccion =true;
		
		if (envDir.equals("true")) {
			// ENVIO A DIRECCION

			if (enviDireccion) {
				String[] gruposNotificar = { "DIRECCION_TESTING" };
				Collection<User> usuarios = null;


				for (int i = 0; i < gruposNotificar.length; i++) {
					usuarios = this.getGroup(gruposNotificar[i]).getUsers();
				}

				for (User u : usuarios) {
					String mail = u.getEmail();
					if (mail.compareTo("") != 0) {
						String[] mailEnviar = { mail };
						this.sendMail(mailEnviar, "Prueba de correo",
								"Buenas Tardes. Estamos probando si funciona el envío de mail hacia dirección. Favor de confirmar si llegó a Miguel. <br> Muchas gracias");
					}
				}
			}
		}
	}
}
