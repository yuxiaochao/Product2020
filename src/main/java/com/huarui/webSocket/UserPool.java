package com.huarui.webSocket;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.huarui.product2020.entity.HrswTUser;
import com.huarui.product2020.service.IHrswTUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserPool {
    @Autowired
    private IHrswTUserService userService;

    private Set<String> userPool = new HashSet<>();

    public Set<String> getUserPool() {
        if(userPool == null || userPool.size()==0){
            //从数据库获取获取
            List<HrswTUser> list = userService.selectList(new EntityWrapper<>());
            for (HrswTUser hrswTUser : list) {
                userPool.add(hrswTUser.getUser001());
            }
        }
        return userPool;
    }

    public void setUserPool(Set<String> userPool) {
        this.userPool = userPool;
    }

    /**
     * 校验用户是否在系统中维护
     * @param userId 用户id
     * @return boolean
     */
    public boolean verification(String userId){
        Set<String> userPool = getUserPool();
        return userPool.contains(userId);
    }
}
