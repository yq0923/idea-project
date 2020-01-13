package com.fh.payLog.service;


import com.fh.common.ServerResponse;
import com.fh.payLog.model.PayLog;

public interface PayLogService {
    void addPayLog(PayLog payLog);

    void updatePayLog(PayLog payLog);

    ServerResponse getPayMoney(String outTradeNo);
}
