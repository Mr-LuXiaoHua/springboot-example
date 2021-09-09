### springboot-example
> 项目模板，新项目可从该模板复制创建

### 项目模板技术栈

|  技术   | 版本  |
|  ----  | ----  |
| Java  | jdk8 |
| SpringBoot  | 2.4.10 |
| MyBatis-Plus  | 3.4.3.2 |



### 项目模板已实现功能
* 连接MySQL数据库，演示增删改查、分页查询功能
* 统一返回对象
* 全局统一异常处理
* 日志打印添加traceId
* controller方法执行耗时打印
* 请求参数Validation
* 多环境变量配置
* 整合了layui


### 项目包结构
```shell script
springboot-example
└─src
    ├─main
    │  ├─java
    │  │  └─com
    │  │      ├─dohko
    │  │      │  └─example
    │  │      │      ├─domain                   --业务领域
    │  │      │      │  ├─aggregation           --聚合服务, 聚合多个子模块的功能
    │  │      │      │  │  └─controller
    │  │      │      │  └─system                --子模块-系统管理
    │  │      │      │      ├─controller          --控制层
    │  │      │      │      ├─event               --事件
    │  │      │      │      │  ├─publish            --事件发布
    │  │      │      │      │  └─subscribe          --事件订阅          
    │  │      │      │      ├─exception             --子模块异常
    │  │      │      │      ├─manager               --子模块通用业务逻辑
    │  │      │      │      ├─model               --领域模型
    │  │      │      │      │  ├─bo                 --子模块业务对象
    │  │      │      │      │  ├─constant           --子模块常量
    │  │      │      │      │  ├─dto                --子模块数据传输对象
    │  │      │      │      │  └─enum               --子模块枚举
    │  │      │      │      ├─repository          --仓储层        
    │  │      │      │      │  ├─entity             --实体，和数据库表字段一一对应 
    │  │      │      │      │  └─mapper             --Mapper接口
    │  │      │      │      └─service             --服务层
    │  │      │      │          └─impl
    │  │      │      └─infrastructure           --基础层
    │  │      │          ├─common                        
    │  │      │          │  ├─aop                 --全局aop
    │  │      │          │  ├─exception           --全局异常
    │  │      │          │  ├─handler             --全局处理器
    │  │      │          │  ├─interceptor         --全局异常
    │  │      │          │  └─model               --全局领域模型
    │  │      │          │      ├─constant          --全局常量
    │  │      │          │      ├─entity            
    │  │      │          │      ├─enums             --全局枚举
    │  │      │          │      └─vo                --全局值对象
    │  │      │          ├─config                 --全局配置
    │  │      │          └─utils                  --全局工具类
    │  │      └─feishu
    │  └─resources
    │      ├─mapper
    │      │  └─system
    │      ├─static                               --静态资源
    │      │  ├─layui
    │      │  │  ├─css
    │      │  │  │  └─modules
    │      │  │  │      ├─laydate
    │      │  │  │      │  └─default
    │      │  │  │      └─layer
    │      │  │  │          └─default
    │      │  │  └─font
    │      │  └─sql
    │      └─templates                           --模板文件
    └─test
        └─java
            └─com
                ├─dohko
                │  └─example
                └─feishu
```


