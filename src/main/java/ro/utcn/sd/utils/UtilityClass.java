package ro.utcn.sd.utils;

public class UtilityClass {
    public UtilityClass() {}

    public String removeParantheses(String str){
        return str.replaceAll("[{}]", "");
    }
}
