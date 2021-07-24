package com.icedevcloud.common.controller;

import com.icedevcloud.common.core.api.Assert;
import com.icedevcloud.common.core.api.R;
import com.icedevcloud.cos.vo.QcloudCosUploadResVo;
import com.icedevcloud.util.CosFileUpload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author XiaoBingBy
 * @since 2020-05-22 23:13
 */
@Slf4j
@RestController
@RequestMapping("/api/")
public class UploadFileController {

    @Autowired
    private CosFileUpload cosFileUpload;

    @PostMapping("uploadFile")
    public R<QcloudCosUploadResVo> uploadFile(@RequestParam("file") MultipartFile file) {
        QcloudCosUploadResVo qcloudCosUploadResVo = null;
        try {
            qcloudCosUploadResVo = cosFileUpload.uploadFile(file);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("上传失败，请重试！");
        }
        return R.ok(qcloudCosUploadResVo);
    }

}
