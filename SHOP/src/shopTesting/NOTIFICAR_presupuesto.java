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

		int ult = proveedores.size() - 1;

		String proveedor = proveedores.get(ult).toString();
		String monto = montos.get(ult).toString();
		String moneda = monedas.get(ult).toString();
		String cumplimiento = cumplimientos.get(ult).toString();
		String comentario = comentarios.get(ult).toString();

		String envDir = currEnt.getAttribute("SH_FINPRESUPUESTO_PRESUPUESTO_COMPRA_STR").getValuesAsString();

		if (envDir.equals("true")) {
			// ENVIO A DIRECCION

			String[] gruposNotificar = { "DIRECCION_TESTING" };
			Collection<User> usuarios = null;

			for (int i = 0; i < gruposNotificar.length; i++) {
				usuarios = this.getGroup(gruposNotificar[i]).getUsers();
			}

			for (User u : usuarios) {
				String mail = u.getEmail();
				if (mail.compareTo("") != 0) {
					String[] mailEnviar = { mail };
					
					this.sendMail(mailEnviar, "DIRECCION_Se ingresó una nueva compra "  + titulo,
							"Hola Marcos o José, <br> <br>" + "Le notificamos que tiene una compra para aprobar. <br><br>"
									+ "Información de la compra: <br>"

									+ "------------------------------------------------------------------------------ <br>"
									+ "		Titulo: " + titulo + "<br>" 
									+ "		Tipo: " + tipo + "<br>"
									+ "		Solicitante: " + solicitante + "<br>" 
									+ "		Fecha estimada: "+ fechaEstimada + "<br>" 
									+ "		Descripcion: " + descripcion + "<br>"
									+ "		Comentario: " + comentario + " <br>"
									+ "  -  -  -  -  -  -  -  -  -  -  -  -  -  -   - <br>" 
									+ "		Comentario Administración: " + comentarioDir + " <br>"
									+ "------------------------------------------------------------------------------ <br><br>"

									+ "Atte: El Gato con Botas!");
				}
			}

		} else {

			String[] gruposNotificar = { "ADMINISTRACION_TESTING" };
			Collection<User> usuarios = null;

			for (int i = 0; i < gruposNotificar.length; i++) { 
				usuarios = this.getGroup(gruposNotificar[i]).getUsers();
			}

			for (User u : usuarios) {
				String mail = u.getEmail();
				if (mail.compareTo("") != 0) {
					String[] mailEnviar = { mail };

					this.sendMail(mailEnviar, "ADMINISTRACION_Se ingresó un nuevo Presupuesto "  + titulo,
							"Hola Karen, <br> <br>"
									+ "Confirmamos que el nuevo presupuesto fue ingresado correctamente. <br><br>"
									+ "Información del presupuesto: <br>"

									+ "------------------------------------------------------------------------------ <br>"
									+ "     Compra: " + titulo + "<br>" + "     Tipo: " + tipo + "<br>"
									+ "     Solicitante: " + solicitante + "<br>"
									+ "  -  -  -  -  -  -  -  -  -  -  -  -  -  -   - <br>" + "     Proveedor: "
									+ proveedor + "<br>" + "     Monto: " + monto + " " + moneda + "<br>"
									+ "     Cumplimiento: " + cumplimiento + "<br>" + "     Comentario: " + comentario
									+ " <br><br>"
									+ "------------------------------------------------------------------------------ <br><br>"

									+ "Atte: El Gato con Botas!");
				}
			}

		}

	}
}
