package ClassesPackage;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Recipe
{
    private String id;
    private String name;
    private LinkedList<Component> in;
    private LinkedList<Component> out;
    private double time;
    private LinkedList<Building> producers;
    private static LinkedList<Recipe> allRecipies = new LinkedList<Recipe>();

    public Recipe(String id, String name, double time)
    {
        this.id = id;
        this.name = name;
        this.time = time;
        in = new LinkedList<Component>();
        out = new LinkedList<Component>();
        producers = new LinkedList<Building>();
        allRecipies.add(this);
    }

    @Override
    public String toString() {
        return "ClassesPackage.Recipe{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", in=" + in +
                ", out=" + out +
                ", time=" + time +
                ", producers=" + producers +
                '}';
    }

    public void addIn(Component in)
    {
        this.in.add(in);
    }

    public void addOut(Component out)
    {
        this.out.add(out);
    }

    public void addProducer(Building producer)
    {
        this.producers.add(producer);
        producer.addRecipe(this);
    }

    public double getTime() {
        return time;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LinkedList<Component> getIn() {
        return (LinkedList<Component>) in.clone();
    }

    public LinkedList<Component> getOut() {
        return (LinkedList<Component>) out.clone();
    }

    public LinkedList<Building> getProducers() {
        return (LinkedList<Building>) producers.clone();
    }

    // Custom comparator to compare by name
    public static class RecipeComparator implements Comparator<Recipe>
    {
        public int compare(Recipe r1, Recipe r2)
        {
            return r1.name.compareTo(r2.name);
        }
    }

    public static Recipe findRecipe(String id)
    {
        for (Recipe r : allRecipies)
        {
            if (r.id.equals(id))
            {
                return r;
            }
        }
        return null;
    }

    //Afficher, pour une recette spécifique, l’ensemble des composants de type ressource qui sont nécessaires pour l’élaboration de la recette. Il faudra, pour chaque composant de la recette qui n’est pas
    //une ressource, rechercher de façon récursive comment produire ce composant jusqu’à obtenir une
    //décomposition en ressources. Si des composants peuvent être produits par plusieurs recettes, on
    //choisira arbitrairement une des recettes.

    public static LinkedList<Resource> getRecipeResources(String id)
    {
        LinkedList<Resource> res = new LinkedList<Resource>();
        // Find recipe
        Recipe recipe = Recipe.findRecipe(id);

        if (recipe.in != null)
        {
            for(Component c : recipe.in)
            {
                if (Recipe.findRecipe(c.getId()) != null)
                {
                    getRecipeResources(c.getId());
                }
                else if (c instanceof Resource)
                {
                    res.add((Resource) c);
                }
            }
        }
        return res;
    }

    //Afficher la liste des recettes par ordre alphabétique et permettre, pour une recette spécifique, d’obtenir toutes ses informations.

    public static LinkedList<Recipe> alphabeticRecipies()
    {
        Collections.sort(allRecipies, new Recipe.RecipeComparator());

        /*for (ClassesPackage.Recipe r : allRecipies)
        {
            System.out.println(r.name);
        }*/
        return allRecipies;
    }
}
