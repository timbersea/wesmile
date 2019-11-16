package com.qian.wx.api.com.qian.wx.api.analytics;

import com.qian.wx.api.APITestBase;
import com.qian.wx.api.analytics.UserAnalysisData;
import com.qian.wx.model.param.UserAnalyze;
import com.qian.wx.model.result.Getusercumulate;
import com.qian.wx.model.result.Getusersummary;
import org.junit.Test;

public class UserAnalysisDataTest extends APITestBase<UserAnalysisData> {

    @Test
    public void getusersummary() {
        UserAnalyze userAnalyze = new UserAnalyze();
        userAnalyze.setBegin_date("2014-12-02");
        userAnalyze.setEnd_date("2014-12-07");
        Getusersummary getusersummary = api.getusersummary(userAnalyze);
        result = getusersummary;
    }

    @Test
    public void getusercumulate() {
        UserAnalyze userAnalyze = new UserAnalyze();
        userAnalyze.setBegin_date("2014-12-02");
        userAnalyze.setEnd_date("2014-12-07");
        Getusercumulate getusersummary = api.getusercumulate(userAnalyze);
        result = getusersummary;
    }
}
