<%--
  Created by IntelliJ IDEA.
  User: 杨帆
  Date: 2019/10/28
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="utf-8">
    <title>首页</title>
    <link rel="stylesheet" type="text/css" href="dhtmlxgrid.css" />
    <link rel="stylesheet" type="text/css" href="dhtmlxtree.css" />
    <link rel="stylesheet" type="text/css" href="css/zTreeStyle.css" />
    <%--<link rel="stylesheet" type="text/css" href="css/demo.css" />--%>
    <link rel="stylesheet" type="text/css" href="skins/dhtmlxgrid_dhx_skyblue.css" />
    <link rel="stylesheet" type="text/css" href="skins/dhtmlxgrid_gabl_skyblue.css"/>
    <link rel="stylesheet" type="text/css" href="css/bootstrap/3.3.6/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/metroStyle/diy.css" />
    <link rel="stylesheet" type="text/css" href="css/metroStyle/metroStyle.css">
    <script src="js/jquery/2.0.0/jquery.min.js"></script>
    <script src="js/bootstrap/3.3.6/bootstrap.min.js"></script>
    <script src="dhtmlxcommon.js"></script>
    <script src="dhtmlxgrid.js"></script>
    <script src="dhtmlxgridcell.js"></script>
    <script src="js/dhtmlxtree.js"></script>
    <script src="js/jquery-1.4.4.min.js"></script>
    <script src="js/jquery.ztree.core.js"></script>
    <style>
        #top{
            height: 15%;
            background-color: rgb(250, 250, 250);
            padding-left: 0px;
            padding-right: 0px;
        }
        #text{
            float: left;
            margin-top: 3%;
            margin-left: 2%;
        }
        #query{
            float: left;
            margin-top: 3%;
            margin-left: 2%;
        }
        #add{
            float: right;
            margin-top: 3%;
            margin-right: 2%;
        }
        #add_bg{
            display: none;
            position: absolute;
            top: 0%;
            left: 0%;
            width: 100%;
            height: 100%;
            background-color: rgb(244,244,244);
            z-index: 1001;
            -moz-opacity: 0.7;
            opacity: .70;
            filter: alpha(opacity=70);
        }
        #add_show{
            display: none;
            position: absolute;
            top: 10%;
            left: 27%;
            width: 47%;
            height:73%;
            padding: 8px;
            /*border: 1px solid black;*/
            background-color: white;
            z-index: 1002;
            overflow: visible;
        }
        #delete{
            float: right;
            margin-top: 3%;
            margin-right: 2%;
        }
        #delete_bg{
            display: none;
            position: absolute;
            top: 0%;
            left: 0%;
            width: 100%;
            height: 100%;
            background-color: rgb(244,244,244);
            z-index: 1001;
            -moz-opacity: 0.7;
            opacity: .70;
            filter: alpha(opacity=70);
        }
        #delete_show{
            display: none;
            position: absolute;
            top: 15%;
            left: 27%;
            width: 47%;
            height:40%;
            padding: 8px;
            /*border: 1px solid black;*/
            background-color: white;
            z-index: 1002;
            overflow: visible;
        }
        #update{
            float: right;
            margin-top: 3%;
            margin-right: 2%;
        }
        #update_bg{
            display: none;
            position: absolute;
            top: 0%;
            left: 0%;
            width: 100%;
            height: 100%;
            background-color: rgb(244,244,244);
            z-index: 1001;
            -moz-opacity: 0.7;
            opacity: .70;
            filter: alpha(opacity=70);
        }
        #update_show{
            display: none;
            position: absolute;
            top: 10%;
            left: 27%;
            width: 47%;
            height:73%;
            padding: 8px;
            /*border: 1px solid black;*/
            background-color: white;
            z-index: 1002;
            overflow: visible;
        }
        #left{
            height: 85%;
            padding-left: 0px;
            padding-right: 0px;
            border: 1px solid gray;
        }
        #right{
            height: 85%;
            padding-left: 0px;
            padding-right: 0px;
        }

    </style>
