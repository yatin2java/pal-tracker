package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{

    private Long id = 0L;

    private HashMap<Long, TimeEntry> map=  new HashMap<Long, TimeEntry>();

    @Override
    public TimeEntry create(TimeEntry timeEntry)
    {
       id = id+1;
       TimeEntry te = new TimeEntry(id, timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());
       map.put(id, te);
       return te;
    }

    @Override
    public TimeEntry find(Long getId)
    {
        TimeEntry te = map.get(getId);
        return te;
    }

    @Override
    public List list()
    {
       List ls = new ArrayList();
       ls.addAll(map.values());
       return ls;
    }

    @Override
    public TimeEntry update(long iD, TimeEntry timeEntry) {

        TimeEntry tt = new TimeEntry(id, timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());
        map.put(id,tt);
        return map.get(iD);
    }

    @Override
    public void delete(long id) {
        map.remove(id);
    }
}
