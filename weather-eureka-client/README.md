# Eureka-Client的使用示例

内部还有服务消费者Feign和API网关Zuul的使用示例：

依赖有：
- spring-cloud-starter-netflix-eureka-client
- spring-cloud-starter-openfeign:1.4.0.RELEASE
- spring-cloud-starter-netflix-zuul:1.4.0.RELEASE

Eureka-Client：只需要在启动类中添加 @EnableDiscoveryClient 并在配置类中声明 该服务的注册名称 和 Eureka-Server的地址即可

Feign：启动类中添加 @EnableFeignClients，并声明接口 添加@FeignClient("service-name") 指明服务的地址, 方法上添加@GetMapping("/cities") 指明服务的具体位置

Zuul：启动类中添加 @EnableZuulProxy注解，其余步骤和Feign相同