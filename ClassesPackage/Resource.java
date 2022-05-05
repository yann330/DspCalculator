package ClassesPackage;

import java.util.LinkedList;

public class Resource extends Component
{
    protected LinkedList<String> minedby;
    protected LinkedList<Extracts> associatedExtractors;
    private static LinkedList<Resource> allResources = new LinkedList<Resource>();

    public Resource(String id, String name)
    {
        super(id, name);
        minedby = new LinkedList<String>();
        associatedExtractors = new LinkedList<Extracts>();
        allResources.add(this);
    }

    @Override
    public String toString()
    {
        return "ClassesPackage.Resource{" +
                "id=" + id +
                ", name=" + name +
                ", minedby=" + minedby +
                '}';
    }

    public void addMinedBy(String extractor)
    {
        minedby.add(extractor);
    }

    public void addExtractor(Extracts extractor)
    {
        associatedExtractors.add(extractor);
    }

    public LinkedList<String> getMinedby()
    {
        return (LinkedList<String>) minedby.clone();
    }

    public LinkedList<Extracts> getAssociatedExtractors()
    {
        return (LinkedList<Extracts>) associatedExtractors.clone();
    }

    public static void fillExtractors()
    {
        for (Resource r : allResources)
        {
            for (String s : r.minedby)
            {
                Extracts e = (Extracts) Building.findBuilding(s);
                e.addResource(r);
                r.addExtractor(e);
            }
        }
    }
}
