import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Course")
public class Course {

    private static final EntityManagerFactory emFactoryObj;
    private static final String PERSISTENCE_UNIT_NAME = "puName";

    static {
        emFactoryObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    // This Method Is Used To Retrieve The 'EntityManager' Object
    public static EntityManager getEntityManager() {
        return emFactoryObj.createEntityManager();
    }

    public Course() {}
    @Id
    @Column(name="cid")
    private Long cid;

    @Column(name="cname")
    private String cname;

    @Column(name="price")
    private double price;

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static void main(String[] args) {

        EntityManager entityMgr = getEntityManager();
        entityMgr.getTransaction().begin();

//        Employee emp = new Employee();
//        emp.setId(102);
//        emp.setName("Sushant");
//        emp.setEmail("s@hmail.com");
//        emp.setDepartment("Sales");
//        entityMgr.persist(emp);

        Query q = entityMgr.createNativeQuery("SELECT e.emp_id, e.emp_name,e.email,e.department FROM employee e",Course.class);
        @SuppressWarnings("unchecked")
        List<Employee> employees =(List<Employee>) q.getResultList();

        for(Employee e: employees) {
            System.out.println(e.getId()+" "+e.getName()+" "+e.getEmail()+" "+e.getDepartment());
        }

        entityMgr.getTransaction().commit();

        entityMgr.clear();
//        System.out.println("Record Successfully Inserted In The Database");
    }

}
