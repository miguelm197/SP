package shopTesting;

import com.dogma.busClass.ApiaAbstractClass;
import com.dogma.busClass.BusClassException;
import com.dogma.busClass.object.Attribute;
import com.dogma.busClass.object.Entity;
import com.dogma.busClass.object.Field;
import com.dogma.busClass.object.PossibleValue;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;

public class verComentarioListaPresupuesto extends ApiaAbstractClass {
	@Override
	protected void executeClass() throws BusClassException {
	
		//Hola, no explote :)
		int index = 0;   //make sure the event source is a field   
		if(this.getEvtSource() instanceof Field){   
			Field gridColumn = (Field)this.getEvtSource();    
		//get index that triggered the event    
		index = gridColumn.getFireIndex();   
		}  
		
		String comentario = getCurrentEntity().getAttribute("").getValue(index).toString();
		


		
	}
}



