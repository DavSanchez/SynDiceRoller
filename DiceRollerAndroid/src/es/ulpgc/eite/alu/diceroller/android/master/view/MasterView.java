package es.ulpgc.eite.alu.diceroller.android.master.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import es.ulpgc.eite.framework.android.AndroidScreenView;
import es.ulpgc.eite.alu.diceroller.android.R;
import es.ulpgc.eite.alu.diceroller.android.detail.data.DetailData;
import es.ulpgc.eite.alu.diceroller.android.master.presenter.I_MasterPresenter;

import java.util.List;

public class MasterView extends AndroidScreenView implements I_MasterView {


    private ListView _list;
    private MasterAdapter _adapter;


    private ListView getList() {
        return _list;
    }

    private void setList(ListView list) {
        _list = list;
    }

    private MasterAdapter getAdapter() {
        return _adapter;
    }

    private void setAdapter(MasterAdapter adapter) {
        _adapter = adapter;
    }


    private int getListLayout(){
        return R.layout.master_view;
    }

    private int getRowLayout(){
        return R.layout.master_row;
    }

    private int getListView(){
        return R.id.lst_master;
    }


    private I_MasterPresenter getMasterPresenter() {
        return (I_MasterPresenter) getScreenPresenter();
    }

    @Override
    public void setMasterScreen() {
        setMasterLayout();
        setMasterList();
        setMasterAdapter();
        setMasterListAdapter();
        setMasterListListener();
    }


    private void setMasterLayout(){
        debug("setMasterLayout");

        setContentView(getListLayout());
    }

    private void setMasterList(){
        debug("setMasterList");

        setList((ListView) findViewById(getListView()));
    }

    private void setMasterAdapter(){
        debug("setMasterAdapter");

        setAdapter(new MasterAdapter(this, getRowLayout()));
    }

    private void setMasterListAdapter(){
        debug("setMasterListAdapter");

        getList().setAdapter(getAdapter());
    }

    private void setMasterListListener(){
        debug("setMasterListListener");

        getList().setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(
                    AdapterView<?> parent, View view, int position, long id) {

                getMasterPresenter().setListPosition(position);
            }
        });
    }



    @Override
    public void setMasterCollection(List<DetailData> collection){
        debug("setMasterCollection", "collection", collection);

        getAdapter().clear();
        getAdapter().addAll(collection);
        getAdapter().notifyDataSetChanged();
    }

    @Override
    public void setListPosition(int position){
        debug("setListPosition", "position", position);

        getList().setSelection(position);
    }



    private class MasterAdapter extends ArrayAdapter<DetailData>{

        private int _rowLayout;
        private MasterView _listView;

        private MasterView _getListView() {
            return _listView;
        }

        private int _getRowLayout() {
            return _rowLayout;
        }

        public void _setListView(MasterView view) {
            _listView = view;
        }

        public void _setRowLayout(int layout) {
            _rowLayout = layout;
        }

        public MasterAdapter(MasterView _view, int _layout) {
            super(_view, _layout);

            _setListView(_view);
            _setRowLayout(_layout);
        }

        @Override
        public View getView(int position, View rowView, ViewGroup parent) {

            LayoutInflater inflater = (LayoutInflater)
                    _getListView().getSystemService(
                            (Context.LAYOUT_INFLATER_SERVICE));

            rowView = inflater.inflate(_getRowLayout(), parent, false);

            DetailData data = getItem(position);
            TextView titleView = (TextView) rowView.findViewById(R.id.lbl_title);
            titleView.setText(data.getLabel());

            return rowView;
        }
    }
}
