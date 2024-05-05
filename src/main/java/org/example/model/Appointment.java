package org.example.model;

import lombok.Data;

import java.util.UUID;

@Data
public class Appointment {
    private UUID id;

    private UUID calendar_id;
    private String start;
    private String end;

    private UUID patient_id;

    private String patient_comment;
    private String note;

    private UUID time_slot_type_id;

    private UUID type_id;
    private Integer state;
    private String out_of_office_location;
    private Boolean out_of_office;
    private Boolean completed;
    private Boolean is_scheduled;


}
