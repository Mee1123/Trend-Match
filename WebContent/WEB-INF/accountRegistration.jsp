<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">

<title>自己分析</title>
</head>
<body>

<form action="/SE18G2/accountRegistration" method="post"enctype="multipart/form-data">
<!-- headerを入れます -->

<h1>アカウント登録(※は必須項目です)</h1>
<input type="file" name="picturepath" size="30"/><br>
プロフィール画像<br>
<p>
<input type="radio" name="jobOffer" value="1">内定あり<br>
<input type="radio" name="jobOffer" value="0"  checked="checked">内定なし<br>
</p>
<p>
ニックネーム※<input type="text" name="nickname"><br>
</p>
<p>
卒業年度<input type="text" name="graduate"><br>
</p>
<p>
所属<input type="text" name="department"><br>
</p>
<p>
職種<select name="occupation">
<option value="1">学部生</option>
<option value="2">大学院生</option>
<option value="3">農林・水産</option>
<option value="4">林業</option>
<option value="5">漁業</option>
<option value="6">鉱業</option>
<option value="7">建設業</option>
<option value="8">製造業</option>
<option value="9">電気・ガス</option>
<option value="10">運輸・通信業</option>
<option value="11">卸売・小売・飲食業</option>
<option value="12">金融・保険業</option>
<option value="13">不動産業</option>
<option value="14">サービス業</option>
<option value="15">その他</option>
</select><br>
</p>
<p>
性別<select name="sex">
<option value="1">男</option>
<option value="2">女</option>
<option value="0">選択しない</option>
</select><br>
</p>
<p>
連絡先<input type="text" name="contact"><br>
</p>
<p>
フリースペース(アピールポイントや興味があること等を書いてください)<br><textarea  name=freespace maxlength=200 cols="40" rows="5"></textarea><br>
</p>
<p>
価値観<br>
<input type="text" name="value1"><br>
<input type="text" name="value2"><br>
<input type="text" name="value3"><br>
</p>
<input type="submit" value="次へ">


</form>
</body>
</html>