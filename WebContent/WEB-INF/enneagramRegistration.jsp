<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="tableDesign.css">
<title>自己分析</title>
</head>
<body>
<jsp:include page="headerForUnfinishAccountRegistration.jsp"/>
<form action="/SE18G2/enneagramRegistration" method="post">
<!-- headerを入れます -->

<h1>自己分析</h1>
★まずエニアグラム診断を受け、その結果を入力してください。<br>
<a href="https://www.enneagram.ne.jp/about"target="_blank">エニアグラムとは</a><br>
*エニアグラムはAppleやIBMなどの企業でも採用されている性格診断の手法です。

<table>
  <tr>
    <td>1</td>
    <td>2</td>
    <td>3</td>
  </tr>
  <tr>
    <td><input type="text" name="enneagram1"></td>
    <td><input type="text" name="enneagram2"></td>
    <td><input type="text" name="enneagram3"></td>
  </tr>
  <tr>
    <td>4</td>
    <td>5</td>
    <td>6</td>
  </tr>
  <tr>
    <td><input type="text" name="enneagram4"></td>
    <td><input type="text" name="enneagram5"></td>
    <td><input type="text" name="enneagram6"></td>
  </tr>
    <tr>
    <td>7</td>
    <td>8</td>
    <td>9</td>
  </tr>
  <tr>
    <td><input type="text" name="enneagram7"></td>
    <td><input type="text" name="enneagram8"></td>
    <td><input type="text" name="enneagram9"></td>
  </tr>
</table>

<input type="submit" value="次へ">


</form>
</body>
</html>