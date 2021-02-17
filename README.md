# 📌 Stock Dashboard Prototype
- spring을 이용한 주식 대쉬보드 프로토타입

## ✔️ 기술 스택 및 개발 환경
![eclipse](https://img.shields.io/badge/eclipse-4.8.0_Photon-yellow)
![openJDK](https://img.shields.io/badge/open--jdk-8-orange)
![spring](https://img.shields.io/badge/spring-5.0.2-brightgreen)
![tomcat](https://img.shields.io/badge/tomcat-8.5.27-yellow)
![tomcat-jdbc](https://img.shields.io/badge/tomcat--jdbc-8.5.27-yellow)
![maven](https://img.shields.io/badge/maven-3.5.2-green)
![servlet](https://img.shields.io/badge/servlet-3.1.0-red)
![hibernate](https://img.shields.io/badge/hibernate-5.4.2-blue)
![mysql](https://img.shields.io/badge/mysql-8.0.17-blue)
![slf4j](https://img.shields.io/badge/slf4j-1.7.25-green)
![jackson](https://img.shields.io/badge/jackson-2.9.4-orange)
- 한국거래소 주식 API

## ✔️ 구현 기능
1. 특정 주식 정보 검색 및 지표 뷰 (종목이름, 기간 입력)
  - 주식 그래프 및 테이블 띄우기

## ✔️ 개발 계획
1. 주식(stock) 정보에 대한 class 
  - stock.java : 주식 기본 정보에 대한 정보

2. dashboard 뷰 개발
  - 원하는 주식 종목/ 기간을 받을 수 있는 input창과 submit 버튼
  - submit한 결과에 대한 요청을 Model로부터 받아서 view ( 표,그래프 형식으로 )
  
3. Controller 개발
  - 거래소 api로부터 XML 형식으로 주식 데이터 get/post

## ✔️ 추후 개발 계획
- 간단한 기능 구현 후 프레임워크 변경
- 실시간 그래프 변화
- DB에 주식 정보를 어떻게 검색/저장할 것인지
- 커뮤니티 기능
