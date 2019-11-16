package com.qian.wesmile.model.param;

public class UserTag {


    /**
     * tag : {"id":134,"name":"广东"}
     */

    private TagBean tag;

    public TagBean getTag() {
        return tag;
    }

    public void setTag(TagBean tag) {
        this.tag = tag;
    }

    public static class TagBean {
        /**
         * id : 134
         * name : 广东
         */

        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
