package com.kulesha.lc_helpdesk_bot.handler.impl;

import com.kulesha.lc_helpdesk_bot.enums.ConversationState;
import com.kulesha.lc_helpdesk_bot.handler.UserRequestHandler;
import com.kulesha.lc_helpdesk_bot.model.UserRequest;
import com.kulesha.lc_helpdesk_bot.model.UserSession;
import com.kulesha.lc_helpdesk_bot.service.TelegramService;
import com.kulesha.lc_helpdesk_bot.service.UserSessionService;
import org.springframework.stereotype.Component;

@Component
public class FeedbackEnteredHandler extends UserRequestHandler {

    private final TelegramService telegramService;
//    private final KeyboardHelper keyboardHelper;
    private final UserSessionService userSessionService;

    public FeedbackEnteredHandler(TelegramService telegramService, UserSessionService userSessionService) {
        this.telegramService = telegramService;
        this.userSessionService = userSessionService;
    }

    @Override
    public boolean isApplicable(UserRequest request) {
        return isTextMessage(request.getUpdate())
                && ConversationState.WAITING_FOR_FEEDBACK.equals(request.getUserSession().getState());
    }

    @Override
    public void handle(UserRequest userRequest) {
        telegramService.sendMessage(userRequest.getChatId(),"Дякую, ваш відгук було передано авторам \uD83D\uDE09");
        UserSession session = userRequest.getUserSession();
        session.setState(ConversationState.CONVERSATION_STARTED);
        userSessionService.saveSession(userRequest.getChatId(), session);
    }

    @Override
    public boolean isGlobal() {
        return false;
    }
}
