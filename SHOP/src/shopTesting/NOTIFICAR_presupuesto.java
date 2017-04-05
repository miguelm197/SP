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

public class NOTIFICAR_presupuesto extends ApiaAbstractClass {
	@Override
	protected void executeClass() throws BusClassException {

		Entity currEnt = this.getCurrentEntity();


		
		Collection prov = this.getCurrentEntity().getAttribute("SH_PROVEEDOR_PRESUPUESTO_INFO_STR").getValues();
		ArrayList proveedores = new ArrayList();
		proveedores.addAll(prov);

		Collection mont = this.getCurrentEntity().getAttribute("SH_MONTO_PRESUPUESTO_INFO_STR").getValues();
		ArrayList montos = new ArrayList();
		montos.addAll(mont);

		Collection mone = this.getCurrentEntity().getAttribute("SH_MONEDA_PRESUPUESTO_INFO_STR").getValues();
		ArrayList monedas = new ArrayList();
		monedas.addAll(mone);

		Collection cump = this.getCurrentEntity().getAttribute("SH_CUMPLIMIENTO_PRESUPUESTO_INFO_STR").getValues();
		ArrayList cumplimientos = new ArrayList();
		cumplimientos.addAll(cump);

		Collection come = this.getCurrentEntity().getAttribute("SH_COMENTARIO_PRESUPUESTO_INFO_STR").getValues();
		ArrayList comentarios = new ArrayList();
		comentarios.addAll(come);

		String titulo = currEnt.getAttribute("SH_TITULO_INGRESO_COMPRA_STR").getValueAsString();
		String solicitante = currEnt.getAttribute("SH_SOLICITANTE_INGRESO_COMPRA_STR").getValueAsString();
		String tipo = currEnt.getAttribute("SH_TIPO_INGRESO_COMPRA_STR").getValueAsString();
		String fechaEstimada = currEnt.getAttribute("SH_FECHAFIN_INGRESO_COMPRA_FEC").getValueAsString();
		String descripcion = currEnt.getAttribute("SH_DESCRIPCION_INGRESO_COMPRA_STR").getValueAsString();
		String comentarioDir = currEnt.getAttribute("SH_COMENTARIODIR_PRESUPUESTO_STR").getValueAsString();
		String cantidad = currEnt.getAttribute("SH_CANTIDAD_INGRESO_COMPRA_STR").getValueAsString();

		int ult = proveedores.size() - 1;

		String proveedor = proveedores.get(ult).toString();
		String monto = montos.get(ult).toString();
		String cumplimiento = cumplimientos.get(ult).toString();
		String comentario = comentarios.get(ult).toString();

		String envDir = currEnt.getAttribute("SH_FINPRESUPUESTO_PRESUPUESTO_COMPRA_STR").getValuesAsString();

		boolean notificarPresupuesto = false;
		boolean notificarAprobacion = true;

		if (envDir.equals("true")) {
			// ENVIO A DIRECCION

			if (notificarAprobacion) {
				String[] gruposNotificar = { "DIRECCION_TESTING" };
				Collection<User> usuarios = null;


				for (int i = 0; i < gruposNotificar.length; i++) {
					usuarios = this.getGroup(gruposNotificar[i]).getUsers();
				}

				for (User u : usuarios) {
					String mail = u.getEmail();
					if (mail.compareTo("") != 0) {
						String[] mailEnviar = { mail };
						this.sendMail(mailEnviar, "COMPRA " + titulo + ": en espera de ser aprobada. ",
								"Le notificamos que hay una compra en espera de ser aprobada. <br><br>"
										+ "<h3> INFORMACIÓN DE LA COMPRA </h3>" + "-<i>Compra:</i> " + titulo + "<br>"
										+ "-<i>Tipo:</i> " + tipo + "<br>" + "-<i>Cantidad:</i> " + cantidad + "<br>"
										+ "-<i>Descripción:</i> " + descripcion + "<br>" + "-<i>Comentario:</i> "
										+ comentario + "<br><br>" + "-Solicitado por " + solicitante + "<br><br>"

										+ "<i>Comentario de administración: </i>" + comentarioDir + "<br><br><br>"

										+ "<font color=gray>Este e-mail se ha generado automáticamente. Por favor, no responda a este e-mail.</font>");
					}
				}
			}

		} else {
			if (notificarPresupuesto) {
				String[] gruposNotificar = { "ADMINISTRACION_TESTING" };
				Collection<User> usuarios = null;

				for (int i = 0; i < gruposNotificar.length; i++) {
					usuarios = this.getGroup(gruposNotificar[i]).getUsers();
				}

				for (User u : usuarios) {
					String mail = u.getEmail();
					if (mail.compareTo("") != 0) {
						String[] mailEnviar = { mail };

						this.sendMail(mailEnviar, "COMPRA " + titulo + ": nuevo presupuesto",
								"Le notificamos que hay una compra en espera de ser aprobada. <br><br>"

										+ "<h3> INFORMACIÓN DE LA COMPRA </h3>" + "-<i>Compra:</i> " + titulo + "<br>"
										+ "-<i>Tipo:</i> " + tipo + "<br>" + "-Solicitado por " + solicitante
										+ "<br><br>"

										+ "<h3>INFORMACIÓN DEL PRESUPUESTO </h3>" + "-<i>Proveedor: <i>" + proveedor
										+ "<br>" + "-<i>Monto: <i>" + monto + " (Incluye IVA) <br>"
										+ "-<i>Cumplimiento: <i>" + cumplimiento + "<br>" + "-<i>Comentario:<i> "
										+ comentario + "<br><br><br>"

										+ "<font color=gray>Este e-mail se ha generado automáticamente. Por favor, no responda a este e-mail.</font>");
					}
				}
			}
		}

	}

}
