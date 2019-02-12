<html>
<body>
<h2>Hello World!</h2>
<a href="helloWorld">Hellow World</a>
<br/>
<a href="springmvc/requestMapping">requestMapping</a>
<br>
<a href="/springmvc/testMethod">testMethod</a>
<br>
<form action="/springmvc/testMethod" method="post">
    <input type="submit" value="testMethod"/>
</form>
<br>
<a href="/springmvc/testPathVariable/">testPathVariable</a>
<br>




<a href="/springmvc/testRest/1">Test Rest Get</a>
<br>
<form action="/springmvc/testRest" method="post">
    <input type="submit" value="testRest"/>
</form>
<br>


<form action="/springmvc/testRest/1" method="post">
    <input type="hidden" name="_method" value="DELETE">
    <input type="submit" value="testRest DEL"/>
</form>
<br>
<form action="/springmvc/testRest/1" method="post">
    <input type="hidden" name="_method" value="PUT">
    <input type="submit" value="testRest PUT"/>
</form>
<br>
<<a href="/springmvc/testRequestPara?userName=ljj&age=23">Test RequestPara</a>
<br><br>
<a href="/springmvc/testRequestHeader">Test RequestPara</a>
</body>
</html>
