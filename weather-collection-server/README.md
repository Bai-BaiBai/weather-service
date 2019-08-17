# 天气数据采集微服务

不对外提供接口，只通过定时任务调用 城市列表微服务 获取城市列表和调用第三方接口将所有城市的天气缓存到redis中

依赖有：
- httpclient:4.5.3 ：调用第三方接口时使用RestTemplate
- spring-boot-starter-data-redis：将数据存入Redis缓存中
- spring-boot-starter-quartz：定时任务
- spring-cloud-starter-openfeign:1.4.0.RELEASE：使用Feign消费城市列表服务。具体做法是声明一个接口添加@FeignClient注解指定要调用的服务注册名称，在接口中@RequestMapping指定具体调用的服务接口
- spring-cloud-starter-netflix-eureka-client：将该服务注册到Eureka注册中心