# Eureka注册中心服务

依赖有：
- spring-cloud-starter-netflix-eureka-server

使用：
- 启动类添加：@EnableEurekaServer
- 配置文件中：

```
# 指定端口
server.port=8761

# 该示例的主机名
eureka.instance.hostname=localhost

# 在该项目禁用client功能，因为EurekaServer也可以作为一个client
eureka.client.registerWithEureka:false
eureka.client.fetchRegistry:false

# Eureka注册中心地址
eureka.client.serviceUrl.defaultZone:http://${eureka.instance.hostname}:${server.port}/eureka/

```