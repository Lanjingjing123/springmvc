package com.csii.ljj.fund.request;

import com.csii.ljj.fund.FundRequestHead;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Request")
@XmlAccessorType(XmlAccessType.FIELD)
public class Request {
    /**
     * 请求报文头信息
     */
    @XmlElement(name = "Head")
    public FundRequestHead requestHead;

    public FundRequestHead getRequestHead() {
        return requestHead;
    }

    public void setRequestHead(FundRequestHead requestHead) {
        this.requestHead = requestHead;
    }

    @Override
    public String toString() {
        return "Request{" +
                "requestHead=" + requestHead +
                '}';
    }
}
