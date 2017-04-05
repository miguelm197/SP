package shopTesting;

import com.dogma.busClass.ApiaAbstractClass;
import com.dogma.busClass.BusClassException;
import com.dogma.busClass.object.Attribute;
import com.dogma.busClass.object.PossibleValue;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;

public class cargarMontoSolicitaCompra extends ApiaAbstractClass {
	@Override
	protected void executeClass() throws BusClassException {

		Collection favs = this.getCurrentEntity().getAttribute("SH_FAVORITODIREC_PRESUPUESTO_INFO_STR").getValues();
		ArrayList favoritos = new ArrayList();
		favoritos.addAll(favs);

		Collection mont = this.getCurrentEntity().getAttribute("SH_MONTO_PRESUPUESTO_INFO_STR").getValues();
		ArrayList montos = new ArrayList();
		montos.addAll(mont);

		Collection mone = this.getCurrentEntity().getAttribute("SH_MONEDA_PRESUPUESTO_INFO_STR").getValues();
		ArrayList monedas = new ArrayList();
		monedas.addAll(mone);

		Collection prov = this.getCurrentEntity().getAttribute("SH_PROVEEDOR_PRESUPUESTO_INFO_STR").getValues();
		ArrayList proveedores = new ArrayList();
		proveedores.addAll(prov);

		
		int f = 0;
		// this.addMessage("Cantidad de presupuestos: " + favoritos.size() +
		// "");
		// this.addMessage("Valor del favorito: " + montos.get(f));
		for (int i = 0; i < favoritos.size(); i++) {
			if (favoritos.get(i).equals("true")) {
				//this.addMessage("valor: " + favoritos.get(i));
				f = i;
			}
		}

		this.getCurrentEntity().getAttribute("SH_MONTO_SOLICITUD_COMPRA_INFO_STR").setValue(montos.get(f));
		// //this.getCurrentEntity().getAttribute("SH_MONEDA_SOLICITUD_COMPRA_INFO_STR").setValue(monedas.get(f));
		this.getCurrentEntity().getAttribute("SH_PROVEEDOR_SOLICITUD_COMPRA_INFO_STR").setValue(proveedores.get(f));

	}
}