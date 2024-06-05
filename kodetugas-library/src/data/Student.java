package data;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Student extends User {
    private final StringProperty name;
    private final StringProperty nim;
    private final StringProperty faculty;
    private final StringProperty program;

    public Student(String name, String nim, String faculty, String program) {
        super(name, "", faculty, program);
        this.name = new SimpleStringProperty(name);
        this.nim = new SimpleStringProperty(nim);
        this.faculty = new SimpleStringProperty(faculty);
        this.program = new SimpleStringProperty(program);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getNim() {
        return nim.get();
    }

    public void setNim(String nim) {
        this.nim.set(nim);
    }

    public StringProperty nimProperty() {
        return nim;
    }

    public String getFaculty() {
        return faculty.get();
    }

    public void setFaculty(String faculty) {
        this.faculty.set(faculty);
    }

    public StringProperty facultyProperty() {
        return faculty;
    }

    public String getProgram() {
        return program.get();
    }

    public void setProgram(String program) {
        this.program.set(program);
    }

    public StringProperty programProperty() {
        return program;
    }
}
