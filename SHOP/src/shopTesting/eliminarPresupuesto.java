package shopTesting;

import java.util.ArrayList;
import java.util.Collection;

import com.dogma.busClass.ApiaAbstractClass;
import com.dogma.busClass.BusClassException;
import com.dogma.busClass.object.Entity;
import com.dogma.busClass.object.Field;

public class eliminarPresupuesto extends ApiaAbstractClass {

	@Override
	protected void executeClass() throws BusClassException {

		Entity currEnt = this.getCurrentEntity();

		Collection provPres = currEnt.getAttribute(
				"SH_PROVEEDOR_PRESUPUESTO_INFO_STR").getValues();
		ArrayList provPresArr = new ArrayList<>();
		provPresArr.addAll(provPres);
		Collection cumpPres = currEnt.getAttribute(
				"SH_CUMPLIMIENTO_PRESUPUESTO_INFO_STR").getValues();
		ArrayList cumpPresArr = new ArrayList<>();
		cumpPresArr.addAll(cumpPres);
		Collection mntPres = currEnt.getAttribute(
				"SH_MONTO_PRESUPUESTO_INFO_STR").getValues();
		ArrayList mntPresArr = new ArrayList<>();
		mntPresArr.addAll(mntPres);
		Collection comPres = currEnt.getAttribute(
				"SH_COMENTARIO_PRESUPUESTO_INFO_STR").getValues();
		ArrayList comPresArr = new ArrayList<>();
		comPresArr.addAll(comPres);
		
		Collection pdfPres = currEnt.getAttribute(
				"SH_COMPROBANTE_PRESUPUESTO_INFO_STR").getValues();
		ArrayList pdfPresArr = new ArrayList<>();
		pdfPresArr.addAll(pdfPres);
		Collection favPres = currEnt.getAttribute(
				"SH_FAVORITOADMIN_PRESUPUESTO_INFO_STR").getValues();
		ArrayList favPresArr = new ArrayList<>();
		favPresArr.addAll(favPres);

		Field currBtn = (Field) this.getEvtSource();
		int index = currBtn.getFireIndex();

		/*
		 * this.addMessage("index: "+index);
		 * 
		 * this.addMessage("provPres: "+ provPresArr.size());
		 * this.addMessage("cumpPres: "+ cumpPresArr.size());
		 * this.addMessage("mntPres: "+ mntPresArr.size());
		 * this.addMessage("comPres: "+ comPresArr.size());
		 * this.addMessage("pdfPres: "+ pdfPresArr.size());
		 * this.addMessage("favPres: "+ favPresArr.size());
		 */

		provPresArr.remove(index);
		cumpPresArr.remove(index);
		mntPresArr.remove(index);
		comPresArr.remove(index);
		favPresArr.remove(index);

		try {
			pdfPresArr.remove(index);
		} catch (Exception e) {
			e.printStackTrace();
		}

		currEnt.getAttribute("SH_PROVEEDOR_PRESUPUESTO_INFO_STR").setValues(
				provPresArr);
		currEnt.getAttribute("SH_CUMPLIMIENTO_PRESUPUESTO_INFO_STR").setValues(
				cumpPresArr);
		currEnt.getAttribute("SH_MONTO_PRESUPUESTO_INFO_STR").setValues(
				mntPresArr);
		currEnt.getAttribute("SH_COMENTARIO_PRESUPUESTO_INFO_STR").setValues(
				comPresArr);
		currEnt.getAttribute("SH_COMPROBANTE_PRESUPUESTO_INFO_STR").setValues(
				pdfPresArr);
		currEnt.getAttribute("SH_FAVORITOADMIN_PRESUPUESTO_INFO_STR")
				.setValues(favPresArr);

	}

}
