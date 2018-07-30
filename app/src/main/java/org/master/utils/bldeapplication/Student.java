package org.master.utils.bldeapplication;

/**
 * Created by Gururaj on 7/28/2018.
 */
public class Student {
    int image;
    String name;
    String dob;

    public Student(int image, String name, String dob) {
        this.image = image;
        this.name = name;
        this.dob = dob;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}
