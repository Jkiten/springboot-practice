package com.kiyeol.service;


import com.kiyeol.repository.WorkLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class WorkLogService {
    @Autowired
    private WorkLogRepository workLogRepository;
}
