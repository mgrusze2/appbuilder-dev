package platform.lease.jaxrs.dto;

import java.util.Date;

public class LeaseContractLineDTO {
    private int syscode;
    private String code;
    private int contractRef;
    private int propertyRef;
    private String actualBeginDate;
    private String actualEndDate;
    private String refBOStateUserDefined;
    private String refContractLineGroup;
    private Date sysInsertDateTime;
    private Date sysChangeDateTime;

    public Date getSysChangeDateTime() {
        return sysChangeDateTime;
    }

    public void setSysChangeDateTime(Date sysChangeDateTime) {
        this.sysChangeDateTime = sysChangeDateTime;
    }

    public Date getSysInsertDateTime() {
        return sysInsertDateTime;
    }

    public void setSysInsertDateTime(Date sysInsertDateTime) {
        this.sysInsertDateTime = sysInsertDateTime;
    }

    public String getRefContractLineGroup() {
        return refContractLineGroup;
    }

    public void setRefContractLineGroup(String refContractLineGroup) {
        this.refContractLineGroup = refContractLineGroup;
    }

    public String getActualBeginDate() {
        return actualBeginDate;
    }

    public void setActualBeginDate(String actualBeginDate) {
        this.actualBeginDate = actualBeginDate;
    }

    public String getActualEndDate() {
        return actualEndDate;
    }

    public void setActualEndDate(String actualEndDate) {
        this.actualEndDate = actualEndDate;
    }

    public String getRefBOStateUserDefined() {
        return refBOStateUserDefined;
    }

    public void setRefBOStateUserDefined(String refBOStateUserDefined) {
        this.refBOStateUserDefined = refBOStateUserDefined;
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

    public int getContractRef() {
        return contractRef;
    }

    public void setContractRef(int contractRef) {
        this.contractRef = contractRef;
    }

    public int getPropertyRef() {
        return propertyRef;
    }

    public void setPropertyRef(int propertyRef) {
        this.propertyRef = propertyRef;
    }

}