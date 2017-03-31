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

public class NOTIFICAR_ingreso extends ApiaAbstractClass {
	@Override
	protected void executeClass() throws BusClassException {

		Entity currEnt = this.getCurrentEntity();

		String titulo = currEnt.getAttribute("SH_TITULO_INGRESO_COMPRA_STR").getValueAsString();
		String solicitante = currEnt.getAttribute("SH_SOLICITANTE_INGRESO_COMPRA_STR").getValueAsString();
		String tipo = currEnt.getAttribute("SH_TIPO_INGRESO_COMPRA_STR").getValueAsString();
		String cantidad = currEnt.getAttribute("SH_CANTIDAD_INGRESO_COMPRA_STR").getValueAsString();
		String fechaEstimada = currEnt.getAttribute("SH_FECHAFIN_INGRESO_COMPRA_FEC").getValueAsString();
		String descripcion = currEnt.getAttribute("SH_DESCRIPCION_INGRESO_COMPRA_STR").getValueAsString();
		String comentario = currEnt.getAttribute("SH_COMENTARIO_INGRESO_COMPRA_STR").getValueAsString();

		String[] gruposNotificar = { "ADMINISTRACION_TESTING" };
		Collection<User> usuarios = null;

		boolean notificar = true;

		if (notificar) {
			for (int i = 0; i < gruposNotificar.length; i++) {
				usuarios = this.getGroup(gruposNotificar[i]).getUsers();
			}

			for (User u : usuarios) {
				String mail = u.getEmail();
				if (mail.compareTo("") != 0) {
					String[] mailEnviar = { mail };

					this.sendMail(mailEnviar, "NUEVA COMPRA " + titulo,
									"Le notificamos que se ha ingresado una nueva compra. <br><br>" 
									
									+ "INFORMACIÓN DE LA COMPRA: <br>" 
									+ "Compra: " + titulo + "<br>" 
									+ "Tipo: " + tipo + "<br>"
									+ "Solicitado por " + solicitante + "<br>"
									+ "Cantidad: " + cantidad + "<br>"
									+ "Descripción: " + descripcion + "<br>"
									+ "Comentario: " + comentario + "<br><br>"
									
									+ "Fecha límite de aprobación: " + fechaEstimada.substring(0, 10) + "<br><br><br>"
									
									+"Este e-mail se ha generado automáticamente. Por favor, no contestes a este e-mail.");
				}
			}

		}

	}
}
