/*
 * Copyright 2009 Johnson Consulting Services
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * 
 */
package org.kuali.student.lum.lu.ui.course.client.widgets.a.dynamictable.export.download;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import org.kuali.student.lum.lu.ui.course.client.widgets.a.common.LightBox;
import org.kuali.student.lum.lu.ui.course.client.widgets.a.dynamictable.export.ExportMessages;
import org.kuali.student.lum.lu.ui.course.client.widgets.a.themes.Theme;

/**
 * @author wilj
 *
 */
public class ExportDownloaderIEOpera implements ExportDownloader {

	/* (non-Javadoc)
	 * @see org.kuali.student.lum.lu.ui.course.client.widgets.a.dynamictable.export.download.ExportDownloader#download(java.lang.String)
	 */
	@Override
	public void download(final String url) {
		final LightBox box = new LightBox(RootPanel.get());
		//final ExportMessages msg = Theme.INSTANCE.getExportMessages();
		final String id = HTMLPanel.createUniqueId();
		final String html = "ReadyText<br/><a id='" + id + "' href='" + url
				+ "' target='_blank'>" + "</a>";
		final HTMLPanel linkPanel = new HTMLPanel(html);
		final VerticalPanel panel = new VerticalPanel();
		panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		panel.add(linkPanel);
		panel.add(new Button("ButtonText", new ClickHandler() {
			@Override
			public void onClick(final ClickEvent arg0) {
				box.hide();
			}
		}));

		box.setWidget(panel);
		box.show();
	}

}