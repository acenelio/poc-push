package com.devsuperior.pocfcm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.pocfcm.dto.PushNotificationRequestDTO;
import com.devsuperior.pocfcm.services.NotificationService;

@RestController
@RequestMapping(value = "/notifications")
public class NotificationController {

	@Autowired
	private NotificationService notificationService;
	
	@PostMapping
	public ResponseEntity<Void> sendNotification(@RequestBody PushNotificationRequestDTO dto) {
		notificationService.sendNotification(dto);
		return ResponseEntity.noContent().build();
	}
}
