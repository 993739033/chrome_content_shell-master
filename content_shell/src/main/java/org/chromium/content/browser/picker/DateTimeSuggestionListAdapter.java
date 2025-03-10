package org.chromium.content.browser.picker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.chromium_content_view.R;
import java.util.List;

class DateTimeSuggestionListAdapter extends ArrayAdapter<DateTimeSuggestion> {
  private final Context mContext;

  public DateTimeSuggestionListAdapter(Context context, List<DateTimeSuggestion> objects) {
    super(context, R.layout.date_time_suggestion, objects);
    this.mContext = context;
  }

  @Override // android.widget.ArrayAdapter, android.widget.Adapter
  public View getView(int position, View convertView, ViewGroup parent) {
    View layout = convertView;
    if (convertView == null) {
      LayoutInflater inflater = LayoutInflater.from(this.mContext);
      layout = inflater.inflate(R.layout.date_time_suggestion, parent, false);
    }
    TextView labelView = (TextView) layout.findViewById(R.id.date_time_suggestion_value);
    TextView sublabelView = (TextView) layout.findViewById(R.id.date_time_suggestion_label);
    if (position == getCount() - 1) {
      labelView.setText(this.mContext.getText(R.string.date_picker_dialog_other_button_label));
      sublabelView.setText("");
    } else {
      labelView.setText(getItem(position).localizedValue());
      sublabelView.setText(getItem(position).label());
    }
    return layout;
  }

  @Override // android.widget.ArrayAdapter, android.widget.Adapter
  public int getCount() {
    return super.getCount() + 1;
  }
}
