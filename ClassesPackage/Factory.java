package ClassesPackage;

public class Factory extends Building
{
    protected String type;
    protected double speed;
    protected int usage;
    protected double drain;


    public Factory(String id, String name, String type, Double speed, int usage, double drain)
    {
        super(id, name);
        this.type = type;
        this.speed = speed;
        this.usage = usage;
        this.drain = drain;

        try
        {
            usageException();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void usageException() throws Exception
    {
        if (drain > usage)
        {
            throw new Exception("Drain is greater than usage");
        }
    }

    @Override
    public String toString() {
        return "ClassesPackage.Factory{" +
                "id=" + id +
//                ", name=" + name +
//                ", building_products=" + building_products +
//                ", building_resources=" + building_resources +
                ", type='" + type + '\'' +
                ", speed=" + speed +
                ", usage=" + usage +
                ", drain=" + drain +
                '}';
    }

    public double getSpeed()
    {
        return speed;
    }

    public double getDrain()
    {
        return drain;
    }

    public String getType()
    {
        return type;
    }

    public int getUsage()
    {
        return usage;
    }
}
