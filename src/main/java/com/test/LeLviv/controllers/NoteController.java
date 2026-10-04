package com.test.LeLviv.controllers;

import com.test.LeLviv.data.entity.Note;
import com.test.LeLviv.services.NoteService;
import com.test.LeLviv.services.exception.NoteNotFoundException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/note")
@Validated
@RequiredArgsConstructor
public class NoteController {
    private final NoteService noteService;

    @GetMapping(value = "/list")
    public ModelAndView list() {
        ModelAndView result = new ModelAndView("note/list");
        result.addObject("notes", noteService.listAll());
        return result;
    }

    @GetMapping("/delete")
    public ModelAndView delete(@Valid @NotNull @RequestParam(value="id") String id) throws NoteNotFoundException {
        noteService.deleteById(Long.parseLong(id));
        return new ModelAndView("redirect:list");
    }

    @PostMapping("/edit")
    public ModelAndView edit(@Valid Note note) throws NoteNotFoundException {
        noteService.update(note);
        return new ModelAndView("redirect:list");
    }

    @GetMapping("/edit")
    public ModelAndView editPage(@NotNull @RequestParam(value="id") String id) throws NoteNotFoundException {
        ModelAndView result = new ModelAndView("note/edit");
        Note note = noteService.getById(Long.parseLong(id));
        result.addObject("note", note);
        return result;
    }

    @PostMapping("/create")
    public ModelAndView create(@Valid Note note) {
        noteService.add(note);
        return new ModelAndView("redirect:list");
    }
}
