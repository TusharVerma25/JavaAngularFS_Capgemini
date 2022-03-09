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

        Course c = new Course();
        c.setCid(101L);
        c.setCname("Java");
        c.setPrice(999);
        entityMgr.persist(c);
        System.out.println("Record Successfully Inserted In The Database");
        Query q = entityMgr.createNativeQuery("SELECT c.cid, c.cname,c.price FROM course c",Course.class);
        @SuppressWarnings("unchecked")
        List<Course> courses =(List<Course>) q.getResultList();

        for(Course C: courses) {
            System.out.println(C.getCid()+" "+C.getCname()+" "+C.getPrice());
        }

        entityMgr.getTransaction().commit();

        entityMgr.clear();

    }

}
