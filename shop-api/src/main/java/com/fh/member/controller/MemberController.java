package com.fh.member.controller;

import com.fh.common.ResponseEnum;
import com.fh.common.ServerResponse;
import com.fh.member.model.Area;
import com.fh.member.model.Member;
import com.fh.member.service.MemberService;
import com.fh.util.AliyunSmsUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@RestController
@CrossOrigin
@RequestMapping("member")
public class MemberController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private MemberService memberService;

    @RequestMapping("sendSms")
    public ServerResponse sendSms(String phoneNumber){
        try {
            //判断手机号是否为空
            if(StringUtils.isBlank(phoneNumber)){
                return ServerResponse.error(ResponseEnum.PHONE_NUMBER_IS_NULL);
            }
            String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);//生成短信验证码
            boolean success = AliyunSmsUtil.sendSms(phoneNumber, verifyCode);
            //判断短信验证码是否发送成功
            if(!success){
                return ServerResponse.error();
            }
            //将生成的验证码放入redis中，过期时间设为1分钟
            redisTemplate.opsForValue().set(phoneNumber,verifyCode,1, TimeUnit.HOURS);
            return ServerResponse.success();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ServerResponse.error();
    }

    @RequestMapping("register")
    public ServerResponse register(Member member, String code){
        try {
            return memberService.addMember(member,code);
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.error();
        }
    }


    @RequestMapping("login")
    public ServerResponse login(String loginname, String password, HttpSession session){
        try {
            ServerResponse serverResponse =  memberService.login(loginname,password);
            return serverResponse;
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.error();
        }
    }


    //获取当前登录会员信息的API接口
    @RequestMapping("getCurrentLoginMember")
    public ServerResponse getCurrentLoginMember(HttpServletRequest request){
        try {
            Member loginMember = (Member) request.getAttribute("loginMember");
            Member member = memberService.getMemberById(loginMember.getId());
            return ServerResponse.success(member);
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.error();
        }
    }


    @RequestMapping("updateMember")
    public ServerResponse updateMember(Member member){
        return memberService.updateMember(member);
    }

    @RequestMapping("getPidByArea")
    public ServerResponse getPidByArea(Integer pid){
        List<Area> areaList =  memberService.getPidByArea(pid);
        return ServerResponse.success(areaList);
    }

}
