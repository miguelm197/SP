package shopTesting;

import com.dogma.busClass.ApiaAbstractClass;
import com.dogma.busClass.BusClassException;
import com.dogma.busClass.object.Field;

public class verComentario extends ApiaAbstractClass{

	@Override
	protected void executeClass() throws BusClassException {
		
		Field currBtn = (Field) this.getEvtSource();
		int index = currBtn.getFireIndex();
		
		String comentario = this.getCurrentEntity().getAttribute("SH_COMENTARIO_PRESUPUESTO_INFO_STR").getValueAsString(index);
		
		this.addMessage(comentario);
	}

}
