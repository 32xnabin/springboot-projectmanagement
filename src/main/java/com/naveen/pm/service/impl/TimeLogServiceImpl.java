package com.naveen.pm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naveen.pm.model.TimeLog;
import com.naveen.pm.repository.TimeLogRepository;
import com.naveen.pm.service.TimeLogService;
@Service
public class TimeLogServiceImpl implements TimeLogService{

    @Autowired
    private TimeLogRepository timeLogRepository;

    @Override
    public List<TimeLog> getTimeLogList() {
        return timeLogRepository.findAll();
    }

    @Override
    public TimeLog findTimeLogById(long id) {
        return timeLogRepository.findById(id);
    }

    @Override
    public void save(TimeLog timeLog) {
    	timeLogRepository.save(timeLog);
    }

    @Override
    public void edit(TimeLog timeLog) {
    	timeLogRepository.save(timeLog);
    }

    @Override
    public void delete(long id) {
    	timeLogRepository.deleteById(id);
    }
}
