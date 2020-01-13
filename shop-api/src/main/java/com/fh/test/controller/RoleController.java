package com.fh.test.controller;

import com.fh.test.model.Role;
import com.fh.test.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    //@RequestMapping(value="/roles",method = RequestMethod.GET)
    @GetMapping("/roles")
    public Map<String,Object> queryRoleList(){
        Map<String,Object> resultMap = new HashMap<>();
        try {
            List<Role> roleList = roleService.queryAllRoleList();
            resultMap.put("code",200);
            resultMap.put("data",roleList);
            resultMap.put("message","请求成功");
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("code",500);
            resultMap.put("data",null);
            resultMap.put("message","运行异常");
        }
        return resultMap;
    }

    @GetMapping("/roles/{id}")
    public Map<String,Object> getRoleById(@PathVariable("id")Integer id){
        Map<String,Object> resultMap = new HashMap<>();
        try {
            Role role = roleService.getRoleById(id);
            resultMap.put("code",200);
            resultMap.put("data",role);
            resultMap.put("message","请求成功");
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("code",500);
            resultMap.put("data",null);
            resultMap.put("message","运行异常");
        }
        return resultMap;
    }

    @PostMapping("/roles")
    public Map<String,Object> addRole(Role role){
        Map<String,Object> resultMap = new HashMap<>();
        try {
            roleService.addRole(role);
            resultMap.put("code",200);
            resultMap.put("data",null);
            resultMap.put("message","请求成功");
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("code",500);
            resultMap.put("data",null);
            resultMap.put("message","运行异常");
        }
        return resultMap;
    }

    @PutMapping("/roles")
    public Map<String,Object> updateRole(Role role){
        Map<String,Object> resultMap = new HashMap<>();
        try {
            roleService.updateRole(role);
            resultMap.put("code",200);
            resultMap.put("data",null);
            resultMap.put("message","请求成功");
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("code",500);
            resultMap.put("data",null);
            resultMap.put("message","运行异常");
        }
        return resultMap;
    }

    @DeleteMapping("/roles/{id}")
    public Map<String,Object> deleteRole(@PathVariable("id")Integer id){
        Map<String,Object> resultMap = new HashMap<>();
        try {
            roleService.deleteRole(id);
            resultMap.put("code",200);
            resultMap.put("data",null);
            resultMap.put("message","请求成功");
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("code",500);
            resultMap.put("data",null);
            resultMap.put("message","运行异常");
        }
        return resultMap;
    }
}
