package br.com.yuricodev.schedulingmvp.repository;

import br.com.yuricodev.schedulingmvp.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
