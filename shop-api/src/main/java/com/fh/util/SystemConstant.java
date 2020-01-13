package com.fh.util;

public class SystemConstant {
    //常量后的值不能重复，就是双引号中的值，和其他项目做同样的方法一样
    public static final String  KEY_CATEGORY="category:";//商品分类
    public static final  String EXCEL_FILE_PATH="D:/outFile/";
    public static final  String EXCEL_TIMPATE_FILE_PATH="bbb.xml";
    public static final  String WORD_TIMPATE_FILE_PATH="word-template.xml";
    public static final  String PDF_TIMPATE_FILE_PATH="pdf-template.html";
    public static final  String UPLOAD_FILE_PATH="upload";
    public static final  int LOGGIN_USERNAME_ERROR=1;
    public static final  int LOGGIN_PASSWORD_ERROR=2;
    public static final  int LOGGIN_SUCCESS=3;
    public static final  String LOGGIN_CURRENT_USER="user1:";
    public static final  String LOGGIN_CURRENT_TOKEN="token1:";
    public static final  String COOKIE_KEY="login1";
    public static final  int COOKIE_OUT_TIME=7*24*60*60;//记住一周
    public static final  int COOKIE_OUT_TIME_DEFAULT=30*60;//cookie默认有效时间
    public static final  int LOG_ERROR=0;
    public static final  int LOG_SUCCESS=1;
    public static final  String LOGIN_PAGE="/login.jsp";
    public static final  String NO_PREMISSION_PAGE="/noPremission.jsp";
    public static final  String AJAX_SESSION_OUT="timeOut1";
    public static final  int ADD_PRODUCT_LIST_SIZE =10;

    public static final String  CURRENT_RESOURCELIST="current_resource1:";//当前用户所拥有的资源 key
    public static final String  ALL_RESOURCELIST="all_resource1:";//所有的资源 key
    public static final String  CODE="code1:";//验证码 key
    public static final String  CATEGROYLIST="categoryList1:";//商品分类

    public static final int  CODE_OUT_TIME=5*60;//手机验证码过期时间
    public static final String  SECRET_KEY="$@876767";//所有的资源key
    public static final long  TOKEN_OUT_TIME=60*60*24*6;//token失效时间  单位毫秒

    public static final String  CAPT_KEY="cart1:";//购物车 key
    public static final String  TOKEN_IS_NULL="token为空";//购物车 key
    public static final String  TOKEN_CHECK_ERROR="token解析失败";//购物车 key
    public static final int ORDER_STATUS_WAIT = 1;//订单支付状态 待支付
    public static final int ORDER_STATUS_SUCCESS= 2;//订单支付状态 成功
    public static final String CART_KEY= "cart1:";//
    public static final int Pay_STATUS_WAIT = 1;//支付状态
    public static final int Pay_STATUS_SUCCESS = 2;//支付状态
    public static final String Pay_KEY= "pay1:";//
    public static final String MTOKEN_IS_NULL = "不存在mtoken";//token 为空
    public static final String SUBMIT_TOKEN_DISABLED = "提交token无效";//token 为空
    public static final String NOT_REPETE_CONFIRM = "不能重复提交";//token 为空
    public static final String PAY_TIME_OUT= "支付超时";//支付超时
    public static final String TOKEN_KEY= "token_key1:";//token失效


}
