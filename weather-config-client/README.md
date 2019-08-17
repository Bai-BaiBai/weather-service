# Config配置中心的client使用示例

依赖有：
- spring-cloud-starter-netflix-eureka-client
- spring-cloud-config-client:1.4.0.RELEASE

该项目需要读取Config配置中心所声明的配置信息

只需要在 application.properties 配置中声明：

```
# 服务注册名
spring.application.name: weather-config-client
# 注册中心地址
eureka.client.serviceUrl.defaultZone: http://localhost:8761/eureka/

# 当前生成环境
spring.cloud.config.profile=dev
# config server的地址
spring.cloud.config.uri=http://localhost:8888/
```

配置中心会自动寻找 weather-config-client-dev.properties 或 weather-config-client-dev.yml 配置类应用。
前提是必须符合 {applicationName}-{profile}的命名规则