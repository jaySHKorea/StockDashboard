# Stock Dashboard
- spring을 이용한 주식 대쉬보드 만들기

## 환경 설정
- DB : MySQL
- Web : spring(java,jsp)
- 한국거래소 주식 API

## 주요 구현 기능
1. 특정 주식 정보 검색 및 지표 뷰 (종목이름, 기간 입력)
  - 주식 그래프
  - 테이블
2. 커뮤니티( 게시판 )

## 개발 계획
1. 주식(stock) 정보에 대한 class 
  - stock.java : 주식 기본 정보에 대한 정보

2. dashboard 뷰 개발
  - 원하는 주식 종목/ 기간을 받을 수 있는 input창과 submit 버튼
  - submit한 결과에 대한 요청을 Model로부터 받아서 view ( 표,그래프 형식으로 ) -> 깔끔하게 표현하는 법 찾기
  
3. Controller 개발
  - 거래소 api로부터 XML 형식으로 주식 데이터 get
  - 해당 데이터를 XML->JSON->MAP 형태로 처리하여 Model에 return -> Map을 Stock 타입 리스트로 바꿀 것
 
----------------------------------------------------------------
4. 커뮤니티 개발 ( 클래스, DB.... 만들어야함 ) 
- 다수의 회원이 글 작성/수정/삭제 가능
- 댓글 / 좋아요 기능

## 추후 개발 계획
- 간단한 기능 구현 후 프레임워크 변경
- 실시간 그래프 변화
- DB에 주식 정보를 어떻게 검색/저장?
