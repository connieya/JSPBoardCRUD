# JSP로 간단한 게시판 CRUD 구현

## 회원가입 페이지
![회원가입 페이지](https://user-images.githubusercontent.com/66653324/99899770-4157a180-2cef-11eb-958c-7cf70404c3fc.PNG)

회원가입 페이지를 보여주는 join.jsp

![join.jsp코드](./image/join.jsp코드.PNG)


회원가입 버튼을 누르면 joinAction.jsp 파일로 이동한다.




-------------------

### joinAction.jsp 수정 전

![수정전](./image/joinAction.PNG)





```
 request.getParameter() 을 사용하여 값을 들고온다.
```

들고 온 값을 UserDAO 안에 있는 join 메서드에 넣는다.

-----------------


### joinAction.jsp 수정 후
![수정후](./image/joinAction수정.PNG)

request.getParameter 대신

액션 태그 <jsp:useBean> 과 <jsp:setProperty> 를 사용하였다. 

```
<jsp:useBean id="user" class="user.User" scope="page"/>
id는 자바빈즈를 식별하기 위한 값으로 변수 명은 상관 없다
class에 user 패키지에 User클래스를 사용


```
#### userdao.join 매개변수에는 user 객체를 넣어 전달
-----------------------------
### UserDAO.java 
![userdao](./image/USerDaoJoin수정전.PNG)

매개변수안에 데이터의 수 만큼 넣어줘야했는데,

<jsp:setProperty> 를 사용하여 매개변수 안에 user 객체를 넣음

```
                user 객체로 받음
public void join(User user) {
		
		String sql = "insert into user(id, password, name, email,gender) values(?,?,?,?,?)";
		
        user 객체 get함수로 값을 넣어줌
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getGender());
			
			int n = pstmt.executeUpdate();
			if(n==1) {
			System.out.println("회원가입 성공");
			}else
				System.out.println("회원가입 실패임");
		}catch(Exception e) {
			System.out.println("회원가입 실패");
			e.printStackTrace();
		}finally {
			try {
			if(pstmt !=null) pstmt.close();
			if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
}
```

그리고 회원가입 폼 안에있는 
input 태그 안에 name과 , User 클래스 변수명이 같기 때문에

```
<jsp:setProperty property="*" name="user"/>
```
사용 가능


## 로그인 , 세션 설정하기

![세션](./image/로그인화면.PNG)


로그인을 하면 세션을 설정해준다.

![세션코드](./image/loginSession.PNG)

```
session.setAttribute(세션이름 , 세션 값);

session.getAttribute(세션이름);
```
