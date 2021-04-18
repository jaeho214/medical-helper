# medical-helper
주변 의료 시설을 조회 및 이용할 수 있는 웹 페이지 (추후에 앱으로 제작 예정)


###서비스 소개
현재 위치를 기준으로 하여 응급실 및 의료 시설을 조회할 수 있고  

###구현사항

####**back end**

#####**spring boot(REST API)**
1. Spring Data JPA를 통한 DB 접근 및 관리
2. 주 저장소로 AWS RDS(MySQL) 사용
3. AOP를 통하여 exception이 발생할 때와 request이 들어올 때를 log로 기록
4.  jwt 방식을 사용하여 토큰을 통한 사용자 인증 구현

#####**spring batch**
1. Open API로부터 대용량 DB를  받아와 주 저장소인 MySQL에 저장


####**Front-end**

https://github.com/shin-ga-eun/medical-helper
