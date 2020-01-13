package com.fh.member.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.member.model.Area;
import com.fh.member.model.Member;

import java.util.List;

public interface MemberMapper extends BaseMapper<Member> {
    void addMember(Member member);

    Member getMemberByLoginname(String loginname);

    void updateMember(Member member);

    List<Area> getPidByArea(Integer pid);

    Member getMemberById(Integer id);
}
