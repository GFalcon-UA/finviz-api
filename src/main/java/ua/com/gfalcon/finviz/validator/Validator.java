package ua.com.gfalcon.finviz.validator;

public interface Validator<T extends Object> {

    boolean isValid(T obj);

}
