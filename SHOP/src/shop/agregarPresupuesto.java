package shop;

import com.dogma.busClass.ApiaAbstractClass;
import com.dogma.busClass.BusClassException;
import com.dogma.busClass.object.Attribute;
import com.dogma.busClass.object.Document;
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

public class agregarPresupuesto extends ApiaAbstractClass {
	
	@Override
	protected void executeClass() throws BusClassException {
		// currEnt.getAttribute("").clear();

		// SH_COMPROBANTE_PRESUPUESTO_COMPRA_STR
		// SH_COMPROBANTE_PRESUPUESTO_INFO_STR

		Entity currEnt = this.getCurrentEntity();
		String envDir = currEnt.getAttribute("SH_FINPRESUPUESTO_PRESUPUESTO_COMPRA_STR").getValuesAsString();
		// String listo =
		// currEnt.getAttribute("SH_LISTO_PRESUPUESTOS_STR").getValuesAsString();

		String iva = currEnt.getAttribute("SH_IVA_PRESUPUESTO_STR").getValueAsString();
		String suma = currEnt.getAttribute("SH_MONTO_MAS_IVA_PRESUPUESTOS_STR").getValueAsString();

		// if (listo.equals("false")) {
		if (envDir.equals("false")) {
			if (iva.equals("Sin IVA")) {
				currEnt.getAttribute("SH_MONTO_PRESUPUESTO_COMPRA_STR").setValue(suma);

			}
			// Se obtiene los valores de los campos
			String proveedor = currEnt.getAttribute("SH_PROVEEDOR_PRESUPUESTO_COMPRA_STR").getValueAsString();
			String cumplimiento = currEnt.getAttribute("SH_CUMPLIMIENTO_PRESUPUESTO_COMPRA_STR").getValueAsString();
			String comprobante = currEnt.getAttribute("SH_COMPROBANTE_PRESUPUESTO_COMPRA_STR").getValueAsString();
			String monto = currEnt.getAttribute("SH_MONTO_PRESUPUESTO_COMPRA_STR").getValueAsString();
			String moneda = currEnt.getAttribute("SH_MONEDA_PRESUPUESTO_COMPRA_STR").getValueAsString();
			String comentario = currEnt.getAttribute("SH_COMENTARIO_PRESUPUESTO_COMPRA_STR").getValueAsString();

			if (proveedor != "" && monto != "") {

				String monedita;
				if (moneda.equals("Pesos")) {
					monedita = "$U";
				} else {
					monedita = "U$D";
				}

				boolean bandera = true;
				double mon;
				int cum;

				try {
					mon = Double.parseDouble(monto);
				} catch (Exception e) {
					bandera = false;
					throw new BusClassException("Ingreso de monto inválido");
				}

				if (mon < 0) {
					throw new BusClassException("El monto debe ser mayor a 0");
				}

				if (bandera == true) {
					// Se obtiene la coleccion de los atributos de la tabla y se
					// le
					// agregan
					// los atributos nuevos
					Collection prov = currEnt.getAttribute("SH_PROVEEDOR_PRESUPUESTO_INFO_STR").getValues();
					prov.add(proveedor);

					Collection cump = currEnt.getAttribute("SH_CUMPLIMIENTO_PRESUPUESTO_INFO_STR").getValues();
					cump.add(cumplimiento);

					Collection mont = currEnt.getAttribute("SH_MONTO_PRESUPUESTO_INFO_STR").getValues();
					mont.add(monedita + " " + monto);

					// Collection mone =
					// currEnt.getAttribute("SH_MONEDA_PRESUPUESTO_INFO_STR").getValues();
					// mone.add(moneda);

					Collection come = currEnt.getAttribute("SH_COMENTARIO_PRESUPUESTO_INFO_STR").getValues();
					come.add(comentario);

					// Se setean (cargan) las nuevas colecciones a los atributos
					// de
					// la
					// tabla
					currEnt.getAttribute("SH_PROVEEDOR_PRESUPUESTO_INFO_STR").setValues(prov);
					currEnt.getAttribute("SH_CUMPLIMIENTO_PRESUPUESTO_INFO_STR").setValues(cump);
					currEnt.getAttribute("SH_MONTO_PRESUPUESTO_INFO_STR").setValues(mont);
					// currEnt.getAttribute("SH_MONEDA_PRESUPUESTO_INFO_STR").setValues(mone);
					currEnt.getAttribute("SH_COMENTARIO_PRESUPUESTO_INFO_STR").setValues(come);
					currEnt.getAttribute("SH_IVA_PRESUPUESTO_STR").setValue("Con IVA");

				}
			}

		} else {
			Collection favs = this.getCurrentEntity().getAttribute("SH_FAVORITOADMIN_PRESUPUESTO_INFO_STR").getValues();
			ArrayList favoritos = new ArrayList();
			favoritos.addAll(favs);

			int cont = 0;

			for (int i = 0; i < favoritos.size(); i++) {
				if (favoritos.get(i).toString().compareTo("true") == 0) {
					cont = cont + 1;
				}
			}

			if (cont == 0) {
				throw new BusClassException("Debe seleccionar al menos 1 favorito");
			}
			String nomUser = this.getCurrentUser().getName();
			String coment = currEnt.getAttribute("SH_COMENTARIODIR_PRESUPUESTO_STR").getValueAsString();

			DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			Date fechaActual = new Date();
			String FechaActS = formatoFecha.format(fechaActual);

			String comentario = FechaActS + " - " + nomUser + ": " + coment + "\n\n";

			Collection chat = this.getCurrentEntity().getAttribute("SH_CHAT_STR").getValues();
			chat.add(comentario);
			currEnt.getAttribute("SH_CHAT_STR").setValues(chat);

			currEnt.getAttribute("SH_ESTADO_APROBACION_COMPRA_STR").setValue("Avanzar");

		}
		// }
		// currEnt.getAttribute("SH_LISTO_PRESUPUESTOS_STR").clear();
	}
}
