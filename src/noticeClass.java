



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author User
 */
import java.io.*;
class Date implements Serializable{
    private String Month;
    private String Date;
    private String Year;

    public Date(String Month, String Date, String Year) {
        this.Month = Month;
        this.Date = Date;
        this.Year = Year;
    }
    
    public String toString(){
        return Month+" "+Date+", "+Year;
    }
}
public class noticeClass implements Serializable{
    private Date dob;
    private String LT;
    private String  Course;
    private String Syllabus;
    private String Type;

    public Date getDob() {
        return dob;
    }

    public noticeClass(String m,String d,String y, String LT, String Course, String Syllabus, String Type) {
        dob=new Date(m,d,y);
        this.LT = LT;
        this.Course = Course;
        this.Syllabus = Syllabus;
        this.Type = Type;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getLT() {
        return LT;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public void setLT(String LT) {
        this.LT = LT;
    }

    public String getCourse() {
        return Course;
    }

    public void setCourse(String Course) {
        this.Course = Course;
    }

    public String getSyllabus() {
        return Syllabus;
    }

    public void setSyllabus(String Syllabus) {
        this.Syllabus = Syllabus;
    }
    public String toString(){
        String s= Type+" to be held on "+dob.toString()+":\n\n"+"Level/Term: "+LT+"\n"+"Course: "+Course+"\n\n"+"Syllabus: "+Syllabus+"\n\n";
        return s;
    }
    
    
}
