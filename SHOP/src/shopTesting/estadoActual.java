package shopTesting;

import com.dogma.busClass.ApiaAbstractClass;
import com.dogma.busClass.BusClassException;
import com.dogma.busClass.object.Attribute;
import com.dogma.busClass.object.Entity;
import com.dogma.busClass.object.PossibleValue;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;

public class estadoActual extends ApiaAbstractClass {
	@Override
	protected void executeClass() throws BusClassException {

		
		Entity currEnt = this.getCurrentEntity();

		String nomTask = this.getCurrentTask().getTaskName().toString();
		String nomSoli = currEnt.getAttribute("SH_SOLICITANTE_INGRESO_COMPRA_STR").getValueAsString();
		String envDir = currEnt.getAttribute("SH_FINPRESUPUESTO_PRESUPUESTO_COMPRA_STR").getValuesAsString();
		String estado = currEnt.getAttribute("SH_ESTADO_APROBACION_COMPRA_STR").getValueAsString();

		
	
		switch (nomTask) {

		case "SH_INGRESO_COMPRA":
			currEnt.getAttribute("SH_ESTADO_ACTUAL_STR").setValue("Ingreso de presupuestos");
			break;

		case "SH_PRESUPUESTOS_COMPRA":
			if (envDir.equals("false")) {
				currEnt.getAttribute("SH_ESTADO_ACTUAL_STR").setValue("Ingreso de presupuestos");
			} else {
				currEnt.getAttribute("SH_ESTADO_ACTUAL_STR").setValue("Aprobación de compra, en Dirección");
			}

		case "SH_APROBAR_COMPRA":
			switch (estado) {

			case "1":
				// AVANZA
				currEnt.getAttribute("SH_ESTADO_ACTUAL_STR").setValue("Solicitar Compra");
				break;

			case "2":
				// VUELVE A PRESUPUESTO
				currEnt.getAttribute("SH_ESTADO_ACTUAL_STR").setValue("Ingreso de presupuestos");
				break;

			case "3":
				// DORMIDO
				currEnt.getAttribute("SH_ESTADO_ACTUAL_STR").setValue("Pospuesto");
				break;

			case "4":
				// CANCELADO
				currEnt.getAttribute("SH_ESTADO_ACTUAL_STR").setValue("Cancelado");
				break;
			}
			break;
			
		case "SH_PENDIENTE_COMPRA":
			currEnt.getAttribute("SH_ESTADO_ACTUAL_STR").setValue("Retornada");
			break;
			
		case "SH_SOLICITAR_COMPRA":
			currEnt.getAttribute("SH_ESTADO_ACTUAL_STR").setValue("Finalizar Compra");
			break;

		case "SH_FINALIZACION_COMPRA":
			currEnt.getAttribute("SH_ESTADO_ACTUAL_STR").setValue("Compra Finalizada");
			break;

		}
		
		
		
		String estadoActual = currEnt.getAttribute("SH_ESTADO_ACTUAL_STR").getValueAsString();
		Collection esta = currEnt.getAttribute("SH_INFO_ESTADO_ACTUAL_STR").getValues();
		esta.add(estadoActual);
		currEnt.getAttribute("SH_INFO_ESTADO_ACTUAL_STR").setValues(esta);
		
		DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date fechaActual = new Date();
		String FechaActS = formatoFecha.format(fechaActual);
		
		try {
			fechaActual = formatoFecha.parse(FechaActS);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Collection fech = currEnt.getAttribute("SH_INFO_FECHA_DIRECCION_FEC").getValues();
		fech.add(fechaActual);
		currEnt.getAttribute("SH_INFO_FECHA_DIRECCION_FEC").setValues(fech);
		
		
		
	}
}
