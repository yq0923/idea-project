package com.fh.payLog.service;

import com.fh.common.ResponseEnum;
import com.fh.common.ServerResponse;
import com.fh.payLog.mapper.PayLogMapper;
import com.fh.payLog.model.PayLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayLogServiceImpl implements PayLogService {

    @Autowired
    private PayLogMapper payLogMapper;

    @Override
    public void addPayLog(PayLog payLog) {
        payLogMapper.addPayLog(payLog);
    }

    @Override
    public void updatePayLog(PayLog payLog) {
        payLogMapper.updatePayLog(payLog);
    }

    @Override
    public ServerResponse getPayMoney(String outTradeNo) {
        PayLog payLog = payLogMapper.getPayLogByOutTradeNo(outTradeNo);
        if (payLog == null) {
            return ServerResponse.error(ResponseEnum.OUT_TRADE_NO_INVALID);
        }
        if (payLog.getPayStatus() == 1) {
            return ServerResponse.error();
        }
        return ServerResponse.success(payLog.getPayMoney());
    }
}
