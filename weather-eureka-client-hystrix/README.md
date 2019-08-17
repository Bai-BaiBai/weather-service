# Hystrix断路器使用示例

在 weather-eureka-client 的基础上增加了 Hystrix的使用示例

依赖有：
- spring-cloud-starter-netflix-eureka-client
- spring-cloud-starter-openfeign:1.4.0.RELEASE
- spring-cloud-starter-netflix-hystrix:1.4.0.RELEASE

使用：启动类添加 @EnableCircuitBreaker 注解，在调用第三方接口有可能调用失败的地方 添加 @HystrixCommand(fallbackMethod="fallbackMethod") 并声明出一个方法名为fallbackMethod，它在断路器生效的时候调用

Feign内部也集成了Hystrix断路器的实现：
- @FeignClient(name="", fallback=FallBack.class) ，FallBack类实现此注解所在的接口，类中的实现方法即为断路器生效时的默认回调方法
- application.properties中 ： feign.hystrix.enabled=true