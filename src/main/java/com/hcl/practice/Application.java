package com.hcl.practice;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * JPA Hello world!
 *
 */
public class Application {

	public static void main(String[] args) {

		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;

		try {
			emf = Persistence.createEntityManagerFactory("jbd-pu");
			entityManager = emf.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();

			Employee employee = new Employee();
			employee.setEmpName("Tim");
			employee.setSalary((long) 60000);
			employee.setAge((long) 21);

			entityManager.persist(employee);

			transaction.commit();

			Query q = entityManager.createQuery("select em from Emp em");

			List<Employee> resultList = q.getResultList();
			System.out.println("num of employees:" + resultList.size());
			for (Employee next : resultList) {
				System.out.println("next employee: " + next);
			}

		} catch (Exception e) {
			System.out.println(e);
			transaction.rollback();
		} finally {
			entityManager.close();
			emf.close();
		}
	}
}
