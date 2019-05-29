
package com.naveen.pm.service;

import java.util.List;

import com.naveen.pm.model.TimeLog;

public interface TimeLogService {

    public List<TimeLog> getTimeLogList();

    public TimeLog findTimeLogById(long id);

    public void save(TimeLog timeLog);

    public void edit(TimeLog timeLog);

    public void delete(long id);


}

