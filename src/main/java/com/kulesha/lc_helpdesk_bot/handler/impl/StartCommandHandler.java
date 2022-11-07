package com.kulesha.lc_helpdesk_bot.handler.impl;

import com.kulesha.lc_helpdesk_bot.handler.UserRequestHandler;
import com.kulesha.lc_helpdesk_bot.model.UserRequest;
import com.kulesha.lc_helpdesk_bot.service.TelegramService;
import org.springframework.stereotype.Component;

@Component
public class StartCommandHandler extends UserRequestHandler {

    private static String command = "/start";

    private final TelegramService telegramService;
//    private final KeyboardHelper keyboardHelper;

    public StartCommandHandler(TelegramService telegramService) {
        this.telegramService = telegramService;
    }

    @Override
    public boolean isApplicable(UserRequest request) {
        return isCommand(request.getUpdate(), command);
    }

    @Override
    public void handle(UserRequest dispatchRequest) {
        telegramService.sendMessage(dispatchRequest.getChatId(),
                "\uD83D\uDC4BПривіт! За допомогою цього чат-бота ви зможете зробити запит про допомогу!");
    }

    @Override
    public boolean isGlobal() {
        return true;
    }
}
