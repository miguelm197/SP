package shopTesting;

import com.dogma.busClass.ApiaAbstractClass;
import com.dogma.busClass.BusClassException;
import com.dogma.busClass.object.Attribute;
import com.dogma.busClass.object.Entity;
import com.dogma.busClass.object.PossibleValue;
import com.dogma.vo.IProperty;

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

		// Entidad de la compra seleccionada
		String estadoActual = ent.getAttribute("SH_ESTADO_ACTUAL_STR").getValueAsString();

		//SINCRONIZACION DE DATOS GENERALES
		if (estadoActual != "") {
			// Obtenemos la información general de la compra
			
			//ent.getForm("SH_RO_INFO_GRAL").setFormProperty(IProperty.PROPERTY_FORM_HIDDEN, false);
			

			String att1 = ent.getAttribute("SH_TITULO_INGRESO_COMPRA_STR").getValueAsString();
			String att2 = ent.getAttribute("SH_CANTIDAD_INGRESO_COMPRA_STR").getValueAsString();
			String att3 = ent.getAttribute("SH_TIPO_INGRESO_COMPRA_STR").getValueAsString();
			String att4 = ent.getAttribute("SH_SOLICITANTE_INGRESO_COMPRA_STR").getValueAsString();
			String att5 = ent.getAttribute("SH_FECHAFIN_INGRESO_COMPRA_FEC").getValueAsString();
			String att6 = ent.getAttribute("SH_DESCRIPCION_INGRESO_COMPRA_STR").getValueAsString();
			String att7 = ent.getAttribute("SH_COMENTARIO_INGRESO_COMPRA_STR").getValueAsString();

			this.getCurrentEntity().getAttribute("SH_RO_GRAL_TITULO").setValue(att1);
			this.getCurrentEntity().getAttribute("SH_RO_GRAL_CANTIDAD").setValue(att2);
			this.getCurrentEntity().getAttribute("SH_RO_GRAL_TIPO").setValue(att3);
			this.getCurrentEntity().getAttribute("SH_RO_GRAL_SOLICITANTE").setValue(att4);
			this.getCurrentEntity().getAttribute("SH_RO_GRAL_FECHA_LIMITE_APROBACION").setValue(att5);
			this.getCurrentEntity().getAttribute("SH_RO_GRAL_DESCRIPCION").setValue(att6);
			this.getCurrentEntity().getAttribute("SH_RO_GRAL_COMENTARIO").setValue(att7);
		}

		//SINCRONIZACION DE PRESUPUESTOS
		if (estadoActual.equals("Ingreso de presupuestos")
				|| estadoActual.equals("Aprobación de compra, en Dirección") 
				|| estadoActual.equals("Solicitar Compra")
				|| estadoActual.equals("Pospuesto") 
				|| estadoActual.equals("Cancelado")
				|| estadoActual.equals("Retornada") 
				|| estadoActual.equals("Finalizar Compra")
				|| estadoActual.equals("Compra Finalizada")) {
			
		//	ent.getForm("SH_RO_INFO_PRESUPUESTOS").setFormProperty(IProperty.PROPERTY_FORM_HIDDEN, false);

			// Obtenemos todos los presupuestos ingresados por administracion
			Collection att1 = ent.getAttribute("SH_PROVEEDOR_PRESUPUESTO_INFO_STR").getValues();
			Collection att2 = ent.getAttribute("SH_CUMPLIMIENTO_PRESUPUESTO_INFO_STR").getValues();
			Collection att3 = ent.getAttribute("SH_MONTO_PRESUPUESTO_INFO_STR").getValues();
			Collection att4	 = ent.getAttribute("SH_COMENTARIO_PRESUPUESTO_INFO_STR").getValues();
			Collection att5 = ent.getAttribute("SH_COMPROBANTE_PRESUPUESTO_INFO_STR").getValues();
			Collection att6 = ent.getAttribute("SH_FAVORITOADMIN_PRESUPUESTO_INFO_STR").getValues();


			this.getCurrentEntity().getAttribute("SH_RO_PRES_PROVEEDOR_STR").setValues(att1);
			this.getCurrentEntity().getAttribute("SH_RO_PRES_CUMPLIMIENTO_STR").setValues(att2);
			this.getCurrentEntity().getAttribute("SH_RO_PRES_MONTO_STR").setValues(att3);
			this.getCurrentEntity().getAttribute("SH_RO_PRES_COMENTARIO_STR").setValues(att4);
			this.getCurrentEntity().getAttribute("SH_RO_PRES_COMPROBANTE_STR").setValues(att5);
			this.getCurrentEntity().getAttribute("SH_RO_PRES_FAV_STR").setValues(att6);
		}

		//SINCRONIZACION DE ESTADOS, CHAT Y FECHAS
		if (false 
				|| estadoActual.equals("Ingreso de presupuestos")
				|| estadoActual.equals("Aprobación de compra, en Dirección")
				|| estadoActual.equals("Solicitar Compra") 
				|| estadoActual.equals("Pospuesto")
				|| estadoActual.equals("Cancelado") 
				|| estadoActual.equals("Retornada")
				|| estadoActual.equals("Finalizar Compra")
				|| estadoActual.equals("Compra Finalizada")) {

		//	ent.getForm("SH_RO_INFO_HISTORIAL").setFormProperty(IProperty.PROPERTY_FORM_HIDDEN, false);
					
			Collection att1 = ent.getAttribute("SH_INFO_ESTADO_ACTUAL_STR").getValues();
			Collection att2 = ent.getAttribute("SH_CHAT_STR").getValues();
			Collection att3 = ent.getAttribute("SH_INFO_FECHA_DIRECCION_FEC").getValues();
		
			this.getCurrentEntity().getAttribute("SH_RO_INFO_ESTADO_ACTUAL_STR").setValues(att1);
			this.getCurrentEntity().getAttribute("SH_RO_INFO_CHAT_STR").setValues(att2);
			this.getCurrentEntity().getAttribute("SH_RO_INFO_FECHA_DIRECCION_FEC").setValues(att3);		}
			
		//SINCRONIZACION DE SOLICITUD DE COMPRA
		if (false 
				|| estadoActual.equals("Solicitar Compra") 
				|| estadoActual.equals("Finalizar Compra")
				|| estadoActual.equals("Compra Finalizada")) {
				
			
		//	ent.getForm("SH_RO_INFO_SOLICITAR_COMPRA").setFormProperty(IProperty.PROPERTY_FORM_HIDDEN, false);
			
			SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			
			String att1 = ent.getAttribute("SH_PROVEEDOR_SOLICITUD_COMPRA_INFO_STR").getValueAsString();
			String att2 = ent.getAttribute("SH_MONTO_SOLICITUD_COMPRA_INFO_STR").getValueAsString();
			String att3 = ent.getAttribute("SH_FECHA_SOLICITA_COMPRA_FEC").getValueAsString();
			String att4 = ent.getAttribute("SH_FORMADEPAGO_SOLICITA_COMPRA_STR").getValueAsString();
			String att5 = ent.getAttribute("SH_COMENTARIO_SOLICITA_COMPRA_STR").getValueAsString();
			
			Date fecha = null;
			try {
				fecha = formatoFecha.parse(att3);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			this.getCurrentEntity().getAttribute("SH_RO_SOL_PROVEEDOR_STR").setValue(att1);
			this.getCurrentEntity().getAttribute("SH_RO_SOL_MONTO_STR").setValue(att2);
			this.getCurrentEntity().getAttribute("SH_RO_SOL_FECHA_ENTREGA_FEC").setValue(fecha);
			this.getCurrentEntity().getAttribute("SH_RO_SOL_FORMA_PAGO_STR").setValue(att4);
			this.getCurrentEntity().getAttribute("SH_RO_SOL_COMENTARIO_STR").setValue(att5);
		}
		
		//SINCRONIZACION DE FINALIZACION
		if (false 
				|| estadoActual.equals("Finalizar Compra")
				|| estadoActual.equals("Compra Finalizada")) {

			//ent.getForm("SH_RO_INFO_FINAL").setFormProperty(IProperty.PROPERTY_FORM_HIDDEN, false);
			
			SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			
			
			String att1 = ent.getAttribute("SH_COMPRA_FINAL_STR").getValueAsString();
			String att2 = ent.getAttribute("SH_PUNTAJE_FINAL_STR").getValueAsString();
			String att3 = ent.getAttribute("SH_FECHA_FINAL_FEC").getValueAsString();
			String att4 = ent.getAttribute("SH_NOTAS_FINAL_STR").getValueAsString();
			String att5 = ent.getAttribute("SH_FACTURA_STR").getValueAsString();
			
			
			Date fecha = null;
			try {
				fecha = formatoFecha.parse(att3);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			this.getCurrentEntity().getAttribute("SH_RO_FIN_COMPRA_STR").setValue(att1);
			this.getCurrentEntity().getAttribute("SH_RO_FIN_PUNTAJE_STR").setValue(att2);
			this.getCurrentEntity().getAttribute("SH_RO_FIN_FECHA_FEC").setValue(fecha);
			this.getCurrentEntity().getAttribute("SH_RO_FIN_NOTA_STR").setValue(att4);
			this.getCurrentEntity().getAttribute("SH_RO_FIN_FACTURA_STR").setValue(att5);
		}
		
		
		
	}
}
