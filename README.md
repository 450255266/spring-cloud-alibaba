##### 软件版本说明
可选版本:
1. SpringBoot 1.5.X.RELEASE,SpringCloud Edgware ,SpringCloud Alibaba 1.5.1.RELEASE
2. SpringBoot 2.0.X.RELEASE,SpringCloud Finchley ,SpringCloud Alibaba 2.0.2.RELEASE
3. SpringBoot 2.1.X.RELEASE,SpringCloud Greenwich ,SpringCloud Alibaba 2.1.2.RELEASE
4. SpringBoot 2.2.X.RELEASE,SpringCloud Hoxton.RELEASE ,SpringCloud Alibaba 2.2.0.RELEASE
5. SpringBoot 2.2.5.RELEASE,SpringCloud Spring Cloud Hoxton.SR3,SpringCloud Alibaba 2.2.1.RELEASE
目前使用:
- SpringBoot  2.2.2.RELEASE
- SpringCloud Hoxton.SR1
- SpringCloud Alibaba 2.1.0.RELEASE
- Nacos 1.1.4 官网下载源码执行:mvn -Prelease-nacos -Dmaven.test.skip=true clean install -U  
- Seata 1.0.0 官方下载即可根据官方进行配置
- Sentinle 1.71 官方下载即可根据官方进行配置
##### 工程说明
- bom 依赖管理
- buscien-service-01 服务注册demo
- buscien-service-02 服务发现RestTemplate进行消费
