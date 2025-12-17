package.com.example.demo.model;
public class Location{
    private Long id;
    private String locationName;
    private String description;
    private String region;
    private LocalDateTime createdAt;
    
    public Long getId(){
        return id;
    }
    public void setId(long id){
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
    
}