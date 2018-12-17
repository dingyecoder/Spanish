<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2018/12/15
  Time: 22:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加文章</title>
</head>
<body>

    <div>
        <div>添加文章</div>
        <div>标题</div>
        <%--<input type="text" id="articleTitleId" name="title" style="width:99%;">--%>
        <form action="${pageContext.request.contextPath}/servletArticle" method="post" id="articleForm">
            <input type="hidden" id="methodId" name="method">
            <input id="articleTitleId" name="articleTitle" style="width: 99%;">
            <input type="hidden" id="articleContentHtmlId" name="articleContentHtml">
            <input type="hidden" id="articleContentTextId" name="articleContentText">
        </form>

        <div>请输入你要添加的内容</div>
        <div id="editor">
            <p>在此输入内容</p>
        </div>

        <button id="btn1">Submit</button>
       <%-- <button id="btn2">获取text</button>--%>
    </div>

    <!-- 注意， 只需要引用 JS，无需引用任何 CSS ！！！-->
    <script type="text/javascript" src="static/js/wangEditor.js"></script>
    <script type="text/javascript">
        debugger;
        var E = window.wangEditor;
        //var editor = new window.wangEditor('#editor');
        var editor = new E(document.getElementById('editor'));
        editor.create();
        document.getElementById('btn1').addEventListener('click', function () {
            //设置表单中的方法为addArticle
            document.getElementById("methodId").value = "addArticle";
           // var articleTitle = document.getElementById("articleTitleId").value;

            //获取富文本编辑器中的html内容
            var contentHtml = document.getElementById("articleContentHtmlId").value = editor.txt.html();
            //获取富文本编辑器中的text内容
            var contentText = document.getElementById("articleContentTextId").value = editor.txt.text();
            console.log(contentHtml);
            console.log(contentText);
            //alert(contentHtml);
            //alert(contentText);

            var form = document.getElementById("articleForm");
            form.submit();
        }, false);

        document.getElementById('btn2').addEventListener('click', function () {
            // 读取 text
            alert(editor.txt.text())
        }, false);
    </script>





</body>
</html>
