package tech.backend.magalums.entity;

import jakarta.persistence.*;

import javax.naming.Name;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_notifications")
public class Notifiication {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long notificationId;
    private LocalDateTime dateTime;
    private String destination;
    private String message;

    private Channel channel;
    private Status status;

}
