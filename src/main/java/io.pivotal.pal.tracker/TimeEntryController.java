package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {


    TimeEntryRepository tER;


    public TimeEntryController(TimeEntryRepository timeEntryRepository)
    {
        this.tER = timeEntryRepository;
    }


    @PostMapping
    public ResponseEntity create(@RequestBody TimeEntry timeEntryToCreate) {

        TimeEntry timeEntry = tER.create(timeEntryToCreate);
        ResponseEntity response = new ResponseEntity(timeEntry, HttpStatus.CREATED);
        return response;
    }


    @GetMapping
    public ResponseEntity<List<TimeEntry>> list() {
        List<TimeEntry> timeEntry = tER.list();
        ResponseEntity response = new ResponseEntity(timeEntry, HttpStatus.OK);
        return response;
    }


    @GetMapping("{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable Long id) {
        TimeEntry timeEntry = tER.find(id);
        ResponseEntity response;

        if(timeEntry == null){
           return response = new ResponseEntity(timeEntry, HttpStatus.NOT_FOUND);
        }
        else
        {
            return response = new ResponseEntity(timeEntry, HttpStatus.OK);
        }
    }


    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable long id, @RequestBody TimeEntry expected) {
        TimeEntry timeEntry = tER.update(id, expected);
        ResponseEntity response;

        if(timeEntry == null){
            return response = new ResponseEntity(timeEntry, HttpStatus.NOT_FOUND);
        }
        else
        {
            return response = new ResponseEntity(timeEntry, HttpStatus.OK);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable long id) {
        tER.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
