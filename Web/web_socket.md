# 웹 소켓
## STOMP
- stomp 라이브러리(AOS/IOS/WEB)
  - 소켓 연결 HTTP 요청 시 user-agent 헤더값이 포함 여부는 라이브러리마다 다르다.
    - 웹 방화벽 설정 시 user-agent 헤더를 포함해야 하는 경우가 많은데, 소켓 관련 요청은 이 헤더를 포함할 수 있는지 살펴봐야 함.
  - 소켓 연결 HTTP 요청 시 커스텀 헤더값은 실제 요청 HTTP 헤더에 포함되지 않고, stomp 라이브러리에서 따로 값으르 포함시켜 서버에게 요청하는 것으로 보인다.
    - Spring 기준 `StompHeaderAccessor` 로 헤더 값을 가져온다.