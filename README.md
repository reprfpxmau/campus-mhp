# 智慧校园心理健康服务平台 (Campus MHP)

> 基于 Spring Boot + Vue.js 的校园心理健康测评、预警管理与在线咨询系统

---

## 项目概述

本系统为高校提供一站式心理健康服务平台，覆盖心理测评、危机预警、在线咨询、档案管理等核心业务。系统采用前后端分离架构，支持管理员、心理咨询师、学生三种角色，实现"一生一档"的全周期心理健康数据管理。

### 核心功能

| 模块 | 功能描述 |
|------|---------|
| 用户管理 | 多角色用户的注册、登录、权限控制、个人信息维护 |
| 心理健康档案 | 学生全周期动态化电子档案，支持创建、维护、查询、统计 |
| 心理测评 | 标准化量表管理、在线测评、自动评分（含正向/反向计分）、风险等级判定 |
| 危机预警 | 规则配置、测评结果自动触发风险评估与预警事件、预警处理闭环 |
| 在线咨询 | 咨询师排班、预约管理、WebSocket 实时聊天、咨询记录归档 |
| 数据统计 | 工作台（概览卡片、待处理预警、今日预约）、数据统计（档案分布、学院咨询量、月度趋势图表） |

---

## 技术栈

### 后端

| 技术 | 版本 | 用途 |
|------|------|------|
| Java | 21 | 编程语言 |
| Spring Boot | 3.3.5 | Web 框架 |
| Spring MVC | - | RESTful 接口 |
| MyBatis | 3.0.3 | 持久层框架（手写 SQL + XML） |
| PageHelper | 2.1.0 | 分页插件 |
| MySQL | 8.0+ | 关系型数据库 |
| Redis | 6.0+ | Token会话、进度暂存、登录防刷、在线状态（RedisTemplate）+ 规则缓存、统计缓存（SpringCache注解） |
| JWT (jjwt) | 0.12.5 | 登录认证 |
| Druid | 1.2.20 | 数据库连接池 |
| Knife4j | 4.5.0 | 接口文档（SpringDoc OpenAPI 3） |
| Lombok | 1.18.36 | 简化 POJO 代码 |
| Fastjson | 2.0.43 | JSON 处理 |
| Apache POI | 5.2.5 | Excel 操作 |

### 前端

| 技术 | 用途 |
|------|------|
| Vue.js 2 | 前端框架 |
| Element UI | UI 组件库 |
| Axios | HTTP 请求 |
| ECharts | 数据可视化图表 |
| Vue Router | 前端路由 |

### 基础设施

| 技术 | 版本 | 用途 |
|------|------|------|
| Nginx | 1.20.2 | 反向代理、静态资源服务 |
| Maven | 3.6+ | 项目构建 |

---

## 项目结构

```
campus-mhp/
├── docs/                           # 项目文档
│   ├── 系统设计说明书.md
│   ├── 项目脚手架说明.md
│   ├── 开发流程.md
│   ├── 测试用例.md
│   └── TODO.md                  # 待实现功能清单
├── sql/                            # 数据库脚本
│   └── mhp_init.sql               # 初始化脚本（29张表 + 预置数据）
├── api-doc/                        # 接口文档
│   ├── 管理端接口文档.html
│   └── 用户端接口文档.html
├── frontend/                       # Vue 前端工程
│   ├── src/
│   │   ├── views/admin/           # 管理端页面
│   │   ├── views/user/            # 用户端页面
│   │   ├── api/index.js           # API 接口定义
│   │   ├── router/index.js        # 路由配置
│   │   └── utils/request.js       # Axios 封装
│   └── dist/                      # 编译产物
├── nginx-1.20.2/                   # Nginx（生产部署可选）
└── campus-mhp/                     # Maven 后端工程
    ├── pom.xml                     # 父工程配置
    ├── mhp-common/                 # 公共模块
    │   └── com/mhp/
    │       ├── result/            # Result、PageResult 统一返回
    │       ├── context/           # BaseContext（ThreadLocal）
    │       ├── properties/        # JwtProperties
    │       ├── exception/         # BusinessException
    │       └── utils/             # JwtUtil
    ├── mhp-pojo/                   # 数据模型模块
    │   └── com/mhp/
    │       ├── entity/            # 数据库实体类
    │       ├── dto/               # 请求参数 DTO
    │       └── vo/                # 视图对象 VO
    └── mhp-server/                 # 业务逻辑模块
        └── com/mhp/
            ├── controller/admin/  # 管理端控制器
            ├── service/           # 业务逻辑层
            ├── mapper/            # 数据访问层
            ├── interceptor/       # JWT 拦截器
            ├── config/            # WebMvc 配置
            └── handler/           # 全局异常处理
```

