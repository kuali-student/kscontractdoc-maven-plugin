package org.kuali.student.lum.program.client.bacc.view;

import com.google.gwt.core.client.GWT;
import org.kuali.student.lum.common.client.configuration.Configuration;
import org.kuali.student.lum.common.client.configuration.ConfigurationManager;
import org.kuali.student.lum.program.client.AbstractProgramConfigurer;
import org.kuali.student.lum.program.client.major.view.*;

/**
 * @author Igor
 */
public class ViewBaccConfigurer extends AbstractProgramConfigurer {

    public ViewBaccConfigurer() {
        programSectionConfigManager = new ConfigurationManager(this);
        programSectionConfigManager.registerConfiguration(new BaccInformationViewConfiguration());
        programSectionConfigManager.registerConfiguration(new BaccManagingBodiesViewConfiguration());
        programSectionConfigManager.registerConfiguration(new BaccCatalogDetailsViewConfiguration());
        programSectionConfigManager.registerConfiguration(new BaccRequirementsViewConfiguration());
        programSectionConfigManager.registerConfiguration(new BaccLearningObjectivesViewConfiguration());
        programSectionConfigManager.registerConfiguration(new SupportingDocsViewConfiguration());
        programSectionConfigManager.registerConfiguration(new BaccViewAllSectionsConfiguration());
    }
}