package ethered.mcc_project;

/**
 * Created by Mitul Champaneri on 4/7/2018.
 */



public class Item {

    private int id;
    private String title;

    public Item(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

}
