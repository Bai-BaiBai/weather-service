# 天气数据API服务

提供两个接口：
 - /weather/cityId/{cityId}
 - /weather/cityName/{cityName}
 
职责：从redis缓存中读取uri中的数据，不存在则抛出异常

依赖有：
- spring-boot-starter-data-redis
- spring-cloud-starter-netflix-eureka-client