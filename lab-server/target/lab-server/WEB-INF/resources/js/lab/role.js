/**
 * Created by Fu Zhong on 2015/8/20.
 */
$(function(){
    var table = $('#containerTable');

    table.bootstrapTable({
        showRefresh : true,
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
        url : lab.contextPath + '/system/role/query',
        columns : [{checkbox: true},
            {title: '角色ID', field: 'id'},
            {title: '名称', field: 'name'},
            {title: '描述', field: 'descr'},
            {title: '备注', field: 'remark'},
            {title: '创建者', field: 'createUserName'},
            {title: '创建时间', field: 'addTime'},
            {title: '操作', field: 'phone',
                formatter : function(value, row, index) {
                    var update = '', del = '', permission ='';
                    permission = "<button type='button' class='btn btn-warning btn-xs' onclick=' handle (" + index + ")'>权限管理</button> ";
                    update = "<button type='button' class='btn btn-info btn-xs' onclick=' mdf (" + index + ")'>修改</button> ";
                    del = "<button style='margin-left:5px;' type='button' class='btn btn-danger btn-xs' onclick='del ("+ row.id + ")'>删除</button>";
                    return permission + update + del;
                }
            }]
    });

});