package org.kuali.student.common.ui.client.configurable.mvc;

import org.kuali.student.common.ui.client.configurable.mvc.impl.DefaultWidgetFactoryImpl;
import org.kuali.student.core.assembly.data.LookupParamMetadata;
import org.kuali.student.core.assembly.data.Metadata;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Widget;

public abstract class DefaultWidgetFactory {
	private static final DefaultWidgetFactory instance = GWT.create(DefaultWidgetFactoryImpl.class);
	public static DefaultWidgetFactory getInstance() {
		return instance;
	}
	public abstract Widget getWidget(FieldDescriptor field);
	
	public abstract Widget getWidget(Metadata meta);
	
	public abstract Widget getWidget(LookupParamMetadata meta);
	
}
 