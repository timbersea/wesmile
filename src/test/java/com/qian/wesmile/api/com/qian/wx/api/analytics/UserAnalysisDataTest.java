package com.qian.wesmile.api.com.qian.wx.api.analytics;

import com.qian.wesmile.api.APITestBase;
import com.qian.wesmile.api.analytics.UserAnalysisData;
import com.qian.wesmile.model.param.UserAnalyze;
import com.qian.wesmile.model.result.Getusercumulate;
import com.qian.wesmile.model.result.Getusersummary;
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
