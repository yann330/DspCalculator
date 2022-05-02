import java.util.LinkedList;

public class EnergyProductionCentral extends Central implements Extracts
{
    private int value;
    private LinkedList<Resource> extractedResources;

    public EnergyProductionCentral(String id, String name, int value)
    {
        super(id, name, "electric-production");
        this.value = value;
        extractedResources = new LinkedList<Resource>();
    }

    @Override
    public String toString() {
        return "EnergyProductionCentral{" +
                "id=" + id +
                ", name=" + name +
//                ", building_products=" + building_products +
//                ", building_resources=" + building_resources +
                ", value=" + value +
                '}';
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
