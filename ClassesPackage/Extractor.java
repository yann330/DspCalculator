package ClassesPackage;

import java.util.LinkedList;

public class Extractor extends Factory implements Extracts
{
    private double mining_speed;
    private LinkedList<Resource> extractedResources;
    //private ClassesPackage.Resource extracted_resource;

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
//                ", building_products=" + building_products +
//                ", building_resources=" + building_resources +
                ", type='" + type + '\'' +
                ", speed=" + speed +
                ", usage=" + usage +
                ", drain=" + drain +
                ", mining_speed=" + mining_speed +
                //", extracted_resource=" + extracted_resource +
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

//    @Override
//    public void getResources()
//    {
//        for (ClassesPackage.Resource r : extractedResources)
//        {
//            System.out.println(r);
//        }
//    }

    @Override
    public LinkedList<Resource> getExtractedResources()
    {
        return (LinkedList<Resource>) extractedResources.clone();
    }
}
