package com.qian.miniapp;

import com.fasterxml.jackson.annotation.JsonProperty;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 小程序支付 V2 接口（和公众号支付底层一致，仅trade_type=JSAPI）
 * 文档地址：https://pay.weixin.qq.com/wiki/doc/api/wxa/wxa_api.php?chapter=9_1
 *
 * @author auto-gen
 */
public interface WeChatMiniPayV2Service {

    /**
     * 统一下单
     */
    @POST("/_/pay/unifiedOrder")
    WeChatMiniPayUnifiedOrderResp unifiedOrder(@Body WeChatMiniPayUnifiedOrderReq req);

    /**
     * 查询订单
     */
    @POST("pay/orderquery")
    WeChatMiniPayOrderQueryResp orderQuery(@Body WeChatMiniPayOrderQueryReq req);

    /**
     * 关闭订单
     */
    @POST("pay/closeorder")
    WeChatMiniPayCloseOrderResp closeOrder(@Body WeChatMiniPayCloseOrderReq req);

    /**
     * 申请退款
     */
    @POST("secapi/pay/refund")
    WeChatMiniPayRefundResp refund(@Body WeChatMiniPayRefundReq req);

    /**
     * 查询退款
     */
    @POST("pay/refundquery")
    WeChatMiniPayRefundQueryResp refundQuery(@Body WeChatMiniPayRefundQueryReq req);

    class WeChatMiniPayBaseResp {
        @JsonProperty("return_code")
        private String returnCode;
        @JsonProperty("return_msg")
        private String returnMsg;
        @JsonProperty("result_code")
        private String resultCode;
        @JsonProperty("err_code")
        private String errCode;
        @JsonProperty("err_code_des")
        private String errCodeDes;

        public String getReturnCode() {
            return returnCode;
        }

        public void setReturnCode(String returnCode) {
            this.returnCode = returnCode;
        }

        public String getReturnMsg() {
            return returnMsg;
        }

        public void setReturnMsg(String returnMsg) {
            this.returnMsg = returnMsg;
        }

        public String getResultCode() {
            return resultCode;
        }

        public void setResultCode(String resultCode) {
            this.resultCode = resultCode;
        }

        public String getErrCode() {
            return errCode;
        }

        public void setErrCode(String errCode) {
            this.errCode = errCode;
        }

        public String getErrCodeDes() {
            return errCodeDes;
        }

        public void setErrCodeDes(String errCodeDes) {
            this.errCodeDes = errCodeDes;
        }
    }

    class WeChatMiniPayUnifiedOrderReq {
        @JsonProperty("appid")
        private String appid;
        @JsonProperty("mch_id")
        private String mchId;
        @JsonProperty("nonce_str")
        private String nonceStr;
        @JsonProperty("sign")
        private String sign;
        @JsonProperty("body")
        private String body;
        @JsonProperty("out_trade_no")
        private String outTradeNo;
        @JsonProperty("total_fee")
        private String totalFee;
        @JsonProperty("spbill_create_ip")
        private String spbillCreateIp;
        @JsonProperty("notify_url")
        private String notifyUrl;
        @JsonProperty("trade_type")
        private String tradeType;
        @JsonProperty("openid")
        private String openid;
        @JsonProperty("attach")
        private String attach;
        @JsonProperty("time_expire")
        private String timeExpire;

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getMchId() {
            return mchId;
        }

        public void setMchId(String mchId) {
            this.mchId = mchId;
        }

        public String getNonceStr() {
            return nonceStr;
        }

        public void setNonceStr(String nonceStr) {
            this.nonceStr = nonceStr;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public String getOutTradeNo() {
            return outTradeNo;
        }

        public void setOutTradeNo(String outTradeNo) {
            this.outTradeNo = outTradeNo;
        }

        public String getTotalFee() {
            return totalFee;
        }

        public void setTotalFee(String totalFee) {
            this.totalFee = totalFee;
        }

        public String getSpbillCreateIp() {
            return spbillCreateIp;
        }

        public void setSpbillCreateIp(String spbillCreateIp) {
            this.spbillCreateIp = spbillCreateIp;
        }

        public String getNotifyUrl() {
            return notifyUrl;
        }

        public void setNotifyUrl(String notifyUrl) {
            this.notifyUrl = notifyUrl;
        }

        public String getTradeType() {
            return tradeType;
        }

        public void setTradeType(String tradeType) {
            this.tradeType = tradeType;
        }

        public String getOpenid() {
            return openid;
        }

        public void setOpenid(String openid) {
            this.openid = openid;
        }

        public String getAttach() {
            return attach;
        }

        public void setAttach(String attach) {
            this.attach = attach;
        }

        public String getTimeExpire() {
            return timeExpire;
        }

        public void setTimeExpire(String timeExpire) {
            this.timeExpire = timeExpire;
        }
    }

