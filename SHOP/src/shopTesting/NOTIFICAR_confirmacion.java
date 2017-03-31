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

public class NOTIFICAR_confirmacion extends ApiaAbstractClass {
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
		String fechafin = currEnt.getAttribute("SH_FECHA_FIN_PENDIENTE_FEC").getValueAsString();
		String comentarioAprobacion = currEnt.getAttribute("SH_COMENTARIO_APROBACION_COMPRA_STR").getValueAsString();

		String estado = currEnt.getAttribute("SH_ESTADO_APROBACION_COMPRA_STR").getValueAsString();

		boolean notificarAvanzar = true;
		boolean notificarPresupuesto = true;
		boolean notificarDormir = true;
		boolean notificarCancelar = true;

		switch (estado) {
		case "1": // AVANZAR

			if (notificarAvanzar) {
				String[] gruposNotificar = { "ADMINISTRACION_TESTING" };
				Collection<User> usuarios = null;

				for (int i = 0; i < gruposNotificar.length; i++) {
					usuarios = this.getGroup(gruposNotificar[i]).getUsers();
				}

				for (User u : usuarios) {
					String mail = u.getEmail();
					if (mail.compareTo("") != 0) {
						String[] mailEnviar = { mail };

						this.sendMail(mailEnviar, "COMPRA " + titulo + ": Presupuesto aprobado",
								"Le notificamos que para la compra " + titulo 
								+ " se ha <font color=green><strong>aprobado</strong></font> un presupuesto. <br><br>" 
						// Agregar presupuesto que Direccion elegio		
								+ "<h5>INFORMACIÓN DE LA COMPRA </h5>" 
								+ "-<i>Compra:</i> " + titulo + "<br>" 
								+ "-<i>Tipo:</i> " + tipo + "<br>"
								+ "-<i>Cantidad:</i> " + cantidad + "<br>"
								+ "-<i>Descripción:</i> " + descripcion + "<br>"
								+ "-<i>Comentario:</i> " + comentario + "<br><br>"
								
								+ "-Solicitado por " + solicitante + "<br><br><br>" 
								
								+ "<font color=gray>Este e-mail se ha generado automáticamente. Por favor, no contestes a este e-mail.</font>");
					}
				}
			}

			break;
		case "2": // VOLVER A PRESUPUESTO
			if (notificarPresupuesto) {
				String[] gruposNotificar1 = { "ADMINISTRACION_TESTING" };
				Collection<User> usuarios1 = null;

				for (int i = 0; i < gruposNotificar1.length; i++) {
					usuarios1 = this.getGroup(gruposNotificar1[i]).getUsers();
				}

				for (User u : usuarios1) {
					String mail = u.getEmail();
					if (mail.compareTo("") != 0) {
						String[] mailEnviar = { mail };

						this.sendMail(mailEnviar, "COMPRA " + titulo + ": Presupuestos rechazados",
								"Le notificamos que los presupuestos para la compra " + titulo
										+ " han sido rechazados. <br><br>"

										+ "<h5> INFORMACIÓN DE LA COMPRA </h5>" 
										+ "-<i>Compra:</i> " + titulo + "<br>" 
										+ "-<i>Tipo:</i> " + tipo + "<br>"
										+ "-<i>Cantidad:</i> " + cantidad + "<br>"
										+ "-<i>Descripción:</i> " + descripcion + "<br>"
										+ "-<i>Comentario:</i> " + comentario + "<br><br>"
										
										+"-Solicitado por " + solicitante + "<br><br>" 
										
										+ "<i>Comentario de dirección: </i>" + comentarioAprobacion + "<br><br><br>"

										+ "<font color=gray>Este e-mail se ha generado automáticamente. Por favor, no contestes a este e-mail.</font>");
					}
				}
			}
			break;
		case "3": // DORMIR
			if (notificarDormir) {
				String[] gruposNotificar11 = { "ADMINISTRACION_TESTING" };
				Collection<User> usuarios11 = null;

				for (int i = 0; i < gruposNotificar11.length; i++) {
					usuarios11 = this.getGroup(gruposNotificar11[i]).getUsers();
				}

				for (User u : usuarios11) {
					String mail = u.getEmail();
					if (mail.compareTo("") != 0) {
						String[] mailEnviar = { mail };

						this.sendMail(mailEnviar, "COMPRA " + titulo + ": en StandBy",
										"Le notificamos que para la compra " + titulo 
										+ " se ha puesto en espera. <br><br>" 
										
										+ "Fecha para retomar: " +"<font color=red>" + fechafin.substring(0, 10) + "</font><br><br>"
									
										+ "<h5> INFORMACIÓN DE LA COMPRA </h5>" 
										+ "-<i>Compra:</i> " + titulo + "<br>" 
										+ "-<i>Tipo:</i> " + tipo + "<br>"
										+ "-<i>Cantidad:</i> " + cantidad + "<br>"
										+ "-<i>Descripción:</i> " + descripcion + "<br>"
										+ "-<i>Comentario:</i> " + comentario + "<br><br>"
										
										+"-Solicitado por " + solicitante + "<br><br><br>" 
										
										+"<font color=gray>Este e-mail se ha generado automáticamente. Por favor, no contestes a este e-mail.</font>");
					}
				}
			}

			break;
		case "4": // CANCELAR
			if (notificarCancelar) {
				String[] gruposNotificar111 = { "ADMINISTRACION_TESTING" };
				Collection<User> usuarios111 = null;

				for (int i = 0; i < gruposNotificar111.length; i++) {
					usuarios111 = this.getGroup(gruposNotificar111[i]).getUsers();
				}

				for (User u : usuarios111) {
					String mail = u.getEmail();
					if (mail.compareTo("") != 0) {
						String[] mailEnviar = { mail };

						this.sendMail(mailEnviar, "COMPRA " + titulo + ": Cancelada",
								"Le notificamos que la compra " + titulo 
								+ " ha sido " + "<font color=red><strong>cancelada</strong></font>. <br><br>" 
							
								+"<h5> INFORMACIÓN DE LA COMPRA </h5>" 
								+ "-<i>Compra:</i> " + titulo + "<br>" 
								+ "-<i>Tipo:</i> " + tipo + "<br>"
								+ "-<i>Cantidad:</i> " + cantidad + "<br>"
								+ "-<i>Descripción:</i> " + descripcion + "<br>"
								+ "-<i>Comentario:</i> " + comentario + "<br><br>"
								
								+"-Solicitado por " + solicitante + "<br><br><br>"
								
								+"<font color=gray>Este e-mail se ha generado automáticamente. Por favor, no contestes a este e-mail.</font>");
					}
				}
			}

			break;

		}

	}
}
