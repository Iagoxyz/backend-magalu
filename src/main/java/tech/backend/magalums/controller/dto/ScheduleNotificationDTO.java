package tech.backend.magalums.controller.dto;

import tech.backend.magalums.entity.Channel;
import tech.backend.magalums.entity.Notification;
import tech.backend.magalums.entity.Status;

import java.time.LocalDateTime;

public record ScheduleNotificationDTO(LocalDateTime dateTime,
                                      String destination,
                                      String message,
                                      Channel.Values channel) {

    public Notification toNotification() {
        return new Notification(
                dateTime,
                destination,
                message,
                channel.toChannel(),
                Status.Values.PENDING.toStatus()
        );
    }
}
