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

public class Scheduler extends ApiaAbstractClass {
	@Override
	protected void executeClass() throws BusClassException {

		String entType = "SHOP";
		String preFix = null;
		int number = 19;
		String postFix = null;
	
		Entity ent = this.getEntity(entType, preFix, number, postFix);
		 
	
		Collection prov = ent.getAttribute("SH_PROVEEDOR_PRESUPUESTO_INFO_STR").getValues();
		ArrayList proveedores = new ArrayList();
//		proveedores.addAll(prov);
		
		Collection mont = ent.getAttribute("SH_MONTO_PRESUPUESTO_INFO_STR").getValues();
		ArrayList montos = new ArrayList();
//		montos.addAll(mont);
		
		Collection cump = ent.getAttribute("SH_CUMPLIMIENTO_PRESUPUESTO_INFO_STR").getValues();
		ArrayList cumplimientos = new ArrayList();
//		cumplimientos.addAll(cump);
		
		Collection come = ent.getAttribute("SH_COMENTARIO_PRESUPUESTO_INFO_STR").getValues();
		ArrayList comentarios = new ArrayList();
//		comentarios.addAll(come);
		
		int index = 0;
			
		       
		ent.getAttribute("SH_PROVEEDOR_PRESUPUESTO_INFO_STR").setValues(proveedores);
		ent.getAttribute("SH_MONTO_PRESUPUESTO_INFO_STR").setValues(montos);
		ent.getAttribute("SH_CUMPLIMIENTO_PRESUPUESTO_INFO_STR").setValues(cumplimientos);
//		ent.getAttribute("SH_COMENTARIO_PRESUPUESTO_INFO_STR").setValues(comentarios);
		ent.getAttribute("SH_FAVORITOADMIN_PRESUPUESTO_INFO_STR").setValues(comentarios);
		ent.getAttribute("SH_COMPROBANTE_PRESUPUESTO_INFO_STR").setValues(comentarios);
		
		
		/*
		 * 9882 Diser 8950 + Iva 10919                 
		 */
	}
}
 