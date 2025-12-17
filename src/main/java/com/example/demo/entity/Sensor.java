package.com.example.demo.model;
public class Sensor{
    private Long id;
    private String sensorCode;
    private String sensorType;
    private String location;
    private LocalDateTime installedAt;
    private Boolean isActive;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    public String getSensorCode() {
        return sensorCode;
    }

    public void setSensorCode(String sensorCode) {
        this.sensorCode = sensorCode;
    }

    
    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    
    public LocalDateTime getInstalledAt() {
        return installedAt;
    }

    public void setInstalledAt(LocalDateTime installedAt) {
        this.installedAt = installedAt;
    }

    
    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}
