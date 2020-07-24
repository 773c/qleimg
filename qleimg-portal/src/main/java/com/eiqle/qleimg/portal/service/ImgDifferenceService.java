package com.eiqle.qleimg.portal.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * 图像做差Service
 */
public interface ImgDifferenceService {
    /**
     * 图像做差
     * @param image0
     * @param image1
     */
    String difference(MultipartFile image0, MultipartFile image1);

}
