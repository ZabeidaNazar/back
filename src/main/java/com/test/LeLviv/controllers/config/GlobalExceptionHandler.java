package com.test.LeLviv.controllers.config;

import com.test.LeLviv.services.exception.NoteNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ModelAndView handleValidationErrors(MethodArgumentNotValidException ex) {
        StringBuilder result = new StringBuilder();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            result.append(fieldName)
                    .append(" - ")
                    .append(errorMessage)
                    .append(", ");
        });
        ModelAndView error = new ModelAndView("error", HttpStatus.BAD_REQUEST);
        error.addObject("errors", result);
        return error;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(Exception ex) {
        ex.printStackTrace();
        ModelAndView mav = new ModelAndView();
        mav.addObject("errors", ex.getMessage());
        mav.setViewName("error");
        mav.setStatus(HttpStatus.BAD_REQUEST);
        return mav;
    }

    @ExceptionHandler(value = {NoteNotFoundException.class})
    public ModelAndView noteNotFoundException(NoteNotFoundException ex) {
        ModelAndView error = new ModelAndView("error", HttpStatus.NOT_FOUND);
        error.addObject("errors", ex.getMessage());
        return error;
    }
}
