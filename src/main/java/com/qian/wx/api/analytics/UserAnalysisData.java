package com.qian.wx.api.analytics;

import com.qian.wx.annotation.JsonBody;
import com.qian.wx.annotation.RelativePath;
import com.qian.wx.model.param.UserAnalyze;
import com.qian.wx.model.result.Getusercumulate;
import com.qian.wx.model.result.Getusersummary;

public interface UserAnalysisData {
    /**
     * Data obtained on user increase or decrease
     * @param userAnalyze with start date and end date
     * @return {@link  Getusersummary} with generate id Getusersummary
     */
    @RelativePath("/datacube/getusersummary")
    Getusersummary getusersummary(@JsonBody UserAnalyze userAnalyze);

    /**
     * Obtain data on the accumulation of users
     * @param userAnalyze with start date and end date
     * @return {@link  Getusercumulate} with generate id Getusersummary
     */
    @RelativePath("/datacube/getusercumulate")
    Getusercumulate getusercumulate(@JsonBody UserAnalyze userAnalyze);
}
