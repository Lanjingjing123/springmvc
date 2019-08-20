package com.csii.ljj.transfer;

import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;

public class LnIouNoInfo {


    /**
     * 借据号
     */
    private String lnIouNo;

    /**
     * 本金
     */
    private BigDecimal princp;
    /**
     * 利息
     */
    private BigDecimal interest;

    public String getLnIouNo() {
        return lnIouNo;
    }

    public LnIouNoInfo(String lnIouNo, BigDecimal princp, BigDecimal interest) {
        this.lnIouNo = lnIouNo;
        this.princp = princp;
        this.interest = interest;
    }

    public LnIouNoInfo() {
    }

    @XmlElement(name = "LNIOUNO")
    public void setLnIouNo(String lnIouNo) {
        this.lnIouNo = lnIouNo;
    }

    public BigDecimal getPrincp() {
        return princp;
    }

    @XmlElement(name = "PRINCP")
    public void setPrincp(BigDecimal princp) {
        this.princp = princp;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    @XmlElement(name = "INTEREST")
    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }
    @Override
    public String toString() {
        return "LnIouNoInfo{" +
                "lnIouNo='" + lnIouNo + '\'' +
                ", princp=" + princp +
                ", interest=" + interest +
                '}';
    }
}
