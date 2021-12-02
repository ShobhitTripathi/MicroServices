package com.benz.assignment.model;

public class UserInfo {

    private String name;
    private String dob;
    private String salary;
    private String age;
    private String fileType;

    public UserInfo() {
    }

    public UserInfo(String name, String dob, String salary, String age, String fileType) {
        this.name = name;
        this.dob = dob;
        this.salary = salary;
        this.age = age;
        this.fileType = fileType;
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

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", salary='" + salary + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public static boolean isValidData(UserInfo userInfo) {
        if (userInfo == null) {
            return false;
        }
        if (!checkEmpty(userInfo)) {
            System.out.println("All parameters should be filled in.");
            return false;
        }
        if (!isNumeric(userInfo.getAge())) {
            System.out.println("Age should be a number.");
            return false;
        }
        if (isNumeric(userInfo.getSalary())) {
            System.out.println("Salary should be a number.");
            return false;
        }
        if (userInfo.getFileType() != "CSV" || userInfo.getFileType() != "XML") {
            System.out.println("FileType input should be CSV or XML.");
        }
        //to-do : validate for date of birth

        return true;
    }

    private static boolean checkEmpty(UserInfo userInfo) {
        if (userInfo.getName().isEmpty()) {
            System.out.println("username is empty");
            return false;
        }
        if (userInfo.getAge().isEmpty()) {
            System.out.println("age is empty");
            return false;
        }
        if (userInfo.getDob().isEmpty()) {
            System.out.println("DOB is empty");
            return false;
        }
        if (userInfo.getSalary().isEmpty()) {
            System.out.println("Salary is empty");
            return false;
        }
        if (userInfo.getFileType().isEmpty()) {
            System.out.println("File Type is empty");
            return false;
        }

        return true;
    }

    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
