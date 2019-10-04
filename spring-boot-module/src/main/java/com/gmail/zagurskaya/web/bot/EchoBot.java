package com.gmail.zagurskaya.web.bot;

import com.gmail.zagurskaya.service.CityService;
import com.gmail.zagurskaya.service.model.CityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

import javax.annotation.PostConstruct;

/**
 * Класс-обработчик поступающих к боту сообщений.
 */
@Component
public class EchoBot extends TelegramLongPollingBot {
    @Autowired
    private CityService cityService;

    @PostConstruct
    void init() {
        TelegramBotsApi botsApi = new TelegramBotsApi();
        try {
            botsApi.registerBot(this);
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод, который возвращает токен, выданный нам ботом @BotFather.
     *
     * @return токен
     */
    @Override
    public String getBotToken() {
        return "907422772:AAHy7I6AHjAu9pDWz8zbQQK0nMrIINV3L-Q";
    }

    /**
     * Метод-обработчик поступающих сообщений.
     *
     * @param update объект, содержащий информацию о входящем сообщении
     */
    @Override
    public void onUpdateReceived(Update update) {
        try {
            if (update.hasMessage() && update.getMessage().hasText()) {
                Message inMessage = update.getMessage();
                SendMessage outMessage = new SendMessage();
                outMessage.setChatId(inMessage.getChatId());
                CityDTO cityDTO = cityService.loadCityByName(inMessage.getText());
                outMessage.setText(cityDTO.getDescription());
                execute(outMessage);
            }
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод, который возвращает имя пользователя бота.
     *
     * @return имя пользователя
     */
    @Override
    public String getBotUsername() {
        return "ZNLEchoBot";
    }
}
