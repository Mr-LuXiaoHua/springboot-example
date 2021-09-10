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
* 整合springboot session



### 项目包结构
```shell script
springboot-example
└─src
    ├─main
    │  ├─java
    │  │  └─com
    │  │      ├─dohko
    │  │        └─example
    │  │            ├─domain                   --业务领域
    │  │            │  ├─aggregation           --聚合服务, 聚合多个子模块的功能
    │  │            │  │  └─controller
    │  │            │  └─system                --子模块-系统管理
    │  │            │      ├─controller          --控制层
    │  │            │      ├─event               --事件
    │  │            │      │  ├─publish            --事件发布
    │  │            │      │  └─subscribe          --事件订阅          
    │  │            │      ├─exception           --子模块异常
    │  │            │      ├─manager             --子模块通用业务逻辑
    │  │            │      ├─model               --领域模型
    │  │            │      │  ├─bo                 --子模块业务对象
    │  │            │      │  ├─constant           --子模块常量
    │  │            │      │  ├─dto                --子模块数据传输对象
    │  │            │      │  └─enum               --子模块枚举
    │  │            │      ├─repository          --仓储层        
    │  │            │      │  ├─entity             --实体，和数据库表字段一一对应 
    │  │            │      │  └─mapper             --Mapper接口
    │  │            │      └─service             --服务层
    │  │            │          └─impl
    │  │            └─infrastructure           --基础层
    │  │                ├─common                        
    │  │                │  ├─aop                 --全局aop
    │  │                │  ├─exception           --全局异常
    │  │                │  ├─handler             --全局处理器
    │  │                │  ├─interceptor         --全局拦截器
    │  │                │  └─model               --全局领域模型
    │  │                │      ├─constant          --全局常量
    │  │                │      ├─entity            
    │  │                │      ├─enums             --全局枚举
    │  │                │      └─vo                --全局值对象
    │  │                ├─config                 --全局配置
    │  │                └─utils                  --全局工具类
    │  │      
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
                  └─example
               
```

### 使用说明

1. 创建test数据库，执行resources\static\sql下的建表语句

```sql
DROP TABLE IF EXISTS `t_user_info`;
CREATE TABLE `t_user_info` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `salt` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '盐值',
  `state` tinyint(2) NOT NULL DEFAULT '1' COMMENT '状态：0-停用；1-正常',
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '昵称',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否已删除：0-否；1-是',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户信息';
```
2. 配置redis

3. 默认端口9090，可在配置文件自行修改，启动应用

4. 访问接口
```shell script
1) 注册用户接口
 
http://localhost:9090/register

请求体
{
	"username":"yekai",
	"password":"e10adc3949ba59abbe56e057f20f883e",
	"nickname":"叶开"
}


2) 用户登录接口
 
http://localhost:9090/login

请求体
{
	"username":"yekai",
	"password":"e10adc3949ba59abbe56e057f20f883e"
}

3) 用户信息分页查询接口

http://localhost:9090/user-info/page-query

请求体
{
	"current":1,
	"size":10
}


```
