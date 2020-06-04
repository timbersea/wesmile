package com.qian.wesmile.model.result;

import java.util.List;

public class VisitTrend {

    private List<ListBean> list;

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * ref_date : 20170306-20170312
         * session_cnt : 986780
         * visit_pv : 3251840
         * visit_uv : 189405
         * visit_uv_new : 45592
         * stay_time_session : 54.5346
         * visit_depth : 1.9735
         */

        private String ref_date;
        private int session_cnt;
        private int visit_pv;
        private int visit_uv;
        private int visit_uv_new;
        private double stay_time_session;
        private double visit_depth;

        public String getRef_date() {
            return ref_date;
        }

        public void setRef_date(String ref_date) {
            this.ref_date = ref_date;
        }

        public int getSession_cnt() {
            return session_cnt;
        }

        public void setSession_cnt(int session_cnt) {
            this.session_cnt = session_cnt;
        }

        public int getVisit_pv() {
            return visit_pv;
        }

        public void setVisit_pv(int visit_pv) {
            this.visit_pv = visit_pv;
        }

        public int getVisit_uv() {
            return visit_uv;
        }

        public void setVisit_uv(int visit_uv) {
            this.visit_uv = visit_uv;
        }

        public int getVisit_uv_new() {
            return visit_uv_new;
        }

        public void setVisit_uv_new(int visit_uv_new) {
            this.visit_uv_new = visit_uv_new;
        }

        public double getStay_time_session() {
            return stay_time_session;
        }

        public void setStay_time_session(double stay_time_session) {
            this.stay_time_session = stay_time_session;
        }

        public double getVisit_depth() {
            return visit_depth;
        }

        public void setVisit_depth(double visit_depth) {
            this.visit_depth = visit_depth;
        }
    }
}
