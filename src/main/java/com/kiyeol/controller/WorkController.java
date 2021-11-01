package com.kiyeol.controller;

import com.kiyeol.domain.Report;
import com.kiyeol.domain.ReportParam;
import com.kiyeol.domain.User;
import com.kiyeol.domain.WorkLog;
import com.kiyeol.domain.WorkParam;
import com.kiyeol.repository.UserRepository;
import com.kiyeol.repository.WorkLogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@Controller
public class WorkController {
    @Autowired
    private WorkLogRepository workLogRepository;
    @Autowired
    private UserRepository userRepository;
    //운동저장
    @PostMapping("/work-save")
    public ResponseEntity SaveWorkLog(@Validated @RequestBody WorkParam workParam){
        WorkLog newWorkLog = new WorkLog();
        try{
            Optional<User> selectUser = userRepository.findById(workParam.getUser_id());
            if(selectUser!=null){
                newWorkLog.setUser_id(selectUser.get());
                newWorkLog.setStart_latitude(workParam.getStart_latitude());
                newWorkLog.setStart_Longitude(workParam.getStart_Longitude());
                newWorkLog.setDesti_latitude(workParam.getDesti_latitude());
                newWorkLog.setDesti_Longitude(workParam.getDesti_Longitude());

                WorkLog result = workLogRepository.save(newWorkLog);
                return ResponseEntity.status(HttpStatus.CREATED).body(result);
            }
            else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }


}
