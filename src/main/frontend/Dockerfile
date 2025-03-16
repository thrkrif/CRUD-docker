#FROM ubuntu:latest
#LABEL authors="sanghun"
#
#ENTRYPOINT ["top", "-b"]

## 1단계: React 앱 빌드
## 가져올 이미지를 정의
#FROM node:18 AS build
## 경로 설정하기
#WORKDIR /app
## 현재 디렉토리의 모든 파일을 도커 컨테이너의 워킹 디렉토리에 복사한다.
#COPY . .
##
#RUN npm install
#RUN npm run build
#
## 2단계: nginx로 정적 파일 서빙
#FROM nginx:alpine
## nginx 설정 파일 복사
#COPY ../../../nginx.conf /etc/nginx/nginx.conf
#
#COPY --from=build /app/build /usr/share/nginx/html
#
## 포트 80으로 서비스
#EXPOSE 80
#CMD ["nginx", "-g", "daemon off;"]

# React 애플리케이션 빌드 단계
FROM node:16 AS build

WORKDIR /app
COPY package.json package-lock.json ./
RUN npm install
COPY . ./
RUN npm run build

# Nginx 컨테이너로 빌드된 파일을 복사하는 단계
FROM nginx:alpine
COPY --from=build /app/build /usr/share/nginx/html

# Nginx 설정 파일 복사
COPY ./nginx.conf /etc/nginx/nginx.conf

EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]