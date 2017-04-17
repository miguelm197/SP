package shopTesting;

import java.util.ArrayList;
import java.util.Collection;

import com.dogma.busClass.ApiaAbstractClass;
import com.dogma.busClass.BusClassException;
import com.dogma.busClass.object.Entity;
import com.dogma.busClass.object.Field;

public class eliminarPresupuesto extends ApiaAbstractClass{

	@Override
	protected void executeClass() throws BusClassException {
	
		Entity currEnt = this.getCurrentEntity();
		
		Collection provPres = currEnt.getAttribute("SH_PROVEEDOR_PRESUPUESTO_INFO_STR").getValues();
		ArrayList provPresArr = new ArrayList<>();
		provPresArr.addAll(provPres);
		Collection cumpPres = currEnt.getAttribute("SH_CUMPLIMIENTO_PRESUPUESTO_INFO_STR").getValues();
		ArrayList cumpPresArr = new ArrayList<>();
		cumpPresArr.addAll(cumpPres);
		Collection mntPres = currEnt.getAttribute("SH_MONTO_PRESUPUESTO_INFO_STR").getValues();
		ArrayList mntPresArr = new ArrayList<>();
		mntPresArr.addAll(mntPres);
		Collection comPres = currEnt.getAttribute("SH_COMENTARIO_PRESUPUESTO_INFO_STR").getValues();
		ArrayList comPresArr = new ArrayList<>();
		comPresArr.addAll(comPres);
		
		Field currBtn = (Field)this.getEvtSource();
		int index = currBtn.getFireIndex();
		
		provPresArr.remove(index);
		cumpPresArr.remove(index);
		mntPresArr.remove(index);
		comPresArr.remove(index);
		
		currEnt.getAttribute("SH_PROVEEDOR_PRESUPUESTO_INFO_STR").setValues(provPresArr);
		currEnt.getAttribute("SH_CUMPLIMIENTO_PRESUPUESTO_INFO_STR").setValues(cumpPresArr);
		currEnt.getAttribute("SH_MONTO_PRESUPUESTO_INFO_STR").setValues(mntPresArr);
		currEnt.getAttribute("SH_COMENTARIO_PRESUPUESTO_INFO_STR").setValues(comPresArr);
		
		
	}

}