---

## 数据库设计

系统共 29 张业务表，遵循第三范式（3NF），采用 InnoDB 存储引擎，字符集 utf8mb4。

| 模块 | 表数 | 核心表 |
|------|------|--------|
| 用户认证 | 6 | sys_user, sys_role, sys_login_log |
| 心理健康档案 | 4 | mh_archive, mh_consult_summary |
| 心理测评 | 8 | psy_scale, psy_question, psy_exam_record, psy_report |
| 在线咨询 | 5 | cs_appointment, cs_consult_session, cs_consult_record |
| 危机预警 | 4 | cr_warn_rule, cr_risk_assessment, cr_warn_event, cr_warn_process |
| AI扩展（预留） | 2 | ai_conversation, ai_message |

### 预警机制流程

```
学生提交测评 → 评分引擎 → 生成报告
                           ↓
                   写入 cr_risk_assessment（评估记录）
                           ↓
                   规则匹配 cr_warn_rule
                     ├─ 未触发 → risk_level=0，结束
                     └─ 触发 → 写入规则快照和证据数据
                               → 生成 cr_warn_event（预警事件）
                               → 管理员处理 → cr_warn_process
```

---

## 快速开始

### 环境要求

- JDK 21+
- MySQL 8.0+
- Redis 6.0+
- Maven 3.6+
- Node.js 16+（如需重新编译前端）

### 1. 数据库初始化

```bash
mysql -u root -p
source sql/mhp_init.sql
```

执行后自动创建 `mhp_platform` 数据库、29 张表和预置数据（管理员、咨询师、学生账号、量表、预警规则等）。

### 2. 后端启动

```bash
cd campus-mhp
# 修改 mhp-server/src/main/resources/application.yml 中的数据库密码
mvn clean compile
cd mhp-server
mvn spring-boot:run
```

后端启动后运行在 `http://localhost:8081`。

### 3. 前端启动

**开发模式：**
```bash
cd frontend
npm install
npm run serve
# 访问 http://localhost:8082/#/admin/login
```

**生产模式（Nginx）：**
```bash
cd frontend
npm run build
# 将 dist 目录部署到 Nginx，端口 81
```

### 4. 访问地址

| 端 | 地址 |
|----|------|
| 管理端 | http://localhost:81/#/admin/login（生产）/ http://localhost:8082/#/admin/login（开发） |
| 用户端 | http://localhost:81/#/user/login（生产）/ http://localhost:8082/#/user/login（开发） |
| 接口文档 | http://localhost:8081/doc.html |

### 5. 默认账号

| 角色 | 账号 | 密码 |
|------|------|------|
| 管理员 | admin | 123456 |
| 咨询师 | T001 | 123456 |
| 学生 | S20240001 | 123456 |

---

## 端口分配

| 组件 | 端口 | 说明 |
|------|------|------|
| 后端 Spring Boot | 8081 | API 接口服务 |
| 前端开发服务器 | 8082 | npm run serve |
| 前端生产部署 | 81 | Nginx |
| MySQL | 3306 | 数据库 |
| Redis | 6379 | 缓存 |

---

## API 接口

所有接口需携带 JWT Token：`Authorization: Bearer {token}`

### 管理端接口

| 模块 | 接口 | 方法 | 路径 |
|------|------|------|------|
| 认证 | 登录 | POST | /admin/auth/login |
| 认证 | 退出 | POST | /admin/auth/logout |
| 用户 | 分页查询 | GET | /admin/user/page |
| 用户 | 新增 | POST | /admin/user |
| 用户 | 修改 | PUT | /admin/user |
| 用户 | 启用/禁用 | POST | /admin/user/status/{status}?id= |
| 档案 | 分页查询 | GET | /admin/archive/page |
| 档案 | 详情 | GET | /admin/archive/{id} |
| 量表 | 分页查询 | GET | /admin/scale/page |
| 量表 | 新增 | POST | /admin/scale |
| 量表 | 题目管理 | POST/DELETE | /admin/scale/question |
| 测评 | 记录分页 | GET | /admin/exam/page |
| 测评 | 报告详情 | GET | /admin/exam/report/{recordId} |
| 预约 | 分页查询 | GET | /admin/appointment/page |
| 预约 | 确认/拒绝 | POST | /admin/appointment/confirm/{id} |
| 预警 | 分页查询 | GET | /admin/warn/page |
| 预警 | 评估详情 | GET | /admin/warn/detail/{assessmentId} |
| 预警 | 分发预警 | POST | /admin/warn/distribute |
| 预警 | 处理 | POST | /admin/warn/process |
| 预警规则 | 分页查询 | GET | /admin/warn-rule/page |
| 预警规则 | 新增/修改 | POST/PUT | /admin/warn-rule |
| 统计 | 概览 | GET | /admin/stat/overview | 工作台卡片 |
| 统计 | 档案分布 | GET | /admin/stat/archive-distribution | 数据统计页饼图 |
| 统计 | 学院咨询 | GET | /admin/stat/college-consult | 数据统计页柱状图 |
| 统计 | 月度趋势 | GET | /admin/stat/monthly-exam | 数据统计页折线图 |
| 通用 | 文件上传 | POST | /admin/common/upload |

