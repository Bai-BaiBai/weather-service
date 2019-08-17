# 天气预报单体项目

职责有：
- 从XML中读取城市列表，提供给天气数据采集和前端页面选择
- 通过定时任务，将城市列表中的城市天气缓存到Redis中，以天气数据的URI作为Key
- 读取城市天气数据时，从Redis中读取，如果Redis中不存在，则调用第三方接口来获取数据
- 前端页面访问 "/report/cityId/{cityId}"，返回对应的城市天气数据 和 可供选择的城市列表
- 访问 "/weather/cityId/{cityId}" 和 "/weather/cityName/{cityName}" 之间返回Json数据

将该服务拆分成以下四个服务：
- weather-city-server：城市列表API服务，提供城市列表
- weather-collection-server：天气数据收集服务，消费城市列表服务，调用第三方接口定时获取所有城市的天气数据并缓存到Redis中
- weather-data-server：天气数据API服务，提供指定城市的天气数据，从Redis中读取
- weather-report-server：天气预报服务：UI界面显示天气预报，消费城市列表服务和天气数据API服务
