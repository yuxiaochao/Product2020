package com.huarui.product2020.controller.book;

import com.baomidou.mybatisplus.plugins.Page;
import com.huarui.common.Req;
import com.huarui.common.utils.IPage;
import com.huarui.product2020.entity.ResultEntity;
import com.huarui.product2020.entity.Tbtssq02;
import com.huarui.product2020.service.ITbtssq02Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 * 图书申请记录 前端控制器
 * </p>
 *
 * @author caifl
 * @since 2020-04-01
 */
@RestController
@RequestMapping("/book/tbtssq02")
public class Tbtssq02Controller {
    
    @Autowired
    private ITbtssq02Service tbtssq02Service;
	
    
    /**
     * 根据用户ID图书申请记录
     * @param req
     * @return
     */
    @RequestMapping("/findListByUserId")
    public ResultEntity findListByUserId(Req req) {
        ResultEntity result = new ResultEntity();
        int start = req.getCurrentPage();
        int limit = req.getPageSize();
        Page<Tbtssq02> page = new IPage<Tbtssq02>(start, limit) {};
        Map<String, Object> paramMap = req.getParameterMap();
        
        String userId = req.getUserId();
        paramMap.put("userId", userId);
        Page<Tbtssq02> data = tbtssq02Service.findListByUserId(page, paramMap);
        result.setData(data);
        return result;
    }
}