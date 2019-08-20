package com.csii.ljj.fund;


import javax.xml.bind.annotation.XmlElement;

public class FundRequestHead {
    /**
     * 交易编码
     */
    private String txCode;

    public String getTxCode() {
        return txCode;
    }

    @XmlElement(name = "TxCode")
    public void setTxCode(String txCode) {
        this.txCode = txCode;
    }

    @Override
    public String toString() {
        return "FundRequestHead{" +
                "txCode='" + txCode + '\'' +
                '}';
    }
}
