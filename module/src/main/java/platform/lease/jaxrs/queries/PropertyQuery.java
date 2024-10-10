package platform.lease.jaxrs.queries;

import com.planonsoftware.platform.backend.querybuilder.v3.IQueryBuilder;
import com.planonsoftware.platform.backend.querybuilder.v3.IQueryDefinition;
import com.planonsoftware.platform.backend.querybuilder.v3.IQueryDefinitionContext;

public class PropertyQuery implements IQueryDefinition
{
    @Override
    public void create(IQueryBuilder leaseContract, IQueryDefinitionContext aContext)
    {
        leaseContract.addSearchField("Syscode");
        leaseContract.addSearchField("Code");
        leaseContract.addSelectField("Code","PropertyCode");
        leaseContract.addSelectField("Name");
   }
   @Override
   public String getBOName()
   {
       return "Property";
   }
}