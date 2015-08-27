/**
 * Created by Fu Zhong on 2015/8/18.
 */
$(function() {
   $('#loginBtn').click(function(){
       var data = lab.getFormData('loginForm');
       $.ajax({
           type : 'get',
           url : lab.contextPath + '/login',
           data : data,
           dataType : 'json',
           success : function(data) {
               if (data.state) {
                   localStorage.setItem('user', JSON.stringify(data.obj));
                   window.location.href = lab.contextPath + '/index';
               } else {
                   bootbox.alert(data.msg);
               }
           },
           error : function(XMLHttpRequest, textStatus, errorThrown) {
               bootbox.alert(textStatus);
           }
       });
   });

});