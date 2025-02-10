package tech.backend.magalums.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.backend.magalums.entity.Channel;

public interface ChannelRepository extends JpaRepository<Channel, Long> {
}
