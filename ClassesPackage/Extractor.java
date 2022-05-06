package ClassesPackage;

import java.util.LinkedList;

public class Extractor extends Factory implements Extracts
{
    private double mining_speed;
    private LinkedList<Resource> extractedResources;

    public Extractor(String id, String name, Integer usage, double drain, Double mining_speed)
    {
        super(id, name, "electric", 0.0, usage, drain);
        this.mining_speed = mining_speed;
        extractedResources = new LinkedList<Resource>();
    }


    @Override
    public String toString() {
        return "ClassesPackage.Extractor{" +
                "id=" + id +
                ", name=" + name +
                ", type='" + type + '\'' +
                ", speed=" + speed +
                ", usage=" + usage +
                ", drain=" + drain +
                ", mining_speed=" + mining_speed +
                '}';
    }

    public double getMining_speed()
    {
        return mining_speed;
    }

    @Override
    public void addResource(Resource resource)
    {
        extractedResources.add(resource);
    }

    @Override
    public LinkedList<Resource> getExtractedResources()
    {
        return (LinkedList<Resource>) extractedResources.clone();
    }
}
