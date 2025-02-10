package tech.backend.magalums.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.backend.magalums.controller.dto.ScheduleNotificationDTO;
import tech.backend.magalums.entity.Notification;
import tech.backend.magalums.service.NotificationService;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping
    public ResponseEntity<Void> scheduleNotification(@RequestBody ScheduleNotificationDTO dto) {
        notificationService.scheduleNotification(dto);

        return ResponseEntity.accepted().build();
    }

    @GetMapping("/{notificationId}")
    public ResponseEntity<Notification> getNotification(@PathVariable("notificationId") Long notificationId) {

       var notification =  notificationService.findById(notificationId);

       if(notification.isEmpty()) {
           return ResponseEntity.notFound().build();
       }
       return ResponseEntity.ok(notification.get());
    }
}
