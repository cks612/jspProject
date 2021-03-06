# jspProject - BlueOcean
-------------------------
## 기획 의도 (블라인드 경매 플랫폼)

>블라인드 경매 플랫폼은 판매상품도 비밀, 호가 금액도 비밀리에 진행되는 신개념 경매 시스템입니다. 
입찰자는 힌트를 통해 경매상품을 유추하여 개인이 원하는 가격을 베팅할 수 있습니다. 이 호가 금액은 서로 비공개이며 경매 마감 후 최고금액을 입력한 입찰자가 입찰하게 됩니다. 
소비자는 최근 유행했던 스타벅스 레디백, 에어 조던 등 돈이 있어도 사기 힘든 희귀 아이템을 합리적인 가격에 구매할 수 있습니다

## Languages
Java, JavaScript, Jsp, Oracle, CSS

## 벤치마킹 사이트
>옥션 중고장터: 대표적인 P2P경매사이트
단점 : 거래가 자유로운 만큼 마감시간이 임박해 초단위로 가격 경쟁을 하거나 판매자가 가격을 조작할 수 있다
보완방법 : 실시간 입찰가를 비공개로 진행하기 때문에 악의적인 가격 경쟁을 막을 수 있다

>위메프 블라인드딜 : 과거 위메프 마케팅 전략 중 하나 비공개 상품을 힌트 이미지만 보고 특가에 선구매할 수 있다

## 벤치마킹 사이트와의 차별화
1. 돈거래가 오가는 블라인드 경매 플랫폼인 만큼 회원가입 한 회원들만 컨텐츠 이용이 가능하게 introPage를 만들었으며, 이메일 인증이 완료되어야 회원가입이 가능하도록 구현

2. 당첨 입찰액이 중복되어 중복 당첨자가 나올 시에는 제일 먼저 당첨 입찰액을 배팅한 회원이 당첨되되록 설정 (betCode)

3. 온라인 경매인 만큼 초 단위로 경매에 참여해 부당하게 이익을 챙기려는 사람들을 방지하기 위해 경매건수 당 경매참여는 총 3번만 가능

4. 당첨된 경매품은 당첨된 회원 이메일 인증을 통해 배송정보 입력 및 가상계좌 발급을 통해 배송이 이뤄지게 구현

## Oracle 테이블 명세서 및 ERD
![table](https://user-images.githubusercontent.com/66737450/93712046-d6bea400-fb8d-11ea-97a4-7ea36893b640.JPG)

![ERD](https://user-images.githubusercontent.com/66737450/93712125-af1c0b80-fb8e-11ea-9811-458c32c739e9.JPG)

## Contents : Admin
![admin](https://user-images.githubusercontent.com/66737450/93712293-eb9c3700-fb8f-11ea-98bd-c46e31056353.JPG)

![adminChart](https://user-images.githubusercontent.com/66737450/93712296-ef2fbe00-fb8f-11ea-89c2-355293c95b2a.JPG)

![adminAuction](https://user-images.githubusercontent.com/66737450/93712297-efc85480-fb8f-11ea-8a14-ca50606de924.JPG)

![adminAuction2](https://user-images.githubusercontent.com/66737450/93712298-efc85480-fb8f-11ea-9125-e6db32c6aedb.JPG)

![adminQNA](https://user-images.githubusercontent.com/66737450/93712299-f060eb00-fb8f-11ea-8226-7f7a3a0ba051.JPG)

## Contents : User
![user](https://user-images.githubusercontent.com/66737450/93712384-88f76b00-fb90-11ea-8fe9-579acaa9bdca.JPG)

![userReg](https://user-images.githubusercontent.com/66737450/93712386-8a289800-fb90-11ea-8a1b-cd6807151d4a.JPG)

![userEmail](https://user-images.githubusercontent.com/66737450/93712387-8ac12e80-fb90-11ea-8b85-3d2f5606ff1c.JPG)

![userEmail2](https://user-images.githubusercontent.com/66737450/93712388-8b59c500-fb90-11ea-812e-76fc20dfb643.JPG)

![userMain](https://user-images.githubusercontent.com/66737450/93712389-8b59c500-fb90-11ea-8ab6-c4c1df16d206.JPG)

![userMain2](https://user-images.githubusercontent.com/66737450/93712390-8bf25b80-fb90-11ea-9185-7f43f052e789.JPG)

![userChat](https://user-images.githubusercontent.com/66737450/93712391-8c8af200-fb90-11ea-9f74-9193ba1773ea.JPG)

![userWinner](https://user-images.githubusercontent.com/66737450/93712392-8c8af200-fb90-11ea-8da6-58537d246233.JPG)

![userQna](https://user-images.githubusercontent.com/66737450/93712394-8d238880-fb90-11ea-9db1-47c7f2160bab.JPG)


