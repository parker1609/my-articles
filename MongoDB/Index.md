# 인덱스 
관계형 데이터베이스와 인덱스에 대한 특징과 동작 과정은 유사하다.

- 인덱스 설정할 때 Compass를 사용하면 GUI로 편하게 설정가능하다.

```javascript
db.{db_name}.createIndex({ "{element_name}": 1 }
    ,{ name: "{index_name}" })
    ,{ background: false })
```
- 1 : 오름차순, -1: 내림차순
- name 부분은 옵션값
- background 설정 기본 값이 false

## 인덱스 생성 시 background VS foreground
인덱스 생성 시 background로 설정하면, 전체 락이 걸리지 않은 상태이므로 DB가 가능한 상태(서비스 무중단)에서 인덱스를 생성한다. 반면에 foreground는 전체 락이 걸리므로 인덱스 생성이 완료될 때까지 DB 자체를 사용할 수 없다.

- background는 foreground보다 훨씬 느리다.
- foreground 실행 중에 취소가 가능하다.
- background vs foreground 시간 비교 자료
  - <https://medium.com/@KarakasP/time-difference-between-background-and-foreground-index-creation-in-mongodb-b29ca3689fdc>
  - <https://qkqhxla1.tistory.com/998>

실제로 background로 설정해서 생성 쿼리를 실행했을 때, 다음과 같은 에러가 발생했다. (4.0 버전)

```
{
	"ok" : 0,
	"code" : 2,
	"errmsg" : "Invalid field specified for createIndexes command: commitQuorum",
	"operationTime" : Timestamp(1647436232, 1)
}
```

이는 좀 더 찾아보자...


## 인덱스 성능 차이 측정하기

```javascript
db.{db_name}.find().explain("executionStats")
```

## 배열에 인덱스 설정하기
배열 인자에 인덱스를 설정하면, 다중키 인덱스로 설정된다.
- 비다중키 인덱스보다는 느리다.

```javascript
db.{db_name}.createIndex({ "{array_name}.{element_name}": 1 })
```

## TTL 인덱스 설정하기

## 기타

인덱스 가져오기

```javascript
db.{db_name}.getIndexes()
```