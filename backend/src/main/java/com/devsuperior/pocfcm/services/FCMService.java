package com.devsuperior.pocfcm.services;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.devsuperior.pocfcm.dto.PushNotificationRequestDTO;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Service
public class FCMService {

	private Logger logger = LoggerFactory.getLogger(FCMService.class);

	@PostConstruct
	public void initialize() throws IOException {
		FirebaseOptions options = FirebaseOptions.builder().setCredentials(GoogleCredentials.getApplicationDefault()).build();
		FirebaseApp.initializeApp(options);
	}

	public void sendMessageToToken(PushNotificationRequestDTO request) throws InterruptedException, ExecutionException {
		Message message = getPreconfiguredMessageToToken(request);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonOutput = gson.toJson(message);
		String response = sendAndGetResponse(message);
		logger.info("Sent message to token. Device token: " + request.getToken() + ", " + response + " msg " + jsonOutput);
	}

	private String sendAndGetResponse(Message message) throws InterruptedException, ExecutionException {
		return FirebaseMessaging.getInstance().sendAsync(message).get();
	}

	private Message getPreconfiguredMessageToToken(PushNotificationRequestDTO request) {
		return getPreconfiguredMessageBuilder(request).setToken(request.getToken()).build();
	}

	private Message.Builder getPreconfiguredMessageBuilder(PushNotificationRequestDTO request) {
		Notification notification = Notification.builder().setTitle(request.getTitle()).setBody(request.getMessage()).build();
		return Message.builder().setNotification(notification);
	}
}
