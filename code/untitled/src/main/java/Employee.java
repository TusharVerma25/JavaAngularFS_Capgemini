import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Employee {

    public Employee() {}
    @Id
    @Column(name="emp_id")

    private Long eid;
    @Column(name="emp_name")

    private String ename;
    @Column(name="email")

    private String email;
    @Column(name="department")

    private String department;

    public Long getId() {
        return eid;
    }
    public void setId(int i) {
        this.eid = (long) i;
    }
    public String getName() {
        return ename;
    }
    public void setName(String ename) {
        this.ename = ename;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }


}