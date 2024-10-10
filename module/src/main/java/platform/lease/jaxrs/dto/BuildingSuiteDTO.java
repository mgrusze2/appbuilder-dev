package platform.lease.jaxrs.dto;

public class BuildingSuiteDTO {
    private String buildingCode;
    private String suiteID;
    private String buildingName;
    private String leaseBeginDate;
    private String leaseEndDate;

    public String getLeaseBeginDate() {
        return leaseBeginDate;
    }

    public void setLeaseBeginDate(String leaseBeginDate) {
        this.leaseBeginDate = leaseBeginDate;
    }

    public String getLeaseEndDate() {
        return leaseEndDate;
    }

    public void setLeaseEndDate(String leaseEndDate) {
        this.leaseEndDate = leaseEndDate;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getBuildingCode() {
        return buildingCode;
    }

    public void setBuildingCode(String buildingCode) {
        this.buildingCode = buildingCode;
    }

    public String getSuiteID() {
        return suiteID;
    }

    public void setSuiteID(String suiteID) {
        this.suiteID = suiteID;
    }

}