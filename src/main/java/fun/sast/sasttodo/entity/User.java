package fun.sast.sasttodo.entity;

public class User {
    private Long id;
    private String studentId;
    private String password;

    public User(Long id, String studentId, String password) {
        this.id = id;
        this.studentId = studentId;
        this.password = password;
    }

    public User() {}

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // toString method
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", studentId='" + studentId + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}