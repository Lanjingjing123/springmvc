package com.csii.ljj.fund;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Request")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "order",propOrder = {"requestHead","requestBody"})
public class FundRequest {
    /**
     * 请求报文头信息
     */
    @XmlElement(name = "Head")
    public FundRequestHead requestHead;

    /**
     * 请求报文体信息
     */
    @XmlElement(name = "Body")
    private FundRequestBody requestBody;

    public FundRequestHead getRequestHead() {
        return requestHead;
    }


    public void setRequestHead(FundRequestHead requestHead) {
        this.requestHead = requestHead;
    }

    public FundRequestBody getRequestBody() {
        return requestBody;
    }


    public void setRequestBody(FundRequestBody requestBody) {
        this.requestBody = requestBody;
    }

    @Override
    public String toString() {
        return "FundRequest{" +
                "requestHead=" + requestHead +
                ", requestBody=" + requestBody +
                '}';
    }
}
