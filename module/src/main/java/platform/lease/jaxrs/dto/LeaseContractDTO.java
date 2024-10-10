package platform.lease.jaxrs.dto;

public class LeaseContractDTO
{
    private int syscode;
    private String code;
    private String name;
    private String freeString3;
    

    public String getFreeString3() {
        return freeString3;
    }
    public void setFreeString3(String freeString3) {
        this.freeString3 = freeString3;
    }
    
    public int getSyscode() {
        return syscode;
    }
    public void setSyscode(int syscode) {
        this.syscode = syscode;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
}