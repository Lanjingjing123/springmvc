package com.csii.ljj;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class FundSwitchServiceImpl implements FundSwitchService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FundSwitchServiceImpl.class);

    @Resource
    private RestTemplate restTemplate;
    @Value("${http.url.fund.switch}")
    private String url;
    @Value("${fund.switch.upsSysCde}")
    private String upsSysCde;

    private static final String REQT_APPHDR = "/reqt/appHdr/";
    private static final String REQT_APPBODY = "/reqt/appBody/";
    private static final String RESP_APPBODY = "/resp/appBody/";
    /**
     * 响应信息字段
     */
    public static final String RESP_MSG = "/resp/appHdr/respMsg";
    /**
     * 响应码字段
     */
    public static final String RESP_CODE = "/resp/appHdr/respCde";
    /**
     * 响应码字段
     */
    public static final String RESP_TRANS_DATE = "/resp/appHdr/transDate";
    /**
     * 响应成功码
     */
    private static final String RESP_SUCCESS = "30400000000000";
    /**
     * 响应失败码
     */
    private static final String RESP_FAILS = "30400099999999,30400000100011,30400000100012,30400000100135";
    /**
     * 交易状态字段
     */
    public static final String RESP_TRANS_STATUS = "/resp/appBody/overAllTransStatus";
    /**
     * 交易流水字段
     */
    public static final String RESP_TRANS_SEQ = "/resp/appBody/overAllTransNbr";
    /**
     * 资金交换平台交易状态 0：成功
     */
    private static final String TRANS_STATUS_SUCCESS = "0";
    /**
     * 资金交换平台交易状态 1：失败
     */
    private static final String TRANS_STATUS_FAIL = "1";
    @Override
    public boolean isSuccess(Map<String, String> responseMap) {
        return false;
    }

    @Override
    public Map<String, String> applyRepayMoney(Map<String, Object> requestMap) {
        return null;
    }


    private Map<String, String> createRequest(Map<String, Object> requestMap, String transId){
        Map<String, String> request = new HashMap<>();
        // 交易码
        request.put(REQT_APPHDR.concat("transId"), transId);
        // 前端流水号
        String pubFsideJnno = (String) requestMap.get("pubFsideJnno");
//        if (pubFsideJnno == null){
//            pubFsideJnno = idGenerator.nextIdStr();
//        }
        requestMap.remove("pubFsideJnno");
        request.put(REQT_APPHDR.concat("pubFsideJnno"), pubFsideJnno);
        // 上游系统代码
        request.put(REQT_APPHDR.concat("upsSysCde"), upsSysCde);
        Date currentDate = new Date();
//        String time = DateFormatUtils.format(currentDate, Constant.FORMAT_DATE_TIME_S);
//        String[] times = time.split(":");
//        // 日期
//        request.put(REQT_APPHDR.concat("dtInFromClt"), times[0]);
//        // 时间
//        request.put(REQT_APPHDR.concat("tmInFromClt"), times[1]);
//        if (requestMap.size() > 0){
//            for (Map.Entry<String, Object> entry : requestMap.entrySet()){
//                if (entry.getValue() != null){
//                    request.put(REQT_APPBODY.concat(entry.getKey()), entry.getValue().toString());
//                }
//            }
//        }
        return request;
    }
}
