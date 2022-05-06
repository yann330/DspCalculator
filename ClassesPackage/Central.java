package ClassesPackage;

public class Central extends Building
{
    protected String type;

    public Central(String id, String name, String type)
    {
        super(id, name);
        this.type = type;
    }

    @Override
    public String toString() {
        return "ClassesPackage.Central{" +
                "id=" + id +
                ", name=" + name +
                ", type='" + type + '\'' +
                '}';
    }

    public String getType()
    {
        return type;
    }
}
