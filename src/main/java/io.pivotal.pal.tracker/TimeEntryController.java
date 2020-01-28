package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {

    TimeEntryRepository tER;


    public TimeEntryController(TimeEntryRepository timeEntryRepository)
    {
        this.tER = timeEntryRepository;
    }


    public ResponseEntity create(TimeEntry timeEntryToCreate) {

        TimeEntry timeEntry = tER.create(timeEntryToCreate);
        ResponseEntity response = new ResponseEntity(timeEntry, HttpStatus.CREATED);
        return response;
    }


    public ResponseEntity<List<TimeEntry>> list() {
        List<TimeEntry> timeEntry = tER.list();
        ResponseEntity response = new ResponseEntity(timeEntry, HttpStatus.OK);
        return response;
    }


    public ResponseEntity<TimeEntry> read(long nonExistentTimeEntryId) {
        TimeEntry timeEntry = tER.find(nonExistentTimeEntryId);
        ResponseEntity response;

        if(timeEntry == null){
           return response = new ResponseEntity(timeEntry, HttpStatus.NOT_FOUND);
        }
        else
        {
            return response = new ResponseEntity(timeEntry, HttpStatus.OK);
        }
    }


    public ResponseEntity update(long timeEntryId, TimeEntry expected) {
        TimeEntry timeEntry = tER.update(timeEntryId, expected);
        ResponseEntity response;

        if(timeEntry == null){
            return response = new ResponseEntity(timeEntry, HttpStatus.NOT_FOUND);
        }
        else
        {
            return response = new ResponseEntity(timeEntry, HttpStatus.OK);
        }
    }


    public ResponseEntity delete(long timeEntryId) {
        tER.delete(timeEntryId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
