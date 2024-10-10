package platform.lease.jaxrs.queries;

import com.planonsoftware.platform.backend.querybuilder.v3.IQueryBuilder;
import com.planonsoftware.platform.backend.querybuilder.v3.IQueryDefinition;
import com.planonsoftware.platform.backend.querybuilder.v3.IQueryDefinitionContext;

public class LeaseContractQuery implements IQueryDefinition
{
    @Override
    public void create(IQueryBuilder leaseContract, IQueryDefinitionContext aContext)
    {
        leaseContract.addSearchField("Syscode");
        leaseContract.addSearchField("FreeString3");
        leaseContract.addSelectField("Code","LeaseContractCode");
        leaseContract.addSelectField("Name");
        leaseContract.addSelectField("FreeString3");
   }
   @Override
   public String getBOName()
   {
       return "LeaseContract";
   }
}