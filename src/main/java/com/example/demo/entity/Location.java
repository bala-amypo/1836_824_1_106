package.com.example.demo.model;
import jakarta.persisitence.Entity;
import jakarta.persisitence.Id;
@Entity
public class Location{
    @Id
    private Long id;
    private String locationName;
    private String description;
    private String region;
    private LocalDateTime createdAt;
    
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public String  getLocationName(){
        return locationName;
    }

    public void setLocationName(String locationName){
        this.locationName=locationName;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description=description;
    }
    public String getRegion(){
        return region;
    }
    public void setRegion(String region){
        this.region=region;
    }
    public String getCreatedAt(){
        return createdAt;
    }
    public void setCreatedAt(String createdAt){
        this.createdAt=createdAt;
    }
    public location(Long id,)

    
}