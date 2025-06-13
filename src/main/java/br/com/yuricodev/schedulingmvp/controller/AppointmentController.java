package br.com.yuricodev.schedulingmvp.controller;

import br.com.yuricodev.schedulingmvp.entity.Appointment;
import br.com.yuricodev.schedulingmvp.service.AppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment){
        Appointment create = appointmentService.createAppointment(appointment);
        return ResponseEntity.status(HttpStatus.CREATED).body(create);
    }

    @GetMapping("/getAppointments")
    public ResponseEntity<List<Appointment>> getAllAppointments(){
        List<Appointment> appointments = appointmentService.getAppointmnet();
        return ResponseEntity.ok(appointments);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id){
         appointmentService.deleteAppointment(id);
        return ResponseEntity.noContent().build();

    }
}
