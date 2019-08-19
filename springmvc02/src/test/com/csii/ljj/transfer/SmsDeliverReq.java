package com.csii.ljj.transfer;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 请求对象
 * @author xuejiangtao
 *
 */
@XmlRootElement(name="SMSDELIVERREQ")
public class SmsDeliverReq {

    private ReqHeader reqHeader;

    private List<SmsBody> smsBodys;

    @XmlElement(name="REQHEADER")
    public ReqHeader getReqHeader() {
        return reqHeader;
    }

    public void setReqHeader(ReqHeader reqHeader) {
        this.reqHeader = reqHeader;
    }

    @XmlElementWrapper(name="SMSBODYS")
    @XmlElement(name="SMSBODY")
    public List<SmsBody> getSmsBodys() {
        return smsBodys;
    }

    public void setSmsBodys(List<SmsBody> smsBodys) {
        this.smsBodys = smsBodys;
    }
}