<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>CheckRegistration</title>
</head>
<body>

<h1>登録確認画面</h1>
<form action="/SE18G2/checkAccountRegistration" method="post"enctype="multipart/form-data">
<!-- headerを入れます -->>
<!-- <input type="file" name="picturepath" size="30"/><br>
プロフィール画像<br> -->
<p>
内定情報<input type="text" name="jobOffer" value= <%=request.getAttribute("jobOffer") %>>
</p>
<p>
ニックネーム※<input type="text" name="nickname" value= <%=request.getAttribute("nickname") %>><br>
</p>
<p>
卒業(yyyymmdd)<input type="text" name="graduate" value= <%=request.getAttribute("graduate") %>><br>
</p>
<p>
所属<input type="text" name="department" value= <%=request.getAttribute("department") %>><br>
</p>
<p>
職種<input type="text" name="occupation" value=<%=request.getAttribute("occupation") %>><br>
</p>
<p>
性別<input type="text" name="sex"value=<%=request.getAttribute("sex") %>><br>
</p>
<p>
連絡先<input type="text" name="contact" value= <%=request.getAttribute("contact") %>><br>
</p>
<p>
フリースペース(アピールポイントや興味があること等を書いてください)<br>
<textarea  name="freespace"><%=request.getAttribute("freeSpace") %></textarea><br>
</p>
<p>
価値観<br>
<input type="text" name="value1" value=<%=request.getAttribute("value1") %>><br>
<input type="text" name="value2" value=<%=request.getAttribute("value2") %>><br>
<input type="text" name="value3" value=<%=request.getAttribute("value3") %>><br>
</p>



上記の内容で登録します。よろしいですか？<br>
<p><input type="button" onclick="location.href='/WEB-INF/accountRegistration'"value="いいえ"></p>
<p><input type="submit" value="はい"></p>
</form>
</body>
</html>