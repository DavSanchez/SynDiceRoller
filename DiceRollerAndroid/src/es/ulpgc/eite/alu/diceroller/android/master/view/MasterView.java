package es.ulpgc.eite.alu.diceroller.android.master.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import es.ulpgc.eite.alu.diceroller.android.R;
import es.ulpgc.eite.alu.diceroller.android.data.DetailData;
import es.ulpgc.eite.alu.diceroller.android.master.presenter.I_MasterPresenter;
import es.ulpgc.eite.framework.android.AndroidScreenView;

import java.util.List;

/**
 * Created by David on 2/6/16.
 */
public class MasterView extends AndroidScreenView implements I_MasterView {

    private ListView _list;
    private MasterAdapter _adapter;
    private int _position;

    @Override
    public int getListPosition(){
        return getPosition();
    }

    private int getPosition() {
        return _position;
    }

    private void setPosition(int position) {
        _position = position;
    }

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

    private I_MasterPresenter getMasterPresenter(){
        return (I_MasterPresenter) getScreenPresenter();
    }

    @Override
    public void setMasterLayout(){
        setContentView(getListLayout());
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

    @Override
    public void setMasterCollection(List<DetailData> collection){
        getAdapter().clear();
        getAdapter().addAll(collection);
        getAdapter().notifyDataSetChanged();
    }

    @Override
    public void setListPosition(int position){
        setPosition(position);
        getList().setSelection(position);
    }

//    @Override
//    public void setListPosition(){
//        getList().setSelection(getPosition());
//    }

    @Override
    public void setMasterList(){
        setList((ListView) findViewById(getListView()));
    }

    @Override
    public void setMasterAdapter(){
        setAdapter(new MasterAdapter(this, getRowLayout()));
    }

    @Override
    public void setMasterListAdapter(){
        getList().setAdapter(getAdapter());
    }

    @Override
    public void setMasterListListener(){
        getList().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //setPosition(position);
                itemListClicked(position);
            }
        });
    }

    private void itemListClicked(int position) {
        setPosition(position);
        getMasterPresenter().itemListClicked();
    }

    private class MasterAdapter extends ArrayAdapter<DetailData> {

        private int _rowLayout;
        private MasterView _listView;

        private int _getRowLayout() {
            return _rowLayout;
        }

        private MasterView _getListView() {
            return _listView;
        }

        public void _setRowLayout(int layout) {
            _rowLayout = layout;
        }

        public void _setListView(MasterView view) {
            _listView = view;
        }

        public MasterAdapter(MasterView _view, int _layout) {
            super(_view, _layout);

            _setListView(_view);
            _setRowLayout(_layout);
        }

        @Override
        public View getView(int position, View rowView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) _getListView().getSystemService((Context.LAYOUT_INFLATER_SERVICE));

            rowView = inflater.inflate(_getRowLayout(), parent, false);

            DetailData data = getItem(position);
            TextView titleView = (TextView) rowView.findViewById(R.id.lbl_title);
            titleView.setText(data.toString());

            return rowView;
        }
    }
}
