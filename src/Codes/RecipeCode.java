package Codes;

import java.util.HashMap;

public interface RecipeCode {
    public HashMap<String,Integer> requirements();
    public String description();

    public void doStuff(int ratio);

    default int getTier(){
        return 0;
    }
}