### 用户端接口

| 模块 | 接口 | 方法 | 路径 |
|------|------|------|------|
| 认证 | 登录 | POST | /user/auth/login |
| 认证 | 注册 | POST | /user/auth/register |
| 档案 | 查看档案 | GET | /user/archive/my |
| 档案 | 补全信息 | PUT | /user/archive/complete |
| 测评 | 可测量表 | GET | /user/scale/available |
| 测评 | 获取题目 | GET | /user/scale/{scaleId}/questions |
| 测评 | 提交答卷 | POST | /user/exam/submit |
| 测评 | 暂存进度 | POST | /user/exam/save-progress |
| 测评 | 测评报告 | GET | /user/exam/report/{recordId} |
| 预约 | 咨询师列表 | GET | /user/counselor/list |
| 预约 | 排班查询 | GET | /user/schedule/{counselorId} |
| 预约 | 创建预约 | POST | /user/appointment |
| 预约 | 我的预约 | GET | /user/appointment/my |
| 预约 | 取消预约 | POST | /user/appointment/cancel/{id} |
| 聊天 | 创建会话 | POST | /user/chat/session |
| 聊天 | 发送消息 | POST | /user/chat/send |
| 聊天 | 历史消息 | GET | /user/chat/messages/{sessionId} |
| 聊天 | 结束会话 | POST | /user/chat/end/{sessionId} |
| 预警 | 我的预警 | GET | /user/warn/my |
| 咨询记录 | 记录列表 | GET | /user/consult/my-records |
| 行为日志 | 上报事件 | POST | /user/behavior/log |

完整的请求参数和返回数据说明见 `api-doc/` 目录下的 HTML 接口文档。

---

## 项目文档

| 文档 | 路径 | 说明 |
|------|------|------|
| 系统设计说明书 | docs/系统设计说明书.md | 总体设计、功能模块设计、数据库设计、UML 图 |
| 项目脚手架说明 | docs/项目脚手架说明.md | 技术栈、项目结构、核心配置、JWT 鉴权流程 |
| 开发流程指南 | docs/开发流程.md | 环境搭建、模块开发顺序、评分引擎实现、调试技巧 |
| 测试用例 | docs/测试用例.md | 97 条测试用例，覆盖 22 个子功能 |
| 管理端接口文档 | api-doc/管理端接口文档.html | 管理端全部 API 详细定义 |
| 用户端接口文档 | api-doc/用户端接口文档.html | 用户端全部 API 详细定义 |

---

## 常见问题

### Q: 密码怎么加密的？

使用 MD5 加密。登录时将输入的密码进行 MD5 哈希后与数据库存储的哈希值比对。

### Q: 如何访问接口文档？

启动后端后访问 `http://localhost:8081/doc.html`（Knife4j），或 `http://localhost:8081/v3/api-docs`（OpenAPI JSON）。

### Q: Token 过期了怎么办？

管理端 Token 有效期 2 小时，用户端 24 小时。过期后重新登录获取新 Token。

### Q: 前端开发模式和生产模式有什么区别？

- **开发模式**：`npm run serve`，端口 8082，自动代理 API 到 8081，支持热更新
- **生产模式**：`npm run build` 后部署到 Nginx（端口 81），Nginx 代理 API 到 8081

### Q: 测评提交后预警是怎么触发的？

测评提交 → 评分引擎计算总分和结果等级 → 写入风险评估记录 → 遍历预警规则进行匹配 → 触发则生成预警事件（含规则快照和证据数据）→ 管理员在预警管理页面查看详情并处理。

### Q: 数据库密码在哪里修改？

`campus-mhp/mhp-server/src/main/resources/application.yml` 中的 `spring.datasource.password` 字段。

---

## 许可证

本项目仅供学习交流使用。

---

**版本**: v1.0.0
**最后更新**: 2026-05-28
