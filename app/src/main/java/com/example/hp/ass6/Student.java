package com.example.hp.ass6;
public class Student {
    public static final String TABLE_NAME = "students";
    public static final String COLUMN_ID = "std_id";
    public static final String COLUMN_NAME = "std_name";
    public static final String COLUMN_TRACK = "std_track";

    private String id;
    private String name;
    private String track;
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " TEXT,"
                    + COLUMN_NAME + " TEXT,"
                    + COLUMN_TRACK + " TEXT"
                    + ")";
    public Student(String id,String name,String track){
        this.id = id;
        this.name = name;
        this.track = track;
    }
    public Student(){}
    public String getId() { return id; }
    public void setId(String id){this.id = id;}
    public String getName() { return name; }
    public void setName(String name){ this.name = name;}
    public void setTrack(String track){this.track = track;}
    public String getTrack(){return track;}
}
