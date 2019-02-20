import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MainApp {

	static EntityManagerFactory factory= Persistence.createEntityManagerFactory("emp");
	static EntityManager entityManager = factory.createEntityManager();
	static EntityTransaction entityTransaction = entityManager.getTransaction();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	insertOperation();
		
		
	}
	
	
	public static void insertOperation()
	{

//		Insert Operation
		entityTransaction.begin();
		Employee employee=new Employee();
		employee.setName("kjio");
		employee.setNumber(4);
		entityManager.persist(employee);
		entityTransaction.commit();
	}
	
	
	public static void readOperation()
	{
		Employee employee=entityManager.find(Employee.class, 12);
		System.out.println("Employee Name:"+employee.getName());
		System.out.println("Employee Number: "+employee.getNumber());
	}
	
	public static void deleteOperation()
	{
		entityTransaction.begin();
		Employee employee=entityManager.find(Employee.class, 3);
		entityManager.remove(employee);
		entityTransaction.commit();
	}
	
	public static void updateOperation()
	{
		entityTransaction.begin();
		Employee employee=entityManager.find(Employee.class, 4);
		employee.setName("Jyoti");
		entityManager.persist(employee);
		entityTransaction.commit();
	}

}
