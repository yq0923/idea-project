package com.fh.member.service;


import com.fh.common.ServerResponse;
import com.fh.member.model.Area;
import com.fh.member.model.Member;

import java.util.List;

public interface MemberService {

    ServerResponse addMember(Member member, String code);

    ServerResponse login(String loginname,String password);


    ServerResponse updateMember(Member member);

    List<Area> getPidByArea(Integer pid);

    Member getMemberById(Integer id);
}
