package com.eiqle.qleimg.portal.dao;

import com.eiqle.qleimg.portal.entity.ImgDifference;

/**
 * 图像做差Dao
 */
public interface ImgDifferenceDao {
    /**
     * 存入生成的图像
     * @param imgDifference
     */
    void insertDifference(ImgDifference imgDifference);
}
