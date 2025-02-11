package tech.backend.magalums.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.backend.magalums.entity.Notification;
import tech.backend.magalums.entity.Status;

import java.time.LocalDateTime;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByStatusInAndDateTimeBefore(List<Status> status, LocalDateTime dateTime);
}
