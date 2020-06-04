package com.qian.wesmile.api.com.qian.wx.api.analytics;

import com.qian.wesmile.api.APITestBase;
import com.qian.wesmile.api.analytics.UserAnalysisData;
import com.qian.wesmile.model.param.Getweanalysisappiddailyvisittrend;
import com.qian.wesmile.model.param.UserAnalyze;
import com.qian.wesmile.model.result.Getusercumulate;
import com.qian.wesmile.model.result.Getusersummary;
import com.qian.wesmile.model.result.VisitTrend;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserAnalysisDataTest extends APITestBase<UserAnalysisData> {
    private static final Logger log = LoggerFactory.getLogger(UserAnalysisDataTest.class);

    @Test
    public void getusersummary() {
        UserAnalyze userAnalyze = new UserAnalyze();
        userAnalyze.setBegin_date("2014-12-02");
        userAnalyze.setEnd_date("2014-12-07");
        Getusersummary getusersummary = api.getusersummary(userAnalyze);
        result = getusersummary;
    }

    @Test
    public void test() {
        log.info(api.toString());
        log.info("{}", api.hashCode());
    }

    @Test
    public void getusercumulate() {
        UserAnalyze userAnalyze = new UserAnalyze();
        userAnalyze.setBegin_date("2019-11-11");
        userAnalyze.setEnd_date("2019-11-16");
        Getusercumulate getusersummary = api.getusercumulate(userAnalyze);
        result = getusersummary;
    }

    @Test
    public void t() {
        Getweanalysisappiddailyvisittrend getweanalysisappiddailyvisittrend = new Getweanalysisappiddailyvisittrend();
        getweanalysisappiddailyvisittrend.setBegin_date("20200602");
        getweanalysisappiddailyvisittrend.setEnd_date("20200603");
        VisitTrend trend = api.getweanalysisappiddailyvisittrend(getweanalysisappiddailyvisittrend);
    }
}
