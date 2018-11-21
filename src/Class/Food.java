package Class;

/**
 * Class for the Food
 * Date: 10/11/2018.
 * @author Gustavo Méndez and Daniela Alvarado.
 */
public abstract class Food {

    private int code;

    private String name;

    private String description;

    private int price;

    private String presentation;

    private String image;
    
    private DiscontTimer timer;

    /**
     * Constructor of food
     * @param code
     * @param name
     * @param description
     * @param price
     * @param presentation
     * @param image 
     */
    public Food(int code, String name, String description, int price, String presentation, String image) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.price = price;
        this.presentation = presentation;
        this.image = image;
        this.timer=null;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public String getPresentation() {
        return presentation;
    }

    public String getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    public void setImage(String image) {
        this.image = image;
    }
    /**
     * Method to initizalize the timer of a discont
     * @param time 
     */
    public void setTimer(String time){
        this.timer=  new DiscontTimer("00:00", time);
        timer.execute();
    }
    public abstract String getType();
    
    
}