    class WeChatMiniPayUnifiedOrderResp extends WeChatMiniPayBaseResp {
        @JsonProperty("prepay_id")
        private String prepayId;
        @JsonProperty("trade_type")
        private String tradeType;

        public String getPrepayId() {
            return prepayId;
        }

        public void setPrepayId(String prepayId) {
            this.prepayId = prepayId;
        }

        public String getTradeType() {
            return tradeType;
        }

        public void setTradeType(String tradeType) {
            this.tradeType = tradeType;
        }
    }

    class WeChatMiniPayOrderQueryReq {
        @JsonProperty("appid")
        private String appid;
        @JsonProperty("mch_id")
        private String mchId;
        @JsonProperty("nonce_str")
        private String nonceStr;
        @JsonProperty("sign")
        private String sign;
        @JsonProperty("out_trade_no")
        private String outTradeNo;
        @JsonProperty("transaction_id")
        private String transactionId;

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getMchId() {
            return mchId;
        }

        public void setMchId(String mchId) {
            this.mchId = mchId;
        }

        public String getNonceStr() {
            return nonceStr;
        }

        public void setNonceStr(String nonceStr) {
            this.nonceStr = nonceStr;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public String getOutTradeNo() {
            return outTradeNo;
        }

        public void setOutTradeNo(String outTradeNo) {
            this.outTradeNo = outTradeNo;
        }

        public String getTransactionId() {
            return transactionId;
        }

        public void setTransactionId(String transactionId) {
            this.transactionId = transactionId;
        }
    }

    class WeChatMiniPayOrderQueryResp extends WeChatMiniPayBaseResp {
        @JsonProperty("trade_state")
        private String tradeState;
        @JsonProperty("out_trade_no")
        private String outTradeNo;
        @JsonProperty("transaction_id")
        private String transactionId;
        @JsonProperty("total_fee")
        private String totalFee;
        @JsonProperty("openid")
        private String openid;

        public String getTradeState() {
            return tradeState;
        }

        public void setTradeState(String tradeState) {
            this.tradeState = tradeState;
        }

        public String getOutTradeNo() {
            return outTradeNo;
        }

        public void setOutTradeNo(String outTradeNo) {
            this.outTradeNo = outTradeNo;
        }

        public String getTransactionId() {
            return transactionId;
        }

        public void setTransactionId(String transactionId) {
            this.transactionId = transactionId;
        }

        public String getTotalFee() {
            return totalFee;
        }

        public void setTotalFee(String totalFee) {
            this.totalFee = totalFee;
        }

        public String getOpenid() {
            return openid;
        }

        public void setOpenid(String openid) {
            this.openid = openid;
        }
    }

    class WeChatMiniPayCloseOrderReq {
        @JsonProperty("appid")
        private String appid;
        @JsonProperty("mch_id")
        private String mchId;
        @JsonProperty("nonce_str")
        private String nonceStr;
        @JsonProperty("sign")
        private String sign;
        @JsonProperty("out_trade_no")
        private String outTradeNo;

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getMchId() {
            return mchId;
        }

        public void setMchId(String mchId) {
            this.mchId = mchId;
        }

        public String getNonceStr() {
            return nonceStr;
        }

        public void setNonceStr(String nonceStr) {
            this.nonceStr = nonceStr;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public String getOutTradeNo() {
            return outTradeNo;
        }

        public void setOutTradeNo(String outTradeNo) {
            this.outTradeNo = outTradeNo;
        }
    }

    class WeChatMiniPayCloseOrderResp extends WeChatMiniPayBaseResp {
    }

    class WeChatMiniPayRefundReq {
        @JsonProperty("appid")
        private String appid;
        @JsonProperty("mch_id")
        private String mchId;
        @JsonProperty("nonce_str")
        private String nonceStr;
        @JsonProperty("sign")
        private String sign;
        @JsonProperty("out_trade_no")
        private String outTradeNo;
        @JsonProperty("out_refund_no")
        private String outRefundNo;
        @JsonProperty("total_fee")
        private String totalFee;
        @JsonProperty("refund_fee")
        private String refundFee;
        @JsonProperty("refund_desc")
        private String refundDesc;
        @JsonProperty("notify_url")
        private String notifyUrl;

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getMchId() {
            return mchId;
        }

