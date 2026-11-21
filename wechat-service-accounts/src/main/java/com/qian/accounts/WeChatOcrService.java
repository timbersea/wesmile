package com.qian.accounts;


import com.fasterxml.jackson.annotation.JsonProperty;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.util.List;

/**
 * 公众号服务平台 - OCR识别接口
 * 官方文档地址：https://developers.weixin.qq.com/doc/service/api/ocr/
 *
 * @author auto-gen
 */
public interface WeChatOcrService {
    /**
     * 身份证OCR识别
     * <p>上传图片url，识别身份证正反面信息。</p>
     *
     * @param req 图片url请求
     * @return 身份证识别结果
     */
    @POST("cv/ocr/idcard")
    WeChatOcrIdCardResp ocrIdCard(@Body WeChatOcrUrlReq req);

    /**
     * 银行卡OCR识别
     * <p>识别银行卡卡号、银行名称等信息。</p>
     *
     * @param req 图片url请求
     * @return 银行卡识别结果
     */
    @POST("cv/ocr/bankcard")
    WeChatOcrBankCardResp ocrBankCard(@Body WeChatOcrUrlReq req);

    /**
     * 驾驶证OCR识别
     * <p>识别机动车驾驶证信息。</p>
     *
     * @param req 图片url请求
     * @return 驾驶证识别结果
     */
    @POST("cv/ocr/drivinglicense")
    WeChatOcrDrivingLicenseResp ocrDrivingLicense(@Body WeChatOcrUrlReq req);

    /**
     * 行驶证OCR识别
     * <p>识别机动车行驶证信息。</p>
     *
     * @param req 图片url请求
     * @return 行驶证识别结果
     */
    @POST("cv/ocr/driving")
    WeChatOcrDrivingResp ocrDriving(@Body WeChatOcrUrlReq req);

    /**
     * 营业执照OCR识别
     * <p>识别营业执照统一社会信用代码、名称、地址等信息。</p>
     *
     * @param req 图片url请求
     * @return 营业执照识别结果
     */
    @POST("cv/ocr/bizlicense")
    WeChatOcrBizLicenseResp ocrBizLicense(@Body WeChatOcrUrlReq req);

    /**
     * 通用印刷体OCR识别
     * <p>识别图片内印刷文字，返回多行文本块。</p>
     *
     * @param req 图片url请求
     * @return 通用印刷体识别结果
     */
    @POST("cv/ocr/comm")
    WeChatOcrCommResp ocrComm(@Body WeChatOcrUrlReq req);

    /**
     * 菜单OCR识别
     * <p>识别纸质菜单菜品、价格等信息。</p>
     *
     * @param req 图片url请求
     * @return 菜单识别结果
     */
    @POST("cv/ocr/menu")
    WeChatOcrMenuResp ocrMenu(@Body WeChatOcrUrlReq req);

