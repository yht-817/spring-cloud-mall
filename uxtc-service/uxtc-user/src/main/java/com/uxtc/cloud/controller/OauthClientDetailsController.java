package com.uxtc.cloud.controller;

import com.uxtc.cloud.common.api.CommonResult;
import com.uxtc.cloud.entity.OauthClientDetails;
import com.uxtc.cloud.service.OauthClientDetailsService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 客户端详细信息表(OauthClientDetails)表控制层
 *
 * @author 鱼仔
 * @since 2021-06-10 16:53:20
 */
@RestController
@RequestMapping("/client")
@Api(tags = "OauthClientDetailsController 客户端信息配置")
public class OauthClientDetailsController {
    /**
     * 服务对象
     */
    @Resource
    private OauthClientDetailsService oauthClientDetailsService;


    /**
     * 新增
     *
     * @author 鱼仔
     * @date 2021/06/10
     **/
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public CommonResult<Object> insert(OauthClientDetails oauthClientDetails) {
        OauthClientDetails insert = oauthClientDetailsService.insert(oauthClientDetails);
        return CommonResult.success(insert);
    }

    /**
     * 刪除
     *
     * @author 鱼仔
     * @date 2021/06/10
     **/
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public CommonResult<Object> delete(String id) {
        boolean b = oauthClientDetailsService.deleteById(id);
        if (b) {
            return CommonResult.success("");
        }
        return CommonResult.failed();
    }

    /**
     * 更新
     *
     * @author 鱼仔
     * @date 2021/06/10
     **/
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public CommonResult<Object> update(OauthClientDetails oauthClientDetails) {
        OauthClientDetails update = oauthClientDetailsService.update(oauthClientDetails);
        return CommonResult.success(update);
    }

    /**
     * 查询 根据主键 id 查询
     *
     * @author 鱼仔
     * @date 2021/06/10
     **/
    @RequestMapping(value = "/load", method = RequestMethod.GET)
    public CommonResult<Object> load(String id) {
        OauthClientDetails oauthClientDetails = oauthClientDetailsService.queryById(id);
        return CommonResult.success(oauthClientDetails);
    }

    /**
     * 查询 分页查询
     *
     * @author 鱼仔
     * @date 2021/06/10
     **/
    @RequestMapping(value = "/pageList", method = RequestMethod.GET)
    public CommonResult<Object> pageList(@RequestParam(required = false, defaultValue = "0") int offset,
                                         @RequestParam(required = false, defaultValue = "10") int pagesize) {
        List<OauthClientDetails> oauthClientDetails = oauthClientDetailsService.queryAllByLimit(offset, pagesize);
        return CommonResult.success(oauthClientDetails);
    }
}