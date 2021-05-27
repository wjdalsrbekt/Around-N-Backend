![image](https://user-images.githubusercontent.com/47201943/119803857-ccbe2380-bf1a-11eb-8a8d-f7532ccb07b6.png)

# Around : N (Backend)

##### Frontend
<a href="https://lab.ssafy.com/at8in/finalhappyvue">frontend 깃허브 바로가기</a>

<a href="https://lab.ssafy.com/at8in/finalhappyvue">frontend 프로젝트 바로가기!</a>
<a href ="https://www.youtube.com/watch?v=usJ1UsJBG_M">서비스 소개 영상</a>

- Around:N 은 사용자끼리의 커뮤니티들 형성하여 
소비자의 합리적인 선택을 적극 권장 합니다.
활발한 의견공유를 통해 나만의 SWEET HOME을 만나보세요!

- 기분좋게 매물 보러 가볼까요?
집 보러 가는날, 맑은 날이면 더욱 좋겠지요?
해당 동네 날씨 확인하고 기분 좋게 길찾기 해봐요!

- 내 매물은 과연 N세권?
맥세권이라는 말을 아시나요? 
주택 인근에 맥도날드가 가까운 경우를 뜻하는 말이에요.

- Around:N은 사용자가 선택한 매물이 주변의 약국, 편의점, 문화공간 등 
다양한  N세권에 포함되는지 바로 확인가능하답니다.

## 😁팀
---

##### ️정민규 (팀장)
- BackEnd : 
    - SpringBoot REST Server 구상 및 구축
- DataBase 
    - SCHEMA, TABLE, VIEW 구조 
- FrontEnd : 
    - 게시판, 회원 관련 스타일링
    - 오픈웨더 API 구현 (날씨 정보)
            
##### ️노영주 (팀원)
- FrontEnd : 
    - Vue/Vuex/Quasar 구상 및 구축
    - (매물, 게시글, 댓글, 로그인, 로그아웃)
    - 매물, 메인페이지, 이벤트 스타일링
    - KAKAO Map API 구현 (마커연결 및 디자인)
- BackEnd : 
    - 회원 관련 기능 추가
    
##기술 스택
---
![image](https://user-images.githubusercontent.com/47201943/119803959-e19ab700-bf1a-11eb-82f2-fefcd3d2db4d.png)

    
## 설계
***
### 기능적 /비기능적 요구사항
---
##### 기능적 요구사항
|Req. ID|범주|기능명|기능 설명|우선순위|
| ----- |----|------|---------|--------|
|FR-01|설정|회원 관리|사용자는 회원 가입,회원정보 수정,회원 탈퇴를 할 수 있다.|MIDDLE|
|FR-02|로그인|로그인 관리|사용자는 사이트에 대한 로그인/ 로그아웃을 이용할 수 있다.|LOW|
|FR-03|게시판|게시판 권한|사용자는 게시판 글 및 댓글 작성을 하려면 로그인을 해야한다.|HIGH|
|FR-04|게시판|글 작성|사용자는 글을 작성할 때, 파일업로드 및 글 수정 및 삭제를 할 수 있다.|HIGH|
|FR-05|게시판|댓글 작성|사용자는 게시판 글에 댓글 작성, 삭제를 할 수 있고, 댓글 게시판은 각 Colum별 정렬 기능 제공을 한다.|HIGH|
|FR-06|게시판|매물 검색|사용자는 원하는 동, 아파트이름을 골라 원하느 매물을 검색 할 수 있다.|HIGH|
|FR-07|매물 검색|날씨확인|시스템은 어플리케이션을 통해 현재의 날씨를 Openweather API에서부터 받아온다.|MIDDLE|
|FR-08|매물 검색|지도 기능|시스템은 사용자가 원하는 매물에 대한 위치 정보, 주변 편의시설을 카카오 Map API에서부터 받아온다.|HIGH|

##### 비기능적 요구사항

|Req. ID|범주|명칭|기능 설명|우선순위|
| ----- |----|------|---------|--------|
|NFR-01|운영환경|네트워크|사용자는 모든 기능을 다 이용하기 위해서 3G, LTE 또는 WIFI에 연결이 되어 있어야한다.|HIGH|
|NFR-02|운영환경|사용자 편의성|웹 사이트에 대한 사전 지식이 없어도 쓰기 편해야 한다.|HIGH|
|NFR-03|운영환경|데이터 저장|시스템은 사용자가 입력한 회원정보,게시물 및 댓글을 DB에 저장한다.|HIGH|
|NFR-04|운영환경|데이터 관리|매물 데이터베이스는 공공데이터를 다운받아 저장 한다.|HIGH|
|NFR-05|성능|응답성|검색에 대한 결과를 빠르게 응답해야 한다.|MIDDLE|
|NFR-06|보안|정보저장|API키는 env.local을 작성하여 gitlab등 소스관리 프로그램에서 노출되지 않게 한다.|HIGH|
|NFR-07|윤리|연령|개발자는 전 연령 이용 가능하도록 만든다.|MIDDLE|
|NFR-08|문화|언어|시스템은 한국어를 지원한다.|MIDDLE|


### Usecase Diagram
---
1.1 Around N 
![image](https://user-images.githubusercontent.com/47201943/119804176-127aec00-bf1b-11eb-87b4-505360d40089.png)

1.2 게시물 관리
![image](https://user-images.githubusercontent.com/47201943/119804428-4a822f00-bf1b-11eb-9adc-6e17a1a55d3d.png)

1.3 기본 관리
![image](https://user-images.githubusercontent.com/47201943/119804445-50781000-bf1b-11eb-8326-408174fc37ec.png)

1.4 매물 관리
![image](https://user-images.githubusercontent.com/47201943/119804475-55d55a80-bf1b-11eb-9838-84bddb752f97.png)

### ERD
---
![image](https://user-images.githubusercontent.com/47201943/119804493-5c63d200-bf1b-11eb-96f1-6002e850ce23.png)

### Class Diagram
---
![image](https://user-images.githubusercontent.com/47201943/119804520-61c11c80-bf1b-11eb-925f-9e0f48f61a68.png)
![image](https://user-images.githubusercontent.com/47201943/119804550-684f9400-bf1b-11eb-8b6f-b4ff86066103.png)

### Swagger
![image](https://user-images.githubusercontent.com/47201943/119804573-6e457500-bf1b-11eb-84db-3f1dc25dfd4a.png)
![image](https://user-images.githubusercontent.com/47201943/119804595-730a2900-bf1b-11eb-96a6-58e4f36205cc.png)
![image](https://user-images.githubusercontent.com/47201943/119804624-7ac9cd80-bf1b-11eb-9a8b-bf46a11238e6.png)
![image](https://user-images.githubusercontent.com/47201943/119804638-7ef5eb00-bf1b-11eb-983a-e926cfa0c571.png)


## 기대효과
---
![image](https://user-images.githubusercontent.com/47201943/119804656-84533580-bf1b-11eb-927e-8560f01c144c.png)

### 오류 및 해결 과정 

<a href ="https://lab.ssafy.com/at8in/finalhappyvue/blob/master/READ%EC%98%A4%EB%A5%98.md">오류 해결 모음</a>


