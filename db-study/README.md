# database with Spring 

- 데이터베이스 기반 지식
- 데이터 접근 기술 

---

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