</head>
<body>
    <div class="container">
        <div class="row">
            <div id="top" class="col-md-12 col-lg-12 col-sm-12 col-xs-12">
                <div id="text">
                    <span>用户代码：</span>
                    <input id="name" name="name" type="text">
                </div>
                <div id="query"><button class="btn btn-default">查询</button></div>
                <div id="update">
                    <button class="btn btn-default" onclick="showUpdate()">修改用户</button>
                </div>
                <div id="delete">
                    <button class="btn btn-default" onclick="showDelete();">删除用户</button>
                </div>
                <div id="add">
                    <button class="btn btn-default box" onclick="showAdd()">添加用户</button>
                </div>
            </div>
        </div>
        <div class="row">
            <div id="left" class="col-md-3 col-lg-3 col-sm-3 col-xs-3">
                <ul id="treeBox" class="ztree" style="width: 100%;height: 100%;margin-top: 0px"></ul>
            </div>
            <div id="right" class="col-md-9 col-lg-9 col-sm-9 col-xs-9">
                <div id="gridBox" style="width: 100%;height: 100%"></div>
            </div>
        </div>
    </div>
    <%--遮罩层--%>

    <%--删除页面--%>
    <%--background--%>
    <div id="delete_bg"></div>
    <%--show--%>
    <div id="delete_show">
        <div class="panel panel-default">
            <div class="page-header">
                <div class="row">
                    <h1 style="text-align: center">删除用户</h1>
                </div>
            </div>
            <div class="panel-body">
                <form class="form-horizontal" role="form" action="deleteUserByYhdm" method="post" onsubmit="return checkDelete()">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">用户代码</label>
                        <div class="col-sm-10">
                            <input class="form-control" placeholder="请输入用户代码" type="text" name="yhdm" id="deleteYhdm">
                        </div>
                    </div>
                    <div class="form-group">
                        <div style="float:left; margin-left: 10%"><button class="btn btn-danger btn" onclick="hideDelete()" type="button">退出</button></div>
                        <div style="float: right;margin-right: 10%"><button class="btn btn-primary btn" type="submit">提交</button></div>
                    </div>
                </form>
            </div>
        </div>
        <%--<button class="btn btn-default" onclick="hideDelete();">关闭</button>--%>
    </div>

    <%--添加页面--%>
    <%--background--%>
    <div id="add_bg"></div>
    <%--show--%>
    <div id="add_show">
        <div class="panel panel-default">
            <div class="page-header">
                <div class="row">
                    <h1 style="text-align: center">添加用户</h1>
                </div>
            </div>
            <div class="panel-body">
                <form class="form-horizontal" role="form" action="addUser" method="post" onsubmit="return checkAdd()">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">用户代码</label>
                        <div class="col-sm-10">
                            <input class="form-control" placeholder="请输入用户代码" type="text" name="yhdm" id="addYhdm">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">用户姓名</label>
                        <div class="col-sm-10">
                            <input class="form-control" placeholder="请输入用户姓名" type="text" name="yhxm" id="addYhxm">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">用户部门</label>
                        <div class="col-sm-10">
                            <input class="form-control" placeholder="请输入用户部门" type="text" name="yhbm" id="addYhbm">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">标识</label>
                        <div class="col-sm-10">
                            <input class="form-control" placeholder="请输入标识" type="text" name="bs" id="addBs">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">是否禁用</label>
                        <div class="col-sm-10">
                            <label class="radio-inline">
                            <input type="radio" name="sfjy" id="addSfjy1" value="0" checked="checked"> 是
                        </label>
                            <label class="radio-inline">
                                <input type="radio" name="sfjy" id="addSfjy2" value="1"> 否
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">排序号</label>
                        <div class="col-sm-10">
                            <input class="form-control" placeholder="请输入排序号" type="text" name="pxh" id="addPxh">
                        </div>
                    </div>
                    <div class="form-group">
                        <div style="float:left; margin-left: 10%"><button class="btn btn-danger btn" onclick="hideAdd()" type="button">退出</button></div>
                        <div style="float: right;margin-right: 10%"><button class="btn btn-primary btn" type="submit">提交</button></div>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <%--更新页面--%>
    <%--background--%>
    <div id="update_bg"></div>
    <%--show--%>
    <div id="update_show">
        <div class="panel panel-default">
            <div class="page-header">
                <div class="row">
                    <h1 style="text-align: center">修改用户</h1>
                </div>
            </div>
            <div class="panel-body">
                <form class="form-horizontal" role="form" action="updateUser" method="post" onsubmit="return checkUpdate()">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">用户代码</label>
                        <div class="col-sm-10">
                            <input class="form-control" placeholder="请输入用户代码" type="text" name="yhdm" id="updateYhdm">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">用户姓名</label>
                        <div class="col-sm-10">
                            <input class="form-control" placeholder="请输入用户姓名" type="text" name="yhxm" id="updateYhxm">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">用户部门</label>
                        <div class="col-sm-10">
                            <input class="form-control" placeholder="请输入用户部门" type="text" name="yhbm" id="updateYhbm">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">标识</label>
                        <div class="col-sm-10">
                            <input class="form-control" placeholder="请输入标识" type="text" name="bs" id="updateBs">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">是否禁用</label>
                        <div class="col-sm-10">
                            <label class="radio-inline">
                                <input type="radio" name="sfjy" id="updateSfjy1" value="0" checked="checked"> 是
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="sfjy" id="updateSfjy2" value="1"> 否
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">排序号</label>
                        <div class="col-sm-10">
                            <input class="form-control" placeholder="请输入排序号" type="text" name="pxh" id="updatePxh">
                        </div>
                    </div>
                    <div class="form-group">
                        <div style="float:left; margin-left: 10%"><button class="btn btn-danger btn" onclick="hideUpdate()" type="button">退出</button></div>
                        <div style="float: right;margin-right: 10%"><button class="btn btn-primary btn" type="submit">提交</button></div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
