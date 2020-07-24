package com.eiqle.qleimg.portal.controller;


import com.eiqle.qleimg.common.util.ResponseResultUtil;
import com.eiqle.qleimg.portal.entity.OssCallback;
import com.eiqle.qleimg.portal.entity.OssPolicy;
import com.eiqle.qleimg.portal.service.OssService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Oss相关操作接口
 */
@Api(tags = "OssController", description = "Oss管理")
@RestController
@RequestMapping("/aliyun/oss")
public class OssController {
    @Autowired
    private OssService ossService;

    @ApiOperation(value = "oss上传签名生成")
    @RequestMapping(value = "/policy", method = RequestMethod.GET)
    public ResponseResultUtil policy() {
        System.out.println("oss上传签名中");
        OssPolicy ossPolicy = ossService.policy();
        return ResponseResultUtil.success(ossPolicy);
    }

    @ApiOperation(value = "oss上传成功回调")
    @RequestMapping(value = "callback", method = RequestMethod.POST)
    public ResponseResultUtil callback(HttpServletRequest request) {
        System.out.println("oss上传成功回调");
        OssCallback ossCallback = ossService.callback(request);
        return ResponseResultUtil.success(ossCallback);
    }
}
