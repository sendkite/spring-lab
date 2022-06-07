# 트랜잭션

한번에 커밋하고 한번에 롤백한다.

## ACID

1) 원자성 Atomicity : 트랜잭션 내에 실행 작업들은 모두 성공하거나 모두 실패해야한다.
2) 일관성 Consistency : 일관성 있는 데이터베이스 상태 유지. 데이터베이스의 무결성 제약 조건을 항상 만족 
3) 격리성 Isolation : 동시에 트래픽이 들어오면, 트랜잭션 격리 수준을 선택
4) 지속성 Durability : 트랜잭션이 성공하면 결과가 항상 기록되어야 한다.(로그) 기록을 보고 복구, 오류해결 할 수 있어야한다.


## 트랜잭션 격리 LEVEL

멀티스레드로 동시에 작업이 들어오면, 트랜잭션을 순서대로 실행해야한다. 그러나 순서대로 실행하면 동시 처리 성능이 매우 나빠진다. 

- ANSI 표준은 트랜잭션 격리수준을 4단계로 나누었다. 
- 단계가 높아질 수록 느려진다.

1) READ UNCOMMITTED (커밋되지 않은 읽기)
2) READ COMMITTED (커밋된 읽기)
   - 기본
3) REPEATABLE READ (반복 가능한 읽기)
4) SERIALIZABLE (직렬화 가능)

## 데이터베이스 세션 

[어플리케이션] -> [커넥션] -> [DB - 세션 생성] 

- 세션 : 트랜잭션 시작, SQL 실행, 트랜잭션 커밋
- 커넥션풀 당 1개의 세션이 생성된다. 

## 자동 커밋
쿼리 하나 마다 자동으로 커밋 
```sql
set autocommit true; //자동 커밋 모드 설정
insert into member(member_id, money) values ('data1',10000); //자동 커밋 
insert into member(member_id, money) values ('data2',10000); //자동 커밋
```

## 수동 커밋 
원하는 범위 수동으로 트랜잭션 반영
```sql
set autocommit false; //수동 커밋 모드 설정 : 트랜잭션 시작
insert into member(member_id, money) values ('data3',10000);
insert into member(member_id, money) values ('data4',10000); 
commit; //수동 커밋 : 트랜잭션 완료
// rollback; // 롤백
```

## 데이터베이스 락 LOCK

세션이 트랜잭션을 시작하고 데이터를 수정하는 동안 커밋, 롤백 전까지 다른 세션이 해당 데이터를 수정할 수 없게 막는다. 
- 락을 획득해야 데이터를 변경할 수 있다. 
- 세션1이 락을 가지고 있으면 세션2는 락을 대기한다. 
- 락 타임 아웃설정을 할 수 있다. 

```sql
SET LOCK_TIMEOUT 60000; // 작성하지 않으면 디비 기본 값 사용
set autocommit false;
update member set money=1000 where member_id = 'memberA';
```

- 락 대기시간 초과하면 타임아웃 에러
- 세션1에서 커밋하는 순간 세션2가 락 획득
- 조회할때도 락을 걸 수 있다. 조회하는 동안 수정 못하도록
```sql

set autocommit false;
select * from member where member_id='memberA' for update;
```





