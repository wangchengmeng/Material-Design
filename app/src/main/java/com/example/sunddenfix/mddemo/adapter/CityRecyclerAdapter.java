package com.example.sunddenfix.mddemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sunddenfix.mddemo.R;
import com.example.sunddenfix.mddemo.decoretion.CityModel;

import java.util.List;

/**
 * @author wangchengmeng
 * @desc
 * @更新时间
 */
public class CityRecyclerAdapter extends RecyclerView.Adapter<CityRecyclerAdapter.ViewHolder> {

    private List<CityModel> mCityModelList;

    public CityRecyclerAdapter(List<CityModel> cityModelList) {
        mCityModelList = cityModelList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_album, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CityModel item = getItem(position);
        holder.mTvAlbumeName.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        if (null != mCityModelList) {
            return mCityModelList.size();
        }
        return 0;
    }

    public CityModel getItem(int position) {
        if (null != mCityModelList) {
            return mCityModelList.get(position);
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
