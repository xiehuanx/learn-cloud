package com.icedevcloud.util;

import com.icedevcloud.learn.entity.InvitationCode;
import com.icedevcloud.learn.service.IInvitationCodeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * author :xiehuan
 * Email: 1487471733@qq.com
 * Date: 2021/7/24
 * Describe:
 * 邀请码 工具类
 */
@Component
@Slf4j
public class InvitationCodeUtil {

    private static final List<String> InvitationCodeList = new ArrayList<>(512);

    @Autowired
    private IInvitationCodeService invitationCodeService;

    /**
     * 验证码邀请码是否正确
     * @param invitationCode 邀请码
     * @return true 正常；false 不正常的邀请码
     */
    public static boolean VerificationCode(String invitationCode){
        return InvitationCodeList.contains(invitationCode);
    }

    /**
     * 从数据库中取出邀请码，然后放到内存中
     */
    @PostConstruct
    public void init(){
        List<InvitationCode> invitationCodes = invitationCodeService.list();
        List<String> strings = invitationCodes.stream().map(InvitationCode::getInvitationCode).collect(Collectors.toList());
        InvitationCodeList.addAll(strings);
    }

}
