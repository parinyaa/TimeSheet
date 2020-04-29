package com.project.time.sheet.module.attendance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.time.sheet.common.models.ResponseModel;      
import com.project.time.sheet.entity.Attendance;
import com.project.time.sheet.module.attendance.models.request.ReqInsertAttendance;
import com.project.time.sheet.module.attendance.service.AttendanceService;



import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/attendance")

public class AttendanceController {
    
    @Autowired
    AttendanceService attendanceService;

    @RequestMapping(value = "/inquiry", method = RequestMethod.GET)
	public ResponseEntity<ResponseModel<List<Attendance>>> inquiry(){
		ResponseModel<List<Attendance>> res = new ResponseModel<List<Attendance>>();
		res = attendanceService.inquiryAttendance();
		return ResponseEntity.ok(res);
    }
    

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ResponseEntity<ResponseModel> insert(@RequestBody ReqInsertAttendance req){
		
		ResponseModel res = new ResponseModel();
		
		res = attendanceService.insertAttendance(req);
		
		return ResponseEntity.ok(res);
	}
}