var isLogin=false;

var loginDivHtml = '\n' +
    '    <form class="form-horizontal" >\n' +
    '        <div class="form-group">\n' +
    '            <label  class="col-sm-2 control-label">用户名</label>\n' +
    '            <div class="col-sm-8">\n' +
    '                <input type="text" class="form-control"   id="loginname" placeholder="请输入登录名...">\n' +
    '            </div>\n' +
    '        </div>\n' +
    '\n' +
    '        <div class="form-group">\n' +
    '            <label  class="col-sm-2 control-label">密码</label>\n' +
    '            <div class="col-sm-8">\n' +
    '                <input type="password" class="form-control"  id="password" placeholder="请输入密码...">\n' +
    '            </div>\n' +
    '        </div>\n' +
    '\n' +
    '    </form>\n' +
    '';







function login() {
    bootbox.dialog({
        message: loginDivHtml,
        title: "登录",
        backdrop: false,
        buttons: {
            Cancel: {
                label: "取消",
                className: "btn-default",
                callback: function () {

                }
            }
            , OK: {
                label: "确认",
                className: "btn-danger",
                callback: function () {
                    var param = {};
                    param.loginname = $("#loginname").val();
                    param.password = $("#password").val();
                    $.post(
                        "http://localhost:8091/member/login",
                        param,
                        function (data) {
                            if (data.code == 200) {
                                isLogin = true;
                                console.log(data.data);
                                window.localStorage.setItem("token", data.data);
                                //queryList();
                                location.reload();
                            } else {
                                alert("操作失败！" + data.message, function () {
                                })
                            }

                        }
                    )
                }
            }
        }
    });

}

