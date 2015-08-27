/**
 * Created by Fu Zhong on 2015/8/20.
 */
$(function () {
    $.get(lab.contextPath+'/permission/query', function(result){
        var data = JSON.parse(result);
        if (data.state && data.total > 0) {
            data = data.rows;
            var tree = "<ul style='padding-left: 10px;'>";
            for (var i=0; i<data.length; i++) {
                tree += dispalyTreeChild(data[i], 1);
            }
            tree += "</ul>";
            $('#tree').html(tree);
        }

        $("#tree a").each(function() {
            $(this).click(function(){
                var data = JSON.parse($(this).attr('data'));
                var info = "";
                info += "<dl><dt>功能名称</dt><dd>"+data.name+"</dd></dl>";
                info += "<dl><dt>功能类型</dt><dd>"+typeInfo(data.type)+"</dd></dl>";
                info += "<dl><dt>功能URL</dt><dd>"+data.url+"</dd></dl>";
                info += "<dl><dt>功能描述</dt><dd>"+data.url+"</dd></dl>";
                info += "<dl><dt>功能描述</dt><dd>"+data.url+"</dd></dl>";
                $('.tree-info .panel-body').html(info)
            });
        });
        $('#tree li:has(ul)').addClass('parent_li').find(' > span').attr('title', 'Collapse this branch');
        $('#tree li.parent_li > span').on('click', function (e) {
            var children = $(this).parent('li.parent_li').find(' > ul > li');
            if (children.is(":visible")) {
                children.hide('fast');
                $(this).attr('title', 'Expand this branch').find(' > i').addClass('icon-plus-sign').removeClass('icon-minus-sign');
            } else {
                children.show('fast');
                $(this).attr('title', 'Collapse this branch').find(' > i').addClass('icon-minus-sign').removeClass('icon-plus-sign');
            }
            e.stopPropagation();
        });
    });

    function dispalyTreeChild (row, index) {
        var li = "<li>";
        li += "<span><i class='"+choiceClass(index)+"'></i>"+typeInfo(row.type)+"</span>" +
            "<a data='"+JSON.stringify(row)+"' href='javascript:void(0);'>&nbsp;&nbsp;&nbsp;"+row.name+"</a>";
        if (row.children.length >0 ) {
            li += "<ul>";
            index++;
            for (var i=0; i<row.children.length; i++) {
                li += dispalyTreeChild(row.children[i], index);
            }
            li += "</ul>";
        }
        li += "</li>";
        return li;
    }

    function choiceClass(index) {
        if (index==1) {
            return "icon-folder-open";
        } else if (index>1 && index%2==0) {
            return "icon-minus-sign";
        } else {
            return "icon-leaf";
        }
    }

    function typeInfo (type) {
        return type == '1' ? '菜单栏' : type == '2' ? '功能按钮' : '位置';
    }
});