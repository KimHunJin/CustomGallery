package dxmnd.com.customgallery.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import dxmnd.com.customgallery.R;
import dxmnd.com.customgallery.holders.BaseViewHolder;
import dxmnd.com.customgallery.holders.MainGalleryRecyclerViewHolder;
import dxmnd.com.customgallery.items.ItemMainGalleryGrid;

/**
 * Created by HunJin on 2017-05-19.
 */

public class MainGalleryRecyclerViewAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private View mView;
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private List<ItemMainGalleryGrid> items;


    public MainGalleryRecyclerViewAdapter(Context context) {
        super();
        this.mContext = context;
        items = new ArrayList<>();
    }

    public List<ItemMainGalleryGrid> getItems() {
        return items;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mLayoutInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = mLayoutInflater.inflate(R.layout.item_rcv_gallery_form, parent, false);
        return new MainGalleryRecyclerViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.setDataOnView(position, items);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addData(ItemMainGalleryGrid item) {
        items.add(item);
        notifyDataSetChanged();
    }

    public void clear() {
        items.clear();
        notifyDataSetChanged();
    }
}
