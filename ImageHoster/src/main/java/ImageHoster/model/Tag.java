package ImageHoster.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

//@Entity annotation specifies that the corresponding class is a JPA entity
@Entity
//@Table annotation provides more options to customize the mapping.
//Here the name of the table to be created in the database is explicitly mentioned as 'Tags'. Hence the table named 'Tags' will be created in the database with all the columns mapped to all the attributes in 'Tag' class
@Table(name = "tags")
public class Tag {

    //@Id annotation specifies that the corresponding attribute is a primary key
    @Id
    //@Column annotation specifies that the attribute will be mapped to the column in the database.
    //Here the column name is explicitly mentioned as 'id'
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name="tag_name",length=20)
    private String tag_name;

    // Write the annotation for many to many between images 
    //and tags where they are mapped by tags field in the images table
    //The 'tags' table is mapped to 'images' table with Many:Many mapping
    //One image can have multiple categories/tags and there can be multiple 
    //images under one category/tag
    //FetchType is LAZY
    //Note that no column will be generated for this attribute in the database instead a new table will be created
    //Since the mapping is Many to Many, a new table will be generated containing the two columns both referencing to the primary key of both the tables ('images', 'tags')

    @ManyToMany(mappedBy = "tags",fetch=FetchType.LAZY)
    private List<Image> images=new ArrayList<>();

    public Tag() {
    }

    public Tag(String tag_name) {
        this.tag_name = tag_name;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return tag_name;
    }

    public void setName(String name) {
        this.tag_name = name;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}