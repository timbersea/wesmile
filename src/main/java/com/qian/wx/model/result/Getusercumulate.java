package com.qian.wx.model.result;

import java.util.List;

public class Getusercumulate {


    private List<ListBean> list;

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * ref_date : 2014-12-07
         * cumulate_user : 1217056
         */

        private String ref_date;
        private int cumulate_user;

        public String getRef_date() {
            return ref_date;
        }

        public void setRef_date(String ref_date) {
            this.ref_date = ref_date;
        }

        public int getCumulate_user() {
            return cumulate_user;
        }

        public void setCumulate_user(int cumulate_user) {
            this.cumulate_user = cumulate_user;
        }
    }
}
