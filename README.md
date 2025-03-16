# CRUD-docker

# 개발 환경
- Java 23
- Spring Boot 3.4.3
- React 19.0.0
- MYSQL 9.2.0

# 실행 방법
## 백엔드
1. 프로젝트 클론
   1. `git clone` https://github.com/thrkrif/CRUD.git 으로 프로젝트 복사
   2. `cd crud/board`
2. `MYSQL` 실행, `사용자명: root`, `비밀번호: ""`
3. `./gradlew build` 로 빌드
4. `java -jar build/libs/{myproject}.jar` 실행
## 프론트 엔드
1. 프론트엔드 디렉터리로 이동 `cd src/main/frontend`
2. 모듈 설치 `npm ci`
3. 실행 `npm start`
