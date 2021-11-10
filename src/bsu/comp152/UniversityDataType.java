package bsu.comp152;

import java.util.ArrayList;

public class UniversityDataType {
    String alpha_two_code;
    ArrayList<String> web_pages;
    String name;
    String country;
    ArrayList<String> domains;

    @Override
    public String toString(){
        return name + " is a University in " + country + " found on the web: " + web_pages;
    }
}
