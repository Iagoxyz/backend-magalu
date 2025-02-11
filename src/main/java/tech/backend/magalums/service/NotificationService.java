package tech.backend.magalums.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.backend.magalums.controller.dto.ScheduleNotificationDTO;
import tech.backend.magalums.entity.Notification;
import tech.backend.magalums.entity.Status;
import tech.backend.magalums.repository.NotificationRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Service
public class NotificationService {

    @Autowired
    public NotificationRepository notificationRepository;

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

    public void checkAndSend(LocalDateTime dateTime) {
       var notification = notificationRepository.findByStatusInAndDateTimeBefore(List.of(
                Status.Values.PENDING.toStatus(),
                Status.Values.ERROR.toStatus()), dateTime);

       notification.forEach(sendNotification());
    }

    public Consumer<Notification> sendNotification() {
        return n -> {

            // TODO - realizar o envio da notificação

            n.setStatus(Status.Values.SUCCESS.toStatus());
            notificationRepository.save(n);
        };
    }
}
