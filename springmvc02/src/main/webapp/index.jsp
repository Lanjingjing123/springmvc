<html>
<head>

    <script type="text/javascript" src="scripts/jquery.min.js"></script>
    <script type="text/javascript">
    $(function () {
        alert("hello jQuery!");
        $("#testJson").click(function () {
            var url = this.href;
            alert(url);
            var args = {};

            $.post(url,args,function (data) {
                for(var i=0 ;i <data.length;i++){
                    var id = data[i].id;
                    var lastName=data[i].lastName;
                    alert(id+":"+lastName);
                }
            });
            return false;
        });
    })


/*        $(function () {
            alert("12312321");
            $("#testJson").click(function(){

                alert("111");
                var url =this.href;
                var args = {};
                $.post(url,args,function{
                    for(var i=0;i<data.length;i++){
                        var id = data[i].id;
                        var lastName =data[i].lastName;
                        alert(id+":"+lastName);
                    }
                });
                return false;
            });
        })*/
    </script>
</head>

<body>
<a href="emps">List All Employees</a>
<br><br>
<a href="testJson" id="testJson">testJson </a>
<br><br>
<form action="testHttpMessageConvert" method="POST" ENCTYPE="multipart/form-data">
    File:<input type="file" name="file"/>
    Desc: <input type="text" name="desc"/>
    <input type="submit" value="Submit"/>
</form>
<br>
<a href="testHandlerException?i=1">Test HandlerException</a>
</body>

</html>
