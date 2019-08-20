package com.csii.ljj.fund;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
public class RepayInfo {
    /**
     * 记录流水号
     */
    @XmlElement(name = "ItemNo")
    private String itemNo;
    /**
     * 金额
     */
    @XmlElement(name = "Amount")
    private BigDecimal amount;
    /**
     * 银行ID
     */
    @XmlElement(name = "BankID")
    private String bankID;
    /**
     * 账户类型
     */
    @XmlElement(name = "AccountType")
    private String accountType;
    /**
     * 账户名称
     */
    @XmlElement(name="AccountName")
    private String accountName;
    /**
     * 账户号
     */
    @XmlElement(name="AccountNumber")
    private String accountNumber;
    /**
     * 分支行
     */
    @XmlElement(name = "BranchName")
    private String branchName;

    @Override
    public String toString() {
        return "RepayInfo{" +
                "itemNo='" + itemNo + '\'' +
                ", amount=" + amount +
                ", bankID='" + bankID + '\'' +
                ", accountType='" + accountType + '\'' +
                ", accountName='" + accountName + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", branchName='" + branchName + '\'' +
                '}';
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getBankID() {
        return bankID;
    }

    public void setBankID(String bankID) {
        this.bankID = bankID;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
}
