package org.kuali.student.common.ui.client.configurable.mvc.binding;

import java.util.ArrayList;
import java.util.Iterator;

import org.kuali.student.common.ui.client.mvc.DataModel;
import org.kuali.student.common.ui.client.widgets.ListOfStringWidget;
import org.kuali.student.core.assembly.data.Data;
import org.kuali.student.core.assembly.data.QueryPath;
import org.kuali.student.core.assembly.data.Data.DataValue;
import org.kuali.student.core.assembly.data.Data.Property;

public class ListOfStringBinding implements ModelWidgetBinding<ListOfStringWidget> {

	@Override
	public void setModelValue(ListOfStringWidget widget, DataModel model, String path) {
		Data data = new Data();
		DataValue listData = new Data.DataValue(data);
		for(String value:widget.getStringValues()){
			data.add(value);
		}
		model.set(QueryPath.parse(path), listData);
	}

	@Override
	public void setWidgetValue(ListOfStringWidget widget, DataModel model, String path) {
		Data data = model.get(path);
		ArrayList<String> values = new ArrayList<String>();
		if(data!=null){
			Iterator<Property> iter = data.realPropertyIterator();
			while(iter.hasNext()){
				Property prop = iter.next();
				String value = prop.getValue();
				values.add(value);
			}
		}
		widget.setStringValues(values);
	}

}