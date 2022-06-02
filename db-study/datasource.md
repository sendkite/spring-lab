## 1. 커넥션 풀

### 커넥션 생성되는 과정

[어플리케이션] -> [DB 드라이버] -> [DB]

1. 어플리케이션 DB Driver Manager 통해서 커넥션 조회
2. Driver Manager는 DB와 TCP/IP 커넥션 연결
3. 연결 되면 ID, PW 기타 정보 DB 전달
4. DB는 ID, PW를 통해 내부 인증, DB 내부 세션 생성
5. DB 커넥션 생성 응답
6. DB Driver는 커넥션 객체를 생성하여 어플리케이션에 반환.


### 커넥션 풀

[어플리케이션] -> [커넥션풀] -> [DB] 

- 어플리케이션 시작 시점에 커넥션을 미리 생성하고 사용한다.(=서비스 이용 속도가 빠르다.)
- 언제든 즉시 SQL DB로 전달할 수 있다. 
- DB 무한정 연결을 방지하여 DB 보호
- 종류
  - commons-dbcp2, tomcat-jdbc pool, Hikari CP(스프링 표준)
- 커넥션 풀에서 커넥션 생성 작업은 별도의 쓰레드에서 동작한다. 어플리케이션 속도에 영향을 주지 않기 위함이다.
- 커넥션 풀의 로그를 확인하기 위해서는 Thread.sleep()을 1초 정도 설정한다. 
- 최대 커넥션 풀 수 설정할 수 있다. 기본 10개  
- 최데 커넥션풀을 초과하면 언제까지 다음 커넥션을 대기할 것인지 설정 가능. 초과하면 타임아웃 exception

## 2.DataSource

커넥션을 획득할 수 있는 방법을 추상화

- javax.sql.DataSource 인터페이스

```java
import java.sql.Connection;
import java.sql.SQLException;

public interface DataSource {
    Connection getConnection() throws SQLException;
}
```
- 한번 dataSource 객체 생성하면 커넥션 생성시 재사용
- 설정은 한 곳에서 관리하는 이점. 설정과 사용을 분리한다.
