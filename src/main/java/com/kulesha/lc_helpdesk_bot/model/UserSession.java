package com.kulesha.lc_helpdesk_bot.model;

import com.kulesha.lc_helpdesk_bot.enums.ConversationState;
import org.telegram.telegrambots.meta.api.objects.Update;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserSession {
    private Long chatId;
    private ConversationState state;
    private String city;
    private String text;
}
