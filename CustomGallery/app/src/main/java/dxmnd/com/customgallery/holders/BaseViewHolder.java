package dxmnd.com.customgallery.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import dxmnd.com.customgallery.items.ItemMainGalleryGrid;

/**
 * Created by HunJin on 2017-05-19.
 */

public abstract class BaseViewHolder extends RecyclerView.ViewHolder {
    public BaseViewHolder(View view) {
        super(view);
    }

    public abstract void setDataOnView(int position, List<ItemMainGalleryGrid> items);
}
