# API网关Zuul服务

作为微服务的统一调用接口，集合了所有微服务提供的API，以达到解耦的目的

依赖有：
- spring-cloud-starter-netflix-eureka-client
- spring-cloud-starter-openfeign:1.4.0.RELEASE
- spring-cloud-starter-netflix-zuul:1.4.0.RELEASE

使用：
- 启动类中添加：@EnableZuulProxy
- 配置类中：

```
spring.application.name: weather-eureka-zuul
eureka.client.serviceUrl.defaultZone: http://localhost:8761/eureka/

# path和service 是一组配置，有多少API就要写多少对
# xxx为API的名称，可自定义
# path设置的值的含义： /xxx/ 开头的所有请求，均会转发到 service-id 对应的服务内处理
# service-id 需要指明该API的在注册中心的名称
zuul.routes.xxx.path=/xxx/**
zuul.routes.xxx.service-id=service注册名称
```

Zuul的客户端调用详见 weather-report-server 服务的 DataClient类