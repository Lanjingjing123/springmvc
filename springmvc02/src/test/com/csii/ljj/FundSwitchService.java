package com.csii.ljj;

import java.util.Map;

public interface FundSwitchService {
    /**
     * 响应是否成功
     * @param responseMap
     * @return true/false
     */
    public boolean isSuccess(Map<String,String> responseMap);

    /**
     *  调用资金交换申请批扣
     *
     * @param requestMap    请求参数封装
     * @return responseMap  响应Map
     */
    public Map<String, String> applyRepayMoney(Map<String, Object> requestMap);
}
