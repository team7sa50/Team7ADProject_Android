package sg.edu.nus.team7adproject.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import sg.edu.nus.team7adproject.R;

public class DepartmentAdapter extends BaseAdapter {
    private List<Departments> list;
    private LayoutInflater inflater;

    public DepartmentAdapter(Context context, List<Departments> list) {
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
        DL dl=null;
        if (view == null) {
            view = inflater.inflate(R.layout.departmentlist, null);
            dl = new DepartmentAdapter.DL();
            dl.dep_id=(TextView)view.findViewById(R.id.dep_id);
            dl.dep_code=(TextView)view.findViewById(R.id.dep_code);
            dl.dep_name=(TextView)view.findViewById(R.id.dep_name);
            dl.dep_contact=(TextView)view.findViewById(R.id.dep_contact);
            dl.dep_contactno=(TextView)view.findViewById(R.id.dep_contactno);
            dl.dep_faxno=(TextView)view.findViewById(R.id.dep_faxno);
            dl.dep_head=(TextView)view.findViewById(R.id.dep_head);
            dl.dep_repname=(TextView)view.findViewById(R.id.dep_repname);
            dl.dep_cp=(TextView)view.findViewById(R.id.dep_cp);
            view.setTag(dl);
        }else{
            dl= (DepartmentAdapter.DL)view.getTag();
        }
        dl.dep_id.setText(list.get(i).getId());
        dl.dep_code.setText(list.get(i).getDeptCode());
        dl.dep_name.setText(list.get(i).getDepartmentName());
        dl.dep_contact.setText(list.get(i).getContactName());
        dl.dep_contactno.setText(Integer.toString(list.get(i).getTelephone()));
        dl.dep_faxno.setText(Integer.toString(list.get(i).getFaxNo()));
        dl.dep_head.setText(list.get(i).getHeadName());
        dl.dep_repname.setText(list.get(i).getRepName());
        dl.dep_cp.setText(list.get(i).getCollectionPoint());
        return view;
    }
    private static class DL {
        private TextView dep_id;
        private TextView dep_code;
        private TextView dep_name;
        private TextView dep_contact;
        private TextView dep_contactno;
        private TextView dep_faxno;
        private TextView dep_head;
        private TextView dep_repname;
        private TextView dep_cp;
    }
}
