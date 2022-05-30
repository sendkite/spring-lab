# 데이터베이스

## 핵심

- 데이터베이스 기반 지식
- 데이터 접근 기술 

---

### 초기 설정 H2 DB 설치 

- h2 데이터베이스 설치 
  - runtimeOnly 'com.h2database:h2' 의존성에 맞는 버전 확인해서 설치
  - https://www.h2database.com/html/download-archive.html 
  - 1.4.200 버전 설치 (spring boot 2.6.4 기준)
```shell
cd bin
chmod 755 h2.sh
./h2.sh 
```
- 최초 DB 생성 및 접속 TEST
```text
jdbc:h2:~/test 
```
- home에 test.mv.db 파일 생성된 것을 확인
- 두번째 접속부터는 파일이 아니라 주소로 접근한다. 
```text
jdbc:h2:tcp://localhost/~/test
```

# 데이터 접근 기술 

## 1. JDBC

- 과거 데이터베이스 마다 연결하는 방법이 다 다르고 고통. 이를 추상화해서 통일해서 편의를 제공한 것이 jdbc이다. 
- JDBC는 각 벤더에서 제공하는 구현 라이브러리를 사용한다. (JDBC 드라이버)

### 어플리케이션 서버와 데이터베이스를 연결하는 방법

#### 1.1 JDBC

- JDBC 표준 인터페이스 (Java Database Connectivity)
  - 자바에서 데이터 베이스에 접속할 수 있도록 하는 자바 API
    - Connection : DB 연결 -> java.sql.Connection
    - Statement : SQL 요청 -> java.sql.Statement
    - ResultSet : SQL 요청 응답 -> java.sql.ResultSet
- JDBC 인터페이스는 각 DB 벤더 회사에 맞는 구현 라이브러리로 사용한다. 
  - JDBC 드라이버 
    - org.postgresql.Driver
    - com.mysql.cj.jdbc.Driver
    - org.h2.jdbc.Driver

- 그러나 
  - SQL은 표준화되지 않았다. 각각의 데이터베이스에 맞는 SQL 수정이 필요하다. 
  
#### 1.2 JDBC 최신 기술
- JDBC는 1997년 출시된 오래된 기술이다. 
- 사용 방법이 복잡하다.
- JDBC를 편리하게 사용하게 도와주는 기술이 있다. 
  - SQL Mapper 기술 
    - JDBC Template
    - Mybatis
  - ORM 기술
    - 객체를 관계형 데이터베이스 테이블과 매핑해주는 기술
      - JPA (구현체)
      - Hibernate
      - 이클립스링크


---

#### 2.1 JDBC 기본 동작

1) DB JDBC Driver 설정 
2) JDBC > Driver Manager : 드라이버를 관리, 커넥션 획득 (연결 구현체를 찾아서 DB 읽고 반환.)


#### 2.2 JDBC SQL 조작

1) 커텍션 획득 
2) PreparedStatement 이용해서 sql 작성, SQL 실행
3) Close! Connection, PreparedStatement, ResultSet Close. 

와.. 너무 귀찮아


