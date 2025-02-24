#  wesmile

#### 介绍
用过别人写的一些微信公众号实现的SDK,感觉不是很好用，繁琐不说,实现也不算是很优雅，
本着减轻使用者的负担，所以就自己写了一套声明式微信公众号API SDK，
调用方需要关注的点只有语法路径，参数，返回结果，简洁明了，易扩展
再造了一个retrofit，在我写这个项目之前不知道有retrofit这个库，写完后才发现retrofit
当然retrofit写得要比我好，但这个库作用动态代理的运用，还是可以学习了解一下的

#### 软件架构
1基于JDK的动态代理,类似与mybatis mapper接口注解SQL的方式
2实现声明式微信公众号,小程序官方文档的SDK实现
3信赖于fastjons和okhttp，支持json解析库和http请求库的可插拨式替换

#### 安装教程
```
git clone https://gitee.com/ngitfk/wesmile.git
cd  ./wesmile
mvn clean install
```
或者
```
mvn clean install -DskipTests=true
```
#### 使用说明
添加依赖
```
<dependency>
    <groupId>com.qian</groupId>
    <artifactId>wesmile</artifactId>
    <version>1.0-SNAPSHOT</version>
 </dependency>
```
#### 示例
```
//init with your properties
 WeSmileUtil.init(config.getAppid(), config.getAppsecret());

UserAnalysisData api=WeSmileUtil.getInstance(UserAnalysisData.class)

//build params and invoke
UserAnalyze userAnalyze = new UserAnalyze();
userAnalyze.setBegin_date("2014-12-02");
 userAnalyze.setEnd_date("2014-12-07");
 Getusersummary getusersummary = api.getusersummary(userAnalyze);
 
or 
//
WeSmile ws =new WeSmile();
weSmile.setAppid(appid);
weSmile.setAppSecret(appSecret);

customer http request sender
we.setHttpRequester(...);
UserAnalysisData api=ws.getInstance(UserAnalysisData.class)
```

#### 如何扩展本sdk中没有实现微信公众号/小程序服务器端接口？
```
//定义接口方法参考com.qian.wesmile.api包中的接口写法
@RelativePath("/datacube/getweanalysisappiddailyvisittrend")//根据官方文档填写地址
List<Map> yourMethod(@JsonBody Params Params);
//定义接口返回的数据实体类，字段名采用下划线风格以减少不必要的麻烦，接口方法中的参数即是API中的参数
YourSelfInterface api=WeSmileUtil.getInstance(YourSelfInterface.class);
api.yourMethod();
```
核心API中的WeSmileUtil.getInstance()或者WeSmile.getInstance()方法的参数可以是任意的接口的class对象，
根据 [微信开放文档](https://developers.weixin.qq.com/doc/offiaccount/Analytics/User_Analysis_Data_Interface.html)
中接口的说明，自定义接口并使用com.qian.wx.annotation下几个注解声明请示的路径以及参数，已经提供了一API的声明
可以直接使用，欢迎提供其它的接口声明并提交PR,

#### 参与贡献

1.  Fork 本仓库
2.  新建 Feat_xxx 分支
3.  提交代码
4.  新建 Pull Request
#### 反馈
ngitfk@qq.com