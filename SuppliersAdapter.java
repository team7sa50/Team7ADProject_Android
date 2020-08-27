package sg.edu.nus.team7adproject.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import sg.edu.nus.team7adproject.R;

public class SuppliersAdapter extends BaseAdapter {
    private List<Suppliers> list;
    private LayoutInflater inflater;

    public SuppliersAdapter(Context context, List<Suppliers> list) {
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
        VL vl=null;
        if (view == null) {
            view = inflater.inflate(R.layout.listview_supplier, null);
            vl = new VL();
            vl.sup_id=(TextView)view.findViewById(R.id.sup_id);
            vl.sup_code=(TextView)view.findViewById(R.id.sup_code);
            vl.sup_name=(TextView)view.findViewById(R.id.sup_name);
            vl.sup_address=(TextView)view.findViewById(R.id.sup_address);
            vl.sup_contactno=(TextView)view.findViewById(R.id.sup_contactno);
            vl.sup_faxno=(TextView)view.findViewById(R.id.sup_faxno);
            view.setTag(vl);
        }else{
            vl = (VL)view.getTag();
        }
        vl.sup_id.setText(list.get(i).getId());
        vl.sup_code.setText(list.get(i).getSupplierCode());
        vl.sup_name.setText(list.get(i).getSupplierName());
        vl.sup_address.setText(list.get(i).getSupplierAddress());
        vl.sup_contactno.setText(Integer.toString(list.get(i).getContactNo()));
       vl.sup_faxno.setText(Integer.toString(list.get(i).getFaxNo()));
        return view;
    }
    private static class VL {
        private TextView sup_id;
        private TextView sup_code;
        private TextView sup_name;
        private TextView sup_address;
        private TextView sup_contactno;
        private TextView sup_faxno;
    }
}
