package com.qian.wesmile.api.analytics;

import com.qian.wesmile.annotation.Api;
import com.qian.wesmile.annotation.JsonBody;
import com.qian.wesmile.annotation.RelativePath;
import com.qian.wesmile.model.param.Getweanalysisappiddailyvisittrend;
import com.qian.wesmile.model.param.UserAnalyze;
import com.qian.wesmile.model.result.Getusercumulate;
import com.qian.wesmile.model.result.Getusersummary;
import com.qian.wesmile.model.result.VisitTrend;

@Api
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
     *
     * @param userAnalyze with start date and end date
     * @return {@link  Getusercumulate} with generate id Getusersummary
     */
    @RelativePath("/datacube/getusercumulate")
    Getusercumulate getusercumulate(@JsonBody UserAnalyze userAnalyze);

    /**
     * Obtains the weekly trend from the data of user visits to a Mini Program.
     *
     * @param userAnalyze
     * @return
     */
    @RelativePath("/datacube/getweanalysisappiddailyvisittrend")
    VisitTrend getweanalysisappiddailyvisittrend(@JsonBody Getweanalysisappiddailyvisittrend userAnalyze);
}
