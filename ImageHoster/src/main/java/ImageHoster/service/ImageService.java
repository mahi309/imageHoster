package ImageHoster.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Exception.BusinessException;
import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.repository.ImageRepository;

@Service
public class ImageService {
	@Autowired
	private ImageRepository imageRepository;

	// Call the getAllImages() method in the Repository and obtain a List of all the
	// images in the database
	public List<Image> getAllImages() throws Exception {
		try {
			return imageRepository.getAllImages();

		} catch (Throwable e) {
			throw e;
		}
	}

	// The method calls the createImage() method in the Repository and passes the
	// image to be persisted in the database
	public void uploadImage(Image image) throws Exception {
		try {
			imageRepository.uploadImage(image);
		} catch (Exception e) {
			throw e;
		}
	}

	// The method calls the getImageByTitle() method in the Repository and passes
	// the title of the image to be fetched
	public Image getImageByTitle(Integer id, String title) throws BusinessException, Exception {
		try {
			if (title == null || title.isEmpty()) {
				throw new BusinessException("Image Title can not be null");
			}
			if (id == null) {
				throw new BusinessException("Image Id can not be null");
			} else {
				return imageRepository.getImageByTitle(id, title);
			}
		} catch (Exception e) {
			throw e;
		}

	}

	// The method calls the getImage() method in the Repository and passes the id of
	// the image to be fetched
	public Image getImage(Integer imageId) throws Exception {
		try {
			return imageRepository.getImage(imageId);
		} catch (Exception e) {
			throw e;
		}
	}

	// The method calls the updateImage() method in the Repository and passes the
	// Image to be updated in the database
	public void updateImage(Image updatedImage) throws Exception {
		try {
			imageRepository.updateImage(updatedImage);

		} catch (Exception e) {
			throw e;
		}
	}

	// The method calls the deleteImage() method in the Repository and passes the
	// Image id of the image to be deleted in the database
	public void deleteImage(Integer imageId) throws Exception {
		try {
			imageRepository.deleteImage(imageId);

		} catch (Exception e) {
			throw e;
		}
	}

	public void createComments(Comment comment) throws Exception {
		// TODO Auto-generated method stub
		try {
			imageRepository.createComments(comment);
		} catch (Throwable e) {
			throw e;
		}

	}

}
