package br.com.yuricodev.schedulingmvp.service;

import br.com.yuricodev.schedulingmvp.entity.AvailableSlot;
import br.com.yuricodev.schedulingmvp.repository.AvailableSlotRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AvailableSlotService {

    private final AvailableSlotRepository availableSlotRepository;

    public AvailableSlotService(AvailableSlotRepository availableSlotRepository) {
        this.availableSlotRepository = availableSlotRepository;
    }

    public List<AvailableSlot> getAvailableSlots(LocalDate date){
        LocalDateTime start = date.atStartOfDay();
        LocalDateTime end = date.plusDays(1).atStartOfDay();
        return availableSlotRepository.findAllByIsTakenFalseAndDateTimeBetween(start, end);
    }

    public AvailableSlot createSlot(LocalDateTime dateTime){
        if (availableSlotRepository.findByDateTime(dateTime).isPresent()) {
            throw new RuntimeException("Esse horário já existe.");
        }

        AvailableSlot slot = new AvailableSlot();
        slot.setDateTime(dateTime);
        slot.setTaken(false);
        return availableSlotRepository.save(slot);
    }

    public void deleteSlot(Long id){
        availableSlotRepository.deleteById(id);
    }

    public boolean isSlotAvailable(LocalDateTime dateTime){
        return availableSlotRepository.findByDateTime(dateTime)
                .map(slot -> !slot.isTaken())
                .orElse(false);
    }

    public void markSlotAsTaken(LocalDateTime dateTime) {
        AvailableSlot slot = availableSlotRepository.findByDateTime(dateTime)
                .orElseThrow(() -> new RuntimeException("Slot não encontrado"));

        if(slot.isTaken()){
            throw new RuntimeException("Esté horário já está ocupado.");
        }

        slot.setTaken(true);
        availableSlotRepository.save(slot);
    }

    public void markSlotAsFree(LocalDateTime dateTime) {
        AvailableSlot slot = availableSlotRepository.findByDateTime(dateTime)
                .orElseThrow(() -> new RuntimeException("Slot não encontrado"));

        slot.setTaken(false);
        availableSlotRepository.save(slot);
    }
}
