package com.eiqle.qleimg.portal.controller;

import com.eiqle.qleimg.portal.service.ImgDifferenceService;
import com.eiqle.qleimg.common.util.ResponseResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Api(value = "图像做差处理")
@RestController
@RequestMapping("/portal")
public class ImgDifferenceController {
    @Autowired
    private ImgDifferenceService differenceService;

    @ApiOperation(value = "图像做差")
    @PostMapping(value = "/difference",headers = "content-type=multipart/form-data")
    public ResponseResultUtil difference(@RequestParam("image0") MultipartFile image0,
                                         @RequestParam("image1") MultipartFile image1) {
        System.out.println(image0.getOriginalFilename());
        System.out.println(image1.getOriginalFilename());
        String ossPath = differenceService.difference(image0, image1);
        return ResponseResultUtil.success(ossPath);
    }
}
