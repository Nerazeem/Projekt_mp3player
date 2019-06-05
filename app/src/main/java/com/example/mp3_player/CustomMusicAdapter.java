package com.example.mp3_player;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomMusicAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<Muzyka> arrayList;
    private MediaPlayer musicPlayer;
    private Boolean flag = true;

    public CustomMusicAdapter(Context context, int layout, ArrayList<Muzyka> arrayList) {
        this.context = context;
        this.layout = layout;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder {
        TextView txtTytul, txtAutor;
        ImageView iconPlay, iconStop;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if(convertView == null)
        {
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = layoutInflater.inflate(layout, null);

            viewHolder.txtTytul = (TextView) convertView.findViewById(R.id.txtTytul);
            viewHolder.txtAutor = (TextView) convertView.findViewById(R.id.txtAutor);

            viewHolder.iconPlay = (ImageView) convertView.findViewById(R.id.iconPlay);
            viewHolder.iconStop = (ImageView) convertView.findViewById(R.id.iconStop);

            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final Muzyka music = arrayList.get(position);

        viewHolder.txtTytul.setText(music.getTytul());
        viewHolder.txtAutor.setText(music.getAutor());

        viewHolder.iconPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag)
                {
                    musicPlayer = MediaPlayer.create(context, music.getUtwor());
                    flag=false;
                }
                if(musicPlayer.isPlaying())
                {
                    musicPlayer.pause();
                    viewHolder.iconPlay.setImageResource(R.drawable.icon_play);
                }
                else{
                    musicPlayer.start();
                    viewHolder.iconPlay.setImageResource(R.drawable.icon_pause);
                }

            }
        });

        viewHolder.iconStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!flag)
                {
                    musicPlayer.stop();
                    musicPlayer.release();
                    flag=true;
                }
                viewHolder.iconPlay.setImageResource(R.drawable.icon_play);
            }
        });

        return convertView;
    }
}
