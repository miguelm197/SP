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
		String proveedor = currEnt.getAttribute("SH_PROVEEDOR_SOLICITUD_COMPRA_INFO_STR").getValueAsString();
		String formapago = currEnt.getAttribute("SH_FORMADEPAGO_SOLICITA_COMPRA_STR").getValueAsString();
		String cantidad = currEnt.getAttribute("SH_CANTIDAD_INGRESO_COMPRA_STR").getValueAsString();
		String monto = currEnt.getAttribute("SH_MONTO_SOLICITUD_COMPRA_INFO_STR").getValueAsString();
		String moneda = currEnt.getAttribute("SH_MONEDA_SOLICITUD_COMPRA_INFO_STR").getValueAsString();
		String comentario = currEnt.getAttribute("SH_COMENTARIO_SOLICITA_COMPRA_STR").getValueAsString();

		String monedita;

		// String fechaSol =
		// currEnt.getAttribute("SH_FECHA_SOLICITUD_COMPRA_STR").getValueAsString();

		/* if (moneda.equals("Pesos")) {
			monedita = "$U";
		} else {
			monedita = "U$D";
		} */
 
		
		DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		Date fechaActual = new Date();
		String fechaSol = formatoFecha.format(fechaActual);

		boolean notificar = true;
		//boolean notificar = true;

		if (notificar) {
			String[] gruposNotificar = { "ADMINISTRACION_TESTING", "DIRECCION_TESTING" };
			Collection<User> usuarios = null;

			for (int i = 0; i < gruposNotificar.length; i++) {
				usuarios = this.getGroup(gruposNotificar[i]).getUsers();
			
				for (User u : usuarios) {
					String mail = u.getEmail();
					if (mail.compareTo("") != 0) {
						String[] mailEnviar = { mail };
	
						this.sendMail(mailEnviar, "TESTING | COMPRA " + titulo + ": en ejecución. ",
								"Le notificamos que la compra " + titulo + " esta siendo solicitada al proveedor. <br><br>"
	
										+ "<h3> INFORMACIÓN DE LA COMPRA </h3>" + "-<i>Compra:</i> " + titulo + "<br>"
										+ "-<i>Cantidad:</i> " + cantidad + "<br>" + "-<i>Proveedor:</i> " + proveedor
										+ "<br>" + "-<i>Forma de pago:</i> " + formapago + "<br><br>"
	
										+ "-<i>Total:</i> " + monto + "<br><br>"
	
										+ "-<i>Comentario:</i> " + comentario + "<br><br>"
	
										+ "-Fecha de solicitud: " + fechaSol.substring(0, 10) + "<br><br><br>"
	
										+ "<font color=gray>Este e-mail se ha generado automáticamente. Por favor, no responda a este e-mail.</font>");
					}
				}
			}
		}

	}
}
