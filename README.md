# Lymall-璃玥商城系统

### **项目的前后端使用了以下技术**

### **前端：微信小程序、ajax**

### **后端：SpringBoot、Mybatis、Redis、MySQL等，并且采用多模块方式开发**

#### **项目功能分为4大模块：首页、分类、购物车、个人中心**

### **项目环境：JDK1.8、macOS、Git、docker、Redis、Mysql8.0、腾讯COS云存储**

## **首页**：

### 1、首页模块： 

### 商品搜索功能、商品轮播广告功能、商品分类功能、优惠券功能、团购专区功能、品牌制造商直供商品功能、周一周四·新品首发功能、人气推荐功能、专题精选功能、更多好物功能；

### 该模块的搜索功能可以按照输入的关键字提示出符合该关键字的商品名称，并且会记录用户所查询的历史关键字；

### 商品分类在首页中只展示L1级分类点击之后会进入到分类商品的查询页面；

### 优惠券当用户点击时会先验证是否已登陆后再验证是否已领取过；

### 2、分类模块：

### **商品搜索功能、商品L1级分类查询、商品L2级分类查询、点击L2级分类会进入分类商品查询页面；**

### 3、购物车模块：

### **商品详情、加入购物车、立即下单；**

### 4、个人中心模块：

### **该模仿分为4个部分**

### **登陆部分：选择登陆方式微信登陆、账号登陆、注册、找回密码等；**

### **我的订单部分：待付款、待发货、待收货、待评价、售后；**

### **核心服务部分：优惠券、商品收藏、浏览足迹、我的拼团、地址管理；**

### **必备工具部分：绑定手机、帮助中心、意见反馈、联系客服、关于我们；**

## **整个项目由以上部分组成**





## 功能开发进度：

### version-0.0.1：项目搭建

### 采用SpringBoot2.3.5、规范项目JDK版本为1.8、设计接口规范前端请求方式为/wx/***、采用多模块分为lymall-core、lymall-db、lymall-vx-api、配置异常参数返回值、配置后端接口返回参数工具类；

### Version-0.0.2：项目引入依赖

### web模块启动器：springBoot-starter-web、分页插件：pagehelper-springboot-starter、Gennerator插件：mybatis-generator-maven-plugin、热部署：spring-boot-devtools、关联提示处理器：spring-boot-configuration-processor、数据校验：spring-boot-starter-validation;
