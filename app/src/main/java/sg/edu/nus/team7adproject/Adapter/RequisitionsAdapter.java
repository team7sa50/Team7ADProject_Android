package sg.edu.nus.team7adproject.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import sg.edu.nus.team7adproject.R;

public class RequisitionsAdapter extends BaseAdapter {

    private List<Requisitions> list;
    private LayoutInflater inflater;

    public RequisitionsAdapter(Context context, List<Requisitions> list){
        this.list=list;
        this.inflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        VH vh=null;
        if(view==null){
            view=inflater.inflate(R.layout.listview_items_requisitions,null);
            vh=new VH();
            vh.tv_date=(TextView)view.findViewById(R.id.tv_date);
            vh.tv_status=(TextView)view.findViewById(R.id.tv_status);
            view.setTag(vh);
        }else{
            vh=(VH)view.getTag();
        }
        vh.tv_date.setText(list.get(i).getDateSubmitted());
        vh.tv_status.setText(list.get(i).getStatus());
        return view;
    }

    private static class VH{
        private TextView tv_date;
        private TextView tv_status;
    }
}
