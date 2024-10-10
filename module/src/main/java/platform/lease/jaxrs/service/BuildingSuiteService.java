package platform.lease.jaxrs.service;

import platform.lease.jaxrs.dto.BuildingSuiteDTO;
import platform.lease.jaxrs.dto.LeaseContractDTO;
import platform.lease.jaxrs.dto.LeaseContractLineDTO;
import platform.lease.jaxrs.dto.PropertyDTO;
import java.util.ArrayList;
import java.util.List;
import com.planonsoftware.jaxrs.api.v9.context.IJaxRsResourceContext;

public class BuildingSuiteService {
    // IJaxRsResourceContext jaxrsContext;
    List<BuildingSuiteDTO> buildingSuites = new ArrayList<>();
    List<LeaseContractDTO> leaseContracts = new ArrayList<>();
    List<LeaseContractLineDTO> leaseCotractLines = new ArrayList<>();
    List<PropertyDTO> property = new ArrayList<>();

    public List<BuildingSuiteDTO> getAllBuildingSuites(final IJaxRsResourceContext context) {
        context.getLogService().debug("Started BuildingSuiteService: getAllBuildingSuites");
        LeaseContractService leaseContractService = new LeaseContractService();
        try {
            leaseContracts = leaseContractService.getAllLeaseContract(context);

            context.getLogService().debug("getAllLeaseContract returned : " + leaseContracts.size());

            for (LeaseContractDTO leaseContract : leaseContracts) {
                BuildingSuiteDTO buildingSuite = new BuildingSuiteDTO();
                context.getLogService().debug("Inside getAllBuildingSuites.leaseContract for loop");
                context.getLogService().debug("leaseContract.getSyscode() " + leaseContract.getSyscode());
                LeaseContractLineService leaseContractLineService = new LeaseContractLineService();
                leaseCotractLines = leaseContractLineService.getAllLeaseLineContractByContractRef(context,
                        leaseContract.getSyscode());
                context.getLogService().debug("getleaseCotractLines equal to leaseContractLine : "
                        + leaseContract.getSyscode() + ":" + leaseCotractLines.size());
                if (leaseCotractLines != null && leaseCotractLines.size() > 0) {
                    String leaseLinePropertyRefResult = "";
                    String propertyBuildingResult = "";
                    String Separator = "_";
                    for (LeaseContractLineDTO leaseCotractLine : leaseCotractLines) {
                        context.getLogService().debug("Inside getAllBuildingSuites.leaseCotractLine for loop:"
                                + leaseCotractLine.getPropertyRef());
                        context.getLogService()
                                .debug("leaseCotractLine.getPropertyRef() : " + leaseCotractLine.getPropertyRef());
                        leaseLinePropertyRefResult =leaseLinePropertyRefResult.concat(String.valueOf(leaseCotractLine.getPropertyRef()).concat(Separator));
                        PropertyService propertyService = new PropertyService();
                        if (leaseCotractLine.getPropertyRef() != 0) {
                            context.getLogService().debug("Inside leaseCotractLine.getPropertyRef() != 0");
                            property = propertyService.getPropertyBySysCode(context, leaseCotractLine.getPropertyRef());
                            context.getLogService()
                                    .debug("getproperty code equal to leaseContractLine propertyRef returned : "
                                            + property.size());
                            propertyBuildingResult =propertyBuildingResult.concat(property.get(0).getCode().concat(Separator));
                        }
                    }
                    context.getLogService().debug("For : " + leaseContract.getSyscode() + " |LeasLines are :"
                            + leaseLinePropertyRefResult + " |And Building Code is : " + propertyBuildingResult);
                    buildingSuite.setSuiteID(leaseContract.getFreeString3());
                    //buildingSuite.setBuildingCode(property.get(0).getCode());
                    
                    buildingSuite.setBuildingCode(property.get(0).getCode());

                    buildingSuite.setBuildingName(property.get(0).getName());
                    // buildingSuite.setLeaseBeginDate(leaseCotractLine.getActualBeginDate());
                    // buildingSuite.setLeaseEndDate(leaseCotractLine.getActualEndDate());
                    buildingSuites.add(buildingSuite);

                }
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return buildingSuites;
    }

}

// public class BuildingSuiteService {
// // IJaxRsResourceContext jaxrsContext;
// List<BuildingSuiteDTO> buildingSuites = new ArrayList<>();
// List<LeaseContractDTO> leaseContracts = new ArrayList<>();
// List<LeaseContractLineDTO> leaseCotractLines = new ArrayList<>();
// List<PropertyDTO> property = new ArrayList<>();

// public List<BuildingSuiteDTO> getAllBuildingSuites(final
// IJaxRsResourceContext context) {
// context.getLogService().debug("Started BuildingSuiteService:
// getAllBuildingSuites");
// LeaseContractService leaseContractService = new LeaseContractService();
// try {
// leaseContracts = leaseContractService.getAllLeaseContract(context);

// context.getLogService().debug("getAllLeaseContract returned : " +
// leaseContracts.size());

// for (LeaseContractDTO leaseContract : leaseContracts) {
// BuildingSuiteDTO buildingSuite = new BuildingSuiteDTO();
// context.getLogService().debug("Inside getAllBuildingSuites.leaseContract for
// loop");
// context.getLogService().debug("leaseContract.getSyscode() " +
// leaseContract.getSyscode());
// LeaseContractLineService leaseContractLineService = new
// LeaseContractLineService();
// // Get all lease contract lines
// leaseCotractLines =
// leaseContractLineService.getAllLeaseLineContractByContractRef(context,
// leaseContract.getSyscode());
// // Sort leaseContractLines by actualEndDate in descending order
// https://chatgpt.com/c/b12a1d30-1911-475a-909e-962c3a129b93
// Collections.sort(leaseCotractLines, new Comparator<LeaseContractLineDTO>() {
// @Override
// public int compare(LeaseContractLineDTO o1, LeaseContractLineDTO o2) {
// if (o1.getActualEndDate() == null && o2.getActualEndDate() == null) {
// return 0;
// } else if (o1.getActualEndDate() == null) {
// return 1;
// } else if (o2.getActualEndDate() == null) {
// return -1;
// }
// return o2.getActualEndDate().compareTo(o1.getActualEndDate());
// }
// });
// // Get the lease contract line with the latest actualEndDate
// LeaseContractLineDTO latestLeaseContractLine = leaseCotractLines.isEmpty() ?
// null
// : leaseCotractLines.get(leaseCotractLines.size() - 1);

// if (latestLeaseContractLine != null) {
// context.getLogService().debug("Latest leaseContractLine with actualEndDate: "
// + latestLeaseContractLine.getActualEndDate());
// // Perform further processing with the latestLeaseContractLine
// if (latestLeaseContractLine.getPropertyRef() != 0) {
// context.getLogService().debug("Inside
// latestLeaseContractLine.getPropertyRef() != 0");
// PropertyService propertyService = new PropertyService();
// property = propertyService.getPropertyBySysCode(context,
// latestLeaseContractLine.getPropertyRef());
// }

// buildingSuite.setSuiteID(leaseContract.getFreeString3());
// buildingSuite.setBuildingCode(property.get(0).getCode());
// buildingSuite.setBuildingName(property.get(0).getName());
// buildingSuite.setLeaseBeginDate(latestLeaseContractLine.getActualBeginDate());
// buildingSuite.setLeaseEndDate(latestLeaseContractLine.getActualEndDate());
// buildingSuites.add(buildingSuite);
// }
// }

// } catch (Exception e) {

// e.printStackTrace();
// }

// return buildingSuites;
// }

// }