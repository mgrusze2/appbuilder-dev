package platform.lease.jaxrs.service;

import java.util.ArrayList;
import java.util.List;
import com.planonsoftware.jaxrs.api.v9.context.IJaxRsResourceContext;
import com.planonsoftware.platform.data.v1.BusinessException;
import com.planonsoftware.platform.data.v1.FieldNotFoundException;
import com.planonsoftware.platform.data.v1.IDatabaseQuery;
import com.planonsoftware.platform.data.v1.IResultSet;
import com.planonsoftware.platform.data.v1.Operator;
import platform.lease.jaxrs.dto.PropertyDTO;

public class PropertyService {
    public List<PropertyDTO> getAllProperty(final IJaxRsResourceContext context)
            throws BusinessException, FieldNotFoundException {
        context.getLogService().debug("Started PropertyService: getAllProperties");
        IDatabaseQuery query = context.getDataService().getPVDatabaseQuery("PropertyQuery");
        IResultSet resultSet = query.execute();
        context.getLogService().debug("Query Executed Successfully for getAllProperty......");
        List<PropertyDTO> property = loadPropertyRecord(resultSet);
        return property;

    }
    public List<PropertyDTO> getPropertyBySysCode(final IJaxRsResourceContext context,int syscode)
            throws BusinessException, FieldNotFoundException {
        context.getLogService().debug("Started PropertyService: getPropertyBySysCode");
        IDatabaseQuery query = context.getDataService().getPVDatabaseQuery("PropertyQuery");
        query.getSearchExpression("Syscode", Operator.EQUAL).addValue(syscode);
        IResultSet resultSet = query.execute();
        context.getLogService().debug("Query Executed Successfully for getPropertyBySysCode......");
        List<PropertyDTO> property = loadPropertyRecord(resultSet);
        return property;

    }
    public List<PropertyDTO> getPropertyByBuildingCode(final IJaxRsResourceContext context,String buildingCode)
            throws BusinessException, FieldNotFoundException {
        context.getLogService().debug("Started PropertyService: getPropertyBySysCode");
        IDatabaseQuery query = context.getDataService().getPVDatabaseQuery("PropertyQuery");
        query.getSearchExpression("Code", Operator.EQUAL).addValue(buildingCode);
        IResultSet resultSet = query.execute();
        context.getLogService().debug("Query Executed Successfully for getPropertyBySysCode......");
        List<PropertyDTO> property = loadPropertyRecord(resultSet);
        return property;

    }


    private List<PropertyDTO> loadPropertyRecord(final IResultSet resultSet)
            throws IllegalStateException, FieldNotFoundException, BusinessException {
        List<PropertyDTO> properties = new ArrayList<>();
        while (resultSet.next()) {
            PropertyDTO property = new PropertyDTO();
            property.setSysCode(resultSet.getPrimaryKey());
            property.setCode(resultSet.getString("PropertyCode"));
            property.setName(resultSet.getString("Name"));
            properties.add(property);

        }
        return properties;
    }

    
    
}