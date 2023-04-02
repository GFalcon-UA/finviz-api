package ua.com.gfalcon.finviz.validator;

public interface Validator<T> {

    boolean isValid(T obj);

}
