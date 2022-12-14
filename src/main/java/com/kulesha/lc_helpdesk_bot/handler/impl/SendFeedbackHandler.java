package com.kulesha.lc_helpdesk_bot.handler.impl;

import com.kulesha.lc_helpdesk_bot.enums.ConversationState;
import com.kulesha.lc_helpdesk_bot.handler.UserRequestHandler;
import com.kulesha.lc_helpdesk_bot.model.UserRequest;
import com.kulesha.lc_helpdesk_bot.model.UserSession;
import com.kulesha.lc_helpdesk_bot.service.TelegramService;
import com.kulesha.lc_helpdesk_bot.service.UserSessionService;
import org.springframework.stereotype.Component;

@Component
public class SendFeedbackHandler extends UserRequestHandler {

    private static String command = "/sendfeedback";

    private final TelegramService telegramService;
    private final UserSessionService userSessionService;

    public SendFeedbackHandler(TelegramService telegramService, UserSessionService userSessionService) {
        this.telegramService = telegramService;
        this.userSessionService = userSessionService;
    }

    @Override
    public boolean isApplicable(UserRequest request) {
        return isCommand(request.getUpdate(), command);
    }

    @Override
    public void handle(UserRequest userRequest) {

        UserSession userSession = userRequest.getUserSession();
        userSession.setState(ConversationState.WAITING_FOR_FEEDBACK);
        userSessionService.saveSession(userSession.getChatId(), userSession);

        telegramService.sendMessage(userRequest.getChatId(),
                "Напишіть ваш відгук/побажання!");
    }

    @Override
    public boolean isGlobal() {
        return true;
    }
}
