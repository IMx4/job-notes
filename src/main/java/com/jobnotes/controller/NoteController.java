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
import java.util.List;

/**
 * Created by edwardbenzenberg on 5/17/17.
 */

@Controller
public class NoteController {



    @Autowired
    private NoteRepository notesRepository;




    @RequestMapping("/")
    public String listCategories(ModelMap modelMap){
        List<Notes> notes = notesRepository.getNotes();
        modelMap.put("notes", notes);

        Notes newNoteTemp = new Notes();
        modelMap.put("newNoteTemp", newNoteTemp);

        return "allNotes2";
    }

    @RequestMapping("/{jobName}")
    public String list(@PathVariable String jobName , ModelMap modelMap){
        List<Notes> notes = notesRepository.getNotes();
        List<Notes> notesByName = notesRepository.findByName(jobName);
        modelMap.put("notesByName", notesByName);
        modelMap.put("notes", notes);
        return "noteByJobName";
    }

    @RequestMapping("/delete/{id}")
    public String deleteNote(@PathVariable int id, ModelMap modelMap){
       Notes note1 = notesRepository.findById(id);

       modelMap.put("note1",note1);

        return "delete";
    }

    @RequestMapping("/edit/{id}")
    public String editNote(@PathVariable int id, ModelMap modelMap, Model model){

        Notes note1 = notesRepository.findById(id);

        model.addAttribute("e",note1);

        modelMap.put("note1",note1);
        modelMap.put("noteEdit", new Notes("test",id));

        return "edit";
    }


    @RequestMapping(value = "/saveEdit", method = RequestMethod.POST)
    public String saveEdit(Notes e, BindingResult bindingResult){
        notesRepository.editNote(e.getId(),e.getNote());
        return "redirect:/";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public void newNote(Notes newNote, BindingResult bindingResult, ModelMap modelMap, Model model) {

    }


}
