package com.kulesha.lc_helpdesk_bot.sender;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.bots.DefaultBotOptions;

@Slf4j
@Component
public class LcHelpdeskBotSender extends DefaultAbsSender {

    @Value("${bot.token}")
    private String botToken;

    protected LcHelpdeskBotSender() {
        super(new DefaultBotOptions());
    }

    @Override
    public String getBotToken() {
        return botToken;
    }
}
