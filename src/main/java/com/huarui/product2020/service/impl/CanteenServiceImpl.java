package com.huarui.product2020.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.common.Req;
import com.huarui.common.utils.ThreadUtils;
import com.huarui.product2020.entity.Canteen;
import com.huarui.product2020.entity.ResultEntity;
import com.huarui.product2020.mapper.CanteenMapper;
import com.huarui.product2020.service.ICanteenService;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 餐厅资源 服务实现类
 * </p>
 *
 * @author caifenglin
 * @since 2020-01-06
 */
@Service
public class CanteenServiceImpl extends ServiceImpl<CanteenMapper, Canteen> implements ICanteenService {

    @Override
    public Page<Canteen> findList(Page<Canteen> page, Map<String, Object> paramMap) {
        page.setRecords(baseMapper.findList(page, paramMap));
        return page;
    }

    @Override
    public List findToExcel(Map paramMap) {
        return baseMapper.findToExcel(paramMap);
    }

    @Override
    public ResultEntity saveOrUpdate(Req req) {
        ResultEntity result = new ResultEntity();
        String restaurantInformation = req.getString("restaurantInformation");
        
        if(ThreadUtils.getRTex().isNotEmpty(restaurantInformation)) {
            Canteen canteen = JSON.parseObject(restaurantInformation, Canteen.class);
            if(ThreadUtils.getRTex().isEmpty(canteen.getCant001())) {
                
                String newCode = this.getNewCode();
                
                // 新增
                canteen.setCant001(ThreadUtils.getRTex().getUUID());
                canteen.setCant002(newCode);
                canteen.setCant008(req.getUserId());
                canteen.setCant009(new Date());
                canteen.setCant010(new Date());
                baseMapper.insert(canteen);
                result.setData(canteen.getCant001());
            } else {
                // 编辑
                canteen.setCant010(new Date());
                baseMapper.updateById(canteen);
                result.setData(canteen.getCant001());
            }
        }
        return result;
    }
    
    /**
     * 生成新的序列号
     * @param type
     * @param serialNumber
     * @return
     */
    public String getNewCode() {
        String type = "CT";
        String code = baseMapper.findMaxCode();
        
        StringBuffer sb = new StringBuffer();
        DateFormat sdf = new SimpleDateFormat("yyyyMMddHH");
        String time = sdf.format(new Date());
        sb.append(type);
        sb.append(time);
        
        if(code != null && code.length() == 16) {
            String serialNumber = code.substring(code.length() - 4);
            int serialNum = Integer.parseInt(serialNumber) + 1;
            sb.append(String.format("%04d", serialNum));
        } else {
            sb.append("0001");
        }
        return sb.toString();
    }

    @Override
    public String findMaxCode() {
        return baseMapper.findMaxCode();
    }

    @Override
    public Page<Canteen> findChooseCanteenList(Page<Canteen> page, Map<String, Object> paramMap) {
        page.setRecords(baseMapper.findChooseCanteenList(page, paramMap));
        return page;
    }
}
