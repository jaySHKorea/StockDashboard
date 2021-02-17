# Stock Dashboard Prototype
- spring을 이용한 주식 대쉬보드 프로토타입

## 환경 설정
- DB : MySQL
- Web : spring(java,jsp)
- 한국거래소 주식 API

## 구현 기능
1. 특정 주식 정보 검색 및 지표 뷰 (종목이름, 기간 입력)
  - 주식 그래프
  - 테이블

## 개발 계획
1. 주식(stock) 정보에 대한 class 
  - stock.java : 주식 기본 정보에 대한 정보

2. dashboard 뷰 개발
  - 원하는 주식 종목/ 기간을 받을 수 있는 input창과 submit 버튼
  - submit한 결과에 대한 요청을 Model로부터 받아서 view ( 표,그래프 형식으로 ) -> 깔끔하게 표현하는 법 찾기
  
3. Controller 개발
  - 거래소 api로부터 XML 형식으로 주식 데이터 get/post

## 추후 개발 계획
- 간단한 기능 구현 후 프레임워크 변경
- 실시간 그래프 변화
- DB에 주식 정보를 어떻게 검색/저장할 것인지
- 커뮤니티 기능
