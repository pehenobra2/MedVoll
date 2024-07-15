package med.voll.api.Infra.Exceptions;

public class ValidacaoException extends RuntimeException{
    public ValidacaoException(String texto){
        super(texto);
    }
}
