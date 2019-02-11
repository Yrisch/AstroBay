package fr.yrisch.astrobay.ui;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import fr.yrisch.astrobay.R;

public class NGCAdaptater extends ArrayAdapter<NGC> {

    public NGCAdaptater(Context context, List<NGC> NGCs){
        super(context,0,NGCs);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_ngc,parent, false);
        }

        NgcViewHolder viewHolder = (NgcViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new NgcViewHolder();
            viewHolder.ngcID = (TextView) convertView.findViewById(R.id.NGCID);
            viewHolder.ngcCoor = (TextView) convertView.findViewById(R.id.Coordinate);
            viewHolder.Icon = (ImageView) convertView.findViewById(R.id.iconNGC);
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Tweet> tweets
        NGC ngc = getItem(position);

        //il ne reste plus qu'à remplir notre vue
        viewHolder.ngcID.setText(ngc.getNgcId());
        viewHolder.ngcCoor.setText(ngc.getNgcCoor());
        viewHolder.Icon.setImageDrawable(new ColorDrawable(ngc.getIcon()));

        return convertView;
    }

    private class NgcViewHolder{
        public TextView ngcID;
        public TextView ngcCoor;
        public ImageView Icon;
    }
}
