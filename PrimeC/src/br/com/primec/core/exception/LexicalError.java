package br.com.primec.core.exception;

public class LexicalError extends AnalysisError {

    public LexicalError(String msg, int position) {
        super(msg, position);
    }

    public LexicalError(String msg) {
        super(msg);
    }
}