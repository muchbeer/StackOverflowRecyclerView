package raum.muchbeer.stackoverflowrecyclerview;

import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

public class RecyclerData {

    String title;
    Integer position;


    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }



    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public void setCrossImage(ImageView crossImage){
        setCrossImage(crossImage);
    }
}
