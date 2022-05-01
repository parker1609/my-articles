# IntelliJ IDEA

## Cannot resolve symbols 에러 해결
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
    - [ ] Ask before downloading new shared indexes

[Invalidate caches](https://www.jetbrains.com/help/idea/2021.2/invalidate-caches.html)

1번으로 안되었을 때, 2번 방법으로 해서 해결되었음.


## Local History로 예전 파일 복구하기
- git으로도 잘못 사용하면 코드를 날릴 수도 있다.
  - commit 하지 않은 채, 다른 커밋으로 hard reset 하는 경우
- IntelliJ IDEA Local History로 예전 파일 복구하기
  - <https://blog.jetbrains.com/ko/2020/03/26/local-history-intellij-save-your-code-ko/>
  - <https://github.com/occidere/TIL/issues/145>