        public void setMchId(String mchId) {
            this.mchId = mchId;
        }

        public String getNonceStr() {
            return nonceStr;
        }

        public void setNonceStr(String nonceStr) {
            this.nonceStr = nonceStr;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public String getOutTradeNo() {
            return outTradeNo;
        }

        public void setOutTradeNo(String outTradeNo) {
            this.outTradeNo = outTradeNo;
        }

        public String getOutRefundNo() {
            return outRefundNo;
        }

        public void setOutRefundNo(String outRefundNo) {
            this.outRefundNo = outRefundNo;
        }

        public String getTotalFee() {
            return totalFee;
        }

        public void setTotalFee(String totalFee) {
            this.totalFee = totalFee;
        }

        public String getRefundFee() {
            return refundFee;
        }

        public void setRefundFee(String refundFee) {
            this.refundFee = refundFee;
        }

        public String getRefundDesc() {
            return refundDesc;
        }

        public void setRefundDesc(String refundDesc) {
            this.refundDesc = refundDesc;
        }

        public String getNotifyUrl() {
            return notifyUrl;
        }

        public void setNotifyUrl(String notifyUrl) {
            this.notifyUrl = notifyUrl;
        }
    }

    class WeChatMiniPayRefundResp extends WeChatMiniPayBaseResp {
        @JsonProperty("out_refund_no")
        private String outRefundNo;
        @JsonProperty("refund_id")
        private String refundId;
        @JsonProperty("refund_fee")
        private String refundFee;

        public String getOutRefundNo() {
            return outRefundNo;
        }

        public void setOutRefundNo(String outRefundNo) {
            this.outRefundNo = outRefundNo;
        }

        public String getRefundId() {
            return refundId;
        }

        public void setRefundId(String refundId) {
            this.refundId = refundId;
        }

        public String getRefundFee() {
            return refundFee;
        }

        public void setRefundFee(String refundFee) {
            this.refundFee = refundFee;
        }
    }

    class WeChatMiniPayRefundQueryReq {
        @JsonProperty("appid")
        private String appid;
        @JsonProperty("mch_id")
        private String mchId;
        @JsonProperty("nonce_str")
        private String nonceStr;
        @JsonProperty("sign")
        private String sign;
        @JsonProperty("out_refund_no")
        private String outRefundNo;
        @JsonProperty("out_trade_no")
        private String outTradeNo;
        @JsonProperty("refund_id")
        private String refundId;

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getMchId() {
            return mchId;
        }

        public void setMchId(String mchId) {
            this.mchId = mchId;
        }

        public String getNonceStr() {
            return nonceStr;
        }

        public void setNonceStr(String nonceStr) {
            this.nonceStr = nonceStr;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public String getOutRefundNo() {
            return outRefundNo;
        }

        public void setOutRefundNo(String outRefundNo) {
            this.outRefundNo = outRefundNo;
        }

        public String getOutTradeNo() {
            return outTradeNo;
        }

        public void setOutTradeNo(String outTradeNo) {
            this.outTradeNo = outTradeNo;
        }

        public String getRefundId() {
            return refundId;
        }

        public void setRefundId(String refundId) {
            this.refundId = refundId;
        }
    }

    class WeChatMiniPayRefundQueryResp extends WeChatMiniPayBaseResp {
        @JsonProperty("out_refund_no_0")
        private String outRefundNo0;
        @JsonProperty("refund_id_0")
        private String refundId0;
        @JsonProperty("refund_status_0")
        private String refundStatus0;
        @JsonProperty("refund_fee_0")
        private String refundFee0;

        public String getOutRefundNo0() {
            return outRefundNo0;
        }

        public void setOutRefundNo0(String outRefundNo0) {
            this.outRefundNo0 = outRefundNo0;
        }

        public String getRefundId0() {
            return refundId0;
        }

        public void setRefundId0(String refundId0) {
            this.refundId0 = refundId0;
        }

        public String getRefundStatus0() {
            return refundStatus0;
        }

        public void setRefundStatus0(String refundStatus0) {
            this.refundStatus0 = refundStatus0;
        }

        public String getRefundFee0() {
            return refundFee0;
        }

        public void setRefundFee0(String refundFee0) {
            this.refundFee0 = refundFee0;
        }
    }
}
