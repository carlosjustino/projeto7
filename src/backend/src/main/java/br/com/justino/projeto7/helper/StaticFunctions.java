package br.com.justino.projeto7.helper;

import br.com.justino.projeto7.exceptions.GenericConstraintValidation;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.LinkedHashSet;
import java.util.Set;

public final class StaticFunctions {

    public static void throwConstraintViolationException(String mensagem, Object instancia) {
        final Set<ConstraintViolation<?>> erros = new LinkedHashSet();
        erros.add(new GenericConstraintValidation(mensagem));
        String baseMessage = mensagem;
        if (instancia != null)
            baseMessage = instancia.getClass().getSimpleName() + ": " + baseMessage;
        throw new ConstraintViolationException(baseMessage, erros);
    }
}
