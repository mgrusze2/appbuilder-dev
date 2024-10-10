package platform.lease.jaxrs.queries;

import com.planonsoftware.platform.backend.querybuilder.v3.IQueryDefinition;
import com.planonsoftware.platform.backend.querybuilder.v3.IQueryDefinitionContext;
import com.planonsoftware.platform.backend.querybuilder.v3.IQueryBuilder;

public class LeaseContractLineQuery implements IQueryDefinition
{
    @Override
    public void create(IQueryBuilder leaseContractLine, IQueryDefinitionContext aContext)
    {
        leaseContractLine.addSearchField("PropertyRef");
        leaseContractLine.addSearchField("ContractRef","contractRef");
        leaseContractLine.addSelectField("Code");
        leaseContractLine.addSelectField("ContractRef");
        leaseContractLine.addSelectField("PropertyRef");
        leaseContractLine.addSelectField("RefBOStateUserDefined");
        leaseContractLine.addSelectField("ActualBeginDate");
        leaseContractLine.addSelectField("ActualEndDate");
        leaseContractLine.addSelectField("SysInsertDateTime");
        leaseContractLine.addSelectField("SysChangeDateTime");
        leaseContractLine.addSelectField("RefContractLineGroup");
           
    }
    @Override
    public String getBOName()
    {
        return "LeaseContractLine";
        

    }
}