package com.jobnotes.data;

import com.jobnotes.com.jobnotes.models.Notes;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by edwardbenzenberg on 5/17/17.
 */

@Component
public class NoteRepository {

    Notes note;
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");

    /*
     * TEMP DATA STORAGE - REMOVE AFTER DB IMPLEMENTAION
     */
    public static int id = 4;
    ArrayList<Notes> notesList = new ArrayList<Notes>();
    Notes temp1 = new Notes(1,"Horan","This is the first note. Need 6 pcs of wood - 7 1/2 x 12. Also need another pc of trim. Added more to the note to make it long. have to make it even longer to reach the end of the page", "5/17/17","in progress");
    Notes temp2 = new Notes(2,"Baby Store", "Baby Store note","5/17/17","not started" );
    Notes temp3 = new Notes(3, "Montemenro", "Another Note", "5/24/17", "not started");



    public NoteRepository() {

            //TEMP - REMOVE AFTER DB IMPLEMENTAION
        notesList.add(temp1);
        notesList.add(temp2);
        notesList.add(temp3);

    }


    public List<Notes> getNotes(){
        return notesList;
    }

    public List<String> getFilteredNotes(){

        List<String> filtered = new ArrayList<>();
        for(Notes note : notesList){
            String jobName = note.getJobName();
            if(!filtered.contains(jobName)) {
                filtered.add(jobName);
            }
        }

        return filtered;
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

    public void editNote(int id, String note, String status){
        Notes edit = new Notes();
        edit = findById(id);
        edit.setNote(note);
        edit.setstatus(status);

    }


    public void addNote(Notes note){


        String jobName = note.getJobName();

        String[] split = jobName.split(",");
        if(split.length >1){
            jobName = split[1];
        }else {
            jobName = split[0];
        }
        String nNote = note.getNote();
        String status = note.getStatus();

        notesList.add(new Notes( id, jobName, nNote,"5/27/17" ,status));

        id++;

    }

    public void deleteNote(int id){

        List<Notes> allNotes = new ArrayList<>(notesList);
        for(Notes oneNote : allNotes){
            if(oneNote.getId() == id ) {
                notesList.remove(oneNote);
            }
        }
    }

}

