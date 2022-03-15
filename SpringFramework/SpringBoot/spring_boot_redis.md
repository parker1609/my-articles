# 스프링 부트에서 Redis 사용하기

## Java Redis Client
- 자바에서 대표적인 레디스 클라이언트는 Jedis와 Lettuce 두 가지가 있다.
- Spring Boot 2.0 버전부터 Lettuce가 기본으로 변경되었다.
  - 2.0 버전 이전에는 Jedis가 기본 클라이언트였지만, 여러 문제로 deprecated 되었다.
  - [Why is Lettuce the default Redis client used in Spring Session Redis?](https://github.com/spring-projects/spring-session/issues/789)

## Spring Boot Redis AutoConfiguration

[spring boot project code - RedisAutoConfiguration](https://github.com/spring-projects/spring-boot/blob/v2.6.4/spring-boot-project/spring-boot-autoconfigure/src/main/java/org/springframework/boot/autoconfigure/data/redis/RedisAutoConfiguration.java)

### single redis

```yaml
spring:
  cache:
    type: redis
  redis:
    host: locahost
    port: 6379
```

- RedisStandaloneConfiguration
- LettuceConnectionFactory


### redis cluster

```yaml
spring:
  redis:
    cluster:
      nodes: localhost:6370,localhost:6371,localhost:6372
      max-redirects: 5 # 설정하지 않으면 기본값 5
```

- RedisClusterConfiguration
  - clusterNodes: 반드시 2개 이상일 필요없이 1개로도 가능 (AWS 엘라스틱 캐시는 엔드포인트가 1개이고, 클러스터 설정인 경우 내부에 여러 레디스가 존재함.)
- LettuceConnectionFactory


[Common Application Properties](https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html)