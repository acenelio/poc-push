package com.devsuperior.pocfcm.services;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Service
public class FCMService {

	private Logger logger = LoggerFactory.getLogger(FCMService.class);

	@PostConstruct
	public void initialize() throws IOException {
		FirebaseOptions options = FirebaseOptions.builder().setCredentials(GoogleCredentials.getApplicationDefault()).build();
		FirebaseApp.initializeApp(options);
	}
}
