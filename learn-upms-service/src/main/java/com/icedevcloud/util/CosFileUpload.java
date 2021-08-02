package com.icedevcloud.util;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.icedevcloud.config.cos.QcloudCosProperties;
import com.icedevcloud.cos.vo.QcloudCosUploadResVo;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * author :xie
 * Email: 1487471733@qq.com
 * Date: 2020/5/23 19:37
 * Describe:
 */
@Slf4j
@Component
public class CosFileUpload {

    @Autowired
    private QcloudCosProperties qcloudCosProperties;

    @Autowired
    private COSClient cosClient;

    public PutObjectResult upload(String filePath, String key, String bucketName) throws Exception {
        File localFile = new File(filePath);
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
        return putObjectResult;
    }

    public QcloudCosUploadResVo uploadFile(MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());

        FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), file);

        String uuid = IdUtil.fastSimpleUUID();
        DateTime nowDate = DateUtil.date();
        String nowDateFormat = DateUtil.format(nowDate, "yyyy/MM/dd");
        String fileNameSuffix = getFileNameSuffix(multipartFile.getOriginalFilename());
        String fileNameKey = nowDateFormat + "/" + uuid + "." + fileNameSuffix;

        PutObjectRequest putObjectRequest = new PutObjectRequest(qcloudCosProperties.getBucketName(), fileNameKey, file);
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
        file.delete();
        String eTag = putObjectResult.getETag();
        String crc64Ecma = putObjectResult.getCrc64Ecma();

        log.info("eTag: {} crc64Ecma: {} key: {}", eTag, crc64Ecma, fileNameKey);

        QcloudCosUploadResVo qcloudCosUploadResVo = new QcloudCosUploadResVo();
        qcloudCosUploadResVo
                .setETag(eTag)
                .setCrc64Ecma(crc64Ecma)
                .setKey(fileNameKey)
                .setDomainKey(qcloudCosProperties.getDomainName() + fileNameKey);
        return qcloudCosUploadResVo;
    }


    public QcloudCosUploadResVo uploadFile(MultipartFile multipartFile, String unit,String bookName, String fileName) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());

        FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), file);

        String fileNameSuffix = getFileNameSuffix(multipartFile.getOriginalFilename());
        String fileNameKey = bookName + "/" + unit + "/" + fileName + "." + fileNameSuffix;

        PutObjectRequest putObjectRequest = new PutObjectRequest(qcloudCosProperties.getBucketName(), fileNameKey, file);
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
        file.delete();
        String eTag = putObjectResult.getETag();
        String crc64Ecma = putObjectResult.getCrc64Ecma();

        log.info("eTag: {} crc64Ecma: {} key: {}", eTag, crc64Ecma, fileNameKey);

        QcloudCosUploadResVo qcloudCosUploadResVo = new QcloudCosUploadResVo();
        qcloudCosUploadResVo
                .setETag(eTag)
                .setCrc64Ecma(crc64Ecma)
                .setKey(fileNameKey)
                .setDomainKey(qcloudCosProperties.getDomainName() + fileNameKey);
        return qcloudCosUploadResVo;
    }

    private String getFileNameSuffix(String fileName) {
        String[] strArray = fileName.split("\\.");
        int suffixIndex = strArray.length - 1;
        return strArray[suffixIndex];
    }

}
