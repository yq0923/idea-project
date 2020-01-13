package com.fh.payLog.mapper;


import com.fh.payLog.model.PayLog;

public interface PayLogMapper {
    void addPayLog(PayLog payLog);

    void updatePayLog(PayLog payLog);

    PayLog getPayLogByOutTradeNo(String outTradeNo);
}
