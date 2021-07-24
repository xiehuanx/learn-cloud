package com.icedevcloud.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * author :xiehuan
 * Email: 1487471733@qq.com
 * Date: 2021/4/24
 * Describe:
 */
@Slf4j
@Component
public class CpMatchSendMsgListener implements ApplicationListener<CpMatchSendMsgEvent> {


    @Override
    public void onApplicationEvent(CpMatchSendMsgEvent event) {

    }
}
