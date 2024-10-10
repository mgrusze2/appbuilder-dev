package platform.lease.jaxrs.service;

import com.planonsoftware.jaxrs.api.v9.context.IJaxRsResourceContext;
import com.planonsoftware.platform.data.v1.BusinessException;
import com.planonsoftware.platform.data.v1.FieldNotFoundException;
import com.planonsoftware.platform.data.v1.IDatabaseQuery;
import com.planonsoftware.platform.data.v1.IResultSet;
import com.planonsoftware.platform.data.v1.Operator;
import java.util.ArrayList;
import java.util.List;
import platform.lease.jaxrs.dto.LeaseContractLineDTO;

public class LeaseContractLineService {
    public List<LeaseContractLineDTO> getAllLeaseLineContract(final IJaxRsResourceContext context)
            throws BusinessException, FieldNotFoundException {
        context.getLogService().debug("LeaseContractLineService: getAllLeaseLineContract");
        IDatabaseQuery query = context.getDataService().getPVDatabaseQuery("LeaseContractLineQuery");
        IResultSet resultSet = query.execute();
        context.getLogService().debug("LeaseContractLineQuery Executed Successfully for getAllLeaseLineContract.....");
        List<LeaseContractLineDTO> leaseContractLine = loadLeaseContractLineRecord(resultSet);
        return leaseContractLine;

    }

    public List<LeaseContractLineDTO> getAllLeaseLineContractByContractRef(final IJaxRsResourceContext context,
            int contractRef) throws BusinessException, FieldNotFoundException {
        context.getLogService().debug("LeaseContractLineService: getAllLeaseLineContractByContactRef:" + contractRef);
        IDatabaseQuery query = context.getDataService().getPVDatabaseQuery("LeaseContractLineQuery");
        query.getSearchExpression("contractRef", Operator.EQUAL).addValue(contractRef);
        IResultSet resultSet = query.execute();
        context.getLogService()
                .debug("LeaseContractLineQuery Executed Successfully for getAllLeaseLineContractByContactRef.....");
        List<LeaseContractLineDTO> leaseContractLine = loadLeaseContractLineRecord(resultSet);
        return leaseContractLine;

    }

    public List<LeaseContractLineDTO> getAllLeaseLineContractByPropertyRef(final IJaxRsResourceContext context,
            int propertyRef) throws BusinessException, FieldNotFoundException {
        context.getLogService().debug("LeaseContractLineService: getAllLeaseLineContractByPropertyRef:" + propertyRef);
        IDatabaseQuery query = context.getDataService().getPVDatabaseQuery("LeaseContractLineQuery");
        query.getSearchExpression("PropertyRef", Operator.EQUAL).addValue(propertyRef);
        IResultSet resultSet = query.execute();
        context.getLogService()
                .debug("LeaseContractLineQuery Executed Successfully for getAllLeaseLineContractByPropertyRef.....");
        List<LeaseContractLineDTO> leaseContractLine = loadLeaseContractLineRecord(resultSet);
        return leaseContractLine;

    }

    private List<LeaseContractLineDTO> loadLeaseContractLineRecord(final IResultSet resultSet)
            throws IllegalStateException, FieldNotFoundException, BusinessException {
        List<LeaseContractLineDTO> leaseContractLines = new ArrayList<>();
        while (resultSet.next())

        {
            LeaseContractLineDTO leaseContractLine = new LeaseContractLineDTO();
            leaseContractLine.setSyscode(resultSet.getPrimaryKey());
            leaseContractLine.setCode(resultSet.getString("Code"));
            leaseContractLine.setContractRef(resultSet.getInteger("ContractRef"));
            leaseContractLine.setPropertyRef(resultSet.getInteger("PropertyRef"));
            leaseContractLine.setRefBOStateUserDefined(resultSet.getString("RefBOStateUserDefined"));
            leaseContractLine.setActualBeginDate(resultSet.getString("ActualBeginDate"));
            leaseContractLine.setActualEndDate(resultSet.getString("ActualEndDate"));
            leaseContractLine.setSysInsertDateTime(resultSet.getDateTime("SysInsertDateTime"));
            leaseContractLine.setSysChangeDateTime(resultSet.getDateTime("SysChangeDateTime"));
            leaseContractLine.setRefContractLineGroup(resultSet.getString("RefContractLineGroup"));

            leaseContractLines.add(leaseContractLine);

        }
        return leaseContractLines;
    }
}