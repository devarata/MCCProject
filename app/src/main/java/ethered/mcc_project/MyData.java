package ethered.mcc_project;

/**
 * Created by Aniket on 20-06-2017.
 * This ${class} is used for
 */

public class MyData {

int id;
    private String subname,attended,bunked,attreq;
    public int getId(){ return id; }
    public void setId(int id){this.id = id;}


    public String getattreq(){ return attreq; }
    public void setattreq(String attreq){this.attreq = attreq;}

    public String getbunked(){ return bunked; }
    public void setbunked(String bunked){this.bunked = bunked;}

    public String getattended(){ return attended; }
    public void setattended(String attended){this.attended = attended;}

    public String getName() {
        return subname;
    }
    public void setName(String name) {
        this.subname = name;
    }


}
