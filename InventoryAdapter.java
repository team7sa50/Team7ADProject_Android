package sg.edu.nus.team7adproject.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import sg.edu.nus.team7adproject.R;

public class InventoryAdapter extends BaseAdapter {
    private List<Inventory> list;
    private LayoutInflater inflater;

    public InventoryAdapter(Context context, List<Inventory> list) {
        this.list = list;
        this.inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        InventoryAdapter.IA a=null;
        if (view == null) {
            view = inflater.inflate(R.layout.inventorylist, null);
            a = new IA();
            a.iv_code=(TextView)view.findViewById(R.id.iv_code);
            a.iv_des=(TextView)view.findViewById(R.id.iv_des);
            a.iv_stock=(TextView)view.findViewById(R.id.iv_stock);
            a.iv_unit=(TextView)view.findViewById(R.id.iv_unit);
            a.iv_location=(TextView)view.findViewById(R.id.iv_location);
            a.iv_price=(TextView)view.findViewById(R.id.iv_price);
            view.setTag(a);
        }else{
            a = (InventoryAdapter.IA)view.getTag();
        }
        a.iv_code.setText(list.get(i).getItemCode());
        a.iv_des.setText(list.get(i).getDescription());
        a.iv_stock.setText(Integer.toString(list.get(i).getStock()));
        a.iv_unit.setText(list.get(i).getMeasurementUnit());
        a.iv_location.setText(list.get(i).getLocation());
        a.iv_price.setText((Double.toString(list.get(i).getPrice())));
        return view;
    }
    private static class IA {
        private TextView iv_code;
        private TextView iv_des;
        private TextView iv_stock;
        private TextView iv_unit;
        private TextView iv_location;
        private TextView iv_price;
    }
}

