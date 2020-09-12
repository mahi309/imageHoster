package ImageHoster.service;

import ImageHoster.model.Tag;
import ImageHoster.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;

    public Tag getTagByName(String title)throws Exception {
    	try {
            return tagRepository.findTag(title);

    	}catch(Exception e) {
    		throw e;
    	}
    }

    public Tag createTag(Tag tag)throws Exception {
    	try {
            return tagRepository.createTag(tag);

    	}catch(Exception e) {
    		throw e;
    	}
    }
}
