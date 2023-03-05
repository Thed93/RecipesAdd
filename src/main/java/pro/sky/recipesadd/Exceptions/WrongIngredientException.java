package pro.sky.recipesadd.Exceptions;

public class WrongIngredientException extends Exception {
    public WrongIngredientException (String message) {
        super(message);
    }
}
