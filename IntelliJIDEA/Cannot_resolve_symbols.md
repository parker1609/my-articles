# Cannot resolve symbols 에러 해결
Gradle 사용 기준

## 1. Gradle 재빌드
gradle clean -> build

## 2. IntelliJ IDEA cache 삭제
상단 메뉴 > File -> Invalidate Caches...

![image](https://user-images.githubusercontent.com/34755287/158501755-97b0cb69-2870-4037-8c34-46b4d3abd098.png)

- 해결했던 상황의 체크 사항
  - [X] Clear file system cache and Local History
  - [X] Clear VCS Log caches and indexes (기본값)
  - [X] Clear downloaded shared indexes (기본값)
  - [O] Ask before downloading new shared indexes

[Invalidate caches](https://www.jetbrains.com/help/idea/2021.2/invalidate-caches.html)

1번으로 안되었을 때, 2번 방법으로 해서 해결되었음.