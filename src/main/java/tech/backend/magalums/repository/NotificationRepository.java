package tech.backend.magalums.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.backend.magalums.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
