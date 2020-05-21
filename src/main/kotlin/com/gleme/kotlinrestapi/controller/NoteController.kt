package com.gleme.kotlinrestapi.controller

import com.gleme.kotlinrestapi.entity.Note
import com.gleme.kotlinrestapi.repository.NoteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import org.springframework.validation.ObjectError

@RestController
@RequestMapping("/notes")
class NoteController {

    @Autowired
    lateinit var noteRepository: NoteRepository;

    @GetMapping
    fun findAll(): ResponseEntity<Response<List<Note>>> {
        var res: Response<List<Note>> = Response()
        try {
            var notes: List<Note> = noteRepository.findAll();
            res.data = notes;
            return ResponseEntity.ok(res);
        }
        catch(ex : Exception) {
            res.errors.add(ex.message);
            return ResponseEntity.status(500).body(res);
        }
    }

    @PostMapping
    fun create(@RequestBody note: Note, bindingResult: BindingResult): ResponseEntity<Response<Note>> {
        var res: Response<Note> = Response();

        if (bindingResult.hasErrors()) {
            bindingResult.allErrors.forEach { objectError: ObjectError? ->
                res.errors.add(objectError!!.defaultMessage);
            }

            return ResponseEntity.status(400).body(res);
        }

        val noteWasSaved = noteRepository.save(note);

        res.data = noteWasSaved;

        return ResponseEntity.ok(res);
    }
}
