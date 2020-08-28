##### 方法一
通过官方直接下载发布版本:https://github.com/alibaba/nacos/releases/download/1.1.0/nacos-server-1.1.0.tar.gz解压即可运行
Linux:
```shell script
#启动命令(standalone代表着单机模式运行，非集群模式)
sh startup.sh -m standalone
```
Windows:
```shell script
cmd startup.cmd
```
`nacos服务默认端口是8848 浏览器输入 http://127.0.0.1:8848/nacos`
##### 方法二
通过源码方式打包安装:git clone https://github.com/alibaba/nacos.git
加速下载:git clone https://gitee.com/mirrors/Nacos.git
```shell script
#切换到1.1.0标签中
git checkout 1.1.0
#执行命令编译打包
mvn -Prelease-nacos -Dmaven.test.skip=true clean install -U  
```

##### Nacos 原生Api
- 服务注册
```shell script
curl -X PUT 'http://127.0.0.1:8848/nacos/v1/ns/instance?serviceName=nacos.naming.serviceName&ip=20.18.7.10&port=8080'
```
- 服务发现
```shell script
curl -X GET 'http://127.0.0.1:8848/nacos/v1/ns/instances?serviceName=nacos.naming.serviceName'
```