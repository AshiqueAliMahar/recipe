package ali.ashique.recipe.controler;

import ali.ashique.recipe.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class ExceptionHandlerCntrlr {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({NotFoundException.class, NumberFormatException.class})
    public String handleException(Exception exception, Model model) {
        model.addAttribute("exception", exception);
        log.error(exception.getMessage());
        return "404-error";
    }
}
