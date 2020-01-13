package com.fh.test.service;

import com.fh.test.mapper.RoleMapper;
import com.fh.test.model.DataTableResult;
import com.fh.test.model.Role;
import com.fh.test.model.RoleQuery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public DataTableResult queryRoleList(RoleQuery roleQuery) {
        //1.查询总条数
        Long count =  roleMapper.queryRoleCount(roleQuery);


        //2.查询当前页数据
        List<Role> roleList = roleMapper.queryRoleList(roleQuery);

        DataTableResult dataTableResult = new DataTableResult(roleQuery.getDraw(),count,count,roleList);

        return dataTableResult;
    }

    @Override
    public void addRole(Role role) {
        role.setCreateDate(new Date());
        roleMapper.addRole(role);
    }

    @Override
    public void deleteRole(Integer id) {
        roleMapper.deleteRole(id);
    }

    @Override
    public Role getRoleById(Integer id) {
        Role role = roleMapper.getRoleById(id);
        return role;
    }

    @Override
    public void updateRole(Role role) {
        role.setUpdateDate(new Date());
        roleMapper.updateRole(role);
    }

    @Override
    public void batchDeleteRole(List<Integer> ids) {
        roleMapper.batchDeleteRole(ids);
    }

    @Override
    public void updateRoleStatus(Integer id) {
        Role role = roleMapper.getRoleById(id);
        roleMapper.updateRoleStatus(id,role.getStatus()==1?2:1);
//        role.setStatus(role.getStatus()==1?2:1);
//        roleMapper.updateRole(role);
    }

    @Override
    public List<Role> queryEnableRoleList() {
        return roleMapper.queryEnableRoleList();
    }

    @Override
    public List<Role> queryAllRoleList() {
        return roleMapper.queryAllRoleList();
    }

    @Override
    public void batchAddRole(List<Role> roleList) {
        roleMapper.batchAddRole(roleList);
    }

    @Override
    public List<Role> queryRoleListNoPage(RoleQuery roleQuery) {
        return roleMapper.queryRoleListNoPage(roleQuery);
    }
}