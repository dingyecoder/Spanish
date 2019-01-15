<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2018/12/16
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Sentence</title>
</head>
<body>

<div>
    <h3>创建每日一句</h3>
</div>

<div>
    <form action="${pageContext.request.contextPath}/servletSentence" method="post" id="sentenceForm">
        <input type="hidden" id="methodId" name="method">
        <input type="hidden" id="sentenceValueId" name="sentence">
    </form>
</div>
<div id="editor">
    <p>请输入您需要添加的语句！</p>
</div>
<button id="btn1">Confirm</button>

<button id="btn2">获取text</button>


<!-- 注意， 只需要引用 JS，无需引用任何 CSS ！！！-->
<script type="text/javascript" src="static/js/wangEditor.js"></script>
<script type="text/javascript">
    debugger;
    var E = window.wangEditor;
    //var editor = new window.wangEditor('#editor');
    var editor = new E(document.getElementById('editor'));
    editor.create();
    document.getElementById('btn1').addEventListener('click', function () {
        // 读取 html
        alert(editor.txt.html())
        console.log(editor.txt.html());
        document.getElementById("methodId").value = "addSentence";
        document.getElementById("sentenceValueId").value = editor.txt.html();
        var form = document.getElementById("sentenceForm");
        form.submit();
    }, false);

    document.getElementById('btn2').addEventListener('click', function () {
        // 读取 text
        alert(editor.txt.text())
    }, false);
</script>


</body>
</html>
