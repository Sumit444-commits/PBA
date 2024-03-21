package myPackage;

public class State {
    String district="";
    String crop="";
    int year;
    public State(String district, String crop, int year) {
        this.district = district;
        this.crop = crop;
        this.year = year;
    }
    public String getDistrict() {
        return district;
    }
    public void setDistrict(String district) {
        this.district = district;
    }
    public String getCrop() {
        return crop;
    }
    public void setCrop(String crop) {
        this.crop = crop;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    @Override
    public String toString() {
        return "[district=" + district + ", crop=" + crop + ", year=" + year + "]";
    }
    
}
