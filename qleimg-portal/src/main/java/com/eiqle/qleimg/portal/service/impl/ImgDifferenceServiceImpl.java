package com.eiqle.qleimg.portal.service.impl;

import cn.hutool.core.date.DateUtil;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectRequest;
import com.eiqle.qleimg.portal.dao.ImgDifferenceDao;
import com.eiqle.qleimg.portal.entity.ImgDifference;
import com.eiqle.qleimg.portal.service.ImgDifferenceService;
import org.bytedeco.javacpp.opencv_core;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StreamUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.ByteBuffer;
import java.util.Date;
import java.util.UUID;

/**
 * 图像做差Service实现类
 */
@Service
public class ImgDifferenceServiceImpl implements ImgDifferenceService {
    @Value("${aliyun.oss.host}")
    private String host;
    @Value("${aliyun.oss.bucketName}")
    private String bucketName;
    @Value("${aliyun.oss.dir.prefix}")
    private String dir;
    @Autowired
    private OSSClient ossClient;
    @Autowired
    private ImgDifferenceDao differenceDao;

    @Override
    public String difference(MultipartFile image0, MultipartFile image1) {
        //导入dll
        String relativelyPath = System.getProperty("user.dir");
        System.load(relativelyPath + "/opencv_java340-x64.dll");
        System.out.println("图像做差开始。。。");
        String imagename0 = image0.getOriginalFilename();
        String imagename1 = image1.getOriginalFilename();
        String path0 = null;
        String path1 = null;
        File filepath = null;
        try {
            //存储图像
            String pathPrefix = (ResourceUtils.getURL("classpath:").getPath()+"static/images/").substring(1);
            path0 = pathPrefix+imagename0;
            path1 = pathPrefix+imagename1;
            StreamUtils.copy(image0.getInputStream(),new FileOutputStream(path0));
            StreamUtils.copy(image1.getInputStream(),new FileOutputStream(path1));

            //读取图像
            Mat img0 = Imgcodecs.imread(path0);
            Mat img1 = Imgcodecs.imread(path1);

            Mat result = new Mat();
            //像素做差
            Core.absdiff(img0, img1, result);
            //存储生成图像

            String imgName = DateUtil.today() + "-" + UUID.randomUUID().toString().substring(0,8)+".jpg";
            String generatePathPrefix = pathPrefix + "generate/";
            filepath = new File(generatePathPrefix);
            if(!filepath.exists()){
                filepath.mkdirs();
            }
            String generatePath = generatePathPrefix + imgName;
            Imgcodecs.imwrite(generatePath, result);

            //上传到OSS
            String ossFilePath = dir+"difgenerate/"+DateUtil.today()+"/"+imgName;
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName,
                    ossFilePath,
                    new File(generatePath));
            ossClient.putObject(putObjectRequest);

            //存储数据到数据库
            ImgDifference imgDifference = new ImgDifference();
            imgDifference.setName(imgName);
            imgDifference.setFilepath(host+ossFilePath);

            differenceDao.insertDifference(imgDifference);
            return host+ossFilePath;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            File file0 = new File(path0);
            File file1= new File(path1);
            file0.delete();
            file1.delete();
        }
        return null;
    }
}
