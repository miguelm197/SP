package shop;

import com.dogma.busClass.ApiaAbstractClass;
import com.dogma.busClass.BusClassException;
import com.dogma.busClass.object.Attribute;
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

public class RO_cargarInfoGral extends ApiaAbstractClass {
	@Override
	protected void executeClass() throws BusClassException {

		String cod = this.getCurrentEntity().getAttribute("SH_RO_CODIGO_COMPRA").getValueAsString();

		String entType = "SHOP";
		String preFix = null;
		int number = Integer.parseInt(cod);
		String postFix = null;

		// INFO GENERAL
		Entity ent = this.getEntity(entType, preFix, number, postFix);

		//Entidad de la compra seleccionada
		String estadoActual = ent.getAttribute("SH_ESTADO_ACTUAL_STR").getValueAsString();

		if (estadoActual != "") {
			//Obtenemos la información general de la compra
			String titulo = ent.getAttribute("SH_TITULO_INGRESO_COMPRA_STR").getValueAsString();
			String cantidad = ent.getAttribute("SH_CANTIDAD_INGRESO_COMPRA_STR").getValueAsString();
			String tipo = ent.getAttribute("SH_TIPO_INGRESO_COMPRA_STR").getValueAsString();
			String solicitante = ent.getAttribute("SH_SOLICITANTE_INGRESO_COMPRA_STR").getValueAsString();
			String fechaAprobacion = ent.getAttribute("SH_FECHAFIN_INGRESO_COMPRA_FEC").getValueAsString();
			String descripcion = ent.getAttribute("SH_DESCRIPCION_INGRESO_COMPRA_STR").getValueAsString();
			String comentario = ent.getAttribute("SH_COMENTARIO_INGRESO_COMPRA_STR").getValueAsString();

			this.getCurrentEntity().getAttribute("SH_RO_GRAL_TITULO").setValue(titulo);
			this.getCurrentEntity().getAttribute("SH_RO_GRAL_CANTIDAD").setValue(cantidad);
			this.getCurrentEntity().getAttribute("SH_RO_GRAL_TIPO").setValue(tipo);
			this.getCurrentEntity().getAttribute("SH_RO_GRAL_SOLICITANTE").setValue(solicitante);
			this.getCurrentEntity().getAttribute("SH_RO_GRAL_FECHA_LIMITE_APROBACION").setValue(fechaAprobacion);
			this.getCurrentEntity().getAttribute("SH_RO_GRAL_DESCRIPCION").setValue(descripcion);
			this.getCurrentEntity().getAttribute("SH_RO_GRAL_COMENTARIO").setValue(comentario);
		}

		if (false 
				|| estadoActual.equals("Ingreso de presupuestos") 
				|| estadoActual.equals("Aprobación de compra, en Dirección")
				|| estadoActual.equals("Solicitar Compra") 
				|| estadoActual.equals("Pospuesto")
				|| estadoActual.equals("Cancelado") 
				|| estadoActual.equals("Retornada")
				|| estadoActual.equals("Finalizar Compra") 
				|| estadoActual.equals("Compra Finalizada")) {
			
			//Obtenemos todos los presupuestos ingresados por administracion
			Collection prov = ent.getAttribute("SH_PROVEEDOR_PRESUPUESTO_INFO_STR").getValues();
			Collection cump = ent.getAttribute("SH_CUMPLIMIENTO_PRESUPUESTO_INFO_STR").getValues();
			Collection mont = ent.getAttribute("SH_MONTO_PRESUPUESTO_INFO_STR").getValues();
			Collection come = ent.getAttribute("SH_COMENTARIO_PRESUPUESTO_INFO_STR").getValues();
			Collection arch = ent.getAttribute("SH_COMPROBANTE_PRESUPUESTO_INFO_STR").getValues();
			
			this.getCurrentEntity().getAttribute("SH_RO_GRAL_TITULO").setValues(prov);
			this.getCurrentEntity().getAttribute("SH_RO_GRAL_TITULO").setValues(cump);
			this.getCurrentEntity().getAttribute("SH_RO_GRAL_TITULO").setValues(mont);
			this.getCurrentEntity().getAttribute("SH_RO_GRAL_TITULO").setValues(come);
			this.getCurrentEntity().getAttribute("SH_RO_PRES_COMPROBANTE_STR").setValues(arch);

		}
		
		if (false 
				|| estadoActual.equals("Aprobación de compra, en Dirección")
				|| estadoActual.equals("Solicitar Compra") 
				|| estadoActual.equals("Pospuesto")
				|| estadoActual.equals("Cancelado") 
				|| estadoActual.equals("Retornada")
				|| estadoActual.equals("Finalizar Compra") 
				|| estadoActual.equals("Compra Finalizada")) {
			
			
			
			
		}
		
		

	}
}
