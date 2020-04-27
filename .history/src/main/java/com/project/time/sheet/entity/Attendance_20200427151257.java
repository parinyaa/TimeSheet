package com.project.time.sheet.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name = "Attendance")
public class Attendance {
    @Id
	@Column(name="PARAM_GROUP_ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}