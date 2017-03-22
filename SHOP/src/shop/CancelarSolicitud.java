package shop;

import com.dogma.busClass.ApiaAbstractClass;
import com.dogma.busClass.BusClassException;
import com.dogma.busClass.object.Attribute;
import com.dogma.busClass.object.Entity;
import com.dogma.busClass.object.User;


/**
 * Se ejecuta cuando se cancela un proceso de licencia en Apia. Se setean los atributos Proceso Finalizado -> Sí y Estado Actual de la licencia -> Cancelado. Además se envía un mail al creador del proceso indicando que se canceló el mismo.
 */
public class CancelarSolicitud extends ApiaAbstractClass{

	@Override
	protected void executeClass() throws BusClassException {
		
		
	}

}
