package main.traveldiaries.com.materialtabs;

/**
 * Created by Piyush on 2/17/2017.
 */

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Ravi Tamada on 18/05/16.
 */
public class RcdnAdapter extends RecyclerView.Adapter<RcdnAdapter.MyViewHolder> {

    private Context mContext;
    private List<Rcdn> rcdnList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView userName, title, artist, album;
        public ImageView thumbnail, overflow;

        public MyViewHolder(View view) {
            super(view);
            userName = (TextView) view.findViewById(R.id.nameThird);
            title = (TextView) view.findViewById(R.id.titleThird);
            artist = (TextView) view.findViewById(R.id.artistThird);
            album = (TextView) view.findViewById(R.id.albumThird);

            thumbnail = (ImageView) view.findViewById(R.id.thumbnailThird);
            overflow = (ImageView) view.findViewById(R.id.overflowThird);
        }
    }


    public RcdnAdapter(Context mContext, List<Rcdn> rcdnList) {
        this.mContext = mContext;
        this.rcdnList = rcdnList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rcdn_list_view, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Rcdn rcdn = rcdnList.get(position);
        holder.userName.setText(rcdn.getName());
        holder.title.setText(rcdn.getTitle());
        holder.artist.setText(rcdn.getArtist());
        holder.album.setText(rcdn.getAlbum());

        // loading album cover using Glide library
        Glide.with(mContext).load(rcdn.getThumbnail()).into(holder.thumbnail);

        holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(holder.overflow);
            }
        });
    }

    /**
     * Showing popup menu when tapping on 3 dots
     */
    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_album, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }

    /**
     * Click listener for popup menu items
     */
    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_add_favourite:
                    Toast.makeText(mContext, "Add to favourite", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_play_next:
                    Toast.makeText(mContext, "Play next", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }

    @Override
    public int getItemCount() {
        return rcdnList.size();
    }
}