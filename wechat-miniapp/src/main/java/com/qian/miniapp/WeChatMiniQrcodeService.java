package com.qian.miniapp;

import com.fasterxml.jackson.annotation.JsonProperty;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 小程序码接口
 * 文档地址：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/qr-code/wxacode.get.html
 *
 * @author auto-gen
 */
public interface WeChatMiniQrcodeService {

    /**
     * 接口A：wxacode.get 生成小程序码（数量有限，永久）
     */
    @POST("wxa/getwxacode")
    ResponseBody getWxaCode(
            @Body WeChatMiniWxaCodeReq req);

    /**
     * 接口B：wxacode.getUnlimited 生成无限数量小程序码（推荐）
     */
    @POST("wxa/getwxacodeunlimit")
    ResponseBody getWxaCodeUnlimited(
            @Body WeChatMiniWxaCodeUnlimitedReq req);

    /**
     * 接口C：createwxaqrcode 生成小程序二维码（数量有限）
     */
    @POST("cgi-bin/wxaapp/createwxaqrcode")
    ResponseBody createWxaQrCode(
            @Body WeChatMiniQrCodeReq req);

    class WeChatMiniWxaCodeReq {
        @JsonProperty("path")
        private String path;
        @JsonProperty("width")
        private Integer width;
        @JsonProperty("auto_color")
        private Boolean autoColor;
        @JsonProperty("line_color")
        private Object lineColor;
        @JsonProperty("is_hyaline")
        private Boolean isHyaline;

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }

        public Boolean getAutoColor() {
            return autoColor;
        }

        public void setAutoColor(Boolean autoColor) {
            this.autoColor = autoColor;
        }

        public Object getLineColor() {
            return lineColor;
        }

        public void setLineColor(Object lineColor) {
            this.lineColor = lineColor;
        }

        public Boolean getIsHyaline() {
            return isHyaline;
        }

        public void setIsHyaline(Boolean isHyaline) {
            this.isHyaline = isHyaline;
        }
    }

    class WeChatMiniWxaCodeUnlimitedReq {
        @JsonProperty("scene")
        private String scene;
        @JsonProperty("page")
        private String page;
        @JsonProperty("width")
        private Integer width;
        @JsonProperty("auto_color")
        private Boolean autoColor;
        @JsonProperty("line_color")
        private Object lineColor;
        @JsonProperty("is_hyaline")
        private Boolean isHyaline;

        public String getScene() {
            return scene;
        }

        public void setScene(String scene) {
            this.scene = scene;
        }

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }

        public Boolean getAutoColor() {
            return autoColor;
        }

        public void setAutoColor(Boolean autoColor) {
            this.autoColor = autoColor;
        }

        public Object getLineColor() {
            return lineColor;
        }

        public void setLineColor(Object lineColor) {
            this.lineColor = lineColor;
        }

        public Boolean getIsHyaline() {
            return isHyaline;
        }

        public void setIsHyaline(Boolean isHyaline) {
            this.isHyaline = isHyaline;
        }
    }

    class WeChatMiniQrCodeReq {
        @JsonProperty("path")
        private String path;
        @JsonProperty("width")
        private Integer width;

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }
    }
}
