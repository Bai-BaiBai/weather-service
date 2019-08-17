# 配置中心Server端

依赖有：
- spring-cloud-starter-netflix-eureka-client
- spring-cloud-config-server:1.4.0.RELEASE

在启动类上添加 @EnableConfigServer 注解，并在application.properties中添加配置即可完成Server的注册：
```
spring.application.name: config-server
eureka.client.serviceUrl.defaultZone: http://localhost:8761/eureka/

# 可以指向一个git仓库，该git仓库中存储全部的配置文件
spring.cloud.config.server.git.uri=
# 指定仓库内存放配置文件的具体路径
spring.cloud.config.server.git.search-paths=
```