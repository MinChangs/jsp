# jsp
## url 테스트 (webapp 폴더 접근 url 확인)
#### WEB-INF 외부에서 접근이 안됨
#### localhsot/jsp/img/brown.png (O)
#### localhsot/jsp/WEB-INF/brown.png (X) <br><br><br><br><br><br>

##  jsp : html코드에 java 코드를 삽입하는 형태
####  <%! %> : 선언부
####  <% %> : 스크립틀릿(자바 로직 작성영역)
####  <%=%> 표현식(값표현)
####  <%-- --%> jsp주석 <br>


## request 객체 정보 확인
### request 정보(getContextPath, getRequestURI)
### request header 정보(사용자 환경 os, web browser)

## jsp파일 parameter받기
### request.getParameter("rangersName") : <%=request.getParameter("rangersName") %>

## 응답위임
### redirect 
####	- response.sendRedirect("path")
####	- 요청이 두번 발생
####	- 최초요청과 두번째 요청은 다르기때문에 파라미터를 공유할수없다
####	- 주소줄에는 redirect된 주소가 표시된다 
### request dispatch
####	- request.getRequestDispatcher("path").foward(request,response)
####	- 요청이 한번 발생
####	- 주소줄에는 최초 요청한 주소가 표시된다
####	- 서버내에서 위임이 이루어지기 때문에 request, response 객체가 공유된다
####  - 요청파라미터를 공유할 수 있다.
