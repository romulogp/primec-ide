package br.com.primec.core.table;

import br.com.primec.core.exception.SemanticError;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SymbolTable {

    private static List<Symbol> symbols = new ArrayList<>();

    public SymbolTable() {
        symbols = new ArrayList<>();
    }

    public List<Symbol> getSymbolTable() {
        return symbols;
    }

    public Symbol findBySymbolScope(Symbol symbol) {
        for (Symbol s : symbols) {
            if ((s.getName().equals(symbol.getName()))
                    && (s.getScope().equals(symbol.getScope()))) {
                return s;
            }
        }
        return null;
    }

    public Symbol findSymbolByName(String name) {
        for (Symbol s : symbols) {
            if (s.getName().equals(name)) {
                return s;
            }
        }
        return null;
    }
    
    public Symbol findDeclaration(Symbol symbol, Stack<String> stack) {
        Stack<String> tempStack = copyStack(stack);

        while (!tempStack.lastElement().equals(Scope.GLOBAL.getDescription())) {

            Symbol tempSymbol = new Symbol();
            tempSymbol.setName(symbol.getName());
            tempSymbol.setScope(tempStack.lastElement());

            if ((tempSymbol = findBySymbolScope(tempSymbol)) != null) {
                return tempSymbol;
            }
            tempStack.pop();
        }
        return null;
    }

    public void add(Symbol symbol) throws SemanticError {
        if (findBySymbolScope(symbol) == null) {
            symbols.add(symbol);
        } else {
            throw new SemanticError("Duplicated Symbol");
        }
    }

    public Stack<String> copyStack(Stack<String> stackToCopy) {
        Stack<String> newStack = new Stack<>();
        for (int i = 0; i < stackToCopy.size(); i++) {
            newStack.push(stackToCopy.elementAt(i));
        }
        return newStack;
    }

    public String checkDeclaredNotUsed() {
        String text = "";
        for (Symbol s : symbols) {
            if (!s.isFunction() && !s.isParam()
                    && !s.isUsed()) {
                text += "A variável \"" + s.getName() + "\" não é utilizada.\n";
            }
        }
        return text;
    }

    public String checkUsedNotInitialized() {
        String text = "";
        for (Symbol s : symbols) {
            if (!s.isFunction() && !s.isParam()
                    && s.isUsed() && !s.isInitialized() 
                    && !s.isVect()) {
                text += "A variável \"" + s.getName() + "\" não foi inicializada.\n";
            }
        }
        return text;
    }

    public Symbol findFunctionParam(String functionName, int paramPos) {
        int countParam = -1;
        for (Symbol s : symbols) {
            if (s.getScope().equals(functionName)) {
                countParam++;
                if (countParam == paramPos) {
                    return s;
                }
            }
        }
        return null;
    }
    
    @Override
    public String toString() {
        String toString = "";
        
        for (Symbol s : symbols) {
            toString += ""
                    + "\n\t"
                    + "Type: " + s.getType()
                    + " | "
                    + "Name: " + s.getName()
                    + " | "
                    + "Scope: " + s.getScope();
        }
        return toString;
    }

}
