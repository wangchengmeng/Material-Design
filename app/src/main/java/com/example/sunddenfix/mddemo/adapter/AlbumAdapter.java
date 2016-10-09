package com.example.sunddenfix.mddemo.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sunddenfix.mddemo.R;
import com.example.sunddenfix.mddemo.utils.DensityUtils;

import java.util.List;

/**
 * @author wangchengmeng
 * @desc
 * @更新时间
 */
public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {

    private List<String> mDatasList;
    private Activity     mActivity;

    public AlbumAdapter(Activity activity, List<String> datasList) {
        this.mActivity = activity;
        this.mDatasList = datasList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_album, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.mTvAlbumeName.setText(getItem(position));
        DensityUtils.measure(holder.mTvAlbumeName, 0, (DensityUtils.getScreenW() / 2) * ((position % 2) + 1));

    }

    @Override
    public int getItemCount() {
        if (null != mDatasList) {
            return mDatasList.size();
        }
        return 0;
    }

    public String getItem(int postion) {
        if (null != mDatasList) {
            return mDatasList.get(postion);
        }
        return null;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView mTvAlbumeName;

        public ViewHolder(View view) {
            super(view);
            mTvAlbumeName = (TextView) view.findViewById(R.id.tv_item_album_name);

        }
    }

}