<script>
    var mygrid;
    mygrid = new dhtmlXGridObject("gridBox");
    mygrid.setImagePath("imgs/");
    mygrid.setHeader("用户代码,用户姓名,用户部门,标识,是否禁用,排序号");
    mygrid.setInitWidthsP("10,*,15,20,10,15");
    mygrid.setColAlign("center,center,center,center,center,center");
    mygrid.setSkin("dhx_skyblue");
    mygrid.init();
    mygrid.load("getAllUser","json");

    $("#query").click(function () {
        var yhdm = $("#name").val();
        if(yhdm == null || yhdm == ""){
            alert("用户代码不能为空！");
        }else{
            var yhbm = id;
            mygrid.clearAndLoad("getUserByYhdmAndYhbm?yhbm="+yhbm+"&yhdm="+yhdm,"json");
        }
    });

    //tree开始
    var setting = {
        async: {
            enable: true,
            url:"getAllDepart",
            dataFilter: function (treeId, parentNode, responseData) {
                return responseData;
            }
        },
        data: {
            simpleData: {
                enable: true,
                idKey:"id",
                pIdKey:"pid"
            }
        },
        callback: {
            onClick: onClick
        }
    };
    var id;
    function onClick(event, treeId, treeNode, clickFlag) {
        id = treeNode.id;
        mygrid.clearAndLoad("getUserByYhbm?yhbm="+id,"json");
    }

    $(document).ready(function(){
        $.fn.zTree.init($("#treeBox"), setting);
    });
    //tree结束

    //遮罩层

    //delete
    function showDelete() {
        document.getElementById("delete_bg").style.display = "block";
        document.getElementById("delete_show").style.display = "block";
    }

    function hideDelete() {
        document.getElementById("delete_bg").style.display = 'none';
        document.getElementById("delete_show").style.display = 'none';
    }

    //add
    function showAdd() {
        document.getElementById("add_bg").style.display = "block";
        document.getElementById("add_show").style.display = "block";
    }

    function hideAdd() {
        document.getElementById("add_bg").style.display = "none";
        document.getElementById("add_show").style.display = "none";
    }

    //update
    function showUpdate() {
        document.getElementById("update_bg").style.display = "block";
        document.getElementById("update_show").style.display = "block";
    }

    function hideUpdate() {
        document.getElementById("update_bg").style.display = "none";
        document.getElementById("update_show").style.display = "none";
    }

    function checkAdd() {
        var addYhdm = document.getElementById("addYhdm").value;
        var addYhxm = document.getElementById("addYhxm").value;
        var addYhbm = document.getElementById("addYhbm").value;
        var addBs = document.getElementById("addBs").value;
        var addPxh = document.getElementById("addPxh").value;
        if(addYhdm == ""){
            alert("用户代码不能为空！");
            return false;
        }
        if(addYhxm == ""){
            alert("用户姓名不能为空！");
            return false;
        }
        if(addYhbm == ""){
            alert("用户部门不能为空！");
            return false;
        }
        if(addBs == ""){
            alert("标识不能为空！");
            return false;
        }
        if(addPxh == ""){
            alert("排序号不能为空！");
            return false;
        }
        return true;
    }

    function checkUpdate() {
        var updateYhdm = document.getElementById("updateYhdm").value;
        var updateYhxm = document.getElementById("updateYhxm").value;
        var updateYhbm = document.getElementById("updateYhbm").value;
        var updateBs = document.getElementById("updateBs").value;
        var updatePxh = document.getElementById("updatePxh").value;
        if(updateYhdm == ""){
            alert("用户代码不能为空！");
            return false;
        }
        if(updateYhxm == ""){
            alert("用户姓名不能为空！");
            return false;
        }
        if(updateYhbm == ""){
            alert("用户部门不能为空！");
            return false;
        }
        if(updateBs == ""){
            alert("标识不能为空！");
            return false;
        }
        if(updatePxh == ""){
            alert("排序号不能为空！");
            return false;
        }
        return true;
    }

    function checkDelete() {
        var deleteYhdm = document.getElementById("deleteYhdm").value;
        if(deleteYhdm == ""){
            alert("用户代码不能为空！");
            return false;
        }
        return true;
    }


</script>
</html>
