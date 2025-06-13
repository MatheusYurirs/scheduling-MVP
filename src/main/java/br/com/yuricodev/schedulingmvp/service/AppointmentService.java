package br.com.yuricodev.schedulingmvp.service;

import br.com.yuricodev.schedulingmvp.entity.Appointment;
import br.com.yuricodev.schedulingmvp.entity.Enums.TypeStatus;
import br.com.yuricodev.schedulingmvp.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final AvailableSlotService availableSlotService;


    public AppointmentService(AppointmentRepository appointmentRepository, AvailableSlotService availableSlotService) {
        this.appointmentRepository = appointmentRepository;
        this.availableSlotService = availableSlotService;
    }

    public Appointment createAppointment(Appointment request){
        if(!availableSlotService.isSlotAvailable(request.getDateTime())){
            throw new RuntimeException("Horário já ocupado");
        }

        Appointment appointment = new Appointment();
        appointment.setDateTime(request.getDateTime());
        appointment.setClientName(request.getClientName());
        if(request.getStatus() != null) {
            appointment.setStatus(request.getStatus());
        }
        else {
            appointment.setStatus(TypeStatus.AGENDADO);
        }

        Appointment saveAppointment = appointmentRepository.save(appointment);

        availableSlotService.markSlotAsTaken(request.getDateTime());

        return saveAppointment;
    }

    public List<Appointment> getAppointmnet(){
        List<Appointment> appointments = appointmentRepository.findAll();
        return appointments;
    }

    public void deleteAppointment(Long id) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agendamento não encontrado"));

        availableSlotService.markSlotAsFree(appointment.getDateTime());
        appointmentRepository.deleteById(id);
    }


}
