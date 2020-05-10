package models;

public class DepartmentNews extends News {
    private static final String TYPE="Department News";

    public DepartmentNews(String content) {
        this.content=content;
        this.type=TYPE;
    }

}
