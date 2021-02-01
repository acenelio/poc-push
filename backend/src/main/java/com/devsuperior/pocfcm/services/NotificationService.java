package com.devsuperior.pocfcm.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.pocfcm.dto.PushNotificationRequestDTO;

@Service
public class NotificationService {

	private Logger logger = LoggerFactory.getLogger(NotificationService.class);
	
	@Autowired
	private FCMService fcmService;
	
	public void sendNotification(PushNotificationRequestDTO dto) {
		try {
			fcmService.sendMessageToToken(dto);
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
	}	
}
