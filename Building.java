
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Building extends Component
{
    private static LinkedList<Building> allBuildings = new LinkedList<Building>();
    protected LinkedList<Recipe> associatedRecipies;

    public Building (String id, String name)
    {
        super(id, name);
        associatedRecipies = new LinkedList<Recipe>();
        allBuildings.add(this);
    }

    @Override
    public String toString() {
        return "Building{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }

    public void addRecipe(Recipe recipe)
    {
        associatedRecipies.add(recipe);
    }

    //Afficher, pour une usine donnée, toutes les recettes qui lui sont associées (vous devez afficher les
    //informations complètes de chaque recette).

    public LinkedList<Recipe> getAssociatedRecipes()
    {
        /*if (associatedRecipies.size() > 0)
        {
            for (Recipe r : associatedRecipies)
            {
                System.out.println(r);
            }
        }
        else
        {
            System.out.println("No recipies associated");
        }*/
        return this.associatedRecipies;
    }


    public static Building findBuilding(String id)
    {
        for (Building b : allBuildings)
        {
            if (b.id.equals(id))
            {
                return b;
            }
        }
        return null;
    }


    //Afficher la liste des bâtiments par ordre alphabétique et permettre, pour un bâtiment spécifique,
    //d’obtenir toutes ses informations

    public static LinkedList<Building> alphabeticBuildings()
    {
        Collections.sort(allBuildings, new Component.ComponentComparator());
        return allBuildings;
        /*for (Component b : allBuildings)
        {
            System.out.println(b.getName());
        }*/
    }


    // Afficher, pour une usine donnée, toutes les recettes qui lui sont associées (vous devez afficher les
    //informations complètes de chaque recette).

    public static void getRecipes(String id)
    {
        try
        {
            Building b = Building.findBuilding(id);
            b.getAssociatedRecipes();
        }
        catch (Exception ex)
        {
            System.out.println("The building is not found");
        }
    }


}
