package com.kulesha.lc_helpdesk_bot.handler.impl;

import com.kulesha.lc_helpdesk_bot.handler.UserRequestHandler;
import com.kulesha.lc_helpdesk_bot.model.UserRequest;
import com.kulesha.lc_helpdesk_bot.service.TelegramService;

public class SendFeedbackHandler extends UserRequestHandler {

    private static String command = "/sendfeedback";

    private final TelegramService telegramService;

    public SendFeedbackHandler(TelegramService telegramService) {
        this.telegramService = telegramService;
    }

    @Override
    public boolean isApplicable(UserRequest request) {

        return isCommand(request.getUpdate(), command);
    }

    @Override
    public void handle(UserRequest dispatchRequest) {
        telegramService.sendMessage(dispatchRequest.getChatId(),
                "Напишіть ваш відгук/побажання.");
    }

    @Override
    public boolean isGlobal() {
        return true;
    }
}
