package com.huarui.product2020.controller.book;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.huarui.common.Req;
import com.huarui.common.utils.IPage;
import com.huarui.common.utils.RedisUtil;
import com.huarui.common.utils.ThreadUtils;
import com.huarui.product2020.entity.ResultEntity;
import com.huarui.product2020.entity.Tbtssq01;
import com.huarui.product2020.entity.Tbtssq02;
import com.huarui.product2020.entity.Tbusif02;
import com.huarui.product2020.service.ITbtssq02Service;
import com.huarui.product2020.service.ITbusif02Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 图书申请 前端控制器
 * </p>
 *
 * @author caifl
 * @since 2020-04-01
 */
@RestController
@RequestMapping("/book/tbtssq01")
public class Tbtssq01Controller {
    
    @Autowired
    private ITbusif02Service tbusif02Service;
    
    @Autowired
    private ITbtssq02Service tbtssq02Service;
    
    @Autowired
    private RedisUtil redisUtil;
	   
    @RequestMapping("/list")
    public ResultEntity findListByUserId(Req req) {
        ResultEntity result = new ResultEntity();
        int start = req.getCurrentPage();
        int limit = req.getPageSize();
        Page<Tbtssq01> page = new IPage<Tbtssq01>(start, limit) {};
        Map<String, Object> paramMap = req.getParameterMap();
        
        String userId = req.getUserId();
        paramMap.put("userId", userId);
        Page<Tbtssq01> data = tbtssq02Service.findBookApplicationListByUserId(page, paramMap);
        result.setData(data);
        return result;
    }
    
    
    
    @RequestMapping("/findAddressByUserId")
    public ResultEntity findAddressByUserId(Req req) {
        ResultEntity result = new ResultEntity();
        String userId = req.getUserId();
        EntityWrapper<Tbusif02> wrapper = new EntityWrapper<Tbusif02>();
        wrapper.eq("usif0202", userId);
        List<Tbusif02> list = tbusif02Service.selectList(wrapper);
        result.setData(list);
        return result;
    }
    
    
    
    @RequestMapping("/bookApply")
    public ResultEntity bookApply(Req req) {
        ResultEntity result = new ResultEntity();
        Map<String, Object> parameterMap = req.getParameterMap();
        String jsonString = JSON.toJSONString(parameterMap);
        Tbtssq02 tbtssq02 = JSON.parseObject(jsonString, Tbtssq02.class);
        tbtssq02.setTssq0201(ThreadUtils.getRTex().getUUID());
        tbtssq02.setTssq0206(0);
        // 调书单号
        tbtssq02.setTssq0207(generateOrder());
        // 申请时间
        tbtssq02.setTssq0208(new Date());
        // 用户ID
        tbtssq02.setTssq0210(req.getUserId());
        boolean flag = tbtssq02Service.insert(tbtssq02);
        if(!flag) {
            result.setErrorMsg("申请失败!");
        }
        return result;
    }
    
    /**
     * 新增地址接口
     * @param req
     * @return
     */
    @RequestMapping("/saveAdress")
    public ResultEntity saveAdress(Req req) {
        ResultEntity result = new ResultEntity();
        Map<String, Object> parameterMap = req.getParameterMap();
        String jsonString = JSON.toJSONString(parameterMap);
        Tbusif02 tbusif02 = JSON.parseObject(jsonString, Tbusif02.class);
        tbusif02.setUsif0201(ThreadUtils.getRTex().getUUID());
        tbusif02.setUsif0202(req.getUserId());
        boolean flag = tbusif02Service.insert(tbusif02);
        return result;
    }
    
    /**
     * 生成调书单号
     */
    public String generateOrder() {
        DateFormat d = new SimpleDateFormat("yyyyMM");
        String time = d.format(new Date());
        DecimalFormat df = new DecimalFormat("0000000");
        long num = redisUtil.incr(time, 0);
        String orderNum = "GKZSXY" + time +df.format(num);
        return orderNum;
    }
}