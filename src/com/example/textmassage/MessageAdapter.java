package com.example.textmassage;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MessageAdapter extends ArrayAdapter<Msg> {
	private int resourceId;

	public MessageAdapter(Context context, int textViewResourceId, List<Msg> objects) {
		super(context, textViewResourceId, objects);
		// TODO Auto-generated constructor stub
		resourceId = textViewResourceId;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup group) {
		Msg msg = getItem(position);
		View view;
		ViewHolder viewholder;
		if (convertView == null) {
			view = LayoutInflater.from(getContext()).inflate(resourceId, null);
			viewholder = new ViewHolder();
			viewholder.left = (LinearLayout) view.findViewById(R.id.layout_left);
			viewholder.right = (LinearLayout) view.findViewById(R.id.layout_right);
			viewholder.leftTx = (TextView) view.findViewById(R.id.leftText);
			viewholder.rightTx = (TextView) view.findViewById(R.id.rightText);
			view.setTag(viewholder);

		} else {
			view = convertView;
			viewholder = (ViewHolder) view.getTag();

		}
		if (msg.getType() == Msg.MESSAGE_RECEIVE) {
			viewholder.left.setVisibility(View.VISIBLE);
			viewholder.right.setVisibility(View.GONE);
			viewholder.leftTx.setText(msg.getMessage());
		} else if (msg.getType() == Msg.MESSAGE_SEND){
			viewholder.right.setVisibility(View.VISIBLE);
			viewholder.left.setVisibility(View.GONE);
			viewholder.rightTx.setText(msg.getMessage());

		}
		return view;

	}

	class ViewHolder {
		LinearLayout left;
		LinearLayout right;
		TextView leftTx;
		TextView rightTx;

	}
}
