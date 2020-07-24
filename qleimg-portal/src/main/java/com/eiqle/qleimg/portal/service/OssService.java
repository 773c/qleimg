package com.eiqle.qleimg.portal.service;


import com.eiqle.qleimg.portal.entity.OssCallback;
import com.eiqle.qleimg.portal.entity.OssPolicy;

import javax.servlet.http.HttpServletRequest;

/**
 * OSS上传管理Service
 */
public interface OssService {
    /**
     * 生成OSS上传策略
     */
    OssPolicy policy();

    /**
     * 上传成功回调
     */

    OssCallback callback(HttpServletRequest request);
}
