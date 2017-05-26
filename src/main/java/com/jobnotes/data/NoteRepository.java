package com.jobnotes.data;

import com.jobnotes.com.jobnotes.models.Notes;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by edwardbenzenberg on 5/17/17.
 */

@Component
public class NoteRepository {

    Notes note;
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");



    List<Notes> notesList =  Arrays.asList(
            new Notes(1,"Horan","This is the first note. Need 6 pcs of wood - 7 1/2 x 12. Also need another pc of trim. Added more to the note to make it long. have to make it even longer to reach the end of the page", "5/17/17","in progress"),
            new Notes(2,"Baby Store", "Baby Store note","5/17/17","not started" ),
            new Notes(3, "Montemenro", "Another Note", "5/24/17", "not started"),
            new Notes(3, "Shop", "And another note", "5/30/17", "not started"));


    public List<Notes> getNotes(){
        return notesList;
    }

    public List<Notes> findByName(String jobName){
        List<Notes> noteByName = new ArrayList<>();
        for(Notes note: notesList){
            if (note.getJobName().equals(jobName)){
                noteByName.add(note);
            }
        }

        return noteByName;
    }

    public Notes findById(int id){
        List<Notes> allNotes = new ArrayList<>(notesList);
        for(Notes oneNote : allNotes){
            if(oneNote.getId() == id ){
                return oneNote;
            }
        }
        return null;
    }

    public void editNote(int id, String note){
        Notes edit = new Notes();
        edit = findById(id);
        edit.setNote(note);

    }


    public void addNote(Notes note){
        notesList.add(note);
    }
}