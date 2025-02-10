package tech.backend.magalums.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.backend.magalums.entity.Status;

public interface StatusRepository extends JpaRepository<Status, Long> {
}
