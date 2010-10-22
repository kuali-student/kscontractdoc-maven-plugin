package org.kuali.student.lum.lu.ui.tools.server.gwt;

import java.util.Map;

import org.apache.log4j.Logger;
import org.kuali.student.common.ui.client.service.DataSaveResult;
import org.kuali.student.common.ui.server.gwt.DataService;
import org.kuali.student.common.ui.shared.IdAttributes;
import org.kuali.student.core.assembly.Assembler;
import org.kuali.student.core.assembly.data.AssemblyException;
import org.kuali.student.core.assembly.data.Data;
import org.kuali.student.core.assembly.data.Metadata;
import org.kuali.student.core.assembly.data.SaveResult;
import org.kuali.student.core.assembly.dictionary.MetadataServiceImpl;
import org.kuali.student.core.assembly.transform.MetadataFilter;
import org.kuali.student.core.assembly.transform.TransformFilter;
import org.kuali.student.core.exceptions.DataValidationErrorException;
import org.kuali.student.core.exceptions.DoesNotExistException;
import org.kuali.student.core.exceptions.InvalidParameterException;
import org.kuali.student.core.exceptions.MissingParameterException;
import org.kuali.student.core.exceptions.OperationFailedException;
import org.kuali.student.core.rice.authorization.PermissionType;

public class CluSetDataService  implements DataService{

    final static Logger LOG = Logger.getLogger(CluSetDataService.class);
    private Assembler<Data, Void> assembler;
    private MetadataServiceImpl metadataService;
    
    public MetadataServiceImpl getMetadataService() {
        return metadataService;
    }

    public void setMetadataService(MetadataServiceImpl metadataService) {
        this.metadataService = metadataService;
    }

    public Assembler<Data, Void> getAssembler() {
        return assembler;
    }

    public void setAssembler(Assembler<Data, Void> assembler) {
        this.assembler = assembler;
    }

    @Override
    public Data getData(String dataId) throws OperationFailedException, DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException {
        Data result = null;
        try {
            result = assembler.get(dataId);
        } catch (Exception e){
            throw new OperationFailedException("Failed to retrieve data from id " + dataId, e);
        }
        return result;
    }

    @Override
    public Metadata getMetadata(String id, Map<String,String> idAttributes) {
        Metadata metadata = metadataService.getMetadata(id);
        return metadata;
    }
    
    protected String getDefaultMetaDataType() {
        return null; //DEFAULT_METADATA_STATE;
    }

    protected String getDefaultMetaDataState() {
        return null; //DEFAULT_METADATA_STATE;
    }

    @Override
    public Boolean isAuthorized(PermissionType type, Map<String, String> attributes) {
        return new Boolean(true);
    }

    @Override
    public DataSaveResult saveData(Data data) throws OperationFailedException, DataValidationErrorException {
        try {
            SaveResult<Data> saveResult = assembler.save(data);
            if (saveResult != null) {
                return new DataSaveResult(saveResult.getValidationResults(), saveResult.getValue());
            }
        } catch (Exception e) {
            LOG.error("Unable to save", e);
            throw new OperationFailedException("Unable to save");
        }
        return null;
    }
}