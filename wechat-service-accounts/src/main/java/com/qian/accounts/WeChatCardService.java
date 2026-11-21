package com.qian.accounts;

import com.fasterxml.jackson.annotation.JsonProperty;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.util.List;

/**
 * 公众号服务平台 - 卡券接口
 * 官方文档地址：https://developers.weixin.qq.com/doc/offiaccount/Cards_and_Offer/Coupons-Mini_Program_Cards_Intro.html
 *
 * @author auto-gen
 */
public interface WeChatCardService {

    /**
     * 创建卡券
     */
    @POST("cgi-bin/card/create")
    WeChatCardCreateResp createCard(
            @Body WeChatCardCreateReq req);

    /**
     * 获取卡券详情
     */
    @POST("cgi-bin/card/get")
    WeChatCardGetResp getCard(
            @Body WeChatCardGetReq req);

    /**
     * 修改卡券
     */
    @POST("cgi-bin/card/update")
    WeChatCardUpdateResp updateCard(
            @Body WeChatCardUpdateReq req);

    /**
     * 删除卡券
     */
    @POST("cgi-bin/card/delete")
    WeChatBaseResp deleteCard(
            @Body WeChatCardDeleteReq req);

    /**
     * 查询卡券列表
     */
    @POST("cgi-bin/card/batchget")
    WeChatCardBatchResp batchGetCard(
            @Body WeChatCardBatchReq req);

    /**
     * 设置卡券库存
     */
    @POST("cgi-bin/card/modifystock")
    WeChatCardModifyStockResp modifyCardStock(
            @Body WeChatCardModifyStockReq req);

    /**
     * 核销卡券
     */
    @POST("cgi-bin/card/code/consume")
    WeChatCardConsumeResp consumeCard(
            @Body WeChatCardConsumeReq req);

    /**
     * 查询Code状态
     */
    @POST("cgi-bin/card/code/get")
    WeChatCardCodeGetResp getCardCode(
            @Body WeChatCardCodeGetReq req);

    class WeChatBaseResp {
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

    class WeChatCardBaseInfo {
        @JsonProperty("card_id")
        private String cardId;
        @JsonProperty("card_type")
        private String cardType;
        @JsonProperty("brand_name")
        private String brandName;
        @JsonProperty("title")
        private String title;
        @JsonProperty("sub_title")
        private String subTitle;
        @JsonProperty("logo_url")
        private String logoUrl;
        @JsonProperty("color")
        private String color;
        @JsonProperty("notice")
        private String notice;
        @JsonProperty("service_phone")
        private String servicePhone;
        @JsonProperty("description")
        private String description;
        @JsonProperty("date_info")
        private WeChatCardDateInfo dateInfo;
        @JsonProperty("sku")
        private WeChatCardSku sku;

        public String getCardId() {
            return cardId;
        }

        public void setCardId(String cardId) {
            this.cardId = cardId;
        }

        public String getCardType() {
            return cardType;
        }

        public void setCardType(String cardType) {
            this.cardType = cardType;
        }

        public String getBrandName() {
            return brandName;
        }

