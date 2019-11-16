# wx

#### 介绍
用过别人写的一些微信公众号实现的SDK,感觉不是很好用，实现也不算是很优雅，所以就自己写了一套
声明式微信公众号API SDK

#### 软件架构
1基于JDK的动态代理,类似与mybatis mapper接口注解SQL的方式
2实现声明式微信公众号官方文档的SDK实现
3信赖于fastjons和okhttp，暂不支持json解析库和http请求库的可插拨式替换

#### 安装教程
｀｀｀
git clone https://gitee.com/ngitfk/wx.git
cd  ./wx
mvn clean install
｀｀｀
或者
｀｀｀
mvn clean install -DskipTests=true
｀｀｀

#### 使用说明

添加依赖
｀｀｀
<dependency>
    <groupId>com.xlvren</groupId>
    <artifactId>wx</artifactId>
    <version>1.0-SNAPSHOT</version>
 </dependency>
｀｀｀
｀｀｀
//init with your properties
 ApiUtil.init(config.getAppid(), config.getAppsecret());

UserAnalysisData api=ApiUtil.getInstance(UserAnalysisData.class)

//build params and call
UserAnalyze userAnalyze = new UserAnalyze();
userAnalyze.setBegin_date("2014-12-02");
 userAnalyze.setEnd_date("2014-12-07");
 Getusersummary getusersummary = api.getusersummary(userAnalyze);

｀｀｀
核心API中的ApiUtil.getInstance()方法的参数可以是任意的接口的class对象，
根据 [微信开放文档](https://developers.weixin.qq.com/doc/offiaccount/Analytics/User_Analysis_Data_Interface.html)
中接口的说明，自定义接口并使用com.qian.wx.annotation下几个注解声明请示的路径以及参数，已经提供了一API的声明
可以直接使用，欢迎提供其它的接口声明并提交PR,

#### 参与贡献

1.  Fork 本仓库
2.  新建 Feat_xxx 分支
3.  提交代码
4.  新建 Pull Request


#### 码云特技

1.  使用 Readme\_XXX.md 来支持不同的语言，例如 Readme\_en.md, Readme\_zh.md
2.  码云官方博客 [blog.gitee.com](https://blog.gitee.com)
3.  你可以 [https://gitee.com/explore](https://gitee.com/explore) 这个地址来了解码云上的优秀开源项目
4.  [GVP](https://gitee.com/gvp) 全称是码云最有价值开源项目，是码云综合评定出的优秀开源项目
5.  码云官方提供的使用手册 [https://gitee.com/help](https://gitee.com/help)
6.  码云封面人物是一档用来展示码云会员风采的栏目 [https://gitee.com/gitee-stars/](https://gitee.com/gitee-stars/)
