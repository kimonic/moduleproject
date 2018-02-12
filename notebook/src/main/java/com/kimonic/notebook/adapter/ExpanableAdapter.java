package com.kimonic.notebook.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.kimonic.notebook.R;
import com.kimonic.notebook.bean.ExpanableListbean;
import com.kimonic.utilsmodule.utils.HeightUtils;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import java.util.List;

/**
 * z折叠listview适配器
 */

public class ExpanableAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<ExpanableListbean> groupList;

    public ExpanableAdapter(Context context, List<ExpanableListbean>  groupList) {
        this.context = context;
        this.groupList = groupList;
    }

    /**
     * 获取组的个数
     */
    @Override
    public int getGroupCount() {
        return groupList.size();
    }

    /**
     * 获取指定组中的子元素个数
     */
    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    /**
     * 获取指定组中的数据
     */
    @Override
    public Object getGroup(int groupPosition) {
        return groupList.get(groupPosition);
    }

    /**
     * 获取指定组中的指定子元素数据。
     */
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return groupList.get(groupPosition);
    }

    /**
     * 获取指定组的ID，这个组ID必须是唯一的
     */
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    /**
     * 获取指定组中的指定子元素ID
     */
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    /**
     * 组和子元素是否持有稳定的ID,也就是底层数据的改变不会影响到它们。
     */
    @Override
    public boolean hasStableIds() {
        return true;
    }

    /**
     * 获取显示指定组的视图对象
     *
     * @param groupPosition 组位置
     * @param isExpanded    该组是展开状态还是伸缩状态
     * @param convertView   重用已有的视图对象
     * @param parent        返回的视图对象始终依附于的视图组
     * @return   ""
     * @see android.widget.ExpandableListAdapter#getGroupView(int, boolean, View,
     * ViewGroup)
     */

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupHolder groupHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.lvitem_expanable_group, parent, false);
            groupHolder = new GroupHolder();
            groupHolder.txt = (TextView) convertView.findViewById(R.id.tv_expanable_group);
            convertView.setTag(groupHolder);
        } else {
            groupHolder = (GroupHolder) convertView.getTag();
        }

        groupHolder.txt.setText(groupList.get(groupPosition).getTitle());
        groupHolder.txt.setCompoundDrawables(context.getResources().getDrawable(R.drawable.xvector_yousanjiao), null, null, null);
        return convertView;
    }

    /**
     * 是否选中指定位置上的子元素。
     *
     * @param groupPosition  ""
     * @param childPosition  " "
     * @return  ""
     * @see android.widget.ExpandableListAdapter#isChildSelectable(int, int)
     */
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ItemHolder itemHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.lvitem_expanable_child, parent, false);
            itemHolder = new ItemHolder();
            itemHolder.lv = (ListView) convertView.findViewById(R.id.lv_expanable_child);
            convertView.setTag(itemHolder);
        } else {
            itemHolder = (ItemHolder) convertView.getTag();
        }
        itemHolder.lv.setAdapter(getAdapter(groupList.get(groupPosition).getChild()));
        HeightUtils.setListviewHeight(itemHolder.lv);
        return convertView;
    }

    /**
     * 是否选中指定位置上的子元素。
     *
     * @param groupPosition  ""
     * @param childPosition  ""
     * @return ""
     * @see android.widget.ExpandableListAdapter#isChildSelectable(int, int)
     */
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    class GroupHolder {
        TextView txt;

    }

    class ItemHolder {

        public ListView lv;
    }

    private CommonAdapter<String> getAdapter(List<String> list) {
        return new CommonAdapter<String>(context, R.layout.lvitem_expanable_child_list, list) {
            @Override
            protected void convert(ViewHolder viewHolder, String item, int position) {
                TextView textView=viewHolder.getView(R.id.tv_expanable_child_list);
                textView.setText(item);
                switch (position % 5) {
                    case 0:
                        textView.setCompoundDrawables(context.getResources().getDrawable(R.drawable.xshape_bluecircle), null, null, null);
                        break;
                    case 1:
                        textView.setCompoundDrawables(context.getResources().getDrawable(R.drawable.xshape_cyancircle), null, null, null);
                        break;
                    case 2:
                        textView.setCompoundDrawables(context.getResources().getDrawable(R.drawable.xshape_redcircle), null, null, null);
                        break;
                    case 3:
                        textView.setCompoundDrawables(context.getResources().getDrawable(R.drawable.xshape_violetcircle), null, null, null);
                        break;
                    case 4:
                        textView.setCompoundDrawables(context.getResources().getDrawable(R.drawable.xshape_yellowcircle), null, null, null);
                        break;
                }
            }
        };
    }
}
