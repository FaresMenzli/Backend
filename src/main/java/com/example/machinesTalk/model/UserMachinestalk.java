package com.example.machinesTalk.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="user_machinestalk")
public class UserMachinestalk {
    @Id
    private Long id;
    private String name;
    private String email;
    private String gender;
    private String status;
}
