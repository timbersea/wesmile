package com.qian.accounts;


import com.fasterxml.jackson.annotation.JsonProperty;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;

/**
 * 公众号服务平台 - 菜单管理接口
 * 官方文档地址：https://developers.weixin.qq.com/doc/offiaccount/Custom_Menus/Creating_Custom-Defined_Menu.html
 *
 * @author auto-gen
 */
public interface WeChatMenuService {

    /**
     * 创建菜单
     *
     * @param req 菜单请求体
     * @return 基础返回
     */
    @POST("cgi-bin/menu/create")
    WeChatBaseResp createMenu(
            @Body WeChatMenuCreateReq req);

    /**
     * 查询菜单
     *
     * @return 菜单查询结果
     */
    @GET("cgi-bin/menu/get")
    WeChatMenuGetResp getMenu();

    /**
     * 删除菜单
     *
     * @return 基础返回
     */
    @GET("cgi-bin/menu/delete")
    WeChatBaseResp deleteMenu();

    /**
     * 创建个性化菜单
     *
     * @param req 个性化菜单请求体
     * @return 创建结果，返回menuid
     */
    @POST("cgi-bin/menu/addconditional")
    WeChatMenuAddConditionalResp addConditionalMenu(
            @Body WeChatMenuConditionalReq req);

    /**
     * 删除个性化菜单
     *
     * @param req 删除请求
     * @return 基础返回
     */
    @POST("cgi-bin/menu/delconditional")
    WeChatBaseResp delConditionalMenu(
            @Body WeChatMenuDelConditionalReq req);

    /**
     * 测试个性化菜单匹配
     *
     * @param req openid请求
     * @return 匹配到的菜单
     */
    @POST("cgi-bin/menu/trymatch")
    WeChatMenuTryMatchResp tryMatchMenu(
            @Body WeChatMenuTryMatchReq req);

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

    class WeChatMenuButton {
        @JsonProperty("type")
        private String type;
        @JsonProperty("name")
        private String name;
        @JsonProperty("key")
        private String key;
        @JsonProperty("url")
        private String url;
        @JsonProperty("media_id")
        private String mediaId;
        @JsonProperty("appid")
        private String appId;
        @JsonProperty("pagepath")
        private String pagePath;
        @JsonProperty("sub_button")
        private List<WeChatMenuButton> subButton;

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

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }

        public String getAppId() {
            return appId;
        }

        public void setAppId(String appId) {
            this.appId = appId;
        }

        public String getPagePath() {
            return pagePath;
        }

        public void setPagePath(String pagePath) {
            this.pagePath = pagePath;
        }

        public List<WeChatMenuButton> getSubButton() {
            return subButton;
        }

        public void setSubButton(List<WeChatMenuButton> subButton) {
            this.subButton = subButton;
        }
    }

    class WeChatMenuCreateReq {
        @JsonProperty("button")
        private List<WeChatMenuButton> button;

        public List<WeChatMenuButton> getButton() {
            return button;
        }

        public void setButton(List<WeChatMenuButton> button) {
            this.button = button;
        }
    }

    class WeChatMenuGetResp extends WeChatBaseResp {
        @JsonProperty("menu")
        private WeChatMenuCreateReq menu;
        @JsonProperty("conditionalmenu")
        private List<WeChatMenuConditionalItem> conditionalMenu;

        public WeChatMenuCreateReq getMenu() {
            return menu;
        }

        public void setMenu(WeChatMenuCreateReq menu) {
            this.menu = menu;
        }

        public List<WeChatMenuConditionalItem> getConditionalMenu() {
            return conditionalMenu;
        }

        public void setConditionalMenu(List<WeChatMenuConditionalItem> conditionalMenu) {
            this.conditionalMenu = conditionalMenu;
        }
    }

    class WeChatMenuConditionalItem {
        @JsonProperty("button")
        private List<WeChatMenuButton> button;
        @JsonProperty("matchrule")
        private WeChatMenuMatchRule matchRule;
        @JsonProperty("menuid")
        private Long menuId;

        public List<WeChatMenuButton> getButton() {
            return button;
        }

        public void setButton(List<WeChatMenuButton> button) {
            this.button = button;
        }

        public WeChatMenuMatchRule getMatchRule() {
            return matchRule;
        }

        public void setMatchRule(WeChatMenuMatchRule matchRule) {
            this.matchRule = matchRule;
        }

        public Long getMenuId() {
            return menuId;
        }

        public void setMenuId(Long menuId) {
            this.menuId = menuId;
        }
    }

    class WeChatMenuMatchRule {
        @JsonProperty("tag_id")
        private String tagId;
        @JsonProperty("sex")
        private String sex;
        @JsonProperty("country")
        private String country;
        @JsonProperty("province")
        private String province;
        @JsonProperty("city")
        private String city;
        @JsonProperty("client_platform_type")
        private String clientPlatformType;
        @JsonProperty("language")
        private String language;

        public String getTagId() {
            return tagId;
        }

        public void setTagId(String tagId) {
            this.tagId = tagId;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getClientPlatformType() {
            return clientPlatformType;
        }

        public void setClientPlatformType(String clientPlatformType) {
            this.clientPlatformType = clientPlatformType;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }
    }

    class WeChatMenuConditionalReq {
        @JsonProperty("button")
        private List<WeChatMenuButton> button;
        @JsonProperty("matchrule")
        private WeChatMenuMatchRule matchRule;

        public List<WeChatMenuButton> getButton() {
            return button;
        }

        public void setButton(List<WeChatMenuButton> button) {
            this.button = button;
        }

        public WeChatMenuMatchRule getMatchRule() {
            return matchRule;
        }

        public void setMatchRule(WeChatMenuMatchRule matchRule) {
            this.matchRule = matchRule;
        }
    }

    class WeChatMenuAddConditionalResp extends WeChatBaseResp {
        @JsonProperty("menuid")
        private Long menuId;

        public Long getMenuId() {
            return menuId;
        }

        public void setMenuId(Long menuId) {
            this.menuId = menuId;
        }
    }

    class WeChatMenuDelConditionalReq {
        @JsonProperty("menuid")
        private Long menuId;

        public Long getMenuId() {
            return menuId;
        }

        public void setMenuId(Long menuId) {
            this.menuId = menuId;
        }
    }

    class WeChatMenuTryMatchReq {
        @JsonProperty("openid")
        private String openId;

        public String getOpenId() {
            return openId;
        }

        public void setOpenId(String openId) {
            this.openId = openId;
        }
    }

    class WeChatMenuTryMatchResp extends WeChatBaseResp {
        @JsonProperty("button")
        private List<WeChatMenuButton> button;

        public List<WeChatMenuButton> getButton() {
            return button;
        }

        public void setButton(List<WeChatMenuButton> button) {
            this.button = button;
        }
    }
}