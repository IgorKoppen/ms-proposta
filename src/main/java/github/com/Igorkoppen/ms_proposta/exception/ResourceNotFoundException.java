package github.com.Igorkoppen.ms_proposta.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(Long id) {
        super("Recurso não encontrado com id: " + id);
    }
}
