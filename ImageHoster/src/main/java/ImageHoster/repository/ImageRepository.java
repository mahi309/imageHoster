package ImageHoster.repository;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

//The annotation is a special type of @Component annotation which describes that the class defines a data repository
@Repository
public class ImageRepository {

	// Get an instance of EntityManagerFactory from persistence unit with name as
	// 'imageHoster'
	@PersistenceUnit(unitName = "imageHoster")
	private EntityManagerFactory emf;

	// The method receives the Image object to be persisted in the database
	// Creates an instance of EntityManager
	// Starts a transaction
	// The transaction is committed if it is successful
	// The transaction is rolled back in case of unsuccessful transaction
	public Image uploadImage(Image newImage)throws Exception {

		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();

		try {
			transaction.begin();
			em.merge(newImage);
			transaction.commit();
		} catch (Throwable e) {
			transaction.rollback();
			throw e;
		}
		return newImage;
	}

	// The method creates an instance of EntityManager
	// Executes JPQL query to fetch all the images from the database
	// Returns the list of all the images fetched from the database
	public List<Image> getAllImages()throws Exception {
		EntityManager em = emf.createEntityManager();
		try {
			TypedQuery<Image> query = em.createQuery("SELECT i from Image i", Image.class);
			List<Image> resultList = query.getResultList();

			return resultList;
		}catch(Exception e) {
			throw e;
		}
		
	}

	// The method creates an instance of EntityManager
	// Executes JPQL query to fetch the image from the database with corresponding
	// title
	// Returns the image in case the image is found in the database
	// Returns null if no image is found in the database
	public Image getImageByTitle(Integer id, String title)throws Exception {
		EntityManager em = emf.createEntityManager();
		try {
			System.out.println("id and title is" + id + " " + title);
			TypedQuery<Image> typedQuery = em.createQuery("SELECT i from Image i where i.id=:id and i.title =:title",
					Image.class);
			typedQuery.setParameter("id", id);
			typedQuery.setParameter("title", title);
			return typedQuery.getSingleResult();
		} catch (Exception nre) {
          throw nre;
		}
	}

	// The method creates an instance of EntityManager
	// Executes JPQL query to fetch the image from the database with corresponding
	// id
	// Returns the image fetched from the database
	public Image getImage(Integer imageId) throws Exception{
		EntityManager em = emf.createEntityManager();
		try {
			TypedQuery<Image> typedQuery = em.createQuery("SELECT i from Image i where i.id =:imageId", Image.class)
					.setParameter("imageId", imageId);
			Image image = typedQuery.getSingleResult();
			return image;
		}catch(Exception e) {
			throw e;
		}
		
	}

	// The method receives the Image object to be updated in the database
	// Creates an instance of EntityManager
	// Starts a transaction
	// The transaction is committed if it is successful
	// The transaction is rolled back in case of unsuccessful transaction
	public void updateImage(Image updatedImage)throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();

		try {
			transaction.begin();
			em.merge(updatedImage);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			throw e;
		}
	}

	// The method receives the Image id of the image to be deleted in the database
	// Creates an instance of EntityManager
	// Starts a transaction
	// Get the image with corresponding image id from the database
	// This changes the state of the image model from detached state to persistent
	// state, which is very essential to use the remove() method
	// If you use remove() method on the object which is not in persistent state, an
	// exception is thrown
	// The transaction is committed if it is successful
	// The transaction is rolled back in case of unsuccessful transaction
	public void deleteImage(Integer imageId)throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();

		try {
			transaction.begin();
			Image image = em.find(Image.class, imageId);
			em.remove(image);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			throw e;
		}
	}

	public void createComments(Comment comment)throws Exception {
		// TODO Auto-generated method stub
		EntityManager em=emf.createEntityManager();
		EntityTransaction transaction=em.getTransaction();
		try {
			// begin the transaction
			transaction.begin();
			em.merge(comment);
			transaction.commit();
			
		}catch(Throwable e) {
			transaction.rollback();
			throw e;
		}
		
	}

}