        public void setBrandName(String brandName) {
            this.brandName = brandName;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSubTitle() {
            return subTitle;
        }

        public void setSubTitle(String subTitle) {
            this.subTitle = subTitle;
        }

        public String getLogoUrl() {
            return logoUrl;
        }

        public void setLogoUrl(String logoUrl) {
            this.logoUrl = logoUrl;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getNotice() {
            return notice;
        }

        public void setNotice(String notice) {
            this.notice = notice;
        }

        public String getServicePhone() {
            return servicePhone;
        }

        public void setServicePhone(String servicePhone) {
            this.servicePhone = servicePhone;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public WeChatCardDateInfo getDateInfo() {
            return dateInfo;
        }

        public void setDateInfo(WeChatCardDateInfo dateInfo) {
            this.dateInfo = dateInfo;
        }

        public WeChatCardSku getSku() {
            return sku;
        }

        public void setSku(WeChatCardSku sku) {
            this.sku = sku;
        }
    }

    class WeChatCardDateInfo {
        @JsonProperty("type")
        private String type;
        @JsonProperty("begin_timestamp")
        private Long beginTimestamp;
        @JsonProperty("end_timestamp")
        private Long endTimestamp;
        @JsonProperty("fixed_term")
        private Integer fixedTerm;
        @JsonProperty("fixed_begin_term")
        private Integer fixedBeginTerm;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Long getBeginTimestamp() {
            return beginTimestamp;
        }

        public void setBeginTimestamp(Long beginTimestamp) {
            this.beginTimestamp = beginTimestamp;
        }

        public Long getEndTimestamp() {
            return endTimestamp;
        }

        public void setEndTimestamp(Long endTimestamp) {
            this.endTimestamp = endTimestamp;
        }

        public Integer getFixedTerm() {
            return fixedTerm;
        }

        public void setFixedTerm(Integer fixedTerm) {
            this.fixedTerm = fixedTerm;
        }

        public Integer getFixedBeginTerm() {
            return fixedBeginTerm;
        }

        public void setFixedBeginTerm(Integer fixedBeginTerm) {
            this.fixedBeginTerm = fixedBeginTerm;
        }
    }

    class WeChatCardSku {
        @JsonProperty("quantity")
        private Integer quantity;

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }
    }

    class WeChatCardCreateReq {
        @JsonProperty("card")
        private WeChatCardBaseInfo card;

        public WeChatCardBaseInfo getCard() {
            return card;
        }

        public void setCard(WeChatCardBaseInfo card) {
            this.card = card;
        }
    }

    class WeChatCardCreateResp extends WeChatBaseResp {
        @JsonProperty("card_id")
        private String cardId;

        public String getCardId() {
            return cardId;
        }

        public void setCardId(String cardId) {
            this.cardId = cardId;
        }
    }

    class WeChatCardGetReq {
        @JsonProperty("card_id")
        private String cardId;

        public String getCardId() {
            return cardId;
        }

        public void setCardId(String cardId) {
            this.cardId = cardId;
        }
    }

    class WeChatCardGetResp extends WeChatBaseResp {
        @JsonProperty("card")
        private WeChatCardBaseInfo card;

        public WeChatCardBaseInfo getCard() {
            return card;
        }

        public void setCard(WeChatCardBaseInfo card) {
            this.card = card;
        }
    }

    class WeChatCardUpdateReq {
        @JsonProperty("card_id")
        private String cardId;
        @JsonProperty("base_info")
        private WeChatCardBaseInfo baseInfo;

        public String getCardId() {
            return cardId;
        }

        public void setCardId(String cardId) {
            this.cardId = cardId;
        }

        public WeChatCardBaseInfo getBaseInfo() {
            return baseInfo;
        }

        public void setBaseInfo(WeChatCardBaseInfo baseInfo) {
            this.baseInfo = baseInfo;
        }
    }

    class WeChatCardUpdateResp extends WeChatBaseResp {
        @JsonProperty("send_check")
        private Boolean sendCheck;

        public Boolean getSendCheck() {
            return sendCheck;
        }

        public void setSendCheck(Boolean sendCheck) {
            this.sendCheck = sendCheck;
        }
    }

    class WeChatCardDeleteReq {
        @JsonProperty("card_id")
        private String cardId;

        public String getCardId() {
            return cardId;
        }

        public void setCardId(String cardId) {
            this.cardId = cardId;
        }
    }

    class WeChatCardBatchReq {
        @JsonProperty("offset")
        private Integer offset;
        @JsonProperty("count")
        private Integer count;

        public Integer getOffset() {
            return offset;
        }

        public void setOffset(Integer offset) {
            this.offset = offset;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }
    }

    class WeChatCardBatchResp extends WeChatBaseResp {
        @JsonProperty("card_id_list")
        private List<String> cardIdList;
        @JsonProperty("total_num")
        private Integer totalNum;

        public List<String> getCardIdList() {
            return cardIdList;
        }

        public void setCardIdList(List<String> cardIdList) {
            this.cardIdList = cardIdList;
        }

        public Integer getTotalNum() {
            return totalNum;
        }

        public void setTotalNum(Integer totalNum) {
            this.totalNum = totalNum;
        }
    }

    class WeChatCardModifyStockReq {
        @JsonProperty("card_id")
        private String cardId;
        @JsonProperty("increase_stock_value")
        private Integer increaseStockValue;
        @JsonProperty("reduce_stock_value")
        private Integer reduceStockValue;

        public String getCardId() {
            return cardId;
        }

        public void setCardId(String cardId) {
            this.cardId = cardId;
        }

        public Integer getIncreaseStockValue() {
            return increaseStockValue;
        }

        public void setIncreaseStockValue(Integer increaseStockValue) {
            this.increaseStockValue = increaseStockValue;
        }

        public Integer getReduceStockValue() {
            return reduceStockValue;
        }

        public void setReduceStockValue(Integer reduceStockValue) {
            this.reduceStockValue = reduceStockValue;
        }
    }

    class WeChatCardModifyStockResp extends WeChatBaseResp {
        @JsonProperty("stock_value")
        private Integer stockValue;

        public Integer getStockValue() {
            return stockValue;
        }

        public void setStockValue(Integer stockValue) {
            this.stockValue = stockValue;
        }
    }

    class WeChatCardConsumeReq {
        @JsonProperty("code")
        private String code;
        @JsonProperty("card_id")
        private String cardId;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getCardId() {
            return cardId;
        }

        public void setCardId(String cardId) {
            this.cardId = cardId;
        }
    }

    class WeChatCardConsumeResp extends WeChatBaseResp {
        @JsonProperty("card")
        private WeChatCardBaseInfo card;
        @JsonProperty("openid")
        private String openid;

        public WeChatCardBaseInfo getCard() {
            return card;
        }

        public void setCard(WeChatCardBaseInfo card) {
            this.card = card;
        }

        public String getOpenid() {
            return openid;
        }

        public void setOpenid(String openid) {
            this.openid = openid;
        }
    }

    class WeChatCardCodeGetReq {
        @JsonProperty("code")
        private String code;
        @JsonProperty("card_id")
        private String cardId;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getCardId() {
            return cardId;
        }

        public void setCardId(String cardId) {
            this.cardId = cardId;
        }
    }

    class WeChatCardCodeGetResp extends WeChatBaseResp {
        @JsonProperty("card")
        private WeChatCardCodeInfo card;

        public WeChatCardCodeInfo getCard() {
            return card;
        }

        public void setCard(WeChatCardCodeInfo card) {
            this.card = card;
        }
    }

    class WeChatCardCodeInfo {
        @JsonProperty("card_id")
        private String cardId;
        @JsonProperty("code")
        private String code;
        @JsonProperty("openid")
        private String openid;
        @JsonProperty("is_consumed")
        private Boolean isConsumed;

        public String getCardId() {
            return cardId;
        }

        public void setCardId(String cardId) {
            this.cardId = cardId;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getOpenid() {
            return openid;
        }

        public void setOpenid(String openid) {
            this.openid = openid;
        }

        public Boolean getConsumed() {
            return isConsumed;
        }

        public void setConsumed(Boolean consumed) {
            isConsumed = consumed;
        }
    }
}

