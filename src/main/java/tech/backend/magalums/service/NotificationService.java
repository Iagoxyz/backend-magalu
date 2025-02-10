package tech.backend.magalums.service;

import org.springframework.stereotype.Service;
import tech.backend.magalums.controller.dto.ScheduleNotificationDTO;
import tech.backend.magalums.entity.Notification;
import tech.backend.magalums.entity.Status;
import tech.backend.magalums.repository.NotificationRepository;

import java.util.Optional;

@Service
public class NotificationService {

    public final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public void scheduleNotification(ScheduleNotificationDTO dto) {
        notificationRepository.save(dto.toNotification());
    }

    public Optional<Notification> findById(Long notificationId) {
        return notificationRepository.findById(notificationId);
    }

    public void cancelNotification(Long notificationId) {
        var notification = findById(notificationId);

        if (notification.isPresent()) {
            notification.get().setStatus(Status.Values.CANCELED.toStatus());
            notificationRepository.save(notification.get());
        }
    }
}
