# Dr.plant_application

#### **2020.1-2020.2**  | **딥러닝을 이용하여 병든 식물 진단기 어플리케이션 개발, 관리자 페이지 개발**

### ****\[인턴 경험담\]****

저는 미국 캘리포니아PeopleSpace스타트업 프로젝트팀에서2달간 개발을 하였습니다.저에게 요청된 개발 내용은 비싼 식물이 병이 들었을 때,플랜트 닥터 앱을 키고 휴대폰 카메라로 병든 부분을 찍으면 이 식물을 살리는 방법을 알려주는 프로그램을 개발 하는 것 이였습니다.저는 비싼 식물의 병든 사진의 데이터를 얻기가 너무 어려웠고,웹Crawling을 통해 얻은 일반 식물의 병든 사진을 이용해서 트랜스퍼러닝을 한 모델을 만들어 이 문제를 해결 하였습니다.또 저는 안드로이드 스튜디오 앱 개발 경험이 있었기 때문에 사진을 서버에 보내고,서버에서AI모델에서 결과값을 받아 띄워주는 애플리케이션 개발자 역할을 맡았습니다.

### ****\[팀 Logo\]****

[##_Image|kage@cHX8Oc/btq4DivxxDq/1m1IbQLMh91GxWASTyBik0/img.png|alignLeft|data-origin-width="658" data-origin-height="572" width="238" height="NaN" data-ke-mobilestyle="widthContent"|||_##]

### ****\[설계 및 구현 경험\] ****

****1) 다양한 툴 경험****

[##_Image|kage@bWBIHS/btq4DhwB7BC/LR4CUcQps9sNp3HUKSPIfK/img.png|alignLeft|data-filename="스크린샷 2021-05-11 오전 12.07.17.png" data-origin-width="2006" data-origin-height="962" width="595" data-ke-mobilestyle="widthContent"|||_##]

****2) 전체 시스템 설계****

[##_Image|kage@cQMAew/btq4z19oNOs/QhQtQkZIJeMy1K0tZoxIwk/img.png|alignLeft|data-filename="스크린샷 2021-05-11 오전 12.06.55.png" data-origin-width="1872" data-origin-height="918" width="607" height="NaN" data-ke-mobilestyle="widthContent"|||_##]

앱에서 사용자가 휴대폰 카메라로 병든 식물 찍음 - 서버로 사진 전송 되고, 머신러닝 결과 반환, 데이터 베이스에 저장

[##_Image|kage@bRnCFS/btq4Di98nUB/4VWoYCJfkwt9kSY0NaTUY1/img.png|alignLeft|data-filename="스크린샷 2021-05-11 오전 12.07.07.png" data-origin-width="1868" data-origin-height="856" width="626" height="NaN" data-ke-mobilestyle="widthContent"|||_##]

**데이터 베이스에서 추출해서 관리자 페이지에 사용 현황 보여주기**

### ****\[Challenge\]****

******1) 머신러닝 데이터 부족 : 비싼 식물이 병든 사진을 충분히 얻기 어려웠다. ******

******\--> 오버피팅 문제 발생******

**\[해결\] 비싸지 않은 일반 식물들의 병든 데이터로 transfer learning 을 진행하는 방식으로 모델 개선**
