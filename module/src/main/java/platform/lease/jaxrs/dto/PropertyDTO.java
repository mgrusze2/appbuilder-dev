package platform.lease.jaxrs.dto;

public class PropertyDTO
{
    private int sysCode;
    private String code;
    private String name;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getSysCode() {
        return sysCode;
    }
    public void setSysCode(int sysCode) {
        this.sysCode = sysCode;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    

}