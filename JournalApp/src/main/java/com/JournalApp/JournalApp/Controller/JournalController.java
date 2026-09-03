package com.JournalApp.JournalApp.Controller;

import com.JournalApp.JournalApp.Entity.JournalEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class JournalController {

    @Autowired
    private JournalEntry je;

    private Map<Long, JournalEntry> journalEntry = new HashMap<>();

    @GetMapping
    public List<JournalEntry> getAll(){
        return new ArrayList<JournalEntry>(journalEntry.values());
    }

    @PostMapping
    public Boolean createEntry(@RequestBody JournalEntry myEntry){
        journalEntry.put(myEntry.getId(), myEntry);
        return true;
    }

    @PutMapping("{id}")
    public Boolean updateEntry(@PathVariable Long id,@RequestBody JournalEntry myEntry){
        journalEntry.put(id,myEntry);
        return true;
    }
}
