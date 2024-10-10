package platform.lease.jaxrs.service;

import java.util.ArrayList;
import java.util.List;
import com.planonsoftware.jaxrs.api.v9.context.IJaxRsResourceContext;
import com.planonsoftware.platform.data.v1.BusinessException;
import com.planonsoftware.platform.data.v1.FieldNotFoundException;
import com.planonsoftware.platform.data.v1.IDatabaseQuery;
import com.planonsoftware.platform.data.v1.IResultSet;
import com.planonsoftware.platform.data.v1.Operator;

import platform.lease.jaxrs.dto.BuildingSuiteDTO;
import platform.lease.jaxrs.dto.LeaseContractDTO;
import platform.lease.jaxrs.dto.LeaseContractLineDTO;
import platform.lease.jaxrs.dto.PropertyDTO;

public class LeaseContractService {
    private static final String Suite = "FreeString3";
    public List<LeaseContractDTO> getAllLeaseContract(final IJaxRsResourceContext context)
            throws BusinessException, FieldNotFoundException {
        context.getLogService().debug("LeaseContractService: getAllLeaseContract");
        IDatabaseQuery query = context.getDataService().getPVDatabaseQuery("LeaseContractQuery");
        IResultSet resultSet = query.execute();
        context.getLogService().debug("Query Executed Successfully......");
        List<LeaseContractDTO> leaseContract = loadLeaseContractRecord(resultSet);
        return leaseContract;

    }

    public List<LeaseContractDTO> getLeaseContractDetailsBySyscode(final IJaxRsResourceContext context, int sysCode)
            throws BusinessException, FieldNotFoundException {
        context.getLogService().debug("LeaseContractService: getLeaseContractByCode");
        IDatabaseQuery query = context.getDataService().getPVDatabaseQuery("LeaseContractQuery");
        query.getSearchExpression("Syscode", Operator.EQUAL).addValue(sysCode);
        IResultSet resultSet = query.execute();
        context.getLogService().debug("Query Executed Successfully......");
        List<LeaseContractDTO> leaseContract = loadLeaseContractRecord(resultSet);
        return leaseContract;

    }
    public List<LeaseContractDTO> getLeaseContractDetailsBySuite(final IJaxRsResourceContext context, String suite)
            throws BusinessException, FieldNotFoundException {
        context.getLogService().debug("LeaseContractService: getLeaseContractDetailsBySuite");
        IDatabaseQuery query = context.getDataService().getPVDatabaseQuery("LeaseContractQuery");
        query.getSearchExpression("FreeString3", Operator.EQUAL).addValue(suite);
        IResultSet resultSet = query.execute();
        context.getLogService().debug("getLeaseContractDetailsBySuiteQuery Executed Successfully......");
        List<LeaseContractDTO> leaseContract = loadLeaseContractRecord(resultSet);
        return leaseContract;

    }

    private List<LeaseContractDTO> loadLeaseContractRecord(final IResultSet resultSet)
            throws IllegalStateException, FieldNotFoundException, BusinessException {
        List<LeaseContractDTO> leaseContracts = new ArrayList<>();
        while (resultSet.next()) {
                if (resultSet.getString(Suite) != null && !resultSet.getString(Suite).isEmpty()) {
                LeaseContractDTO leaseContract = new LeaseContractDTO();
                leaseContract.setSyscode(resultSet.getPrimaryKey());
                leaseContract.setCode(resultSet.getString("LeaseContractCode"));
                leaseContract.setFreeString3(resultSet.getString("FreeString3"));
                leaseContract.setName(resultSet.getString("Name"));
                leaseContracts.add(leaseContract);

            }
        }
        return leaseContracts;
    }

    // public List<BuildingSuiteDTO> getAllBuildingSuites(final IJaxRsResourceContext context) {
    //     IJaxRsResourceContext jaxrsContext;
    // List<BuildingSuiteDTO> buildingSuites = new ArrayList<>();
    // List<LeaseContractDTO> leaseContracts = new ArrayList<>();
    // List<LeaseContractLineDTO> leaseCotractLines = new ArrayList<>();
    // List<PropertyDTO> property = new ArrayList<>();
    //     context.getLogService().debug("Started BuildingSuiteService: getAllBuildingSuites");
    //     LeaseContractService leaseContractService = new LeaseContractService();
    //     try {
    //         leaseContracts = leaseContractService.getAllLeaseContract(jaxrsContext);

    //         context.getLogService().debug("getAllLeaseContract returned : " + leaseContracts.size());

    //         for (LeaseContractDTO leaseContract : leaseContracts) {
    //             BuildingSuiteDTO buildingSuite = new BuildingSuiteDTO();
    //             context.getLogService().debug("Inside getAllBuildingSuites.leaseContract for loop");
    //             context.getLogService().debug("leaseContract.getSyscode() " + leaseContract.getSyscode());
    //             LeaseContractLineService leaseContractLineService = new LeaseContractLineService();
    //             leaseCotractLines = leaseContractLineService.getAllLeaseLineContract(jaxrsContext,
    //                     leaseContract.getSyscode());
    //             for (LeaseContractLineDTO leaseCotractLine : leaseCotractLines) {
    //                 context.getLogService().debug("Inside getAllBuildingSuites.leaseCotractLine for loop");
    //                 context.getLogService()
    //                         .debug("leaseCotractLine.getPropertyRef() : " + leaseCotractLine.getPropertyRef());
    //                 PropertyService propertyService = new PropertyService();
    //                 if (leaseCotractLine.getPropertyRef() != 0) {
    //                     context.getLogService().debug("Inside leaseCotractLine.getPropertyRef() != 0");
    //                     property = propertyService.getPropertyBySysCode(jaxrsContext,
    //                             leaseCotractLine.getPropertyRef());
    //                 }
    //             }
    //             buildingSuite.setSuiteID(leaseContract.getFreeString3());
    //             buildingSuite.setBuildingCode(property.get(0).getCode());
    //             buildingSuites.add(buildingSuite);
    //         }

    //     } catch (Exception e) {

    //         e.printStackTrace();
    //     }

    //     return buildingSuites;
    // }

}
