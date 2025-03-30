package com.bank.Bank.Transiction.API.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bank.Bank.Transiction.API.domain.user.User;
import com.bank.Bank.Transiction.API.dto.NotificationDTO;

@Service
public class NotificationService {
    @Autowired
    private RestTemplate restTemplate;

    public void sendNotification (User user, String message) throws Exception {
        String email = user.getEmail();
        NotificationDTO notificationRequest = new NotificationDTO(email, message);
        String urlNotificationMessage = "https://util.devi.tools/api/v1/notify";

        /*ResponseEntity<String> notificationResponse = restTemplate.postForEntity(urlNotificationMessage, notificationRequest, String.class);

        if (!(notificationResponse.getStatusCode() == HttpStatus.OK)) {
            System.out.println("Erro ao enviar notificação");
            throw new Exception("Serviço de notificação indisponível");
        }*/

        System.out.println("Notificação enviada para o usuário");
        
    }
}
