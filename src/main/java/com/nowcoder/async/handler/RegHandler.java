package com.nowcoder.async.handler;

import com.nowcoder.async.EventHandler;
import com.nowcoder.async.EventModel;
import com.nowcoder.async.EventType;
import com.nowcoder.model.Message;
import com.nowcoder.service.MessageService;
import com.nowcoder.util.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author KnoWsea
 * @create 2019-03-13 11:24
 */
@Component
public class RegHandler implements EventHandler {
    @Autowired
    MessageService messageService;

    @Autowired
    MailSender mailSender;

    @Override
    public void doHandle(EventModel model) {
        Message message = new Message();
        message.setToId(model.getActorId());
        message.setContent("你注册的ip存在异常");
        // SYSTEM ACCOUNT
        message.setFromId(3);
        message.setCreatedDate(new Date());
        messageService.addMessage(message);

        Map<String, Object> map = new HashMap();
        map.put("username", model.getExt("username"));
        mailSender.sendWithHTMLTemplate(model.getExt("to"), "注册异常",
                "mails/welcome.html", map);
    }

    @Override
    public List<EventType> getSupportEventTypes() {
        return Arrays.asList(EventType.LOGIN);
    }
}