    class WeChatOcrUrlReq {
        @JsonProperty("img_url")
        private String imgUrl;

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }
    }

    class WeChatOcrIdCardResp {
        @JsonProperty("type")
        private String type;
        @JsonProperty("name")
        private String name;
        @JsonProperty("id")
        private String id;
        @JsonProperty("sex")
        private String sex;
        @JsonProperty("nationality")
        private String nationality;
        @JsonProperty("birth")
        private String birth;
        @JsonProperty("address")
        private String address;
        @JsonProperty("valid_date")
        private String validDate;
        @JsonProperty("authority")
        private String authority;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getNationality() {
            return nationality;
        }

        public void setNationality(String nationality) {
            this.nationality = nationality;
        }

        public String getBirth() {
            return birth;
        }

        public void setBirth(String birth) {
            this.birth = birth;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getValidDate() {
            return validDate;
        }

        public void setValidDate(String validDate) {
            this.validDate = validDate;
        }

        public String getAuthority() {
            return authority;
        }

        public void setAuthority(String authority) {
            this.authority = authority;
        }
    }

    class WeChatOcrBankCardResp {
        @JsonProperty("bank_name")
        private String bankName;
        @JsonProperty("card_num")
        private String cardNum;
        @JsonProperty("card_type")
        private String cardType;

        public String getBankName() {
            return bankName;
        }

        public void setBankName(String bankName) {
            this.bankName = bankName;
        }

        public String getCardNum() {
            return cardNum;
        }

        public void setCardNum(String cardNum) {
            this.cardNum = cardNum;
        }

        public String getCardType() {
            return cardType;
        }

        public void setCardType(String cardType) {
            this.cardType = cardType;
        }
    }

    class WeChatOcrDrivingLicenseResp {
        @JsonProperty("name")
        private String name;
        @JsonProperty("id")
        private String id;
        @JsonProperty("sex")
        private String sex;
        @JsonProperty("nationality")
        private String nationality;
        @JsonProperty("address")
        private String address;
        @JsonProperty("birthday")
        private String birthday;
        @JsonProperty("first_issue_date")
        private String firstIssueDate;
        @JsonProperty("drive_class")
        private String driveClass;
        @JsonProperty("valid_from")
        private String validFrom;
        @JsonProperty("valid_to")
        private String validTo;
        @JsonProperty("record")
        private String record;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getNationality() {
            return nationality;
        }

        public void setNationality(String nationality) {
            this.nationality = nationality;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getFirstIssueDate() {
            return firstIssueDate;
        }

        public void setFirstIssueDate(String firstIssueDate) {
            this.firstIssueDate = firstIssueDate;
        }

        public String getDriveClass() {
            return driveClass;
        }

        public void setDriveClass(String driveClass) {
            this.driveClass = driveClass;
        }

        public String getValidFrom() {
            return validFrom;
        }

        public void setValidFrom(String validFrom) {
            this.validFrom = validFrom;
        }

        public String getValidTo() {
            return validTo;
        }

        public void setValidTo(String validTo) {
            this.validTo = validTo;
        }

        public String getRecord() {
            return record;
        }

        public void setRecord(String record) {
            this.record = record;
        }
    }

    class WeChatOcrDrivingResp {
        @JsonProperty("plate_num")
        private String plateNum;
        @JsonProperty("vehicle_type")
        private String vehicleType;
        @JsonProperty("owner")
        private String owner;
        @JsonProperty("address")
        private String address;
        @JsonProperty("model")
        private String model;
        @JsonProperty("vin")
        private String vin;
        @JsonProperty("engine_num")
        private String engineNum;
        @JsonProperty("register_date")
        private String registerDate;
        @JsonProperty("issue_date")
        private String issueDate;
        @JsonProperty("use_character")
        private String useCharacter;

        public String getPlateNum() {
            return plateNum;
        }

        public void setPlateNum(String plateNum) {
            this.plateNum = plateNum;
        }

        public String getVehicleType() {
            return vehicleType;
        }

        public void setVehicleType(String vehicleType) {
            this.vehicleType = vehicleType;
        }

        public String getOwner() {
            return owner;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getVin() {
            return vin;
        }

        public void setVin(String vin) {
            this.vin = vin;
        }

        public String getEngineNum() {
            return engineNum;
        }

        public void setEngineNum(String engineNum) {
            this.engineNum = engineNum;
        }

        public String getRegisterDate() {
            return registerDate;
        }

        public void setRegisterDate(String registerDate) {
            this.registerDate = registerDate;
        }

        public String getIssueDate() {
            return issueDate;
        }

        public void setIssueDate(String issueDate) {
            this.issueDate = issueDate;
        }

        public String getUseCharacter() {
            return useCharacter;
        }

        public void setUseCharacter(String useCharacter) {
            this.useCharacter = useCharacter;
        }
    }

    class WeChatOcrBizLicenseResp {
        @JsonProperty("reg_num")
        private String regNum;
        @JsonProperty("name")
        private String name;
        @JsonProperty("address")
        private String address;
        @JsonProperty("person")
        private String person;
        @JsonProperty("valid_period")
        private String validPeriod;
        @JsonProperty("business_scope")
        private String businessScope;

        public String getRegNum() {
            return regNum;
        }

        public void setRegNum(String regNum) {
            this.regNum = regNum;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPerson() {
            return person;
        }

        public void setPerson(String person) {
            this.person = person;
        }

        public String getValidPeriod() {
            return validPeriod;
        }

        public void setValidPeriod(String validPeriod) {
            this.validPeriod = validPeriod;
        }

        public String getBusinessScope() {
            return businessScope;
        }

        public void setBusinessScope(String businessScope) {
            this.businessScope = businessScope;
        }
    }

    class WeChatOcrCommResp {
        @JsonProperty("items")
        private List<WeChatOcrCommItem> items;

        public List<WeChatOcrCommItem> getItems() {
            return items;
        }

        public void setItems(List<WeChatOcrCommItem> items) {
            this.items = items;
        }
    }

    class WeChatOcrCommItem {
        @JsonProperty("text")
        private String text;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    class WeChatOcrMenuResp {
        @JsonProperty("items")
        private List<WeChatOcrMenuItem> items;

        public List<WeChatOcrMenuItem> getItems() {
            return items;
        }

        public void setItems(List<WeChatOcrMenuItem> items) {
            this.items = items;
        }
    }

    class WeChatOcrMenuItem {
        @JsonProperty("name")
        private String name;
        @JsonProperty("price")
        private String price;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }
    }
}
