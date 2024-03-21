package myPackage;

public class Crop {
    String cropName;
    int count;

    public Crop(String name, int count) {
        this.cropName = name;
        this.count = count;
    }

    @Override
    public String toString() {
        return "CropData [cropName=" + cropName + ", count=" + count + "]";
    }
}
