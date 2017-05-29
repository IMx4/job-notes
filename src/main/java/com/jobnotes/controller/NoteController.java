package com.jobnotes.controller;

import com.jobnotes.com.jobnotes.models.Notes;
import com.jobnotes.data.NoteRepository;
//import com.sun.tools.javap.TypeAnnotationWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.Attribute;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by edwardbenzenberg on 5/17/17.
 */

@Controller
public class NoteController {



    @Autowired
    private NoteRepository notesRepository;




    @RequestMapping("/")
    public String listCategories(ModelMap modelMap){

        List<String> notesFiltered = notesRepository.getFilteredNotes();
        modelMap.put("notesFiltered", notesFiltered);

        List<Notes> notes = notesRepository.getNotes();
        modelMap.put("notes", notes);

        Notes newNoteTemp = new Notes();
        modelMap.put("newNoteTemp", newNoteTemp);

        return "allNotes2";
    }

    @RequestMapping("/{jobName}")
    public String list(@PathVariable String jobName , ModelMap modelMap){

        List<String> notesFiltered = notesRepository.getFilteredNotes();
        modelMap.put("notesFiltered", notesFiltered);

        List<Notes> notes = notesRepository.getNotes();
        List<Notes> notesByName = notesRepository.findByName(jobName);
        modelMap.put("notesByName", notesByName);
        modelMap.put("notes", notes);
        return "noteByJobName";
    }

    @RequestMapping("/delete/{id}")
    public String deleteNote(@PathVariable int id){
       notesRepository.deleteNote(id);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public String editNote(@PathVariable int id, ModelMap modelMap, Model model){

        List<String> notesFiltered = notesRepository.getFilteredNotes();
        modelMap.put("notesFiltered", notesFiltered);

        Notes note1 = notesRepository.findById(id);
        model.addAttribute("e",note1);

        modelMap.put("note1",note1);
        modelMap.put("noteEdit", new Notes("test",id,"status"));

        return "edit";
    }


    @RequestMapping(value = "/saveEdit", method = RequestMethod.POST)
    public String saveEdit(Notes e, BindingResult bindingResult){
        notesRepository.editNote(e.getId(),e.getNote(),e.getStatus());
        return "redirect:/";
    }

    @RequestMapping(value = "/newNote", method = RequestMethod.POST)
    public String newNote(Notes newNote, BindingResult bindingResult, ModelMap modelMap) {
        notesRepository.addNote(newNote);

        return "redirect:/";
    }



    }
