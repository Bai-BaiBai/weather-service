# 天气预报微服务

- micro-weather-basic：天气预报单体项目，未拆分之前的项目

拆分之后：
- weather-city-server：城市列表API服务，提供城市列表
- weather-collection-server：天气数据收集服务，消费城市列表服务，调用第三方接口定时获取所有城市的天气数据并缓存到Redis中
- weather-data-server：天气数据API服务，提供指定城市的天气数据，从Redis中读取
- weather-report-server：天气预报服务：UI界面显示天气预报，消费城市列表服务和天气数据API服务

此外还有配套的Spring Cloud微服务：
- weather-eureka-server：Eureka服务端，用于微服务之间的注册与发现，各个微服务即Eureka的client
- weather-eureka-client-zuul：API网关-Zuul，它也作为一个Eureka Client，注册到注册中心后，供其它微服务调用。该项目中weather-report-server使用到该API网关
- weather-config-server：配置中心，此项目中没有实际应用，只是作为一个示例
- weather-config-client：从配置中心中读取统一配置的使用示例
- weather-eureka-client：Eureka客户端的使用示例
- weather-eureka-client-hystrix：Hystrix的使用示例