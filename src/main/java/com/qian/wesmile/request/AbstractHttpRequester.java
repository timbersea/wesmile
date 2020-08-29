package com.qian.wesmile.request;

import com.qian.wesmile.WeSmile;
import com.qian.wesmile.exception.ApiException;
import com.qian.wesmile.model.result.APIResult;
import com.qian.wesmile.model.result.AccessToken;
import com.qian.wesmile.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wuhuaiqian
 */
public abstract class AbstractHttpRequester {
    private static final Logger log = LoggerFactory.getLogger(AbstractHttpRequester.class);
    private static AccessToken accessToken = new AccessToken();
    private static final String GET_ACCESS_TOKEN_URL_PATTERN = "%s/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";

    public String call(String url, String body) {
        return doRequest(url, body);
    }

    private String doRequest(String url, String body) {
        String urlWithAccessToken = String.format(url, getAccessToken().getAccessToken());
        String result = sendHttpRequest(urlWithAccessToken, body);
        log.debug("url {} \r\n body {}", urlWithAccessToken, body);
        log.debug("result {}", result);
        APIResult apiResult = JsonUtil.deserialize(result, APIResult.class);
        if (apiResult.success()) {
            return result;
        }
        boolean apiAccessTokenInvalid = apiResult.getErrcode() == 42001 || apiResult.getErrcode() == 40001;

        //这个接口返回access token无效，是因为通过/sns/oauth2/，code换取到access token无效，并不能通过刷新token来解决问题
        boolean notSnsOauth2 = !url.contains("/sns/userinfo");
        if (apiAccessTokenInvalid && notSnsOauth2) {
            onAccessTokenExpire();
            return doRequest(url, body);
        }
        else {
            throw new ApiException(result);
        }
    }

    private void onAccessTokenExpire() {
        AbstractHttpRequester.accessToken.setCreateTimestamp(-1);
    }

    private synchronized AccessToken getAccessToken() {
        if (AbstractHttpRequester.accessToken.isExpire()) {
            String url = String.format(GET_ACCESS_TOKEN_URL_PATTERN, WeSmile.domain, WeSmile.appid, WeSmile.appSecret);
            log.info("access token {} expired now do request", AbstractHttpRequester.accessToken);
            log.debug("get new access token url:{}", url);
            String result = sendHttpRequest(url, null);
            log.debug("get new access  response {}", result);
            AccessToken accessToken = JsonUtil.deserialize(result, AccessToken.class);
            if (accessToken.getAccessToken() == null) {
                throw new ApiException(result);
            }
            if (!url.contains("/sns/oauth2/")) {//这个接口的access token和其它接口的不是同一个东西
                AbstractHttpRequester.accessToken = accessToken;
            }
            return accessToken;
        }
        else {
            log.info("use cached access token {}", AbstractHttpRequester.accessToken);
            return AbstractHttpRequester.accessToken;
        }

    }

    /**
     * send http request body data to the url by your self
     * you may use other http client
     *
     * @param url
     * @param body
     * @return the response String result
     */
    public abstract String sendHttpRequest(String url, String body);
}
