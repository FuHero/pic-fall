/**
 * Created by Fu Zhong on 2015/8/20.
 */
$(function(){
    var table = $('#containerTable');
    table.bootstrapTable({
        showRefresh : true,
        showColumns : true,
        clickToSelect : false,
        striped : true,
        pagination : true,
        pageSize : 20,
        pageList : [ 20, 30, 50 ],
        queryParamsType : 'limit',
        sidePagination : 'server',
        pageNumber : 1,
        smartDisplay : true,
        toolbar : '#toolbar',
        idField : 'id',
        url : lab.contextPath + '/system/user/query',
        columns : [{checkbox: true},
            {title: '用户ID', field: 'id'},
            {title: '账号', field: 'username'},
            {title: '姓名', field: 'name'},
            {title: '年龄', field: 'age'},
            {title: '性别', field: 'sex', formatter : function(value, row, index){
                return value == '0' ? '男' : value == '1' ? '女' : '未知';
            }},
            {title: '联系电话', field: 'phone'},
            {title: '地址', field: 'address'},
            {title: '创建时间', field: 'addTime'},
            {title: '状态', field: 'isLock', formatter : function(value, row, index){
                return value == '0' ? '未锁' : value == '1' ? '锁定' : '未知';
            }},
            {title: '操作', field: 'phone',
                formatter : function(value, row, index) {
                    var permission = '', update = '', del ='';
                    permission += "<button type='button' class='btn btn-warning btn-xs' onclick='handle(" + index + ")'>权限管理</button>";
                    update += "<button style='margin-left:5px;' type='button' class='btn btn-info btn-xs' onclick='update(" + index + ")'>修改</button>";
                    del += "<button style='margin-left:5px;' type='button' class='btn btn-danger btn-xs' onclick='del("+ row.id + ")'>删除</button>";
                    return permission + update + del;
                }
            }]
    });

    $('#confirmBtn').click(function(){
        $('#createModel').modal('hide');
        var user = lab.getFormData("userForm");
        bootbox.confirm({
            message: "确认操作！",
            callback: function (result) {
                if (result) {
                    var url = '';
                    if (user.id != null && user.id != undefined) {
                        url =  lab.contextPath + '/system/user/update';
                    } else {
                        url =  lab.contextPath + '/system/user/add';
                    }
                    $.ajax({
                        type : 'get',
                        //async : false,
                        url : url,
                        data : user,
                        dataType : 'json',
                        success : function(data) {
                            if (data.state) {
                                bootbox.alert("成功！");
                                table.bootstrapTable('refresh', { silent : true });
                            } else {
                                bootbox.alert(data.msg);
                            }
                        },
                        error : function(XMLHttpRequest, textStatus, errorThrown) {
                            bootbox.alert(textStatus);
                        }
                    });
                }
            }
        });
    });
});

function lock(index) {
    var row = getIndexRow(index);
    if (row){
        bootbox.confirm({
            message: "确认操作！",
            callback: function (result) {
                if (result) {
                    $.ajax({
                        type : 'get',
                        //async : false,
                        url : lab.contextPath + '/system/user/lock',
                        data : {id: row.id, isLock: !row.isLock},
                        dataType : 'json',
                        success : function(data) {
                            if (data.state) {
                                bootbox.alert("成功！");
                                $('#containerTable').bootstrapTable('refresh', { silent : true });
                            } else {
                                bootbox.alert(data.msg);
                            }
                        },
                        error : function(XMLHttpRequest, textStatus, errorThrown) {
                            bootbox.alert(textStatus);
                        }
                    });
                }
            }
        });
    }
}

function getIndexRow (index) {
    var $table = $('#containerTable');
    var row = {};
    if (index || index == 0) {
        var data = $table.bootstrapTable('getData');
        row = data[index];
    } else  {
        var rows = $table.bootstrapTable('getSelections');
        var len = rows.length;
        if (len == 0) {
            bootbox.alert('没有选择任何记录');
            return;
        } else if (len > 1) {
            bootbox.alert('选则的记录过多');
            return;
        } else {
            row = rows[0];
        }
    }
    return row;
}

function create() {
    var user = {};
    $('#userID').remove();
    $('#username').removeAttr('disabled');
    $('#password').parents('.form-group').show();
    $('#password').removeAttr('disabled');
    lab.setFormData("createModel", user);
    $('#createModel').modal();
}

function del (id) {
    bootbox.confirm({
        message: "确认操作！",
        callback: function (result) {
            if (result) {
                var $table = $('#containerTable');
                var row = {};
                if (!id) {
                    var rows = $table.bootstrapTable('getSelections');
                    var len = rows.length;
                    if (len == 0) {
                        bootbox.alert('没有选择任何记录');
                        return false;
                    } else if (len > 1) {
                        bootbox.alert('选则的记录过多');
                        return false;
                    } else {
                        row = rows[0];
                    }
                    id = row.id;
                }
                $.ajax({
                    type : 'get',
                    //async : false,
                    url : lab.contextPath + '/system/user/del',
                    data : {id: id},
                    dataType : 'json',
                    success : function(data) {
                        if (data.state) {
                            bootbox.alert("成功！");
                            $table.bootstrapTable('refresh', { silent : true });
                        } else {
                            bootbox.alert(data.msg);
                        }
                    },
                    error : function(XMLHttpRequest, textStatus, errorThrown) {
                        bootbox.alert(textStatus);
                    }
                });
            }
        }
    });
}

function update(index) {
    var $table = $('#containerTable');
    var row = {};
    if (index || index == 0) {
        var data = $table.bootstrapTable('getData');
        row = data[index];
    } else  {
        var rows = $table.bootstrapTable('getSelections');
        var len = rows.length;
        if (len == 0) {
            bootbox.alert('没有选择任何记录');
            return false;
        } else if (len > 1) {
            bootbox.alert('选则的记录过多');
            return false;
        } else {
            row = rows[0];
        }
    }
    row.password = '';
    $('#userID').remove();
    var id = "<div class='form-group' id='userID'><label class='col-sm-2 control-label'>用户ID</label><div class='col-sm-10'>";
    id += "<input type='text' class='form-control' name='id' disabled='disabled'></div></div>";
    $('#userForm').prepend(id);
    $('#password').parents('.form-group').hide();
    $('#username').attr('disabled', 'disabled');
    $('#password').attr('disabled', 'disabled');
    lab.setFormData("createModel", row);
    $('#createModel').modal();
}