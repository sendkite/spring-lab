## 비즈니스 로직의 순수함

서비스계층은 기술 종속 없이 순수 비즈니스 로직만 있어야한다. 
기술의 종속이 있으면 기술 변경, 확장에 제한적이다. 

- 변경을 최소화하고 구현, 기술 변경

## 스프링 트랜잭션

아래 문제점 스프링이 해결 가능

### 문제
- 트랜잭션 문제
  - JDBC 구현 기술 누수
    - DB 접근 계층에 DB 코드 몰았는데, 서비스 침범
  - 트랜잭션 동기화 문제 
    - 트랜젝션을 위해 커넥션을 파라미터로 넘길때 파생하는 복잡도.
- 예외누수 문제
  - JDBC 기술에 종속된 Exception이 서비스 계층 침범.
- JDBC 반복 문제
  - 유사 코드 반복 

### 해결책

1) 트랜잭션 추상화
- 스프링에서 제공하는 추상화 기술 : PlatformTransactionManager 인터페이스를 사용한다.
```text
디비 접근 기술마다 트랜잭션 방법이 다르다.
기술 변경시 모두 고쳐야함 -> 장애 (단일 책임 원칙 위배 - 1개를 변경했는데 다른 곳에서 문제)
```
2) 트랜잭션 동기화
- 리소스 동기화. 트랜잭션 시작부터 끝까지 같은 커넥션을 유지해야한다.
- 쓰레드 로컬 (ThreadLocal)을 사용해서 트랜잭션을 동기화해준다. 
```text

```