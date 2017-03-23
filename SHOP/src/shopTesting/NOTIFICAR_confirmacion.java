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

		String estado = currEnt.getAttribute("SH_ESTADO_APROBACION_COMPRA_STR").getValueAsString();

		boolean notificarAvanzar = false;
		boolean notificarPresupuesto = false;
		boolean notificarDormir = false;
		boolean notificarCancelar = false;

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

						this.sendMail(mailEnviar, "ADMINISTRACION_Se aprobó la compra. " + titulo,
								"Hola Karen, <br> <br>" + "Confirmamos que la nueva compra solicitada por "
										+ solicitante + " ha sido aprobada correctamente. <br><br>"

										+ "Saludos, Apia :)");
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

						this.sendMail(mailEnviar, "ADMINISTRACION_Se rechazó los presupuestos. " + titulo,
								"Hola Karen, <br> <br>"
										+ "Confirmamos que los presupuestos de la compra solicitada por " + solicitante
										+ " ha sido rechazada <br><br>"

										+ "Saludos, Apia :)");
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

						this.sendMail(mailEnviar, "ADMINISTRACION_Se colocó la compra en modo StandBy" + titulo,
								"Hola Karen, <br> <br>" + "Confirmamos que la nueva compra solicitada por "
										+ solicitante + " ha sido puesta en espera hasta nuevo aviso <br><br>"

										+ "Saludos, Apia :)");
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

						this.sendMail(mailEnviar, "ADMINISTRACION_Se canceló la compra" + titulo,
								"Hola Karen, <br> <br>" + "Confirmamos que la nueva compra solicitada por "
										+ solicitante + " ha sido cancelada. <br><br>"

										+ "Saludos, Apia :)");
					}
				}
			}

			break;

		}

	}
}
