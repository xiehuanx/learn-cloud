package com.icedevcloud.event;

import org.springframework.context.ApplicationEvent;

/**
 * author :xiehuan
 * Email: 1487471733@qq.com
 * Date: 2021/4/24
 * Describe:
 */
public class CpMatchSendMsgEvent extends ApplicationEvent {
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public CpMatchSendMsgEvent(Object source) {
        super(source);
    }
}
