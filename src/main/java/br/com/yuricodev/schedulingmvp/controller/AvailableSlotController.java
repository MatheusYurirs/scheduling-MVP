package br.com.yuricodev.schedulingmvp.controller;

import br.com.yuricodev.schedulingmvp.entity.AvailableSlot;
import br.com.yuricodev.schedulingmvp.service.AvailableSlotService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/slots")
public class AvailableSlotController {

    private final AvailableSlotService availableSlotService;

    public AvailableSlotController(AvailableSlotService availableSlotService) {
        this.availableSlotService = availableSlotService;
    }

    @GetMapping("/available")
    public ResponseEntity<List<AvailableSlot>> getAvailable(@RequestParam("date")
                                                            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<AvailableSlot> availableSlots = availableSlotService.getAvailableSlots(date);
        return ResponseEntity.ok(availableSlots);
    }

    @GetMapping("/check")
    public ResponseEntity<Boolean> isSlotAvailabe(@RequestParam("datetime")
                                                  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTime
    ) {
        boolean available = availableSlotService.isSlotAvailable(dateTime);
        return ResponseEntity.ok(available);
    }

    @PostMapping
    public ResponseEntity<AvailableSlot> createSlot(@RequestBody AvailableSlot availableSlot){
        AvailableSlot slot = availableSlotService.createSlot(availableSlot.getDateTime());
        return ResponseEntity.status(HttpStatus.CREATED).body(slot);
    }


}
