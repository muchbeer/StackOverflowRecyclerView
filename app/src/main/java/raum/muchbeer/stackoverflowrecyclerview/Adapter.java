package raum.muchbeer.stackoverflowrecyclerview;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.TitleAdapter> {

    private static final String LOG_TAG = Adapter.class.getSimpleName() ;
    private ArrayList<RecyclerData> myList;
    int mLastPosition = 0;

    private RemoveClickListner mListner;

    public Adapter(ArrayList<RecyclerData> myList, RemoveClickListner mListner) {
        this.myList = myList;
        this.mListner = mListner;
    }

    @NonNull
    @Override
    public TitleAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item,
                    parent,
                false);

        TitleAdapter viewHolder = new TitleAdapter(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TitleAdapter holder, int position) {

        Log.d("His problem here is:  ", myList.size() + "");
        RecyclerData titleData = myList.get(position);
        Log.d("Title is:  ", titleData.title + "");
        mLastPosition = position;
        holder.crossImage.setImageResource(R.drawable.jumanji);
        holder.etTitleTextView.setText(titleData.title);
        holder.etPositionTextView.setText("Position :" + (position +1));
        holder.etTitleTextView.requestFocus();
    }

    public void notifyData(ArrayList<RecyclerData> myList) {

        this.myList = myList;
        Log.d("notifyData ", myList.size() + "");
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {

          return(null != myList?myList.size():0);
        }

    public class TitleAdapter extends RecyclerView.ViewHolder {

        private final TextView etTitleTextView, etPositionTextView;
        private LinearLayout mainLayout;
        public ImageView crossImage;
        public TitleAdapter(@NonNull View itemView) {
            super(itemView);

            etTitleTextView = itemView.findViewById(R.id.txtTitle);
            etPositionTextView = itemView.findViewById(R.id.position);
            crossImage = (ImageView) itemView.findViewById(R.id.thumbnail);
            mainLayout = (LinearLayout) itemView.findViewById(R.id.mainLayout);

            mainLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), "Position:" + getAdapterPosition(), Toast.LENGTH_SHORT).show();
                }
            });

            crossImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListner.OnRemoveClick(getAdapterPosition());
                }
            });
        }
    }
}
