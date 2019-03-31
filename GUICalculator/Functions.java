package Application;

public class Functions extends Object {
    private String functionName;
    private String function;

    public Functions(String functionName, String function){
        this.functionName=functionName; // pełna nazwa funkcji
        this.function=function; // skrót nazwy funkcji

    }


    public void setFunction(String function) {

        this.function = function;
    }


    public String getFunction() {

        return function;
    }

    public String toString(){
        return functionName;

    }

}
