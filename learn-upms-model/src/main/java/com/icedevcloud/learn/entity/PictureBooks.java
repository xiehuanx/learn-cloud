package com.icedevcloud.learn.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author XiaoBingBy
 * @since 2021-07-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("learn_picture_books")
@ApiModel(value="PictureBooks对象", description="")
public class PictureBooks implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "绘本名称")
    private String pictureBookName;

    @ApiModelProperty(value = "logo")
    private String pictureBookImgUrl;

    @ApiModelProperty(value = "绘本pdf地址")
    private String pictureBookPdfUrl;

    @ApiModelProperty(value = "绘本音频，保留字段，应该不会用； 音频和pdf处于相同的位置，前端主动去拼接地址")
    private String pictureBookAudioUrl;

    @ApiModelProperty(value = "=0,3-6岁；=1，6-9岁")
    private Integer pictureBookType;

    @ApiModelProperty(value = "创建时间")
    private Date gmtCreate;

    @ApiModelProperty(value = "更新时间")
    private Date gmtModified;


}
