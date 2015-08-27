/**
 * Created by Fu Zhong on 2015/8/16.
 */
/** 弹窗设置 **/
bootbox.setLocale("zh_CN");
bootbox.setDefaults({
    size : 'small'
});

/** 公共方法 **/
var lab = {
    contextPath : $('#contextPath').val(),
    getParamUrl : function(url) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)","i");
        var r = window.location.search.substr(1).match(reg);
        if (r!=null) {
            return (r[2]);
        }
        return null;
    },
    /** 用户资料缓存 **/
    getLoginInfo : function () {
        var info = localStorage.getItem('user');
        if (!info) {
            var url = window.location.href;
            if (url.indexOf("/logout")>0) {
                return;
            }
            window.location.href = lab.contextPath + '/logout';
        }
        return JSON.parse(info);
    },
    getFormData : function(formID) {
        var data = {};
        var input = $('#' + formID).find(':input:not(:button)');
        $.each(input, function(i, n) {
            if ($(n).is(':radio')) {
                if ($(n).is(':checked')) {
                    data[$(n).attr('name')] = $(n).val();
                }
            } else if ($(n).is(':checkbox')) {
                if ($(n).is(':checked')) {
                    var name = data[$(n).attr('name')];
                    if (!name) {
                        name = new Array();
                    }
                    name.push($(n).val());
                    data[$(n).attr('name')] = name;
                }
            } else {
                data[$(n).attr('name')] = $(n).val();
            }
        });
        return data;
    },
    setFormData : function(formID, data) {
        var input = $('#' + formID).find(':input:not(:button)');
        $.each(input, function(i, n) {
            if ($(n).is(':radio')) {
                if ($(n).val() == data[$(n).attr('name')]) {
                    $(n).attr('checked', true);
                    console.log($(n).attr('name'));
                } else {
                    $(n).attr('checked', false);
                }
            } else if ($(n).is(':checkbox')) {
                var arr = data[$(n).attr('name')];
                if ($.isArray(arr) && $.inArray($(n).val(), arr) != -1) {
                    $(n).attr('checked', true);
                } else {
                    $(n).attr('checked', false);
                }
            } else {
                $(n).val(data[$(n).attr('name')]);
            }
        })
    }
};

if (lab.getLoginInfo()) {
    $('#userButtom p').html(lab.getLoginInfo().name);
    $('#userButtom-li').click(function () {
        window.location.href = lab.contextPath + '/user/detail?id=' + lab.getLoginInfo().id;
    });
}

$('.nav li').each(function (i) {
    $(this).click(function () {
        $('.nav li').removeClass('active');
        $(this).addClass('active');
        var value = $(this).find('b:first').attr('class');
        if (value == 'float-right glyphicon glyphicon-chevron-right') {
            $(this).find('b:first').attr('class', 'float-right glyphicon glyphicon-chevron-down');
        } else {
            $(this).find('b:first').attr('class', 'float-right glyphicon glyphicon-chevron-right');
        }
        var display = $(this).next('.submenu').css('display');
        if (display == 'none') {
            $(this).next('.submenu').css('display', 'block');
        } else if (display == 'block') {
            $(this).next('.submenu').css('display', 'none');
        } else {

        }
    });
});
