package models;

public class GeneralNews extends News{
    private static final String TYPE="General News";

    public GeneralNews(String content) {
        this.content=content;
        this.type=TYPE;
    }

}
