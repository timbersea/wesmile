package com.qian.miniapp;

import com.fasterxml.jackson.annotation.JsonProperty;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 小程序OCR识别接口
 * 文档地址：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/ocr/ocr.business.recognize.html
 *
 * @author auto-gen
 */
public interface WeChatMiniOcrService {

    /**
     * OCR通用识别（支持身份证、银行卡、行驶证、驾驶证、营业执照等）
     */
    @POST("cv/ocr/business/recognize")
    WeChatMiniOcrResp ocrRecognize(
            @Body WeChatMiniOcrReq req);

    class WeChatMiniOcrBaseResp {
        @JsonProperty("errcode")
        private Integer errCode;
        @JsonProperty("errmsg")
        private String errMsg;

        public Integer getErrCode() {
            return errCode;
        }

        public void setErrCode(Integer errCode) {
            this.errCode = errCode;
        }

        public String getErrMsg() {
            return errMsg;
        }

        public void setErrMsg(String errMsg) {
            this.errMsg = errMsg;
        }
    }

    class WeChatMiniOcrReq {
        /**
         * 识别类型：
         * IDCard -> 身份证
         * BankCard -> 银行卡
         * DrivingLicense -> 驾驶证
         * VehicleLicense -> 行驶证
         * BusinessLicense -> 营业执照
         */
        @JsonProperty("type")
        private String type;
        @JsonProperty("img_url")
        private String imgUrl;
        @JsonProperty("img")
        private String img;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }
    }

    class WeChatMiniOcrResp extends WeChatMiniOcrBaseResp {
        @JsonProperty("result")
        private Object result;

        public Object getResult() {
            return result;
        }

        public void setResult(Object result) {
            this.result = result;
        }
    }
}
