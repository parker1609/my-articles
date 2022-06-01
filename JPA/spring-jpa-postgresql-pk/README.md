# Spring Boot + Spring Data JPA + PostgreSQL 환경에서 엔티티 기본키 전략

## 개발환경

## Docker로 PostgreSQL 설정하기

```shell
docker pull postgres

docker images

# postgres 이미지가 여러 개인 경우, Image ID로 사용, id: postgres / pw: {your_password}
docker run -d -p 5432:5432 -e POSTGRES_PASSWORD="{your_password}" --name PostgreSQL01 postgres

docker ps -a

sudo docker exec --user="root" -it PostgreSQL01 "bash"

psql -U postgres
```

- `docker run` 까지만 하고, DBeaver와 같은 DB GUI툴 사용 권장.