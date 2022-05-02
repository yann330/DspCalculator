import java.util.LinkedList;

public interface IsCarburant
{
    public LinkedList<IsCarburant> carburant_list = new LinkedList<IsCarburant>();
    public CategoryCarburant getCategory();
    public String getName();
    public static LinkedList<IsCarburant> getCarburantsByCategory(CategoryCarburant categoryCarburant)
    {
        LinkedList<IsCarburant> res= new LinkedList<IsCarburant>();
        for (IsCarburant c : carburant_list)
        {
            if (c.getCategory() == categoryCarburant)
            {
                res.add( c);
            }
        }
        return res;
    }
}
