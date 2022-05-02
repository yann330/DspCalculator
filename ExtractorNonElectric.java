import java.util.LinkedList;

public class ExtractorNonElectric extends Building implements Extracts
{
    private double mining_speed;
    private LinkedList<Resource> extractedResources;

    public ExtractorNonElectric(String id, String name, double mining_speed)
    {
        super(id, name);
        this.mining_speed = mining_speed;
        extractedResources = new LinkedList<Resource>();
    }

    @Override
    public String toString()
    {
        return "ExtractorNonElectric{" +
                "id=" + id +
                ", name=" + name +
//                ", building_products=" + building_products +
//                ", building_resources=" + building_resources +
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
    public void getResources()
    {
        for (Resource r : extractedResources)
        {
            System.out.println(r);
        }
    }
}
