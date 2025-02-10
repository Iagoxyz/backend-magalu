package tech.backend.magalums.service;

import org.springframework.stereotype.Service;
import tech.backend.magalums.controller.dto.ScheduleNotificationDTO;
import tech.backend.magalums.entity.Notification;
import tech.backend.magalums.repository.NotificationRepository;

@Service
public class NotificationService {

    public final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public void scheduleNotification(ScheduleNotificationDTO dto) {
        notificationRepository.save(dto.toNotification());
    }
}
