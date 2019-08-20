package com.csii.ljj.fund;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.math.BigDecimal;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class FundRequestBody {
    /**
     * 机构编号
     */
    @XmlElement(name = "InstitutionID")
    private String institutionID;

    /**
     * 批次号
     */
    @XmlElement(name = "BatchNo")
    private long batchNo;

    /**
     * 总金额
     */
    @XmlElement(name = "TotalAmount")
    private BigDecimal totalAmount;

    /**
     * 总笔数
     */
    @XmlElement(name = "TotalCount")
    private long totalCount;

    /**
     * 备注
     */
    @XmlElement(name = "Remark")
    private String remark;

    /**
     * 客户还款信息
     */
    @XmlElementWrapper(name = "Item")
    @XmlElement(name = "BankNoByPBC")
    private List<RepayInfo> repayInfos;

    public String getInstitutionID() {
        return institutionID;
    }


    public void setInstitutionID(String institutionID) {
        this.institutionID = institutionID;
    }

    public long getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(long batchNo) {
        this.batchNo = batchNo;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<RepayInfo> getRepayInfos() {
        return repayInfos;
    }


    public void setRepayInfos(List<RepayInfo> repayInfos) {
        this.repayInfos = repayInfos;
    }

    @Override
    public String toString() {
        return "FundRequestBody{" +
                "institutionID='" + institutionID + '\'' +
                ", batchNo='" + batchNo + '\'' +
                ", totalAmount=" + totalAmount +
                ", totalCount=" + totalCount +
                ", remark='" + remark + '\'' +
                ", repayInfos=" + repayInfos +
                '}';
    }
}
