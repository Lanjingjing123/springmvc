package com.csii.ljj.fund.request;

import com.csii.ljj.fund.FundRequestBody;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="Request1")
@XmlAccessorType(XmlAccessType.FIELD)
public class newRequest extends Request {

//    public newRequest() {
//        super();
//    }

    /**
     * 请求报文体信息
     */
    @XmlElement(name = "Body")
    private FundRequestBody body;

    public FundRequestBody getBody() {
        return body;
    }

    public void setBody(FundRequestBody body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "newRequest{" +
                "body=" + body +
                '}';
    }
}
