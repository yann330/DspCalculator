import java.util.LinkedList;

public class Resource extends Component
{
    protected LinkedList<String> minedby;
    private static LinkedList<Resource> allResources = new LinkedList<Resource>();
    protected int insideResource = 0;

    public Resource(String id, String name)
    {
        super(id, name);
        minedby = new LinkedList<String>();
        allResources.add(this);
    }

    @Override
    public String toString()
    {
        return "Resource{" +
                "id=" + id +
                ", name=" + name +
                ", minedby=" + minedby +
                '}';
    }

//    public int isInsideResource()
//    {
//        return insideResource;
//    }
//
    public void addExtractor(String extractor)
    {
        minedby.add(extractor);
//        insideResource = 1;
//        extractor.setExtracted_resource(this);
//        insideResource = 0;
    }

    public LinkedList<String> getMinedby()
    {
        return (LinkedList<String>) minedby.clone();
    }

    public static void fillExtractors()
    {
        for (Resource r : allResources)
        {
            for (String s : r.minedby)
            {
                Extracts e = (Extracts) Building.findBuilding(s);
                e.addResource(r);
            }
        }
    }
}
