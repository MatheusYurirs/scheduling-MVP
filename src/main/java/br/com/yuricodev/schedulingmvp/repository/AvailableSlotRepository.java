package br.com.yuricodev.schedulingmvp.repository;

import br.com.yuricodev.schedulingmvp.entity.AvailableSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface AvailableSlotRepository extends JpaRepository<AvailableSlot, Long> {

    Optional<AvailableSlot> findByDateTime(LocalDateTime dateTime);

    List<AvailableSlot> findAllByIsTakenFalseAndDateTimeBetween(LocalDateTime start, LocalDateTime end);
}
