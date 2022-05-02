import java.util.Arrays;

public class Carburant extends Component implements IsCarburant, CategoryExceptionInterface
{
    private CategoryCarburant category;
    private int value;

    public Carburant (String id, String name, String category, int value)
    {
        super(id, name);
        this.value = value;

        try
        {
            categoryException(category);
            if (category.equals("chemical"))
            {
                this.category = CategoryCarburant.CHEMICAL;
            }
            else if (category.equals("nuclear"))
            {
                this.category = CategoryCarburant.NUCLEAR;
            }
            else
            {
                this.category = CategoryCarburant.ANTIMATTER;
            }
            carburant_list.add(this);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Carburant{" +
                "id=" + id +
                ", name=" + name +
                ", category=" + category +
                ", value=" + value +
                '}';
    }

    @Override
    public CategoryCarburant getCategory()
    {
        return category;
    }

    @Override
    public void categoryException(String category) throws Exception
    {
        String[] categories = {"chemical","nuclear","antimatter"};
        boolean contains = Arrays.stream(categories).anyMatch(category :: equals);

        if (!contains)
        {
            throw new Exception("The category does not exist");
        }
    }
}
